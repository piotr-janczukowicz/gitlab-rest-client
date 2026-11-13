package io.github.piotr_janczukowicz.gitlab.api.codesuggestions;

import java.util.List;

public final class CodesuggestionsCatalogFixtures {

    private CodesuggestionsCatalogFixtures() {}

    public static GitLabCodeSuggestionsCreateCompletionContext codeSuggestionsCreateCompletionContext() {
        return GitLabCodeSuggestionsCreateCompletionContextBuilder.builder()
                .type(GitLabCodeSuggestionsCreateCompletionContextType.FILE)
                .name("name")
                .content("content")
                .build();
    }

    public static GitLabCodeSuggestionsCreateCompletionCurrentFile codeSuggestionsCreateCompletionCurrentFile() {
        return GitLabCodeSuggestionsCreateCompletionCurrentFileBuilder.builder()
                .fileName("file_name")
                .contentAboveCursor("content_above_cursor")
                .contentBelowCursor("content_below_cursor")
                .build();
    }

    public static GitLabCodeSuggestionsCreateCompletionPayload codeSuggestionsCreateCompletionPayload() {
        return GitLabCodeSuggestionsCreateCompletionPayloadBuilder.builder()
                .currentFile(CodesuggestionsCatalogFixtures.codeSuggestionsCreateCompletionCurrentFile())
                .intent(GitLabCodeSuggestionsCreateCompletionIntent.COMPLETION)
                .generationType(GitLabCodeSuggestionsCreateCompletionGenerationType.COMMENT)
                .stream(true)
                .projectPath("namespace/project")
                .userInstruction("user_instruction")
                .context(List.of(CodesuggestionsCatalogFixtures.codeSuggestionsCreateCompletionContext()))
                .build();
    }

    public static GitLabCodeSuggestionsDirectAccessPayload codeSuggestionsDirectAccessPayload() {
        return GitLabCodeSuggestionsDirectAccessPayloadBuilder.builder()
                .projectPath("namespace/project")
                .build();
    }

    public static GitLabCodeSuggestionsEnabledPayload codeSuggestionsEnabledPayload() {
        return GitLabCodeSuggestionsEnabledPayloadBuilder.builder()
                .projectPath("namespace/project")
                .build();
    }
}
