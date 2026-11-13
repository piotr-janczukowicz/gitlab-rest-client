package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab duo agent platform flows create agent workflow additional context of a GitLab resource.
 *
 * @param category the category
 * @param content the content
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4AiDuoWorkflowsAgentWorkflows/requestBody/properties/additional_context/items")
public record GitLabDuoAgentPlatformFlowsCreateAgentWorkflowAdditionalContext(
        @Nullable @JsonProperty("Category") String category,
        @Nullable @JsonProperty("Content") String content) {}
