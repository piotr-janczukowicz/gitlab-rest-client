package io.github.piotr_janczukowicz.gitlab.api.groupwikis;

public final class GroupwikisCatalogFixtures {

    private GroupwikisCatalogFixtures() {}

    public static GitLabGroupGroupWikisCreateFrontMatter groupGroupWikisCreateFrontMatter() {
        return GitLabGroupGroupWikisCreateFrontMatterBuilder.builder()
                .title("title")
                .build();
    }

    public static GitLabGroupGroupWikisCreatePayload groupGroupWikisCreatePayload() {
        return GitLabGroupGroupWikisCreatePayloadBuilder.builder()
                .title("title")
                .frontMatter(GroupwikisCatalogFixtures.groupGroupWikisCreateFrontMatter())
                .content("content")
                .format(GitLabGroupGroupWikisCreateFormat.MARKDOWN)
                .build();
    }

    public static GitLabGroupGroupWikisUpdateFrontMatter groupGroupWikisUpdateFrontMatter() {
        return GitLabGroupGroupWikisUpdateFrontMatterBuilder.builder()
                .title("title")
                .build();
    }

    public static GitLabGroupGroupWikisUpdatePayload groupGroupWikisUpdatePayload() {
        return GitLabGroupGroupWikisUpdatePayloadBuilder.builder()
                .title("title")
                .frontMatter(GroupwikisCatalogFixtures.groupGroupWikisUpdateFrontMatter())
                .content("content")
                .format(GitLabGroupGroupWikisUpdateFormat.MARKDOWN)
                .build();
    }
}
