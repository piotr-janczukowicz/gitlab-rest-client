package io.github.piotr_janczukowicz.gitlab.api.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab user associations count.
 *
 * @param groupsCount the groups count
 * @param projectsCount the projects count
 * @param issuesCount the issues count
 * @param mergeRequestsCount the merge requests count
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesUserAssociationsCount")
public record GitLabUserAssociationsCount(
        @Nullable Integer groupsCount,
        @Nullable Integer projectsCount,
        @Nullable Integer issuesCount,
        @Nullable Integer mergeRequestsCount) {}
