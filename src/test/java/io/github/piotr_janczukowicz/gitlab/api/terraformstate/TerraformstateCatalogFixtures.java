package io.github.piotr_janczukowicz.gitlab.api.terraformstate;

public final class TerraformstateCatalogFixtures {

    private TerraformstateCatalogFixtures() {}

    public static GitLabProjectTerraformStateCreateStateLockPayload projectTerraformStateCreateStateLockPayload() {
        return GitLabProjectTerraformStateCreateStateLockPayloadBuilder.builder()
                .id("ID")
                .operation("Operation")
                .info("Info")
                .who("Who")
                .version("Version")
                .created("Created")
                .path("Path")
                .build();
    }

    public static GitLabProjectTerraformStateRuleCreatePayload projectTerraformStateRuleCreatePayload() {
        return GitLabProjectTerraformStateRuleCreatePayloadBuilder.builder()
                .stateName("state_name")
                .minimumAccessLevelForWrite(GitLabProjectTerraformStateRuleCreateMinimumAccessLevelForWrite.DEVELOPER)
                .allowedFrom(GitLabProjectTerraformStateRuleCreateAllowedFrom.ANYWHERE)
                .build();
    }

    public static GitLabProjectTerraformStateRuleUpdatePayload projectTerraformStateRuleUpdatePayload() {
        return GitLabProjectTerraformStateRuleUpdatePayloadBuilder.builder()
                .stateName("state_name")
                .minimumAccessLevelForWrite(GitLabProjectTerraformStateRuleUpdateMinimumAccessLevelForWrite.DEVELOPER)
                .allowedFrom(GitLabProjectTerraformStateRuleUpdateAllowedFrom.ANYWHERE)
                .build();
    }

    public static GitLabTerraformStateProtectionRule terraformStateProtectionRule() {
        return GitLabTerraformStateProtectionRuleBuilder.builder()
                .id(1L)
                .projectId(1L)
                .stateName("production")
                .minimumAccessLevelForWrite("maintainer")
                .allowedFrom("ci_only")
                .build();
    }
}
