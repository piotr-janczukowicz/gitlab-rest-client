package io.github.piotr_janczukowicz.gitlab.api.featureflags;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabFeatureFlagSettingsTest {

    @Test
    void constructor_shouldAcceptNull_whenMinimumRoleIsNullable() {
        final GitLabFeatureFlagSettingsBuilder builder = GitLabFeatureFlagSettingsBuilder.builder(
                        FeatureflagsCatalogFixtures.featureFlagSettings())
                .minimumRole(null);

        final GitLabFeatureFlagSettings built = builder.build();

        assertThat(built.minimumRole()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabFeatureFlagSettings value = FeatureflagsCatalogFixtures.featureFlagSettings();

        assertThat(value.minimumRole()).isEqualTo("developer");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabFeatureFlagSettings original = FeatureflagsCatalogFixtures.featureFlagSettings();

        final GitLabFeatureFlagSettings rebuilt =
                GitLabFeatureFlagSettingsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabFeatureFlagSettings.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("minimumRole");
    }
}
