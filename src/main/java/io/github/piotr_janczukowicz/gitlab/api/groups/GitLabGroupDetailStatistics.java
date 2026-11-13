package io.github.piotr_janczukowicz.gitlab.api.groups;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab group detail statistics of a GitLab resource.
 *
 * @param storageSize the storage size
 * @param repositorySize the repository size
 * @param wikiSize the wiki size
 * @param lfsObjectsSize the lfs objects size
 * @param jobArtifactsSize the job artifacts size
 * @param pipelineArtifactsSize the pipeline artifacts size
 * @param packagesSize the packages size
 * @param snippetsSize the snippets size
 * @param uploadsSize the uploads size
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesGroupDetail/properties/statistics")
public record GitLabGroupDetailStatistics(
        @Nullable String storageSize,
        @Nullable String repositorySize,
        @Nullable String wikiSize,
        @Nullable String lfsObjectsSize,
        @Nullable String jobArtifactsSize,
        @Nullable String pipelineArtifactsSize,
        @Nullable String packagesSize,
        @Nullable String snippetsSize,
        @Nullable String uploadsSize) {}
