package io.github.piotr_janczukowicz.gitlab.api.orbit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabOrbitSkillSummaryTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabOrbitSkillSummaryBuilder builder = GitLabOrbitSkillSummaryBuilder.builder(
                        OrbitCatalogFixtures.orbitSkillSummary())
                .name(null);

        final GitLabOrbitSkillSummary built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionIsNullable() {
        final GitLabOrbitSkillSummaryBuilder builder = GitLabOrbitSkillSummaryBuilder.builder(
                        OrbitCatalogFixtures.orbitSkillSummary())
                .version(null);

        final GitLabOrbitSkillSummary built = builder.build();

        assertThat(built.version()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCompatibilityIsNullable() {
        final GitLabOrbitSkillSummaryBuilder builder = GitLabOrbitSkillSummaryBuilder.builder(
                        OrbitCatalogFixtures.orbitSkillSummary())
                .compatibility(null);

        final GitLabOrbitSkillSummary built = builder.build();

        assertThat(built.compatibility()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabOrbitSkillSummaryBuilder builder = GitLabOrbitSkillSummaryBuilder.builder(
                        OrbitCatalogFixtures.orbitSkillSummary())
                .description(null);

        final GitLabOrbitSkillSummary built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabOrbitSkillSummary value = OrbitCatalogFixtures.orbitSkillSummary();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("orbit");
            softly.assertThat(value.version()).isEqualTo("0.29.0");
            softly.assertThat(value.compatibility()).isEqualTo("Orbit CLI");
            softly.assertThat(value.description()).isEqualTo("Use the glab orbit CLI.");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabOrbitSkillSummary original = OrbitCatalogFixtures.orbitSkillSummary();

        final GitLabOrbitSkillSummary rebuilt =
                GitLabOrbitSkillSummaryBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabOrbitSkillSummary.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "version", "compatibility", "description");
    }
}
