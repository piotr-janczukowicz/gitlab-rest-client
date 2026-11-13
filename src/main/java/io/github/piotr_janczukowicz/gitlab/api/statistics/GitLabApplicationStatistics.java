package io.github.piotr_janczukowicz.gitlab.api.statistics;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab application statistics.
 *
 * @param forks the forks
 * @param issues the issues
 * @param mergeRequests the merge requests
 * @param notes the notes
 * @param snippets the snippets
 * @param sshKeys the ssh keys
 * @param milestones the milestones
 * @param users the users
 * @param projects the projects
 * @param groups the groups
 * @param activeUsers the active users
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesApplicationStatistics")
public record GitLabApplicationStatistics(
        @Nullable Integer forks,
        @Nullable Integer issues,
        @Nullable Integer mergeRequests,
        @Nullable Integer notes,
        @Nullable Integer snippets,
        @Nullable Integer sshKeys,
        @Nullable Integer milestones,
        @Nullable Integer users,
        @Nullable Integer projects,
        @Nullable Integer groups,
        @Nullable Integer activeUsers) {}
