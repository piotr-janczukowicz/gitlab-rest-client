package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupStatisticsTest {

    @Test
    void constructor_shouldAcceptNull_whenStorageSizeIsNullable() {
        final GitLabGroupStatisticsBuilder builder = GitLabGroupStatisticsBuilder.builder(
                        CommonCatalogFixtures.groupStatistics())
                .storageSize(null);

        final GitLabGroupStatistics built = builder.build();

        assertThat(built.storageSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositorySizeIsNullable() {
        final GitLabGroupStatisticsBuilder builder = GitLabGroupStatisticsBuilder.builder(
                        CommonCatalogFixtures.groupStatistics())
                .repositorySize(null);

        final GitLabGroupStatistics built = builder.build();

        assertThat(built.repositorySize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiSizeIsNullable() {
        final GitLabGroupStatisticsBuilder builder = GitLabGroupStatisticsBuilder.builder(
                        CommonCatalogFixtures.groupStatistics())
                .wikiSize(null);

        final GitLabGroupStatistics built = builder.build();

        assertThat(built.wikiSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLfsObjectsSizeIsNullable() {
        final GitLabGroupStatisticsBuilder builder = GitLabGroupStatisticsBuilder.builder(
                        CommonCatalogFixtures.groupStatistics())
                .lfsObjectsSize(null);

        final GitLabGroupStatistics built = builder.build();

        assertThat(built.lfsObjectsSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsSizeIsNullable() {
        final GitLabGroupStatisticsBuilder builder = GitLabGroupStatisticsBuilder.builder(
                        CommonCatalogFixtures.groupStatistics())
                .jobArtifactsSize(null);

        final GitLabGroupStatistics built = builder.build();

        assertThat(built.jobArtifactsSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsSizeIsNullable() {
        final GitLabGroupStatisticsBuilder builder = GitLabGroupStatisticsBuilder.builder(
                        CommonCatalogFixtures.groupStatistics())
                .pipelineArtifactsSize(null);

        final GitLabGroupStatistics built = builder.build();

        assertThat(built.pipelineArtifactsSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesSizeIsNullable() {
        final GitLabGroupStatisticsBuilder builder = GitLabGroupStatisticsBuilder.builder(
                        CommonCatalogFixtures.groupStatistics())
                .packagesSize(null);

        final GitLabGroupStatistics built = builder.build();

        assertThat(built.packagesSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetsSizeIsNullable() {
        final GitLabGroupStatisticsBuilder builder = GitLabGroupStatisticsBuilder.builder(
                        CommonCatalogFixtures.groupStatistics())
                .snippetsSize(null);

        final GitLabGroupStatistics built = builder.build();

        assertThat(built.snippetsSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsSizeIsNullable() {
        final GitLabGroupStatisticsBuilder builder = GitLabGroupStatisticsBuilder.builder(
                        CommonCatalogFixtures.groupStatistics())
                .uploadsSize(null);

        final GitLabGroupStatistics built = builder.build();

        assertThat(built.uploadsSize()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupStatistics value = CommonCatalogFixtures.groupStatistics();

        assertSoftly(softly -> {
            softly.assertThat(value.storageSize()).isEqualTo("storage_size");
            softly.assertThat(value.repositorySize()).isEqualTo("repository_size");
            softly.assertThat(value.wikiSize()).isEqualTo("wiki_size");
            softly.assertThat(value.lfsObjectsSize()).isEqualTo("lfs_objects_size");
            softly.assertThat(value.jobArtifactsSize()).isEqualTo("job_artifacts_size");
            softly.assertThat(value.pipelineArtifactsSize()).isEqualTo("pipeline_artifacts_size");
            softly.assertThat(value.packagesSize()).isEqualTo("packages_size");
            softly.assertThat(value.snippetsSize()).isEqualTo("snippets_size");
            softly.assertThat(value.uploadsSize()).isEqualTo("uploads_size");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupStatistics original = CommonCatalogFixtures.groupStatistics();

        final GitLabGroupStatistics rebuilt =
                GitLabGroupStatisticsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupStatistics.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "storageSize",
                        "repositorySize",
                        "wikiSize",
                        "lfsObjectsSize",
                        "jobArtifactsSize",
                        "pipelineArtifactsSize",
                        "packagesSize",
                        "snippetsSize",
                        "uploadsSize");
    }
}
