package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSettingsUpdateGroupTest {

    @Test
    void constructor_shouldAcceptNull_whenGroupRunnerTokenExpirationIntervalIsNullable() {
        final GitLabSettingsUpdateGroupBuilder builder = GitLabSettingsUpdateGroupBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateGroup())
                .groupRunnerTokenExpirationInterval(null);

        final GitLabSettingsUpdateGroup built = builder.build();

        assertThat(built.groupRunnerTokenExpirationInterval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupRelationsExportLimitIsNullable() {
        final GitLabSettingsUpdateGroupBuilder builder = GitLabSettingsUpdateGroupBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateGroup())
                .groupRelationsExportLimit(null);

        final GitLabSettingsUpdateGroup built = builder.build();

        assertThat(built.groupRelationsExportLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupRelationsExportDownloadLimitIsNullable() {
        final GitLabSettingsUpdateGroupBuilder builder = GitLabSettingsUpdateGroupBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateGroup())
                .groupRelationsExportDownloadLimit(null);

        final GitLabSettingsUpdateGroup built = builder.build();

        assertThat(built.groupRelationsExportDownloadLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupHooksCreateLimitIsNullable() {
        final GitLabSettingsUpdateGroupBuilder builder = GitLabSettingsUpdateGroupBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateGroup())
                .groupHooksCreateLimit(null);

        final GitLabSettingsUpdateGroup built = builder.build();

        assertThat(built.groupHooksCreateLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupAuditEventsApiLimitIsNullable() {
        final GitLabSettingsUpdateGroupBuilder builder = GitLabSettingsUpdateGroupBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateGroup())
                .groupAuditEventsApiLimit(null);

        final GitLabSettingsUpdateGroup built = builder.build();

        assertThat(built.groupAuditEventsApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupOwnersCanManageDefaultBranchProtectionIsNullable() {
        final GitLabSettingsUpdateGroupBuilder builder = GitLabSettingsUpdateGroupBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateGroup())
                .groupOwnersCanManageDefaultBranchProtection(null);

        final GitLabSettingsUpdateGroup built = builder.build();

        assertThat(built.groupOwnersCanManageDefaultBranchProtection()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupSecretsLimitIsNullable() {
        final GitLabSettingsUpdateGroupBuilder builder = GitLabSettingsUpdateGroupBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateGroup())
                .groupSecretsLimit(null);

        final GitLabSettingsUpdateGroup built = builder.build();

        assertThat(built.groupSecretsLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupCreateLimitIsNullable() {
        final GitLabSettingsUpdateGroupBuilder builder = GitLabSettingsUpdateGroupBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateGroup())
                .groupCreateLimit(null);

        final GitLabSettingsUpdateGroup built = builder.build();

        assertThat(built.groupCreateLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupImportLimitIsNullable() {
        final GitLabSettingsUpdateGroupBuilder builder = GitLabSettingsUpdateGroupBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateGroup())
                .groupImportLimit(null);

        final GitLabSettingsUpdateGroup built = builder.build();

        assertThat(built.groupImportLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupExportLimitIsNullable() {
        final GitLabSettingsUpdateGroupBuilder builder = GitLabSettingsUpdateGroupBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateGroup())
                .groupExportLimit(null);

        final GitLabSettingsUpdateGroup built = builder.build();

        assertThat(built.groupExportLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupDownloadExportLimitIsNullable() {
        final GitLabSettingsUpdateGroupBuilder builder = GitLabSettingsUpdateGroupBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateGroup())
                .groupDownloadExportLimit(null);

        final GitLabSettingsUpdateGroup built = builder.build();

        assertThat(built.groupDownloadExportLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupApiLimitIsNullable() {
        final GitLabSettingsUpdateGroupBuilder builder = GitLabSettingsUpdateGroupBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateGroup())
                .groupApiLimit(null);

        final GitLabSettingsUpdateGroup built = builder.build();

        assertThat(built.groupApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupArchiveUnarchiveApiLimitIsNullable() {
        final GitLabSettingsUpdateGroupBuilder builder = GitLabSettingsUpdateGroupBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateGroup())
                .groupArchiveUnarchiveApiLimit(null);

        final GitLabSettingsUpdateGroup built = builder.build();

        assertThat(built.groupArchiveUnarchiveApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupInvitedGroupsApiLimitIsNullable() {
        final GitLabSettingsUpdateGroupBuilder builder = GitLabSettingsUpdateGroupBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateGroup())
                .groupInvitedGroupsApiLimit(null);

        final GitLabSettingsUpdateGroup built = builder.build();

        assertThat(built.groupInvitedGroupsApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupSharedGroupsApiLimitIsNullable() {
        final GitLabSettingsUpdateGroupBuilder builder = GitLabSettingsUpdateGroupBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateGroup())
                .groupSharedGroupsApiLimit(null);

        final GitLabSettingsUpdateGroup built = builder.build();

        assertThat(built.groupSharedGroupsApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupProjectsApiLimitIsNullable() {
        final GitLabSettingsUpdateGroupBuilder builder = GitLabSettingsUpdateGroupBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateGroup())
                .groupProjectsApiLimit(null);

        final GitLabSettingsUpdateGroup built = builder.build();

        assertThat(built.groupProjectsApiLimit()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSettingsUpdateGroup value = SettingsCatalogFixtures.settingsUpdateGroup();

        assertSoftly(softly -> {
            softly.assertThat(value.groupRunnerTokenExpirationInterval()).isEqualTo(1);
            softly.assertThat(value.groupRelationsExportLimit()).isEqualTo(1);
            softly.assertThat(value.groupRelationsExportDownloadLimit()).isEqualTo(1);
            softly.assertThat(value.groupHooksCreateLimit()).isEqualTo("group_hooks_create_limit");
            softly.assertThat(value.groupAuditEventsApiLimit()).isEqualTo(1);
            softly.assertThat(value.groupOwnersCanManageDefaultBranchProtection())
                    .isEqualTo(true);
            softly.assertThat(value.groupSecretsLimit()).isEqualTo("group_secrets_limit");
            softly.assertThat(value.groupCreateLimit()).isEqualTo("group_create_limit");
            softly.assertThat(value.groupImportLimit()).isEqualTo("group_import_limit");
            softly.assertThat(value.groupExportLimit()).isEqualTo("group_export_limit");
            softly.assertThat(value.groupDownloadExportLimit()).isEqualTo("group_download_export_limit");
            softly.assertThat(value.groupApiLimit()).isEqualTo("group_api_limit");
            softly.assertThat(value.groupArchiveUnarchiveApiLimit()).isEqualTo("group_archive_unarchive_api_limit");
            softly.assertThat(value.groupInvitedGroupsApiLimit()).isEqualTo("group_invited_groups_api_limit");
            softly.assertThat(value.groupSharedGroupsApiLimit()).isEqualTo("group_shared_groups_api_limit");
            softly.assertThat(value.groupProjectsApiLimit()).isEqualTo("group_projects_api_limit");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSettingsUpdateGroup original = SettingsCatalogFixtures.settingsUpdateGroup();

        final GitLabSettingsUpdateGroup rebuilt =
                GitLabSettingsUpdateGroupBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenGroupSecretsLimitIsACredential() {
        final GitLabSettingsUpdateGroup value = SettingsCatalogFixtures.settingsUpdateGroup();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSettingsUpdateGroup.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "groupRunnerTokenExpirationInterval",
                        "groupRelationsExportLimit",
                        "groupRelationsExportDownloadLimit",
                        "groupHooksCreateLimit",
                        "groupAuditEventsApiLimit",
                        "groupOwnersCanManageDefaultBranchProtection",
                        "groupSecretsLimit",
                        "groupCreateLimit",
                        "groupImportLimit",
                        "groupExportLimit",
                        "groupDownloadExportLimit",
                        "groupApiLimit",
                        "groupArchiveUnarchiveApiLimit",
                        "groupInvitedGroupsApiLimit",
                        "groupSharedGroupsApiLimit",
                        "groupProjectsApiLimit");
    }
}
