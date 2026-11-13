package io.github.piotr_janczukowicz.gitlab.api.featureflags;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabFeatureFlagTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabFeatureFlagBuilder builder = GitLabFeatureFlagBuilder.builder(
                        FeatureflagsCatalogFixtures.featureFlag())
                .name(null);

        final GitLabFeatureFlag built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabFeatureFlagBuilder builder = GitLabFeatureFlagBuilder.builder(
                        FeatureflagsCatalogFixtures.featureFlag())
                .description(null);

        final GitLabFeatureFlag built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabFeatureFlagBuilder builder = GitLabFeatureFlagBuilder.builder(
                        FeatureflagsCatalogFixtures.featureFlag())
                .active(null);

        final GitLabFeatureFlag built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionIsNullable() {
        final GitLabFeatureFlagBuilder builder = GitLabFeatureFlagBuilder.builder(
                        FeatureflagsCatalogFixtures.featureFlag())
                .version(null);

        final GitLabFeatureFlag built = builder.build();

        assertThat(built.version()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabFeatureFlagBuilder builder = GitLabFeatureFlagBuilder.builder(
                        FeatureflagsCatalogFixtures.featureFlag())
                .createdAt(null);

        final GitLabFeatureFlag built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabFeatureFlagBuilder builder = GitLabFeatureFlagBuilder.builder(
                        FeatureflagsCatalogFixtures.featureFlag())
                .updatedAt(null);

        final GitLabFeatureFlag built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStrategiesIsNullable() {
        final GitLabFeatureFlagBuilder builder = GitLabFeatureFlagBuilder.builder(
                        FeatureflagsCatalogFixtures.featureFlag())
                .strategies(null);

        final GitLabFeatureFlag built = builder.build();

        assertThat(built.strategies()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabFeatureFlag value = FeatureflagsCatalogFixtures.featureFlag();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("merge_train");
            softly.assertThat(value.description()).isEqualTo("merge train feature flag");
            softly.assertThat(value.active()).isEqualTo(true);
            softly.assertThat(value.version()).isEqualTo("new_version_flag");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.strategies()).isEqualTo(List.of(FeatureflagsCatalogFixtures.featureFlagStrategy()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabFeatureFlag original = FeatureflagsCatalogFixtures.featureFlag();

        final GitLabFeatureFlag rebuilt =
                GitLabFeatureFlagBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabFeatureFlag.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("name", "description", "active", "version", "createdAt", "updatedAt", "strategies");
    }
}
