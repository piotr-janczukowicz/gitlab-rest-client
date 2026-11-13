package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabApplicationSettingOtherFurtherTest {

    @Test
    void constructor_shouldAcceptNull_whenRelationExportBatchSizeIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .relationExportBatchSize(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.relationExportBatchSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOfflineTransferExportsEnabledIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .offlineTransferExportsEnabled(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.offlineTransferExportsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOfflineTransferImportsEnabledIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .offlineTransferImportsEnabled(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.offlineTransferImportsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValidRunnerRegistrarsIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .validRunnerRegistrars(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.validRunnerRegistrars()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeactivationEmailAdditionalTextIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .deactivationEmailAdditionalText(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.deactivationEmailAdditionalText()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectsApiRateLimitUnauthenticatedIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .projectsApiRateLimitUnauthenticated(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.projectsApiRateLimitUnauthenticated()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectsApiLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .projectsApiLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.projectsApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGlqlDbSecondsPerIpLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .glqlDbSecondsPerIpLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.glqlDbSecondsPerIpLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGlqlDbSecondsPerQueryLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .glqlDbSecondsPerQueryLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.glqlDbSecondsPerQueryLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGlqlDbSecondsPerUserLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .glqlDbSecondsPerUserLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.glqlDbSecondsPerUserLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGlqlDuoDbSecondsPerUserLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .glqlDuoDbSecondsPerUserLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.glqlDuoDbSecondsPerUserLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupsApiLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .groupsApiLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.groupsApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuableCsvImportLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .issuableCsvImportLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.issuableCsvImportLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelDeleteLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .labelDeleteLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.labelDeleteLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreateOrganizationApiLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .createOrganizationApiLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.createOrganizationApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCrossReferenceChecksLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .crossReferenceChecksLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.crossReferenceChecksLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagsCreateLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .tagsCreateLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.tagsCreateLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTodosListApiLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .todosListApiLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.todosListApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSystemHooksCreateLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .systemHooksCreateLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.systemHooksCreateLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebHookEventResendLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .webHookEventResendLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.webHookEventResendLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebHookTestLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .webHookTestLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.webHookTestLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemHierarchyAddChildrenLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .workItemHierarchyAddChildrenLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.workItemHierarchyAddChildrenLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemMoveLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .workItemMoveLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.workItemMoveLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemUpdateLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .workItemUpdateLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.workItemUpdateLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGithubGistsImportLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .githubGistsImportLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.githubGistsImportLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespaceAggregationScheduleLeaseDurationInSecondsIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .namespaceAggregationScheduleLeaseDurationInSeconds(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.namespaceAggregationScheduleLeaseDurationInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecurityTxtContentIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .securityTxtContent(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.securityTxtContent()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecurityPolicyGlobalGroupApproversEnabledIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .securityPolicyGlobalGroupApproversEnabled(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.securityPolicyGlobalGroupApproversEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecurityApprovalPoliciesLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .securityApprovalPoliciesLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.securityApprovalPoliciesLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecurityMrReportCacheLifetimeMinutesIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .securityMrReportCacheLifetimeMinutes(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.securityMrReportCacheLifetimeMinutes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecurityScanStaleAfterDaysIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .securityScanStaleAfterDays(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.securityScanStaleAfterDays()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDownstreamPipelineTriggerLimitPerProjectUserShaIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .downstreamPipelineTriggerLimitPerProjectUserSha(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.downstreamPipelineTriggerLimitPerProjectUserSha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobRetryLimitPerUserProjectIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .jobRetryLimitPerUserProject(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.jobRetryLimitPerUserProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobPlayLimitPerUserProjectIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .jobPlayLimitPerUserProject(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.jobPlayLimitPerUserProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobEraseLimitPerUserProjectIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .jobEraseLimitPerUserProject(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.jobEraseLimitPerUserProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobCancelLimitPerUserProjectIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .jobCancelLimitPerUserProject(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.jobCancelLimitPerUserProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAsciidocMaxIncludesIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .asciidocMaxIncludes(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.asciidocMaxIncludes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiActionApiRateLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .aiActionApiRateLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.aiActionApiRateLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiAuditEventsStreamingEnabledIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .aiAuditEventsStreamingEnabled(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.aiAuditEventsStreamingEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenObservabilityBackendSslVerificationEnabledIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .observabilityBackendSslVerificationEnabled(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.observabilityBackendSslVerificationEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShowMigrateFromJenkinsBannerIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .showMigrateFromJenkinsBanner(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.showMigrateFromJenkinsBanner()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVscodeExtensionMarketplaceIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .vscodeExtensionMarketplace(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.vscodeExtensionMarketplace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVscodeExtensionMarketplaceEnabledIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .vscodeExtensionMarketplaceEnabled(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.vscodeExtensionMarketplaceEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVscodeExtensionMarketplaceExtensionHostDomainIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .vscodeExtensionMarketplaceExtensionHostDomain(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.vscodeExtensionMarketplaceExtensionHostDomain()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVscodeExtensionMarketplaceSingleOriginFallbackEnabledIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .vscodeExtensionMarketplaceSingleOriginFallbackEnabled(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.vscodeExtensionMarketplaceSingleOriginFallbackEnabled())
                .isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReindexingMinimumIndexSizeIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .reindexingMinimumIndexSize(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.reindexingMinimumIndexSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReindexingMinimumRelativeBloatSizeIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .reindexingMinimumRelativeBloatSize(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.reindexingMinimumRelativeBloatSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAnonymousSearchesAllowedIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .anonymousSearchesAllowed(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.anonymousSearchesAllowed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitPushPipelineLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .gitPushPipelineLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.gitPushPipelineLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitTwoFactorSessionExpiryIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .gitTwoFactorSessionExpiry(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.gitTwoFactorSessionExpiry()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitRateLimitUsersAllowlistIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .gitRateLimitUsersAllowlist(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.gitRateLimitUsersAllowlist()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGitRateLimitUsersAlertlistIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .gitRateLimitUsersAlertlist(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.gitRateLimitUsersAlertlist()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDelayUserAccountSelfDeletionIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .delayUserAccountSelfDeletion(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.delayUserAccountSelfDeletion()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBackgroundOperationsMaxJobsIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .backgroundOperationsMaxJobs(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.backgroundOperationsMaxJobs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPgAshSamplingEnabledIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .pgAshSamplingEnabled(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.pgAshSamplingEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPgAshSampleIntervalSecondsIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .pgAshSampleIntervalSeconds(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.pgAshSampleIntervalSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGranularTokensEnforcedAfterIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .granularTokensEnforcedAfter(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.granularTokensEnforcedAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLoggingFieldSchemaVersionIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .loggingFieldSchemaVersion(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.loggingFieldSchemaVersion()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLoggingFieldDualEmitTargetIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .loggingFieldDualEmitTarget(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.loggingFieldDualEmitTarget()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeactivateDormantUsersIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .deactivateDormantUsers(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.deactivateDormantUsers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeactivateDormantUsersPeriodIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .deactivateDormantUsersPeriod(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.deactivateDormantUsersPeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNugetSkipMetadataUrlValidationIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .nugetSkipMetadataUrlValidation(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.nugetSkipMetadataUrlValidation()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHelmMaxPackagesCountIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .helmMaxPackagesCount(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.helmMaxPackagesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMcpServerEnabledIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .mcpServerEnabled(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.mcpServerEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDynamicClientRegistrationEnabledIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .dynamicClientRegistrationEnabled(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.dynamicClientRegistrationEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveContextPauseIndexingIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .activeContextPauseIndexing(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.activeContextPauseIndexing()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowedIntegrationsIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .allowedIntegrations(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.allowedIntegrations()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutomaticPurchasedStorageAllocationIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .automaticPurchasedStorageAllocation(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.automaticPurchasedStorageAllocation()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCheckNamespacePlanIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .checkNamespacePlan(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.checkNamespacePlan()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGeoNodeAllowedIpsIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .geoNodeAllowedIps(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.geoNodeAllowedIps()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGeoStatusTimeoutIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .geoStatusTimeout(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.geoStatusTimeout()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenModelPromptCacheEnabledIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .modelPromptCacheEnabled(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.modelPromptCacheEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReceptiveClusterAgentsEnabledIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .receptiveClusterAgentsEnabled(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.receptiveClusterAgentsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecretDetectionTokenRevocationEnabledIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .secretDetectionTokenRevocationEnabled(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.secretDetectionTokenRevocationEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecretDetectionTokenRevocationUrlIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .secretDetectionTokenRevocationUrl(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.secretDetectionTokenRevocationUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecretDetectionTokenRevocationTokenIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .secretDetectionTokenRevocationToken(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.secretDetectionTokenRevocationToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecretDetectionRevocationTokenTypesUrlIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .secretDetectionRevocationTokenTypesUrl(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.secretDetectionRevocationTokenTypesUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecretDetectionServiceAuthTokenIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .secretDetectionServiceAuthToken(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.secretDetectionServiceAuthToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecretDetectionServiceUrlIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .secretDetectionServiceUrl(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.secretDetectionServiceUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecretPushProtectionAvailableIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .secretPushProtectionAvailable(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.secretPushProtectionAvailable()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProductAnalyticsEnabledIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .productAnalyticsEnabled(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.productAnalyticsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProductAnalyticsDataCollectorHostIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .productAnalyticsDataCollectorHost(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.productAnalyticsDataCollectorHost()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProductAnalyticsConfiguratorConnectionStringIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .productAnalyticsConfiguratorConnectionString(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.productAnalyticsConfiguratorConnectionString()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCubeApiBaseUrlIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .cubeApiBaseUrl(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.cubeApiBaseUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCubeApiKeyIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .cubeApiKey(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.cubeApiKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenToolApprovalForSessionEnabledIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .toolApprovalForSessionEnabled(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.toolApprovalForSessionEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenToolApprovalForSessionAvailabilityIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .toolApprovalForSessionAvailability(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.toolApprovalForSessionAvailability()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFoundationalAgentsDefaultEnabledIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .foundationalAgentsDefaultEnabled(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.foundationalAgentsDefaultEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFoundationalAgentsStatusesIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .foundationalAgentsStatuses(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.foundationalAgentsStatuses()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrbitAutoIndexRootNamespaceIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .orbitAutoIndexRootNamespace(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.orbitAutoIndexRootNamespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrbitDapEnabledByDefaultIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .orbitDapEnabledByDefault(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.orbitDapEnabledByDefault()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrbitQueryLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .orbitQueryLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.orbitQueryLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrbitIndexingStatusLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .orbitIndexingStatusLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.orbitIndexingStatusLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrbitItemCountsLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .orbitItemCountsLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.orbitItemCountsLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrbitRateLimitAllowlistRawIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .orbitRateLimitAllowlistRaw(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.orbitRateLimitAllowlistRaw()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEpicMoveListLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .epicMoveListLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.epicMoveListLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInsightsQueryLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .insightsQueryLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.insightsQueryLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSubscriptionUsagePerMinuteLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .subscriptionUsagePerMinuteLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.subscriptionUsagePerMinuteLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSubscriptionUsagePerHourLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .subscriptionUsagePerHourLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.subscriptionUsagePerHourLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSubscriptionUsagePerDayLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .subscriptionUsagePerDayLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.subscriptionUsagePerDayLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBudgetCapUpdatePerMinuteLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .budgetCapUpdatePerMinuteLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.budgetCapUpdatePerMinuteLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBudgetCapUpdatePerHourLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .budgetCapUpdatePerHourLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.budgetCapUpdatePerHourLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBudgetCapUpdatePerDayLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .budgetCapUpdatePerDayLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.budgetCapUpdatePerDayLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScanExecutionPoliciesActionLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .scanExecutionPoliciesActionLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.scanExecutionPoliciesActionLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScanExecutionPoliciesScheduleLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .scanExecutionPoliciesScheduleLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.scanExecutionPoliciesScheduleLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScanExecutionPoliciesPerConfigurationLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .scanExecutionPoliciesPerConfigurationLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.scanExecutionPoliciesPerConfigurationLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilityManagementPoliciesPerConfigurationLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .vulnerabilityManagementPoliciesPerConfigurationLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.vulnerabilityManagementPoliciesPerConfigurationLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPolicyStoreExperimentEnabledIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .policyStoreExperimentEnabled(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.policyStoreExperimentEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFetchObservabilityAlertsFromCloudIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .fetchObservabilityAlertsFromCloud(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.fetchObservabilityAlertsFromCloud()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticMigrationWorkerEnabledIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .elasticMigrationWorkerEnabled(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.elasticMigrationWorkerEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDisplayGitlabCreditsUserDataIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .displayGitlabCreditsUserData(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.displayGitlabCreditsUserData()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVacProjectIdsRawIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .vacProjectIdsRaw(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.vacProjectIdsRaw()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSigninEnabledIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .signinEnabled(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.signinEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPreventMergeRequestsAuthorApprovalIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .preventMergeRequestsAuthorApproval(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.preventMergeRequestsAuthorApproval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPreventMergeRequestsCommittersApprovalIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .preventMergeRequestsCommittersApproval(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.preventMergeRequestsCommittersApproval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFileTemplateProjectIdIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .fileTemplateProjectId(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.fileTemplateProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatingNameDisabledForUsersIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .updatingNameDisabledForUsers(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.updatingNameDisabledForUsers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMavenPackageRequestsForwardingIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .mavenPackageRequestsForwarding(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.mavenPackageRequestsForwarding()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNpmPackageRequestsForwardingIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .npmPackageRequestsForwarding(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.npmPackageRequestsForwarding()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVirtualRegistriesEndpointsApiLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .virtualRegistriesEndpointsApiLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.virtualRegistriesEndpointsApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuditEventsApiLimitIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .auditEventsApiLimit(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.auditEventsApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPreReceiveSecretDetectionEnabledIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .preReceiveSecretDetectionEnabled(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.preReceiveSecretDetectionEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPypiPackageRequestsForwardingIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .pypiPackageRequestsForwarding(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.pypiPackageRequestsForwarding()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRubygemsPackageRequestsForwardingIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .rubygemsPackageRequestsForwarding(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.rubygemsPackageRequestsForwarding()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaintenanceModeIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .maintenanceMode(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.maintenanceMode()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaintenanceModeMessageIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .maintenanceModeMessage(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.maintenanceModeMessage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServiceAccessTokensExpirationEnforcedIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .serviceAccessTokensExpirationEnforced(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.serviceAccessTokensExpirationEnforced()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUnconfirmedUsersDeleteAfterDaysIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .unconfirmedUsersDeleteAfterDays(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.unconfirmedUsersDeleteAfterDays()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMakeProfilePrivateIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .makeProfilePrivate(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.makeProfilePrivate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBuiltInProjectTemplatesEnabledIsNullable() {
        final GitLabApplicationSettingOtherFurtherBuilder builder = GitLabApplicationSettingOtherFurtherBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingOtherFurther())
                .builtInProjectTemplatesEnabled(null);

        final GitLabApplicationSettingOtherFurther built = builder.build();

        assertThat(built.builtInProjectTemplatesEnabled()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabApplicationSettingOtherFurther value = SettingsCatalogFixtures.applicationSettingOtherFurther();

        assertSoftly(softly -> {
            softly.assertThat(value.relationExportBatchSize()).isEqualTo("relation_export_batch_size");
            softly.assertThat(value.offlineTransferExportsEnabled()).isEqualTo("offline_transfer_exports_enabled");
            softly.assertThat(value.offlineTransferImportsEnabled()).isEqualTo("offline_transfer_imports_enabled");
            softly.assertThat(value.validRunnerRegistrars()).isEqualTo("valid_runner_registrars");
            softly.assertThat(value.deactivationEmailAdditionalText()).isEqualTo("deactivation_email_additional_text");
            softly.assertThat(value.projectsApiRateLimitUnauthenticated())
                    .isEqualTo("projects_api_rate_limit_unauthenticated");
            softly.assertThat(value.projectsApiLimit()).isEqualTo("projects_api_limit");
            softly.assertThat(value.glqlDbSecondsPerIpLimit()).isEqualTo("glql_db_seconds_per_ip_limit");
            softly.assertThat(value.glqlDbSecondsPerQueryLimit()).isEqualTo("glql_db_seconds_per_query_limit");
            softly.assertThat(value.glqlDbSecondsPerUserLimit()).isEqualTo("glql_db_seconds_per_user_limit");
            softly.assertThat(value.glqlDuoDbSecondsPerUserLimit()).isEqualTo("glql_duo_db_seconds_per_user_limit");
            softly.assertThat(value.groupsApiLimit()).isEqualTo("groups_api_limit");
            softly.assertThat(value.issuableCsvImportLimit()).isEqualTo("issuable_csv_import_limit");
            softly.assertThat(value.labelDeleteLimit()).isEqualTo("label_delete_limit");
            softly.assertThat(value.createOrganizationApiLimit()).isEqualTo("create_organization_api_limit");
            softly.assertThat(value.crossReferenceChecksLimit()).isEqualTo("cross_reference_checks_limit");
            softly.assertThat(value.tagsCreateLimit()).isEqualTo("tags_create_limit");
            softly.assertThat(value.todosListApiLimit()).isEqualTo("todos_list_api_limit");
            softly.assertThat(value.systemHooksCreateLimit()).isEqualTo("system_hooks_create_limit");
            softly.assertThat(value.webHookEventResendLimit()).isEqualTo("web_hook_event_resend_limit");
            softly.assertThat(value.webHookTestLimit()).isEqualTo("web_hook_test_limit");
            softly.assertThat(value.workItemHierarchyAddChildrenLimit())
                    .isEqualTo("work_item_hierarchy_add_children_limit");
            softly.assertThat(value.workItemMoveLimit()).isEqualTo("work_item_move_limit");
            softly.assertThat(value.workItemUpdateLimit()).isEqualTo("work_item_update_limit");
            softly.assertThat(value.githubGistsImportLimit()).isEqualTo("github_gists_import_limit");
            softly.assertThat(value.namespaceAggregationScheduleLeaseDurationInSeconds())
                    .isEqualTo("namespace_aggregation_schedule_lease_duration_in_seconds");
            softly.assertThat(value.securityTxtContent()).isEqualTo("security_txt_content");
            softly.assertThat(value.securityPolicyGlobalGroupApproversEnabled())
                    .isEqualTo("security_policy_global_group_approvers_enabled");
            softly.assertThat(value.securityApprovalPoliciesLimit()).isEqualTo("security_approval_policies_limit");
            softly.assertThat(value.securityMrReportCacheLifetimeMinutes())
                    .isEqualTo("security_mr_report_cache_lifetime_minutes");
            softly.assertThat(value.securityScanStaleAfterDays()).isEqualTo("security_scan_stale_after_days");
            softly.assertThat(value.downstreamPipelineTriggerLimitPerProjectUserSha())
                    .isEqualTo("downstream_pipeline_trigger_limit_per_project_user_sha");
            softly.assertThat(value.jobRetryLimitPerUserProject()).isEqualTo("job_retry_limit_per_user_project");
            softly.assertThat(value.jobPlayLimitPerUserProject()).isEqualTo("job_play_limit_per_user_project");
            softly.assertThat(value.jobEraseLimitPerUserProject()).isEqualTo("job_erase_limit_per_user_project");
            softly.assertThat(value.jobCancelLimitPerUserProject()).isEqualTo("job_cancel_limit_per_user_project");
            softly.assertThat(value.asciidocMaxIncludes()).isEqualTo("asciidoc_max_includes");
            softly.assertThat(value.aiActionApiRateLimit()).isEqualTo("ai_action_api_rate_limit");
            softly.assertThat(value.aiAuditEventsStreamingEnabled()).isEqualTo(true);
            softly.assertThat(value.observabilityBackendSslVerificationEnabled())
                    .isEqualTo("observability_backend_ssl_verification_enabled");
            softly.assertThat(value.showMigrateFromJenkinsBanner()).isEqualTo("show_migrate_from_jenkins_banner");
            softly.assertThat(value.vscodeExtensionMarketplace()).isEqualTo("vscode_extension_marketplace");
            softly.assertThat(value.vscodeExtensionMarketplaceEnabled())
                    .isEqualTo("vscode_extension_marketplace_enabled");
            softly.assertThat(value.vscodeExtensionMarketplaceExtensionHostDomain())
                    .isEqualTo("vscode_extension_marketplace_extension_host_domain");
            softly.assertThat(value.vscodeExtensionMarketplaceSingleOriginFallbackEnabled())
                    .isEqualTo("vscode_extension_marketplace_single_origin_fallback_enabled");
            softly.assertThat(value.reindexingMinimumIndexSize()).isEqualTo("reindexing_minimum_index_size");
            softly.assertThat(value.reindexingMinimumRelativeBloatSize())
                    .isEqualTo("reindexing_minimum_relative_bloat_size");
            softly.assertThat(value.anonymousSearchesAllowed()).isEqualTo("anonymous_searches_allowed");
            softly.assertThat(value.gitPushPipelineLimit()).isEqualTo("git_push_pipeline_limit");
            softly.assertThat(value.gitTwoFactorSessionExpiry()).isEqualTo("git_two_factor_session_expiry");
            softly.assertThat(value.gitRateLimitUsersAllowlist()).isEqualTo("git_rate_limit_users_allowlist");
            softly.assertThat(value.gitRateLimitUsersAlertlist()).isEqualTo("git_rate_limit_users_alertlist");
            softly.assertThat(value.delayUserAccountSelfDeletion()).isEqualTo("delay_user_account_self_deletion");
            softly.assertThat(value.backgroundOperationsMaxJobs()).isEqualTo("background_operations_max_jobs");
            softly.assertThat(value.pgAshSamplingEnabled()).isEqualTo("pg_ash_sampling_enabled");
            softly.assertThat(value.pgAshSampleIntervalSeconds()).isEqualTo("pg_ash_sample_interval_seconds");
            softly.assertThat(value.granularTokensEnforcedAfter()).isEqualTo("granular_tokens_enforced_after");
            softly.assertThat(value.loggingFieldSchemaVersion()).isEqualTo(1);
            softly.assertThat(value.loggingFieldDualEmitTarget()).isEqualTo(1);
            softly.assertThat(value.deactivateDormantUsers()).isEqualTo("deactivate_dormant_users");
            softly.assertThat(value.deactivateDormantUsersPeriod()).isEqualTo("deactivate_dormant_users_period");
            softly.assertThat(value.nugetSkipMetadataUrlValidation()).isEqualTo("nuget_skip_metadata_url_validation");
            softly.assertThat(value.helmMaxPackagesCount()).isEqualTo("helm_max_packages_count");
            softly.assertThat(value.mcpServerEnabled()).isEqualTo("mcp_server_enabled");
            softly.assertThat(value.dynamicClientRegistrationEnabled())
                    .isEqualTo("dynamic_client_registration_enabled");
            softly.assertThat(value.activeContextPauseIndexing()).isEqualTo("active_context_pause_indexing");
            softly.assertThat(value.allowedIntegrations()).isEqualTo("allowed_integrations");
            softly.assertThat(value.automaticPurchasedStorageAllocation())
                    .isEqualTo("automatic_purchased_storage_allocation");
            softly.assertThat(value.checkNamespacePlan()).isEqualTo("check_namespace_plan");
            softly.assertThat(value.geoNodeAllowedIps()).isEqualTo("geo_node_allowed_ips");
            softly.assertThat(value.geoStatusTimeout()).isEqualTo("geo_status_timeout");
            softly.assertThat(value.modelPromptCacheEnabled()).isEqualTo("model_prompt_cache_enabled");
            softly.assertThat(value.receptiveClusterAgentsEnabled()).isEqualTo("receptive_cluster_agents_enabled");
            softly.assertThat(value.secretDetectionTokenRevocationEnabled())
                    .isEqualTo("secret_detection_token_revocation_enabled");
            softly.assertThat(value.secretDetectionTokenRevocationUrl())
                    .isEqualTo("secret_detection_token_revocation_url");
            softly.assertThat(value.secretDetectionTokenRevocationToken())
                    .isEqualTo("secret_detection_token_revocation_token");
            softly.assertThat(value.secretDetectionRevocationTokenTypesUrl())
                    .isEqualTo("secret_detection_revocation_token_types_url");
            softly.assertThat(value.secretDetectionServiceAuthToken()).isEqualTo("secret_detection_service_auth_token");
            softly.assertThat(value.secretDetectionServiceUrl()).isEqualTo("secret_detection_service_url");
            softly.assertThat(value.secretPushProtectionAvailable()).isEqualTo("secret_push_protection_available");
            softly.assertThat(value.productAnalyticsEnabled()).isEqualTo("product_analytics_enabled");
            softly.assertThat(value.productAnalyticsDataCollectorHost())
                    .isEqualTo("product_analytics_data_collector_host");
            softly.assertThat(value.productAnalyticsConfiguratorConnectionString())
                    .isEqualTo("product_analytics_configurator_connection_string");
            softly.assertThat(value.cubeApiBaseUrl()).isEqualTo("cube_api_base_url");
            softly.assertThat(value.cubeApiKey()).isEqualTo("cube_api_key");
            softly.assertThat(value.toolApprovalForSessionEnabled()).isEqualTo("tool_approval_for_session_enabled");
            softly.assertThat(value.toolApprovalForSessionAvailability())
                    .isEqualTo("tool_approval_for_session_availability");
            softly.assertThat(value.foundationalAgentsDefaultEnabled())
                    .isEqualTo("foundational_agents_default_enabled");
            softly.assertThat(value.foundationalAgentsStatuses()).isEqualTo("foundational_agents_statuses");
            softly.assertThat(value.orbitAutoIndexRootNamespace()).isEqualTo("orbit_auto_index_root_namespace");
            softly.assertThat(value.orbitDapEnabledByDefault()).isEqualTo("orbit_dap_enabled_by_default");
            softly.assertThat(value.orbitQueryLimit()).isEqualTo("orbit_query_limit");
            softly.assertThat(value.orbitIndexingStatusLimit()).isEqualTo("orbit_indexing_status_limit");
            softly.assertThat(value.orbitItemCountsLimit()).isEqualTo("orbit_item_counts_limit");
            softly.assertThat(value.orbitRateLimitAllowlistRaw()).isEqualTo("orbit_rate_limit_allowlist_raw");
            softly.assertThat(value.epicMoveListLimit()).isEqualTo("epic_move_list_limit");
            softly.assertThat(value.insightsQueryLimit()).isEqualTo("insights_query_limit");
            softly.assertThat(value.subscriptionUsagePerMinuteLimit()).isEqualTo("subscription_usage_per_minute_limit");
            softly.assertThat(value.subscriptionUsagePerHourLimit()).isEqualTo("subscription_usage_per_hour_limit");
            softly.assertThat(value.subscriptionUsagePerDayLimit()).isEqualTo("subscription_usage_per_day_limit");
            softly.assertThat(value.budgetCapUpdatePerMinuteLimit()).isEqualTo("budget_cap_update_per_minute_limit");
            softly.assertThat(value.budgetCapUpdatePerHourLimit()).isEqualTo("budget_cap_update_per_hour_limit");
            softly.assertThat(value.budgetCapUpdatePerDayLimit()).isEqualTo("budget_cap_update_per_day_limit");
            softly.assertThat(value.scanExecutionPoliciesActionLimit())
                    .isEqualTo("scan_execution_policies_action_limit");
            softly.assertThat(value.scanExecutionPoliciesScheduleLimit())
                    .isEqualTo("scan_execution_policies_schedule_limit");
            softly.assertThat(value.scanExecutionPoliciesPerConfigurationLimit())
                    .isEqualTo("scan_execution_policies_per_configuration_limit");
            softly.assertThat(value.vulnerabilityManagementPoliciesPerConfigurationLimit())
                    .isEqualTo("vulnerability_management_policies_per_configuration_limit");
            softly.assertThat(value.policyStoreExperimentEnabled()).isEqualTo("policy_store_experiment_enabled");
            softly.assertThat(value.fetchObservabilityAlertsFromCloud())
                    .isEqualTo("fetch_observability_alerts_from_cloud");
            softly.assertThat(value.elasticMigrationWorkerEnabled()).isEqualTo("elastic_migration_worker_enabled");
            softly.assertThat(value.displayGitlabCreditsUserData()).isEqualTo("display_gitlab_credits_user_data");
            softly.assertThat(value.vacProjectIdsRaw()).isEqualTo("vac_project_ids_raw");
            softly.assertThat(value.signinEnabled()).isEqualTo("signin_enabled");
            softly.assertThat(value.preventMergeRequestsAuthorApproval())
                    .isEqualTo("prevent_merge_requests_author_approval");
            softly.assertThat(value.preventMergeRequestsCommittersApproval())
                    .isEqualTo("prevent_merge_requests_committers_approval");
            softly.assertThat(value.fileTemplateProjectId()).isEqualTo("file_template_project_id");
            softly.assertThat(value.updatingNameDisabledForUsers()).isEqualTo("updating_name_disabled_for_users");
            softly.assertThat(value.mavenPackageRequestsForwarding()).isEqualTo("maven_package_requests_forwarding");
            softly.assertThat(value.npmPackageRequestsForwarding()).isEqualTo("npm_package_requests_forwarding");
            softly.assertThat(value.virtualRegistriesEndpointsApiLimit())
                    .isEqualTo("virtual_registries_endpoints_api_limit");
            softly.assertThat(value.auditEventsApiLimit()).isEqualTo("audit_events_api_limit");
            softly.assertThat(value.preReceiveSecretDetectionEnabled())
                    .isEqualTo("pre_receive_secret_detection_enabled");
            softly.assertThat(value.pypiPackageRequestsForwarding()).isEqualTo("pypi_package_requests_forwarding");
            softly.assertThat(value.rubygemsPackageRequestsForwarding())
                    .isEqualTo("rubygems_package_requests_forwarding");
            softly.assertThat(value.maintenanceMode()).isEqualTo("maintenance_mode");
            softly.assertThat(value.maintenanceModeMessage()).isEqualTo("maintenance_mode_message");
            softly.assertThat(value.serviceAccessTokensExpirationEnforced())
                    .isEqualTo("service_access_tokens_expiration_enforced");
            softly.assertThat(value.unconfirmedUsersDeleteAfterDays()).isEqualTo("unconfirmed_users_delete_after_days");
            softly.assertThat(value.makeProfilePrivate()).isEqualTo("make_profile_private");
            softly.assertThat(value.builtInProjectTemplatesEnabled()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabApplicationSettingOtherFurther original = SettingsCatalogFixtures.applicationSettingOtherFurther();

        final GitLabApplicationSettingOtherFurther rebuilt =
                GitLabApplicationSettingOtherFurtherBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenGranularTokensEnforcedAfterIsACredential() {
        final GitLabApplicationSettingOtherFurther value = SettingsCatalogFixtures.applicationSettingOtherFurther();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenSecretDetectionTokenRevocationTokenIsACredential() {
        final GitLabApplicationSettingOtherFurther value = SettingsCatalogFixtures.applicationSettingOtherFurther();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenSecretDetectionServiceAuthTokenIsACredential() {
        final GitLabApplicationSettingOtherFurther value = SettingsCatalogFixtures.applicationSettingOtherFurther();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenSecretPushProtectionAvailableIsACredential() {
        final GitLabApplicationSettingOtherFurther value = SettingsCatalogFixtures.applicationSettingOtherFurther();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenServiceAccessTokensExpirationEnforcedIsACredential() {
        final GitLabApplicationSettingOtherFurther value = SettingsCatalogFixtures.applicationSettingOtherFurther();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabApplicationSettingOtherFurther.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "relationExportBatchSize",
                        "offlineTransferExportsEnabled",
                        "offlineTransferImportsEnabled",
                        "validRunnerRegistrars",
                        "deactivationEmailAdditionalText",
                        "projectsApiRateLimitUnauthenticated",
                        "projectsApiLimit",
                        "glqlDbSecondsPerIpLimit",
                        "glqlDbSecondsPerQueryLimit",
                        "glqlDbSecondsPerUserLimit",
                        "glqlDuoDbSecondsPerUserLimit",
                        "groupsApiLimit",
                        "issuableCsvImportLimit",
                        "labelDeleteLimit",
                        "createOrganizationApiLimit",
                        "crossReferenceChecksLimit",
                        "tagsCreateLimit",
                        "todosListApiLimit",
                        "systemHooksCreateLimit",
                        "webHookEventResendLimit",
                        "webHookTestLimit",
                        "workItemHierarchyAddChildrenLimit",
                        "workItemMoveLimit",
                        "workItemUpdateLimit",
                        "githubGistsImportLimit",
                        "namespaceAggregationScheduleLeaseDurationInSeconds",
                        "securityTxtContent",
                        "securityPolicyGlobalGroupApproversEnabled",
                        "securityApprovalPoliciesLimit",
                        "securityMrReportCacheLifetimeMinutes",
                        "securityScanStaleAfterDays",
                        "downstreamPipelineTriggerLimitPerProjectUserSha",
                        "jobRetryLimitPerUserProject",
                        "jobPlayLimitPerUserProject",
                        "jobEraseLimitPerUserProject",
                        "jobCancelLimitPerUserProject",
                        "asciidocMaxIncludes",
                        "aiActionApiRateLimit",
                        "aiAuditEventsStreamingEnabled",
                        "observabilityBackendSslVerificationEnabled",
                        "showMigrateFromJenkinsBanner",
                        "vscodeExtensionMarketplace",
                        "vscodeExtensionMarketplaceEnabled",
                        "vscodeExtensionMarketplaceExtensionHostDomain",
                        "vscodeExtensionMarketplaceSingleOriginFallbackEnabled",
                        "reindexingMinimumIndexSize",
                        "reindexingMinimumRelativeBloatSize",
                        "anonymousSearchesAllowed",
                        "gitPushPipelineLimit",
                        "gitTwoFactorSessionExpiry",
                        "gitRateLimitUsersAllowlist",
                        "gitRateLimitUsersAlertlist",
                        "delayUserAccountSelfDeletion",
                        "backgroundOperationsMaxJobs",
                        "pgAshSamplingEnabled",
                        "pgAshSampleIntervalSeconds",
                        "granularTokensEnforcedAfter",
                        "loggingFieldSchemaVersion",
                        "loggingFieldDualEmitTarget",
                        "deactivateDormantUsers",
                        "deactivateDormantUsersPeriod",
                        "nugetSkipMetadataUrlValidation",
                        "helmMaxPackagesCount",
                        "mcpServerEnabled",
                        "dynamicClientRegistrationEnabled",
                        "activeContextPauseIndexing",
                        "allowedIntegrations",
                        "automaticPurchasedStorageAllocation",
                        "checkNamespacePlan",
                        "geoNodeAllowedIps",
                        "geoStatusTimeout",
                        "modelPromptCacheEnabled",
                        "receptiveClusterAgentsEnabled",
                        "secretDetectionTokenRevocationEnabled",
                        "secretDetectionTokenRevocationUrl",
                        "secretDetectionTokenRevocationToken",
                        "secretDetectionRevocationTokenTypesUrl",
                        "secretDetectionServiceAuthToken",
                        "secretDetectionServiceUrl",
                        "secretPushProtectionAvailable",
                        "productAnalyticsEnabled",
                        "productAnalyticsDataCollectorHost",
                        "productAnalyticsConfiguratorConnectionString",
                        "cubeApiBaseUrl",
                        "cubeApiKey",
                        "toolApprovalForSessionEnabled",
                        "toolApprovalForSessionAvailability",
                        "foundationalAgentsDefaultEnabled",
                        "foundationalAgentsStatuses",
                        "orbitAutoIndexRootNamespace",
                        "orbitDapEnabledByDefault",
                        "orbitQueryLimit",
                        "orbitIndexingStatusLimit",
                        "orbitItemCountsLimit",
                        "orbitRateLimitAllowlistRaw",
                        "epicMoveListLimit",
                        "insightsQueryLimit",
                        "subscriptionUsagePerMinuteLimit",
                        "subscriptionUsagePerHourLimit",
                        "subscriptionUsagePerDayLimit",
                        "budgetCapUpdatePerMinuteLimit",
                        "budgetCapUpdatePerHourLimit",
                        "budgetCapUpdatePerDayLimit",
                        "scanExecutionPoliciesActionLimit",
                        "scanExecutionPoliciesScheduleLimit",
                        "scanExecutionPoliciesPerConfigurationLimit",
                        "vulnerabilityManagementPoliciesPerConfigurationLimit",
                        "policyStoreExperimentEnabled",
                        "fetchObservabilityAlertsFromCloud",
                        "elasticMigrationWorkerEnabled",
                        "displayGitlabCreditsUserData",
                        "vacProjectIdsRaw",
                        "signinEnabled",
                        "preventMergeRequestsAuthorApproval",
                        "preventMergeRequestsCommittersApproval",
                        "fileTemplateProjectId",
                        "updatingNameDisabledForUsers",
                        "mavenPackageRequestsForwarding",
                        "npmPackageRequestsForwarding",
                        "virtualRegistriesEndpointsApiLimit",
                        "auditEventsApiLimit",
                        "preReceiveSecretDetectionEnabled",
                        "pypiPackageRequestsForwarding",
                        "rubygemsPackageRequestsForwarding",
                        "maintenanceMode",
                        "maintenanceModeMessage",
                        "serviceAccessTokensExpirationEnforced",
                        "unconfirmedUsersDeleteAfterDays",
                        "makeProfilePrivate",
                        "builtInProjectTemplatesEnabled");
    }
}
