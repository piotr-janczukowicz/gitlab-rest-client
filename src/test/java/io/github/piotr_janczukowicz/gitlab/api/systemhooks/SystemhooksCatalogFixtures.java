package io.github.piotr_janczukowicz.gitlab.api.systemhooks;

import java.time.Instant;
import java.util.List;
import java.util.Map;

public final class SystemhooksCatalogFixtures {

    private SystemhooksCatalogFixtures() {}

    public static GitLabHook hook() {
        return GitLabHookBuilder.builder()
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
                .build();
    }

    public static GitLabSystemHooksCreateCustomHeader systemHooksCreateCustomHeader() {
        return GitLabSystemHooksCreateCustomHeaderBuilder.builder()
                .key("X-Custom-Header")
                .value("value")
                .build();
    }

    public static GitLabSystemHooksCreatePayload systemHooksCreatePayload() {
        return GitLabSystemHooksCreatePayloadBuilder.builder()
                .url("http://example.com/hook")
                .name("name")
                .description("description")
                .token("token")
                .signingToken("signing_token")
                .pushEvents(true)
                .tagPushEvents(true)
                .mergeRequestsEvents(true)
                .repositoryUpdateEvents(true)
                .enableSslVerification(true)
                .pushEventsBranchFilter("push_events_branch_filter")
                .branchFilterStrategy(GitLabSystemHooksCreateBranchFilterStrategy.WILDCARD)
                .customWebhookTemplate("custom_webhook_template")
                .urlVariables(List.of(SystemhooksCatalogFixtures.systemHooksCreateUrlVariable()))
                .customHeaders(List.of(SystemhooksCatalogFixtures.systemHooksCreateCustomHeader()))
                .build();
    }

    public static GitLabSystemHooksCreateUrlVariable systemHooksCreateUrlVariable() {
        return GitLabSystemHooksCreateUrlVariableBuilder.builder()
                .key("token")
                .value("123")
                .build();
    }

    public static GitLabSystemHooksUpdateCustomHeader systemHooksUpdateCustomHeader() {
        return GitLabSystemHooksUpdateCustomHeaderBuilder.builder()
                .key("X-Custom-Header")
                .value("value")
                .build();
    }

    public static GitLabSystemHooksUpdateCustomHeaderPayload systemHooksUpdateCustomHeaderPayload() {
        return GitLabSystemHooksUpdateCustomHeaderPayloadBuilder.builder()
                .value("value")
                .build();
    }

    public static GitLabSystemHooksUpdatePayload systemHooksUpdatePayload() {
        return GitLabSystemHooksUpdatePayloadBuilder.builder()
                .url("url")
                .name("name")
                .description("description")
                .token("token")
                .signingToken("signing_token")
                .pushEvents(true)
                .tagPushEvents(true)
                .mergeRequestsEvents(true)
                .repositoryUpdateEvents(true)
                .enableSslVerification(true)
                .pushEventsBranchFilter("push_events_branch_filter")
                .branchFilterStrategy(GitLabSystemHooksUpdateBranchFilterStrategy.WILDCARD)
                .customWebhookTemplate("custom_webhook_template")
                .urlVariables(List.of(SystemhooksCatalogFixtures.systemHooksUpdateUrlVariable()))
                .customHeaders(List.of(SystemhooksCatalogFixtures.systemHooksUpdateCustomHeader()))
                .build();
    }

    public static GitLabSystemHooksUpdateUrlVariable systemHooksUpdateUrlVariable() {
        return GitLabSystemHooksUpdateUrlVariableBuilder.builder()
                .key("token")
                .value("123")
                .build();
    }

    public static GitLabSystemHooksUpdateUrlVariablePayload systemHooksUpdateUrlVariablePayload() {
        return GitLabSystemHooksUpdateUrlVariablePayloadBuilder.builder()
                .value("value")
                .build();
    }
}
