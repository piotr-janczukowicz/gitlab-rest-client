package io.github.piotr_janczukowicz.gitlab.api.personalaccesstokens;

import java.time.LocalDate;
import java.util.List;

public final class PersonalaccesstokensCatalogFixtures {

    private PersonalaccesstokensCatalogFixtures() {}

    public static GitLabPersonalAccessTokenCreateGranularScope personalAccessTokenCreateGranularScope() {
        return GitLabPersonalAccessTokenCreateGranularScopeBuilder.builder()
                .access(GitLabPersonalAccessTokenCreateGranularScopeAccess.PERSONAL_PROJECTS)
                .permissions(List.of("permissions"))
                .projectIds(List.of(1L))
                .groupIds(List.of(1L))
                .build();
    }

    public static GitLabPersonalAccessTokenCreatePayload personalAccessTokenCreatePayload() {
        return GitLabPersonalAccessTokenCreatePayloadBuilder.builder()
                .name("My token")
                .description("A token used for k8s")
                .expiresAt(LocalDate.parse("2026-01-01"))
                .granularScopes(List.of(PersonalaccesstokensCatalogFixtures.personalAccessTokenCreateGranularScope()))
                .scopes(List.of(GitLabPersonalAccessTokenCreateScopes.K8S_PROXY))
                .build();
    }

    public static GitLabPersonalAccessTokensRotatePayload personalAccessTokensRotatePayload() {
        return GitLabPersonalAccessTokensRotatePayloadBuilder.builder()
                .expiresAt(LocalDate.parse("2026-01-01"))
                .build();
    }

    public static GitLabPersonalAccessTokensRotateSelfPayload personalAccessTokensRotateSelfPayload() {
        return GitLabPersonalAccessTokensRotateSelfPayloadBuilder.builder()
                .expiresAt(LocalDate.parse("2026-01-01"))
                .build();
    }
}
