package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4GroupsIdIntegrationsDatadog}.
 *
 * @param datadogSite the datadog site
 * @param apiUrl the api url
 * @param apiKey the api key
 * @param datadogCiVisibility the datadog ci visibility
 * @param archiveTraceEvents the archive trace events
 * @param datadogService the datadog service
 * @param datadogEnv the datadog env
 * @param datadogTags the datadog tags
 * @param pipelineEvents the pipeline events
 * @param buildEvents the build events
 * @param pushEvents the push events
 * @param mergeRequestsEvents the merge requests events
 * @param noteEvents the note events
 * @param tagPushEvents the tag push events
 * @param subgroupEvents the subgroup events
 * @param projectEvents the project events
 * @param useInheritedSettings the use inherited settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4GroupsIdIntegrationsDatadog/requestBody")
public record GitLabGroupGroupIntegrationsDatadogPayload(
        @Nullable String datadogSite,
        @Nullable String apiUrl,
        @Nullable String apiKey,
        @Nullable Boolean datadogCiVisibility,
        @Nullable Boolean archiveTraceEvents,
        @Nullable String datadogService,
        @Nullable String datadogEnv,
        @Nullable String datadogTags,
        @Nullable Boolean pipelineEvents,
        @Nullable Boolean buildEvents,
        @Nullable Boolean pushEvents,
        @Nullable Boolean mergeRequestsEvents,
        @Nullable Boolean noteEvents,
        @Nullable Boolean tagPushEvents,
        @Nullable Boolean subgroupEvents,
        @Nullable Boolean projectEvents,
        @Nullable Boolean useInheritedSettings) {}
