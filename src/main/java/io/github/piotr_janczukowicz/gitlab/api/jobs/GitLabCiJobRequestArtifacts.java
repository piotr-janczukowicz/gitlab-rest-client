package io.github.piotr_janczukowicz.gitlab.api.jobs;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ci job request artifacts.
 *
 * @param name the name
 * @param untracked the untracked
 * @param paths the paths
 * @param exclude the exclude
 * @param when the when
 * @param expireIn the expire in
 * @param artifactType the artifact type
 * @param artifactFormat the artifact format
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiJobRequestArtifacts")
public record GitLabCiJobRequestArtifacts(
        @Nullable String name,
        @Nullable Boolean untracked,
        @Nullable List<String> paths,
        @Nullable List<String> exclude,
        @Nullable String when,
        @Nullable String expireIn,
        @Nullable String artifactType,
        @Nullable String artifactFormat) {}
