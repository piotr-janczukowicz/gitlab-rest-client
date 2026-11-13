package io.github.piotr_janczukowicz.gitlab.api.integrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdServicesEmailsOnPush}.
 *
 * @param sendFromCommitterEmail the send from committer email
 * @param disableDiffs the disable diffs
 * @param branchesToBeNotified the branches to be notified
 * @param recipients the recipients
 * @param pushEvents the push events
 * @param tagPushEvents the tag push events
 * @param useInheritedSettings the use inherited settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdServicesEmailsOnPush/requestBody")
public record GitLabProjectIntegrationsEmailsOnPushServicePayload(
        @Nullable Boolean sendFromCommitterEmail,
        @Nullable Boolean disableDiffs,
        @Nullable String branchesToBeNotified,
        @Nullable String recipients,
        @Nullable Boolean pushEvents,
        @Nullable Boolean tagPushEvents,
        @Nullable Boolean useInheritedSettings) {}
