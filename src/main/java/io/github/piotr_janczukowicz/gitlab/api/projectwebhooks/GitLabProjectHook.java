package io.github.piotr_janczukowicz.gitlab.api.projectwebhooks;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab project hook.
 *
 * @param id the id
 * @param url the url
 * @param name the name
 * @param description the description
 * @param createdAt the created at
 * @param pushEvents the push events
 * @param tagPushEvents the tag push events
 * @param mergeRequestsEvents the merge requests events
 * @param repositoryUpdateEvents the repository update events
 * @param enableSslVerification the enable ssl verification
 * @param organizationId the organization id
 * @param alertStatus the alert status
 * @param disabledUntil the disabled until
 * @param urlVariables the url variables
 * @param pushEventsBranchFilter the push events branch filter
 * @param branchFilterStrategy the branch filter strategy
 * @param customWebhookTemplate the custom webhook template
 * @param customHeaders the custom headers
 * @param tokenPresent the token present
 * @param signingTokenPresent the signing token present
 * @param projectId the project id
 * @param issuesEvents the issues events
 * @param confidentialIssuesEvents the confidential issues events
 * @param noteEvents the note events
 * @param confidentialNoteEvents the confidential note events
 * @param pipelineEvents the pipeline events
 * @param wikiPageEvents the wiki page events
 * @param deploymentEvents the deployment events
 * @param featureFlagEvents the feature flag events
 * @param jobEvents the job events
 * @param releasesEvents the releases events
 * @param milestoneEvents the milestone events
 * @param emojiEvents the emoji events
 * @param resourceAccessTokenEvents the resource access token events
 * @param resourceDeployTokenEvents the resource deploy token events
 * @param vulnerabilityEvents the vulnerability events
 * @param duoFlowCallbackEnabled the duo flow callback enabled
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesProjectHook")
public record GitLabProjectHook(
        @Nullable Long id,
        @Nullable String url,
        @Nullable String name,
        @Nullable String description,
        @Nullable Instant createdAt,
        @Nullable Boolean pushEvents,
        @Nullable Boolean tagPushEvents,
        @Nullable Boolean mergeRequestsEvents,
        @Nullable Boolean repositoryUpdateEvents,
        @Nullable Boolean enableSslVerification,
        @Nullable Long organizationId,
        @Nullable String alertStatus,
        @Nullable Instant disabledUntil,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        List<Map<String, Object>> urlVariables,

        @Nullable String pushEventsBranchFilter,
        @Nullable String branchFilterStrategy,
        @Nullable String customWebhookTemplate,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        List<Map<String, Object>> customHeaders,

        @Nullable Boolean tokenPresent,
        @Nullable Boolean signingTokenPresent,
        @Nullable Long projectId,
        @Nullable Boolean issuesEvents,
        @Nullable Boolean confidentialIssuesEvents,
        @Nullable Boolean noteEvents,
        @Nullable Boolean confidentialNoteEvents,
        @Nullable Boolean pipelineEvents,
        @Nullable Boolean wikiPageEvents,
        @Nullable Boolean deploymentEvents,
        @Nullable Boolean featureFlagEvents,
        @Nullable Boolean jobEvents,
        @Nullable Boolean releasesEvents,
        @Nullable Boolean milestoneEvents,
        @Nullable Boolean emojiEvents,
        @Nullable Boolean resourceAccessTokenEvents,
        @Nullable Boolean resourceDeployTokenEvents,
        @Nullable Boolean vulnerabilityEvents,
        @Nullable Boolean duoFlowCallbackEnabled) {}
