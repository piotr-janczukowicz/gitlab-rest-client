package io.github.piotr_janczukowicz.gitlab.api.projectcicdjobtokenscope;

public final class ProjectcicdjobtokenscopeCatalogFixtures {

    private ProjectcicdjobtokenscopeCatalogFixtures() {}

    public static GitLabGroupScopeLink groupScopeLink() {
        return GitLabGroupScopeLinkBuilder.builder()
                .sourceProjectId(1L)
                .targetGroupId(1L)
                .build();
    }

    public static GitLabProjectJobTokenScope projectJobTokenScope() {
        return GitLabProjectJobTokenScopeBuilder.builder()
                .inboundEnabled(true)
                .outboundEnabled(true)
                .build();
    }

    public static GitLabProjectProjectCICDJobTokenScopeCreateAllowlistPayload
            projectProjectCICDJobTokenScopeCreateAllowlistPayload() {
        return GitLabProjectProjectCICDJobTokenScopeCreateAllowlistPayloadBuilder.builder()
                .targetProjectId(1L)
                .build();
    }

    public static GitLabProjectProjectCICDJobTokenScopeCreateGroupsAllowlistPayload
            projectProjectCICDJobTokenScopeCreateGroupsAllowlistPayload() {
        return GitLabProjectProjectCICDJobTokenScopeCreateGroupsAllowlistPayloadBuilder.builder()
                .targetGroupId(1L)
                .build();
    }

    public static GitLabProjectProjectCICDJobTokenScopeUpdatePayload projectProjectCICDJobTokenScopeUpdatePayload() {
        return GitLabProjectProjectCICDJobTokenScopeUpdatePayloadBuilder.builder()
                .enabled(true)
                .build();
    }

    public static GitLabProjectScopeLink projectScopeLink() {
        return GitLabProjectScopeLinkBuilder.builder()
                .sourceProjectId(1L)
                .targetProjectId(1L)
                .build();
    }
}
