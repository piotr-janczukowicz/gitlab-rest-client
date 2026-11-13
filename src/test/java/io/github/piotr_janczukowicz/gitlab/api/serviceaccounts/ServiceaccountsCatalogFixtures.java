package io.github.piotr_janczukowicz.gitlab.api.serviceaccounts;

import java.time.LocalDate;
import java.util.List;

public final class ServiceaccountsCatalogFixtures {

    private ServiceaccountsCatalogFixtures() {}

    public static GitLabGroupServiceAccountsCreatePayload groupServiceAccountsCreatePayload() {
        return GitLabGroupServiceAccountsCreatePayloadBuilder.builder()
                .name("name")
                .username("username")
                .email("email")
                .build();
    }

    public static GitLabGroupServiceAccountsCreatePersonalAccessTokenPayload
            groupServiceAccountsCreatePersonalAccessTokenPayload() {
        return GitLabGroupServiceAccountsCreatePersonalAccessTokenPayloadBuilder.builder()
                .name("My token")
                .description("A token used for k8s")
                .expiresAt(LocalDate.parse("2026-01-01"))
                .scopes(List.of(GitLabGroupServiceAccountsCreatePersonalAccessTokenScopes.API))
                .build();
    }

    public static GitLabGroupServiceAccountsRotatePersonalAccessTokenPayload
            groupServiceAccountsRotatePersonalAccessTokenPayload() {
        return GitLabGroupServiceAccountsRotatePersonalAccessTokenPayloadBuilder.builder()
                .expiresAt(LocalDate.parse("2026-01-01"))
                .build();
    }

    public static GitLabGroupServiceAccountsUpdatePayload groupServiceAccountsUpdatePayload() {
        return GitLabGroupServiceAccountsUpdatePayloadBuilder.builder()
                .name("name")
                .username("username")
                .email("email")
                .build();
    }

    public static GitLabInstanceServiceAccountsCreatePayload instanceServiceAccountsCreatePayload() {
        return GitLabInstanceServiceAccountsCreatePayloadBuilder.builder()
                .name("name")
                .username("username")
                .email("email")
                .external(true)
                .build();
    }

    public static GitLabInstanceServiceAccountsUpdatePayload instanceServiceAccountsUpdatePayload() {
        return GitLabInstanceServiceAccountsUpdatePayloadBuilder.builder()
                .name("name")
                .username("username")
                .email("email")
                .external(true)
                .build();
    }

    public static GitLabProjectServiceAccountsCreatePayload projectServiceAccountsCreatePayload() {
        return GitLabProjectServiceAccountsCreatePayloadBuilder.builder()
                .name("name")
                .username("username")
                .email("email")
                .build();
    }

    public static GitLabProjectServiceAccountsCreatePersonalAccessTokenPayload
            projectServiceAccountsCreatePersonalAccessTokenPayload() {
        return GitLabProjectServiceAccountsCreatePersonalAccessTokenPayloadBuilder.builder()
                .name("My token")
                .description("A token used for k8s")
                .expiresAt(LocalDate.parse("2026-01-01"))
                .scopes(List.of(GitLabProjectServiceAccountsCreatePersonalAccessTokenScopes.API))
                .build();
    }

    public static GitLabProjectServiceAccountsRotatePersonalAccessTokenPayload
            projectServiceAccountsRotatePersonalAccessTokenPayload() {
        return GitLabProjectServiceAccountsRotatePersonalAccessTokenPayloadBuilder.builder()
                .expiresAt(LocalDate.parse("2026-01-01"))
                .build();
    }

    public static GitLabProjectServiceAccountsUpdatePayload projectServiceAccountsUpdatePayload() {
        return GitLabProjectServiceAccountsUpdatePayloadBuilder.builder()
                .name("name")
                .username("username")
                .email("email")
                .build();
    }

    public static GitLabServiceAccount serviceAccount() {
        return GitLabServiceAccountBuilder.builder()
                .id(1L)
                .username("admin")
                .publicEmail("john@example.com")
                .name("Administrator")
                .email("service_account@example.com")
                .unconfirmedEmail("updated_service_account@example.com")
                .external(true)
                .build();
    }
}
