package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab duo agent platform flows create tools risk assessment result claim of a GitLab resource.
 *
 * @param name the name
 * @param value the value
 * @param evidence the evidence
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4AiDuoWorkflowsToolsRiskAssessmentResults/requestBody/properties/claims/items")
public record GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaim(
        @Nullable String name,
        @Nullable String value,
        @Nullable String evidence) {
    public GitLabDuoAgentPlatformFlowsCreateToolsRiskAssessmentResultClaim {
        requireMaxLengthIfPresent(name, 64, "name");
        requireMaxLengthIfPresent(value, 256, "value");
        requireMaxLengthIfPresent(evidence, 256, "evidence");
    }
}
