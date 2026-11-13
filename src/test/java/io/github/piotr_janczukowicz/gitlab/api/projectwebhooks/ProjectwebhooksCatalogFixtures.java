package io.github.piotr_janczukowicz.gitlab.api.projectwebhooks;

import java.time.Instant;
import java.util.List;
import java.util.Map;

public final class ProjectwebhooksCatalogFixtures {

    private ProjectwebhooksCatalogFixtures() {}

    public static GitLabProjectHook projectHook() {
        return GitLabProjectHookBuilder.builder()
                .id(1L)
                .url("https://webhook.site")
                .name("Hook name")
                .description("Hook description")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .pushEvents(true)
                .tagPushEvents(true)
                .mergeRequestsEvents(true)
                .repositoryUpdateEvents(true)
                .enableSslVerification(true)
                .organizationId(1L)
                .alertStatus("executable")
                .disabledUntil(Instant.parse("2026-01-01T00:00:00Z"))
                .urlVariables(List.of(Map.of("key", "value")))
                .pushEventsBranchFilter("my-branch-*")
                .branchFilterStrategy("wildcard")
                .customWebhookTemplate("{\"event\":\"{{object_kind}}\"}")
                .customHeaders(List.of(Map.of("key", "value")))
                .tokenPresent(true)
                .signingTokenPresent(true)
                .projectId(1L)
                .issuesEvents(true)
                .confidentialIssuesEvents(true)
                .noteEvents(true)
                .confidentialNoteEvents(true)
                .pipelineEvents(true)
                .wikiPageEvents(true)
                .deploymentEvents(true)
                .featureFlagEvents(true)
                .jobEvents(true)
                .releasesEvents(true)
                .milestoneEvents(true)
                .emojiEvents(true)
                .resourceAccessTokenEvents(true)
                .resourceDeployTokenEvents(true)
                .vulnerabilityEvents(true)
                .duoFlowCallbackEnabled(true)
                .build();
    }

    public static GitLabProjectProjectWebhooksCreateCustomHeader projectProjectWebhooksCreateCustomHeader() {
        return GitLabProjectProjectWebhooksCreateCustomHeaderBuilder.builder()
                .key("X-Custom-Header")
                .value("value")
                .build();
    }

    public static GitLabProjectProjectWebhooksCreatePayload projectProjectWebhooksCreatePayload() {
        return GitLabProjectProjectWebhooksCreatePayloadBuilder.builder()
                .url("http://example.com/hook")
                .name("name")
                .description("description")
                .pushEvents(true)
                .issuesEvents(true)
                .confidentialIssuesEvents(true)
                .mergeRequestsEvents(true)
                .tagPushEvents(true)
                .noteEvents(true)
                .confidentialNoteEvents(true)
                .jobEvents(true)
                .pipelineEvents(true)
                .wikiPageEvents(true)
                .deploymentEvents(true)
                .featureFlagEvents(true)
                .releasesEvents(true)
                .milestoneEvents(true)
                .emojiEvents(true)
                .resourceAccessTokenEvents(true)
                .resourceDeployTokenEvents(true)
                .enableSslVerification(true)
                .token("token")
                .signingToken("signing_token")
                .pushEventsBranchFilter("push_events_branch_filter")
                .customWebhookTemplate("custom_webhook_template")
                .branchFilterStrategy(GitLabProjectProjectWebhooksCreateBranchFilterStrategy.WILDCARD)
                .vulnerabilityEvents(true)
                .duoFlowCallbackEnabled(true)
                .urlVariables(List.of(ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreateUrlVariable()))
                .customHeaders(List.of(ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreateCustomHeader()))
                .build();
    }

    public static GitLabProjectProjectWebhooksCreateUrlVariable projectProjectWebhooksCreateUrlVariable() {
        return GitLabProjectProjectWebhooksCreateUrlVariableBuilder.builder()
                .key("token")
                .value("123")
                .build();
    }

    public static GitLabProjectProjectWebhooksUpdateCustomHeader projectProjectWebhooksUpdateCustomHeader() {
        return GitLabProjectProjectWebhooksUpdateCustomHeaderBuilder.builder()
                .key("X-Custom-Header")
                .value("value")
                .build();
    }

    public static GitLabProjectProjectWebhooksUpdateCustomHeaderPayload
            projectProjectWebhooksUpdateCustomHeaderPayload() {
        return GitLabProjectProjectWebhooksUpdateCustomHeaderPayloadBuilder.builder()
                .value("value")
                .build();
    }

    public static GitLabProjectProjectWebhooksUpdatePayload projectProjectWebhooksUpdatePayload() {
        return GitLabProjectProjectWebhooksUpdatePayloadBuilder.builder()
                .url("url")
                .name("name")
                .description("description")
                .pushEvents(true)
                .issuesEvents(true)
                .confidentialIssuesEvents(true)
                .mergeRequestsEvents(true)
                .tagPushEvents(true)
                .noteEvents(true)
                .confidentialNoteEvents(true)
                .jobEvents(true)
                .pipelineEvents(true)
                .wikiPageEvents(true)
                .deploymentEvents(true)
                .featureFlagEvents(true)
                .releasesEvents(true)
                .milestoneEvents(true)
                .emojiEvents(true)
                .resourceAccessTokenEvents(true)
                .resourceDeployTokenEvents(true)
                .enableSslVerification(true)
                .token("token")
                .signingToken("signing_token")
                .pushEventsBranchFilter("push_events_branch_filter")
                .customWebhookTemplate("custom_webhook_template")
                .branchFilterStrategy(GitLabProjectProjectWebhooksUpdateBranchFilterStrategy.WILDCARD)
                .vulnerabilityEvents(true)
                .duoFlowCallbackEnabled(true)
                .urlVariables(List.of(ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdateUrlVariable()))
                .customHeaders(List.of(ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdateCustomHeader()))
                .build();
    }

    public static GitLabProjectProjectWebhooksUpdateUrlVariable projectProjectWebhooksUpdateUrlVariable() {
        return GitLabProjectProjectWebhooksUpdateUrlVariableBuilder.builder()
                .key("token")
                .value("123")
                .build();
    }

    public static GitLabProjectProjectWebhooksUpdateUrlVariablePayload
            projectProjectWebhooksUpdateUrlVariablePayload() {
        return GitLabProjectProjectWebhooksUpdateUrlVariablePayloadBuilder.builder()
                .value("value")
                .build();
    }
}
