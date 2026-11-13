package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSettingsUpdateProjectTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectExportEnabledIsNullable() {
        final GitLabSettingsUpdateProjectBuilder builder = GitLabSettingsUpdateProjectBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateProject())
                .projectExportEnabled(null);

        final GitLabSettingsUpdateProject built = builder.build();

        assertThat(built.projectExportEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRunnerTokenExpirationIntervalIsNullable() {
        final GitLabSettingsUpdateProjectBuilder builder = GitLabSettingsUpdateProjectBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateProject())
                .projectRunnerTokenExpirationInterval(null);

        final GitLabSettingsUpdateProject built = builder.build();

        assertThat(built.projectRunnerTokenExpirationInterval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRelationsExportLimitIsNullable() {
        final GitLabSettingsUpdateProjectBuilder builder = GitLabSettingsUpdateProjectBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateProject())
                .projectRelationsExportLimit(null);

        final GitLabSettingsUpdateProject built = builder.build();

        assertThat(built.projectRelationsExportLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRelationsExportDownloadLimitIsNullable() {
        final GitLabSettingsUpdateProjectBuilder builder = GitLabSettingsUpdateProjectBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateProject())
                .projectRelationsExportDownloadLimit(null);

        final GitLabSettingsUpdateProject built = builder.build();

        assertThat(built.projectRelationsExportDownloadLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectJobsApiRateLimitIsNullable() {
        final GitLabSettingsUpdateProjectBuilder builder = GitLabSettingsUpdateProjectBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateProject())
                .projectJobsApiRateLimit(null);

        final GitLabSettingsUpdateProject built = builder.build();

        assertThat(built.projectJobsApiRateLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectHooksCreateLimitIsNullable() {
        final GitLabSettingsUpdateProjectBuilder builder = GitLabSettingsUpdateProjectBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateProject())
                .projectHooksCreateLimit(null);

        final GitLabSettingsUpdateProject built = builder.build();

        assertThat(built.projectHooksCreateLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectAuditEventsApiLimitIsNullable() {
        final GitLabSettingsUpdateProjectBuilder builder = GitLabSettingsUpdateProjectBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateProject())
                .projectAuditEventsApiLimit(null);

        final GitLabSettingsUpdateProject built = builder.build();

        assertThat(built.projectAuditEventsApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectSecretsLimitIsNullable() {
        final GitLabSettingsUpdateProjectBuilder builder = GitLabSettingsUpdateProjectBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateProject())
                .projectSecretsLimit(null);

        final GitLabSettingsUpdateProject built = builder.build();

        assertThat(built.projectSecretsLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectCreateLimitIsNullable() {
        final GitLabSettingsUpdateProjectBuilder builder = GitLabSettingsUpdateProjectBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateProject())
                .projectCreateLimit(null);

        final GitLabSettingsUpdateProject built = builder.build();

        assertThat(built.projectCreateLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectImportLimitIsNullable() {
        final GitLabSettingsUpdateProjectBuilder builder = GitLabSettingsUpdateProjectBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateProject())
                .projectImportLimit(null);

        final GitLabSettingsUpdateProject built = builder.build();

        assertThat(built.projectImportLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectExportLimitIsNullable() {
        final GitLabSettingsUpdateProjectBuilder builder = GitLabSettingsUpdateProjectBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateProject())
                .projectExportLimit(null);

        final GitLabSettingsUpdateProject built = builder.build();

        assertThat(built.projectExportLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectDownloadExportLimitIsNullable() {
        final GitLabSettingsUpdateProjectBuilder builder = GitLabSettingsUpdateProjectBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateProject())
                .projectDownloadExportLimit(null);

        final GitLabSettingsUpdateProject built = builder.build();

        assertThat(built.projectDownloadExportLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectApiLimitIsNullable() {
        final GitLabSettingsUpdateProjectBuilder builder = GitLabSettingsUpdateProjectBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateProject())
                .projectApiLimit(null);

        final GitLabSettingsUpdateProject built = builder.build();

        assertThat(built.projectApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectInvitedGroupsApiLimitIsNullable() {
        final GitLabSettingsUpdateProjectBuilder builder = GitLabSettingsUpdateProjectBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateProject())
                .projectInvitedGroupsApiLimit(null);

        final GitLabSettingsUpdateProject built = builder.build();

        assertThat(built.projectInvitedGroupsApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRepositoriesBlameLimitIsNullable() {
        final GitLabSettingsUpdateProjectBuilder builder = GitLabSettingsUpdateProjectBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateProject())
                .projectRepositoriesBlameLimit(null);

        final GitLabSettingsUpdateProject built = builder.build();

        assertThat(built.projectRepositoriesBlameLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRepositoriesBlameUnauthenticatedLimitIsNullable() {
        final GitLabSettingsUpdateProjectBuilder builder = GitLabSettingsUpdateProjectBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateProject())
                .projectRepositoriesBlameUnauthenticatedLimit(null);

        final GitLabSettingsUpdateProject built = builder.build();

        assertThat(built.projectRepositoriesBlameUnauthenticatedLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRepositoriesBlobsBatchLimitIsNullable() {
        final GitLabSettingsUpdateProjectBuilder builder = GitLabSettingsUpdateProjectBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateProject())
                .projectRepositoriesBlobsBatchLimit(null);

        final GitLabSettingsUpdateProject built = builder.build();

        assertThat(built.projectRepositoriesBlobsBatchLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectRepositoryCommitsApiLimitIsNullable() {
        final GitLabSettingsUpdateProjectBuilder builder = GitLabSettingsUpdateProjectBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateProject())
                .projectRepositoryCommitsApiLimit(null);

        final GitLabSettingsUpdateProject built = builder.build();

        assertThat(built.projectRepositoryCommitsApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectMembersApiLimitIsNullable() {
        final GitLabSettingsUpdateProjectBuilder builder = GitLabSettingsUpdateProjectBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateProject())
                .projectMembersApiLimit(null);

        final GitLabSettingsUpdateProject built = builder.build();

        assertThat(built.projectMembersApiLimit()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSettingsUpdateProject value = SettingsCatalogFixtures.settingsUpdateProject();

        assertSoftly(softly -> {
            softly.assertThat(value.projectExportEnabled()).isEqualTo(true);
            softly.assertThat(value.projectRunnerTokenExpirationInterval()).isEqualTo(1);
            softly.assertThat(value.projectRelationsExportLimit()).isEqualTo(1);
            softly.assertThat(value.projectRelationsExportDownloadLimit()).isEqualTo(1);
            softly.assertThat(value.projectJobsApiRateLimit()).isEqualTo(1);
            softly.assertThat(value.projectHooksCreateLimit()).isEqualTo("project_hooks_create_limit");
            softly.assertThat(value.projectAuditEventsApiLimit()).isEqualTo(1);
            softly.assertThat(value.projectSecretsLimit()).isEqualTo("project_secrets_limit");
            softly.assertThat(value.projectCreateLimit()).isEqualTo("project_create_limit");
            softly.assertThat(value.projectImportLimit()).isEqualTo("project_import_limit");
            softly.assertThat(value.projectExportLimit()).isEqualTo("project_export_limit");
            softly.assertThat(value.projectDownloadExportLimit()).isEqualTo("project_download_export_limit");
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
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSettingsUpdateProject original = SettingsCatalogFixtures.settingsUpdateProject();

        final GitLabSettingsUpdateProject rebuilt =
                GitLabSettingsUpdateProjectBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenProjectSecretsLimitIsACredential() {
        final GitLabSettingsUpdateProject value = SettingsCatalogFixtures.settingsUpdateProject();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSettingsUpdateProject.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "projectExportEnabled",
                        "projectRunnerTokenExpirationInterval",
                        "projectRelationsExportLimit",
                        "projectRelationsExportDownloadLimit",
                        "projectJobsApiRateLimit",
                        "projectHooksCreateLimit",
                        "projectAuditEventsApiLimit",
                        "projectSecretsLimit",
                        "projectCreateLimit",
                        "projectImportLimit",
                        "projectExportLimit",
                        "projectDownloadExportLimit",
                        "projectApiLimit",
                        "projectInvitedGroupsApiLimit",
                        "projectRepositoriesBlameLimit",
                        "projectRepositoriesBlameUnauthenticatedLimit",
                        "projectRepositoriesBlobsBatchLimit",
                        "projectRepositoryCommitsApiLimit",
                        "projectMembersApiLimit");
    }
}
