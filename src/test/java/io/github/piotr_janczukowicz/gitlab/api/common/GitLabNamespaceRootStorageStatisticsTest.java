package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabNamespaceRootStorageStatisticsTest {

    @Test
    void constructor_shouldAcceptNull_whenBuildArtifactsSizeIsNullable() {
        final GitLabNamespaceRootStorageStatisticsBuilder builder = GitLabNamespaceRootStorageStatisticsBuilder.builder(
                        CommonCatalogFixtures.namespaceRootStorageStatistics())
                .buildArtifactsSize(null);

        final GitLabNamespaceRootStorageStatistics built = builder.build();

        assertThat(built.buildArtifactsSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRegistrySizeIsNullable() {
        final GitLabNamespaceRootStorageStatisticsBuilder builder = GitLabNamespaceRootStorageStatisticsBuilder.builder(
                        CommonCatalogFixtures.namespaceRootStorageStatistics())
                .containerRegistrySize(null);

        final GitLabNamespaceRootStorageStatistics built = builder.build();

        assertThat(built.containerRegistrySize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRegistrySizeIsEstimatedIsNullable() {
        final GitLabNamespaceRootStorageStatisticsBuilder builder = GitLabNamespaceRootStorageStatisticsBuilder.builder(
                        CommonCatalogFixtures.namespaceRootStorageStatistics())
                .containerRegistrySizeIsEstimated(null);

        final GitLabNamespaceRootStorageStatistics built = builder.build();

        assertThat(built.containerRegistrySizeIsEstimated()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyProxySizeIsNullable() {
        final GitLabNamespaceRootStorageStatisticsBuilder builder = GitLabNamespaceRootStorageStatisticsBuilder.builder(
                        CommonCatalogFixtures.namespaceRootStorageStatistics())
                .dependencyProxySize(null);

        final GitLabNamespaceRootStorageStatistics built = builder.build();

        assertThat(built.dependencyProxySize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLfsObjectsSizeIsNullable() {
        final GitLabNamespaceRootStorageStatisticsBuilder builder = GitLabNamespaceRootStorageStatisticsBuilder.builder(
                        CommonCatalogFixtures.namespaceRootStorageStatistics())
                .lfsObjectsSize(null);

        final GitLabNamespaceRootStorageStatistics built = builder.build();

        assertThat(built.lfsObjectsSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesSizeIsNullable() {
        final GitLabNamespaceRootStorageStatisticsBuilder builder = GitLabNamespaceRootStorageStatisticsBuilder.builder(
                        CommonCatalogFixtures.namespaceRootStorageStatistics())
                .packagesSize(null);

        final GitLabNamespaceRootStorageStatistics built = builder.build();

        assertThat(built.packagesSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineArtifactsSizeIsNullable() {
        final GitLabNamespaceRootStorageStatisticsBuilder builder = GitLabNamespaceRootStorageStatisticsBuilder.builder(
                        CommonCatalogFixtures.namespaceRootStorageStatistics())
                .pipelineArtifactsSize(null);

        final GitLabNamespaceRootStorageStatistics built = builder.build();

        assertThat(built.pipelineArtifactsSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositorySizeIsNullable() {
        final GitLabNamespaceRootStorageStatisticsBuilder builder = GitLabNamespaceRootStorageStatisticsBuilder.builder(
                        CommonCatalogFixtures.namespaceRootStorageStatistics())
                .repositorySize(null);

        final GitLabNamespaceRootStorageStatistics built = builder.build();

        assertThat(built.repositorySize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetsSizeIsNullable() {
        final GitLabNamespaceRootStorageStatisticsBuilder builder = GitLabNamespaceRootStorageStatisticsBuilder.builder(
                        CommonCatalogFixtures.namespaceRootStorageStatistics())
                .snippetsSize(null);

        final GitLabNamespaceRootStorageStatistics built = builder.build();

        assertThat(built.snippetsSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStorageSizeIsNullable() {
        final GitLabNamespaceRootStorageStatisticsBuilder builder = GitLabNamespaceRootStorageStatisticsBuilder.builder(
                        CommonCatalogFixtures.namespaceRootStorageStatistics())
                .storageSize(null);

        final GitLabNamespaceRootStorageStatistics built = builder.build();

        assertThat(built.storageSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadsSizeIsNullable() {
        final GitLabNamespaceRootStorageStatisticsBuilder builder = GitLabNamespaceRootStorageStatisticsBuilder.builder(
                        CommonCatalogFixtures.namespaceRootStorageStatistics())
                .uploadsSize(null);

        final GitLabNamespaceRootStorageStatistics built = builder.build();

        assertThat(built.uploadsSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiSizeIsNullable() {
        final GitLabNamespaceRootStorageStatisticsBuilder builder = GitLabNamespaceRootStorageStatisticsBuilder.builder(
                        CommonCatalogFixtures.namespaceRootStorageStatistics())
                .wikiSize(null);

        final GitLabNamespaceRootStorageStatistics built = builder.build();

        assertThat(built.wikiSize()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabNamespaceRootStorageStatistics value = CommonCatalogFixtures.namespaceRootStorageStatistics();

        assertSoftly(softly -> {
            softly.assertThat(value.buildArtifactsSize()).isEqualTo(1L);
            softly.assertThat(value.containerRegistrySize()).isEqualTo(1L);
            softly.assertThat(value.containerRegistrySizeIsEstimated()).isEqualTo(true);
            softly.assertThat(value.dependencyProxySize()).isEqualTo(1L);
            softly.assertThat(value.lfsObjectsSize()).isEqualTo(1L);
            softly.assertThat(value.packagesSize()).isEqualTo(1L);
            softly.assertThat(value.pipelineArtifactsSize()).isEqualTo(1L);
            softly.assertThat(value.repositorySize()).isEqualTo(1L);
            softly.assertThat(value.snippetsSize()).isEqualTo(1L);
            softly.assertThat(value.storageSize()).isEqualTo(1L);
            softly.assertThat(value.uploadsSize()).isEqualTo(1L);
            softly.assertThat(value.wikiSize()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabNamespaceRootStorageStatistics original = CommonCatalogFixtures.namespaceRootStorageStatistics();

        final GitLabNamespaceRootStorageStatistics rebuilt =
                GitLabNamespaceRootStorageStatisticsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabNamespaceRootStorageStatistics.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "buildArtifactsSize",
                        "containerRegistrySize",
                        "containerRegistrySizeIsEstimated",
                        "dependencyProxySize",
                        "lfsObjectsSize",
                        "packagesSize",
                        "pipelineArtifactsSize",
                        "repositorySize",
                        "snippetsSize",
                        "storageSize",
                        "uploadsSize",
                        "wikiSize");
    }
}
