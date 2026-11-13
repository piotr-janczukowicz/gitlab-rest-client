package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupDetailStatisticsTest {

    @Test
    void constructor_shouldAcceptNull_whenStorageSizeIsNullable() {
        final GitLabGroupDetailStatisticsBuilder builder = GitLabGroupDetailStatisticsBuilder.builder(
                        GroupsCatalogFixtures.groupDetailStatistics())
                .storageSize(null);

        final GitLabGroupDetailStatistics built = builder.build();

        assertThat(built.storageSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositorySizeIsNullable() {
        final GitLabGroupDetailStatisticsBuilder builder = GitLabGroupDetailStatisticsBuilder.builder(
                        GroupsCatalogFixtures.groupDetailStatistics())
                .repositorySize(null);

        final GitLabGroupDetailStatistics built = builder.build();

        assertThat(built.repositorySize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiSizeIsNullable() {
        final GitLabGroupDetailStatisticsBuilder builder = GitLabGroupDetailStatisticsBuilder.builder(
                        GroupsCatalogFixtures.groupDetailStatistics())
                .wikiSize(null);

        final GitLabGroupDetailStatistics built = builder.build();

        assertThat(built.wikiSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLfsObjectsSizeIsNullable() {
        final GitLabGroupDetailStatisticsBuilder builder = GitLabGroupDetailStatisticsBuilder.builder(
                        GroupsCatalogFixtures.groupDetailStatistics())
                .lfsObjectsSize(null);

        final GitLabGroupDetailStatistics built = builder.build();

        assertThat(built.lfsObjectsSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsSizeIsNullable() {
        final GitLabGroupDetailStatisticsBuilder builder = GitLabGroupDetailStatisticsBuilder.builder(
                        GroupsCatalogFixtures.groupDetailStatistics())
                .jobArtifactsSize(null);

        final GitLabGroupDetailStatistics built = builder.build();

        assertThat(built.jobArtifactsSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsSizeIsNullable() {
        final GitLabGroupDetailStatisticsBuilder builder = GitLabGroupDetailStatisticsBuilder.builder(
                        GroupsCatalogFixtures.groupDetailStatistics())
                .pipelineArtifactsSize(null);

        final GitLabGroupDetailStatistics built = builder.build();

        assertThat(built.pipelineArtifactsSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesSizeIsNullable() {
        final GitLabGroupDetailStatisticsBuilder builder = GitLabGroupDetailStatisticsBuilder.builder(
                        GroupsCatalogFixtures.groupDetailStatistics())
                .packagesSize(null);

        final GitLabGroupDetailStatistics built = builder.build();

        assertThat(built.packagesSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetsSizeIsNullable() {
        final GitLabGroupDetailStatisticsBuilder builder = GitLabGroupDetailStatisticsBuilder.builder(
                        GroupsCatalogFixtures.groupDetailStatistics())
                .snippetsSize(null);

        final GitLabGroupDetailStatistics built = builder.build();

        assertThat(built.snippetsSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsSizeIsNullable() {
        final GitLabGroupDetailStatisticsBuilder builder = GitLabGroupDetailStatisticsBuilder.builder(
                        GroupsCatalogFixtures.groupDetailStatistics())
                .uploadsSize(null);

        final GitLabGroupDetailStatistics built = builder.build();

        assertThat(built.uploadsSize()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupDetailStatistics value = GroupsCatalogFixtures.groupDetailStatistics();

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
        final GitLabGroupDetailStatistics original = GroupsCatalogFixtures.groupDetailStatistics();

        final GitLabGroupDetailStatistics rebuilt =
                GitLabGroupDetailStatisticsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupDetailStatistics.class.getRecordComponents())
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
