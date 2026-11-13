package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabApplicationSettingProjectTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectExportEnabledIsNullable() {
        final GitLabApplicationSettingProjectBuilder builder = GitLabApplicationSettingProjectBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingProject())
                .projectExportEnabled(null);

        final GitLabApplicationSettingProject built = builder.build();

        assertThat(built.projectExportEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectCreateLimitIsNullable() {
        final GitLabApplicationSettingProjectBuilder builder = GitLabApplicationSettingProjectBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingProject())
                .projectCreateLimit(null);

        final GitLabApplicationSettingProject built = builder.build();

        assertThat(built.projectCreateLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectImportLimitIsNullable() {
        final GitLabApplicationSettingProjectBuilder builder = GitLabApplicationSettingProjectBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingProject())
                .projectImportLimit(null);

        final GitLabApplicationSettingProject built = builder.build();

        assertThat(built.projectImportLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectExportLimitIsNullable() {
        final GitLabApplicationSettingProjectBuilder builder = GitLabApplicationSettingProjectBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingProject())
                .projectExportLimit(null);

        final GitLabApplicationSettingProject built = builder.build();

        assertThat(built.projectExportLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectDownloadExportLimitIsNullable() {
        final GitLabApplicationSettingProjectBuilder builder = GitLabApplicationSettingProjectBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingProject())
                .projectDownloadExportLimit(null);

        final GitLabApplicationSettingProject built = builder.build();

        assertThat(built.projectDownloadExportLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRelationsExportLimitIsNullable() {
        final GitLabApplicationSettingProjectBuilder builder = GitLabApplicationSettingProjectBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingProject())
                .projectRelationsExportLimit(null);

        final GitLabApplicationSettingProject built = builder.build();

        assertThat(built.projectRelationsExportLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRelationsExportDownloadLimitIsNullable() {
        final GitLabApplicationSettingProjectBuilder builder = GitLabApplicationSettingProjectBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingProject())
                .projectRelationsExportDownloadLimit(null);

        final GitLabApplicationSettingProject built = builder.build();

        assertThat(built.projectRelationsExportDownloadLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRunnerTokenExpirationIntervalIsNullable() {
        final GitLabApplicationSettingProjectBuilder builder = GitLabApplicationSettingProjectBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingProject())
                .projectRunnerTokenExpirationInterval(null);

        final GitLabApplicationSettingProject built = builder.build();

        assertThat(built.projectRunnerTokenExpirationInterval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectApiLimitIsNullable() {
        final GitLabApplicationSettingProjectBuilder builder = GitLabApplicationSettingProjectBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingProject())
                .projectApiLimit(null);

        final GitLabApplicationSettingProject built = builder.build();

        assertThat(built.projectApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectInvitedGroupsApiLimitIsNullable() {
        final GitLabApplicationSettingProjectBuilder builder = GitLabApplicationSettingProjectBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingProject())
                .projectInvitedGroupsApiLimit(null);

        final GitLabApplicationSettingProject built = builder.build();

        assertThat(built.projectInvitedGroupsApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRepositoriesBlameLimitIsNullable() {
        final GitLabApplicationSettingProjectBuilder builder = GitLabApplicationSettingProjectBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingProject())
                .projectRepositoriesBlameLimit(null);

        final GitLabApplicationSettingProject built = builder.build();

        assertThat(built.projectRepositoriesBlameLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRepositoriesBlameUnauthenticatedLimitIsNullable() {
        final GitLabApplicationSettingProjectBuilder builder = GitLabApplicationSettingProjectBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingProject())
                .projectRepositoriesBlameUnauthenticatedLimit(null);

        final GitLabApplicationSettingProject built = builder.build();

        assertThat(built.projectRepositoriesBlameUnauthenticatedLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRepositoriesBlobsBatchLimitIsNullable() {
        final GitLabApplicationSettingProjectBuilder builder = GitLabApplicationSettingProjectBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingProject())
                .projectRepositoriesBlobsBatchLimit(null);

        final GitLabApplicationSettingProject built = builder.build();

        assertThat(built.projectRepositoriesBlobsBatchLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRepositoryCommitsApiLimitIsNullable() {
        final GitLabApplicationSettingProjectBuilder builder = GitLabApplicationSettingProjectBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingProject())
                .projectRepositoryCommitsApiLimit(null);

        final GitLabApplicationSettingProject built = builder.build();

        assertThat(built.projectRepositoryCommitsApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectMembersApiLimitIsNullable() {
        final GitLabApplicationSettingProjectBuilder builder = GitLabApplicationSettingProjectBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingProject())
                .projectMembersApiLimit(null);

        final GitLabApplicationSettingProject built = builder.build();

        assertThat(built.projectMembersApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectHooksCreateLimitIsNullable() {
        final GitLabApplicationSettingProjectBuilder builder = GitLabApplicationSettingProjectBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingProject())
                .projectHooksCreateLimit(null);

        final GitLabApplicationSettingProject built = builder.build();

        assertThat(built.projectHooksCreateLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectJobsApiRateLimitIsNullable() {
        final GitLabApplicationSettingProjectBuilder builder = GitLabApplicationSettingProjectBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingProject())
                .projectJobsApiRateLimit(null);

        final GitLabApplicationSettingProject built = builder.build();

        assertThat(built.projectJobsApiRateLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectSecretsLimitIsNullable() {
        final GitLabApplicationSettingProjectBuilder builder = GitLabApplicationSettingProjectBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingProject())
                .projectSecretsLimit(null);

        final GitLabApplicationSettingProject built = builder.build();

        assertThat(built.projectSecretsLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectAuditEventsApiLimitIsNullable() {
        final GitLabApplicationSettingProjectBuilder builder = GitLabApplicationSettingProjectBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingProject())
                .projectAuditEventsApiLimit(null);

        final GitLabApplicationSettingProject built = builder.build();

        assertThat(built.projectAuditEventsApiLimit()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabApplicationSettingProject value = SettingsCatalogFixtures.applicationSettingProject();

        assertSoftly(softly -> {
            softly.assertThat(value.projectExportEnabled()).isEqualTo("project_export_enabled");
            softly.assertThat(value.projectCreateLimit()).isEqualTo("project_create_limit");
            softly.assertThat(value.projectImportLimit()).isEqualTo("project_import_limit");
            softly.assertThat(value.projectExportLimit()).isEqualTo("project_export_limit");
            softly.assertThat(value.projectDownloadExportLimit()).isEqualTo("project_download_export_limit");
            softly.assertThat(value.projectRelationsExportLimit()).isEqualTo("project_relations_export_limit");
            softly.assertThat(value.projectRelationsExportDownloadLimit())
                    .isEqualTo("project_relations_export_download_limit");
            softly.assertThat(value.projectRunnerTokenExpirationInterval())
                    .isEqualTo("project_runner_token_expiration_interval");
            softly.assertThat(value.projectApiLimit()).isEqualTo("project_api_limit");
            softly.assertThat(value.projectInvitedGroupsApiLimit()).isEqualTo("project_invited_groups_api_limit");
            softly.assertThat(value.projectRepositoriesBlameLimit()).isEqualTo("project_repositories_blame_limit");
            softly.assertThat(value.projectRepositoriesBlameUnauthenticatedLimit())
                    .isEqualTo("project_repositories_blame_unauthenticated_limit");
            softly.assertThat(value.projectRepositoriesBlobsBatchLimit())
                    .isEqualTo("project_repositories_blobs_batch_limit");
            softly.assertThat(value.projectRepositoryCommitsApiLimit())
                    .isEqualTo("project_repository_commits_api_limit");
            softly.assertThat(value.projectMembersApiLimit()).isEqualTo("project_members_api_limit");
            softly.assertThat(value.projectHooksCreateLimit()).isEqualTo("project_hooks_create_limit");
            softly.assertThat(value.projectJobsApiRateLimit()).isEqualTo("project_jobs_api_rate_limit");
            softly.assertThat(value.projectSecretsLimit()).isEqualTo("project_secrets_limit");
            softly.assertThat(value.projectAuditEventsApiLimit()).isEqualTo("project_audit_events_api_limit");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabApplicationSettingProject original = SettingsCatalogFixtures.applicationSettingProject();

        final GitLabApplicationSettingProject rebuilt =
                GitLabApplicationSettingProjectBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenProjectRunnerTokenExpirationIntervalIsACredential() {
        final GitLabApplicationSettingProject value = SettingsCatalogFixtures.applicationSettingProject();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenProjectSecretsLimitIsACredential() {
        final GitLabApplicationSettingProject value = SettingsCatalogFixtures.applicationSettingProject();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabApplicationSettingProject.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "projectExportEnabled",
                        "projectCreateLimit",
                        "projectImportLimit",
                        "projectExportLimit",
                        "projectDownloadExportLimit",
                        "projectRelationsExportLimit",
                        "projectRelationsExportDownloadLimit",
                        "projectRunnerTokenExpirationInterval",
                        "projectApiLimit",
                        "projectInvitedGroupsApiLimit",
                        "projectRepositoriesBlameLimit",
                        "projectRepositoriesBlameUnauthenticatedLimit",
                        "projectRepositoriesBlobsBatchLimit",
                        "projectRepositoryCommitsApiLimit",
                        "projectMembersApiLimit",
                        "projectHooksCreateLimit",
                        "projectJobsApiRateLimit",
                        "projectSecretsLimit",
                        "projectAuditEventsApiLimit");
    }
}
