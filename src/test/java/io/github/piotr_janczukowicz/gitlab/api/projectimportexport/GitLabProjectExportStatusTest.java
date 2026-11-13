package io.github.piotr_janczukowicz.gitlab.api.projectimportexport;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectExportStatusTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProjectExportStatusBuilder builder = GitLabProjectExportStatusBuilder.builder(
                        ProjectimportexportCatalogFixtures.projectExportStatus())
                .id(null);

        final GitLabProjectExportStatus built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectExportStatusBuilder builder = GitLabProjectExportStatusBuilder.builder(
                        ProjectimportexportCatalogFixtures.projectExportStatus())
                .description(null);

        final GitLabProjectExportStatus built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectExportStatusBuilder builder = GitLabProjectExportStatusBuilder.builder(
                        ProjectimportexportCatalogFixtures.projectExportStatus())
                .name(null);

        final GitLabProjectExportStatus built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameWithNamespaceIsNullable() {
        final GitLabProjectExportStatusBuilder builder = GitLabProjectExportStatusBuilder.builder(
                        ProjectimportexportCatalogFixtures.projectExportStatus())
                .nameWithNamespace(null);

        final GitLabProjectExportStatus built = builder.build();

        assertThat(built.nameWithNamespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabProjectExportStatusBuilder builder = GitLabProjectExportStatusBuilder.builder(
                        ProjectimportexportCatalogFixtures.projectExportStatus())
                .path(null);

        final GitLabProjectExportStatus built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathWithNamespaceIsNullable() {
        final GitLabProjectExportStatusBuilder builder = GitLabProjectExportStatusBuilder.builder(
                        ProjectimportexportCatalogFixtures.projectExportStatus())
                .pathWithNamespace(null);

        final GitLabProjectExportStatus built = builder.build();

        assertThat(built.pathWithNamespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabProjectExportStatusBuilder builder = GitLabProjectExportStatusBuilder.builder(
                        ProjectimportexportCatalogFixtures.projectExportStatus())
                .createdAt(null);

        final GitLabProjectExportStatus built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExportStatusIsNullable() {
        final GitLabProjectExportStatusBuilder builder = GitLabProjectExportStatusBuilder.builder(
                        ProjectimportexportCatalogFixtures.projectExportStatus())
                .exportStatus(null);

        final GitLabProjectExportStatus built = builder.build();

        assertThat(built.exportStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinksIsNullable() {
        final GitLabProjectExportStatusBuilder builder = GitLabProjectExportStatusBuilder.builder(
                        ProjectimportexportCatalogFixtures.projectExportStatus())
                .links(null);

        final GitLabProjectExportStatus built = builder.build();

        assertThat(built.links()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectExportStatus value = ProjectimportexportCatalogFixtures.projectExportStatus();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.description()).isEqualTo("desc");
            softly.assertThat(value.name()).isEqualTo("project1");
            softly.assertThat(value.nameWithNamespace()).isEqualTo("John Doe / project1");
            softly.assertThat(value.path()).isEqualTo("project1");
            softly.assertThat(value.pathWithNamespace()).isEqualTo("namespace1/project1");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.exportStatus()).isEqualTo(GitLabProjectExportStatusExportStatus.QUEUED);
            softly.assertThat(value.links()).isEqualTo(ProjectimportexportCatalogFixtures.projectExportStatusLinks());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectExportStatus original = ProjectimportexportCatalogFixtures.projectExportStatus();

        final GitLabProjectExportStatus rebuilt =
                GitLabProjectExportStatusBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectExportStatus.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "description",
                        "name",
                        "nameWithNamespace",
                        "path",
                        "pathWithNamespace",
                        "createdAt",
                        "exportStatus",
                        "links");
    }
}
