package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectWithAccessTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .id(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .description(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .name(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameWithNamespaceIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .nameWithNamespace(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.nameWithNamespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .path(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathWithNamespaceIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .pathWithNamespace(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.pathWithNamespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .createdAt(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultBranchIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .defaultBranch(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.defaultBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagListIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .tagList(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.tagList()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTopicsIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .topics(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.topics()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSshUrlToRepoIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .sshUrlToRepo(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.sshUrlToRepo()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHttpUrlToRepoIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .httpUrlToRepo(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.httpUrlToRepo()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .webUrl(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadmeUrlIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .readmeUrl(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.readmeUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenForksCountIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .forksCount(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.forksCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLicenseUrlIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .licenseUrl(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.licenseUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLicenseIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .license(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.license()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvatarUrlIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .avatarUrl(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.avatarUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStarCountIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .starCount(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.starCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastActivityAtIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .lastActivityAt(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.lastActivityAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVisibilityIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .visibility(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.visibility()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespaceIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .namespace(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.namespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomAttributesIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .customAttributes(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.customAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryStorageIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .repositoryStorage(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.repositoryStorage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenForkedFromProjectIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .forkedFromProject(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.forkedFromProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRegistryImagePrefixIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .containerRegistryImagePrefix(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.containerRegistryImagePrefix()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinksIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .links(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.links()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMarkedForDeletionAtIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .markedForDeletionAt(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.markedForDeletionAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMarkedForDeletionOnIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .markedForDeletionOn(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.markedForDeletionOn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesEnabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .packagesEnabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.packagesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmptyRepoIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .emptyRepo(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.emptyRepo()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchivedIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .archived(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.archived()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOwnerIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .owner(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.owner()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResolveOutdatedDiffDiscussionsIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .resolveOutdatedDiffDiscussions(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.resolveOutdatedDiffDiscussions()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerExpirationPolicyIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .containerExpirationPolicy(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.containerExpirationPolicy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryObjectFormatIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .repositoryObjectFormat(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.repositoryObjectFormat()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEnabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .issuesEnabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.issuesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEnabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .mergeRequestsEnabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.mergeRequestsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiEnabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .wikiEnabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.wikiEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobsEnabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .jobsEnabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.jobsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetsEnabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .snippetsEnabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.snippetsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRegistryEnabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .containerRegistryEnabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.containerRegistryEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServiceDeskEnabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .serviceDeskEnabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.serviceDeskEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServiceDeskAddressIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .serviceDeskAddress(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.serviceDeskAddress()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCanCreateMergeRequestInIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .canCreateMergeRequestIn(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.canCreateMergeRequestIn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesAccessLevelIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .issuesAccessLevel(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.issuesAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryAccessLevelIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .repositoryAccessLevel(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.repositoryAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsAccessLevelIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .mergeRequestsAccessLevel(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.mergeRequestsAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenForkingAccessLevelIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .forkingAccessLevel(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.forkingAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiAccessLevelIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .wikiAccessLevel(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.wikiAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBuildsAccessLevelIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .buildsAccessLevel(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.buildsAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetsAccessLevelIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .snippetsAccessLevel(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.snippetsAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesAccessLevelIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .pagesAccessLevel(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.pagesAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAnalyticsAccessLevelIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .analyticsAccessLevel(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.analyticsAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRegistryAccessLevelIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .containerRegistryAccessLevel(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.containerRegistryAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecurityAndComplianceAccessLevelIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .securityAndComplianceAccessLevel(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.securityAndComplianceAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReleasesAccessLevelIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .releasesAccessLevel(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.releasesAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentsAccessLevelIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .environmentsAccessLevel(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.environmentsAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFeatureFlagsAccessLevelIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .featureFlagsAccessLevel(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.featureFlagsAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInfrastructureAccessLevelIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .infrastructureAccessLevel(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.infrastructureAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMonitorAccessLevelIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .monitorAccessLevel(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.monitorAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenModelExperimentsAccessLevelIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .modelExperimentsAccessLevel(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.modelExperimentsAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenModelRegistryAccessLevelIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .modelRegistryAccessLevel(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.modelRegistryAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageRegistryAccessLevelIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .packageRegistryAccessLevel(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.packageRegistryAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailsDisabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .emailsDisabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.emailsDisabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailsEnabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .emailsEnabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.emailsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShowDiffPreviewInEmailIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .showDiffPreviewInEmail(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.showDiffPreviewInEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSharedRunnersEnabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .sharedRunnersEnabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.sharedRunnersEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLfsEnabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .lfsEnabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.lfsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatorIdIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .creatorId(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.creatorId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMrDefaultTargetSelfIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .mrDefaultTargetSelf(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.mrDefaultTargetSelf()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportUrlIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .importUrl(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.importUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportTypeIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .importType(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.importType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportStatusIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .importStatus(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.importStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportErrorIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .importError(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.importError()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOpenIssuesCountIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .openIssuesCount(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.openIssuesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionHtmlIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .descriptionHtml(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.descriptionHtml()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .updatedAt(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiDefaultGitDepthIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .ciDefaultGitDepth(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.ciDefaultGitDepth()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiDeletePipelinesInSecondsIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .ciDeletePipelinesInSeconds(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.ciDeletePipelinesInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiForwardDeploymentEnabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .ciForwardDeploymentEnabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.ciForwardDeploymentEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiForwardDeploymentRollbackAllowedIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .ciForwardDeploymentRollbackAllowed(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.ciForwardDeploymentRollbackAllowed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiJobTokenScopeEnabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .ciJobTokenScopeEnabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.ciJobTokenScopeEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiSeparatedCachesIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .ciSeparatedCaches(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.ciSeparatedCaches()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiAllowForkPipelinesToRunInParentProjectIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .ciAllowForkPipelinesToRunInParentProject(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.ciAllowForkPipelinesToRunInParentProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiIdTokenSubClaimComponentsIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .ciIdTokenSubClaimComponents(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.ciIdTokenSubClaimComponents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBuildGitStrategyIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .buildGitStrategy(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.buildGitStrategy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKeepLatestArtifactIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .keepLatestArtifact(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.keepLatestArtifact()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRestrictUserDefinedVariablesIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .restrictUserDefinedVariables(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.restrictUserDefinedVariables()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiPipelineVariablesMinimumOverrideRoleIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .ciPipelineVariablesMinimumOverrideRole(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.ciPipelineVariablesMinimumOverrideRole()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunnerTokenExpirationIntervalIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .runnerTokenExpirationInterval(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.runnerTokenExpirationInterval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupRunnersEnabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .groupRunnersEnabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.groupRunnersEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResourceGroupDefaultProcessModeIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .resourceGroupDefaultProcessMode(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.resourceGroupDefaultProcessMode()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoCancelPendingPipelinesIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .autoCancelPendingPipelines(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.autoCancelPendingPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBuildTimeoutIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .buildTimeout(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.buildTimeout()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoDevopsEnabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .autoDevopsEnabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.autoDevopsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoDevopsDeployStrategyIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .autoDevopsDeployStrategy(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.autoDevopsDeployStrategy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiPushRepositoryForJobTokenAllowedIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .ciPushRepositoryForJobTokenAllowed(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.ciPushRepositoryForJobTokenAllowed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProtectMergeRequestPipelinesIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .protectMergeRequestPipelines(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.protectMergeRequestPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiDisplayPipelineVariablesIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .ciDisplayPipelineVariables(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.ciDisplayPipelineVariables()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiSkipBranchPipelinesForMrsIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .ciSkipBranchPipelinesForMrs(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.ciSkipBranchPipelinesForMrs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunnersTokenIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .runnersToken(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.runnersToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiConfigPathIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .ciConfigPath(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.ciConfigPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPublicJobsIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .publicJobs(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.publicJobs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSharedWithGroupsIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .sharedWithGroups(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.sharedWithGroups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOnlyAllowMergeIfPipelineSucceedsIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .onlyAllowMergeIfPipelineSucceeds(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.onlyAllowMergeIfPipelineSucceeds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowMergeOnSkippedPipelineIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .allowMergeOnSkippedPipeline(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.allowMergeOnSkippedPipeline()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequestAccessEnabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .requestAccessEnabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.requestAccessEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOnlyAllowMergeIfAllDiscussionsAreResolvedIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .onlyAllowMergeIfAllDiscussionsAreResolved(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.onlyAllowMergeIfAllDiscussionsAreResolved()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRemoveSourceBranchAfterMergeIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .removeSourceBranchAfterMerge(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.removeSourceBranchAfterMerge()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPrintingMergeRequestLinkEnabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .printingMergeRequestLinkEnabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.printingMergeRequestLinkEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeMethodIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .mergeMethod(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.mergeMethod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSquashOptionIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .squashOption(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.squashOption()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutomaticRebaseEnabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .automaticRebaseEnabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.automaticRebaseEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnforceAuthChecksOnUploadsIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .enforceAuthChecksOnUploads(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.enforceAuthChecksOnUploads()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSuggestionCommitMessageIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .suggestionCommitMessage(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.suggestionCommitMessage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeCommitTemplateIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .mergeCommitTemplate(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.mergeCommitTemplate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSquashCommitTemplateIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .squashCommitTemplate(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.squashCommitTemplate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMrDefaultTitleTemplateIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .mrDefaultTitleTemplate(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.mrDefaultTitleTemplate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssueBranchTemplateIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .issueBranchTemplate(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.issueBranchTemplate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatisticsIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .statistics(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.statistics()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWarnAboutPotentiallyUnwantedCharactersIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .warnAboutPotentiallyUnwantedCharacters(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.warnAboutPotentiallyUnwantedCharacters()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutocloseReferencedIssuesIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .autocloseReferencedIssues(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.autocloseReferencedIssues()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxArtifactsSizeIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .maxArtifactsSize(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.maxArtifactsSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalsBeforeMergeIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .approvalsBeforeMerge(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.approvalsBeforeMerge()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMirrorIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .mirror(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.mirror()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMirrorUserIdIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .mirrorUserId(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.mirrorUserId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMirrorTriggerBuildsIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .mirrorTriggerBuilds(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.mirrorTriggerBuilds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOnlyMirrorProtectedBranchesIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .onlyMirrorProtectedBranches(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.onlyMirrorProtectedBranches()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMirrorOverwritesDivergedBranchesIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .mirrorOverwritesDivergedBranches(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.mirrorOverwritesDivergedBranches()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalAuthorizationClassificationLabelIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .externalAuthorizationClassificationLabel(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.externalAuthorizationClassificationLabel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequirementsEnabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .requirementsEnabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.requirementsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequirementsAccessLevelIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .requirementsAccessLevel(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.requirementsAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecurityAndComplianceEnabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .securityAndComplianceEnabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.securityAndComplianceEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecretPushProtectionEnabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .secretPushProtectionEnabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.secretPushProtectionEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPreReceiveSecretDetectionEnabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .preReceiveSecretDetectionEnabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.preReceiveSecretDetectionEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenComplianceFrameworksIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .complianceFrameworks(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.complianceFrameworks()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesTemplateIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .issuesTemplate(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.issuesTemplate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsTemplateIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .mergeRequestsTemplate(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.mergeRequestsTemplate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiRestrictPipelineCancellationRoleIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .ciRestrictPipelineCancellationRole(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.ciRestrictPipelineCancellationRole()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergePipelinesEnabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .mergePipelinesEnabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.mergePipelinesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeTrainsEnabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .mergeTrainsEnabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.mergeTrainsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeTrainsSkipTrainAllowedIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .mergeTrainsSkipTrainAllowed(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.mergeTrainsSkipTrainAllowed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeTrainEnforcementIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .mergeTrainEnforcement(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.mergeTrainEnforcement()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxPipelinesPerMergeTrainIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .maxPipelinesPerMergeTrain(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.maxPipelinesPerMergeTrain()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOnlyAllowMergeIfAllStatusChecksPassedIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .onlyAllowMergeIfAllStatusChecksPassed(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.onlyAllowMergeIfAllStatusChecksPassed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowPipelineTriggerApproveDeploymentIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .allowPipelineTriggerApproveDeployment(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.allowPipelineTriggerApproveDeployment()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPreventMergeWithoutJiraIssueIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .preventMergeWithoutJiraIssue(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.preventMergeWithoutJiraIssue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoDuoCodeReviewEnabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .autoDuoCodeReviewEnabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.autoDuoCodeReviewEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCodeReviewDecisionsEnabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .duoCodeReviewDecisionsEnabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.duoCodeReviewDecisionsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCodeReviewDepthAllowedIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .duoCodeReviewDepthAllowed(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.duoCodeReviewDepthAllowed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCodeReviewDefaultDepthIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .duoCodeReviewDefaultDepth(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.duoCodeReviewDefaultDepth()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReviewerAssignmentStrategyIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .reviewerAssignmentStrategy(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.reviewerAssignmentStrategy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoRemoteFlowsEnabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .duoRemoteFlowsEnabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.duoRemoteFlowsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoFoundationalFlowsEnabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .duoFoundationalFlowsEnabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.duoFoundationalFlowsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoScheduledAutomationsEnabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .duoScheduledAutomationsEnabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.duoScheduledAutomationsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoSastFpDetectionEnabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .duoSastFpDetectionEnabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.duoSastFpDetectionEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoSecretDetectionFpEnabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .duoSecretDetectionFpEnabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.duoSecretDetectionFpEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoDependencyBumpBreakingChangesEnabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .duoDependencyBumpBreakingChangesEnabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.duoDependencyBumpBreakingChangesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoSastVrWorkflowEnabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .duoSastVrWorkflowEnabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.duoSastVrWorkflowEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebBasedCommitSigningEnabledIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .webBasedCommitSigningEnabled(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.webBasedCommitSigningEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSppRepositoryPipelineAccessIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .sppRepositoryPipelineAccess(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.sppRepositoryPipelineAccess()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecurityPolicyPipelineMustSucceedIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .securityPolicyPipelineMustSucceed(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.securityPolicyPipelineMustSucceed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestTitleRegexIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .mergeRequestTitleRegex(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.mergeRequestTitleRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestTitleRegexDescriptionIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .mergeRequestTitleRegexDescription(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.mergeRequestTitleRegexDescription()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPermissionsIsNullable() {
        final GitLabProjectWithAccessBuilder builder = GitLabProjectWithAccessBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccess())
                .permissions(null);

        final GitLabProjectWithAccess built = builder.build();

        assertThat(built.permissions()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectWithAccess value = ProjectsCatalogFixtures.projectWithAccess();

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
            softly.assertThat(value.links()).isEqualTo(ProjectsCatalogFixtures.projectWithAccessLinks());
            softly.assertThat(value.markedForDeletionAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.markedForDeletionOn()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
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
            softly.assertThat(value.approvalsBeforeMerge()).isEqualTo("approvals_before_merge");
            softly.assertThat(value.mirror()).isEqualTo("mirror");
            softly.assertThat(value.mirrorUserId()).isEqualTo("mirror_user_id");
            softly.assertThat(value.mirrorTriggerBuilds()).isEqualTo("mirror_trigger_builds");
            softly.assertThat(value.onlyMirrorProtectedBranches()).isEqualTo("only_mirror_protected_branches");
            softly.assertThat(value.mirrorOverwritesDivergedBranches())
                    .isEqualTo("mirror_overwrites_diverged_branches");
            softly.assertThat(value.externalAuthorizationClassificationLabel())
                    .isEqualTo("external_authorization_classification_label");
            softly.assertThat(value.requirementsEnabled()).isEqualTo("requirements_enabled");
            softly.assertThat(value.requirementsAccessLevel()).isEqualTo("requirements_access_level");
            softly.assertThat(value.securityAndComplianceEnabled()).isEqualTo("security_and_compliance_enabled");
            softly.assertThat(value.secretPushProtectionEnabled()).isEqualTo(true);
            softly.assertThat(value.preReceiveSecretDetectionEnabled()).isEqualTo(true);
            softly.assertThat(value.complianceFrameworks()).isEqualTo("compliance_frameworks");
            softly.assertThat(value.issuesTemplate()).isEqualTo("issues_template");
            softly.assertThat(value.mergeRequestsTemplate()).isEqualTo("merge_requests_template");
            softly.assertThat(value.ciRestrictPipelineCancellationRole())
                    .isEqualTo("ci_restrict_pipeline_cancellation_role");
            softly.assertThat(value.mergePipelinesEnabled()).isEqualTo("merge_pipelines_enabled");
            softly.assertThat(value.mergeTrainsEnabled()).isEqualTo("merge_trains_enabled");
            softly.assertThat(value.mergeTrainsSkipTrainAllowed()).isEqualTo("merge_trains_skip_train_allowed");
            softly.assertThat(value.mergeTrainEnforcement()).isEqualTo("merge_train_enforcement");
            softly.assertThat(value.maxPipelinesPerMergeTrain()).isEqualTo("max_pipelines_per_merge_train");
            softly.assertThat(value.onlyAllowMergeIfAllStatusChecksPassed())
                    .isEqualTo("only_allow_merge_if_all_status_checks_passed");
            softly.assertThat(value.allowPipelineTriggerApproveDeployment()).isEqualTo(true);
            softly.assertThat(value.preventMergeWithoutJiraIssue()).isEqualTo("prevent_merge_without_jira_issue");
            softly.assertThat(value.autoDuoCodeReviewEnabled()).isEqualTo("auto_duo_code_review_enabled");
            softly.assertThat(value.duoCodeReviewDecisionsEnabled()).isEqualTo("duo_code_review_decisions_enabled");
            softly.assertThat(value.duoCodeReviewDepthAllowed()).isEqualTo(true);
            softly.assertThat(value.duoCodeReviewDefaultDepth()).isEqualTo("standard");
            softly.assertThat(value.reviewerAssignmentStrategy()).isEqualTo("code_owners");
            softly.assertThat(value.duoRemoteFlowsEnabled()).isEqualTo("duo_remote_flows_enabled");
            softly.assertThat(value.duoFoundationalFlowsEnabled()).isEqualTo("duo_foundational_flows_enabled");
            softly.assertThat(value.duoScheduledAutomationsEnabled()).isEqualTo("duo_scheduled_automations_enabled");
            softly.assertThat(value.duoSastFpDetectionEnabled()).isEqualTo("duo_sast_fp_detection_enabled");
            softly.assertThat(value.duoSecretDetectionFpEnabled()).isEqualTo("duo_secret_detection_fp_enabled");
            softly.assertThat(value.duoDependencyBumpBreakingChangesEnabled())
                    .isEqualTo("duo_dependency_bump_breaking_changes_enabled");
            softly.assertThat(value.duoSastVrWorkflowEnabled()).isEqualTo("duo_sast_vr_workflow_enabled");
            softly.assertThat(value.webBasedCommitSigningEnabled()).isEqualTo("web_based_commit_signing_enabled");
            softly.assertThat(value.sppRepositoryPipelineAccess()).isEqualTo(true);
            softly.assertThat(value.securityPolicyPipelineMustSucceed()).isEqualTo(true);
            softly.assertThat(value.mergeRequestTitleRegex()).isEqualTo("/Title of merge request/");
            softly.assertThat(value.mergeRequestTitleRegexDescription())
                    .isEqualTo("This requires the title to include a Jira label");
            softly.assertThat(value.permissions()).isEqualTo(ProjectsCatalogFixtures.projectWithAccessPermissions());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectWithAccess original = ProjectsCatalogFixtures.projectWithAccess();

        final GitLabProjectWithAccess rebuilt =
                GitLabProjectWithAccessBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenRunnersTokenIsACredential() {
        final GitLabProjectWithAccess value = ProjectsCatalogFixtures.projectWithAccess();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectWithAccess.class.getRecordComponents())
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
                        "mergeRequestTitleRegexDescription",
                        "permissions");
    }
}
