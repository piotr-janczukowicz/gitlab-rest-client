package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSettingsUpdateAllowTest {

    @Test
    void constructor_shouldAcceptNull_whenAllowLocalRequestsFromHooksAndServicesIsNullable() {
        final GitLabSettingsUpdateAllowBuilder builder = GitLabSettingsUpdateAllowBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateAllow())
                .allowLocalRequestsFromHooksAndServices(null);

        final GitLabSettingsUpdateAllow built = builder.build();

        assertThat(built.allowLocalRequestsFromHooksAndServices()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowRunnerRegistrationTokenIsNullable() {
        final GitLabSettingsUpdateAllowBuilder builder = GitLabSettingsUpdateAllowBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateAllow())
                .allowRunnerRegistrationToken(null);

        final GitLabSettingsUpdateAllow built = builder.build();

        assertThat(built.allowRunnerRegistrationToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowAccountDeletionIsNullable() {
        final GitLabSettingsUpdateAllowBuilder builder = GitLabSettingsUpdateAllowBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateAllow())
                .allowAccountDeletion(null);

        final GitLabSettingsUpdateAllow built = builder.build();

        assertThat(built.allowAccountDeletion()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowApplicationDefaultCredentialsForOfflineTransferIsNullable() {
        final GitLabSettingsUpdateAllowBuilder builder = GitLabSettingsUpdateAllowBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateAllow())
                .allowApplicationDefaultCredentialsForOfflineTransfer(null);

        final GitLabSettingsUpdateAllow built = builder.build();

        assertThat(built.allowApplicationDefaultCredentialsForOfflineTransfer()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowBypassPlaceholderConfirmationIsNullable() {
        final GitLabSettingsUpdateAllowBuilder builder = GitLabSettingsUpdateAllowBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateAllow())
                .allowBypassPlaceholderConfirmation(null);

        final GitLabSettingsUpdateAllow built = builder.build();

        assertThat(built.allowBypassPlaceholderConfirmation()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowLocalRequestsFromSystemHooksIsNullable() {
        final GitLabSettingsUpdateAllowBuilder builder = GitLabSettingsUpdateAllowBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateAllow())
                .allowLocalRequestsFromSystemHooks(null);

        final GitLabSettingsUpdateAllow built = builder.build();

        assertThat(built.allowLocalRequestsFromSystemHooks()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowLocalRequestsFromWebHooksAndServicesIsNullable() {
        final GitLabSettingsUpdateAllowBuilder builder = GitLabSettingsUpdateAllowBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateAllow())
                .allowLocalRequestsFromWebHooksAndServices(null);

        final GitLabSettingsUpdateAllow built = builder.build();

        assertThat(built.allowLocalRequestsFromWebHooksAndServices()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowProjectCreationForGuestAndBelowIsNullable() {
        final GitLabSettingsUpdateAllowBuilder builder = GitLabSettingsUpdateAllowBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateAllow())
                .allowProjectCreationForGuestAndBelow(null);

        final GitLabSettingsUpdateAllow built = builder.build();

        assertThat(built.allowProjectCreationForGuestAndBelow()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowS3CompatibleStorageForOfflineTransferIsNullable() {
        final GitLabSettingsUpdateAllowBuilder builder = GitLabSettingsUpdateAllowBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateAllow())
                .allowS3CompatibleStorageForOfflineTransfer(null);

        final GitLabSettingsUpdateAllow built = builder.build();

        assertThat(built.allowS3CompatibleStorageForOfflineTransfer()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowAllIntegrationsIsNullable() {
        final GitLabSettingsUpdateAllowBuilder builder = GitLabSettingsUpdateAllowBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateAllow())
                .allowAllIntegrations(null);

        final GitLabSettingsUpdateAllow built = builder.build();

        assertThat(built.allowAllIntegrations()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowGroupOwnersToManageLdapIsNullable() {
        final GitLabSettingsUpdateAllowBuilder builder = GitLabSettingsUpdateAllowBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateAllow())
                .allowGroupOwnersToManageLdap(null);

        final GitLabSettingsUpdateAllow built = builder.build();

        assertThat(built.allowGroupOwnersToManageLdap()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowPossibleSpamIsNullable() {
        final GitLabSettingsUpdateAllowBuilder builder = GitLabSettingsUpdateAllowBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateAllow())
                .allowPossibleSpam(null);

        final GitLabSettingsUpdateAllow built = builder.build();

        assertThat(built.allowPossibleSpam()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowContributionMappingToAdminsIsNullable() {
        final GitLabSettingsUpdateAllowBuilder builder = GitLabSettingsUpdateAllowBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateAllow())
                .allowContributionMappingToAdmins(null);

        final GitLabSettingsUpdateAllow built = builder.build();

        assertThat(built.allowContributionMappingToAdmins()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowDeployTokensAndKeysWithExternalAuthnIsNullable() {
        final GitLabSettingsUpdateAllowBuilder builder = GitLabSettingsUpdateAllowBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateAllow())
                .allowDeployTokensAndKeysWithExternalAuthn(null);

        final GitLabSettingsUpdateAllow built = builder.build();

        assertThat(built.allowDeployTokensAndKeysWithExternalAuthn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowTopLevelGroupOwnersToCreateServiceAccountsIsNullable() {
        final GitLabSettingsUpdateAllowBuilder builder = GitLabSettingsUpdateAllowBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateAllow())
                .allowTopLevelGroupOwnersToCreateServiceAccounts(null);

        final GitLabSettingsUpdateAllow built = builder.build();

        assertThat(built.allowTopLevelGroupOwnersToCreateServiceAccounts()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSettingsUpdateAllow value = SettingsCatalogFixtures.settingsUpdateAllow();

        assertSoftly(softly -> {
            softly.assertThat(value.allowLocalRequestsFromHooksAndServices()).isEqualTo(true);
            softly.assertThat(value.allowRunnerRegistrationToken()).isEqualTo(true);
            softly.assertThat(value.allowAccountDeletion()).isEqualTo("allow_account_deletion");
            softly.assertThat(value.allowApplicationDefaultCredentialsForOfflineTransfer())
                    .isEqualTo("allow_application_default_credentials_for_offline_transfer");
            softly.assertThat(value.allowBypassPlaceholderConfirmation())
                    .isEqualTo("allow_bypass_placeholder_confirmation");
            softly.assertThat(value.allowLocalRequestsFromSystemHooks())
                    .isEqualTo("allow_local_requests_from_system_hooks");
            softly.assertThat(value.allowLocalRequestsFromWebHooksAndServices())
                    .isEqualTo("allow_local_requests_from_web_hooks_and_services");
            softly.assertThat(value.allowProjectCreationForGuestAndBelow())
                    .isEqualTo("allow_project_creation_for_guest_and_below");
            softly.assertThat(value.allowS3CompatibleStorageForOfflineTransfer())
                    .isEqualTo("allow_s3_compatible_storage_for_offline_transfer");
            softly.assertThat(value.allowAllIntegrations()).isEqualTo("allow_all_integrations");
            softly.assertThat(value.allowGroupOwnersToManageLdap()).isEqualTo("allow_group_owners_to_manage_ldap");
            softly.assertThat(value.allowPossibleSpam()).isEqualTo("allow_possible_spam");
            softly.assertThat(value.allowContributionMappingToAdmins())
                    .isEqualTo("allow_contribution_mapping_to_admins");
            softly.assertThat(value.allowDeployTokensAndKeysWithExternalAuthn())
                    .isEqualTo("allow_deploy_tokens_and_keys_with_external_authn");
            softly.assertThat(value.allowTopLevelGroupOwnersToCreateServiceAccounts())
                    .isEqualTo("allow_top_level_group_owners_to_create_service_accounts");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSettingsUpdateAllow original = SettingsCatalogFixtures.settingsUpdateAllow();

        final GitLabSettingsUpdateAllow rebuilt =
                GitLabSettingsUpdateAllowBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenAllowApplicationDefaultCredentialsForOfflineTransferIsACredential() {
        final GitLabSettingsUpdateAllow value = SettingsCatalogFixtures.settingsUpdateAllow();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenAllowDeployTokensAndKeysWithExternalAuthnIsACredential() {
        final GitLabSettingsUpdateAllow value = SettingsCatalogFixtures.settingsUpdateAllow();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSettingsUpdateAllow.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "allowLocalRequestsFromHooksAndServices",
                        "allowRunnerRegistrationToken",
                        "allowAccountDeletion",
                        "allowApplicationDefaultCredentialsForOfflineTransfer",
                        "allowBypassPlaceholderConfirmation",
                        "allowLocalRequestsFromSystemHooks",
                        "allowLocalRequestsFromWebHooksAndServices",
                        "allowProjectCreationForGuestAndBelow",
                        "allowS3CompatibleStorageForOfflineTransfer",
                        "allowAllIntegrations",
                        "allowGroupOwnersToManageLdap",
                        "allowPossibleSpam",
                        "allowContributionMappingToAdmins",
                        "allowDeployTokensAndKeysWithExternalAuthn",
                        "allowTopLevelGroupOwnersToCreateServiceAccounts");
    }
}
