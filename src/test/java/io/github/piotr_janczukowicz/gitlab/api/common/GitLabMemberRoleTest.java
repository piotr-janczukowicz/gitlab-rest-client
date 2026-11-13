package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMemberRoleTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .id(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .groupId(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.groupId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .name(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .description(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBaseAccessLevelIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .baseAccessLevel(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.baseAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApplySecurityScanProfilesIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .applySecurityScanProfiles(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.applySecurityScanProfiles()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminMergeRequestIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .adminMergeRequest(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.adminMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchiveProjectIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .archiveProject(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.archiveProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchiveSubgroupIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .archiveSubgroup(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.archiveSubgroup()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminAiCatalogItemConsumerIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .adminAiCatalogItemConsumer(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.adminAiCatalogItemConsumer()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreateSecurityScanProfilesIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .createSecurityScanProfiles(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.createSecurityScanProfiles()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDestroyPackageIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .destroyPackage(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.destroyPackage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRemoveProjectIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .removeProject(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.removeProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeleteSecurityScanProfilesIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .deleteSecurityScanProfiles(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.deleteSecurityScanProfiles()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRemoveGroupIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .removeGroup(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.removeGroup()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenManageSecurityPolicyLinkIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .manageSecurityPolicyLink(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.manageSecurityPolicyLink()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminAiCatalogItemIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .adminAiCatalogItem(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.adminAiCatalogItem()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminComplianceFrameworkIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .adminComplianceFramework(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.adminComplianceFramework()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminCicdVariablesIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .adminCicdVariables(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.adminCicdVariables()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenManageDeployTokensIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .manageDeployTokens(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.manageDeployTokens()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenManageGroupAccessTokensIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .manageGroupAccessTokens(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.manageGroupAccessTokens()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminGroupMemberIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .adminGroupMember(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.adminGroupMember()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminIntegrationsIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .adminIntegrations(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.adminIntegrations()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenManageMergeRequestSettingsIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .manageMergeRequestSettings(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.manageMergeRequestSettings()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenManageProjectAccessTokensIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .manageProjectAccessTokens(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.manageProjectAccessTokens()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminProtectedBranchIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .adminProtectedBranch(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.adminProtectedBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminProtectedEnvironmentsIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .adminProtectedEnvironments(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.adminProtectedEnvironments()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminPushRulesIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .adminPushRules(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.adminPushRules()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminRunnersIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .adminRunners(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.adminRunners()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminSecurityAttributesIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .adminSecurityAttributes(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.adminSecurityAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminTerraformStateIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .adminTerraformState(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.adminTerraformState()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminVulnerabilityIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .adminVulnerability(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.adminVulnerability()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminWebHookIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .adminWebHook(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.adminWebHook()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPullContainerImageIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .pullContainerImage(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.pullContainerImage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushContainerImageIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .pushContainerImage(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.pushContainerImage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadAgentArtifactsIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .readAgentArtifacts(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.readAgentArtifacts()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadComplianceDashboardIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .readComplianceDashboard(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.readComplianceDashboard()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadSecurityScanProfilesIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .readSecurityScanProfiles(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.readSecurityScanProfiles()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadVirtualRegistryIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .readVirtualRegistry(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.readVirtualRegistry()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdateSecAiWorkflowSettingsIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .updateSecAiWorkflowSettings(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.updateSecAiWorkflowSettings()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdateSecurityScanProfilesIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .updateSecurityScanProfiles(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.updateSecurityScanProfiles()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadAdminCicdIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .readAdminCicd(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.readAdminCicd()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadCrmContactIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .readCrmContact(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.readCrmContact()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadDependencyIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .readDependency(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.readDependency()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadAdminGroupsIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .readAdminGroups(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.readAdminGroups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadAdminProjectsIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .readAdminProjects(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.readAdminProjects()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadCodeIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .readCode(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.readCode()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadRunnersIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .readRunners(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.readRunners()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadSecurityAttributeIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .readSecurityAttribute(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.readSecurityAttribute()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadAdminSubscriptionIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .readAdminSubscription(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.readAdminSubscription()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadAdminMonitoringIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .readAdminMonitoring(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.readAdminMonitoring()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadAdminUsersIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .readAdminUsers(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.readAdminUsers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadVulnerabilityIsNullable() {
        final GitLabMemberRoleBuilder builder = GitLabMemberRoleBuilder.builder(CommonCatalogFixtures.memberRole())
                .readVulnerability(null);

        final GitLabMemberRole built = builder.build();

        assertThat(built.readVulnerability()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMemberRole value = CommonCatalogFixtures.memberRole();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.groupId()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("Custom guest");
            softly.assertThat(value.description()).isEqualTo("Guest user who can also read_code");
            softly.assertThat(value.baseAccessLevel()).isEqualTo(GitLabMemberRoleBaseAccessLevel.MINIMAL_ACCESS);
            softly.assertThat(value.applySecurityScanProfiles()).isEqualTo(true);
            softly.assertThat(value.adminMergeRequest()).isEqualTo(true);
            softly.assertThat(value.archiveProject()).isEqualTo(true);
            softly.assertThat(value.archiveSubgroup()).isEqualTo(true);
            softly.assertThat(value.adminAiCatalogItemConsumer()).isEqualTo(true);
            softly.assertThat(value.createSecurityScanProfiles()).isEqualTo(true);
            softly.assertThat(value.destroyPackage()).isEqualTo(true);
            softly.assertThat(value.removeProject()).isEqualTo(true);
            softly.assertThat(value.deleteSecurityScanProfiles()).isEqualTo(true);
            softly.assertThat(value.removeGroup()).isEqualTo(true);
            softly.assertThat(value.manageSecurityPolicyLink()).isEqualTo(true);
            softly.assertThat(value.adminAiCatalogItem()).isEqualTo(true);
            softly.assertThat(value.adminComplianceFramework()).isEqualTo(true);
            softly.assertThat(value.adminCicdVariables()).isEqualTo(true);
            softly.assertThat(value.manageDeployTokens()).isEqualTo(true);
            softly.assertThat(value.manageGroupAccessTokens()).isEqualTo(true);
            softly.assertThat(value.adminGroupMember()).isEqualTo(true);
            softly.assertThat(value.adminIntegrations()).isEqualTo(true);
            softly.assertThat(value.manageMergeRequestSettings()).isEqualTo(true);
            softly.assertThat(value.manageProjectAccessTokens()).isEqualTo(true);
            softly.assertThat(value.adminProtectedBranch()).isEqualTo(true);
            softly.assertThat(value.adminProtectedEnvironments()).isEqualTo(true);
            softly.assertThat(value.adminPushRules()).isEqualTo(true);
            softly.assertThat(value.adminRunners()).isEqualTo(true);
            softly.assertThat(value.adminSecurityAttributes()).isEqualTo(true);
            softly.assertThat(value.adminTerraformState()).isEqualTo(true);
            softly.assertThat(value.adminVulnerability()).isEqualTo(true);
            softly.assertThat(value.adminWebHook()).isEqualTo(true);
            softly.assertThat(value.pullContainerImage()).isEqualTo(true);
            softly.assertThat(value.pushContainerImage()).isEqualTo(true);
            softly.assertThat(value.readAgentArtifacts()).isEqualTo(true);
            softly.assertThat(value.readComplianceDashboard()).isEqualTo(true);
            softly.assertThat(value.readSecurityScanProfiles()).isEqualTo(true);
            softly.assertThat(value.readVirtualRegistry()).isEqualTo(true);
            softly.assertThat(value.updateSecAiWorkflowSettings()).isEqualTo(true);
            softly.assertThat(value.updateSecurityScanProfiles()).isEqualTo(true);
            softly.assertThat(value.readAdminCicd()).isEqualTo(true);
            softly.assertThat(value.readCrmContact()).isEqualTo(true);
            softly.assertThat(value.readDependency()).isEqualTo(true);
            softly.assertThat(value.readAdminGroups()).isEqualTo(true);
            softly.assertThat(value.readAdminProjects()).isEqualTo(true);
            softly.assertThat(value.readCode()).isEqualTo(true);
            softly.assertThat(value.readRunners()).isEqualTo(true);
            softly.assertThat(value.readSecurityAttribute()).isEqualTo(true);
            softly.assertThat(value.readAdminSubscription()).isEqualTo(true);
            softly.assertThat(value.readAdminMonitoring()).isEqualTo(true);
            softly.assertThat(value.readAdminUsers()).isEqualTo(true);
            softly.assertThat(value.readVulnerability()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMemberRole original = CommonCatalogFixtures.memberRole();

        final GitLabMemberRole rebuilt =
                GitLabMemberRoleBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMemberRole.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "groupId",
                        "name",
                        "description",
                        "baseAccessLevel",
                        "applySecurityScanProfiles",
                        "adminMergeRequest",
                        "archiveProject",
                        "archiveSubgroup",
                        "adminAiCatalogItemConsumer",
                        "createSecurityScanProfiles",
                        "destroyPackage",
                        "removeProject",
                        "deleteSecurityScanProfiles",
                        "removeGroup",
                        "manageSecurityPolicyLink",
                        "adminAiCatalogItem",
                        "adminComplianceFramework",
                        "adminCicdVariables",
                        "manageDeployTokens",
                        "manageGroupAccessTokens",
                        "adminGroupMember",
                        "adminIntegrations",
                        "manageMergeRequestSettings",
                        "manageProjectAccessTokens",
                        "adminProtectedBranch",
                        "adminProtectedEnvironments",
                        "adminPushRules",
                        "adminRunners",
                        "adminSecurityAttributes",
                        "adminTerraformState",
                        "adminVulnerability",
                        "adminWebHook",
                        "pullContainerImage",
                        "pushContainerImage",
                        "readAgentArtifacts",
                        "readComplianceDashboard",
                        "readSecurityScanProfiles",
                        "readVirtualRegistry",
                        "updateSecAiWorkflowSettings",
                        "updateSecurityScanProfiles",
                        "readAdminCicd",
                        "readCrmContact",
                        "readDependency",
                        "readAdminGroups",
                        "readAdminProjects",
                        "readCode",
                        "readRunners",
                        "readSecurityAttribute",
                        "readAdminSubscription",
                        "readAdminMonitoring",
                        "readAdminUsers",
                        "readVulnerability");
    }
}
