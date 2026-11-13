package io.github.piotr_janczukowicz.gitlab.api.userapplications;

public final class UserapplicationsCatalogFixtures {

    private UserapplicationsCatalogFixtures() {}

    public static GitLabUserApplicationsCreatePayload userApplicationsCreatePayload() {
        return GitLabUserApplicationsCreatePayloadBuilder.builder()
                .name("MyApplication")
                .redirectUri("https://redirect.uri")
                .scopes("scopes")
                .confidential(true)
                .build();
    }

    public static GitLabUserApplicationsUpdatePayload userApplicationsUpdatePayload() {
        return GitLabUserApplicationsUpdatePayloadBuilder.builder()
                .name("name")
                .scopes("scopes")
                .build();
    }
}
