package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabScimIdentityTest {

    @Test
    void constructor_shouldAcceptNull_whenExternUidIsNullable() {
        final GitLabScimIdentityBuilder builder = GitLabScimIdentityBuilder.builder(
                        CommonCatalogFixtures.scimIdentity())
                .externUid(null);

        final GitLabScimIdentity built = builder.build();

        assertThat(built.externUid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdIsNullable() {
        final GitLabScimIdentityBuilder builder = GitLabScimIdentityBuilder.builder(
                        CommonCatalogFixtures.scimIdentity())
                .groupId(null);

        final GitLabScimIdentity built = builder.build();

        assertThat(built.groupId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabScimIdentityBuilder builder = GitLabScimIdentityBuilder.builder(
                        CommonCatalogFixtures.scimIdentity())
                .active(null);

        final GitLabScimIdentity built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabScimIdentity value = CommonCatalogFixtures.scimIdentity();

        assertSoftly(softly -> {
            softly.assertThat(value.externUid()).isEqualTo("extern_uid");
            softly.assertThat(value.groupId()).isEqualTo(1L);
            softly.assertThat(value.active()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabScimIdentity original = CommonCatalogFixtures.scimIdentity();

        final GitLabScimIdentity rebuilt =
                GitLabScimIdentityBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabScimIdentity.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("externUid", "groupId", "active");
    }
}
