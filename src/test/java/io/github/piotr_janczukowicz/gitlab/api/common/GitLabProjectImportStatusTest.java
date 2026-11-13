package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectImportStatusTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProjectImportStatusBuilder builder = GitLabProjectImportStatusBuilder.builder(
                        CommonCatalogFixtures.projectImportStatus())
                .id(null);

        final GitLabProjectImportStatus built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectImportStatusBuilder builder = GitLabProjectImportStatusBuilder.builder(
                        CommonCatalogFixtures.projectImportStatus())
                .description(null);

        final GitLabProjectImportStatus built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectImportStatusBuilder builder = GitLabProjectImportStatusBuilder.builder(
                        CommonCatalogFixtures.projectImportStatus())
                .name(null);

        final GitLabProjectImportStatus built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameWithNamespaceIsNullable() {
        final GitLabProjectImportStatusBuilder builder = GitLabProjectImportStatusBuilder.builder(
                        CommonCatalogFixtures.projectImportStatus())
                .nameWithNamespace(null);

        final GitLabProjectImportStatus built = builder.build();

        assertThat(built.nameWithNamespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabProjectImportStatusBuilder builder = GitLabProjectImportStatusBuilder.builder(
                        CommonCatalogFixtures.projectImportStatus())
                .path(null);

        final GitLabProjectImportStatus built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathWithNamespaceIsNullable() {
        final GitLabProjectImportStatusBuilder builder = GitLabProjectImportStatusBuilder.builder(
                        CommonCatalogFixtures.projectImportStatus())
                .pathWithNamespace(null);

        final GitLabProjectImportStatus built = builder.build();

        assertThat(built.pathWithNamespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabProjectImportStatusBuilder builder = GitLabProjectImportStatusBuilder.builder(
                        CommonCatalogFixtures.projectImportStatus())
                .createdAt(null);

        final GitLabProjectImportStatus built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportStatusIsNullable() {
        final GitLabProjectImportStatusBuilder builder = GitLabProjectImportStatusBuilder.builder(
                        CommonCatalogFixtures.projectImportStatus())
                .importStatus(null);

        final GitLabProjectImportStatus built = builder.build();

        assertThat(built.importStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportTypeIsNullable() {
        final GitLabProjectImportStatusBuilder builder = GitLabProjectImportStatusBuilder.builder(
                        CommonCatalogFixtures.projectImportStatus())
                .importType(null);

        final GitLabProjectImportStatus built = builder.build();

        assertThat(built.importType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCorrelationIdIsNullable() {
        final GitLabProjectImportStatusBuilder builder = GitLabProjectImportStatusBuilder.builder(
                        CommonCatalogFixtures.projectImportStatus())
                .correlationId(null);

        final GitLabProjectImportStatus built = builder.build();

        assertThat(built.correlationId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFailedRelationsIsNullable() {
        final GitLabProjectImportStatusBuilder builder = GitLabProjectImportStatusBuilder.builder(
                        CommonCatalogFixtures.projectImportStatus())
                .failedRelations(null);

        final GitLabProjectImportStatus built = builder.build();

        assertThat(built.failedRelations()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportErrorIsNullable() {
        final GitLabProjectImportStatusBuilder builder = GitLabProjectImportStatusBuilder.builder(
                        CommonCatalogFixtures.projectImportStatus())
                .importError(null);

        final GitLabProjectImportStatus built = builder.build();

        assertThat(built.importError()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatsIsNullable() {
        final GitLabProjectImportStatusBuilder builder = GitLabProjectImportStatusBuilder.builder(
                        CommonCatalogFixtures.projectImportStatus())
                .stats(null);

        final GitLabProjectImportStatus built = builder.build();

        assertThat(built.stats()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectImportStatus value = CommonCatalogFixtures.projectImportStatus();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.description()).isEqualTo("desc");
            softly.assertThat(value.name()).isEqualTo("project1");
            softly.assertThat(value.nameWithNamespace()).isEqualTo("John Doe / project1");
            softly.assertThat(value.path()).isEqualTo("project1");
            softly.assertThat(value.pathWithNamespace()).isEqualTo("namespace1/project1");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.importStatus()).isEqualTo("scheduled");
            softly.assertThat(value.importType()).isEqualTo("gitlab_project");
            softly.assertThat(value.correlationId()).isEqualTo("dfcf583058ed4508e4c7c617bd7f0edd");
            softly.assertThat(value.failedRelations())
                    .isEqualTo(List.of(CommonCatalogFixtures.projectImportFailedRelation()));
            softly.assertThat(value.importError()).isEqualTo("Error message");
            softly.assertThat(value.stats()).isEqualTo(Map.of("key", "value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectImportStatus original = CommonCatalogFixtures.projectImportStatus();

        final GitLabProjectImportStatus rebuilt =
                GitLabProjectImportStatusBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectImportStatus.class.getRecordComponents())
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
                        "importStatus",
                        "importType",
                        "correlationId",
                        "failedRelations",
                        "importError",
                        "stats");
    }
}
