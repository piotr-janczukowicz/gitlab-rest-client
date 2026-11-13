package io.github.piotr_janczukowicz.gitlab.api;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.api.accessrequests.GitLabAccessRequestsApi;
import io.github.piotr_janczukowicz.gitlab.api.accesstokens.GitLabAccessTokensApi;
import io.github.piotr_janczukowicz.gitlab.api.activecontext.GitLabActiveContextApi;
import io.github.piotr_janczukowicz.gitlab.api.advancedsearchrollout.GitLabAdvancedSearchRolloutApi;
import io.github.piotr_janczukowicz.gitlab.api.agents.GitLabProjectAgentsApi;
import io.github.piotr_janczukowicz.gitlab.api.alertmanagementalerts.GitLabProjectAlertManagementAlertsApi;
import io.github.piotr_janczukowicz.gitlab.api.analytics.GitLabAnalyticsApi;
import io.github.piotr_janczukowicz.gitlab.api.appearance.GitLabAppearanceApi;
import io.github.piotr_janczukowicz.gitlab.api.applications.GitLabApplicationsApi;
import io.github.piotr_janczukowicz.gitlab.api.attestations.GitLabProjectAttestationsApi;
import io.github.piotr_janczukowicz.gitlab.api.auditevents.GitLabAuditEventsApi;
import io.github.piotr_janczukowicz.gitlab.api.authn.GitLabAuthnApi;
import io.github.piotr_janczukowicz.gitlab.api.avatar.GitLabAvatarApi;
import io.github.piotr_janczukowicz.gitlab.api.batchedbackgroundmigrations.GitLabBatchedBackgroundMigrationsApi;
import io.github.piotr_janczukowicz.gitlab.api.branches.GitLabProjectBranchesApi;
import io.github.piotr_janczukowicz.gitlab.api.broadcastmessages.GitLabBroadcastMessagesApi;
import io.github.piotr_janczukowicz.gitlab.api.clusterdiscoverycertificatebaseddeprecated.GitLabClusterDiscoveryCertificateBasedDeprecatedApi;
import io.github.piotr_janczukowicz.gitlab.api.codereviewanalytics.GitLabCodeReviewAnalyticsApi;
import io.github.piotr_janczukowicz.gitlab.api.codesearch.GitLabCodeSearchApi;
import io.github.piotr_janczukowicz.gitlab.api.codesnippets.GitLabCodeSnippetsApi;
import io.github.piotr_janczukowicz.gitlab.api.codesuggestions.GitLabCodeSuggestionsApi;
import io.github.piotr_janczukowicz.gitlab.api.commits.GitLabProjectCommitsApi;
import io.github.piotr_janczukowicz.gitlab.api.complianceandpolicysettings.GitLabComplianceAndPolicySettingsApi;
import io.github.piotr_janczukowicz.gitlab.api.composerdistributions.GitLabProjectComposerDistributionsApi;
import io.github.piotr_janczukowicz.gitlab.api.conanv1distributions.GitLabProjectConanV1DistributionsApi;
import io.github.piotr_janczukowicz.gitlab.api.conanv2distributions.GitLabProjectConanV2DistributionsApi;
import io.github.piotr_janczukowicz.gitlab.api.containerregistry.GitLabProjectContainerRegistryApi;
import io.github.piotr_janczukowicz.gitlab.api.containerregistryprotectiontagrules.GitLabProjectContainerRegistryProtectionTagRulesApi;
import io.github.piotr_janczukowicz.gitlab.api.customattributes.GitLabCustomAttributesApi;
import io.github.piotr_janczukowicz.gitlab.api.databasedictionary.GitLabDatabaseDictionaryApi;
import io.github.piotr_janczukowicz.gitlab.api.databasemigrations.GitLabDatabaseMigrationsApi;
import io.github.piotr_janczukowicz.gitlab.api.datamanagement.GitLabDataManagementApi;
import io.github.piotr_janczukowicz.gitlab.api.debiandistributions.GitLabDebianDistributionsApi;
import io.github.piotr_janczukowicz.gitlab.api.debianpackages.GitLabProjectDebianPackagesApi;
import io.github.piotr_janczukowicz.gitlab.api.dependencies.GitLabProjectDependenciesApi;
import io.github.piotr_janczukowicz.gitlab.api.dependencylistexports.GitLabDependencyListExportsApi;
import io.github.piotr_janczukowicz.gitlab.api.dependencymanagement.GitLabDependencyManagementApi;
import io.github.piotr_janczukowicz.gitlab.api.dependencyproxy.GitLabGroupDependencyProxyApi;
import io.github.piotr_janczukowicz.gitlab.api.deploykeys.GitLabDeployKeysApi;
import io.github.piotr_janczukowicz.gitlab.api.deployments.GitLabProjectDeploymentsApi;
import io.github.piotr_janczukowicz.gitlab.api.deploytokens.GitLabDeployTokensApi;
import io.github.piotr_janczukowicz.gitlab.api.devopsresearchandassessmentdorametrics.GitLabDevOpsResearchAndAssessmentDORAMetricsApi;
import io.github.piotr_janczukowicz.gitlab.api.discussions.GitLabDiscussionsApi;
import io.github.piotr_janczukowicz.gitlab.api.dockerfiletemplates.GitLabDockerfileTemplatesApi;
import io.github.piotr_janczukowicz.gitlab.api.draftnotes.GitLabProjectDraftNotesApi;
import io.github.piotr_janczukowicz.gitlab.api.emojireactions.GitLabProjectEmojiReactionsApi;
import io.github.piotr_janczukowicz.gitlab.api.environments.GitLabProjectEnvironmentsApi;
import io.github.piotr_janczukowicz.gitlab.api.epicissues.GitLabGroupEpicIssuesApi;
import io.github.piotr_janczukowicz.gitlab.api.epiclinks.GitLabGroupEpicLinksApi;
import io.github.piotr_janczukowicz.gitlab.api.epics.GitLabGroupEpicsApi;
import io.github.piotr_janczukowicz.gitlab.api.errortracking.GitLabProjectErrorTrackingApi;
import io.github.piotr_janczukowicz.gitlab.api.events.GitLabEventsApi;
import io.github.piotr_janczukowicz.gitlab.api.experiments.GitLabExperimentsApi;
import io.github.piotr_janczukowicz.gitlab.api.externalstatuschecks.GitLabProjectExternalStatusChecksApi;
import io.github.piotr_janczukowicz.gitlab.api.featureflags.GitLabFeatureFlagsApi;
import io.github.piotr_janczukowicz.gitlab.api.featureflaguserlists.GitLabProjectFeatureFlagUserListsApi;
import io.github.piotr_janczukowicz.gitlab.api.freezeperiods.GitLabProjectFreezePeriodsApi;
import io.github.piotr_janczukowicz.gitlab.api.geo.GitLabGeoApi;
import io.github.piotr_janczukowicz.gitlab.api.geonodes.GitLabGeoNodesApi;
import io.github.piotr_janczukowicz.gitlab.api.geosites.GitLabGeoSitesApi;
import io.github.piotr_janczukowicz.gitlab.api.gitignoretemplates.GitLabGitignoreTemplatesApi;
import io.github.piotr_janczukowicz.gitlab.api.gitlabcicdyamltemplates.GitLabCICDYAMLTemplatesApi;
import io.github.piotr_janczukowicz.gitlab.api.gitlabduo.GitLabDuoApi;
import io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows.GitLabDuoAgentPlatformFlowsApi;
import io.github.piotr_janczukowicz.gitlab.api.gitlabduochatcompletions.GitLabDuoChatCompletionsApi;
import io.github.piotr_janczukowicz.gitlab.api.glql.GitLabGLQLApi;
import io.github.piotr_janczukowicz.gitlab.api.googlecloudintegration.GitLabProjectGoogleCloudIntegrationApi;
import io.github.piotr_janczukowicz.gitlab.api.goproxy.GitLabProjectGoProxyApi;
import io.github.piotr_janczukowicz.gitlab.api.groupandprojectmigrationbydirecttransfer.GitLabGroupAndProjectMigrationByDirectTransferApi;
import io.github.piotr_janczukowicz.gitlab.api.groupbadges.GitLabGroupGroupBadgesApi;
import io.github.piotr_janczukowicz.gitlab.api.groupenterpriseusers.GitLabGroupGroupEnterpriseUsersApi;
import io.github.piotr_janczukowicz.gitlab.api.groupepicboards.GitLabGroupGroupEpicBoardsApi;
import io.github.piotr_janczukowicz.gitlab.api.groupimportandexport.GitLabGroupGroupImportAndExportApi;
import io.github.piotr_janczukowicz.gitlab.api.groupintegrations.GitLabGroupGroupIntegrationsApi;
import io.github.piotr_janczukowicz.gitlab.api.groupissueboards.GitLabGroupGroupIssueBoardsApi;
import io.github.piotr_janczukowicz.gitlab.api.groupiterations.GitLabGroupGroupIterationsApi;
import io.github.piotr_janczukowicz.gitlab.api.grouplabels.GitLabGroupGroupLabelsApi;
import io.github.piotr_janczukowicz.gitlab.api.grouplevelprotectedbranches.GitLabGroupGroupLevelProtectedBranchesApi;
import io.github.piotr_janczukowicz.gitlab.api.grouplevelprotectedenvironments.GitLabGroupGroupLevelProtectedEnvironmentsApi;
import io.github.piotr_janczukowicz.gitlab.api.grouplevelvariables.GitLabGroupGroupLevelVariablesApi;
import io.github.piotr_janczukowicz.gitlab.api.groupmarkdownuploads.GitLabGroupGroupMarkdownUploadsApi;
import io.github.piotr_janczukowicz.gitlab.api.groupmilestones.GitLabGroupGroupMilestonesApi;
import io.github.piotr_janczukowicz.gitlab.api.groupplaceholderreassignments.GitLabGroupGroupPlaceholderReassignmentsApi;
import io.github.piotr_janczukowicz.gitlab.api.grouppushrules.GitLabGroupGroupPushRulesApi;
import io.github.piotr_janczukowicz.gitlab.api.groupreleases.GitLabGroupGroupReleasesApi;
import io.github.piotr_janczukowicz.gitlab.api.grouprepositorystoragemoves.GitLabGroupRepositoryStorageMovesApi;
import io.github.piotr_janczukowicz.gitlab.api.groups.GitLabGroupGroupsApi;
import io.github.piotr_janczukowicz.gitlab.api.groupsecuritysettings.GitLabGroupGroupSecuritySettingsApi;
import io.github.piotr_janczukowicz.gitlab.api.groupsshcertificates.GitLabGroupGroupSSHCertificatesApi;
import io.github.piotr_janczukowicz.gitlab.api.groupwebhooks.GitLabGroupGroupWebhooksApi;
import io.github.piotr_janczukowicz.gitlab.api.groupwikis.GitLabGroupGroupWikisApi;
import io.github.piotr_janczukowicz.gitlab.api.importrepositoryfrombitbucketserver.GitLabImportRepositoryFromBitbucketServerApi;
import io.github.piotr_janczukowicz.gitlab.api.importrepositoryfromgithub.GitLabImportRepositoryFromGitHubApi;
import io.github.piotr_janczukowicz.gitlab.api.instanceclusters.GitLabInstanceClustersApi;
import io.github.piotr_janczukowicz.gitlab.api.instancelevelcicdvariables.GitLabInstanceLevelCICDVariablesApi;
import io.github.piotr_janczukowicz.gitlab.api.integrations.GitLabProjectIntegrationsApi;
import io.github.piotr_janczukowicz.gitlab.api.invitations.GitLabInvitationsApi;
import io.github.piotr_janczukowicz.gitlab.api.issueboards.GitLabProjectIssueBoardsApi;
import io.github.piotr_janczukowicz.gitlab.api.issuelinks.GitLabProjectIssueLinksApi;
import io.github.piotr_janczukowicz.gitlab.api.issues.GitLabIssuesApi;
import io.github.piotr_janczukowicz.gitlab.api.issuesstatistics.GitLabIssuesStatisticsApi;
import io.github.piotr_janczukowicz.gitlab.api.iterations.GitLabProjectIterationsApi;
import io.github.piotr_janczukowicz.gitlab.api.jiraconnectsubscriptions.GitLabJiraConnectSubscriptionsApi;
import io.github.piotr_janczukowicz.gitlab.api.jiraforgeinstallation.GitLabJiraForgeInstallationApi;
import io.github.piotr_janczukowicz.gitlab.api.jiraforgesubscriptions.GitLabJiraForgeSubscriptionsApi;
import io.github.piotr_janczukowicz.gitlab.api.jiraforgeuserdelegation.GitLabJiraForgeUserDelegationApi;
import io.github.piotr_janczukowicz.gitlab.api.jobs.GitLabJobsApi;
import io.github.piotr_janczukowicz.gitlab.api.jobsartifacts.GitLabProjectJobsArtifactsApi;
import io.github.piotr_janczukowicz.gitlab.api.keys.GitLabKeysApi;
import io.github.piotr_janczukowicz.gitlab.api.knowledgegraph.GitLabKnowledgeGraphApi;
import io.github.piotr_janczukowicz.gitlab.api.labels.GitLabProjectLabelsApi;
import io.github.piotr_janczukowicz.gitlab.api.ldap.GitLabLDAPApi;
import io.github.piotr_janczukowicz.gitlab.api.ldapgrouplinks.GitLabGroupLDAPGroupLinksApi;
import io.github.piotr_janczukowicz.gitlab.api.license.GitLabLicenseApi;
import io.github.piotr_janczukowicz.gitlab.api.linkedepics.GitLabGroupLinkedEpicsApi;
import io.github.piotr_janczukowicz.gitlab.api.markdown.GitLabMarkdownApi;
import io.github.piotr_janczukowicz.gitlab.api.markdownuploads.GitLabProjectMarkdownUploadsApi;
import io.github.piotr_janczukowicz.gitlab.api.mavenrepository.GitLabProjectMavenRepositoryApi;
import io.github.piotr_janczukowicz.gitlab.api.memberroles.GitLabGroupMemberRolesApi;
import io.github.piotr_janczukowicz.gitlab.api.members.GitLabMembersApi;
import io.github.piotr_janczukowicz.gitlab.api.mergerequestapprovals.GitLabProjectMergeRequestApprovalsApi;
import io.github.piotr_janczukowicz.gitlab.api.mergerequestapprovalsettings.GitLabMergeRequestApprovalSettingsApi;
import io.github.piotr_janczukowicz.gitlab.api.mergerequestcontextcommits.GitLabProjectMergeRequestContextCommitsApi;
import io.github.piotr_janczukowicz.gitlab.api.mergerequests.GitLabMergeRequestsApi;
import io.github.piotr_janczukowicz.gitlab.api.mergetrains.GitLabProjectMergeTrainsApi;
import io.github.piotr_janczukowicz.gitlab.api.metadata.GitLabProjectMetadataApi;
import io.github.piotr_janczukowicz.gitlab.api.migrations.GitLabMigrationsApi;
import io.github.piotr_janczukowicz.gitlab.api.mobilepushsubscriptions.GitLabMobilePushSubscriptionsApi;
import io.github.piotr_janczukowicz.gitlab.api.modelregistry.GitLabProjectModelRegistryApi;
import io.github.piotr_janczukowicz.gitlab.api.namespaces.GitLabNamespacesApi;
import io.github.piotr_janczukowicz.gitlab.api.notes.GitLabNotesApi;
import io.github.piotr_janczukowicz.gitlab.api.notificationsettings.GitLabNotificationSettingsApi;
import io.github.piotr_janczukowicz.gitlab.api.npmrepository.GitLabProjectNPMRepositoryApi;
import io.github.piotr_janczukowicz.gitlab.api.nugetpackages.GitLabProjectNuGetPackagesApi;
import io.github.piotr_janczukowicz.gitlab.api.offlinetransfers.GitLabOfflineTransfersApi;
import io.github.piotr_janczukowicz.gitlab.api.opensourcelicensetemplates.GitLabOpenSourceLicenseTemplatesApi;
import io.github.piotr_janczukowicz.gitlab.api.orbit.GitLabOrbitApi;
import io.github.piotr_janczukowicz.gitlab.api.organizations.GitLabOrganizationsApi;
import io.github.piotr_janczukowicz.gitlab.api.packages.GitLabProjectPackagesApi;
import io.github.piotr_janczukowicz.gitlab.api.pagesdomains.GitLabPagesDomainsApi;
import io.github.piotr_janczukowicz.gitlab.api.pagessettings.GitLabProjectPagesSettingsApi;
import io.github.piotr_janczukowicz.gitlab.api.personalaccesstokens.GitLabPersonalAccessTokensApi;
import io.github.piotr_janczukowicz.gitlab.api.pipelines.GitLabProjectPipelinesApi;
import io.github.piotr_janczukowicz.gitlab.api.pipelineschedules.GitLabProjectPipelineSchedulesApi;
import io.github.piotr_janczukowicz.gitlab.api.pipelinetriggers.GitLabProjectPipelineTriggersApi;
import io.github.piotr_janczukowicz.gitlab.api.planlimits.GitLabPlanLimitsApi;
import io.github.piotr_janczukowicz.gitlab.api.projectaliases.GitLabProjectAliasesApi;
import io.github.piotr_janczukowicz.gitlab.api.projectbadges.GitLabProjectProjectBadgesApi;
import io.github.piotr_janczukowicz.gitlab.api.projectcicdjobtokenscope.GitLabProjectProjectCICDJobTokenScopeApi;
import io.github.piotr_janczukowicz.gitlab.api.projectclusters.GitLabProjectProjectClustersApi;
import io.github.piotr_janczukowicz.gitlab.api.projectforks.GitLabProjectProjectForksApi;
import io.github.piotr_janczukowicz.gitlab.api.projectimport.GitLabProjectImportApi;
import io.github.piotr_janczukowicz.gitlab.api.projectimportexport.GitLabProjectProjectImportExportApi;
import io.github.piotr_janczukowicz.gitlab.api.projectlevelsecurefiles.GitLabProjectProjectLevelSecureFilesApi;
import io.github.piotr_janczukowicz.gitlab.api.projectlevelvariables.GitLabProjectProjectLevelVariablesApi;
import io.github.piotr_janczukowicz.gitlab.api.projectmilestones.GitLabProjectProjectMilestonesApi;
import io.github.piotr_janczukowicz.gitlab.api.projectpushrules.GitLabProjectProjectPushRulesApi;
import io.github.piotr_janczukowicz.gitlab.api.projectrelationsexport.GitLabProjectProjectRelationsExportApi;
import io.github.piotr_janczukowicz.gitlab.api.projectrepositorystoragemoves.GitLabProjectRepositoryStorageMovesApi;
import io.github.piotr_janczukowicz.gitlab.api.projects.GitLabProjectsApi;
import io.github.piotr_janczukowicz.gitlab.api.projectsecuritysettings.GitLabProjectProjectSecuritySettingsApi;
import io.github.piotr_janczukowicz.gitlab.api.projectsnippets.GitLabProjectProjectSnippetsApi;
import io.github.piotr_janczukowicz.gitlab.api.projectstarring.GitLabProjectProjectStarringApi;
import io.github.piotr_janczukowicz.gitlab.api.projectstatistics.GitLabProjectProjectStatisticsApi;
import io.github.piotr_janczukowicz.gitlab.api.projecttemplates.GitLabProjectProjectTemplatesApi;
import io.github.piotr_janczukowicz.gitlab.api.projectvulnerabilities.GitLabProjectProjectVulnerabilitiesApi;
import io.github.piotr_janczukowicz.gitlab.api.projectwebhooks.GitLabProjectProjectWebhooksApi;
import io.github.piotr_janczukowicz.gitlab.api.projectwikis.GitLabProjectProjectWikisApi;
import io.github.piotr_janczukowicz.gitlab.api.protectedbranches.GitLabProjectProtectedBranchesApi;
import io.github.piotr_janczukowicz.gitlab.api.protectedcontainerregistry.GitLabProjectProtectedContainerRegistryApi;
import io.github.piotr_janczukowicz.gitlab.api.protectedenvironments.GitLabProjectProtectedEnvironmentsApi;
import io.github.piotr_janczukowicz.gitlab.api.protectedpackages.GitLabProjectProtectedPackagesApi;
import io.github.piotr_janczukowicz.gitlab.api.protectedtags.GitLabProjectProtectedTagsApi;
import io.github.piotr_janczukowicz.gitlab.api.pullmirroring.GitLabProjectPullMirroringApi;
import io.github.piotr_janczukowicz.gitlab.api.pypipackages.GitLabProjectPyPIPackagesApi;
import io.github.piotr_janczukowicz.gitlab.api.releaselinks.GitLabProjectReleaseLinksApi;
import io.github.piotr_janczukowicz.gitlab.api.releases.GitLabProjectReleasesApi;
import io.github.piotr_janczukowicz.gitlab.api.remotemirrors.GitLabProjectRemoteMirrorsApi;
import io.github.piotr_janczukowicz.gitlab.api.repositories.GitLabProjectRepositoriesApi;
import io.github.piotr_janczukowicz.gitlab.api.repositoryfiles.GitLabProjectRepositoryFilesApi;
import io.github.piotr_janczukowicz.gitlab.api.repositorysubmodules.GitLabProjectRepositorySubmodulesApi;
import io.github.piotr_janczukowicz.gitlab.api.resourcegroup.GitLabProjectResourceGroupApi;
import io.github.piotr_janczukowicz.gitlab.api.resourceiterationevents.GitLabProjectResourceIterationEventsApi;
import io.github.piotr_janczukowicz.gitlab.api.resourcelabelevents.GitLabResourceLabelEventsApi;
import io.github.piotr_janczukowicz.gitlab.api.resourcemilestoneevents.GitLabProjectResourceMilestoneEventsApi;
import io.github.piotr_janczukowicz.gitlab.api.resourcestateevents.GitLabResourceStateEventsApi;
import io.github.piotr_janczukowicz.gitlab.api.resourceweightevents.GitLabProjectResourceWeightEventsApi;
import io.github.piotr_janczukowicz.gitlab.api.rollouts.GitLabRolloutsApi;
import io.github.piotr_janczukowicz.gitlab.api.rubygems.GitLabProjectRubyGemsApi;
import io.github.piotr_janczukowicz.gitlab.api.runnercontrollers.GitLabRunnerControllersApi;
import io.github.piotr_janczukowicz.gitlab.api.runnercontrollertokens.GitLabRunnerControllerTokensApi;
import io.github.piotr_janczukowicz.gitlab.api.runners.GitLabRunnersApi;
import io.github.piotr_janczukowicz.gitlab.api.saml.GitLabGroupSAMLApi;
import io.github.piotr_janczukowicz.gitlab.api.scim.GitLabGroupSCIMApi;
import io.github.piotr_janczukowicz.gitlab.api.search.GitLabSearchApi;
import io.github.piotr_janczukowicz.gitlab.api.searchadmin.GitLabSearchAdminApi;
import io.github.piotr_janczukowicz.gitlab.api.serviceaccounts.GitLabServiceAccountsApi;
import io.github.piotr_janczukowicz.gitlab.api.servicedata.GitLabServiceDataApi;
import io.github.piotr_janczukowicz.gitlab.api.settings.GitLabSettingsApi;
import io.github.piotr_janczukowicz.gitlab.api.sidekiq.GitLabSidekiqApi;
import io.github.piotr_janczukowicz.gitlab.api.sidekiqmetrics.GitLabSidekiqMetricsApi;
import io.github.piotr_janczukowicz.gitlab.api.sidekiqqueuesadministration.GitLabSidekiqQueuesAdministrationApi;
import io.github.piotr_janczukowicz.gitlab.api.snippetrepositorystoragemoves.GitLabSnippetRepositoryStorageMovesApi;
import io.github.piotr_janczukowicz.gitlab.api.softwarecompositionanalysis.GitLabSoftwareCompositionAnalysisApi;
import io.github.piotr_janczukowicz.gitlab.api.statistics.GitLabStatisticsApi;
import io.github.piotr_janczukowicz.gitlab.api.suggestions.GitLabSuggestionsApi;
import io.github.piotr_janczukowicz.gitlab.api.systemhooks.GitLabSystemHooksApi;
import io.github.piotr_janczukowicz.gitlab.api.tags.GitLabProjectTagsApi;
import io.github.piotr_janczukowicz.gitlab.api.terraformmodules.GitLabProjectTerraformModulesApi;
import io.github.piotr_janczukowicz.gitlab.api.terraformstate.GitLabProjectTerraformStateApi;
import io.github.piotr_janczukowicz.gitlab.api.todos.GitLabToDosApi;
import io.github.piotr_janczukowicz.gitlab.api.tokenexchange.GitLabTokenExchangeApi;
import io.github.piotr_janczukowicz.gitlab.api.topics.GitLabTopicsApi;
import io.github.piotr_janczukowicz.gitlab.api.unleash.GitLabUnleashApi;
import io.github.piotr_janczukowicz.gitlab.api.userapplications.GitLabUserApplicationsApi;
import io.github.piotr_janczukowicz.gitlab.api.useremailaddresses.GitLabUserEmailAddressesApi;
import io.github.piotr_janczukowicz.gitlab.api.userfollowandunfollow.GitLabUserFollowAndUnfollowApi;
import io.github.piotr_janczukowicz.gitlab.api.usermoderation.GitLabUserModerationApi;
import io.github.piotr_janczukowicz.gitlab.api.users.GitLabUsersApi;
import io.github.piotr_janczukowicz.gitlab.api.usersshandgpgkeys.GitLabUserSSHAndGPGKeysApi;
import io.github.piotr_janczukowicz.gitlab.api.usertokens.GitLabUserTokensApi;
import io.github.piotr_janczukowicz.gitlab.api.validategitlabciymlfile.GitLabProjectValidateGitlabCiYmlFileApi;
import io.github.piotr_janczukowicz.gitlab.api.vscode.GitLabVSCodeApi;
import io.github.piotr_janczukowicz.gitlab.api.vulnerabilities.GitLabProjectVulnerabilitiesApi;
import io.github.piotr_janczukowicz.gitlab.api.vulnerabilityfindings.GitLabProjectVulnerabilityFindingsApi;
import io.github.piotr_janczukowicz.gitlab.api.webcommits.GitLabWebCommitsApi;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.util.LazyValue;

/** Every GitLab API, reached from one client or caller. */
public final class GitLab {

    private final LazyValue<GitLabAccessRequestsApi> accessrequests;
    private final LazyValue<GitLabAccessTokensApi> accesstokens;
    private final LazyValue<GitLabActiveContextApi> activecontext;
    private final LazyValue<GitLabAdvancedSearchRolloutApi> advancedsearchrollout;
    private final LazyValue<GitLabProjectAgentsApi> agents;
    private final LazyValue<GitLabProjectAlertManagementAlertsApi> alertmanagementalerts;
    private final LazyValue<GitLabAnalyticsApi> analytics;
    private final LazyValue<GitLabAppearanceApi> appearance;
    private final LazyValue<GitLabApplicationsApi> applications;
    private final LazyValue<GitLabProjectAttestationsApi> attestations;
    private final LazyValue<GitLabAuditEventsApi> auditevents;
    private final LazyValue<GitLabAuthnApi> authn;
    private final LazyValue<GitLabAvatarApi> avatar;
    private final LazyValue<GitLabBatchedBackgroundMigrationsApi> batchedbackgroundmigrations;
    private final LazyValue<GitLabProjectBranchesApi> branches;
    private final LazyValue<GitLabBroadcastMessagesApi> broadcastmessages;
    private final LazyValue<GitLabClusterDiscoveryCertificateBasedDeprecatedApi>
            clusterdiscoverycertificatebaseddeprecated;
    private final LazyValue<GitLabCodeReviewAnalyticsApi> codereviewanalytics;
    private final LazyValue<GitLabCodeSearchApi> codesearch;
    private final LazyValue<GitLabCodeSnippetsApi> codesnippets;
    private final LazyValue<GitLabCodeSuggestionsApi> codesuggestions;
    private final LazyValue<GitLabProjectCommitsApi> commits;
    private final LazyValue<GitLabComplianceAndPolicySettingsApi> complianceandpolicysettings;
    private final LazyValue<GitLabProjectComposerDistributionsApi> composerdistributions;
    private final LazyValue<GitLabProjectConanV1DistributionsApi> conanv1distributions;
    private final LazyValue<GitLabProjectConanV2DistributionsApi> conanv2distributions;
    private final LazyValue<GitLabProjectContainerRegistryApi> containerregistry;
    private final LazyValue<GitLabProjectContainerRegistryProtectionTagRulesApi> containerregistryprotectiontagrules;
    private final LazyValue<GitLabCustomAttributesApi> customattributes;
    private final LazyValue<GitLabDatabaseDictionaryApi> databasedictionary;
    private final LazyValue<GitLabDatabaseMigrationsApi> databasemigrations;
    private final LazyValue<GitLabDataManagementApi> datamanagement;
    private final LazyValue<GitLabDebianDistributionsApi> debiandistributions;
    private final LazyValue<GitLabProjectDebianPackagesApi> debianpackages;
    private final LazyValue<GitLabProjectDependenciesApi> dependencies;
    private final LazyValue<GitLabDependencyListExportsApi> dependencylistexports;
    private final LazyValue<GitLabDependencyManagementApi> dependencymanagement;
    private final LazyValue<GitLabGroupDependencyProxyApi> dependencyproxy;
    private final LazyValue<GitLabDeployKeysApi> deploykeys;
    private final LazyValue<GitLabProjectDeploymentsApi> deployments;
    private final LazyValue<GitLabDeployTokensApi> deploytokens;
    private final LazyValue<GitLabDevOpsResearchAndAssessmentDORAMetricsApi> devopsresearchandassessmentdorametrics;
    private final LazyValue<GitLabDiscussionsApi> discussions;
    private final LazyValue<GitLabDockerfileTemplatesApi> dockerfiletemplates;
    private final LazyValue<GitLabProjectDraftNotesApi> draftnotes;
    private final LazyValue<GitLabProjectEmojiReactionsApi> emojireactions;
    private final LazyValue<GitLabProjectEnvironmentsApi> environments;
    private final LazyValue<GitLabGroupEpicIssuesApi> epicissues;
    private final LazyValue<GitLabGroupEpicLinksApi> epiclinks;
    private final LazyValue<GitLabGroupEpicsApi> epics;
    private final LazyValue<GitLabProjectErrorTrackingApi> errortracking;
    private final LazyValue<GitLabEventsApi> events;
    private final LazyValue<GitLabExperimentsApi> experiments;
    private final LazyValue<GitLabProjectExternalStatusChecksApi> externalstatuschecks;
    private final LazyValue<GitLabFeatureFlagsApi> featureflags;
    private final LazyValue<GitLabProjectFeatureFlagUserListsApi> featureflaguserlists;
    private final LazyValue<GitLabProjectFreezePeriodsApi> freezeperiods;
    private final LazyValue<GitLabGeoApi> geo;
    private final LazyValue<GitLabGeoNodesApi> geonodes;
    private final LazyValue<GitLabGeoSitesApi> geosites;
    private final LazyValue<GitLabGitignoreTemplatesApi> gitignoretemplates;
    private final LazyValue<GitLabCICDYAMLTemplatesApi> gitlabcicdyamltemplates;
    private final LazyValue<GitLabDuoApi> gitlabduo;
    private final LazyValue<GitLabDuoAgentPlatformFlowsApi> gitlabduoagentplatformflows;
    private final LazyValue<GitLabDuoChatCompletionsApi> gitlabduochatcompletions;
    private final LazyValue<GitLabGLQLApi> glql;
    private final LazyValue<GitLabProjectGoogleCloudIntegrationApi> googlecloudintegration;
    private final LazyValue<GitLabProjectGoProxyApi> goproxy;
    private final LazyValue<GitLabGroupAndProjectMigrationByDirectTransferApi> groupandprojectmigrationbydirecttransfer;
    private final LazyValue<GitLabGroupGroupBadgesApi> groupbadges;
    private final LazyValue<GitLabGroupGroupEnterpriseUsersApi> groupenterpriseusers;
    private final LazyValue<GitLabGroupGroupEpicBoardsApi> groupepicboards;
    private final LazyValue<GitLabGroupGroupImportAndExportApi> groupimportandexport;
    private final LazyValue<GitLabGroupGroupIntegrationsApi> groupintegrations;
    private final LazyValue<GitLabGroupGroupIssueBoardsApi> groupissueboards;
    private final LazyValue<GitLabGroupGroupIterationsApi> groupiterations;
    private final LazyValue<GitLabGroupGroupLabelsApi> grouplabels;
    private final LazyValue<GitLabGroupGroupLevelProtectedBranchesApi> grouplevelprotectedbranches;
    private final LazyValue<GitLabGroupGroupLevelProtectedEnvironmentsApi> grouplevelprotectedenvironments;
    private final LazyValue<GitLabGroupGroupLevelVariablesApi> grouplevelvariables;
    private final LazyValue<GitLabGroupGroupMarkdownUploadsApi> groupmarkdownuploads;
    private final LazyValue<GitLabGroupGroupMilestonesApi> groupmilestones;
    private final LazyValue<GitLabGroupGroupPlaceholderReassignmentsApi> groupplaceholderreassignments;
    private final LazyValue<GitLabGroupGroupPushRulesApi> grouppushrules;
    private final LazyValue<GitLabGroupGroupReleasesApi> groupreleases;
    private final LazyValue<GitLabGroupRepositoryStorageMovesApi> grouprepositorystoragemoves;
    private final LazyValue<GitLabGroupGroupsApi> groups;
    private final LazyValue<GitLabGroupGroupSecuritySettingsApi> groupsecuritysettings;
    private final LazyValue<GitLabGroupGroupSSHCertificatesApi> groupsshcertificates;
    private final LazyValue<GitLabGroupGroupWebhooksApi> groupwebhooks;
    private final LazyValue<GitLabGroupGroupWikisApi> groupwikis;
    private final LazyValue<GitLabImportRepositoryFromBitbucketServerApi> importrepositoryfrombitbucketserver;
    private final LazyValue<GitLabImportRepositoryFromGitHubApi> importrepositoryfromgithub;
    private final LazyValue<GitLabInstanceClustersApi> instanceclusters;
    private final LazyValue<GitLabInstanceLevelCICDVariablesApi> instancelevelcicdvariables;
    private final LazyValue<GitLabProjectIntegrationsApi> integrations;
    private final LazyValue<GitLabInvitationsApi> invitations;
    private final LazyValue<GitLabProjectIssueBoardsApi> issueboards;
    private final LazyValue<GitLabProjectIssueLinksApi> issuelinks;
    private final LazyValue<GitLabIssuesApi> issues;
    private final LazyValue<GitLabIssuesStatisticsApi> issuesstatistics;
    private final LazyValue<GitLabProjectIterationsApi> iterations;
    private final LazyValue<GitLabJiraConnectSubscriptionsApi> jiraconnectsubscriptions;
    private final LazyValue<GitLabJiraForgeInstallationApi> jiraforgeinstallation;
    private final LazyValue<GitLabJiraForgeSubscriptionsApi> jiraforgesubscriptions;
    private final LazyValue<GitLabJiraForgeUserDelegationApi> jiraforgeuserdelegation;
    private final LazyValue<GitLabJobsApi> jobs;
    private final LazyValue<GitLabProjectJobsArtifactsApi> jobsartifacts;
    private final LazyValue<GitLabKeysApi> keys;
    private final LazyValue<GitLabKnowledgeGraphApi> knowledgegraph;
    private final LazyValue<GitLabProjectLabelsApi> labels;
    private final LazyValue<GitLabLDAPApi> ldap;
    private final LazyValue<GitLabGroupLDAPGroupLinksApi> ldapgrouplinks;
    private final LazyValue<GitLabLicenseApi> license;
    private final LazyValue<GitLabGroupLinkedEpicsApi> linkedepics;
    private final LazyValue<GitLabMarkdownApi> markdown;
    private final LazyValue<GitLabProjectMarkdownUploadsApi> markdownuploads;
    private final LazyValue<GitLabProjectMavenRepositoryApi> mavenrepository;
    private final LazyValue<GitLabGroupMemberRolesApi> memberroles;
    private final LazyValue<GitLabMembersApi> members;
    private final LazyValue<GitLabProjectMergeRequestApprovalsApi> mergerequestapprovals;
    private final LazyValue<GitLabMergeRequestApprovalSettingsApi> mergerequestapprovalsettings;
    private final LazyValue<GitLabProjectMergeRequestContextCommitsApi> mergerequestcontextcommits;
    private final LazyValue<GitLabMergeRequestsApi> mergerequests;
    private final LazyValue<GitLabProjectMergeTrainsApi> mergetrains;
    private final LazyValue<GitLabProjectMetadataApi> metadata;
    private final LazyValue<GitLabMigrationsApi> migrations;
    private final LazyValue<GitLabMobilePushSubscriptionsApi> mobilepushsubscriptions;
    private final LazyValue<GitLabProjectModelRegistryApi> modelregistry;
    private final LazyValue<GitLabNamespacesApi> namespaces;
    private final LazyValue<GitLabNotesApi> notes;
    private final LazyValue<GitLabNotificationSettingsApi> notificationsettings;
    private final LazyValue<GitLabProjectNPMRepositoryApi> npmrepository;
    private final LazyValue<GitLabProjectNuGetPackagesApi> nugetpackages;
    private final LazyValue<GitLabOfflineTransfersApi> offlinetransfers;
    private final LazyValue<GitLabOpenSourceLicenseTemplatesApi> opensourcelicensetemplates;
    private final LazyValue<GitLabOrbitApi> orbit;
    private final LazyValue<GitLabOrganizationsApi> organizations;
    private final LazyValue<GitLabProjectPackagesApi> packages;
    private final LazyValue<GitLabPagesDomainsApi> pagesdomains;
    private final LazyValue<GitLabProjectPagesSettingsApi> pagessettings;
    private final LazyValue<GitLabPersonalAccessTokensApi> personalaccesstokens;
    private final LazyValue<GitLabProjectPipelinesApi> pipelines;
    private final LazyValue<GitLabProjectPipelineSchedulesApi> pipelineschedules;
    private final LazyValue<GitLabProjectPipelineTriggersApi> pipelinetriggers;
    private final LazyValue<GitLabPlanLimitsApi> planlimits;
    private final LazyValue<GitLabProjectAliasesApi> projectaliases;
    private final LazyValue<GitLabProjectProjectBadgesApi> projectbadges;
    private final LazyValue<GitLabProjectProjectCICDJobTokenScopeApi> projectcicdjobtokenscope;
    private final LazyValue<GitLabProjectProjectClustersApi> projectclusters;
    private final LazyValue<GitLabProjectProjectForksApi> projectforks;
    private final LazyValue<GitLabProjectImportApi> projectimport;
    private final LazyValue<GitLabProjectProjectImportExportApi> projectimportexport;
    private final LazyValue<GitLabProjectProjectLevelSecureFilesApi> projectlevelsecurefiles;
    private final LazyValue<GitLabProjectProjectLevelVariablesApi> projectlevelvariables;
    private final LazyValue<GitLabProjectProjectMilestonesApi> projectmilestones;
    private final LazyValue<GitLabProjectProjectPushRulesApi> projectpushrules;
    private final LazyValue<GitLabProjectProjectRelationsExportApi> projectrelationsexport;
    private final LazyValue<GitLabProjectRepositoryStorageMovesApi> projectrepositorystoragemoves;
    private final LazyValue<GitLabProjectsApi> projects;
    private final LazyValue<GitLabProjectProjectSecuritySettingsApi> projectsecuritysettings;
    private final LazyValue<GitLabProjectProjectSnippetsApi> projectsnippets;
    private final LazyValue<GitLabProjectProjectStarringApi> projectstarring;
    private final LazyValue<GitLabProjectProjectStatisticsApi> projectstatistics;
    private final LazyValue<GitLabProjectProjectTemplatesApi> projecttemplates;
    private final LazyValue<GitLabProjectProjectVulnerabilitiesApi> projectvulnerabilities;
    private final LazyValue<GitLabProjectProjectWebhooksApi> projectwebhooks;
    private final LazyValue<GitLabProjectProjectWikisApi> projectwikis;
    private final LazyValue<GitLabProjectProtectedBranchesApi> protectedbranches;
    private final LazyValue<GitLabProjectProtectedContainerRegistryApi> protectedcontainerregistry;
    private final LazyValue<GitLabProjectProtectedEnvironmentsApi> protectedenvironments;
    private final LazyValue<GitLabProjectProtectedPackagesApi> protectedpackages;
    private final LazyValue<GitLabProjectProtectedTagsApi> protectedtags;
    private final LazyValue<GitLabProjectPullMirroringApi> pullmirroring;
    private final LazyValue<GitLabProjectPyPIPackagesApi> pypipackages;
    private final LazyValue<GitLabProjectReleaseLinksApi> releaselinks;
    private final LazyValue<GitLabProjectReleasesApi> releases;
    private final LazyValue<GitLabProjectRemoteMirrorsApi> remotemirrors;
    private final LazyValue<GitLabProjectRepositoriesApi> repositories;
    private final LazyValue<GitLabProjectRepositoryFilesApi> repositoryfiles;
    private final LazyValue<GitLabProjectRepositorySubmodulesApi> repositorysubmodules;
    private final LazyValue<GitLabProjectResourceGroupApi> resourcegroup;
    private final LazyValue<GitLabProjectResourceIterationEventsApi> resourceiterationevents;
    private final LazyValue<GitLabResourceLabelEventsApi> resourcelabelevents;
    private final LazyValue<GitLabProjectResourceMilestoneEventsApi> resourcemilestoneevents;
    private final LazyValue<GitLabResourceStateEventsApi> resourcestateevents;
    private final LazyValue<GitLabProjectResourceWeightEventsApi> resourceweightevents;
    private final LazyValue<GitLabRolloutsApi> rollouts;
    private final LazyValue<GitLabProjectRubyGemsApi> rubygems;
    private final LazyValue<GitLabRunnerControllersApi> runnercontrollers;
    private final LazyValue<GitLabRunnerControllerTokensApi> runnercontrollertokens;
    private final LazyValue<GitLabRunnersApi> runners;
    private final LazyValue<GitLabGroupSAMLApi> saml;
    private final LazyValue<GitLabGroupSCIMApi> scim;
    private final LazyValue<GitLabSearchApi> search;
    private final LazyValue<GitLabSearchAdminApi> searchadmin;
    private final LazyValue<GitLabServiceAccountsApi> serviceaccounts;
    private final LazyValue<GitLabServiceDataApi> servicedata;
    private final LazyValue<GitLabSettingsApi> settings;
    private final LazyValue<GitLabSidekiqApi> sidekiq;
    private final LazyValue<GitLabSidekiqMetricsApi> sidekiqmetrics;
    private final LazyValue<GitLabSidekiqQueuesAdministrationApi> sidekiqqueuesadministration;
    private final LazyValue<GitLabSnippetRepositoryStorageMovesApi> snippetrepositorystoragemoves;
    private final LazyValue<GitLabSoftwareCompositionAnalysisApi> softwarecompositionanalysis;
    private final LazyValue<GitLabStatisticsApi> statistics;
    private final LazyValue<GitLabSuggestionsApi> suggestions;
    private final LazyValue<GitLabSystemHooksApi> systemhooks;
    private final LazyValue<GitLabProjectTagsApi> tags;
    private final LazyValue<GitLabProjectTerraformModulesApi> terraformmodules;
    private final LazyValue<GitLabProjectTerraformStateApi> terraformstate;
    private final LazyValue<GitLabToDosApi> todos;
    private final LazyValue<GitLabTokenExchangeApi> tokenexchange;
    private final LazyValue<GitLabTopicsApi> topics;
    private final LazyValue<GitLabUnleashApi> unleash;
    private final LazyValue<GitLabUserApplicationsApi> userapplications;
    private final LazyValue<GitLabUserEmailAddressesApi> useremailaddresses;
    private final LazyValue<GitLabUserFollowAndUnfollowApi> userfollowandunfollow;
    private final LazyValue<GitLabUserModerationApi> usermoderation;
    private final LazyValue<GitLabUsersApi> users;
    private final LazyValue<GitLabUserSSHAndGPGKeysApi> usersshandgpgkeys;
    private final LazyValue<GitLabUserTokensApi> usertokens;
    private final LazyValue<GitLabProjectValidateGitlabCiYmlFileApi> validategitlabciymlfile;
    private final LazyValue<GitLabVSCodeApi> vscode;
    private final LazyValue<GitLabProjectVulnerabilitiesApi> vulnerabilities;
    private final LazyValue<GitLabProjectVulnerabilityFindingsApi> vulnerabilityfindings;
    private final LazyValue<GitLabWebCommitsApi> webcommits;

    /**
     * The APIs over {@code caller}; each is created when it is first asked for.
     *
     * @param caller sends the calls of every API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    @SuppressWarnings("PMD.NcssCount")
    public GitLab(final GitLabCaller caller) {
        requireNonNull(caller, "caller");
        this.accessrequests = new LazyValue<>(() -> new GitLabAccessRequestsApi(caller));
        this.accesstokens = new LazyValue<>(() -> new GitLabAccessTokensApi(caller));
        this.activecontext = new LazyValue<>(() -> new GitLabActiveContextApi(caller));
        this.advancedsearchrollout = new LazyValue<>(() -> new GitLabAdvancedSearchRolloutApi(caller));
        this.agents = new LazyValue<>(() -> new GitLabProjectAgentsApi(caller));
        this.alertmanagementalerts = new LazyValue<>(() -> new GitLabProjectAlertManagementAlertsApi(caller));
        this.analytics = new LazyValue<>(() -> new GitLabAnalyticsApi(caller));
        this.appearance = new LazyValue<>(() -> new GitLabAppearanceApi(caller));
        this.applications = new LazyValue<>(() -> new GitLabApplicationsApi(caller));
        this.attestations = new LazyValue<>(() -> new GitLabProjectAttestationsApi(caller));
        this.auditevents = new LazyValue<>(() -> new GitLabAuditEventsApi(caller));
        this.authn = new LazyValue<>(() -> new GitLabAuthnApi(caller));
        this.avatar = new LazyValue<>(() -> new GitLabAvatarApi(caller));
        this.batchedbackgroundmigrations = new LazyValue<>(() -> new GitLabBatchedBackgroundMigrationsApi(caller));
        this.branches = new LazyValue<>(() -> new GitLabProjectBranchesApi(caller));
        this.broadcastmessages = new LazyValue<>(() -> new GitLabBroadcastMessagesApi(caller));
        this.clusterdiscoverycertificatebaseddeprecated =
                new LazyValue<>(() -> new GitLabClusterDiscoveryCertificateBasedDeprecatedApi(caller));
        this.codereviewanalytics = new LazyValue<>(() -> new GitLabCodeReviewAnalyticsApi(caller));
        this.codesearch = new LazyValue<>(() -> new GitLabCodeSearchApi(caller));
        this.codesnippets = new LazyValue<>(() -> new GitLabCodeSnippetsApi(caller));
        this.codesuggestions = new LazyValue<>(() -> new GitLabCodeSuggestionsApi(caller));
        this.commits = new LazyValue<>(() -> new GitLabProjectCommitsApi(caller));
        this.complianceandpolicysettings = new LazyValue<>(() -> new GitLabComplianceAndPolicySettingsApi(caller));
        this.composerdistributions = new LazyValue<>(() -> new GitLabProjectComposerDistributionsApi(caller));
        this.conanv1distributions = new LazyValue<>(() -> new GitLabProjectConanV1DistributionsApi(caller));
        this.conanv2distributions = new LazyValue<>(() -> new GitLabProjectConanV2DistributionsApi(caller));
        this.containerregistry = new LazyValue<>(() -> new GitLabProjectContainerRegistryApi(caller));
        this.containerregistryprotectiontagrules =
                new LazyValue<>(() -> new GitLabProjectContainerRegistryProtectionTagRulesApi(caller));
        this.customattributes = new LazyValue<>(() -> new GitLabCustomAttributesApi(caller));
        this.databasedictionary = new LazyValue<>(() -> new GitLabDatabaseDictionaryApi(caller));
        this.databasemigrations = new LazyValue<>(() -> new GitLabDatabaseMigrationsApi(caller));
        this.datamanagement = new LazyValue<>(() -> new GitLabDataManagementApi(caller));
        this.debiandistributions = new LazyValue<>(() -> new GitLabDebianDistributionsApi(caller));
        this.debianpackages = new LazyValue<>(() -> new GitLabProjectDebianPackagesApi(caller));
        this.dependencies = new LazyValue<>(() -> new GitLabProjectDependenciesApi(caller));
        this.dependencylistexports = new LazyValue<>(() -> new GitLabDependencyListExportsApi(caller));
        this.dependencymanagement = new LazyValue<>(() -> new GitLabDependencyManagementApi(caller));
        this.dependencyproxy = new LazyValue<>(() -> new GitLabGroupDependencyProxyApi(caller));
        this.deploykeys = new LazyValue<>(() -> new GitLabDeployKeysApi(caller));
        this.deployments = new LazyValue<>(() -> new GitLabProjectDeploymentsApi(caller));
        this.deploytokens = new LazyValue<>(() -> new GitLabDeployTokensApi(caller));
        this.devopsresearchandassessmentdorametrics =
                new LazyValue<>(() -> new GitLabDevOpsResearchAndAssessmentDORAMetricsApi(caller));
        this.discussions = new LazyValue<>(() -> new GitLabDiscussionsApi(caller));
        this.dockerfiletemplates = new LazyValue<>(() -> new GitLabDockerfileTemplatesApi(caller));
        this.draftnotes = new LazyValue<>(() -> new GitLabProjectDraftNotesApi(caller));
        this.emojireactions = new LazyValue<>(() -> new GitLabProjectEmojiReactionsApi(caller));
        this.environments = new LazyValue<>(() -> new GitLabProjectEnvironmentsApi(caller));
        this.epicissues = new LazyValue<>(() -> new GitLabGroupEpicIssuesApi(caller));
        this.epiclinks = new LazyValue<>(() -> new GitLabGroupEpicLinksApi(caller));
        this.epics = new LazyValue<>(() -> new GitLabGroupEpicsApi(caller));
        this.errortracking = new LazyValue<>(() -> new GitLabProjectErrorTrackingApi(caller));
        this.events = new LazyValue<>(() -> new GitLabEventsApi(caller));
        this.experiments = new LazyValue<>(() -> new GitLabExperimentsApi(caller));
        this.externalstatuschecks = new LazyValue<>(() -> new GitLabProjectExternalStatusChecksApi(caller));
        this.featureflags = new LazyValue<>(() -> new GitLabFeatureFlagsApi(caller));
        this.featureflaguserlists = new LazyValue<>(() -> new GitLabProjectFeatureFlagUserListsApi(caller));
        this.freezeperiods = new LazyValue<>(() -> new GitLabProjectFreezePeriodsApi(caller));
        this.geo = new LazyValue<>(() -> new GitLabGeoApi(caller));
        this.geonodes = new LazyValue<>(() -> new GitLabGeoNodesApi(caller));
        this.geosites = new LazyValue<>(() -> new GitLabGeoSitesApi(caller));
        this.gitignoretemplates = new LazyValue<>(() -> new GitLabGitignoreTemplatesApi(caller));
        this.gitlabcicdyamltemplates = new LazyValue<>(() -> new GitLabCICDYAMLTemplatesApi(caller));
        this.gitlabduo = new LazyValue<>(() -> new GitLabDuoApi(caller));
        this.gitlabduoagentplatformflows = new LazyValue<>(() -> new GitLabDuoAgentPlatformFlowsApi(caller));
        this.gitlabduochatcompletions = new LazyValue<>(() -> new GitLabDuoChatCompletionsApi(caller));
        this.glql = new LazyValue<>(() -> new GitLabGLQLApi(caller));
        this.googlecloudintegration = new LazyValue<>(() -> new GitLabProjectGoogleCloudIntegrationApi(caller));
        this.goproxy = new LazyValue<>(() -> new GitLabProjectGoProxyApi(caller));
        this.groupandprojectmigrationbydirecttransfer =
                new LazyValue<>(() -> new GitLabGroupAndProjectMigrationByDirectTransferApi(caller));
        this.groupbadges = new LazyValue<>(() -> new GitLabGroupGroupBadgesApi(caller));
        this.groupenterpriseusers = new LazyValue<>(() -> new GitLabGroupGroupEnterpriseUsersApi(caller));
        this.groupepicboards = new LazyValue<>(() -> new GitLabGroupGroupEpicBoardsApi(caller));
        this.groupimportandexport = new LazyValue<>(() -> new GitLabGroupGroupImportAndExportApi(caller));
        this.groupintegrations = new LazyValue<>(() -> new GitLabGroupGroupIntegrationsApi(caller));
        this.groupissueboards = new LazyValue<>(() -> new GitLabGroupGroupIssueBoardsApi(caller));
        this.groupiterations = new LazyValue<>(() -> new GitLabGroupGroupIterationsApi(caller));
        this.grouplabels = new LazyValue<>(() -> new GitLabGroupGroupLabelsApi(caller));
        this.grouplevelprotectedbranches = new LazyValue<>(() -> new GitLabGroupGroupLevelProtectedBranchesApi(caller));
        this.grouplevelprotectedenvironments =
                new LazyValue<>(() -> new GitLabGroupGroupLevelProtectedEnvironmentsApi(caller));
        this.grouplevelvariables = new LazyValue<>(() -> new GitLabGroupGroupLevelVariablesApi(caller));
        this.groupmarkdownuploads = new LazyValue<>(() -> new GitLabGroupGroupMarkdownUploadsApi(caller));
        this.groupmilestones = new LazyValue<>(() -> new GitLabGroupGroupMilestonesApi(caller));
        this.groupplaceholderreassignments =
                new LazyValue<>(() -> new GitLabGroupGroupPlaceholderReassignmentsApi(caller));
        this.grouppushrules = new LazyValue<>(() -> new GitLabGroupGroupPushRulesApi(caller));
        this.groupreleases = new LazyValue<>(() -> new GitLabGroupGroupReleasesApi(caller));
        this.grouprepositorystoragemoves = new LazyValue<>(() -> new GitLabGroupRepositoryStorageMovesApi(caller));
        this.groups = new LazyValue<>(() -> new GitLabGroupGroupsApi(caller));
        this.groupsecuritysettings = new LazyValue<>(() -> new GitLabGroupGroupSecuritySettingsApi(caller));
        this.groupsshcertificates = new LazyValue<>(() -> new GitLabGroupGroupSSHCertificatesApi(caller));
        this.groupwebhooks = new LazyValue<>(() -> new GitLabGroupGroupWebhooksApi(caller));
        this.groupwikis = new LazyValue<>(() -> new GitLabGroupGroupWikisApi(caller));
        this.importrepositoryfrombitbucketserver =
                new LazyValue<>(() -> new GitLabImportRepositoryFromBitbucketServerApi(caller));
        this.importrepositoryfromgithub = new LazyValue<>(() -> new GitLabImportRepositoryFromGitHubApi(caller));
        this.instanceclusters = new LazyValue<>(() -> new GitLabInstanceClustersApi(caller));
        this.instancelevelcicdvariables = new LazyValue<>(() -> new GitLabInstanceLevelCICDVariablesApi(caller));
        this.integrations = new LazyValue<>(() -> new GitLabProjectIntegrationsApi(caller));
        this.invitations = new LazyValue<>(() -> new GitLabInvitationsApi(caller));
        this.issueboards = new LazyValue<>(() -> new GitLabProjectIssueBoardsApi(caller));
        this.issuelinks = new LazyValue<>(() -> new GitLabProjectIssueLinksApi(caller));
        this.issues = new LazyValue<>(() -> new GitLabIssuesApi(caller));
        this.issuesstatistics = new LazyValue<>(() -> new GitLabIssuesStatisticsApi(caller));
        this.iterations = new LazyValue<>(() -> new GitLabProjectIterationsApi(caller));
        this.jiraconnectsubscriptions = new LazyValue<>(() -> new GitLabJiraConnectSubscriptionsApi(caller));
        this.jiraforgeinstallation = new LazyValue<>(() -> new GitLabJiraForgeInstallationApi(caller));
        this.jiraforgesubscriptions = new LazyValue<>(() -> new GitLabJiraForgeSubscriptionsApi(caller));
        this.jiraforgeuserdelegation = new LazyValue<>(() -> new GitLabJiraForgeUserDelegationApi(caller));
        this.jobs = new LazyValue<>(() -> new GitLabJobsApi(caller));
        this.jobsartifacts = new LazyValue<>(() -> new GitLabProjectJobsArtifactsApi(caller));
        this.keys = new LazyValue<>(() -> new GitLabKeysApi(caller));
        this.knowledgegraph = new LazyValue<>(() -> new GitLabKnowledgeGraphApi(caller));
        this.labels = new LazyValue<>(() -> new GitLabProjectLabelsApi(caller));
        this.ldap = new LazyValue<>(() -> new GitLabLDAPApi(caller));
        this.ldapgrouplinks = new LazyValue<>(() -> new GitLabGroupLDAPGroupLinksApi(caller));
        this.license = new LazyValue<>(() -> new GitLabLicenseApi(caller));
        this.linkedepics = new LazyValue<>(() -> new GitLabGroupLinkedEpicsApi(caller));
        this.markdown = new LazyValue<>(() -> new GitLabMarkdownApi(caller));
        this.markdownuploads = new LazyValue<>(() -> new GitLabProjectMarkdownUploadsApi(caller));
        this.mavenrepository = new LazyValue<>(() -> new GitLabProjectMavenRepositoryApi(caller));
        this.memberroles = new LazyValue<>(() -> new GitLabGroupMemberRolesApi(caller));
        this.members = new LazyValue<>(() -> new GitLabMembersApi(caller));
        this.mergerequestapprovals = new LazyValue<>(() -> new GitLabProjectMergeRequestApprovalsApi(caller));
        this.mergerequestapprovalsettings = new LazyValue<>(() -> new GitLabMergeRequestApprovalSettingsApi(caller));
        this.mergerequestcontextcommits = new LazyValue<>(() -> new GitLabProjectMergeRequestContextCommitsApi(caller));
        this.mergerequests = new LazyValue<>(() -> new GitLabMergeRequestsApi(caller));
        this.mergetrains = new LazyValue<>(() -> new GitLabProjectMergeTrainsApi(caller));
        this.metadata = new LazyValue<>(() -> new GitLabProjectMetadataApi(caller));
        this.migrations = new LazyValue<>(() -> new GitLabMigrationsApi(caller));
        this.mobilepushsubscriptions = new LazyValue<>(() -> new GitLabMobilePushSubscriptionsApi(caller));
        this.modelregistry = new LazyValue<>(() -> new GitLabProjectModelRegistryApi(caller));
        this.namespaces = new LazyValue<>(() -> new GitLabNamespacesApi(caller));
        this.notes = new LazyValue<>(() -> new GitLabNotesApi(caller));
        this.notificationsettings = new LazyValue<>(() -> new GitLabNotificationSettingsApi(caller));
        this.npmrepository = new LazyValue<>(() -> new GitLabProjectNPMRepositoryApi(caller));
        this.nugetpackages = new LazyValue<>(() -> new GitLabProjectNuGetPackagesApi(caller));
        this.offlinetransfers = new LazyValue<>(() -> new GitLabOfflineTransfersApi(caller));
        this.opensourcelicensetemplates = new LazyValue<>(() -> new GitLabOpenSourceLicenseTemplatesApi(caller));
        this.orbit = new LazyValue<>(() -> new GitLabOrbitApi(caller));
        this.organizations = new LazyValue<>(() -> new GitLabOrganizationsApi(caller));
        this.packages = new LazyValue<>(() -> new GitLabProjectPackagesApi(caller));
        this.pagesdomains = new LazyValue<>(() -> new GitLabPagesDomainsApi(caller));
        this.pagessettings = new LazyValue<>(() -> new GitLabProjectPagesSettingsApi(caller));
        this.personalaccesstokens = new LazyValue<>(() -> new GitLabPersonalAccessTokensApi(caller));
        this.pipelines = new LazyValue<>(() -> new GitLabProjectPipelinesApi(caller));
        this.pipelineschedules = new LazyValue<>(() -> new GitLabProjectPipelineSchedulesApi(caller));
        this.pipelinetriggers = new LazyValue<>(() -> new GitLabProjectPipelineTriggersApi(caller));
        this.planlimits = new LazyValue<>(() -> new GitLabPlanLimitsApi(caller));
        this.projectaliases = new LazyValue<>(() -> new GitLabProjectAliasesApi(caller));
        this.projectbadges = new LazyValue<>(() -> new GitLabProjectProjectBadgesApi(caller));
        this.projectcicdjobtokenscope = new LazyValue<>(() -> new GitLabProjectProjectCICDJobTokenScopeApi(caller));
        this.projectclusters = new LazyValue<>(() -> new GitLabProjectProjectClustersApi(caller));
        this.projectforks = new LazyValue<>(() -> new GitLabProjectProjectForksApi(caller));
        this.projectimport = new LazyValue<>(() -> new GitLabProjectImportApi(caller));
        this.projectimportexport = new LazyValue<>(() -> new GitLabProjectProjectImportExportApi(caller));
        this.projectlevelsecurefiles = new LazyValue<>(() -> new GitLabProjectProjectLevelSecureFilesApi(caller));
        this.projectlevelvariables = new LazyValue<>(() -> new GitLabProjectProjectLevelVariablesApi(caller));
        this.projectmilestones = new LazyValue<>(() -> new GitLabProjectProjectMilestonesApi(caller));
        this.projectpushrules = new LazyValue<>(() -> new GitLabProjectProjectPushRulesApi(caller));
        this.projectrelationsexport = new LazyValue<>(() -> new GitLabProjectProjectRelationsExportApi(caller));
        this.projectrepositorystoragemoves = new LazyValue<>(() -> new GitLabProjectRepositoryStorageMovesApi(caller));
        this.projects = new LazyValue<>(() -> new GitLabProjectsApi(caller));
        this.projectsecuritysettings = new LazyValue<>(() -> new GitLabProjectProjectSecuritySettingsApi(caller));
        this.projectsnippets = new LazyValue<>(() -> new GitLabProjectProjectSnippetsApi(caller));
        this.projectstarring = new LazyValue<>(() -> new GitLabProjectProjectStarringApi(caller));
        this.projectstatistics = new LazyValue<>(() -> new GitLabProjectProjectStatisticsApi(caller));
        this.projecttemplates = new LazyValue<>(() -> new GitLabProjectProjectTemplatesApi(caller));
        this.projectvulnerabilities = new LazyValue<>(() -> new GitLabProjectProjectVulnerabilitiesApi(caller));
        this.projectwebhooks = new LazyValue<>(() -> new GitLabProjectProjectWebhooksApi(caller));
        this.projectwikis = new LazyValue<>(() -> new GitLabProjectProjectWikisApi(caller));
        this.protectedbranches = new LazyValue<>(() -> new GitLabProjectProtectedBranchesApi(caller));
        this.protectedcontainerregistry = new LazyValue<>(() -> new GitLabProjectProtectedContainerRegistryApi(caller));
        this.protectedenvironments = new LazyValue<>(() -> new GitLabProjectProtectedEnvironmentsApi(caller));
        this.protectedpackages = new LazyValue<>(() -> new GitLabProjectProtectedPackagesApi(caller));
        this.protectedtags = new LazyValue<>(() -> new GitLabProjectProtectedTagsApi(caller));
        this.pullmirroring = new LazyValue<>(() -> new GitLabProjectPullMirroringApi(caller));
        this.pypipackages = new LazyValue<>(() -> new GitLabProjectPyPIPackagesApi(caller));
        this.releaselinks = new LazyValue<>(() -> new GitLabProjectReleaseLinksApi(caller));
        this.releases = new LazyValue<>(() -> new GitLabProjectReleasesApi(caller));
        this.remotemirrors = new LazyValue<>(() -> new GitLabProjectRemoteMirrorsApi(caller));
        this.repositories = new LazyValue<>(() -> new GitLabProjectRepositoriesApi(caller));
        this.repositoryfiles = new LazyValue<>(() -> new GitLabProjectRepositoryFilesApi(caller));
        this.repositorysubmodules = new LazyValue<>(() -> new GitLabProjectRepositorySubmodulesApi(caller));
        this.resourcegroup = new LazyValue<>(() -> new GitLabProjectResourceGroupApi(caller));
        this.resourceiterationevents = new LazyValue<>(() -> new GitLabProjectResourceIterationEventsApi(caller));
        this.resourcelabelevents = new LazyValue<>(() -> new GitLabResourceLabelEventsApi(caller));
        this.resourcemilestoneevents = new LazyValue<>(() -> new GitLabProjectResourceMilestoneEventsApi(caller));
        this.resourcestateevents = new LazyValue<>(() -> new GitLabResourceStateEventsApi(caller));
        this.resourceweightevents = new LazyValue<>(() -> new GitLabProjectResourceWeightEventsApi(caller));
        this.rollouts = new LazyValue<>(() -> new GitLabRolloutsApi(caller));
        this.rubygems = new LazyValue<>(() -> new GitLabProjectRubyGemsApi(caller));
        this.runnercontrollers = new LazyValue<>(() -> new GitLabRunnerControllersApi(caller));
        this.runnercontrollertokens = new LazyValue<>(() -> new GitLabRunnerControllerTokensApi(caller));
        this.runners = new LazyValue<>(() -> new GitLabRunnersApi(caller));
        this.saml = new LazyValue<>(() -> new GitLabGroupSAMLApi(caller));
        this.scim = new LazyValue<>(() -> new GitLabGroupSCIMApi(caller));
        this.search = new LazyValue<>(() -> new GitLabSearchApi(caller));
        this.searchadmin = new LazyValue<>(() -> new GitLabSearchAdminApi(caller));
        this.serviceaccounts = new LazyValue<>(() -> new GitLabServiceAccountsApi(caller));
        this.servicedata = new LazyValue<>(() -> new GitLabServiceDataApi(caller));
        this.settings = new LazyValue<>(() -> new GitLabSettingsApi(caller));
        this.sidekiq = new LazyValue<>(() -> new GitLabSidekiqApi(caller));
        this.sidekiqmetrics = new LazyValue<>(() -> new GitLabSidekiqMetricsApi(caller));
        this.sidekiqqueuesadministration = new LazyValue<>(() -> new GitLabSidekiqQueuesAdministrationApi(caller));
        this.snippetrepositorystoragemoves = new LazyValue<>(() -> new GitLabSnippetRepositoryStorageMovesApi(caller));
        this.softwarecompositionanalysis = new LazyValue<>(() -> new GitLabSoftwareCompositionAnalysisApi(caller));
        this.statistics = new LazyValue<>(() -> new GitLabStatisticsApi(caller));
        this.suggestions = new LazyValue<>(() -> new GitLabSuggestionsApi(caller));
        this.systemhooks = new LazyValue<>(() -> new GitLabSystemHooksApi(caller));
        this.tags = new LazyValue<>(() -> new GitLabProjectTagsApi(caller));
        this.terraformmodules = new LazyValue<>(() -> new GitLabProjectTerraformModulesApi(caller));
        this.terraformstate = new LazyValue<>(() -> new GitLabProjectTerraformStateApi(caller));
        this.todos = new LazyValue<>(() -> new GitLabToDosApi(caller));
        this.tokenexchange = new LazyValue<>(() -> new GitLabTokenExchangeApi(caller));
        this.topics = new LazyValue<>(() -> new GitLabTopicsApi(caller));
        this.unleash = new LazyValue<>(() -> new GitLabUnleashApi(caller));
        this.userapplications = new LazyValue<>(() -> new GitLabUserApplicationsApi(caller));
        this.useremailaddresses = new LazyValue<>(() -> new GitLabUserEmailAddressesApi(caller));
        this.userfollowandunfollow = new LazyValue<>(() -> new GitLabUserFollowAndUnfollowApi(caller));
        this.usermoderation = new LazyValue<>(() -> new GitLabUserModerationApi(caller));
        this.users = new LazyValue<>(() -> new GitLabUsersApi(caller));
        this.usersshandgpgkeys = new LazyValue<>(() -> new GitLabUserSSHAndGPGKeysApi(caller));
        this.usertokens = new LazyValue<>(() -> new GitLabUserTokensApi(caller));
        this.validategitlabciymlfile = new LazyValue<>(() -> new GitLabProjectValidateGitlabCiYmlFileApi(caller));
        this.vscode = new LazyValue<>(() -> new GitLabVSCodeApi(caller));
        this.vulnerabilities = new LazyValue<>(() -> new GitLabProjectVulnerabilitiesApi(caller));
        this.vulnerabilityfindings = new LazyValue<>(() -> new GitLabProjectVulnerabilityFindingsApi(caller));
        this.webcommits = new LazyValue<>(() -> new GitLabWebCommitsApi(caller));
    }

    /**
     * The APIs over the caller of {@code client}.
     *
     * @param client the client that sends the calls
     * @return the facade
     * @throws NullPointerException if {@code client} is {@code null}
     */
    public static GitLab of(final GitLabClient client) {
        return new GitLab(GitLabCaller.of(client));
    }

    /**
     * The accessrequests API.
     *
     * @return the API
     */
    public GitLabAccessRequestsApi accessrequests() {
        return accessrequests.get();
    }

    /**
     * The accesstokens API.
     *
     * @return the API
     */
    public GitLabAccessTokensApi accesstokens() {
        return accesstokens.get();
    }

    /**
     * The activecontext API.
     *
     * @return the API
     */
    public GitLabActiveContextApi activecontext() {
        return activecontext.get();
    }

    /**
     * The advancedsearchrollout API.
     *
     * @return the API
     */
    public GitLabAdvancedSearchRolloutApi advancedsearchrollout() {
        return advancedsearchrollout.get();
    }

    /**
     * The agents API.
     *
     * @return the API
     */
    public GitLabProjectAgentsApi agents() {
        return agents.get();
    }

    /**
     * The alertmanagementalerts API.
     *
     * @return the API
     */
    public GitLabProjectAlertManagementAlertsApi alertmanagementalerts() {
        return alertmanagementalerts.get();
    }

    /**
     * The analytics API.
     *
     * @return the API
     */
    public GitLabAnalyticsApi analytics() {
        return analytics.get();
    }

    /**
     * The appearance API.
     *
     * @return the API
     */
    public GitLabAppearanceApi appearance() {
        return appearance.get();
    }

    /**
     * The applications API.
     *
     * @return the API
     */
    public GitLabApplicationsApi applications() {
        return applications.get();
    }

    /**
     * The attestations API.
     *
     * @return the API
     */
    public GitLabProjectAttestationsApi attestations() {
        return attestations.get();
    }

    /**
     * The auditevents API.
     *
     * @return the API
     */
    public GitLabAuditEventsApi auditevents() {
        return auditevents.get();
    }

    /**
     * The authn API.
     *
     * @return the API
     */
    public GitLabAuthnApi authn() {
        return authn.get();
    }

    /**
     * The avatar API.
     *
     * @return the API
     */
    public GitLabAvatarApi avatar() {
        return avatar.get();
    }

    /**
     * The batchedbackgroundmigrations API.
     *
     * @return the API
     */
    public GitLabBatchedBackgroundMigrationsApi batchedbackgroundmigrations() {
        return batchedbackgroundmigrations.get();
    }

    /**
     * The branches API.
     *
     * @return the API
     */
    public GitLabProjectBranchesApi branches() {
        return branches.get();
    }

    /**
     * The broadcastmessages API.
     *
     * @return the API
     */
    public GitLabBroadcastMessagesApi broadcastmessages() {
        return broadcastmessages.get();
    }

    /**
     * The clusterdiscoverycertificatebaseddeprecated API.
     *
     * @return the API
     */
    public GitLabClusterDiscoveryCertificateBasedDeprecatedApi clusterdiscoverycertificatebaseddeprecated() {
        return clusterdiscoverycertificatebaseddeprecated.get();
    }

    /**
     * The codereviewanalytics API.
     *
     * @return the API
     */
    public GitLabCodeReviewAnalyticsApi codereviewanalytics() {
        return codereviewanalytics.get();
    }

    /**
     * The codesearch API.
     *
     * @return the API
     */
    public GitLabCodeSearchApi codesearch() {
        return codesearch.get();
    }

    /**
     * The codesnippets API.
     *
     * @return the API
     */
    public GitLabCodeSnippetsApi codesnippets() {
        return codesnippets.get();
    }

    /**
     * The codesuggestions API.
     *
     * @return the API
     */
    public GitLabCodeSuggestionsApi codesuggestions() {
        return codesuggestions.get();
    }

    /**
     * The commits API.
     *
     * @return the API
     */
    public GitLabProjectCommitsApi commits() {
        return commits.get();
    }

    /**
     * The complianceandpolicysettings API.
     *
     * @return the API
     */
    public GitLabComplianceAndPolicySettingsApi complianceandpolicysettings() {
        return complianceandpolicysettings.get();
    }

    /**
     * The composerdistributions API.
     *
     * @return the API
     */
    public GitLabProjectComposerDistributionsApi composerdistributions() {
        return composerdistributions.get();
    }

    /**
     * The conanv1distributions API.
     *
     * @return the API
     */
    public GitLabProjectConanV1DistributionsApi conanv1distributions() {
        return conanv1distributions.get();
    }

    /**
     * The conanv2distributions API.
     *
     * @return the API
     */
    public GitLabProjectConanV2DistributionsApi conanv2distributions() {
        return conanv2distributions.get();
    }

    /**
     * The containerregistry API.
     *
     * @return the API
     */
    public GitLabProjectContainerRegistryApi containerregistry() {
        return containerregistry.get();
    }

    /**
     * The containerregistryprotectiontagrules API.
     *
     * @return the API
     */
    public GitLabProjectContainerRegistryProtectionTagRulesApi containerregistryprotectiontagrules() {
        return containerregistryprotectiontagrules.get();
    }

    /**
     * The customattributes API.
     *
     * @return the API
     */
    public GitLabCustomAttributesApi customattributes() {
        return customattributes.get();
    }

    /**
     * The databasedictionary API.
     *
     * @return the API
     */
    public GitLabDatabaseDictionaryApi databasedictionary() {
        return databasedictionary.get();
    }

    /**
     * The databasemigrations API.
     *
     * @return the API
     */
    public GitLabDatabaseMigrationsApi databasemigrations() {
        return databasemigrations.get();
    }

    /**
     * The datamanagement API.
     *
     * @return the API
     */
    public GitLabDataManagementApi datamanagement() {
        return datamanagement.get();
    }

    /**
     * The debiandistributions API.
     *
     * @return the API
     */
    public GitLabDebianDistributionsApi debiandistributions() {
        return debiandistributions.get();
    }

    /**
     * The debianpackages API.
     *
     * @return the API
     */
    public GitLabProjectDebianPackagesApi debianpackages() {
        return debianpackages.get();
    }

    /**
     * The dependencies API.
     *
     * @return the API
     */
    public GitLabProjectDependenciesApi dependencies() {
        return dependencies.get();
    }

    /**
     * The dependencylistexports API.
     *
     * @return the API
     */
    public GitLabDependencyListExportsApi dependencylistexports() {
        return dependencylistexports.get();
    }

    /**
     * The dependencymanagement API.
     *
     * @return the API
     */
    public GitLabDependencyManagementApi dependencymanagement() {
        return dependencymanagement.get();
    }

    /**
     * The dependencyproxy API.
     *
     * @return the API
     */
    public GitLabGroupDependencyProxyApi dependencyproxy() {
        return dependencyproxy.get();
    }

    /**
     * The deploykeys API.
     *
     * @return the API
     */
    public GitLabDeployKeysApi deploykeys() {
        return deploykeys.get();
    }

    /**
     * The deployments API.
     *
     * @return the API
     */
    public GitLabProjectDeploymentsApi deployments() {
        return deployments.get();
    }

    /**
     * The deploytokens API.
     *
     * @return the API
     */
    public GitLabDeployTokensApi deploytokens() {
        return deploytokens.get();
    }

    /**
     * The devopsresearchandassessmentdorametrics API.
     *
     * @return the API
     */
    public GitLabDevOpsResearchAndAssessmentDORAMetricsApi devopsresearchandassessmentdorametrics() {
        return devopsresearchandassessmentdorametrics.get();
    }

    /**
     * The discussions API.
     *
     * @return the API
     */
    public GitLabDiscussionsApi discussions() {
        return discussions.get();
    }

    /**
     * The dockerfiletemplates API.
     *
     * @return the API
     */
    public GitLabDockerfileTemplatesApi dockerfiletemplates() {
        return dockerfiletemplates.get();
    }

    /**
     * The draftnotes API.
     *
     * @return the API
     */
    public GitLabProjectDraftNotesApi draftnotes() {
        return draftnotes.get();
    }

    /**
     * The emojireactions API.
     *
     * @return the API
     */
    public GitLabProjectEmojiReactionsApi emojireactions() {
        return emojireactions.get();
    }

    /**
     * The environments API.
     *
     * @return the API
     */
    public GitLabProjectEnvironmentsApi environments() {
        return environments.get();
    }

    /**
     * The epicissues API.
     *
     * @return the API
     */
    public GitLabGroupEpicIssuesApi epicissues() {
        return epicissues.get();
    }

    /**
     * The epiclinks API.
     *
     * @return the API
     */
    public GitLabGroupEpicLinksApi epiclinks() {
        return epiclinks.get();
    }

    /**
     * The epics API.
     *
     * @return the API
     */
    public GitLabGroupEpicsApi epics() {
        return epics.get();
    }

    /**
     * The errortracking API.
     *
     * @return the API
     */
    public GitLabProjectErrorTrackingApi errortracking() {
        return errortracking.get();
    }

    /**
     * The events API.
     *
     * @return the API
     */
    public GitLabEventsApi events() {
        return events.get();
    }

    /**
     * The experiments API.
     *
     * @return the API
     */
    public GitLabExperimentsApi experiments() {
        return experiments.get();
    }

    /**
     * The externalstatuschecks API.
     *
     * @return the API
     */
    public GitLabProjectExternalStatusChecksApi externalstatuschecks() {
        return externalstatuschecks.get();
    }

    /**
     * The featureflags API.
     *
     * @return the API
     */
    public GitLabFeatureFlagsApi featureflags() {
        return featureflags.get();
    }

    /**
     * The featureflaguserlists API.
     *
     * @return the API
     */
    public GitLabProjectFeatureFlagUserListsApi featureflaguserlists() {
        return featureflaguserlists.get();
    }

    /**
     * The freezeperiods API.
     *
     * @return the API
     */
    public GitLabProjectFreezePeriodsApi freezeperiods() {
        return freezeperiods.get();
    }

    /**
     * The geo API.
     *
     * @return the API
     */
    public GitLabGeoApi geo() {
        return geo.get();
    }

    /**
     * The geonodes API.
     *
     * @return the API
     */
    public GitLabGeoNodesApi geonodes() {
        return geonodes.get();
    }

    /**
     * The geosites API.
     *
     * @return the API
     */
    public GitLabGeoSitesApi geosites() {
        return geosites.get();
    }

    /**
     * The gitignoretemplates API.
     *
     * @return the API
     */
    public GitLabGitignoreTemplatesApi gitignoretemplates() {
        return gitignoretemplates.get();
    }

    /**
     * The gitlabcicdyamltemplates API.
     *
     * @return the API
     */
    public GitLabCICDYAMLTemplatesApi gitlabcicdyamltemplates() {
        return gitlabcicdyamltemplates.get();
    }

    /**
     * The gitlabduo API.
     *
     * @return the API
     */
    public GitLabDuoApi gitlabduo() {
        return gitlabduo.get();
    }

    /**
     * The gitlabduoagentplatformflows API.
     *
     * @return the API
     */
    public GitLabDuoAgentPlatformFlowsApi gitlabduoagentplatformflows() {
        return gitlabduoagentplatformflows.get();
    }

    /**
     * The gitlabduochatcompletions API.
     *
     * @return the API
     */
    public GitLabDuoChatCompletionsApi gitlabduochatcompletions() {
        return gitlabduochatcompletions.get();
    }

    /**
     * The glql API.
     *
     * @return the API
     */
    public GitLabGLQLApi glql() {
        return glql.get();
    }

    /**
     * The googlecloudintegration API.
     *
     * @return the API
     */
    public GitLabProjectGoogleCloudIntegrationApi googlecloudintegration() {
        return googlecloudintegration.get();
    }

    /**
     * The goproxy API.
     *
     * @return the API
     */
    public GitLabProjectGoProxyApi goproxy() {
        return goproxy.get();
    }

    /**
     * The groupandprojectmigrationbydirecttransfer API.
     *
     * @return the API
     */
    public GitLabGroupAndProjectMigrationByDirectTransferApi groupandprojectmigrationbydirecttransfer() {
        return groupandprojectmigrationbydirecttransfer.get();
    }

    /**
     * The groupbadges API.
     *
     * @return the API
     */
    public GitLabGroupGroupBadgesApi groupbadges() {
        return groupbadges.get();
    }

    /**
     * The groupenterpriseusers API.
     *
     * @return the API
     */
    public GitLabGroupGroupEnterpriseUsersApi groupenterpriseusers() {
        return groupenterpriseusers.get();
    }

    /**
     * The groupepicboards API.
     *
     * @return the API
     */
    public GitLabGroupGroupEpicBoardsApi groupepicboards() {
        return groupepicboards.get();
    }

    /**
     * The groupimportandexport API.
     *
     * @return the API
     */
    public GitLabGroupGroupImportAndExportApi groupimportandexport() {
        return groupimportandexport.get();
    }

    /**
     * The groupintegrations API.
     *
     * @return the API
     */
    public GitLabGroupGroupIntegrationsApi groupintegrations() {
        return groupintegrations.get();
    }

    /**
     * The groupissueboards API.
     *
     * @return the API
     */
    public GitLabGroupGroupIssueBoardsApi groupissueboards() {
        return groupissueboards.get();
    }

    /**
     * The groupiterations API.
     *
     * @return the API
     */
    public GitLabGroupGroupIterationsApi groupiterations() {
        return groupiterations.get();
    }

    /**
     * The grouplabels API.
     *
     * @return the API
     */
    public GitLabGroupGroupLabelsApi grouplabels() {
        return grouplabels.get();
    }

    /**
     * The grouplevelprotectedbranches API.
     *
     * @return the API
     */
    public GitLabGroupGroupLevelProtectedBranchesApi grouplevelprotectedbranches() {
        return grouplevelprotectedbranches.get();
    }

    /**
     * The grouplevelprotectedenvironments API.
     *
     * @return the API
     */
    public GitLabGroupGroupLevelProtectedEnvironmentsApi grouplevelprotectedenvironments() {
        return grouplevelprotectedenvironments.get();
    }

    /**
     * The grouplevelvariables API.
     *
     * @return the API
     */
    public GitLabGroupGroupLevelVariablesApi grouplevelvariables() {
        return grouplevelvariables.get();
    }

    /**
     * The groupmarkdownuploads API.
     *
     * @return the API
     */
    public GitLabGroupGroupMarkdownUploadsApi groupmarkdownuploads() {
        return groupmarkdownuploads.get();
    }

    /**
     * The groupmilestones API.
     *
     * @return the API
     */
    public GitLabGroupGroupMilestonesApi groupmilestones() {
        return groupmilestones.get();
    }

    /**
     * The groupplaceholderreassignments API.
     *
     * @return the API
     */
    public GitLabGroupGroupPlaceholderReassignmentsApi groupplaceholderreassignments() {
        return groupplaceholderreassignments.get();
    }

    /**
     * The grouppushrules API.
     *
     * @return the API
     */
    public GitLabGroupGroupPushRulesApi grouppushrules() {
        return grouppushrules.get();
    }

    /**
     * The groupreleases API.
     *
     * @return the API
     */
    public GitLabGroupGroupReleasesApi groupreleases() {
        return groupreleases.get();
    }

    /**
     * The grouprepositorystoragemoves API.
     *
     * @return the API
     */
    public GitLabGroupRepositoryStorageMovesApi grouprepositorystoragemoves() {
        return grouprepositorystoragemoves.get();
    }

    /**
     * The groups API.
     *
     * @return the API
     */
    public GitLabGroupGroupsApi groups() {
        return groups.get();
    }

    /**
     * The groupsecuritysettings API.
     *
     * @return the API
     */
    public GitLabGroupGroupSecuritySettingsApi groupsecuritysettings() {
        return groupsecuritysettings.get();
    }

    /**
     * The groupsshcertificates API.
     *
     * @return the API
     */
    public GitLabGroupGroupSSHCertificatesApi groupsshcertificates() {
        return groupsshcertificates.get();
    }

    /**
     * The groupwebhooks API.
     *
     * @return the API
     */
    public GitLabGroupGroupWebhooksApi groupwebhooks() {
        return groupwebhooks.get();
    }

    /**
     * The groupwikis API.
     *
     * @return the API
     */
    public GitLabGroupGroupWikisApi groupwikis() {
        return groupwikis.get();
    }

    /**
     * The importrepositoryfrombitbucketserver API.
     *
     * @return the API
     */
    public GitLabImportRepositoryFromBitbucketServerApi importrepositoryfrombitbucketserver() {
        return importrepositoryfrombitbucketserver.get();
    }

    /**
     * The importrepositoryfromgithub API.
     *
     * @return the API
     */
    public GitLabImportRepositoryFromGitHubApi importrepositoryfromgithub() {
        return importrepositoryfromgithub.get();
    }

    /**
     * The instanceclusters API.
     *
     * @return the API
     */
    public GitLabInstanceClustersApi instanceclusters() {
        return instanceclusters.get();
    }

    /**
     * The instancelevelcicdvariables API.
     *
     * @return the API
     */
    public GitLabInstanceLevelCICDVariablesApi instancelevelcicdvariables() {
        return instancelevelcicdvariables.get();
    }

    /**
     * The integrations API.
     *
     * @return the API
     */
    public GitLabProjectIntegrationsApi integrations() {
        return integrations.get();
    }

    /**
     * The invitations API.
     *
     * @return the API
     */
    public GitLabInvitationsApi invitations() {
        return invitations.get();
    }

    /**
     * The issueboards API.
     *
     * @return the API
     */
    public GitLabProjectIssueBoardsApi issueboards() {
        return issueboards.get();
    }

    /**
     * The issuelinks API.
     *
     * @return the API
     */
    public GitLabProjectIssueLinksApi issuelinks() {
        return issuelinks.get();
    }

    /**
     * The issues API.
     *
     * @return the API
     */
    public GitLabIssuesApi issues() {
        return issues.get();
    }

    /**
     * The issuesstatistics API.
     *
     * @return the API
     */
    public GitLabIssuesStatisticsApi issuesstatistics() {
        return issuesstatistics.get();
    }

    /**
     * The iterations API.
     *
     * @return the API
     */
    public GitLabProjectIterationsApi iterations() {
        return iterations.get();
    }

    /**
     * The jiraconnectsubscriptions API.
     *
     * @return the API
     */
    public GitLabJiraConnectSubscriptionsApi jiraconnectsubscriptions() {
        return jiraconnectsubscriptions.get();
    }

    /**
     * The jiraforgeinstallation API.
     *
     * @return the API
     */
    public GitLabJiraForgeInstallationApi jiraforgeinstallation() {
        return jiraforgeinstallation.get();
    }

    /**
     * The jiraforgesubscriptions API.
     *
     * @return the API
     */
    public GitLabJiraForgeSubscriptionsApi jiraforgesubscriptions() {
        return jiraforgesubscriptions.get();
    }

    /**
     * The jiraforgeuserdelegation API.
     *
     * @return the API
     */
    public GitLabJiraForgeUserDelegationApi jiraforgeuserdelegation() {
        return jiraforgeuserdelegation.get();
    }

    /**
     * The jobs API.
     *
     * @return the API
     */
    public GitLabJobsApi jobs() {
        return jobs.get();
    }

    /**
     * The jobsartifacts API.
     *
     * @return the API
     */
    public GitLabProjectJobsArtifactsApi jobsartifacts() {
        return jobsartifacts.get();
    }

    /**
     * The keys API.
     *
     * @return the API
     */
    public GitLabKeysApi keys() {
        return keys.get();
    }

    /**
     * The knowledgegraph API.
     *
     * @return the API
     */
    public GitLabKnowledgeGraphApi knowledgegraph() {
        return knowledgegraph.get();
    }

    /**
     * The labels API.
     *
     * @return the API
     */
    public GitLabProjectLabelsApi labels() {
        return labels.get();
    }

    /**
     * The ldap API.
     *
     * @return the API
     */
    public GitLabLDAPApi ldap() {
        return ldap.get();
    }

    /**
     * The ldapgrouplinks API.
     *
     * @return the API
     */
    public GitLabGroupLDAPGroupLinksApi ldapgrouplinks() {
        return ldapgrouplinks.get();
    }

    /**
     * The license API.
     *
     * @return the API
     */
    public GitLabLicenseApi license() {
        return license.get();
    }

    /**
     * The linkedepics API.
     *
     * @return the API
     */
    public GitLabGroupLinkedEpicsApi linkedepics() {
        return linkedepics.get();
    }

    /**
     * The markdown API.
     *
     * @return the API
     */
    public GitLabMarkdownApi markdown() {
        return markdown.get();
    }

    /**
     * The markdownuploads API.
     *
     * @return the API
     */
    public GitLabProjectMarkdownUploadsApi markdownuploads() {
        return markdownuploads.get();
    }

    /**
     * The mavenrepository API.
     *
     * @return the API
     */
    public GitLabProjectMavenRepositoryApi mavenrepository() {
        return mavenrepository.get();
    }

    /**
     * The memberroles API.
     *
     * @return the API
     */
    public GitLabGroupMemberRolesApi memberroles() {
        return memberroles.get();
    }

    /**
     * The members API.
     *
     * @return the API
     */
    public GitLabMembersApi members() {
        return members.get();
    }

    /**
     * The mergerequestapprovals API.
     *
     * @return the API
     */
    public GitLabProjectMergeRequestApprovalsApi mergerequestapprovals() {
        return mergerequestapprovals.get();
    }

    /**
     * The mergerequestapprovalsettings API.
     *
     * @return the API
     */
    public GitLabMergeRequestApprovalSettingsApi mergerequestapprovalsettings() {
        return mergerequestapprovalsettings.get();
    }

    /**
     * The mergerequestcontextcommits API.
     *
     * @return the API
     */
    public GitLabProjectMergeRequestContextCommitsApi mergerequestcontextcommits() {
        return mergerequestcontextcommits.get();
    }

    /**
     * The mergerequests API.
     *
     * @return the API
     */
    public GitLabMergeRequestsApi mergerequests() {
        return mergerequests.get();
    }

    /**
     * The mergetrains API.
     *
     * @return the API
     */
    public GitLabProjectMergeTrainsApi mergetrains() {
        return mergetrains.get();
    }

    /**
     * The metadata API.
     *
     * @return the API
     */
    public GitLabProjectMetadataApi metadata() {
        return metadata.get();
    }

    /**
     * The migrations API.
     *
     * @return the API
     */
    public GitLabMigrationsApi migrations() {
        return migrations.get();
    }

    /**
     * The mobilepushsubscriptions API.
     *
     * @return the API
     */
    public GitLabMobilePushSubscriptionsApi mobilepushsubscriptions() {
        return mobilepushsubscriptions.get();
    }

    /**
     * The modelregistry API.
     *
     * @return the API
     */
    public GitLabProjectModelRegistryApi modelregistry() {
        return modelregistry.get();
    }

    /**
     * The namespaces API.
     *
     * @return the API
     */
    public GitLabNamespacesApi namespaces() {
        return namespaces.get();
    }

    /**
     * The notes API.
     *
     * @return the API
     */
    public GitLabNotesApi notes() {
        return notes.get();
    }

    /**
     * The notificationsettings API.
     *
     * @return the API
     */
    public GitLabNotificationSettingsApi notificationsettings() {
        return notificationsettings.get();
    }

    /**
     * The npmrepository API.
     *
     * @return the API
     */
    public GitLabProjectNPMRepositoryApi npmrepository() {
        return npmrepository.get();
    }

    /**
     * The nugetpackages API.
     *
     * @return the API
     */
    public GitLabProjectNuGetPackagesApi nugetpackages() {
        return nugetpackages.get();
    }

    /**
     * The offlinetransfers API.
     *
     * @return the API
     */
    public GitLabOfflineTransfersApi offlinetransfers() {
        return offlinetransfers.get();
    }

    /**
     * The opensourcelicensetemplates API.
     *
     * @return the API
     */
    public GitLabOpenSourceLicenseTemplatesApi opensourcelicensetemplates() {
        return opensourcelicensetemplates.get();
    }

    /**
     * The orbit API.
     *
     * @return the API
     */
    public GitLabOrbitApi orbit() {
        return orbit.get();
    }

    /**
     * The organizations API.
     *
     * @return the API
     */
    public GitLabOrganizationsApi organizations() {
        return organizations.get();
    }

    /**
     * The packages API.
     *
     * @return the API
     */
    public GitLabProjectPackagesApi packages() {
        return packages.get();
    }

    /**
     * The pagesdomains API.
     *
     * @return the API
     */
    public GitLabPagesDomainsApi pagesdomains() {
        return pagesdomains.get();
    }

    /**
     * The pagessettings API.
     *
     * @return the API
     */
    public GitLabProjectPagesSettingsApi pagessettings() {
        return pagessettings.get();
    }

    /**
     * The personalaccesstokens API.
     *
     * @return the API
     */
    public GitLabPersonalAccessTokensApi personalaccesstokens() {
        return personalaccesstokens.get();
    }

    /**
     * The pipelines API.
     *
     * @return the API
     */
    public GitLabProjectPipelinesApi pipelines() {
        return pipelines.get();
    }

    /**
     * The pipelineschedules API.
     *
     * @return the API
     */
    public GitLabProjectPipelineSchedulesApi pipelineschedules() {
        return pipelineschedules.get();
    }

    /**
     * The pipelinetriggers API.
     *
     * @return the API
     */
    public GitLabProjectPipelineTriggersApi pipelinetriggers() {
        return pipelinetriggers.get();
    }

    /**
     * The planlimits API.
     *
     * @return the API
     */
    public GitLabPlanLimitsApi planlimits() {
        return planlimits.get();
    }

    /**
     * The projectaliases API.
     *
     * @return the API
     */
    public GitLabProjectAliasesApi projectaliases() {
        return projectaliases.get();
    }

    /**
     * The projectbadges API.
     *
     * @return the API
     */
    public GitLabProjectProjectBadgesApi projectbadges() {
        return projectbadges.get();
    }

    /**
     * The projectcicdjobtokenscope API.
     *
     * @return the API
     */
    public GitLabProjectProjectCICDJobTokenScopeApi projectcicdjobtokenscope() {
        return projectcicdjobtokenscope.get();
    }

    /**
     * The projectclusters API.
     *
     * @return the API
     */
    public GitLabProjectProjectClustersApi projectclusters() {
        return projectclusters.get();
    }

    /**
     * The projectforks API.
     *
     * @return the API
     */
    public GitLabProjectProjectForksApi projectforks() {
        return projectforks.get();
    }

    /**
     * The projectimport API.
     *
     * @return the API
     */
    public GitLabProjectImportApi projectimport() {
        return projectimport.get();
    }

    /**
     * The projectimportexport API.
     *
     * @return the API
     */
    public GitLabProjectProjectImportExportApi projectimportexport() {
        return projectimportexport.get();
    }

    /**
     * The projectlevelsecurefiles API.
     *
     * @return the API
     */
    public GitLabProjectProjectLevelSecureFilesApi projectlevelsecurefiles() {
        return projectlevelsecurefiles.get();
    }

    /**
     * The projectlevelvariables API.
     *
     * @return the API
     */
    public GitLabProjectProjectLevelVariablesApi projectlevelvariables() {
        return projectlevelvariables.get();
    }

    /**
     * The projectmilestones API.
     *
     * @return the API
     */
    public GitLabProjectProjectMilestonesApi projectmilestones() {
        return projectmilestones.get();
    }

    /**
     * The projectpushrules API.
     *
     * @return the API
     */
    public GitLabProjectProjectPushRulesApi projectpushrules() {
        return projectpushrules.get();
    }

    /**
     * The projectrelationsexport API.
     *
     * @return the API
     */
    public GitLabProjectProjectRelationsExportApi projectrelationsexport() {
        return projectrelationsexport.get();
    }

    /**
     * The projectrepositorystoragemoves API.
     *
     * @return the API
     */
    public GitLabProjectRepositoryStorageMovesApi projectrepositorystoragemoves() {
        return projectrepositorystoragemoves.get();
    }

    /**
     * The projects API.
     *
     * @return the API
     */
    public GitLabProjectsApi projects() {
        return projects.get();
    }

    /**
     * The projectsecuritysettings API.
     *
     * @return the API
     */
    public GitLabProjectProjectSecuritySettingsApi projectsecuritysettings() {
        return projectsecuritysettings.get();
    }

    /**
     * The projectsnippets API.
     *
     * @return the API
     */
    public GitLabProjectProjectSnippetsApi projectsnippets() {
        return projectsnippets.get();
    }

    /**
     * The projectstarring API.
     *
     * @return the API
     */
    public GitLabProjectProjectStarringApi projectstarring() {
        return projectstarring.get();
    }

    /**
     * The projectstatistics API.
     *
     * @return the API
     */
    public GitLabProjectProjectStatisticsApi projectstatistics() {
        return projectstatistics.get();
    }

    /**
     * The projecttemplates API.
     *
     * @return the API
     */
    public GitLabProjectProjectTemplatesApi projecttemplates() {
        return projecttemplates.get();
    }

    /**
     * The projectvulnerabilities API.
     *
     * @return the API
     */
    public GitLabProjectProjectVulnerabilitiesApi projectvulnerabilities() {
        return projectvulnerabilities.get();
    }

    /**
     * The projectwebhooks API.
     *
     * @return the API
     */
    public GitLabProjectProjectWebhooksApi projectwebhooks() {
        return projectwebhooks.get();
    }

    /**
     * The projectwikis API.
     *
     * @return the API
     */
    public GitLabProjectProjectWikisApi projectwikis() {
        return projectwikis.get();
    }

    /**
     * The protectedbranches API.
     *
     * @return the API
     */
    public GitLabProjectProtectedBranchesApi protectedbranches() {
        return protectedbranches.get();
    }

    /**
     * The protectedcontainerregistry API.
     *
     * @return the API
     */
    public GitLabProjectProtectedContainerRegistryApi protectedcontainerregistry() {
        return protectedcontainerregistry.get();
    }

    /**
     * The protectedenvironments API.
     *
     * @return the API
     */
    public GitLabProjectProtectedEnvironmentsApi protectedenvironments() {
        return protectedenvironments.get();
    }

    /**
     * The protectedpackages API.
     *
     * @return the API
     */
    public GitLabProjectProtectedPackagesApi protectedpackages() {
        return protectedpackages.get();
    }

    /**
     * The protectedtags API.
     *
     * @return the API
     */
    public GitLabProjectProtectedTagsApi protectedtags() {
        return protectedtags.get();
    }

    /**
     * The pullmirroring API.
     *
     * @return the API
     */
    public GitLabProjectPullMirroringApi pullmirroring() {
        return pullmirroring.get();
    }

    /**
     * The pypipackages API.
     *
     * @return the API
     */
    public GitLabProjectPyPIPackagesApi pypipackages() {
        return pypipackages.get();
    }

    /**
     * The releaselinks API.
     *
     * @return the API
     */
    public GitLabProjectReleaseLinksApi releaselinks() {
        return releaselinks.get();
    }

    /**
     * The releases API.
     *
     * @return the API
     */
    public GitLabProjectReleasesApi releases() {
        return releases.get();
    }

    /**
     * The remotemirrors API.
     *
     * @return the API
     */
    public GitLabProjectRemoteMirrorsApi remotemirrors() {
        return remotemirrors.get();
    }

    /**
     * The repositories API.
     *
     * @return the API
     */
    public GitLabProjectRepositoriesApi repositories() {
        return repositories.get();
    }

    /**
     * The repositoryfiles API.
     *
     * @return the API
     */
    public GitLabProjectRepositoryFilesApi repositoryfiles() {
        return repositoryfiles.get();
    }

    /**
     * The repositorysubmodules API.
     *
     * @return the API
     */
    public GitLabProjectRepositorySubmodulesApi repositorysubmodules() {
        return repositorysubmodules.get();
    }

    /**
     * The resourcegroup API.
     *
     * @return the API
     */
    public GitLabProjectResourceGroupApi resourcegroup() {
        return resourcegroup.get();
    }

    /**
     * The resourceiterationevents API.
     *
     * @return the API
     */
    public GitLabProjectResourceIterationEventsApi resourceiterationevents() {
        return resourceiterationevents.get();
    }

    /**
     * The resourcelabelevents API.
     *
     * @return the API
     */
    public GitLabResourceLabelEventsApi resourcelabelevents() {
        return resourcelabelevents.get();
    }

    /**
     * The resourcemilestoneevents API.
     *
     * @return the API
     */
    public GitLabProjectResourceMilestoneEventsApi resourcemilestoneevents() {
        return resourcemilestoneevents.get();
    }

    /**
     * The resourcestateevents API.
     *
     * @return the API
     */
    public GitLabResourceStateEventsApi resourcestateevents() {
        return resourcestateevents.get();
    }

    /**
     * The resourceweightevents API.
     *
     * @return the API
     */
    public GitLabProjectResourceWeightEventsApi resourceweightevents() {
        return resourceweightevents.get();
    }

    /**
     * The rollouts API.
     *
     * @return the API
     */
    public GitLabRolloutsApi rollouts() {
        return rollouts.get();
    }

    /**
     * The rubygems API.
     *
     * @return the API
     */
    public GitLabProjectRubyGemsApi rubygems() {
        return rubygems.get();
    }

    /**
     * The runnercontrollers API.
     *
     * @return the API
     */
    public GitLabRunnerControllersApi runnercontrollers() {
        return runnercontrollers.get();
    }

    /**
     * The runnercontrollertokens API.
     *
     * @return the API
     */
    public GitLabRunnerControllerTokensApi runnercontrollertokens() {
        return runnercontrollertokens.get();
    }

    /**
     * The runners API.
     *
     * @return the API
     */
    public GitLabRunnersApi runners() {
        return runners.get();
    }

    /**
     * The saml API.
     *
     * @return the API
     */
    public GitLabGroupSAMLApi saml() {
        return saml.get();
    }

    /**
     * The scim API.
     *
     * @return the API
     */
    public GitLabGroupSCIMApi scim() {
        return scim.get();
    }

    /**
     * The search API.
     *
     * @return the API
     */
    public GitLabSearchApi search() {
        return search.get();
    }

    /**
     * The searchadmin API.
     *
     * @return the API
     */
    public GitLabSearchAdminApi searchadmin() {
        return searchadmin.get();
    }

    /**
     * The serviceaccounts API.
     *
     * @return the API
     */
    public GitLabServiceAccountsApi serviceaccounts() {
        return serviceaccounts.get();
    }

    /**
     * The servicedata API.
     *
     * @return the API
     */
    public GitLabServiceDataApi servicedata() {
        return servicedata.get();
    }

    /**
     * The settings API.
     *
     * @return the API
     */
    public GitLabSettingsApi settings() {
        return settings.get();
    }

    /**
     * The sidekiq API.
     *
     * @return the API
     */
    public GitLabSidekiqApi sidekiq() {
        return sidekiq.get();
    }

    /**
     * The sidekiqmetrics API.
     *
     * @return the API
     */
    public GitLabSidekiqMetricsApi sidekiqmetrics() {
        return sidekiqmetrics.get();
    }

    /**
     * The sidekiqqueuesadministration API.
     *
     * @return the API
     */
    public GitLabSidekiqQueuesAdministrationApi sidekiqqueuesadministration() {
        return sidekiqqueuesadministration.get();
    }

    /**
     * The snippetrepositorystoragemoves API.
     *
     * @return the API
     */
    public GitLabSnippetRepositoryStorageMovesApi snippetrepositorystoragemoves() {
        return snippetrepositorystoragemoves.get();
    }

    /**
     * The softwarecompositionanalysis API.
     *
     * @return the API
     */
    public GitLabSoftwareCompositionAnalysisApi softwarecompositionanalysis() {
        return softwarecompositionanalysis.get();
    }

    /**
     * The statistics API.
     *
     * @return the API
     */
    public GitLabStatisticsApi statistics() {
        return statistics.get();
    }

    /**
     * The suggestions API.
     *
     * @return the API
     */
    public GitLabSuggestionsApi suggestions() {
        return suggestions.get();
    }

    /**
     * The systemhooks API.
     *
     * @return the API
     */
    public GitLabSystemHooksApi systemhooks() {
        return systemhooks.get();
    }

    /**
     * The tags API.
     *
     * @return the API
     */
    public GitLabProjectTagsApi tags() {
        return tags.get();
    }

    /**
     * The terraformmodules API.
     *
     * @return the API
     */
    public GitLabProjectTerraformModulesApi terraformmodules() {
        return terraformmodules.get();
    }

    /**
     * The terraformstate API.
     *
     * @return the API
     */
    public GitLabProjectTerraformStateApi terraformstate() {
        return terraformstate.get();
    }

    /**
     * The todos API.
     *
     * @return the API
     */
    public GitLabToDosApi todos() {
        return todos.get();
    }

    /**
     * The tokenexchange API.
     *
     * @return the API
     */
    public GitLabTokenExchangeApi tokenexchange() {
        return tokenexchange.get();
    }

    /**
     * The topics API.
     *
     * @return the API
     */
    public GitLabTopicsApi topics() {
        return topics.get();
    }

    /**
     * The unleash API.
     *
     * @return the API
     */
    public GitLabUnleashApi unleash() {
        return unleash.get();
    }

    /**
     * The userapplications API.
     *
     * @return the API
     */
    public GitLabUserApplicationsApi userapplications() {
        return userapplications.get();
    }

    /**
     * The useremailaddresses API.
     *
     * @return the API
     */
    public GitLabUserEmailAddressesApi useremailaddresses() {
        return useremailaddresses.get();
    }

    /**
     * The userfollowandunfollow API.
     *
     * @return the API
     */
    public GitLabUserFollowAndUnfollowApi userfollowandunfollow() {
        return userfollowandunfollow.get();
    }

    /**
     * The usermoderation API.
     *
     * @return the API
     */
    public GitLabUserModerationApi usermoderation() {
        return usermoderation.get();
    }

    /**
     * The users API.
     *
     * @return the API
     */
    public GitLabUsersApi users() {
        return users.get();
    }

    /**
     * The usersshandgpgkeys API.
     *
     * @return the API
     */
    public GitLabUserSSHAndGPGKeysApi usersshandgpgkeys() {
        return usersshandgpgkeys.get();
    }

    /**
     * The usertokens API.
     *
     * @return the API
     */
    public GitLabUserTokensApi usertokens() {
        return usertokens.get();
    }

    /**
     * The validategitlabciymlfile API.
     *
     * @return the API
     */
    public GitLabProjectValidateGitlabCiYmlFileApi validategitlabciymlfile() {
        return validategitlabciymlfile.get();
    }

    /**
     * The vscode API.
     *
     * @return the API
     */
    public GitLabVSCodeApi vscode() {
        return vscode.get();
    }

    /**
     * The vulnerabilities API.
     *
     * @return the API
     */
    public GitLabProjectVulnerabilitiesApi vulnerabilities() {
        return vulnerabilities.get();
    }

    /**
     * The vulnerabilityfindings API.
     *
     * @return the API
     */
    public GitLabProjectVulnerabilityFindingsApi vulnerabilityfindings() {
        return vulnerabilityfindings.get();
    }

    /**
     * The webcommits API.
     *
     * @return the API
     */
    public GitLabWebCommitsApi webcommits() {
        return webcommits.get();
    }
}
