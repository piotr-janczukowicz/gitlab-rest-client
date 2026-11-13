package io.github.piotr_janczukowicz.gitlab.api.debianpackages;

public final class DebianpackagesCatalogFixtures {

    private DebianpackagesCatalogFixtures() {}

    public static GitLabProjectDebianPackagesAuthorizePayload projectDebianPackagesAuthorizePayload() {
        return GitLabProjectDebianPackagesAuthorizePayloadBuilder.builder()
                .distribution("distribution")
                .component("component")
                .build();
    }
}
