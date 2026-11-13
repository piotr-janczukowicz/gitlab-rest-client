package io.github.piotr_janczukowicz.gitlab.api.emojireactions;

public final class EmojireactionsCatalogFixtures {

    private EmojireactionsCatalogFixtures() {}

    public static GitLabProjectEmojiReactionsCreateIssuesAwardEmojiPayload
            projectEmojiReactionsCreateIssuesAwardEmojiPayload() {
        return GitLabProjectEmojiReactionsCreateIssuesAwardEmojiPayloadBuilder.builder()
                .name("name")
                .build();
    }

    public static GitLabProjectEmojiReactionsCreateIssuesNotesAwardEmojiPayload
            projectEmojiReactionsCreateIssuesNotesAwardEmojiPayload() {
        return GitLabProjectEmojiReactionsCreateIssuesNotesAwardEmojiPayloadBuilder.builder()
                .name("name")
                .build();
    }

    public static GitLabProjectEmojiReactionsCreateRequestsAwardEmojiPayload
            projectEmojiReactionsCreateRequestsAwardEmojiPayload() {
        return GitLabProjectEmojiReactionsCreateRequestsAwardEmojiPayloadBuilder.builder()
                .name("name")
                .build();
    }

    public static GitLabProjectEmojiReactionsCreateRequestsNotesAwardEmojiPayload
            projectEmojiReactionsCreateRequestsNotesAwardEmojiPayload() {
        return GitLabProjectEmojiReactionsCreateRequestsNotesAwardEmojiPayloadBuilder.builder()
                .name("name")
                .build();
    }

    public static GitLabProjectEmojiReactionsCreateSnippetsAwardEmojiPayload
            projectEmojiReactionsCreateSnippetsAwardEmojiPayload() {
        return GitLabProjectEmojiReactionsCreateSnippetsAwardEmojiPayloadBuilder.builder()
                .name("name")
                .build();
    }

    public static GitLabProjectEmojiReactionsCreateSnippetsNotesAwardEmojiPayload
            projectEmojiReactionsCreateSnippetsNotesAwardEmojiPayload() {
        return GitLabProjectEmojiReactionsCreateSnippetsNotesAwardEmojiPayloadBuilder.builder()
                .name("name")
                .build();
    }
}
