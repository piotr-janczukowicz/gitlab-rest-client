package io.github.piotr_janczukowicz.gitlab.api.deployments;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCiJob;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabEnvironmentBasic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab deployment extended.
 *
 * @param id the id
 * @param iid the iid
 * @param ref the ref
 * @param sha the sha
 * @param createdAt the created at
 * @param updatedAt the updated at
 * @param user the user
 * @param environment the environment
 * @param deployable the deployable
 * @param status the status
 * @param pendingApprovalCount the pending approval count
 * @param approvals the approvals
 * @param approvalSummary the approval summary
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesDeploymentExtended")
public record GitLabDeploymentExtended(
        @Nullable Long id,
        @Nullable Long iid,
        @Nullable String ref,
        @Nullable String sha,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt,
        @Nullable GitLabUserBasic user,
        @Nullable GitLabEnvironmentBasic environment,
        @Nullable GitLabCiJob deployable,
        @Nullable String status,
        @Nullable Integer pendingApprovalCount,
        @Nullable List<GitLabDeploymentApproval> approvals,
        @Nullable GitLabDeploymentApprovalSummary approvalSummary) {}
