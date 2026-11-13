package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSettingsUpdateOtherMoreTest {

    @Test
    void constructor_shouldAcceptNull_whenIssuesCreateLimitIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .issuesCreateLimit(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.issuesCreateLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRawBlobRequestLimitIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .rawBlobRequestLimit(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.rawBlobRequestLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRawBlobRequestLimitUnauthenticatedIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .rawBlobRequestLimitUnauthenticated(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.rawBlobRequestLimitUnauthenticated()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReleaseEvidenceCollectionsLimitPerUserIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .releaseEvidenceCollectionsLimitPerUser(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.releaseEvidenceCollectionsLimitPerUser()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReleaseWritesLimitPerProjectIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .releaseWritesLimitPerProject(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.releaseWritesLimitPerProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReleaseWritesLimitPerUserIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .releaseWritesLimitPerUser(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.releaseWritesLimitPerUser()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageMaxContentBytesIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .wikiPageMaxContentBytes(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.wikiPageMaxContentBytes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiAsciidocAllowUriIncludesIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .wikiAsciidocAllowUriIncludes(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.wikiAsciidocAllowUriIncludes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiReadRequestLimitUnauthenticatedIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .wikiReadRequestLimitUnauthenticated(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.wikiReadRequestLimitUnauthenticated()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionAndNoteMaxSizeIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .descriptionAndNoteMaxSize(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.descriptionAndNoteMaxSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWhatsNewVariantIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .whatsNewVariant(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.whatsNewVariant()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFlocEnabledIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .flocEnabled(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.flocEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShowMigrateFromJenkinsBannerIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .showMigrateFromJenkinsBanner(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.showMigrateFromJenkinsBanner()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnableArtifactExternalRedirectWarningPageIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .enableArtifactExternalRedirectWarningPage(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.enableArtifactExternalRedirectWarningPage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnableLanguageServerRestrictionsIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .enableLanguageServerRestrictions(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.enableLanguageServerRestrictions()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnableMemberPromotionManagementIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .enableMemberPromotionManagement(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.enableMemberPromotionManagement()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineLimitPerProjectUserShaIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .pipelineLimitPerProjectUserSha(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.pipelineLimitPerProjectUserSha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineLimitPerUserIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .pipelineLimitPerUser(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.pipelineLimitPerUser()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineCancelLimitPerUserProjectIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .pipelineCancelLimitPerUserProject(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.pipelineCancelLimitPerUserProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineRetryLimitPerUserProjectIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .pipelineRetryLimitPerUserProject(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.pipelineRetryLimitPerUserProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineScheduleManagementLimitPerUserIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .pipelineScheduleManagementLimitPerUser(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.pipelineScheduleManagementLimitPerUser()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineDeleteLimitPerUserProjectIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .pipelineDeleteLimitPerUserProject(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.pipelineDeleteLimitPerUserProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineExecutionPoliciesPerConfigurationLimitIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .pipelineExecutionPoliciesPerConfigurationLimit(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.pipelineExecutionPoliciesPerConfigurationLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraConnectApplicationKeyIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .jiraConnectApplicationKey(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.jiraConnectApplicationKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraConnectPublicKeyStorageEnabledIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .jiraConnectPublicKeyStorageEnabled(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.jiraConnectPublicKeyStorageEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraConnectProxyUrlIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .jiraConnectProxyUrl(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.jiraConnectProxyUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraConnectDomainAllowlistIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .jiraConnectDomainAllowlist(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.jiraConnectDomainAllowlist()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraConnectDomainAllowlistRawIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .jiraConnectDomainAllowlistRaw(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.jiraConnectDomainAllowlistRaw()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraForgeAppIdIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .jiraForgeAppId(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.jiraForgeAppId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraConnectAdditionalAudienceUrlIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .jiraConnectAdditionalAudienceUrl(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.jiraConnectAdditionalAudienceUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBulkImportConcurrentPipelineBatchLimitIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .bulkImportConcurrentPipelineBatchLimit(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.bulkImportConcurrentPipelineBatchLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBulkImportEnabledIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .bulkImportEnabled(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.bulkImportEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBulkImportMaxDownloadFileIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .bulkImportMaxDownloadFile(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.bulkImportMaxDownloadFile()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBulkImportMaxDownloadFileSizeIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .bulkImportMaxDownloadFileSize(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.bulkImportMaxDownloadFileSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConcurrentRelationBatchExportLimitIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .concurrentRelationBatchExportLimit(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.concurrentRelationBatchExportLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConcurrentGithubImportJobsLimitIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .concurrentGithubImportJobsLimit(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.concurrentGithubImportJobsLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConcurrentBitbucketImportJobsLimitIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .concurrentBitbucketImportJobsLimit(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.concurrentBitbucketImportJobsLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConcurrentBitbucketServerImportJobsLimitIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .concurrentBitbucketServerImportJobsLimit(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.concurrentBitbucketServerImportJobsLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConcurrentPullRequestImportJobsLimitIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .concurrentPullRequestImportJobsLimit(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.concurrentPullRequestImportJobsLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConcurrentRelationExportLimitIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .concurrentRelationExportLimit(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.concurrentRelationExportLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutocompleteUsersLimitIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .autocompleteUsersLimit(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.autocompleteUsersLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutocompleteUsersUnauthenticatedLimitIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .autocompleteUsersUnauthenticatedLimit(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.autocompleteUsersUnauthenticatedLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitPushPipelineLimitIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .gitPushPipelineLimit(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.gitPushPipelineLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitTwoFactorSessionExpiryIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .gitTwoFactorSessionExpiry(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.gitTwoFactorSessionExpiry()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitRateLimitUsersAllowlistIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .gitRateLimitUsersAllowlist(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.gitRateLimitUsersAllowlist()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitRateLimitUsersAlertlistIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .gitRateLimitUsersAlertlist(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.gitRateLimitUsersAlertlist()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecurityPolicyGlobalGroupApproversEnabledIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .securityPolicyGlobalGroupApproversEnabled(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.securityPolicyGlobalGroupApproversEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecurityTxtContentIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .securityTxtContent(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.securityTxtContent()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecurityScanStaleAfterDaysIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .securityScanStaleAfterDays(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.securityScanStaleAfterDays()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecurityApprovalPoliciesLimitIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .securityApprovalPoliciesLimit(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.securityApprovalPoliciesLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecurityMrReportCacheLifetimeMinutesIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .securityMrReportCacheLifetimeMinutes(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.securityMrReportCacheLifetimeMinutes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSlackAppEnabledIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .slackAppEnabled(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.slackAppEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSlackAppIdIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .slackAppId(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.slackAppId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSlackAppSecretIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .slackAppSecret(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.slackAppSecret()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSlackAppSigningSecretIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .slackAppSigningSecret(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.slackAppSigningSecret()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSlackAppVerificationTokenIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .slackAppVerificationToken(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.slackAppVerificationToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespaceAggregationScheduleLeaseDurationInSecondsIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .namespaceAggregationScheduleLeaseDurationInSeconds(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.namespaceAggregationScheduleLeaseDurationInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDownstreamPipelineTriggerLimitPerProjectUserShaIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .downstreamPipelineTriggerLimitPerProjectUserSha(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.downstreamPipelineTriggerLimitPerProjectUserSha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobRetryLimitPerUserProjectIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .jobRetryLimitPerUserProject(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.jobRetryLimitPerUserProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobPlayLimitPerUserProjectIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .jobPlayLimitPerUserProject(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.jobPlayLimitPerUserProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobEraseLimitPerUserProjectIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .jobEraseLimitPerUserProject(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.jobEraseLimitPerUserProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobCancelLimitPerUserProjectIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .jobCancelLimitPerUserProject(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.jobCancelLimitPerUserProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiActionApiRateLimitIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .aiActionApiRateLimit(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.aiActionApiRateLimit()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenAiActionApiRateLimitIsBelowTheMinimum() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .aiActionApiRateLimit(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenAiActionApiRateLimitIsTheMinimum() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .aiActionApiRateLimit(1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiAuditEventsStreamingEnabledIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .aiAuditEventsStreamingEnabled(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.aiAuditEventsStreamingEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCodeSuggestionsApiRateLimitIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .codeSuggestionsApiRateLimit(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.codeSuggestionsApiRateLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCodeDropdownCustomClientsIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .codeDropdownCustomClients(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.codeDropdownCustomClients()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResourceUsageLimitsIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .resourceUsageLimits(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.resourceUsageLimits()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResourceAccessTokenNotifyInheritedIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .resourceAccessTokenNotifyInherited(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.resourceAccessTokenNotifyInherited()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVscodeExtensionMarketplaceIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .vscodeExtensionMarketplace(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.vscodeExtensionMarketplace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVscodeExtensionMarketplaceEnabledIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .vscodeExtensionMarketplaceEnabled(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.vscodeExtensionMarketplaceEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVscodeExtensionMarketplaceExtensionHostDomainIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .vscodeExtensionMarketplaceExtensionHostDomain(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.vscodeExtensionMarketplaceExtensionHostDomain()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVscodeExtensionMarketplaceSingleOriginFallbackEnabledIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .vscodeExtensionMarketplaceSingleOriginFallbackEnabled(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.vscodeExtensionMarketplaceSingleOriginFallbackEnabled())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinimumLanguageServerVersionIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .minimumLanguageServerVersion(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.minimumLanguageServerVersion()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinimumPasswordLengthIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .minimumPasswordLength(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.minimumPasswordLength()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTerraformStateEncryptionEnabledIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .terraformStateEncryptionEnabled(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.terraformStateEncryptionEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLoggingFieldSchemaVersionIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .loggingFieldSchemaVersion(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.loggingFieldSchemaVersion()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLoggingFieldDualEmitTargetIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .loggingFieldDualEmitTarget(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.loggingFieldDualEmitTarget()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRsaKeyRestrictionIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .rsaKeyRestriction(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.rsaKeyRestriction()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDsaKeyRestrictionIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .dsaKeyRestriction(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.dsaKeyRestriction()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEcdsaKeyRestrictionIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .ecdsaKeyRestriction(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.ecdsaKeyRestriction()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEcdsaSkKeyRestrictionIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .ecdsaSkKeyRestriction(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.ecdsaSkKeyRestriction()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEd25519KeyRestrictionIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .ed25519KeyRestriction(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.ed25519KeyRestriction()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEd25519SkKeyRestrictionIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .ed25519SkKeyRestriction(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.ed25519SkKeyRestriction()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchiveBuildsInHumanReadableIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .archiveBuildsInHumanReadable(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.archiveBuildsInHumanReadable()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAsciidocMaxIncludesIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .asciidocMaxIncludes(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.asciidocMaxIncludes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorizedKeysEnabledIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .authorizedKeysEnabled(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.authorizedKeysEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoAcceptAwardedAchievementsIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .autoAcceptAwardedAchievements(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.autoAcceptAwardedAchievements()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoDevopsDomainIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .autoDevopsDomain(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.autoDevopsDomain()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoDevopsEnabledIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .autoDevopsEnabled(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.autoDevopsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoBanUserOnExcessiveProjectsDownloadIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .autoBanUserOnExcessiveProjectsDownload(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.autoBanUserOnExcessiveProjectsDownload()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoDuoCodeReviewEnabledIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .autoDuoCodeReviewEnabled(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.autoDuoCodeReviewEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoDuoCodeReviewOnPushEnabledIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .autoDuoCodeReviewOnPushEnabled(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.autoDuoCodeReviewOnPushEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCanCreateGroupIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .canCreateGroup(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.canCreateGroup()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCanCreateOrganizationIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .canCreateOrganization(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.canCreateOrganization()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitEmailHostnameIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .commitEmailHostname(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.commitEmailHostname()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomHttpCloneUrlRootIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .customHttpCloneUrlRoot(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.customHttpCloneUrlRoot()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeleteInactiveProjectsIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .deleteInactiveProjects(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.deleteInactiveProjects()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeleteUnconfirmedUsersIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .deleteUnconfirmedUsers(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.deleteUnconfirmedUsers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeletionAdjournedPeriodIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .deletionAdjournedPeriod(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.deletionAdjournedPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiffMaxCommitsIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .diffMaxCommits(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.diffMaxCommits()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiffMaxFilesIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .diffMaxFiles(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.diffMaxFiles()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiffMaxLinesIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .diffMaxLines(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.diffMaxLines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiffMaxPatchBytesIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .diffMaxPatchBytes(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.diffMaxPatchBytes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiffMaxVersionsIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .diffMaxVersions(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.diffMaxVersions()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDnsRebindingProtectionEnabledIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .dnsRebindingProtectionEnabled(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.dnsRebindingProtectionEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnforceTermsIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .enforceTerms(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.enforceTerms()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnforceNamespaceStorageLimitIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .enforceNamespaceStorageLimit(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.enforceNamespaceStorageLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnforcePiplComplianceIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .enforcePiplCompliance(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.enforcePiplCompliance()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnforceCiInboundJobTokenScopeEnabledIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .enforceCiInboundJobTokenScopeEnabled(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.enforceCiInboundJobTokenScopeEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnforceEmailSubaddressRestrictionsIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .enforceEmailSubaddressRestrictions(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.enforceEmailSubaddressRestrictions()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnforceGranularTokensIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .enforceGranularTokens(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.enforceGranularTokens()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFailedLoginAttemptsUnlockPeriodInMinutesIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .failedLoginAttemptsUnlockPeriodInMinutes(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.failedLoginAttemptsUnlockPeriodInMinutes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFeatureFlagUserListWriteBytesLimitPerUserIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .featureFlagUserListWriteBytesLimitPerUser(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.featureFlagUserListWriteBytesLimitPerUser()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFirstDayOfWeekIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .firstDayOfWeek(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.firstDayOfWeek()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGithubGistsImportLimitIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .githubGistsImportLimit(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.githubGistsImportLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitlabDedicatedInstanceIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .gitlabDedicatedInstance(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.gitlabDedicatedInstance()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitlabEnvironmentToolkitInstanceIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .gitlabEnvironmentToolkitInstance(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.gitlabEnvironmentToolkitInstance()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitlabProductUsageDataEnabledIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .gitlabProductUsageDataEnabled(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.gitlabProductUsageDataEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitlabShellOperationLimitIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .gitlabShellOperationLimit(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.gitlabShellOperationLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitlabShellOperationPerActorLimitIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .gitlabShellOperationPerActorLimit(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.gitlabShellOperationPerActorLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHashedStorageEnabledIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .hashedStorageEnabled(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.hashedStorageEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHideThirdPartyOffersIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .hideThirdPartyOffers(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.hideThirdPartyOffers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInactiveProjectsDeleteAfterMonthsIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .inactiveProjectsDeleteAfterMonths(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.inactiveProjectsDeleteAfterMonths()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInactiveProjectsMinSizeMbIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .inactiveProjectsMinSizeMb(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.inactiveProjectsMinSizeMb()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInactiveProjectsSendWarningEmailAfterMonthsIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .inactiveProjectsSendWarningEmailAfterMonths(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.inactiveProjectsSendWarningEmailAfterMonths()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInactiveResourceAccessTokensDeleteAfterDaysIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .inactiveResourceAccessTokensDeleteAfterDays(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.inactiveResourceAccessTokensDeleteAfterDays()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncludeOptionalMetricsInServicePingIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .includeOptionalMetricsInServicePing(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.includeOptionalMetricsInServicePing()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKeepLatestArtifactIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .keepLatestArtifact(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.keepLatestArtifact()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMirrorAvailableIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .mirrorAvailable(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.mirrorAvailable()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMirrorCapacityThresholdIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .mirrorCapacityThreshold(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.mirrorCapacityThreshold()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMirrorMaxCapacityIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .mirrorMaxCapacity(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.mirrorMaxCapacity()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMirrorMaxDelayIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .mirrorMaxDelay(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.mirrorMaxDelay()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotifyOnUnknownSignInIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .notifyOnUnknownSignIn(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.notifyOnUnknownSignIn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOfflineTransferExportsEnabledIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .offlineTransferExportsEnabled(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.offlineTransferExportsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOfflineTransferImportsEnabledIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .offlineTransferImportsEnabled(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.offlineTransferImportsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageRegistryAllowAnyoneToPullOptionIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .packageRegistryAllowAnyoneToPullOption(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.packageRegistryAllowAnyoneToPullOption()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageRegistryCleanupPoliciesWorkerCapacityIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .packageRegistryCleanupPoliciesWorkerCapacity(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.packageRegistryCleanupPoliciesWorkerCapacity()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageMetadataPurlTypesIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .packageMetadataPurlTypes(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.packageMetadataPurlTypes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesDomainVerificationEnabledIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .pagesDomainVerificationEnabled(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.pagesDomainVerificationEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesUniqueDomainDefaultEnabledIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .pagesUniqueDomainDefaultEnabled(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.pagesUniqueDomainDefaultEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesExtraDeploymentsDefaultExpirySecondsIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .pagesExtraDeploymentsDefaultExpirySeconds(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.pagesExtraDeploymentsDefaultExpirySeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesDeploymentsApiLimitIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .pagesDeploymentsApiLimit(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.pagesDeploymentsApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectsApiRateLimitUnauthenticatedIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .projectsApiRateLimitUnauthenticated(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.projectsApiRateLimitUnauthenticated()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectsApiLimitIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .projectsApiLimit(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.projectsApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProtectedCiVariablesIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .protectedCiVariables(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.protectedCiVariables()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProtectedPathsRawIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .protectedPathsRaw(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.protectedPathsRaw()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProtectedPathsForGetRequestRawIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .protectedPathsForGetRequestRaw(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.protectedPathsForGetRequestRaw()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProtectedBranchWriteLimitIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .protectedBranchWriteLimit(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.protectedBranchWriteLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRateLimitingResponseTextIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .rateLimitingResponseText(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.rateLimitingResponseText()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReceiveMaxInputSizeIsNullable() {
        final GitLabSettingsUpdateOtherMoreBuilder builder = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .receiveMaxInputSize(null);

        final GitLabSettingsUpdateOtherMore built = builder.build();

        assertThat(built.receiveMaxInputSize()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSettingsUpdateOtherMore value = SettingsCatalogFixtures.settingsUpdateOtherMore();

        assertSoftly(softly -> {
            softly.assertThat(value.issuesCreateLimit()).isEqualTo(1);
            softly.assertThat(value.rawBlobRequestLimit()).isEqualTo(1);
            softly.assertThat(value.rawBlobRequestLimitUnauthenticated()).isEqualTo(1);
            softly.assertThat(value.releaseEvidenceCollectionsLimitPerUser()).isEqualTo(1);
            softly.assertThat(value.releaseWritesLimitPerProject()).isEqualTo(1);
            softly.assertThat(value.releaseWritesLimitPerUser()).isEqualTo(1);
            softly.assertThat(value.wikiPageMaxContentBytes()).isEqualTo(1L);
            softly.assertThat(value.wikiAsciidocAllowUriIncludes()).isEqualTo(true);
            softly.assertThat(value.wikiReadRequestLimitUnauthenticated())
                    .isEqualTo("wiki_read_request_limit_unauthenticated");
            softly.assertThat(value.descriptionAndNoteMaxSize()).isEqualTo(1L);
            softly.assertThat(value.whatsNewVariant()).isEqualTo(GitLabSettingsUpdateWhatsNewVariant.ALL_TIERS);
            softly.assertThat(value.flocEnabled()).isEqualTo(true);
            softly.assertThat(value.showMigrateFromJenkinsBanner()).isEqualTo(true);
            softly.assertThat(value.enableArtifactExternalRedirectWarningPage()).isEqualTo(true);
            softly.assertThat(value.enableLanguageServerRestrictions()).isEqualTo(true);
            softly.assertThat(value.enableMemberPromotionManagement()).isEqualTo("enable_member_promotion_management");
            softly.assertThat(value.pipelineLimitPerProjectUserSha()).isEqualTo(1);
            softly.assertThat(value.pipelineLimitPerUser()).isEqualTo(1);
            softly.assertThat(value.pipelineCancelLimitPerUserProject()).isEqualTo(1);
            softly.assertThat(value.pipelineRetryLimitPerUserProject()).isEqualTo(1);
            softly.assertThat(value.pipelineScheduleManagementLimitPerUser()).isEqualTo(1);
            softly.assertThat(value.pipelineDeleteLimitPerUserProject()).isEqualTo(1);
            softly.assertThat(value.pipelineExecutionPoliciesPerConfigurationLimit())
                    .isEqualTo("pipeline_execution_policies_per_configuration_limit");
            softly.assertThat(value.jiraConnectApplicationKey()).isEqualTo("jira_connect_application_key");
            softly.assertThat(value.jiraConnectPublicKeyStorageEnabled()).isEqualTo(true);
            softly.assertThat(value.jiraConnectProxyUrl()).isEqualTo("jira_connect_proxy_url");
            softly.assertThat(value.jiraConnectDomainAllowlist()).isEqualTo(List.of("jira_connect_domain_allowlist"));
            softly.assertThat(value.jiraConnectDomainAllowlistRaw()).isEqualTo("jira_connect_domain_allowlist_raw");
            softly.assertThat(value.jiraForgeAppId()).isEqualTo("jira_forge_app_id");
            softly.assertThat(value.jiraConnectAdditionalAudienceUrl())
                    .isEqualTo("jira_connect_additional_audience_url");
            softly.assertThat(value.bulkImportConcurrentPipelineBatchLimit()).isEqualTo(1);
            softly.assertThat(value.bulkImportEnabled()).isEqualTo(true);
            softly.assertThat(value.bulkImportMaxDownloadFile()).isEqualTo(1);
            softly.assertThat(value.bulkImportMaxDownloadFileSize()).isEqualTo("bulk_import_max_download_file_size");
            softly.assertThat(value.concurrentRelationBatchExportLimit()).isEqualTo(1);
            softly.assertThat(value.concurrentGithubImportJobsLimit()).isEqualTo(1);
            softly.assertThat(value.concurrentBitbucketImportJobsLimit()).isEqualTo(1);
            softly.assertThat(value.concurrentBitbucketServerImportJobsLimit()).isEqualTo(1);
            softly.assertThat(value.concurrentPullRequestImportJobsLimit()).isEqualTo(1);
            softly.assertThat(value.concurrentRelationExportLimit()).isEqualTo("concurrent_relation_export_limit");
            softly.assertThat(value.autocompleteUsersLimit()).isEqualTo(1);
            softly.assertThat(value.autocompleteUsersUnauthenticatedLimit()).isEqualTo(1);
            softly.assertThat(value.gitPushPipelineLimit()).isEqualTo(1);
            softly.assertThat(value.gitTwoFactorSessionExpiry()).isEqualTo(1);
            softly.assertThat(value.gitRateLimitUsersAllowlist()).isEqualTo(List.of("git_rate_limit_users_allowlist"));
            softly.assertThat(value.gitRateLimitUsersAlertlist()).isEqualTo(List.of(1));
            softly.assertThat(value.securityPolicyGlobalGroupApproversEnabled()).isEqualTo(true);
            softly.assertThat(value.securityTxtContent()).isEqualTo("security_txt_content");
            softly.assertThat(value.securityScanStaleAfterDays()).isEqualTo(1);
            softly.assertThat(value.securityApprovalPoliciesLimit()).isEqualTo("security_approval_policies_limit");
            softly.assertThat(value.securityMrReportCacheLifetimeMinutes())
                    .isEqualTo("security_mr_report_cache_lifetime_minutes");
            softly.assertThat(value.slackAppEnabled()).isEqualTo(true);
            softly.assertThat(value.slackAppId()).isEqualTo("slack_app_id");
            softly.assertThat(value.slackAppSecret()).isEqualTo("slack_app_secret");
            softly.assertThat(value.slackAppSigningSecret()).isEqualTo("slack_app_signing_secret");
            softly.assertThat(value.slackAppVerificationToken()).isEqualTo("slack_app_verification_token");
            softly.assertThat(value.namespaceAggregationScheduleLeaseDurationInSeconds())
                    .isEqualTo(1);
            softly.assertThat(value.downstreamPipelineTriggerLimitPerProjectUserSha())
                    .isEqualTo(1);
            softly.assertThat(value.jobRetryLimitPerUserProject()).isEqualTo(1);
            softly.assertThat(value.jobPlayLimitPerUserProject()).isEqualTo(1);
            softly.assertThat(value.jobEraseLimitPerUserProject()).isEqualTo(1);
            softly.assertThat(value.jobCancelLimitPerUserProject()).isEqualTo(1);
            softly.assertThat(value.aiActionApiRateLimit()).isEqualTo(1);
            softly.assertThat(value.aiAuditEventsStreamingEnabled()).isEqualTo("ai_audit_events_streaming_enabled");
            softly.assertThat(value.codeSuggestionsApiRateLimit()).isEqualTo(1);
            softly.assertThat(value.codeDropdownCustomClients())
                    .isEqualTo(List.of(SettingsCatalogFixtures.settingsUpdateCodeDropdownCustomClient()));
            softly.assertThat(value.resourceUsageLimits()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.resourceAccessTokenNotifyInherited())
                    .isEqualTo("resource_access_token_notify_inherited");
            softly.assertThat(value.vscodeExtensionMarketplace())
                    .isEqualTo(SettingsCatalogFixtures.settingsUpdateVscodeExtensionMarketplace());
            softly.assertThat(value.vscodeExtensionMarketplaceEnabled())
                    .isEqualTo("vscode_extension_marketplace_enabled");
            softly.assertThat(value.vscodeExtensionMarketplaceExtensionHostDomain())
                    .isEqualTo("vscode_extension_marketplace_extension_host_domain");
            softly.assertThat(value.vscodeExtensionMarketplaceSingleOriginFallbackEnabled())
                    .isEqualTo("vscode_extension_marketplace_single_origin_fallback_enabled");
            softly.assertThat(value.minimumLanguageServerVersion()).isEqualTo("minimum_language_server_version");
            softly.assertThat(value.minimumPasswordLength()).isEqualTo("minimum_password_length");
            softly.assertThat(value.terraformStateEncryptionEnabled()).isEqualTo(true);
            softly.assertThat(value.loggingFieldSchemaVersion())
                    .isEqualTo(GitLabSettingsUpdateLoggingFieldSchemaVersion.N_0);
            softly.assertThat(value.loggingFieldDualEmitTarget())
                    .isEqualTo(GitLabSettingsUpdateLoggingFieldDualEmitTarget.N_1);
            softly.assertThat(value.rsaKeyRestriction()).isEqualTo(GitLabSettingsUpdateRsaKeyRestriction.N_0);
            softly.assertThat(value.dsaKeyRestriction()).isEqualTo(GitLabSettingsUpdateDsaKeyRestriction.N_0);
            softly.assertThat(value.ecdsaKeyRestriction()).isEqualTo(GitLabSettingsUpdateEcdsaKeyRestriction.N_0);
            softly.assertThat(value.ecdsaSkKeyRestriction()).isEqualTo(GitLabSettingsUpdateEcdsaSkKeyRestriction.N_0);
            softly.assertThat(value.ed25519KeyRestriction()).isEqualTo(GitLabSettingsUpdateEd25519KeyRestriction.N_0);
            softly.assertThat(value.ed25519SkKeyRestriction())
                    .isEqualTo(GitLabSettingsUpdateEd25519SkKeyRestriction.N_0);
            softly.assertThat(value.archiveBuildsInHumanReadable()).isEqualTo("archive_builds_in_human_readable");
            softly.assertThat(value.asciidocMaxIncludes()).isEqualTo("asciidoc_max_includes");
            softly.assertThat(value.authorizedKeysEnabled()).isEqualTo("authorized_keys_enabled");
            softly.assertThat(value.autoAcceptAwardedAchievements()).isEqualTo("auto_accept_awarded_achievements");
            softly.assertThat(value.autoDevopsDomain()).isEqualTo("auto_devops_domain");
            softly.assertThat(value.autoDevopsEnabled()).isEqualTo("auto_devops_enabled");
            softly.assertThat(value.autoBanUserOnExcessiveProjectsDownload()).isEqualTo(true);
            softly.assertThat(value.autoDuoCodeReviewEnabled()).isEqualTo(true);
            softly.assertThat(value.autoDuoCodeReviewOnPushEnabled()).isEqualTo("auto_duo_code_review_on_push_enabled");
            softly.assertThat(value.canCreateGroup()).isEqualTo("can_create_group");
            softly.assertThat(value.canCreateOrganization()).isEqualTo("can_create_organization");
            softly.assertThat(value.commitEmailHostname()).isEqualTo("commit_email_hostname");
            softly.assertThat(value.customHttpCloneUrlRoot()).isEqualTo("custom_http_clone_url_root");
            softly.assertThat(value.deleteInactiveProjects()).isEqualTo("delete_inactive_projects");
            softly.assertThat(value.deleteUnconfirmedUsers()).isEqualTo("delete_unconfirmed_users");
            softly.assertThat(value.deletionAdjournedPeriod()).isEqualTo("deletion_adjourned_period");
            softly.assertThat(value.diffMaxCommits()).isEqualTo("diff_max_commits");
            softly.assertThat(value.diffMaxFiles()).isEqualTo("diff_max_files");
            softly.assertThat(value.diffMaxLines()).isEqualTo("diff_max_lines");
            softly.assertThat(value.diffMaxPatchBytes()).isEqualTo("diff_max_patch_bytes");
            softly.assertThat(value.diffMaxVersions()).isEqualTo("diff_max_versions");
            softly.assertThat(value.dnsRebindingProtectionEnabled()).isEqualTo("dns_rebinding_protection_enabled");
            softly.assertThat(value.enforceTerms()).isEqualTo("enforce_terms");
            softly.assertThat(value.enforceNamespaceStorageLimit()).isEqualTo("enforce_namespace_storage_limit");
            softly.assertThat(value.enforcePiplCompliance()).isEqualTo("enforce_pipl_compliance");
            softly.assertThat(value.enforceCiInboundJobTokenScopeEnabled())
                    .isEqualTo("enforce_ci_inbound_job_token_scope_enabled");
            softly.assertThat(value.enforceEmailSubaddressRestrictions())
                    .isEqualTo("enforce_email_subaddress_restrictions");
            softly.assertThat(value.enforceGranularTokens()).isEqualTo("enforce_granular_tokens");
            softly.assertThat(value.failedLoginAttemptsUnlockPeriodInMinutes())
                    .isEqualTo("failed_login_attempts_unlock_period_in_minutes");
            softly.assertThat(value.featureFlagUserListWriteBytesLimitPerUser()).isEqualTo(1);
            softly.assertThat(value.firstDayOfWeek()).isEqualTo("first_day_of_week");
            softly.assertThat(value.githubGistsImportLimit()).isEqualTo("github_gists_import_limit");
            softly.assertThat(value.gitlabDedicatedInstance()).isEqualTo("gitlab_dedicated_instance");
            softly.assertThat(value.gitlabEnvironmentToolkitInstance())
                    .isEqualTo("gitlab_environment_toolkit_instance");
            softly.assertThat(value.gitlabProductUsageDataEnabled()).isEqualTo("gitlab_product_usage_data_enabled");
            softly.assertThat(value.gitlabShellOperationLimit()).isEqualTo("gitlab_shell_operation_limit");
            softly.assertThat(value.gitlabShellOperationPerActorLimit()).isEqualTo(1);
            softly.assertThat(value.hashedStorageEnabled()).isEqualTo("hashed_storage_enabled");
            softly.assertThat(value.hideThirdPartyOffers()).isEqualTo("hide_third_party_offers");
            softly.assertThat(value.inactiveProjectsDeleteAfterMonths())
                    .isEqualTo("inactive_projects_delete_after_months");
            softly.assertThat(value.inactiveProjectsMinSizeMb()).isEqualTo("inactive_projects_min_size_mb");
            softly.assertThat(value.inactiveProjectsSendWarningEmailAfterMonths())
                    .isEqualTo("inactive_projects_send_warning_email_after_months");
            softly.assertThat(value.inactiveResourceAccessTokensDeleteAfterDays())
                    .isEqualTo("inactive_resource_access_tokens_delete_after_days");
            softly.assertThat(value.includeOptionalMetricsInServicePing())
                    .isEqualTo("include_optional_metrics_in_service_ping");
            softly.assertThat(value.keepLatestArtifact()).isEqualTo("keep_latest_artifact");
            softly.assertThat(value.mirrorAvailable()).isEqualTo("mirror_available");
            softly.assertThat(value.mirrorCapacityThreshold()).isEqualTo("mirror_capacity_threshold");
            softly.assertThat(value.mirrorMaxCapacity()).isEqualTo("mirror_max_capacity");
            softly.assertThat(value.mirrorMaxDelay()).isEqualTo("mirror_max_delay");
            softly.assertThat(value.notifyOnUnknownSignIn()).isEqualTo("notify_on_unknown_sign_in");
            softly.assertThat(value.offlineTransferExportsEnabled()).isEqualTo("offline_transfer_exports_enabled");
            softly.assertThat(value.offlineTransferImportsEnabled()).isEqualTo("offline_transfer_imports_enabled");
            softly.assertThat(value.packageRegistryAllowAnyoneToPullOption())
                    .isEqualTo("package_registry_allow_anyone_to_pull_option");
            softly.assertThat(value.packageRegistryCleanupPoliciesWorkerCapacity())
                    .isEqualTo("package_registry_cleanup_policies_worker_capacity");
            softly.assertThat(value.packageMetadataPurlTypes()).isEqualTo("package_metadata_purl_types");
            softly.assertThat(value.pagesDomainVerificationEnabled()).isEqualTo("pages_domain_verification_enabled");
            softly.assertThat(value.pagesUniqueDomainDefaultEnabled()).isEqualTo("pages_unique_domain_default_enabled");
            softly.assertThat(value.pagesExtraDeploymentsDefaultExpirySeconds())
                    .isEqualTo("pages_extra_deployments_default_expiry_seconds");
            softly.assertThat(value.pagesDeploymentsApiLimit()).isEqualTo("pages_deployments_api_limit");
            softly.assertThat(value.projectsApiRateLimitUnauthenticated())
                    .isEqualTo("projects_api_rate_limit_unauthenticated");
            softly.assertThat(value.projectsApiLimit()).isEqualTo("projects_api_limit");
            softly.assertThat(value.protectedCiVariables()).isEqualTo("protected_ci_variables");
            softly.assertThat(value.protectedPathsRaw()).isEqualTo("protected_paths_raw");
            softly.assertThat(value.protectedPathsForGetRequestRaw()).isEqualTo("protected_paths_for_get_request_raw");
            softly.assertThat(value.protectedBranchWriteLimit()).isEqualTo("protected_branch_write_limit");
            softly.assertThat(value.rateLimitingResponseText()).isEqualTo("rate_limiting_response_text");
            softly.assertThat(value.receiveMaxInputSize()).isEqualTo("receive_max_input_size");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSettingsUpdateOtherMore original = SettingsCatalogFixtures.settingsUpdateOtherMore();

        final GitLabSettingsUpdateOtherMore rebuilt =
                GitLabSettingsUpdateOtherMoreBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenJiraConnectDomainAllowlistSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("jira_connect_domain_allowlist"));
        final GitLabSettingsUpdateOtherMore built = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .jiraConnectDomainAllowlist(source)
                .build();
        source.clear();

        assertThat(built.jiraConnectDomainAllowlist()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenJiraConnectDomainAllowlistIsRead() {
        final GitLabSettingsUpdateOtherMore built = SettingsCatalogFixtures.settingsUpdateOtherMore();
        final List<String> values = built.jiraConnectDomainAllowlist();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenGitRateLimitUsersAllowlistSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("git_rate_limit_users_allowlist"));
        final GitLabSettingsUpdateOtherMore built = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .gitRateLimitUsersAllowlist(source)
                .build();
        source.clear();

        assertThat(built.gitRateLimitUsersAllowlist()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenGitRateLimitUsersAllowlistIsRead() {
        final GitLabSettingsUpdateOtherMore built = SettingsCatalogFixtures.settingsUpdateOtherMore();
        final List<String> values = built.gitRateLimitUsersAllowlist();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenGitRateLimitUsersAlertlistSourceChangesLater() {
        final List<Integer> source = new ArrayList<>(List.of(1));
        final GitLabSettingsUpdateOtherMore built = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .gitRateLimitUsersAlertlist(source)
                .build();
        source.clear();

        assertThat(built.gitRateLimitUsersAlertlist()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenGitRateLimitUsersAlertlistIsRead() {
        final GitLabSettingsUpdateOtherMore built = SettingsCatalogFixtures.settingsUpdateOtherMore();
        final List<Integer> values = built.gitRateLimitUsersAlertlist();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenCodeDropdownCustomClientsSourceChangesLater() {
        final List<GitLabSettingsUpdateCodeDropdownCustomClient> source =
                new ArrayList<>(List.of(SettingsCatalogFixtures.settingsUpdateCodeDropdownCustomClient()));
        final GitLabSettingsUpdateOtherMore built = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .codeDropdownCustomClients(source)
                .build();
        source.clear();

        assertThat(built.codeDropdownCustomClients()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenCodeDropdownCustomClientsIsRead() {
        final GitLabSettingsUpdateOtherMore built = SettingsCatalogFixtures.settingsUpdateOtherMore();
        final List<GitLabSettingsUpdateCodeDropdownCustomClient> values = built.codeDropdownCustomClients();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheMap_whenResourceUsageLimitsSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabSettingsUpdateOtherMore built = GitLabSettingsUpdateOtherMoreBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateOtherMore())
                .resourceUsageLimits(source)
                .build();
        source.clear();

        assertThat(built.resourceUsageLimits()).isNotEmpty();
    }

    @Test
    void toString_shouldMaskTheValue_whenSlackAppSecretIsACredential() {
        final GitLabSettingsUpdateOtherMore value = SettingsCatalogFixtures.settingsUpdateOtherMore();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenSlackAppSigningSecretIsACredential() {
        final GitLabSettingsUpdateOtherMore value = SettingsCatalogFixtures.settingsUpdateOtherMore();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenSlackAppVerificationTokenIsACredential() {
        final GitLabSettingsUpdateOtherMore value = SettingsCatalogFixtures.settingsUpdateOtherMore();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenResourceAccessTokenNotifyInheritedIsACredential() {
        final GitLabSettingsUpdateOtherMore value = SettingsCatalogFixtures.settingsUpdateOtherMore();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenMinimumPasswordLengthIsACredential() {
        final GitLabSettingsUpdateOtherMore value = SettingsCatalogFixtures.settingsUpdateOtherMore();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenEnforceGranularTokensIsACredential() {
        final GitLabSettingsUpdateOtherMore value = SettingsCatalogFixtures.settingsUpdateOtherMore();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenInactiveResourceAccessTokensDeleteAfterDaysIsACredential() {
        final GitLabSettingsUpdateOtherMore value = SettingsCatalogFixtures.settingsUpdateOtherMore();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSettingsUpdateOtherMore.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "issuesCreateLimit",
                        "rawBlobRequestLimit",
                        "rawBlobRequestLimitUnauthenticated",
                        "releaseEvidenceCollectionsLimitPerUser",
                        "releaseWritesLimitPerProject",
                        "releaseWritesLimitPerUser",
                        "wikiPageMaxContentBytes",
                        "wikiAsciidocAllowUriIncludes",
                        "wikiReadRequestLimitUnauthenticated",
                        "descriptionAndNoteMaxSize",
                        "whatsNewVariant",
                        "flocEnabled",
                        "showMigrateFromJenkinsBanner",
                        "enableArtifactExternalRedirectWarningPage",
                        "enableLanguageServerRestrictions",
                        "enableMemberPromotionManagement",
                        "pipelineLimitPerProjectUserSha",
                        "pipelineLimitPerUser",
                        "pipelineCancelLimitPerUserProject",
                        "pipelineRetryLimitPerUserProject",
                        "pipelineScheduleManagementLimitPerUser",
                        "pipelineDeleteLimitPerUserProject",
                        "pipelineExecutionPoliciesPerConfigurationLimit",
                        "jiraConnectApplicationKey",
                        "jiraConnectPublicKeyStorageEnabled",
                        "jiraConnectProxyUrl",
                        "jiraConnectDomainAllowlist",
                        "jiraConnectDomainAllowlistRaw",
                        "jiraForgeAppId",
                        "jiraConnectAdditionalAudienceUrl",
                        "bulkImportConcurrentPipelineBatchLimit",
                        "bulkImportEnabled",
                        "bulkImportMaxDownloadFile",
                        "bulkImportMaxDownloadFileSize",
                        "concurrentRelationBatchExportLimit",
                        "concurrentGithubImportJobsLimit",
                        "concurrentBitbucketImportJobsLimit",
                        "concurrentBitbucketServerImportJobsLimit",
                        "concurrentPullRequestImportJobsLimit",
                        "concurrentRelationExportLimit",
                        "autocompleteUsersLimit",
                        "autocompleteUsersUnauthenticatedLimit",
                        "gitPushPipelineLimit",
                        "gitTwoFactorSessionExpiry",
                        "gitRateLimitUsersAllowlist",
                        "gitRateLimitUsersAlertlist",
                        "securityPolicyGlobalGroupApproversEnabled",
                        "securityTxtContent",
                        "securityScanStaleAfterDays",
                        "securityApprovalPoliciesLimit",
                        "securityMrReportCacheLifetimeMinutes",
                        "slackAppEnabled",
                        "slackAppId",
                        "slackAppSecret",
                        "slackAppSigningSecret",
                        "slackAppVerificationToken",
                        "namespaceAggregationScheduleLeaseDurationInSeconds",
                        "downstreamPipelineTriggerLimitPerProjectUserSha",
                        "jobRetryLimitPerUserProject",
                        "jobPlayLimitPerUserProject",
                        "jobEraseLimitPerUserProject",
                        "jobCancelLimitPerUserProject",
                        "aiActionApiRateLimit",
                        "aiAuditEventsStreamingEnabled",
                        "codeSuggestionsApiRateLimit",
                        "codeDropdownCustomClients",
                        "resourceUsageLimits",
                        "resourceAccessTokenNotifyInherited",
                        "vscodeExtensionMarketplace",
                        "vscodeExtensionMarketplaceEnabled",
                        "vscodeExtensionMarketplaceExtensionHostDomain",
                        "vscodeExtensionMarketplaceSingleOriginFallbackEnabled",
                        "minimumLanguageServerVersion",
                        "minimumPasswordLength",
                        "terraformStateEncryptionEnabled",
                        "loggingFieldSchemaVersion",
                        "loggingFieldDualEmitTarget",
                        "rsaKeyRestriction",
                        "dsaKeyRestriction",
                        "ecdsaKeyRestriction",
                        "ecdsaSkKeyRestriction",
                        "ed25519KeyRestriction",
                        "ed25519SkKeyRestriction",
                        "archiveBuildsInHumanReadable",
                        "asciidocMaxIncludes",
                        "authorizedKeysEnabled",
                        "autoAcceptAwardedAchievements",
                        "autoDevopsDomain",
                        "autoDevopsEnabled",
                        "autoBanUserOnExcessiveProjectsDownload",
                        "autoDuoCodeReviewEnabled",
                        "autoDuoCodeReviewOnPushEnabled",
                        "canCreateGroup",
                        "canCreateOrganization",
                        "commitEmailHostname",
                        "customHttpCloneUrlRoot",
                        "deleteInactiveProjects",
                        "deleteUnconfirmedUsers",
                        "deletionAdjournedPeriod",
                        "diffMaxCommits",
                        "diffMaxFiles",
                        "diffMaxLines",
                        "diffMaxPatchBytes",
                        "diffMaxVersions",
                        "dnsRebindingProtectionEnabled",
                        "enforceTerms",
                        "enforceNamespaceStorageLimit",
                        "enforcePiplCompliance",
                        "enforceCiInboundJobTokenScopeEnabled",
                        "enforceEmailSubaddressRestrictions",
                        "enforceGranularTokens",
                        "failedLoginAttemptsUnlockPeriodInMinutes",
                        "featureFlagUserListWriteBytesLimitPerUser",
                        "firstDayOfWeek",
                        "githubGistsImportLimit",
                        "gitlabDedicatedInstance",
                        "gitlabEnvironmentToolkitInstance",
                        "gitlabProductUsageDataEnabled",
                        "gitlabShellOperationLimit",
                        "gitlabShellOperationPerActorLimit",
                        "hashedStorageEnabled",
                        "hideThirdPartyOffers",
                        "inactiveProjectsDeleteAfterMonths",
                        "inactiveProjectsMinSizeMb",
                        "inactiveProjectsSendWarningEmailAfterMonths",
                        "inactiveResourceAccessTokensDeleteAfterDays",
                        "includeOptionalMetricsInServicePing",
                        "keepLatestArtifact",
                        "mirrorAvailable",
                        "mirrorCapacityThreshold",
                        "mirrorMaxCapacity",
                        "mirrorMaxDelay",
                        "notifyOnUnknownSignIn",
                        "offlineTransferExportsEnabled",
                        "offlineTransferImportsEnabled",
                        "packageRegistryAllowAnyoneToPullOption",
                        "packageRegistryCleanupPoliciesWorkerCapacity",
                        "packageMetadataPurlTypes",
                        "pagesDomainVerificationEnabled",
                        "pagesUniqueDomainDefaultEnabled",
                        "pagesExtraDeploymentsDefaultExpirySeconds",
                        "pagesDeploymentsApiLimit",
                        "projectsApiRateLimitUnauthenticated",
                        "projectsApiLimit",
                        "protectedCiVariables",
                        "protectedPathsRaw",
                        "protectedPathsForGetRequestRaw",
                        "protectedBranchWriteLimit",
                        "rateLimitingResponseText",
                        "receiveMaxInputSize");
    }
}
