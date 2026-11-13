package io.github.piotr_janczukowicz.gitlab.api.markdown;

public final class MarkdownCatalogFixtures {

    private MarkdownCatalogFixtures() {}

    public static GitLabMarkdown markdown() {
        return GitLabMarkdownBuilder.builder()
                .html("<p dir=\\\"auto\\\">Hello world!</p>\"")
                .build();
    }

    public static GitLabMarkdownCreatePayload markdownCreatePayload() {
        return GitLabMarkdownCreatePayloadBuilder.builder()
                .text("text")
                .gfm(true)
                .project("project")
                .build();
    }
}
