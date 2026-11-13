package io.github.piotr_janczukowicz.gitlab.api.suggestions;

import java.util.List;

public final class SuggestionsCatalogFixtures {

    private SuggestionsCatalogFixtures() {}

    public static GitLabSuggestionsApplyPayload suggestionsApplyPayload() {
        return GitLabSuggestionsApplyPayloadBuilder.builder()
                .commitMessage("commit_message")
                .build();
    }

    public static GitLabSuggestionsBatchApplyPayload suggestionsBatchApplyPayload() {
        return GitLabSuggestionsBatchApplyPayloadBuilder.builder()
                .ids(List.of(1))
                .commitMessage("commit_message")
                .build();
    }
}
