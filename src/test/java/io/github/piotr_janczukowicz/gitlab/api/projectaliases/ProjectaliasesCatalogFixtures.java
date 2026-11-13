package io.github.piotr_janczukowicz.gitlab.api.projectaliases;

public final class ProjectaliasesCatalogFixtures {

    private ProjectaliasesCatalogFixtures() {}

    public static GitLabProjectAlias projectAlias() {
        return GitLabProjectAliasBuilder.builder()
                .id(1L)
                .projectId(1L)
                .name("gitlab")
                .build();
    }

    public static GitLabProjectAliasesCreatePayload projectAliasesCreatePayload() {
        return GitLabProjectAliasesCreatePayloadBuilder.builder()
                .projectId("gitlab-org/gitlab")
                .name("gitlab")
                .build();
    }
}
