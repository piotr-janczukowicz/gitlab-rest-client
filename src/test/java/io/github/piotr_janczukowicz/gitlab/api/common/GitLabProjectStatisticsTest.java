package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectStatisticsTest {

    @Test
    void constructor_shouldAcceptNull_whenCommitCountIsNullable() {
        final GitLabProjectStatisticsBuilder builder = GitLabProjectStatisticsBuilder.builder(
                        CommonCatalogFixtures.projectStatistics())
                .commitCount(null);

        final GitLabProjectStatistics built = builder.build();

        assertThat(built.commitCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStorageSizeIsNullable() {
        final GitLabProjectStatisticsBuilder builder = GitLabProjectStatisticsBuilder.builder(
                        CommonCatalogFixtures.projectStatistics())
                .storageSize(null);

        final GitLabProjectStatistics built = builder.build();

        assertThat(built.storageSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositorySizeIsNullable() {
        final GitLabProjectStatisticsBuilder builder = GitLabProjectStatisticsBuilder.builder(
                        CommonCatalogFixtures.projectStatistics())
                .repositorySize(null);

        final GitLabProjectStatistics built = builder.build();

        assertThat(built.repositorySize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiSizeIsNullable() {
        final GitLabProjectStatisticsBuilder builder = GitLabProjectStatisticsBuilder.builder(
                        CommonCatalogFixtures.projectStatistics())
                .wikiSize(null);

        final GitLabProjectStatistics built = builder.build();

        assertThat(built.wikiSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLfsObjectsSizeIsNullable() {
        final GitLabProjectStatisticsBuilder builder = GitLabProjectStatisticsBuilder.builder(
                        CommonCatalogFixtures.projectStatistics())
                .lfsObjectsSize(null);

        final GitLabProjectStatistics built = builder.build();

        assertThat(built.lfsObjectsSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobArtifactsSizeIsNullable() {
        final GitLabProjectStatisticsBuilder builder = GitLabProjectStatisticsBuilder.builder(
                        CommonCatalogFixtures.projectStatistics())
                .jobArtifactsSize(null);

        final GitLabProjectStatistics built = builder.build();

        assertThat(built.jobArtifactsSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsSizeIsNullable() {
        final GitLabProjectStatisticsBuilder builder = GitLabProjectStatisticsBuilder.builder(
                        CommonCatalogFixtures.projectStatistics())
                .pipelineArtifactsSize(null);

        final GitLabProjectStatistics built = builder.build();

        assertThat(built.pipelineArtifactsSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesSizeIsNullable() {
        final GitLabProjectStatisticsBuilder builder = GitLabProjectStatisticsBuilder.builder(
                        CommonCatalogFixtures.projectStatistics())
                .packagesSize(null);

        final GitLabProjectStatistics built = builder.build();

        assertThat(built.packagesSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetsSizeIsNullable() {
        final GitLabProjectStatisticsBuilder builder = GitLabProjectStatisticsBuilder.builder(
                        CommonCatalogFixtures.projectStatistics())
                .snippetsSize(null);

        final GitLabProjectStatistics built = builder.build();

        assertThat(built.snippetsSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsSizeIsNullable() {
        final GitLabProjectStatisticsBuilder builder = GitLabProjectStatisticsBuilder.builder(
                        CommonCatalogFixtures.projectStatistics())
                .uploadsSize(null);

        final GitLabProjectStatistics built = builder.build();

        assertThat(built.uploadsSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRegistrySizeIsNullable() {
        final GitLabProjectStatisticsBuilder builder = GitLabProjectStatisticsBuilder.builder(
                        CommonCatalogFixtures.projectStatistics())
                .containerRegistrySize(null);

        final GitLabProjectStatistics built = builder.build();

        assertThat(built.containerRegistrySize()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectStatistics value = CommonCatalogFixtures.projectStatistics();

        assertSoftly(softly -> {
            softly.assertThat(value.commitCount()).isEqualTo(1);
            softly.assertThat(value.storageSize()).isEqualTo(1L);
            softly.assertThat(value.repositorySize()).isEqualTo(1L);
            softly.assertThat(value.wikiSize()).isEqualTo(1L);
            softly.assertThat(value.lfsObjectsSize()).isEqualTo(1L);
            softly.assertThat(value.jobArtifactsSize()).isEqualTo(1L);
            softly.assertThat(value.pipelineArtifactsSize()).isEqualTo(1L);
            softly.assertThat(value.packagesSize()).isEqualTo(1L);
            softly.assertThat(value.snippetsSize()).isEqualTo(1L);
            softly.assertThat(value.uploadsSize()).isEqualTo(1L);
            softly.assertThat(value.containerRegistrySize()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectStatistics original = CommonCatalogFixtures.projectStatistics();

        final GitLabProjectStatistics rebuilt =
                GitLabProjectStatisticsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectStatistics.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "commitCount",
                        "storageSize",
                        "repositorySize",
                        "wikiSize",
                        "lfsObjectsSize",
                        "jobArtifactsSize",
                        "pipelineArtifactsSize",
                        "packagesSize",
                        "snippetsSize",
                        "uploadsSize",
                        "containerRegistrySize");
    }
}
