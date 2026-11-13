package io.github.piotr_janczukowicz.gitlab.api.saml;

public final class SamlCatalogFixtures {

    private SamlCatalogFixtures() {}

    public static GitLabGroupSAMLCreatePayload groupSAMLCreatePayload() {
        return GitLabGroupSAMLCreatePayloadBuilder.builder()
                .samlGroupName("saml_group_name")
                .accessLevel(GitLabGroupSAMLCreateAccessLevel.MINIMAL_ACCESS)
                .memberRoleId(1L)
                .provider("provider")
                .build();
    }
}
