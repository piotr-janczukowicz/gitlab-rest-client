package io.github.piotr_janczukowicz.gitlab.api.orbit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabOrbitSkillTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabOrbitSkillBuilder builder = GitLabOrbitSkillBuilder.builder(OrbitCatalogFixtures.orbitSkill())
                .name(null);

        final GitLabOrbitSkill built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionIsNullable() {
        final GitLabOrbitSkillBuilder builder = GitLabOrbitSkillBuilder.builder(OrbitCatalogFixtures.orbitSkill())
                .version(null);

        final GitLabOrbitSkill built = builder.build();

        assertThat(built.version()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCompatibilityIsNullable() {
        final GitLabOrbitSkillBuilder builder = GitLabOrbitSkillBuilder.builder(OrbitCatalogFixtures.orbitSkill())
                .compatibility(null);

        final GitLabOrbitSkill built = builder.build();

        assertThat(built.compatibility()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServerVersionIsNullable() {
        final GitLabOrbitSkillBuilder builder = GitLabOrbitSkillBuilder.builder(OrbitCatalogFixtures.orbitSkill())
                .serverVersion(null);

        final GitLabOrbitSkill built = builder.build();

        assertThat(built.serverVersion()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFilesIsNullable() {
        final GitLabOrbitSkillBuilder builder = GitLabOrbitSkillBuilder.builder(OrbitCatalogFixtures.orbitSkill())
                .files(null);

        final GitLabOrbitSkill built = builder.build();

        assertThat(built.files()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabOrbitSkill value = OrbitCatalogFixtures.orbitSkill();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("orbit");
            softly.assertThat(value.version()).isEqualTo("0.29.0");
            softly.assertThat(value.compatibility()).isEqualTo("Orbit CLI");
            softly.assertThat(value.serverVersion()).isEqualTo("0.31.0");
            softly.assertThat(value.files()).isEqualTo(List.of(OrbitCatalogFixtures.orbitSkillFile()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabOrbitSkill original = OrbitCatalogFixtures.orbitSkill();

        final GitLabOrbitSkill rebuilt =
                GitLabOrbitSkillBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabOrbitSkill.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "version", "compatibility", "serverVersion", "files");
    }
}
