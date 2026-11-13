package io.github.piotr_janczukowicz.gitlab.api.groupwebhooks;

import java.time.Instant;
import java.util.List;
import java.util.Map;

public final class GroupwebhooksCatalogFixtures {

    private GroupwebhooksCatalogFixtures() {}

    public static GitLabGroupGroupWebhooksCreateCustomHeader groupGroupWebhooksCreateCustomHeader() {
        return GitLabGroupGroupWebhooksCreateCustomHeaderBuilder.builder()
                .key("X-Custom-Header")
                .value("value")
                .build();
    }

    public static GitLabGroupGroupWebhooksCreatePayload groupGroupWebhooksCreatePayload() {
        return GitLabGroupGroupWebhooksCreatePayloadBuilder.builder()
                .url("http://example.com/hook")
                .name("name")
                .description("description")
                .pushEvents(true)
                .pushEventsBranchFilter("push_events_branch_filter")
                .issuesEvents(true)
                .confidentialIssuesEvents(true)
                .mergeRequestsEvents(true)
                .tagPushEvents(true)
                .noteEvents(true)
                .confidentialNoteEvents(true)
                .jobEvents(true)
                .pipelineEvents(true)
                .projectEvents(true)
                .wikiPageEvents(true)
                .deploymentEvents(true)
                .featureFlagEvents(true)
                .releasesEvents(true)
                .milestoneEvents(true)
                .subgroupEvents(true)
                .emojiEvents(true)
                .resourceAccessTokenEvents(true)
                .memberEvents(true)
                .vulnerabilityEvents(true)
                .enableSslVerification(true)
                .token("token")
                .signingToken("signing_token")
                .customWebhookTemplate("custom_webhook_template")
                .branchFilterStrategy(GitLabGroupGroupWebhooksCreateBranchFilterStrategy.WILDCARD)
                .duoFlowCallbackEnabled(true)
                .urlVariables(List.of(GroupwebhooksCatalogFixtures.groupGroupWebhooksCreateUrlVariable()))
                .customHeaders(List.of(GroupwebhooksCatalogFixtures.groupGroupWebhooksCreateCustomHeader()))
                .build();
    }

    public static GitLabGroupGroupWebhooksCreateUrlVariable groupGroupWebhooksCreateUrlVariable() {
        return GitLabGroupGroupWebhooksCreateUrlVariableBuilder.builder()
                .key("token")
                .value("123")
                .build();
    }

    public static GitLabGroupGroupWebhooksUpdateCustomHeader groupGroupWebhooksUpdateCustomHeader() {
        return GitLabGroupGroupWebhooksUpdateCustomHeaderBuilder.builder()
                .key("X-Custom-Header")
                .value("value")
                .build();
    }

    public static GitLabGroupGroupWebhooksUpdateCustomHeaderPayload groupGroupWebhooksUpdateCustomHeaderPayload() {
        return GitLabGroupGroupWebhooksUpdateCustomHeaderPayloadBuilder.builder()
                .value("value")
                .build();
    }

    public static GitLabGroupGroupWebhooksUpdatePayload groupGroupWebhooksUpdatePayload() {
        return GitLabGroupGroupWebhooksUpdatePayloadBuilder.builder()
                .url("url")
                .name("name")
                .description("description")
                .pushEvents(true)
                .pushEventsBranchFilter("push_events_branch_filter")
                .issuesEvents(true)
                .confidentialIssuesEvents(true)
                .mergeRequestsEvents(true)
                .tagPushEvents(true)
                .noteEvents(true)
                .confidentialNoteEvents(true)
                .jobEvents(true)
                .pipelineEvents(true)
                .projectEvents(true)
                .wikiPageEvents(true)
                .deploymentEvents(true)
                .featureFlagEvents(true)
                .releasesEvents(true)
                .milestoneEvents(true)
                .subgroupEvents(true)
                .emojiEvents(true)
                .resourceAccessTokenEvents(true)
                .memberEvents(true)
                .vulnerabilityEvents(true)
                .enableSslVerification(true)
                .token("token")
                .signingToken("signing_token")
                .customWebhookTemplate("custom_webhook_template")
                .branchFilterStrategy(GitLabGroupGroupWebhooksUpdateBranchFilterStrategy.WILDCARD)
                .duoFlowCallbackEnabled(true)
                .urlVariables(List.of(GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdateUrlVariable()))
                .customHeaders(List.of(GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdateCustomHeader()))
                .build();
    }

    public static GitLabGroupGroupWebhooksUpdateUrlVariable groupGroupWebhooksUpdateUrlVariable() {
        return GitLabGroupGroupWebhooksUpdateUrlVariableBuilder.builder()
                .key("token")
                .value("123")
                .build();
    }

    public static GitLabGroupGroupWebhooksUpdateUrlVariablePayload groupGroupWebhooksUpdateUrlVariablePayload() {
        return GitLabGroupGroupWebhooksUpdateUrlVariablePayloadBuilder.builder()
                .value("value")
                .build();
    }

    public static GitLabGroupHook groupHook() {
        return GitLabGroupHookBuilder.builder()
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
                .groupId(1L)
                .issuesEvents(true)
                .confidentialIssuesEvents(true)
                .noteEvents(true)
                .confidentialNoteEvents(true)
                .pipelineEvents(true)
                .wikiPageEvents(true)
                .jobEvents(true)
                .deploymentEvents(true)
                .featureFlagEvents(true)
                .releasesEvents(true)
                .milestoneEvents(true)
                .subgroupEvents(true)
                .emojiEvents(true)
                .resourceAccessTokenEvents(true)
                .memberEvents(true)
                .vulnerabilityEvents(true)
                .projectEvents(true)
                .duoFlowCallbackEnabled(true)
                .build();
    }
}
