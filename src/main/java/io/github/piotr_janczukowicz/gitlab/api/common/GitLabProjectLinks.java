package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab project links of a GitLab resource.
 *
 * @param self the self
 * @param issues the issues
 * @param mergeRequests the merge requests
 * @param repoBranches the repo branches
 * @param labels the labels
 * @param events the events
 * @param members the members
 * @param clusterAgents the cluster agents
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesProject/properties/_links")
public record GitLabProjectLinks(
        @Nullable String self,
        @Nullable String issues,
        @Nullable String mergeRequests,
        @Nullable String repoBranches,
        @Nullable String labels,
        @Nullable String events,
        @Nullable String members,
        @Nullable String clusterAgents) {}
