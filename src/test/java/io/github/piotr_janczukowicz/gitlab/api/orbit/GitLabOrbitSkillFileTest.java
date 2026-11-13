package io.github.piotr_janczukowicz.gitlab.api.orbit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabOrbitSkillFileTest {

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabOrbitSkillFileBuilder builder = GitLabOrbitSkillFileBuilder.builder(
                        OrbitCatalogFixtures.orbitSkillFile())
                .path(null);

        final GitLabOrbitSkillFile built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSha256IsNullable() {
        final GitLabOrbitSkillFileBuilder builder = GitLabOrbitSkillFileBuilder.builder(
                        OrbitCatalogFixtures.orbitSkillFile())
                .sha256(null);

        final GitLabOrbitSkillFile built = builder.build();

        assertThat(built.sha256()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContentIsNullable() {
        final GitLabOrbitSkillFileBuilder builder = GitLabOrbitSkillFileBuilder.builder(
                        OrbitCatalogFixtures.orbitSkillFile())
                .content(null);

        final GitLabOrbitSkillFile built = builder.build();

        assertThat(built.content()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabOrbitSkillFile value = OrbitCatalogFixtures.orbitSkillFile();

        assertSoftly(softly -> {
            softly.assertThat(value.path()).isEqualTo("SKILL.md");
            softly.assertThat(value.sha256()).isEqualTo("abc123");
            softly.assertThat(value.content()).isEqualTo("# Orbit skill");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabOrbitSkillFile original = OrbitCatalogFixtures.orbitSkillFile();

        final GitLabOrbitSkillFile rebuilt =
                GitLabOrbitSkillFileBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabOrbitSkillFile.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("path", "sha256", "content");
    }
}
