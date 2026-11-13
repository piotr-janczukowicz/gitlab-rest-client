package io.github.piotr_janczukowicz.gitlab.api.deployments;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab deployment approval.
 *
 * @param user the user
 * @param status the status
 * @param createdAt the created at
 * @param comment the comment
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesDeploymentsApproval")
public record GitLabDeploymentApproval(
        @Nullable GitLabUserBasic user,
        @Nullable String status,
        @Nullable Instant createdAt,
        @Nullable String comment) {}
