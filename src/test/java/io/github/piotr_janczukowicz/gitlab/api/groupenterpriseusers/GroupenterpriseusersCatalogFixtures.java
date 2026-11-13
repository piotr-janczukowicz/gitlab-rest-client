package io.github.piotr_janczukowicz.gitlab.api.groupenterpriseusers;

public final class GroupenterpriseusersCatalogFixtures {

    private GroupenterpriseusersCatalogFixtures() {}

    public static GitLabGroupGroupEnterpriseUsersUpdatePayload groupGroupEnterpriseUsersUpdatePayload() {
        return GitLabGroupGroupEnterpriseUsersUpdatePayloadBuilder.builder()
                .name("name")
                .email("email")
                .projectsLimit(1)
                .canCreateGroup(true)
                .build();
    }
}
