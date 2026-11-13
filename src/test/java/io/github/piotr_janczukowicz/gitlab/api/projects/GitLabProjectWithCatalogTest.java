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
class GitLabProjectWithCatalogTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .id(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .description(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .name(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameWithNamespaceIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .nameWithNamespace(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.nameWithNamespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .path(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathWithNamespaceIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .pathWithNamespace(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.pathWithNamespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .createdAt(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultBranchIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .defaultBranch(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.defaultBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagListIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .tagList(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.tagList()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTopicsIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .topics(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.topics()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSshUrlToRepoIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .sshUrlToRepo(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.sshUrlToRepo()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHttpUrlToRepoIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .httpUrlToRepo(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.httpUrlToRepo()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .webUrl(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadmeUrlIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .readmeUrl(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.readmeUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenForksCountIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .forksCount(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.forksCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLicenseUrlIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .licenseUrl(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.licenseUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLicenseIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .license(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.license()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvatarUrlIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .avatarUrl(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.avatarUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStarCountIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .starCount(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.starCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastActivityAtIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .lastActivityAt(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.lastActivityAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVisibilityIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .visibility(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.visibility()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespaceIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .namespace(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.namespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomAttributesIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .customAttributes(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.customAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryStorageIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .repositoryStorage(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.repositoryStorage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenForkedFromProjectIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .forkedFromProject(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.forkedFromProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRegistryImagePrefixIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .containerRegistryImagePrefix(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.containerRegistryImagePrefix()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinksIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .links(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.links()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMarkedForDeletionAtIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .markedForDeletionAt(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.markedForDeletionAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMarkedForDeletionOnIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .markedForDeletionOn(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.markedForDeletionOn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .packagesEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.packagesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmptyRepoIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .emptyRepo(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.emptyRepo()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchivedIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .archived(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.archived()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOwnerIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .owner(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.owner()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResolveOutdatedDiffDiscussionsIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .resolveOutdatedDiffDiscussions(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.resolveOutdatedDiffDiscussions()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerExpirationPolicyIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .containerExpirationPolicy(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.containerExpirationPolicy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryObjectFormatIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .repositoryObjectFormat(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.repositoryObjectFormat()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .issuesEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.issuesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .mergeRequestsEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.mergeRequestsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .wikiEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.wikiEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobsEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .jobsEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.jobsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetsEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .snippetsEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.snippetsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRegistryEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .containerRegistryEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.containerRegistryEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServiceDeskEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .serviceDeskEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.serviceDeskEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServiceDeskAddressIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .serviceDeskAddress(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.serviceDeskAddress()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCanCreateMergeRequestInIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .canCreateMergeRequestIn(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.canCreateMergeRequestIn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesAccessLevelIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .issuesAccessLevel(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.issuesAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryAccessLevelIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .repositoryAccessLevel(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.repositoryAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsAccessLevelIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .mergeRequestsAccessLevel(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.mergeRequestsAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenForkingAccessLevelIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .forkingAccessLevel(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.forkingAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiAccessLevelIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .wikiAccessLevel(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.wikiAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBuildsAccessLevelIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .buildsAccessLevel(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.buildsAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetsAccessLevelIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .snippetsAccessLevel(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.snippetsAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesAccessLevelIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .pagesAccessLevel(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.pagesAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAnalyticsAccessLevelIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .analyticsAccessLevel(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.analyticsAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRegistryAccessLevelIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .containerRegistryAccessLevel(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.containerRegistryAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecurityAndComplianceAccessLevelIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .securityAndComplianceAccessLevel(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.securityAndComplianceAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReleasesAccessLevelIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .releasesAccessLevel(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.releasesAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentsAccessLevelIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .environmentsAccessLevel(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.environmentsAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFeatureFlagsAccessLevelIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .featureFlagsAccessLevel(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.featureFlagsAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInfrastructureAccessLevelIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .infrastructureAccessLevel(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.infrastructureAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMonitorAccessLevelIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .monitorAccessLevel(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.monitorAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenModelExperimentsAccessLevelIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .modelExperimentsAccessLevel(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.modelExperimentsAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenModelRegistryAccessLevelIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .modelRegistryAccessLevel(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.modelRegistryAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageRegistryAccessLevelIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .packageRegistryAccessLevel(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.packageRegistryAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailsDisabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .emailsDisabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.emailsDisabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailsEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .emailsEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.emailsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShowDiffPreviewInEmailIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .showDiffPreviewInEmail(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.showDiffPreviewInEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSharedRunnersEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .sharedRunnersEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.sharedRunnersEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLfsEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .lfsEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.lfsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatorIdIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .creatorId(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.creatorId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMrDefaultTargetSelfIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .mrDefaultTargetSelf(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.mrDefaultTargetSelf()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportUrlIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .importUrl(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.importUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportTypeIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .importType(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.importType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportStatusIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .importStatus(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.importStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportErrorIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .importError(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.importError()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOpenIssuesCountIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .openIssuesCount(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.openIssuesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionHtmlIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .descriptionHtml(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.descriptionHtml()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .updatedAt(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiDefaultGitDepthIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .ciDefaultGitDepth(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.ciDefaultGitDepth()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiDeletePipelinesInSecondsIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .ciDeletePipelinesInSeconds(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.ciDeletePipelinesInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiForwardDeploymentEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .ciForwardDeploymentEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.ciForwardDeploymentEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiForwardDeploymentRollbackAllowedIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .ciForwardDeploymentRollbackAllowed(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.ciForwardDeploymentRollbackAllowed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiJobTokenScopeEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .ciJobTokenScopeEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.ciJobTokenScopeEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiSeparatedCachesIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .ciSeparatedCaches(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.ciSeparatedCaches()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiAllowForkPipelinesToRunInParentProjectIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .ciAllowForkPipelinesToRunInParentProject(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.ciAllowForkPipelinesToRunInParentProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiIdTokenSubClaimComponentsIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .ciIdTokenSubClaimComponents(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.ciIdTokenSubClaimComponents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBuildGitStrategyIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .buildGitStrategy(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.buildGitStrategy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKeepLatestArtifactIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .keepLatestArtifact(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.keepLatestArtifact()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRestrictUserDefinedVariablesIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .restrictUserDefinedVariables(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.restrictUserDefinedVariables()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiPipelineVariablesMinimumOverrideRoleIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .ciPipelineVariablesMinimumOverrideRole(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.ciPipelineVariablesMinimumOverrideRole()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunnerTokenExpirationIntervalIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .runnerTokenExpirationInterval(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.runnerTokenExpirationInterval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupRunnersEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .groupRunnersEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.groupRunnersEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResourceGroupDefaultProcessModeIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .resourceGroupDefaultProcessMode(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.resourceGroupDefaultProcessMode()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoCancelPendingPipelinesIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .autoCancelPendingPipelines(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.autoCancelPendingPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBuildTimeoutIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .buildTimeout(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.buildTimeout()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoDevopsEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .autoDevopsEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.autoDevopsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoDevopsDeployStrategyIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .autoDevopsDeployStrategy(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.autoDevopsDeployStrategy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiPushRepositoryForJobTokenAllowedIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .ciPushRepositoryForJobTokenAllowed(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.ciPushRepositoryForJobTokenAllowed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProtectMergeRequestPipelinesIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .protectMergeRequestPipelines(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.protectMergeRequestPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiDisplayPipelineVariablesIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .ciDisplayPipelineVariables(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.ciDisplayPipelineVariables()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiSkipBranchPipelinesForMrsIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .ciSkipBranchPipelinesForMrs(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.ciSkipBranchPipelinesForMrs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunnersTokenIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .runnersToken(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.runnersToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiConfigPathIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .ciConfigPath(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.ciConfigPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPublicJobsIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .publicJobs(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.publicJobs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSharedWithGroupsIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .sharedWithGroups(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.sharedWithGroups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOnlyAllowMergeIfPipelineSucceedsIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .onlyAllowMergeIfPipelineSucceeds(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.onlyAllowMergeIfPipelineSucceeds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowMergeOnSkippedPipelineIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .allowMergeOnSkippedPipeline(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.allowMergeOnSkippedPipeline()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequestAccessEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .requestAccessEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.requestAccessEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOnlyAllowMergeIfAllDiscussionsAreResolvedIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .onlyAllowMergeIfAllDiscussionsAreResolved(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.onlyAllowMergeIfAllDiscussionsAreResolved()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRemoveSourceBranchAfterMergeIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .removeSourceBranchAfterMerge(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.removeSourceBranchAfterMerge()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPrintingMergeRequestLinkEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .printingMergeRequestLinkEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.printingMergeRequestLinkEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeMethodIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .mergeMethod(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.mergeMethod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSquashOptionIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .squashOption(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.squashOption()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutomaticRebaseEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .automaticRebaseEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.automaticRebaseEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnforceAuthChecksOnUploadsIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .enforceAuthChecksOnUploads(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.enforceAuthChecksOnUploads()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSuggestionCommitMessageIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .suggestionCommitMessage(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.suggestionCommitMessage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeCommitTemplateIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .mergeCommitTemplate(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.mergeCommitTemplate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSquashCommitTemplateIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .squashCommitTemplate(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.squashCommitTemplate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMrDefaultTitleTemplateIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .mrDefaultTitleTemplate(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.mrDefaultTitleTemplate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssueBranchTemplateIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .issueBranchTemplate(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.issueBranchTemplate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatisticsIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .statistics(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.statistics()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWarnAboutPotentiallyUnwantedCharactersIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .warnAboutPotentiallyUnwantedCharacters(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.warnAboutPotentiallyUnwantedCharacters()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutocloseReferencedIssuesIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .autocloseReferencedIssues(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.autocloseReferencedIssues()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxArtifactsSizeIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .maxArtifactsSize(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.maxArtifactsSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalsBeforeMergeIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .approvalsBeforeMerge(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.approvalsBeforeMerge()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMirrorIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .mirror(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.mirror()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMirrorUserIdIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .mirrorUserId(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.mirrorUserId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMirrorTriggerBuildsIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .mirrorTriggerBuilds(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.mirrorTriggerBuilds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOnlyMirrorProtectedBranchesIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .onlyMirrorProtectedBranches(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.onlyMirrorProtectedBranches()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMirrorOverwritesDivergedBranchesIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .mirrorOverwritesDivergedBranches(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.mirrorOverwritesDivergedBranches()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalAuthorizationClassificationLabelIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .externalAuthorizationClassificationLabel(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.externalAuthorizationClassificationLabel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequirementsEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .requirementsEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.requirementsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequirementsAccessLevelIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .requirementsAccessLevel(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.requirementsAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecurityAndComplianceEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .securityAndComplianceEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.securityAndComplianceEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecretPushProtectionEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .secretPushProtectionEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.secretPushProtectionEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPreReceiveSecretDetectionEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .preReceiveSecretDetectionEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.preReceiveSecretDetectionEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenComplianceFrameworksIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .complianceFrameworks(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.complianceFrameworks()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesTemplateIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .issuesTemplate(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.issuesTemplate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsTemplateIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .mergeRequestsTemplate(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.mergeRequestsTemplate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiRestrictPipelineCancellationRoleIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .ciRestrictPipelineCancellationRole(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.ciRestrictPipelineCancellationRole()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergePipelinesEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .mergePipelinesEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.mergePipelinesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeTrainsEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .mergeTrainsEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.mergeTrainsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeTrainsSkipTrainAllowedIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .mergeTrainsSkipTrainAllowed(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.mergeTrainsSkipTrainAllowed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeTrainEnforcementIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .mergeTrainEnforcement(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.mergeTrainEnforcement()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxPipelinesPerMergeTrainIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .maxPipelinesPerMergeTrain(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.maxPipelinesPerMergeTrain()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOnlyAllowMergeIfAllStatusChecksPassedIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .onlyAllowMergeIfAllStatusChecksPassed(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.onlyAllowMergeIfAllStatusChecksPassed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowPipelineTriggerApproveDeploymentIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .allowPipelineTriggerApproveDeployment(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.allowPipelineTriggerApproveDeployment()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPreventMergeWithoutJiraIssueIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .preventMergeWithoutJiraIssue(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.preventMergeWithoutJiraIssue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoDuoCodeReviewEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .autoDuoCodeReviewEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.autoDuoCodeReviewEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCodeReviewDecisionsEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .duoCodeReviewDecisionsEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.duoCodeReviewDecisionsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCodeReviewDepthAllowedIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .duoCodeReviewDepthAllowed(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.duoCodeReviewDepthAllowed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCodeReviewDefaultDepthIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .duoCodeReviewDefaultDepth(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.duoCodeReviewDefaultDepth()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReviewerAssignmentStrategyIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .reviewerAssignmentStrategy(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.reviewerAssignmentStrategy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoRemoteFlowsEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .duoRemoteFlowsEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.duoRemoteFlowsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoFoundationalFlowsEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .duoFoundationalFlowsEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.duoFoundationalFlowsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoScheduledAutomationsEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .duoScheduledAutomationsEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.duoScheduledAutomationsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoSastFpDetectionEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .duoSastFpDetectionEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.duoSastFpDetectionEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoSecretDetectionFpEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .duoSecretDetectionFpEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.duoSecretDetectionFpEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoDependencyBumpBreakingChangesEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .duoDependencyBumpBreakingChangesEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.duoDependencyBumpBreakingChangesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoSastVrWorkflowEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .duoSastVrWorkflowEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.duoSastVrWorkflowEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebBasedCommitSigningEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .webBasedCommitSigningEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.webBasedCommitSigningEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSppRepositoryPipelineAccessIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .sppRepositoryPipelineAccess(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.sppRepositoryPipelineAccess()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecurityPolicyPipelineMustSucceedIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .securityPolicyPipelineMustSucceed(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.securityPolicyPipelineMustSucceed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestTitleRegexIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .mergeRequestTitleRegex(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.mergeRequestTitleRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestTitleRegexDescriptionIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .mergeRequestTitleRegexDescription(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.mergeRequestTitleRegexDescription()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCicdCatalogEnabledIsNullable() {
        final GitLabProjectWithCatalogBuilder builder = GitLabProjectWithCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalog())
                .cicdCatalogEnabled(null);

        final GitLabProjectWithCatalog built = builder.build();

        assertThat(built.cicdCatalogEnabled()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectWithCatalog value = ProjectsCatalogFixtures.projectWithCatalog();

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
            softly.assertThat(value.links()).isEqualTo(ProjectsCatalogFixtures.projectWithCatalogLinks());
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
            softly.assertThat(value.webBasedCommitSigningEnabled()).isEqualTo(true);
            softly.assertThat(value.sppRepositoryPipelineAccess()).isEqualTo(true);
            softly.assertThat(value.securityPolicyPipelineMustSucceed()).isEqualTo(true);
            softly.assertThat(value.mergeRequestTitleRegex()).isEqualTo("/Title of merge request/");
            softly.assertThat(value.mergeRequestTitleRegexDescription())
                    .isEqualTo("This requires the title to include a Jira label");
            softly.assertThat(value.cicdCatalogEnabled()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectWithCatalog original = ProjectsCatalogFixtures.projectWithCatalog();

        final GitLabProjectWithCatalog rebuilt =
                GitLabProjectWithCatalogBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenRunnersTokenIsACredential() {
        final GitLabProjectWithCatalog value = ProjectsCatalogFixtures.projectWithCatalog();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectWithCatalog.class.getRecordComponents())
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
                        "cicdCatalogEnabled");
    }
}
