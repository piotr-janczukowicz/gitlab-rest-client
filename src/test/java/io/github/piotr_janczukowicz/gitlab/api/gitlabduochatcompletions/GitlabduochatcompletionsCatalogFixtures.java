package io.github.piotr_janczukowicz.gitlab.api.gitlabduochatcompletions;

import java.util.List;
import java.util.Map;

public final class GitlabduochatcompletionsCatalogFixtures {

    private GitlabduochatcompletionsCatalogFixtures() {}

    public static GitLabDuoChatCompletionsCreateAdditionalContext duoChatCompletionsCreateAdditionalContext() {
        return GitLabDuoChatCompletionsCreateAdditionalContextBuilder.builder()
                .category(GitLabDuoChatCompletionsCreateAdditionalContextCategory.FILE)
                .id("id")
                .content("content")
                .metadata(Map.of("key", "value"))
                .build();
    }

    public static GitLabDuoChatCompletionsCreateCurrentFile duoChatCompletionsCreateCurrentFile() {
        return GitLabDuoChatCompletionsCreateCurrentFileBuilder.builder()
                .fileName("file_name")
                .contentAboveCursor("content_above_cursor")
                .contentBelowCursor("content_below_cursor")
                .selectedText("selected_text")
                .build();
    }

    public static GitLabDuoChatCompletionsCreatePayload duoChatCompletionsCreatePayload() {
        return GitLabDuoChatCompletionsCreatePayloadBuilder.builder()
                .content("content")
                .resourceType(GitLabDuoChatCompletionsCreateResourceType.ISSUE)
                .resourceId("text")
                .refererUrl("referer_url")
                .clientSubscriptionId("client_subscription_id")
                .withCleanHistory(true)
                .projectId(1L)
                .currentFile(GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreateCurrentFile())
                .additionalContext(
                        List.of(GitlabduochatcompletionsCatalogFixtures.duoChatCompletionsCreateAdditionalContext()))
                .build();
    }
}
