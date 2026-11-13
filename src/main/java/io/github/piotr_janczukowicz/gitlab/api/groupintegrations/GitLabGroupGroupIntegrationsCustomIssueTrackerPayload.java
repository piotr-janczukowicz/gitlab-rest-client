package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4GroupsIdIntegrationsCustomIssueTracker}.
 *
 * @param projectUrl the project url
 * @param issuesUrl the issues url
 * @param newIssueUrl the new issue url
 * @param pushEvents the push events
 * @param useInheritedSettings the use inherited settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4GroupsIdIntegrationsCustomIssueTracker/requestBody")
public record GitLabGroupGroupIntegrationsCustomIssueTrackerPayload(
        @Nullable String projectUrl,
        @Nullable String issuesUrl,
        @Nullable String newIssueUrl,
        @Nullable Boolean pushEvents,
        @Nullable Boolean useInheritedSettings) {}
