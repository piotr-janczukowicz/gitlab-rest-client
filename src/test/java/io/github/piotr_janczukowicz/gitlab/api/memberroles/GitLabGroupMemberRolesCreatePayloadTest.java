package io.github.piotr_janczukowicz.gitlab.api.memberroles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupMemberRolesCreatePayloadTest {

    @Test
    void constructor_shouldRefuseNull_whenBaseAccessLevelIsNull() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .baseAccessLevel(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("baseAccessLevel");
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .name(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .description(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApplySecurityScanProfilesIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .applySecurityScanProfiles(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.applySecurityScanProfiles()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminMergeRequestIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .adminMergeRequest(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.adminMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchiveProjectIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .archiveProject(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.archiveProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchiveSubgroupIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .archiveSubgroup(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.archiveSubgroup()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminAiCatalogItemConsumerIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .adminAiCatalogItemConsumer(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.adminAiCatalogItemConsumer()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreateSecurityScanProfilesIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .createSecurityScanProfiles(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.createSecurityScanProfiles()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDestroyPackageIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .destroyPackage(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.destroyPackage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRemoveProjectIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .removeProject(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.removeProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeleteSecurityScanProfilesIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .deleteSecurityScanProfiles(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.deleteSecurityScanProfiles()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRemoveGroupIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .removeGroup(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.removeGroup()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenManageSecurityPolicyLinkIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .manageSecurityPolicyLink(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.manageSecurityPolicyLink()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminAiCatalogItemIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .adminAiCatalogItem(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.adminAiCatalogItem()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminComplianceFrameworkIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .adminComplianceFramework(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.adminComplianceFramework()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminCicdVariablesIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .adminCicdVariables(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.adminCicdVariables()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenManageDeployTokensIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .manageDeployTokens(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.manageDeployTokens()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenManageGroupAccessTokensIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .manageGroupAccessTokens(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.manageGroupAccessTokens()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminGroupMemberIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .adminGroupMember(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.adminGroupMember()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminIntegrationsIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .adminIntegrations(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.adminIntegrations()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenManageMergeRequestSettingsIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .manageMergeRequestSettings(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.manageMergeRequestSettings()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenManageProjectAccessTokensIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .manageProjectAccessTokens(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.manageProjectAccessTokens()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminProtectedBranchIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .adminProtectedBranch(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.adminProtectedBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminProtectedEnvironmentsIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .adminProtectedEnvironments(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.adminProtectedEnvironments()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminPushRulesIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .adminPushRules(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.adminPushRules()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminRunnersIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .adminRunners(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.adminRunners()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminSecurityAttributesIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .adminSecurityAttributes(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.adminSecurityAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminTerraformStateIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .adminTerraformState(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.adminTerraformState()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminVulnerabilityIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .adminVulnerability(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.adminVulnerability()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminWebHookIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .adminWebHook(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.adminWebHook()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPullContainerImageIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .pullContainerImage(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.pullContainerImage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushContainerImageIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .pushContainerImage(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.pushContainerImage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadAgentArtifactsIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .readAgentArtifacts(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.readAgentArtifacts()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadComplianceDashboardIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .readComplianceDashboard(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.readComplianceDashboard()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadSecurityScanProfilesIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .readSecurityScanProfiles(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.readSecurityScanProfiles()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadVirtualRegistryIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .readVirtualRegistry(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.readVirtualRegistry()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdateSecAiWorkflowSettingsIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .updateSecAiWorkflowSettings(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.updateSecAiWorkflowSettings()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdateSecurityScanProfilesIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .updateSecurityScanProfiles(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.updateSecurityScanProfiles()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadAdminCicdIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .readAdminCicd(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.readAdminCicd()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadCrmContactIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .readCrmContact(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.readCrmContact()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadDependencyIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .readDependency(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.readDependency()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadAdminGroupsIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .readAdminGroups(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.readAdminGroups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadAdminProjectsIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .readAdminProjects(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.readAdminProjects()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadCodeIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .readCode(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.readCode()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadRunnersIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .readRunners(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.readRunners()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadSecurityAttributeIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .readSecurityAttribute(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.readSecurityAttribute()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadAdminSubscriptionIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .readAdminSubscription(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.readAdminSubscription()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadAdminMonitoringIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .readAdminMonitoring(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.readAdminMonitoring()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadAdminUsersIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .readAdminUsers(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.readAdminUsers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadVulnerabilityIsNullable() {
        final GitLabGroupMemberRolesCreatePayloadBuilder builder = GitLabGroupMemberRolesCreatePayloadBuilder.builder(
                        MemberrolesCatalogFixtures.groupMemberRolesCreatePayload())
                .readVulnerability(null);

        final GitLabGroupMemberRolesCreatePayload built = builder.build();

        assertThat(built.readVulnerability()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupMemberRolesCreatePayload value = MemberrolesCatalogFixtures.groupMemberRolesCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.baseAccessLevel()).isEqualTo(GitLabGroupMemberRolesCreateBaseAccessLevel.GUEST);
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.description()).isEqualTo("description");
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
        final GitLabGroupMemberRolesCreatePayload original = MemberrolesCatalogFixtures.groupMemberRolesCreatePayload();

        final GitLabGroupMemberRolesCreatePayload rebuilt =
                GitLabGroupMemberRolesCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupMemberRolesCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "baseAccessLevel",
                        "name",
                        "description",
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
