package io.github.piotr_janczukowicz.gitlab.api.orbit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabOrbitSkillCollectionTest {

    @Test
    void constructor_shouldAcceptNull_whenSkillsIsNullable() {
        final GitLabOrbitSkillCollectionBuilder builder = GitLabOrbitSkillCollectionBuilder.builder(
                        OrbitCatalogFixtures.orbitSkillCollection())
                .skills(null);

        final GitLabOrbitSkillCollection built = builder.build();

        assertThat(built.skills()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServerVersionIsNullable() {
        final GitLabOrbitSkillCollectionBuilder builder = GitLabOrbitSkillCollectionBuilder.builder(
                        OrbitCatalogFixtures.orbitSkillCollection())
                .serverVersion(null);

        final GitLabOrbitSkillCollection built = builder.build();

        assertThat(built.serverVersion()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabOrbitSkillCollection value = OrbitCatalogFixtures.orbitSkillCollection();

        assertSoftly(softly -> {
            softly.assertThat(value.skills()).isEqualTo(List.of(OrbitCatalogFixtures.orbitSkillSummary()));
            softly.assertThat(value.serverVersion()).isEqualTo("0.31.0");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabOrbitSkillCollection original = OrbitCatalogFixtures.orbitSkillCollection();

        final GitLabOrbitSkillCollection rebuilt =
                GitLabOrbitSkillCollectionBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabOrbitSkillCollection.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("skills", "serverVersion");
    }
}
