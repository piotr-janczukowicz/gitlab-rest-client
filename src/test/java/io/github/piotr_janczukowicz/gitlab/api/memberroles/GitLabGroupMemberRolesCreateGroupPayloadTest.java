package io.github.piotr_janczukowicz.gitlab.api.memberroles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupMemberRolesCreateGroupPayloadTest {

    @Test
    void constructor_shouldRefuseNull_whenBaseAccessLevelIsNull() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .baseAccessLevel(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("baseAccessLevel");
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .name(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .description(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApplySecurityScanProfilesIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .applySecurityScanProfiles(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.applySecurityScanProfiles()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminMergeRequestIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .adminMergeRequest(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.adminMergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchiveProjectIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .archiveProject(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.archiveProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchiveSubgroupIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .archiveSubgroup(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.archiveSubgroup()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminAiCatalogItemConsumerIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .adminAiCatalogItemConsumer(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.adminAiCatalogItemConsumer()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreateSecurityScanProfilesIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .createSecurityScanProfiles(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.createSecurityScanProfiles()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDestroyPackageIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .destroyPackage(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.destroyPackage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRemoveProjectIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .removeProject(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.removeProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeleteSecurityScanProfilesIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .deleteSecurityScanProfiles(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.deleteSecurityScanProfiles()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRemoveGroupIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .removeGroup(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.removeGroup()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenManageSecurityPolicyLinkIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .manageSecurityPolicyLink(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.manageSecurityPolicyLink()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminAiCatalogItemIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .adminAiCatalogItem(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.adminAiCatalogItem()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminComplianceFrameworkIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .adminComplianceFramework(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.adminComplianceFramework()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminCicdVariablesIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .adminCicdVariables(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.adminCicdVariables()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenManageDeployTokensIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .manageDeployTokens(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.manageDeployTokens()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenManageGroupAccessTokensIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .manageGroupAccessTokens(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.manageGroupAccessTokens()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminGroupMemberIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .adminGroupMember(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.adminGroupMember()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminIntegrationsIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .adminIntegrations(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.adminIntegrations()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenManageMergeRequestSettingsIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .manageMergeRequestSettings(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.manageMergeRequestSettings()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenManageProjectAccessTokensIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .manageProjectAccessTokens(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.manageProjectAccessTokens()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminProtectedBranchIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .adminProtectedBranch(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.adminProtectedBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminProtectedEnvironmentsIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .adminProtectedEnvironments(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.adminProtectedEnvironments()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminPushRulesIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .adminPushRules(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.adminPushRules()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminRunnersIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .adminRunners(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.adminRunners()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminSecurityAttributesIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .adminSecurityAttributes(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.adminSecurityAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminTerraformStateIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .adminTerraformState(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.adminTerraformState()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminVulnerabilityIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .adminVulnerability(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.adminVulnerability()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminWebHookIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .adminWebHook(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.adminWebHook()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPullContainerImageIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .pullContainerImage(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.pullContainerImage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushContainerImageIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .pushContainerImage(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.pushContainerImage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadAgentArtifactsIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .readAgentArtifacts(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.readAgentArtifacts()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadComplianceDashboardIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .readComplianceDashboard(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.readComplianceDashboard()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadSecurityScanProfilesIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .readSecurityScanProfiles(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.readSecurityScanProfiles()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadVirtualRegistryIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .readVirtualRegistry(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.readVirtualRegistry()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdateSecAiWorkflowSettingsIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .updateSecAiWorkflowSettings(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.updateSecAiWorkflowSettings()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdateSecurityScanProfilesIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .updateSecurityScanProfiles(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.updateSecurityScanProfiles()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadAdminCicdIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .readAdminCicd(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.readAdminCicd()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadCrmContactIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .readCrmContact(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.readCrmContact()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadDependencyIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .readDependency(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.readDependency()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadAdminGroupsIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .readAdminGroups(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.readAdminGroups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadAdminProjectsIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .readAdminProjects(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.readAdminProjects()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadCodeIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .readCode(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.readCode()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadRunnersIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .readRunners(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.readRunners()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadSecurityAttributeIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .readSecurityAttribute(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.readSecurityAttribute()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadAdminSubscriptionIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .readAdminSubscription(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.readAdminSubscription()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadAdminMonitoringIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .readAdminMonitoring(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.readAdminMonitoring()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadAdminUsersIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .readAdminUsers(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.readAdminUsers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadVulnerabilityIsNullable() {
        final GitLabGroupMemberRolesCreateGroupPayloadBuilder builder =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(
                                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload())
                        .readVulnerability(null);

        final GitLabGroupMemberRolesCreateGroupPayload built = builder.build();

        assertThat(built.readVulnerability()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupMemberRolesCreateGroupPayload value =
                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.baseAccessLevel())
                    .isEqualTo(GitLabGroupMemberRolesCreateGroupBaseAccessLevel.GUEST);
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
        final GitLabGroupMemberRolesCreateGroupPayload original =
                MemberrolesCatalogFixtures.groupMemberRolesCreateGroupPayload();

        final GitLabGroupMemberRolesCreateGroupPayload rebuilt =
                GitLabGroupMemberRolesCreateGroupPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupMemberRolesCreateGroupPayload.class.getRecordComponents())
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
