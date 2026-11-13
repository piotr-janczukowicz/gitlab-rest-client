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
class GitLabProjectWithAccessAndCatalogTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .id(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .description(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .name(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameWithNamespaceIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .nameWithNamespace(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.nameWithNamespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .path(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathWithNamespaceIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .pathWithNamespace(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.pathWithNamespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .createdAt(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultBranchIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .defaultBranch(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.defaultBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagListIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .tagList(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.tagList()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTopicsIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .topics(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.topics()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSshUrlToRepoIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .sshUrlToRepo(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.sshUrlToRepo()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHttpUrlToRepoIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .httpUrlToRepo(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.httpUrlToRepo()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .webUrl(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReadmeUrlIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .readmeUrl(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.readmeUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenForksCountIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .forksCount(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.forksCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLicenseUrlIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .licenseUrl(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.licenseUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLicenseIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .license(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.license()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvatarUrlIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .avatarUrl(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.avatarUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStarCountIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .starCount(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.starCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastActivityAtIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .lastActivityAt(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.lastActivityAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVisibilityIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .visibility(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.visibility()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespaceIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .namespace(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.namespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomAttributesIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .customAttributes(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.customAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryStorageIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .repositoryStorage(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.repositoryStorage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenForkedFromProjectIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .forkedFromProject(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.forkedFromProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRegistryImagePrefixIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .containerRegistryImagePrefix(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.containerRegistryImagePrefix()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinksIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .links(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.links()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMarkedForDeletionAtIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .markedForDeletionAt(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.markedForDeletionAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMarkedForDeletionOnIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .markedForDeletionOn(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.markedForDeletionOn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackagesEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .packagesEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.packagesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmptyRepoIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .emptyRepo(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.emptyRepo()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchivedIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .archived(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.archived()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOwnerIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .owner(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.owner()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResolveOutdatedDiffDiscussionsIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .resolveOutdatedDiffDiscussions(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.resolveOutdatedDiffDiscussions()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerExpirationPolicyIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .containerExpirationPolicy(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.containerExpirationPolicy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryObjectFormatIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .repositoryObjectFormat(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.repositoryObjectFormat()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .issuesEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.issuesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .mergeRequestsEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.mergeRequestsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .wikiEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.wikiEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobsEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .jobsEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.jobsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetsEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .snippetsEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.snippetsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRegistryEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .containerRegistryEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.containerRegistryEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServiceDeskEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .serviceDeskEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.serviceDeskEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServiceDeskAddressIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .serviceDeskAddress(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.serviceDeskAddress()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCanCreateMergeRequestInIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .canCreateMergeRequestIn(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.canCreateMergeRequestIn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesAccessLevelIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .issuesAccessLevel(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.issuesAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryAccessLevelIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .repositoryAccessLevel(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.repositoryAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsAccessLevelIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .mergeRequestsAccessLevel(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.mergeRequestsAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenForkingAccessLevelIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .forkingAccessLevel(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.forkingAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiAccessLevelIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .wikiAccessLevel(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.wikiAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBuildsAccessLevelIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .buildsAccessLevel(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.buildsAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetsAccessLevelIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .snippetsAccessLevel(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.snippetsAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPagesAccessLevelIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .pagesAccessLevel(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.pagesAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAnalyticsAccessLevelIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .analyticsAccessLevel(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.analyticsAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRegistryAccessLevelIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .containerRegistryAccessLevel(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.containerRegistryAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecurityAndComplianceAccessLevelIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .securityAndComplianceAccessLevel(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.securityAndComplianceAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReleasesAccessLevelIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .releasesAccessLevel(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.releasesAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentsAccessLevelIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .environmentsAccessLevel(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.environmentsAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFeatureFlagsAccessLevelIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .featureFlagsAccessLevel(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.featureFlagsAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInfrastructureAccessLevelIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .infrastructureAccessLevel(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.infrastructureAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMonitorAccessLevelIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .monitorAccessLevel(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.monitorAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenModelExperimentsAccessLevelIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .modelExperimentsAccessLevel(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.modelExperimentsAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenModelRegistryAccessLevelIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .modelRegistryAccessLevel(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.modelRegistryAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageRegistryAccessLevelIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .packageRegistryAccessLevel(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.packageRegistryAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailsDisabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .emailsDisabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.emailsDisabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailsEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .emailsEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.emailsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShowDiffPreviewInEmailIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .showDiffPreviewInEmail(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.showDiffPreviewInEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSharedRunnersEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .sharedRunnersEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.sharedRunnersEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLfsEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .lfsEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.lfsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatorIdIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .creatorId(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.creatorId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMrDefaultTargetSelfIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .mrDefaultTargetSelf(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.mrDefaultTargetSelf()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportUrlIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .importUrl(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.importUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportTypeIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .importType(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.importType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportStatusIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .importStatus(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.importStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportErrorIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .importError(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.importError()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOpenIssuesCountIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .openIssuesCount(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.openIssuesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionHtmlIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .descriptionHtml(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.descriptionHtml()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .updatedAt(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiDefaultGitDepthIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .ciDefaultGitDepth(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.ciDefaultGitDepth()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiDeletePipelinesInSecondsIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .ciDeletePipelinesInSeconds(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.ciDeletePipelinesInSeconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiForwardDeploymentEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .ciForwardDeploymentEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.ciForwardDeploymentEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiForwardDeploymentRollbackAllowedIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .ciForwardDeploymentRollbackAllowed(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.ciForwardDeploymentRollbackAllowed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiJobTokenScopeEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .ciJobTokenScopeEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.ciJobTokenScopeEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiSeparatedCachesIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .ciSeparatedCaches(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.ciSeparatedCaches()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiAllowForkPipelinesToRunInParentProjectIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .ciAllowForkPipelinesToRunInParentProject(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.ciAllowForkPipelinesToRunInParentProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiIdTokenSubClaimComponentsIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .ciIdTokenSubClaimComponents(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.ciIdTokenSubClaimComponents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBuildGitStrategyIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .buildGitStrategy(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.buildGitStrategy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKeepLatestArtifactIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .keepLatestArtifact(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.keepLatestArtifact()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRestrictUserDefinedVariablesIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .restrictUserDefinedVariables(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.restrictUserDefinedVariables()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiPipelineVariablesMinimumOverrideRoleIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .ciPipelineVariablesMinimumOverrideRole(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.ciPipelineVariablesMinimumOverrideRole()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunnerTokenExpirationIntervalIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .runnerTokenExpirationInterval(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.runnerTokenExpirationInterval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupRunnersEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .groupRunnersEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.groupRunnersEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResourceGroupDefaultProcessModeIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .resourceGroupDefaultProcessMode(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.resourceGroupDefaultProcessMode()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoCancelPendingPipelinesIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .autoCancelPendingPipelines(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.autoCancelPendingPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBuildTimeoutIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .buildTimeout(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.buildTimeout()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoDevopsEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .autoDevopsEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.autoDevopsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoDevopsDeployStrategyIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .autoDevopsDeployStrategy(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.autoDevopsDeployStrategy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiPushRepositoryForJobTokenAllowedIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .ciPushRepositoryForJobTokenAllowed(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.ciPushRepositoryForJobTokenAllowed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProtectMergeRequestPipelinesIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .protectMergeRequestPipelines(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.protectMergeRequestPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiDisplayPipelineVariablesIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .ciDisplayPipelineVariables(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.ciDisplayPipelineVariables()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiSkipBranchPipelinesForMrsIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .ciSkipBranchPipelinesForMrs(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.ciSkipBranchPipelinesForMrs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunnersTokenIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .runnersToken(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.runnersToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiConfigPathIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .ciConfigPath(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.ciConfigPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPublicJobsIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .publicJobs(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.publicJobs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSharedWithGroupsIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .sharedWithGroups(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.sharedWithGroups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOnlyAllowMergeIfPipelineSucceedsIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .onlyAllowMergeIfPipelineSucceeds(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.onlyAllowMergeIfPipelineSucceeds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowMergeOnSkippedPipelineIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .allowMergeOnSkippedPipeline(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.allowMergeOnSkippedPipeline()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequestAccessEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .requestAccessEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.requestAccessEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOnlyAllowMergeIfAllDiscussionsAreResolvedIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .onlyAllowMergeIfAllDiscussionsAreResolved(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.onlyAllowMergeIfAllDiscussionsAreResolved()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRemoveSourceBranchAfterMergeIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .removeSourceBranchAfterMerge(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.removeSourceBranchAfterMerge()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPrintingMergeRequestLinkEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .printingMergeRequestLinkEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.printingMergeRequestLinkEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeMethodIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .mergeMethod(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.mergeMethod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSquashOptionIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .squashOption(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.squashOption()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutomaticRebaseEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .automaticRebaseEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.automaticRebaseEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnforceAuthChecksOnUploadsIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .enforceAuthChecksOnUploads(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.enforceAuthChecksOnUploads()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSuggestionCommitMessageIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .suggestionCommitMessage(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.suggestionCommitMessage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeCommitTemplateIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .mergeCommitTemplate(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.mergeCommitTemplate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSquashCommitTemplateIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .squashCommitTemplate(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.squashCommitTemplate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMrDefaultTitleTemplateIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .mrDefaultTitleTemplate(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.mrDefaultTitleTemplate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssueBranchTemplateIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .issueBranchTemplate(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.issueBranchTemplate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatisticsIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .statistics(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.statistics()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWarnAboutPotentiallyUnwantedCharactersIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .warnAboutPotentiallyUnwantedCharacters(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.warnAboutPotentiallyUnwantedCharacters()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutocloseReferencedIssuesIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .autocloseReferencedIssues(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.autocloseReferencedIssues()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxArtifactsSizeIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .maxArtifactsSize(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.maxArtifactsSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalsBeforeMergeIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .approvalsBeforeMerge(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.approvalsBeforeMerge()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMirrorIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .mirror(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.mirror()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMirrorUserIdIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .mirrorUserId(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.mirrorUserId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMirrorTriggerBuildsIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .mirrorTriggerBuilds(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.mirrorTriggerBuilds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOnlyMirrorProtectedBranchesIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .onlyMirrorProtectedBranches(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.onlyMirrorProtectedBranches()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMirrorOverwritesDivergedBranchesIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .mirrorOverwritesDivergedBranches(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.mirrorOverwritesDivergedBranches()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalAuthorizationClassificationLabelIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .externalAuthorizationClassificationLabel(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.externalAuthorizationClassificationLabel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequirementsEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .requirementsEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.requirementsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequirementsAccessLevelIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .requirementsAccessLevel(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.requirementsAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecurityAndComplianceEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .securityAndComplianceEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.securityAndComplianceEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecretPushProtectionEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .secretPushProtectionEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.secretPushProtectionEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPreReceiveSecretDetectionEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .preReceiveSecretDetectionEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.preReceiveSecretDetectionEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenComplianceFrameworksIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .complianceFrameworks(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.complianceFrameworks()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesTemplateIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .issuesTemplate(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.issuesTemplate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsTemplateIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .mergeRequestsTemplate(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.mergeRequestsTemplate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCiRestrictPipelineCancellationRoleIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .ciRestrictPipelineCancellationRole(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.ciRestrictPipelineCancellationRole()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergePipelinesEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .mergePipelinesEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.mergePipelinesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeTrainsEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .mergeTrainsEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.mergeTrainsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeTrainsSkipTrainAllowedIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .mergeTrainsSkipTrainAllowed(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.mergeTrainsSkipTrainAllowed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeTrainEnforcementIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .mergeTrainEnforcement(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.mergeTrainEnforcement()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxPipelinesPerMergeTrainIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .maxPipelinesPerMergeTrain(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.maxPipelinesPerMergeTrain()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOnlyAllowMergeIfAllStatusChecksPassedIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .onlyAllowMergeIfAllStatusChecksPassed(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.onlyAllowMergeIfAllStatusChecksPassed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowPipelineTriggerApproveDeploymentIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .allowPipelineTriggerApproveDeployment(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.allowPipelineTriggerApproveDeployment()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPreventMergeWithoutJiraIssueIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .preventMergeWithoutJiraIssue(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.preventMergeWithoutJiraIssue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoDuoCodeReviewEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .autoDuoCodeReviewEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.autoDuoCodeReviewEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCodeReviewDecisionsEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .duoCodeReviewDecisionsEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.duoCodeReviewDecisionsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCodeReviewDepthAllowedIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .duoCodeReviewDepthAllowed(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.duoCodeReviewDepthAllowed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCodeReviewDefaultDepthIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .duoCodeReviewDefaultDepth(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.duoCodeReviewDefaultDepth()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReviewerAssignmentStrategyIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .reviewerAssignmentStrategy(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.reviewerAssignmentStrategy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoRemoteFlowsEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .duoRemoteFlowsEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.duoRemoteFlowsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoFoundationalFlowsEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .duoFoundationalFlowsEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.duoFoundationalFlowsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoScheduledAutomationsEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .duoScheduledAutomationsEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.duoScheduledAutomationsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoSastFpDetectionEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .duoSastFpDetectionEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.duoSastFpDetectionEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoSecretDetectionFpEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .duoSecretDetectionFpEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.duoSecretDetectionFpEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoDependencyBumpBreakingChangesEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .duoDependencyBumpBreakingChangesEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.duoDependencyBumpBreakingChangesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoSastVrWorkflowEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .duoSastVrWorkflowEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.duoSastVrWorkflowEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebBasedCommitSigningEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .webBasedCommitSigningEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.webBasedCommitSigningEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSppRepositoryPipelineAccessIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .sppRepositoryPipelineAccess(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.sppRepositoryPipelineAccess()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecurityPolicyPipelineMustSucceedIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .securityPolicyPipelineMustSucceed(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.securityPolicyPipelineMustSucceed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestTitleRegexIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .mergeRequestTitleRegex(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.mergeRequestTitleRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestTitleRegexDescriptionIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .mergeRequestTitleRegexDescription(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.mergeRequestTitleRegexDescription()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPermissionsIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .permissions(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.permissions()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCicdCatalogEnabledIsNullable() {
        final GitLabProjectWithAccessAndCatalogBuilder builder = GitLabProjectWithAccessAndCatalogBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessAndCatalog())
                .cicdCatalogEnabled(null);

        final GitLabProjectWithAccessAndCatalog built = builder.build();

        assertThat(built.cicdCatalogEnabled()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectWithAccessAndCatalog value = ProjectsCatalogFixtures.projectWithAccessAndCatalog();

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
            softly.assertThat(value.links()).isEqualTo(ProjectsCatalogFixtures.projectWithAccessAndCatalogLinks());
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
            softly.assertThat(value.approvalsBeforeMerge()).isEqualTo(1);
            softly.assertThat(value.mirror()).isEqualTo(true);
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
            softly.assertThat(value.permissions())
                    .isEqualTo(ProjectsCatalogFixtures.projectWithAccessAndCatalogPermissions());
            softly.assertThat(value.cicdCatalogEnabled()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectWithAccessAndCatalog original = ProjectsCatalogFixtures.projectWithAccessAndCatalog();

        final GitLabProjectWithAccessAndCatalog rebuilt =
                GitLabProjectWithAccessAndCatalogBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenRunnersTokenIsACredential() {
        final GitLabProjectWithAccessAndCatalog value = ProjectsCatalogFixtures.projectWithAccessAndCatalog();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectWithAccessAndCatalog.class.getRecordComponents())
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
                        "permissions",
                        "cicdCatalogEnabled");
    }
}
