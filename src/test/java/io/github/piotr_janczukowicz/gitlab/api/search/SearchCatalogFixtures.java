package io.github.piotr_janczukowicz.gitlab.api.search;

import java.util.List;

public final class SearchCatalogFixtures {

    private SearchCatalogFixtures() {}

    public static GitLabAiSemanticCodeGroupedResult aiSemanticCodeGroupedResult() {
        return GitLabAiSemanticCodeGroupedResultBuilder.builder()
                .path("app/models/user.rb")
                .blobId("abc123def456")
                .fileUrl("https://gitlab.com/group/project/-/blob/main/user.rb")
                .score(1.5)
                .snippetRanges(List.of(SearchCatalogFixtures.aiSemanticCodeSnippetRange()))
                .build();
    }

    public static GitLabAiSemanticCodeResponse aiSemanticCodeResponse() {
        return GitLabAiSemanticCodeResponseBuilder.builder()
                .confidence("high")
                .results(List.of(SearchCatalogFixtures.aiSemanticCodeGroupedResult()))
                .build();
    }

    public static GitLabAiSemanticCodeSnippetRange aiSemanticCodeSnippetRange() {
        return GitLabAiSemanticCodeSnippetRangeBuilder.builder()
                .startLine(1)
                .endLine(1)
                .content("def authenticate\n  ...\nend")
                .score(1.5)
                .build();
    }
}
