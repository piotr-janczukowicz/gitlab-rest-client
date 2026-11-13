package io.github.piotr_janczukowicz.gitlab.api.projectwikis;

public final class ProjectwikisCatalogFixtures {

    private ProjectwikisCatalogFixtures() {}

    public static GitLabProjectProjectWikisCreateFrontMatter projectProjectWikisCreateFrontMatter() {
        return GitLabProjectProjectWikisCreateFrontMatterBuilder.builder()
                .title("title")
                .build();
    }

    public static GitLabProjectProjectWikisCreatePayload projectProjectWikisCreatePayload() {
        return GitLabProjectProjectWikisCreatePayloadBuilder.builder()
                .title("title")
                .frontMatter(ProjectwikisCatalogFixtures.projectProjectWikisCreateFrontMatter())
                .content("content")
                .format(GitLabProjectProjectWikisCreateFormat.MARKDOWN)
                .build();
    }

    public static GitLabProjectProjectWikisUpdateFrontMatter projectProjectWikisUpdateFrontMatter() {
        return GitLabProjectProjectWikisUpdateFrontMatterBuilder.builder()
                .title("title")
                .build();
    }

    public static GitLabProjectProjectWikisUpdatePayload projectProjectWikisUpdatePayload() {
        return GitLabProjectProjectWikisUpdatePayloadBuilder.builder()
                .title("title")
                .frontMatter(ProjectwikisCatalogFixtures.projectProjectWikisUpdateFrontMatter())
                .content("content")
                .format(GitLabProjectProjectWikisUpdateFormat.MARKDOWN)
                .build();
    }
}
