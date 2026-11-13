package io.github.piotr_janczukowicz.gitlab.api.projectforks;

public final class ProjectforksCatalogFixtures {

    private ProjectforksCatalogFixtures() {}

    public static GitLabProjectProjectForksCreatePayload projectProjectForksCreatePayload() {
        return GitLabProjectProjectForksCreatePayloadBuilder.builder()
                .namespace("gitlab")
                .namespaceId(1L)
                .namespacePath("new_path/gitlab")
                .path("fork")
                .name("Fork")
                .description("Description")
                .visibility(GitLabProjectProjectForksCreateVisibility.PRIVATE)
                .mrDefaultTargetSelf(true)
                .branches("branches")
                .build();
    }
}
