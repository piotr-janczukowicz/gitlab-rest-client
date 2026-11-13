package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabIdentityDetailTest {

    @Test
    void constructor_shouldAcceptNull_whenExternUidIsNullable() {
        final GitLabIdentityDetailBuilder builder = GitLabIdentityDetailBuilder.builder(
                        CommonCatalogFixtures.identityDetail())
                .externUid(null);

        final GitLabIdentityDetail built = builder.build();

        assertThat(built.externUid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabIdentityDetailBuilder builder = GitLabIdentityDetailBuilder.builder(
                        CommonCatalogFixtures.identityDetail())
                .userId(null);

        final GitLabIdentityDetail built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabIdentityDetailBuilder builder = GitLabIdentityDetailBuilder.builder(
                        CommonCatalogFixtures.identityDetail())
                .active(null);

        final GitLabIdentityDetail built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabIdentityDetail value = CommonCatalogFixtures.identityDetail();

        assertSoftly(softly -> {
            softly.assertThat(value.externUid()).isEqualTo("extern_uid");
            softly.assertThat(value.userId()).isEqualTo(1L);
            softly.assertThat(value.active()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabIdentityDetail original = CommonCatalogFixtures.identityDetail();

        final GitLabIdentityDetail rebuilt =
                GitLabIdentityDetailBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabIdentityDetail.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("externUid", "userId", "active");
    }
}
