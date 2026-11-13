package io.github.piotr_janczukowicz.gitlab.api.deployments;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab deployment approval summary.
 *
 * @param rules the rules
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesDeploymentsApprovalSummary")
public record GitLabDeploymentApprovalSummary(
        @Nullable List<GitLabProtectedEnvironmentsApprovalRuleForSummary> rules) {}
