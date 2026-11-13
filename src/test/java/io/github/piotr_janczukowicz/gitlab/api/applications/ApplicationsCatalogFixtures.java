package io.github.piotr_janczukowicz.gitlab.api.applications;

import java.util.List;

public final class ApplicationsCatalogFixtures {

    private ApplicationsCatalogFixtures() {}

    public static GitLabApplicationsCreateGranularScope applicationsCreateGranularScope() {
        return GitLabApplicationsCreateGranularScopeBuilder.builder()
                .access(GitLabApplicationsCreateGranularScopeAccess.PERSONAL_PROJECTS)
                .permissions(List.of("permissions"))
                .projectIds(List.of(1L))
                .groupIds(List.of(1L))
                .build();
    }

    public static GitLabApplicationsCreatePayload applicationsCreatePayload() {
        return GitLabApplicationsCreatePayloadBuilder.builder()
                .name("MyApplication")
                .redirectUri("https://redirect.uri")
                .scopes("scopes")
                .confidential(true)
                .granularScopes(List.of(ApplicationsCatalogFixtures.applicationsCreateGranularScope()))
                .build();
    }
}
