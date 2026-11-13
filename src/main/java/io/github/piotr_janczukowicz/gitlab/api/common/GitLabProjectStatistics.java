package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab project statistics.
 *
 * @param commitCount the commit count
 * @param storageSize the storage size
 * @param repositorySize the repository size
 * @param wikiSize the wiki size
 * @param lfsObjectsSize the lfs objects size
 * @param jobArtifactsSize the job artifacts size
 * @param pipelineArtifactsSize the pipeline artifacts size
 * @param packagesSize the packages size
 * @param snippetsSize the snippets size
 * @param uploadsSize the uploads size
 * @param containerRegistrySize the container registry size
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesProjectStatistics")
public record GitLabProjectStatistics(
        @Nullable Integer commitCount,
        @Nullable Long storageSize,
        @Nullable Long repositorySize,
        @Nullable Long wikiSize,
        @Nullable Long lfsObjectsSize,
        @Nullable Long jobArtifactsSize,
        @Nullable Long pipelineArtifactsSize,
        @Nullable Long packagesSize,
        @Nullable Long snippetsSize,
        @Nullable Long uploadsSize,
        @Nullable Long containerRegistrySize) {}
