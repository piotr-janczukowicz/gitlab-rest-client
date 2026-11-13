package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabRelationImportTrackerTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabRelationImportTrackerBuilder builder = GitLabRelationImportTrackerBuilder.builder(
                        ProjectsCatalogFixtures.relationImportTracker())
                .id(null);

        final GitLabRelationImportTracker built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectPathIsNullable() {
        final GitLabRelationImportTrackerBuilder builder = GitLabRelationImportTrackerBuilder.builder(
                        ProjectsCatalogFixtures.relationImportTracker())
                .projectPath(null);

        final GitLabRelationImportTracker built = builder.build();

        assertThat(built.projectPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRelationIsNullable() {
        final GitLabRelationImportTrackerBuilder builder = GitLabRelationImportTrackerBuilder.builder(
                        ProjectsCatalogFixtures.relationImportTracker())
                .relation(null);

        final GitLabRelationImportTracker built = builder.build();

        assertThat(built.relation()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabRelationImportTrackerBuilder builder = GitLabRelationImportTrackerBuilder.builder(
                        ProjectsCatalogFixtures.relationImportTracker())
                .status(null);

        final GitLabRelationImportTracker built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabRelationImportTrackerBuilder builder = GitLabRelationImportTrackerBuilder.builder(
                        ProjectsCatalogFixtures.relationImportTracker())
                .createdAt(null);

        final GitLabRelationImportTracker built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabRelationImportTrackerBuilder builder = GitLabRelationImportTrackerBuilder.builder(
                        ProjectsCatalogFixtures.relationImportTracker())
                .updatedAt(null);

        final GitLabRelationImportTracker built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabRelationImportTracker value = ProjectsCatalogFixtures.relationImportTracker();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.projectPath()).isEqualTo("namespace1/project1");
            softly.assertThat(value.relation()).isEqualTo("issues");
            softly.assertThat(value.status()).isEqualTo("pending");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabRelationImportTracker original = ProjectsCatalogFixtures.relationImportTracker();

        final GitLabRelationImportTracker rebuilt =
                GitLabRelationImportTrackerBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabRelationImportTracker.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "projectPath", "relation", "status", "createdAt", "updatedAt");
    }
}
