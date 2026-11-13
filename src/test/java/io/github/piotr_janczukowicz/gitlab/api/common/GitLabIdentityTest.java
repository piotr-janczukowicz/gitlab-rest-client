package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabIdentityTest {

    @Test
    void constructor_shouldAcceptNull_whenProviderIsNullable() {
        final GitLabIdentityBuilder builder =
                GitLabIdentityBuilder.builder(CommonCatalogFixtures.identity()).provider(null);

        final GitLabIdentity built = builder.build();

        assertThat(built.provider()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternUidIsNullable() {
        final GitLabIdentityBuilder builder =
                GitLabIdentityBuilder.builder(CommonCatalogFixtures.identity()).externUid(null);

        final GitLabIdentity built = builder.build();

        assertThat(built.externUid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSamlProviderIdIsNullable() {
        final GitLabIdentityBuilder builder =
                GitLabIdentityBuilder.builder(CommonCatalogFixtures.identity()).samlProviderId(null);

        final GitLabIdentity built = builder.build();

        assertThat(built.samlProviderId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabIdentity value = CommonCatalogFixtures.identity();

        assertSoftly(softly -> {
            softly.assertThat(value.provider()).isEqualTo("provider");
            softly.assertThat(value.externUid()).isEqualTo("extern_uid");
            softly.assertThat(value.samlProviderId()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabIdentity original = CommonCatalogFixtures.identity();

        final GitLabIdentity rebuilt = GitLabIdentityBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabIdentity.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("provider", "externUid", "samlProviderId");
    }
}
