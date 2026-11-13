package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabApplicationSettingGroupTest {

    @Test
    void constructor_shouldAcceptNull_whenGroupCreateLimitIsNullable() {
        final GitLabApplicationSettingGroupBuilder builder = GitLabApplicationSettingGroupBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingGroup())
                .groupCreateLimit(null);

        final GitLabApplicationSettingGroup built = builder.build();

        assertThat(built.groupCreateLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupImportLimitIsNullable() {
        final GitLabApplicationSettingGroupBuilder builder = GitLabApplicationSettingGroupBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingGroup())
                .groupImportLimit(null);

        final GitLabApplicationSettingGroup built = builder.build();

        assertThat(built.groupImportLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupExportLimitIsNullable() {
        final GitLabApplicationSettingGroupBuilder builder = GitLabApplicationSettingGroupBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingGroup())
                .groupExportLimit(null);

        final GitLabApplicationSettingGroup built = builder.build();

        assertThat(built.groupExportLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupDownloadExportLimitIsNullable() {
        final GitLabApplicationSettingGroupBuilder builder = GitLabApplicationSettingGroupBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingGroup())
                .groupDownloadExportLimit(null);

        final GitLabApplicationSettingGroup built = builder.build();

        assertThat(built.groupDownloadExportLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupRelationsExportLimitIsNullable() {
        final GitLabApplicationSettingGroupBuilder builder = GitLabApplicationSettingGroupBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingGroup())
                .groupRelationsExportLimit(null);

        final GitLabApplicationSettingGroup built = builder.build();

        assertThat(built.groupRelationsExportLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupRelationsExportDownloadLimitIsNullable() {
        final GitLabApplicationSettingGroupBuilder builder = GitLabApplicationSettingGroupBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingGroup())
                .groupRelationsExportDownloadLimit(null);

        final GitLabApplicationSettingGroup built = builder.build();

        assertThat(built.groupRelationsExportDownloadLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupRunnerTokenExpirationIntervalIsNullable() {
        final GitLabApplicationSettingGroupBuilder builder = GitLabApplicationSettingGroupBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingGroup())
                .groupRunnerTokenExpirationInterval(null);

        final GitLabApplicationSettingGroup built = builder.build();

        assertThat(built.groupRunnerTokenExpirationInterval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupApiLimitIsNullable() {
        final GitLabApplicationSettingGroupBuilder builder = GitLabApplicationSettingGroupBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingGroup())
                .groupApiLimit(null);

        final GitLabApplicationSettingGroup built = builder.build();

        assertThat(built.groupApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupArchiveUnarchiveApiLimitIsNullable() {
        final GitLabApplicationSettingGroupBuilder builder = GitLabApplicationSettingGroupBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingGroup())
                .groupArchiveUnarchiveApiLimit(null);

        final GitLabApplicationSettingGroup built = builder.build();

        assertThat(built.groupArchiveUnarchiveApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupInvitedGroupsApiLimitIsNullable() {
        final GitLabApplicationSettingGroupBuilder builder = GitLabApplicationSettingGroupBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingGroup())
                .groupInvitedGroupsApiLimit(null);

        final GitLabApplicationSettingGroup built = builder.build();

        assertThat(built.groupInvitedGroupsApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupSharedGroupsApiLimitIsNullable() {
        final GitLabApplicationSettingGroupBuilder builder = GitLabApplicationSettingGroupBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingGroup())
                .groupSharedGroupsApiLimit(null);

        final GitLabApplicationSettingGroup built = builder.build();

        assertThat(built.groupSharedGroupsApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupProjectsApiLimitIsNullable() {
        final GitLabApplicationSettingGroupBuilder builder = GitLabApplicationSettingGroupBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingGroup())
                .groupProjectsApiLimit(null);

        final GitLabApplicationSettingGroup built = builder.build();

        assertThat(built.groupProjectsApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupHooksCreateLimitIsNullable() {
        final GitLabApplicationSettingGroupBuilder builder = GitLabApplicationSettingGroupBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingGroup())
                .groupHooksCreateLimit(null);

        final GitLabApplicationSettingGroup built = builder.build();

        assertThat(built.groupHooksCreateLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupSecretsLimitIsNullable() {
        final GitLabApplicationSettingGroupBuilder builder = GitLabApplicationSettingGroupBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingGroup())
                .groupSecretsLimit(null);

        final GitLabApplicationSettingGroup built = builder.build();

        assertThat(built.groupSecretsLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupAuditEventsApiLimitIsNullable() {
        final GitLabApplicationSettingGroupBuilder builder = GitLabApplicationSettingGroupBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingGroup())
                .groupAuditEventsApiLimit(null);

        final GitLabApplicationSettingGroup built = builder.build();

        assertThat(built.groupAuditEventsApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupOwnersCanManageDefaultBranchProtectionIsNullable() {
        final GitLabApplicationSettingGroupBuilder builder = GitLabApplicationSettingGroupBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingGroup())
                .groupOwnersCanManageDefaultBranchProtection(null);

        final GitLabApplicationSettingGroup built = builder.build();

        assertThat(built.groupOwnersCanManageDefaultBranchProtection()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabApplicationSettingGroup value = SettingsCatalogFixtures.applicationSettingGroup();

        assertSoftly(softly -> {
            softly.assertThat(value.groupCreateLimit()).isEqualTo("group_create_limit");
            softly.assertThat(value.groupImportLimit()).isEqualTo("group_import_limit");
            softly.assertThat(value.groupExportLimit()).isEqualTo("group_export_limit");
            softly.assertThat(value.groupDownloadExportLimit()).isEqualTo("group_download_export_limit");
            softly.assertThat(value.groupRelationsExportLimit()).isEqualTo("group_relations_export_limit");
            softly.assertThat(value.groupRelationsExportDownloadLimit())
                    .isEqualTo("group_relations_export_download_limit");
            softly.assertThat(value.groupRunnerTokenExpirationInterval())
                    .isEqualTo("group_runner_token_expiration_interval");
            softly.assertThat(value.groupApiLimit()).isEqualTo("group_api_limit");
            softly.assertThat(value.groupArchiveUnarchiveApiLimit()).isEqualTo("group_archive_unarchive_api_limit");
            softly.assertThat(value.groupInvitedGroupsApiLimit()).isEqualTo("group_invited_groups_api_limit");
            softly.assertThat(value.groupSharedGroupsApiLimit()).isEqualTo("group_shared_groups_api_limit");
            softly.assertThat(value.groupProjectsApiLimit()).isEqualTo("group_projects_api_limit");
            softly.assertThat(value.groupHooksCreateLimit()).isEqualTo("group_hooks_create_limit");
            softly.assertThat(value.groupSecretsLimit()).isEqualTo("group_secrets_limit");
            softly.assertThat(value.groupAuditEventsApiLimit()).isEqualTo("group_audit_events_api_limit");
            softly.assertThat(value.groupOwnersCanManageDefaultBranchProtection())
                    .isEqualTo("group_owners_can_manage_default_branch_protection");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabApplicationSettingGroup original = SettingsCatalogFixtures.applicationSettingGroup();

        final GitLabApplicationSettingGroup rebuilt =
                GitLabApplicationSettingGroupBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenGroupRunnerTokenExpirationIntervalIsACredential() {
        final GitLabApplicationSettingGroup value = SettingsCatalogFixtures.applicationSettingGroup();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenGroupSecretsLimitIsACredential() {
        final GitLabApplicationSettingGroup value = SettingsCatalogFixtures.applicationSettingGroup();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabApplicationSettingGroup.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "groupCreateLimit",
                        "groupImportLimit",
                        "groupExportLimit",
                        "groupDownloadExportLimit",
                        "groupRelationsExportLimit",
                        "groupRelationsExportDownloadLimit",
                        "groupRunnerTokenExpirationInterval",
                        "groupApiLimit",
                        "groupArchiveUnarchiveApiLimit",
                        "groupInvitedGroupsApiLimit",
                        "groupSharedGroupsApiLimit",
                        "groupProjectsApiLimit",
                        "groupHooksCreateLimit",
                        "groupSecretsLimit",
                        "groupAuditEventsApiLimit",
                        "groupOwnersCanManageDefaultBranchProtection");
    }
}
