package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).id(null);

        final GitLabProject built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).description(null);

        final GitLabProject built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).name(null);

        final GitLabProject built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameWithNamespaceIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).nameWithNamespace(null);

        final GitLabProject built = builder.build();

        assertThat(built.nameWithNamespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).path(null);

        final GitLabProject built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathWithNamespaceIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).pathWithNamespace(null);

        final GitLabProject built = builder.build();

        assertThat(built.pathWithNamespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).createdAt(null);

        final GitLabProject built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultBranchIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).defaultBranch(null);

        final GitLabProject built = builder.build();

        assertThat(built.defaultBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagListIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).tagList(null);

        final GitLabProject built = builder.build();

        assertThat(built.tagList()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTopicsIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).topics(null);

        final GitLabProject built = builder.build();

        assertThat(built.topics()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSshUrlToRepoIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).sshUrlToRepo(null);

        final GitLabProject built = builder.build();

        assertThat(built.sshUrlToRepo()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHttpUrlToRepoIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).httpUrlToRepo(null);

        final GitLabProject built = builder.build();

        assertThat(built.httpUrlToRepo()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).webUrl(null);

        final GitLabProject built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadmeUrlIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).readmeUrl(null);

        final GitLabProject built = builder.build();

        assertThat(built.readmeUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenForksCountIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).forksCount(null);

        final GitLabProject built = builder.build();

        assertThat(built.forksCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLicenseUrlIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).licenseUrl(null);

        final GitLabProject built = builder.build();

        assertThat(built.licenseUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLicenseIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).license(null);

        final GitLabProject built = builder.build();

        assertThat(built.license()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvatarUrlIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).avatarUrl(null);

        final GitLabProject built = builder.build();

        assertThat(built.avatarUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStarCountIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).starCount(null);

        final GitLabProject built = builder.build();

        assertThat(built.starCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastActivityAtIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).lastActivityAt(null);

        final GitLabProject built = builder.build();

        assertThat(built.lastActivityAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVisibilityIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).visibility(null);

        final GitLabProject built = builder.build();

        assertThat(built.visibility()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespaceIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).namespace(null);

        final GitLabProject built = builder.build();

        assertThat(built.namespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomAttributesIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).customAttributes(null);

        final GitLabProject built = builder.build();

        assertThat(built.customAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryStorageIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).repositoryStorage(null);

        final GitLabProject built = builder.build();

        assertThat(built.repositoryStorage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenForkedFromProjectIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).forkedFromProject(null);

        final GitLabProject built = builder.build();

        assertThat(built.forkedFromProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRegistryImagePrefixIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).containerRegistryImagePrefix(null);

        final GitLabProject built = builder.build();

        assertThat(built.containerRegistryImagePrefix()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinksIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).links(null);

        final GitLabProject built = builder.build();

        assertThat(built.links()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMarkedForDeletionAtIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).markedForDeletionAt(null);

        final GitLabProject built = builder.build();

        assertThat(built.markedForDeletionAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMarkedForDeletionOnIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).markedForDeletionOn(null);

        final GitLabProject built = builder.build();

        assertThat(built.markedForDeletionOn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesEnabledIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).packagesEnabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.packagesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmptyRepoIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).emptyRepo(null);

        final GitLabProject built = builder.build();

        assertThat(built.emptyRepo()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchivedIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).archived(null);

        final GitLabProject built = builder.build();

        assertThat(built.archived()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOwnerIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).owner(null);

        final GitLabProject built = builder.build();

        assertThat(built.owner()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResolveOutdatedDiffDiscussionsIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).resolveOutdatedDiffDiscussions(null);

        final GitLabProject built = builder.build();

        assertThat(built.resolveOutdatedDiffDiscussions()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerExpirationPolicyIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).containerExpirationPolicy(null);

        final GitLabProject built = builder.build();

        assertThat(built.containerExpirationPolicy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryObjectFormatIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).repositoryObjectFormat(null);

        final GitLabProject built = builder.build();

        assertThat(built.repositoryObjectFormat()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEnabledIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).issuesEnabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.issuesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEnabledIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).mergeRequestsEnabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.mergeRequestsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiEnabledIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).wikiEnabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.wikiEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobsEnabledIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).jobsEnabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.jobsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetsEnabledIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).snippetsEnabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.snippetsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRegistryEnabledIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).containerRegistryEnabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.containerRegistryEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServiceDeskEnabledIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).serviceDeskEnabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.serviceDeskEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServiceDeskAddressIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).serviceDeskAddress(null);

        final GitLabProject built = builder.build();

        assertThat(built.serviceDeskAddress()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCanCreateMergeRequestInIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).canCreateMergeRequestIn(null);

        final GitLabProject built = builder.build();

        assertThat(built.canCreateMergeRequestIn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesAccessLevelIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).issuesAccessLevel(null);

        final GitLabProject built = builder.build();

        assertThat(built.issuesAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryAccessLevelIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).repositoryAccessLevel(null);

        final GitLabProject built = builder.build();

        assertThat(built.repositoryAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsAccessLevelIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).mergeRequestsAccessLevel(null);

        final GitLabProject built = builder.build();

        assertThat(built.mergeRequestsAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenForkingAccessLevelIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).forkingAccessLevel(null);

        final GitLabProject built = builder.build();

        assertThat(built.forkingAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiAccessLevelIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).wikiAccessLevel(null);

        final GitLabProject built = builder.build();

        assertThat(built.wikiAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBuildsAccessLevelIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).buildsAccessLevel(null);

        final GitLabProject built = builder.build();

        assertThat(built.buildsAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetsAccessLevelIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).snippetsAccessLevel(null);

        final GitLabProject built = builder.build();

        assertThat(built.snippetsAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesAccessLevelIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).pagesAccessLevel(null);

        final GitLabProject built = builder.build();

        assertThat(built.pagesAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAnalyticsAccessLevelIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).analyticsAccessLevel(null);

        final GitLabProject built = builder.build();

        assertThat(built.analyticsAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRegistryAccessLevelIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).containerRegistryAccessLevel(null);

        final GitLabProject built = builder.build();

        assertThat(built.containerRegistryAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecurityAndComplianceAccessLevelIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).securityAndComplianceAccessLevel(null);

        final GitLabProject built = builder.build();

        assertThat(built.securityAndComplianceAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReleasesAccessLevelIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).releasesAccessLevel(null);

        final GitLabProject built = builder.build();

        assertThat(built.releasesAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentsAccessLevelIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).environmentsAccessLevel(null);

        final GitLabProject built = builder.build();

        assertThat(built.environmentsAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFeatureFlagsAccessLevelIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).featureFlagsAccessLevel(null);

        final GitLabProject built = builder.build();

        assertThat(built.featureFlagsAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInfrastructureAccessLevelIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).infrastructureAccessLevel(null);

        final GitLabProject built = builder.build();

        assertThat(built.infrastructureAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMonitorAccessLevelIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).monitorAccessLevel(null);

        final GitLabProject built = builder.build();

        assertThat(built.monitorAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenModelExperimentsAccessLevelIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).modelExperimentsAccessLevel(null);

        final GitLabProject built = builder.build();

        assertThat(built.modelExperimentsAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenModelRegistryAccessLevelIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).modelRegistryAccessLevel(null);

        final GitLabProject built = builder.build();

        assertThat(built.modelRegistryAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageRegistryAccessLevelIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).packageRegistryAccessLevel(null);

        final GitLabProject built = builder.build();

        assertThat(built.packageRegistryAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailsDisabledIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).emailsDisabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.emailsDisabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailsEnabledIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).emailsEnabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.emailsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShowDiffPreviewInEmailIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).showDiffPreviewInEmail(null);

        final GitLabProject built = builder.build();

        assertThat(built.showDiffPreviewInEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSharedRunnersEnabledIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).sharedRunnersEnabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.sharedRunnersEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLfsEnabledIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).lfsEnabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.lfsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatorIdIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).creatorId(null);

        final GitLabProject built = builder.build();

        assertThat(built.creatorId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMrDefaultTargetSelfIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).mrDefaultTargetSelf(null);

        final GitLabProject built = builder.build();

        assertThat(built.mrDefaultTargetSelf()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportUrlIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).importUrl(null);

        final GitLabProject built = builder.build();

        assertThat(built.importUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportTypeIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).importType(null);

        final GitLabProject built = builder.build();

        assertThat(built.importType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportStatusIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).importStatus(null);

        final GitLabProject built = builder.build();

        assertThat(built.importStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportErrorIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).importError(null);

        final GitLabProject built = builder.build();

        assertThat(built.importError()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOpenIssuesCountIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).openIssuesCount(null);

        final GitLabProject built = builder.build();

        assertThat(built.openIssuesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionHtmlIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).descriptionHtml(null);

        final GitLabProject built = builder.build();

        assertThat(built.descriptionHtml()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).updatedAt(null);

        final GitLabProject built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiDefaultGitDepthIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).ciDefaultGitDepth(null);

        final GitLabProject built = builder.build();

        assertThat(built.ciDefaultGitDepth()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiDeletePipelinesInSecondsIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).ciDeletePipelinesInSeconds(null);

        final GitLabProject built = builder.build();

        assertThat(built.ciDeletePipelinesInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiForwardDeploymentEnabledIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).ciForwardDeploymentEnabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.ciForwardDeploymentEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiForwardDeploymentRollbackAllowedIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).ciForwardDeploymentRollbackAllowed(null);

        final GitLabProject built = builder.build();

        assertThat(built.ciForwardDeploymentRollbackAllowed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiJobTokenScopeEnabledIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).ciJobTokenScopeEnabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.ciJobTokenScopeEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiSeparatedCachesIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).ciSeparatedCaches(null);

        final GitLabProject built = builder.build();

        assertThat(built.ciSeparatedCaches()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiAllowForkPipelinesToRunInParentProjectIsNullable() {
        final GitLabProjectBuilder builder = GitLabProjectBuilder.builder(CommonCatalogFixtures.project())
                .ciAllowForkPipelinesToRunInParentProject(null);

        final GitLabProject built = builder.build();

        assertThat(built.ciAllowForkPipelinesToRunInParentProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiIdTokenSubClaimComponentsIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).ciIdTokenSubClaimComponents(null);

        final GitLabProject built = builder.build();

        assertThat(built.ciIdTokenSubClaimComponents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBuildGitStrategyIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).buildGitStrategy(null);

        final GitLabProject built = builder.build();

        assertThat(built.buildGitStrategy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKeepLatestArtifactIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).keepLatestArtifact(null);

        final GitLabProject built = builder.build();

        assertThat(built.keepLatestArtifact()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRestrictUserDefinedVariablesIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).restrictUserDefinedVariables(null);

        final GitLabProject built = builder.build();

        assertThat(built.restrictUserDefinedVariables()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiPipelineVariablesMinimumOverrideRoleIsNullable() {
        final GitLabProjectBuilder builder = GitLabProjectBuilder.builder(CommonCatalogFixtures.project())
                .ciPipelineVariablesMinimumOverrideRole(null);

        final GitLabProject built = builder.build();

        assertThat(built.ciPipelineVariablesMinimumOverrideRole()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunnerTokenExpirationIntervalIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).runnerTokenExpirationInterval(null);

        final GitLabProject built = builder.build();

        assertThat(built.runnerTokenExpirationInterval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupRunnersEnabledIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).groupRunnersEnabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.groupRunnersEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResourceGroupDefaultProcessModeIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).resourceGroupDefaultProcessMode(null);

        final GitLabProject built = builder.build();

        assertThat(built.resourceGroupDefaultProcessMode()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoCancelPendingPipelinesIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).autoCancelPendingPipelines(null);

        final GitLabProject built = builder.build();

        assertThat(built.autoCancelPendingPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBuildTimeoutIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).buildTimeout(null);

        final GitLabProject built = builder.build();

        assertThat(built.buildTimeout()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoDevopsEnabledIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).autoDevopsEnabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.autoDevopsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoDevopsDeployStrategyIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).autoDevopsDeployStrategy(null);

        final GitLabProject built = builder.build();

        assertThat(built.autoDevopsDeployStrategy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiPushRepositoryForJobTokenAllowedIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).ciPushRepositoryForJobTokenAllowed(null);

        final GitLabProject built = builder.build();

        assertThat(built.ciPushRepositoryForJobTokenAllowed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProtectMergeRequestPipelinesIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).protectMergeRequestPipelines(null);

        final GitLabProject built = builder.build();

        assertThat(built.protectMergeRequestPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiDisplayPipelineVariablesIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).ciDisplayPipelineVariables(null);

        final GitLabProject built = builder.build();

        assertThat(built.ciDisplayPipelineVariables()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiSkipBranchPipelinesForMrsIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).ciSkipBranchPipelinesForMrs(null);

        final GitLabProject built = builder.build();

        assertThat(built.ciSkipBranchPipelinesForMrs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunnersTokenIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).runnersToken(null);

        final GitLabProject built = builder.build();

        assertThat(built.runnersToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiConfigPathIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).ciConfigPath(null);

        final GitLabProject built = builder.build();

        assertThat(built.ciConfigPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPublicJobsIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).publicJobs(null);

        final GitLabProject built = builder.build();

        assertThat(built.publicJobs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSharedWithGroupsIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).sharedWithGroups(null);

        final GitLabProject built = builder.build();

        assertThat(built.sharedWithGroups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOnlyAllowMergeIfPipelineSucceedsIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).onlyAllowMergeIfPipelineSucceeds(null);

        final GitLabProject built = builder.build();

        assertThat(built.onlyAllowMergeIfPipelineSucceeds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowMergeOnSkippedPipelineIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).allowMergeOnSkippedPipeline(null);

        final GitLabProject built = builder.build();

        assertThat(built.allowMergeOnSkippedPipeline()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequestAccessEnabledIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).requestAccessEnabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.requestAccessEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOnlyAllowMergeIfAllDiscussionsAreResolvedIsNullable() {
        final GitLabProjectBuilder builder = GitLabProjectBuilder.builder(CommonCatalogFixtures.project())
                .onlyAllowMergeIfAllDiscussionsAreResolved(null);

        final GitLabProject built = builder.build();

        assertThat(built.onlyAllowMergeIfAllDiscussionsAreResolved()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRemoveSourceBranchAfterMergeIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).removeSourceBranchAfterMerge(null);

        final GitLabProject built = builder.build();

        assertThat(built.removeSourceBranchAfterMerge()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPrintingMergeRequestLinkEnabledIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).printingMergeRequestLinkEnabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.printingMergeRequestLinkEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeMethodIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).mergeMethod(null);

        final GitLabProject built = builder.build();

        assertThat(built.mergeMethod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSquashOptionIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).squashOption(null);

        final GitLabProject built = builder.build();

        assertThat(built.squashOption()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutomaticRebaseEnabledIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).automaticRebaseEnabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.automaticRebaseEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnforceAuthChecksOnUploadsIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).enforceAuthChecksOnUploads(null);

        final GitLabProject built = builder.build();

        assertThat(built.enforceAuthChecksOnUploads()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSuggestionCommitMessageIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).suggestionCommitMessage(null);

        final GitLabProject built = builder.build();

        assertThat(built.suggestionCommitMessage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeCommitTemplateIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).mergeCommitTemplate(null);

        final GitLabProject built = builder.build();

        assertThat(built.mergeCommitTemplate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSquashCommitTemplateIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).squashCommitTemplate(null);

        final GitLabProject built = builder.build();

        assertThat(built.squashCommitTemplate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMrDefaultTitleTemplateIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).mrDefaultTitleTemplate(null);

        final GitLabProject built = builder.build();

        assertThat(built.mrDefaultTitleTemplate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssueBranchTemplateIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).issueBranchTemplate(null);

        final GitLabProject built = builder.build();

        assertThat(built.issueBranchTemplate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatisticsIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).statistics(null);

        final GitLabProject built = builder.build();

        assertThat(built.statistics()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWarnAboutPotentiallyUnwantedCharactersIsNullable() {
        final GitLabProjectBuilder builder = GitLabProjectBuilder.builder(CommonCatalogFixtures.project())
                .warnAboutPotentiallyUnwantedCharacters(null);

        final GitLabProject built = builder.build();

        assertThat(built.warnAboutPotentiallyUnwantedCharacters()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutocloseReferencedIssuesIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).autocloseReferencedIssues(null);

        final GitLabProject built = builder.build();

        assertThat(built.autocloseReferencedIssues()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxArtifactsSizeIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).maxArtifactsSize(null);

        final GitLabProject built = builder.build();

        assertThat(built.maxArtifactsSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalsBeforeMergeIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).approvalsBeforeMerge(null);

        final GitLabProject built = builder.build();

        assertThat(built.approvalsBeforeMerge()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMirrorIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).mirror(null);

        final GitLabProject built = builder.build();

        assertThat(built.mirror()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMirrorUserIdIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).mirrorUserId(null);

        final GitLabProject built = builder.build();

        assertThat(built.mirrorUserId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMirrorTriggerBuildsIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).mirrorTriggerBuilds(null);

        final GitLabProject built = builder.build();

        assertThat(built.mirrorTriggerBuilds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOnlyMirrorProtectedBranchesIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).onlyMirrorProtectedBranches(null);

        final GitLabProject built = builder.build();

        assertThat(built.onlyMirrorProtectedBranches()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMirrorOverwritesDivergedBranchesIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).mirrorOverwritesDivergedBranches(null);

        final GitLabProject built = builder.build();

        assertThat(built.mirrorOverwritesDivergedBranches()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalAuthorizationClassificationLabelIsNullable() {
        final GitLabProjectBuilder builder = GitLabProjectBuilder.builder(CommonCatalogFixtures.project())
                .externalAuthorizationClassificationLabel(null);

        final GitLabProject built = builder.build();

        assertThat(built.externalAuthorizationClassificationLabel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequirementsEnabledIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).requirementsEnabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.requirementsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequirementsAccessLevelIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).requirementsAccessLevel(null);

        final GitLabProject built = builder.build();

        assertThat(built.requirementsAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecurityAndComplianceEnabledIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).securityAndComplianceEnabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.securityAndComplianceEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecretPushProtectionEnabledIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).secretPushProtectionEnabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.secretPushProtectionEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPreReceiveSecretDetectionEnabledIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).preReceiveSecretDetectionEnabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.preReceiveSecretDetectionEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenComplianceFrameworksIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).complianceFrameworks(null);

        final GitLabProject built = builder.build();

        assertThat(built.complianceFrameworks()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesTemplateIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).issuesTemplate(null);

        final GitLabProject built = builder.build();

        assertThat(built.issuesTemplate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsTemplateIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).mergeRequestsTemplate(null);

        final GitLabProject built = builder.build();

        assertThat(built.mergeRequestsTemplate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiRestrictPipelineCancellationRoleIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).ciRestrictPipelineCancellationRole(null);

        final GitLabProject built = builder.build();

        assertThat(built.ciRestrictPipelineCancellationRole()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergePipelinesEnabledIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).mergePipelinesEnabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.mergePipelinesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeTrainsEnabledIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).mergeTrainsEnabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.mergeTrainsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeTrainsSkipTrainAllowedIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).mergeTrainsSkipTrainAllowed(null);

        final GitLabProject built = builder.build();

        assertThat(built.mergeTrainsSkipTrainAllowed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeTrainEnforcementIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).mergeTrainEnforcement(null);

        final GitLabProject built = builder.build();

        assertThat(built.mergeTrainEnforcement()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxPipelinesPerMergeTrainIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).maxPipelinesPerMergeTrain(null);

        final GitLabProject built = builder.build();

        assertThat(built.maxPipelinesPerMergeTrain()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOnlyAllowMergeIfAllStatusChecksPassedIsNullable() {
        final GitLabProjectBuilder builder = GitLabProjectBuilder.builder(CommonCatalogFixtures.project())
                .onlyAllowMergeIfAllStatusChecksPassed(null);

        final GitLabProject built = builder.build();

        assertThat(built.onlyAllowMergeIfAllStatusChecksPassed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowPipelineTriggerApproveDeploymentIsNullable() {
        final GitLabProjectBuilder builder = GitLabProjectBuilder.builder(CommonCatalogFixtures.project())
                .allowPipelineTriggerApproveDeployment(null);

        final GitLabProject built = builder.build();

        assertThat(built.allowPipelineTriggerApproveDeployment()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPreventMergeWithoutJiraIssueIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).preventMergeWithoutJiraIssue(null);

        final GitLabProject built = builder.build();

        assertThat(built.preventMergeWithoutJiraIssue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoDuoCodeReviewEnabledIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).autoDuoCodeReviewEnabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.autoDuoCodeReviewEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCodeReviewDecisionsEnabledIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).duoCodeReviewDecisionsEnabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.duoCodeReviewDecisionsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCodeReviewDepthAllowedIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).duoCodeReviewDepthAllowed(null);

        final GitLabProject built = builder.build();

        assertThat(built.duoCodeReviewDepthAllowed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCodeReviewDefaultDepthIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).duoCodeReviewDefaultDepth(null);

        final GitLabProject built = builder.build();

        assertThat(built.duoCodeReviewDefaultDepth()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReviewerAssignmentStrategyIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).reviewerAssignmentStrategy(null);

        final GitLabProject built = builder.build();

        assertThat(built.reviewerAssignmentStrategy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoRemoteFlowsEnabledIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).duoRemoteFlowsEnabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.duoRemoteFlowsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoFoundationalFlowsEnabledIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).duoFoundationalFlowsEnabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.duoFoundationalFlowsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoScheduledAutomationsEnabledIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).duoScheduledAutomationsEnabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.duoScheduledAutomationsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoSastFpDetectionEnabledIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).duoSastFpDetectionEnabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.duoSastFpDetectionEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoSecretDetectionFpEnabledIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).duoSecretDetectionFpEnabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.duoSecretDetectionFpEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoDependencyBumpBreakingChangesEnabledIsNullable() {
        final GitLabProjectBuilder builder = GitLabProjectBuilder.builder(CommonCatalogFixtures.project())
                .duoDependencyBumpBreakingChangesEnabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.duoDependencyBumpBreakingChangesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoSastVrWorkflowEnabledIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).duoSastVrWorkflowEnabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.duoSastVrWorkflowEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebBasedCommitSigningEnabledIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).webBasedCommitSigningEnabled(null);

        final GitLabProject built = builder.build();

        assertThat(built.webBasedCommitSigningEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSppRepositoryPipelineAccessIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).sppRepositoryPipelineAccess(null);

        final GitLabProject built = builder.build();

        assertThat(built.sppRepositoryPipelineAccess()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecurityPolicyPipelineMustSucceedIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).securityPolicyPipelineMustSucceed(null);

        final GitLabProject built = builder.build();

        assertThat(built.securityPolicyPipelineMustSucceed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestTitleRegexIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).mergeRequestTitleRegex(null);

        final GitLabProject built = builder.build();

        assertThat(built.mergeRequestTitleRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestTitleRegexDescriptionIsNullable() {
        final GitLabProjectBuilder builder =
                GitLabProjectBuilder.builder(CommonCatalogFixtures.project()).mergeRequestTitleRegexDescription(null);

        final GitLabProject built = builder.build();

        assertThat(built.mergeRequestTitleRegexDescription()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProject value = CommonCatalogFixtures.project();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.description()).isEqualTo("desc");
            softly.assertThat(value.name()).isEqualTo("project1");
            softly.assertThat(value.nameWithNamespace()).isEqualTo("John Doe / project1");
            softly.assertThat(value.path()).isEqualTo("project1");
            softly.assertThat(value.pathWithNamespace()).isEqualTo("namespace1/project1");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.defaultBranch()).isEqualTo("main");
            softly.assertThat(value.tagList()).isEqualTo(List.of("tag"));
            softly.assertThat(value.topics()).isEqualTo(List.of("topic"));
            softly.assertThat(value.sshUrlToRepo()).isEqualTo("git@gitlab.example.com:gitlab/gitlab.git");
            softly.assertThat(value.httpUrlToRepo()).isEqualTo("https://gitlab.example.com/gitlab/gitlab.git");
            softly.assertThat(value.webUrl()).isEqualTo("https://gitlab.example.com/gitlab/gitlab");
            softly.assertThat(value.readmeUrl())
                    .isEqualTo("https://gitlab.example.com/gitlab/gitlab/blob/master/README.md");
            softly.assertThat(value.forksCount()).isEqualTo(1);
            softly.assertThat(value.licenseUrl())
                    .isEqualTo("https://gitlab.example.com/gitlab/gitlab/blob/master/LICENCE");
            softly.assertThat(value.license()).isEqualTo(CommonCatalogFixtures.licenseBasic());
            softly.assertThat(value.avatarUrl())
                    .isEqualTo("http://example.com/uploads/project/avatar/3/uploads/avatar.png");
            softly.assertThat(value.starCount()).isEqualTo(1);
            softly.assertThat(value.lastActivityAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.visibility()).isEqualTo("public");
            softly.assertThat(value.namespace()).isEqualTo(CommonCatalogFixtures.namespaceBasic());
            softly.assertThat(value.customAttributes()).isEqualTo(CommonCatalogFixtures.customAttribute());
            softly.assertThat(value.repositoryStorage()).isEqualTo("default");
            softly.assertThat(value.forkedFromProject()).isEqualTo(CommonCatalogFixtures.basicProjectDetails());
            softly.assertThat(value.containerRegistryImagePrefix())
                    .isEqualTo("registry.gitlab.example.com/gitlab/gitlab-client");
            softly.assertThat(value.links()).isEqualTo(CommonCatalogFixtures.projectLinks());
            softly.assertThat(value.markedForDeletionAt()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.markedForDeletionOn()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.packagesEnabled()).isEqualTo(true);
            softly.assertThat(value.emptyRepo()).isEqualTo(true);
            softly.assertThat(value.archived()).isEqualTo(true);
            softly.assertThat(value.owner()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.resolveOutdatedDiffDiscussions()).isEqualTo(true);
            softly.assertThat(value.containerExpirationPolicy())
                    .isEqualTo(CommonCatalogFixtures.containerExpirationPolicy());
            softly.assertThat(value.repositoryObjectFormat()).isEqualTo("sha1");
            softly.assertThat(value.issuesEnabled()).isEqualTo(true);
            softly.assertThat(value.mergeRequestsEnabled()).isEqualTo(true);
            softly.assertThat(value.wikiEnabled()).isEqualTo(true);
            softly.assertThat(value.jobsEnabled()).isEqualTo(true);
            softly.assertThat(value.snippetsEnabled()).isEqualTo(true);
            softly.assertThat(value.containerRegistryEnabled()).isEqualTo(true);
            softly.assertThat(value.serviceDeskEnabled()).isEqualTo(true);
            softly.assertThat(value.serviceDeskAddress()).isEqualTo("address@example.com");
            softly.assertThat(value.canCreateMergeRequestIn()).isEqualTo(true);
            softly.assertThat(value.issuesAccessLevel()).isEqualTo("enabled");
            softly.assertThat(value.repositoryAccessLevel()).isEqualTo("enabled");
            softly.assertThat(value.mergeRequestsAccessLevel()).isEqualTo("enabled");
            softly.assertThat(value.forkingAccessLevel()).isEqualTo("enabled");
            softly.assertThat(value.wikiAccessLevel()).isEqualTo("enabled");
            softly.assertThat(value.buildsAccessLevel()).isEqualTo("enabled");
            softly.assertThat(value.snippetsAccessLevel()).isEqualTo("enabled");
            softly.assertThat(value.pagesAccessLevel()).isEqualTo("enabled");
            softly.assertThat(value.analyticsAccessLevel()).isEqualTo("enabled");
            softly.assertThat(value.containerRegistryAccessLevel()).isEqualTo("enabled");
            softly.assertThat(value.securityAndComplianceAccessLevel()).isEqualTo("enabled");
            softly.assertThat(value.releasesAccessLevel()).isEqualTo("enabled");
            softly.assertThat(value.environmentsAccessLevel()).isEqualTo("enabled");
            softly.assertThat(value.featureFlagsAccessLevel()).isEqualTo("enabled");
            softly.assertThat(value.infrastructureAccessLevel()).isEqualTo("enabled");
            softly.assertThat(value.monitorAccessLevel()).isEqualTo("enabled");
            softly.assertThat(value.modelExperimentsAccessLevel()).isEqualTo("enabled");
            softly.assertThat(value.modelRegistryAccessLevel()).isEqualTo("enabled");
            softly.assertThat(value.packageRegistryAccessLevel()).isEqualTo("enabled");
            softly.assertThat(value.emailsDisabled()).isEqualTo(true);
            softly.assertThat(value.emailsEnabled()).isEqualTo(true);
            softly.assertThat(value.showDiffPreviewInEmail()).isEqualTo(true);
            softly.assertThat(value.sharedRunnersEnabled()).isEqualTo(true);
            softly.assertThat(value.lfsEnabled()).isEqualTo(true);
            softly.assertThat(value.creatorId()).isEqualTo(1L);
            softly.assertThat(value.mrDefaultTargetSelf()).isEqualTo(true);
            softly.assertThat(value.importUrl()).isEqualTo("https://gitlab.com/gitlab/gitlab.git");
            softly.assertThat(value.importType()).isEqualTo("git");
            softly.assertThat(value.importStatus()).isEqualTo("none");
            softly.assertThat(value.importError()).isEqualTo("Import error");
            softly.assertThat(value.openIssuesCount()).isEqualTo(1);
            softly.assertThat(value.descriptionHtml()).isEqualTo("description_html");
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.ciDefaultGitDepth()).isEqualTo(1);
            softly.assertThat(value.ciDeletePipelinesInSeconds()).isEqualTo(1);
            softly.assertThat(value.ciForwardDeploymentEnabled()).isEqualTo(true);
            softly.assertThat(value.ciForwardDeploymentRollbackAllowed()).isEqualTo(true);
            softly.assertThat(value.ciJobTokenScopeEnabled()).isEqualTo(true);
            softly.assertThat(value.ciSeparatedCaches()).isEqualTo(true);
            softly.assertThat(value.ciAllowForkPipelinesToRunInParentProject()).isEqualTo(true);
            softly.assertThat(value.ciIdTokenSubClaimComponents())
                    .isEqualTo(List.of("ci_id_token_sub_claim_components"));
            softly.assertThat(value.buildGitStrategy()).isEqualTo("fetch");
            softly.assertThat(value.keepLatestArtifact()).isEqualTo(true);
            softly.assertThat(value.restrictUserDefinedVariables()).isEqualTo(true);
            softly.assertThat(value.ciPipelineVariablesMinimumOverrideRole())
                    .isEqualTo("ci_pipeline_variables_minimum_override_role");
            softly.assertThat(value.runnerTokenExpirationInterval()).isEqualTo(1);
            softly.assertThat(value.groupRunnersEnabled()).isEqualTo(true);
            softly.assertThat(value.resourceGroupDefaultProcessMode()).isEqualTo("unordered");
            softly.assertThat(value.autoCancelPendingPipelines()).isEqualTo("enabled");
            softly.assertThat(value.buildTimeout()).isEqualTo(1);
            softly.assertThat(value.autoDevopsEnabled()).isEqualTo(true);
            softly.assertThat(value.autoDevopsDeployStrategy()).isEqualTo("continuous");
            softly.assertThat(value.ciPushRepositoryForJobTokenAllowed()).isEqualTo(true);
            softly.assertThat(value.protectMergeRequestPipelines()).isEqualTo(true);
            softly.assertThat(value.ciDisplayPipelineVariables()).isEqualTo(true);
            softly.assertThat(value.ciSkipBranchPipelinesForMrs()).isEqualTo(true);
            softly.assertThat(value.runnersToken()).isEqualTo("b8547b1dc37721d05889db52fa2f02");
            softly.assertThat(value.ciConfigPath()).isEqualTo("");
            softly.assertThat(value.publicJobs()).isEqualTo(true);
            softly.assertThat(value.sharedWithGroups()).isEqualTo(List.of(Map.of("key", "value")));
            softly.assertThat(value.onlyAllowMergeIfPipelineSucceeds()).isEqualTo(true);
            softly.assertThat(value.allowMergeOnSkippedPipeline()).isEqualTo(true);
            softly.assertThat(value.requestAccessEnabled()).isEqualTo(true);
            softly.assertThat(value.onlyAllowMergeIfAllDiscussionsAreResolved()).isEqualTo(true);
            softly.assertThat(value.removeSourceBranchAfterMerge()).isEqualTo(true);
            softly.assertThat(value.printingMergeRequestLinkEnabled()).isEqualTo(true);
            softly.assertThat(value.mergeMethod()).isEqualTo("merge");
            softly.assertThat(value.squashOption()).isEqualTo("default_off");
            softly.assertThat(value.automaticRebaseEnabled()).isEqualTo(true);
            softly.assertThat(value.enforceAuthChecksOnUploads()).isEqualTo(true);
            softly.assertThat(value.suggestionCommitMessage()).isEqualTo("Suggestion message");
            softly.assertThat(value.mergeCommitTemplate()).isEqualTo("%(title)");
            softly.assertThat(value.squashCommitTemplate()).isEqualTo("%(source_branch)");
            softly.assertThat(value.mrDefaultTitleTemplate()).isEqualTo("%(source_branch)");
            softly.assertThat(value.issueBranchTemplate()).isEqualTo("%(title)");
            softly.assertThat(value.statistics()).isEqualTo(CommonCatalogFixtures.projectStatistics());
            softly.assertThat(value.warnAboutPotentiallyUnwantedCharacters()).isEqualTo(true);
            softly.assertThat(value.autocloseReferencedIssues()).isEqualTo(true);
            softly.assertThat(value.maxArtifactsSize()).isEqualTo(1L);
            softly.assertThat(value.approvalsBeforeMerge()).isEqualTo(1);
            softly.assertThat(value.mirror()).isEqualTo(true);
            softly.assertThat(value.mirrorUserId()).isEqualTo(1L);
            softly.assertThat(value.mirrorTriggerBuilds()).isEqualTo(true);
            softly.assertThat(value.onlyMirrorProtectedBranches()).isEqualTo(true);
            softly.assertThat(value.mirrorOverwritesDivergedBranches()).isEqualTo(true);
            softly.assertThat(value.externalAuthorizationClassificationLabel())
                    .isEqualTo("external_authorization_classification_label");
            softly.assertThat(value.requirementsEnabled()).isEqualTo(true);
            softly.assertThat(value.requirementsAccessLevel()).isEqualTo("requirements_access_level");
            softly.assertThat(value.securityAndComplianceEnabled()).isEqualTo(true);
            softly.assertThat(value.secretPushProtectionEnabled()).isEqualTo(true);
            softly.assertThat(value.preReceiveSecretDetectionEnabled()).isEqualTo(true);
            softly.assertThat(value.complianceFrameworks()).isEqualTo(List.of("compliance_frameworks"));
            softly.assertThat(value.issuesTemplate()).isEqualTo("issues_template");
            softly.assertThat(value.mergeRequestsTemplate()).isEqualTo("merge_requests_template");
            softly.assertThat(value.ciRestrictPipelineCancellationRole())
                    .isEqualTo("ci_restrict_pipeline_cancellation_role");
            softly.assertThat(value.mergePipelinesEnabled()).isEqualTo(true);
            softly.assertThat(value.mergeTrainsEnabled()).isEqualTo(true);
            softly.assertThat(value.mergeTrainsSkipTrainAllowed()).isEqualTo(true);
            softly.assertThat(value.mergeTrainEnforcement()).isEqualTo("merge_train_enforcement");
            softly.assertThat(value.maxPipelinesPerMergeTrain()).isEqualTo("max_pipelines_per_merge_train");
            softly.assertThat(value.onlyAllowMergeIfAllStatusChecksPassed()).isEqualTo(true);
            softly.assertThat(value.allowPipelineTriggerApproveDeployment()).isEqualTo(true);
            softly.assertThat(value.preventMergeWithoutJiraIssue()).isEqualTo(true);
            softly.assertThat(value.autoDuoCodeReviewEnabled()).isEqualTo(true);
            softly.assertThat(value.duoCodeReviewDecisionsEnabled()).isEqualTo(true);
            softly.assertThat(value.duoCodeReviewDepthAllowed()).isEqualTo(true);
            softly.assertThat(value.duoCodeReviewDefaultDepth()).isEqualTo("standard");
            softly.assertThat(value.reviewerAssignmentStrategy()).isEqualTo("code_owners");
            softly.assertThat(value.duoRemoteFlowsEnabled()).isEqualTo(true);
            softly.assertThat(value.duoFoundationalFlowsEnabled()).isEqualTo(true);
            softly.assertThat(value.duoScheduledAutomationsEnabled()).isEqualTo("duo_scheduled_automations_enabled");
            softly.assertThat(value.duoSastFpDetectionEnabled()).isEqualTo(true);
            softly.assertThat(value.duoSecretDetectionFpEnabled()).isEqualTo(true);
            softly.assertThat(value.duoDependencyBumpBreakingChangesEnabled()).isEqualTo(true);
            softly.assertThat(value.duoSastVrWorkflowEnabled()).isEqualTo(true);
            softly.assertThat(value.webBasedCommitSigningEnabled()).isEqualTo("web_based_commit_signing_enabled");
            softly.assertThat(value.sppRepositoryPipelineAccess()).isEqualTo(true);
            softly.assertThat(value.securityPolicyPipelineMustSucceed()).isEqualTo(true);
            softly.assertThat(value.mergeRequestTitleRegex()).isEqualTo("/Title of merge request/");
            softly.assertThat(value.mergeRequestTitleRegexDescription())
                    .isEqualTo("This requires the title to include a Jira label");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProject original = CommonCatalogFixtures.project();

        final GitLabProject rebuilt = GitLabProjectBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenRunnersTokenIsACredential() {
        final GitLabProject value = CommonCatalogFixtures.project();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProject.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "description",
                        "name",
                        "nameWithNamespace",
                        "path",
                        "pathWithNamespace",
                        "createdAt",
                        "defaultBranch",
                        "tagList",
                        "topics",
                        "sshUrlToRepo",
                        "httpUrlToRepo",
                        "webUrl",
                        "readmeUrl",
                        "forksCount",
                        "licenseUrl",
                        "license",
                        "avatarUrl",
                        "starCount",
                        "lastActivityAt",
                        "visibility",
                        "namespace",
                        "customAttributes",
                        "repositoryStorage",
                        "forkedFromProject",
                        "containerRegistryImagePrefix",
                        "links",
                        "markedForDeletionAt",
                        "markedForDeletionOn",
                        "packagesEnabled",
                        "emptyRepo",
                        "archived",
                        "owner",
                        "resolveOutdatedDiffDiscussions",
                        "containerExpirationPolicy",
                        "repositoryObjectFormat",
                        "issuesEnabled",
                        "mergeRequestsEnabled",
                        "wikiEnabled",
                        "jobsEnabled",
                        "snippetsEnabled",
                        "containerRegistryEnabled",
                        "serviceDeskEnabled",
                        "serviceDeskAddress",
                        "canCreateMergeRequestIn",
                        "issuesAccessLevel",
                        "repositoryAccessLevel",
                        "mergeRequestsAccessLevel",
                        "forkingAccessLevel",
                        "wikiAccessLevel",
                        "buildsAccessLevel",
                        "snippetsAccessLevel",
                        "pagesAccessLevel",
                        "analyticsAccessLevel",
                        "containerRegistryAccessLevel",
                        "securityAndComplianceAccessLevel",
                        "releasesAccessLevel",
                        "environmentsAccessLevel",
                        "featureFlagsAccessLevel",
                        "infrastructureAccessLevel",
                        "monitorAccessLevel",
                        "modelExperimentsAccessLevel",
                        "modelRegistryAccessLevel",
                        "packageRegistryAccessLevel",
                        "emailsDisabled",
                        "emailsEnabled",
                        "showDiffPreviewInEmail",
                        "sharedRunnersEnabled",
                        "lfsEnabled",
                        "creatorId",
                        "mrDefaultTargetSelf",
                        "importUrl",
                        "importType",
                        "importStatus",
                        "importError",
                        "openIssuesCount",
                        "descriptionHtml",
                        "updatedAt",
                        "ciDefaultGitDepth",
                        "ciDeletePipelinesInSeconds",
                        "ciForwardDeploymentEnabled",
                        "ciForwardDeploymentRollbackAllowed",
                        "ciJobTokenScopeEnabled",
                        "ciSeparatedCaches",
                        "ciAllowForkPipelinesToRunInParentProject",
                        "ciIdTokenSubClaimComponents",
                        "buildGitStrategy",
                        "keepLatestArtifact",
                        "restrictUserDefinedVariables",
                        "ciPipelineVariablesMinimumOverrideRole",
                        "runnerTokenExpirationInterval",
                        "groupRunnersEnabled",
                        "resourceGroupDefaultProcessMode",
                        "autoCancelPendingPipelines",
                        "buildTimeout",
                        "autoDevopsEnabled",
                        "autoDevopsDeployStrategy",
                        "ciPushRepositoryForJobTokenAllowed",
                        "protectMergeRequestPipelines",
                        "ciDisplayPipelineVariables",
                        "ciSkipBranchPipelinesForMrs",
                        "runnersToken",
                        "ciConfigPath",
                        "publicJobs",
                        "sharedWithGroups",
                        "onlyAllowMergeIfPipelineSucceeds",
                        "allowMergeOnSkippedPipeline",
                        "requestAccessEnabled",
                        "onlyAllowMergeIfAllDiscussionsAreResolved",
                        "removeSourceBranchAfterMerge",
                        "printingMergeRequestLinkEnabled",
                        "mergeMethod",
                        "squashOption",
                        "automaticRebaseEnabled",
                        "enforceAuthChecksOnUploads",
                        "suggestionCommitMessage",
                        "mergeCommitTemplate",
                        "squashCommitTemplate",
                        "mrDefaultTitleTemplate",
                        "issueBranchTemplate",
                        "statistics",
                        "warnAboutPotentiallyUnwantedCharacters",
                        "autocloseReferencedIssues",
                        "maxArtifactsSize",
                        "approvalsBeforeMerge",
                        "mirror",
                        "mirrorUserId",
                        "mirrorTriggerBuilds",
                        "onlyMirrorProtectedBranches",
                        "mirrorOverwritesDivergedBranches",
                        "externalAuthorizationClassificationLabel",
                        "requirementsEnabled",
                        "requirementsAccessLevel",
                        "securityAndComplianceEnabled",
                        "secretPushProtectionEnabled",
                        "preReceiveSecretDetectionEnabled",
                        "complianceFrameworks",
                        "issuesTemplate",
                        "mergeRequestsTemplate",
                        "ciRestrictPipelineCancellationRole",
                        "mergePipelinesEnabled",
                        "mergeTrainsEnabled",
                        "mergeTrainsSkipTrainAllowed",
                        "mergeTrainEnforcement",
                        "maxPipelinesPerMergeTrain",
                        "onlyAllowMergeIfAllStatusChecksPassed",
                        "allowPipelineTriggerApproveDeployment",
                        "preventMergeWithoutJiraIssue",
                        "autoDuoCodeReviewEnabled",
                        "duoCodeReviewDecisionsEnabled",
                        "duoCodeReviewDepthAllowed",
                        "duoCodeReviewDefaultDepth",
                        "reviewerAssignmentStrategy",
                        "duoRemoteFlowsEnabled",
                        "duoFoundationalFlowsEnabled",
                        "duoScheduledAutomationsEnabled",
                        "duoSastFpDetectionEnabled",
                        "duoSecretDetectionFpEnabled",
                        "duoDependencyBumpBreakingChangesEnabled",
                        "duoSastVrWorkflowEnabled",
                        "webBasedCommitSigningEnabled",
                        "sppRepositoryPipelineAccess",
                        "securityPolicyPipelineMustSucceed",
                        "mergeRequestTitleRegex",
                        "mergeRequestTitleRegexDescription");
    }
}
