package io.github.piotr_janczukowicz.gitlab.api.integrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdIntegrationsPipelinesEmail}.
 *
 * @param recipients the recipients
 * @param notifyOnlyBrokenPipelines the notify only broken pipelines
 * @param notifyOnlyWhenPipelineStatusChanges the notify only when pipeline status changes
 * @param notifyOnlyDefaultBranch the notify only default branch
 * @param branchesToBeNotified the branches to be notified
 * @param notifyChildPipelines the notify child pipelines
 * @param pipelineEvents the pipeline events
 * @param useInheritedSettings the use inherited settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdIntegrationsPipelinesEmail/requestBody")
public record GitLabProjectIntegrationsPipelinesEmailPayload(
        @Nullable String recipients,
        @Nullable Boolean notifyOnlyBrokenPipelines,
        @Nullable Boolean notifyOnlyWhenPipelineStatusChanges,
        @Nullable Boolean notifyOnlyDefaultBranch,
        @Nullable String branchesToBeNotified,
        @Nullable Boolean notifyChildPipelines,
        @Nullable Boolean pipelineEvents,
        @Nullable Boolean useInheritedSettings) {}
