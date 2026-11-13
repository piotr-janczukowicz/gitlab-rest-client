package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab namespace root storage statistics.
 *
 * @param buildArtifactsSize the build artifacts size
 * @param containerRegistrySize the container registry size
 * @param containerRegistrySizeIsEstimated the container registry size is estimated
 * @param dependencyProxySize the dependency proxy size
 * @param lfsObjectsSize the lfs objects size
 * @param packagesSize the packages size
 * @param pipelineArtifactsSize the pipeline artifacts size
 * @param repositorySize the repository size
 * @param snippetsSize the snippets size
 * @param storageSize the storage size
 * @param uploadsSize the uploads size
 * @param wikiSize the wiki size
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesNamespaceRootStorageStatistics")
public record GitLabNamespaceRootStorageStatistics(
        @Nullable Long buildArtifactsSize,
        @Nullable Long containerRegistrySize,
        @Nullable Boolean containerRegistrySizeIsEstimated,
        @Nullable Long dependencyProxySize,
        @Nullable Long lfsObjectsSize,
        @Nullable Long packagesSize,
        @Nullable Long pipelineArtifactsSize,
        @Nullable Long repositorySize,
        @Nullable Long snippetsSize,
        @Nullable Long storageSize,
        @Nullable Long uploadsSize,
        @Nullable Long wikiSize) {}
