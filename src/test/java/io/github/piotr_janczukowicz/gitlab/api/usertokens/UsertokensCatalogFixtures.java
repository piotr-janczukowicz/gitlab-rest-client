package io.github.piotr_janczukowicz.gitlab.api.usertokens;

import java.time.LocalDate;
import java.util.List;

public final class UsertokensCatalogFixtures {

    private UsertokensCatalogFixtures() {}

    public static GitLabUserTokensCreateGranularScope userTokensCreateGranularScope() {
        return GitLabUserTokensCreateGranularScopeBuilder.builder()
                .access(GitLabUserTokensCreateGranularScopeAccess.PERSONAL_PROJECTS)
                .permissions(List.of("permissions"))
                .projectIds(List.of(1L))
                .groupIds(List.of(1L))
                .build();
    }

    public static GitLabUserTokensCreatePayload userTokensCreatePayload() {
        return GitLabUserTokensCreatePayloadBuilder.builder()
                .name("My token")
                .description("A token used for k8s")
                .expiresAt(LocalDate.parse("2026-01-01"))
                .scopes(List.of(GitLabUserTokensCreateScopes.API))
                .granularScopes(List.of(UsertokensCatalogFixtures.userTokensCreateGranularScope()))
                .build();
    }
}
