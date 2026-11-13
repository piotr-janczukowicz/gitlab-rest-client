package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMergeRequestBasic;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab merge request dependency.
 *
 * @param id the id
 * @param blockingMergeRequest the blocking merge request
 * @param blockedMergeRequest the blocked merge request
 * @param projectId the project id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesMergeRequestDependency")
public record GitLabMergeRequestDependency(
        @Nullable Long id,
        @Nullable GitLabMergeRequestBasic blockingMergeRequest,
        @Nullable GitLabMergeRequestBasic blockedMergeRequest,
        @Nullable Long projectId) {}
