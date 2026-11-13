package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabApplicationSettingAllowTest {

    @Test
    void constructor_shouldAcceptNull_whenAllowLocalRequestsFromWebHooksAndServicesIsNullable() {
        final GitLabApplicationSettingAllowBuilder builder = GitLabApplicationSettingAllowBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingAllow())
                .allowLocalRequestsFromWebHooksAndServices(null);

        final GitLabApplicationSettingAllow built = builder.build();

        assertThat(built.allowLocalRequestsFromWebHooksAndServices()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowLocalRequestsFromSystemHooksIsNullable() {
        final GitLabApplicationSettingAllowBuilder builder = GitLabApplicationSettingAllowBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingAllow())
                .allowLocalRequestsFromSystemHooks(null);

        final GitLabApplicationSettingAllow built = builder.build();

        assertThat(built.allowLocalRequestsFromSystemHooks()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowPossibleSpamIsNullable() {
        final GitLabApplicationSettingAllowBuilder builder = GitLabApplicationSettingAllowBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingAllow())
                .allowPossibleSpam(null);

        final GitLabApplicationSettingAllow built = builder.build();

        assertThat(built.allowPossibleSpam()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowBypassPlaceholderConfirmationIsNullable() {
        final GitLabApplicationSettingAllowBuilder builder = GitLabApplicationSettingAllowBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingAllow())
                .allowBypassPlaceholderConfirmation(null);

        final GitLabApplicationSettingAllow built = builder.build();

        assertThat(built.allowBypassPlaceholderConfirmation()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowContributionMappingToAdminsIsNullable() {
        final GitLabApplicationSettingAllowBuilder builder = GitLabApplicationSettingAllowBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingAllow())
                .allowContributionMappingToAdmins(null);

        final GitLabApplicationSettingAllow built = builder.build();

        assertThat(built.allowContributionMappingToAdmins()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowS3CompatibleStorageForOfflineTransferIsNullable() {
        final GitLabApplicationSettingAllowBuilder builder = GitLabApplicationSettingAllowBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingAllow())
                .allowS3CompatibleStorageForOfflineTransfer(null);

        final GitLabApplicationSettingAllow built = builder.build();

        assertThat(built.allowS3CompatibleStorageForOfflineTransfer()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowApplicationDefaultCredentialsForOfflineTransferIsNullable() {
        final GitLabApplicationSettingAllowBuilder builder = GitLabApplicationSettingAllowBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingAllow())
                .allowApplicationDefaultCredentialsForOfflineTransfer(null);

        final GitLabApplicationSettingAllow built = builder.build();

        assertThat(built.allowApplicationDefaultCredentialsForOfflineTransfer()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowRunnerRegistrationTokenIsNullable() {
        final GitLabApplicationSettingAllowBuilder builder = GitLabApplicationSettingAllowBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingAllow())
                .allowRunnerRegistrationToken(null);

        final GitLabApplicationSettingAllow built = builder.build();

        assertThat(built.allowRunnerRegistrationToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowAccountDeletionIsNullable() {
        final GitLabApplicationSettingAllowBuilder builder = GitLabApplicationSettingAllowBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingAllow())
                .allowAccountDeletion(null);

        final GitLabApplicationSettingAllow built = builder.build();

        assertThat(built.allowAccountDeletion()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowProjectCreationForGuestAndBelowIsNullable() {
        final GitLabApplicationSettingAllowBuilder builder = GitLabApplicationSettingAllowBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingAllow())
                .allowProjectCreationForGuestAndBelow(null);

        final GitLabApplicationSettingAllow built = builder.build();

        assertThat(built.allowProjectCreationForGuestAndBelow()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowAllIntegrationsIsNullable() {
        final GitLabApplicationSettingAllowBuilder builder = GitLabApplicationSettingAllowBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingAllow())
                .allowAllIntegrations(null);

        final GitLabApplicationSettingAllow built = builder.build();

        assertThat(built.allowAllIntegrations()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowGroupOwnersToManageLdapIsNullable() {
        final GitLabApplicationSettingAllowBuilder builder = GitLabApplicationSettingAllowBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingAllow())
                .allowGroupOwnersToManageLdap(null);

        final GitLabApplicationSettingAllow built = builder.build();

        assertThat(built.allowGroupOwnersToManageLdap()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowDeployTokensAndKeysWithExternalAuthnIsNullable() {
        final GitLabApplicationSettingAllowBuilder builder = GitLabApplicationSettingAllowBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingAllow())
                .allowDeployTokensAndKeysWithExternalAuthn(null);

        final GitLabApplicationSettingAllow built = builder.build();

        assertThat(built.allowDeployTokensAndKeysWithExternalAuthn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowLocalRequestsFromHooksAndServicesIsNullable() {
        final GitLabApplicationSettingAllowBuilder builder = GitLabApplicationSettingAllowBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingAllow())
                .allowLocalRequestsFromHooksAndServices(null);

        final GitLabApplicationSettingAllow built = builder.build();

        assertThat(built.allowLocalRequestsFromHooksAndServices()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowTopLevelGroupOwnersToCreateServiceAccountsIsNullable() {
        final GitLabApplicationSettingAllowBuilder builder = GitLabApplicationSettingAllowBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingAllow())
                .allowTopLevelGroupOwnersToCreateServiceAccounts(null);

        final GitLabApplicationSettingAllow built = builder.build();

        assertThat(built.allowTopLevelGroupOwnersToCreateServiceAccounts()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabApplicationSettingAllow value = SettingsCatalogFixtures.applicationSettingAllow();

        assertSoftly(softly -> {
            softly.assertThat(value.allowLocalRequestsFromWebHooksAndServices())
                    .isEqualTo("allow_local_requests_from_web_hooks_and_services");
            softly.assertThat(value.allowLocalRequestsFromSystemHooks())
                    .isEqualTo("allow_local_requests_from_system_hooks");
            softly.assertThat(value.allowPossibleSpam()).isEqualTo("allow_possible_spam");
            softly.assertThat(value.allowBypassPlaceholderConfirmation())
                    .isEqualTo("allow_bypass_placeholder_confirmation");
            softly.assertThat(value.allowContributionMappingToAdmins())
                    .isEqualTo("allow_contribution_mapping_to_admins");
            softly.assertThat(value.allowS3CompatibleStorageForOfflineTransfer())
                    .isEqualTo("allow_s3_compatible_storage_for_offline_transfer");
            softly.assertThat(value.allowApplicationDefaultCredentialsForOfflineTransfer())
                    .isEqualTo("allow_application_default_credentials_for_offline_transfer");
            softly.assertThat(value.allowRunnerRegistrationToken()).isEqualTo("allow_runner_registration_token");
            softly.assertThat(value.allowAccountDeletion()).isEqualTo("allow_account_deletion");
            softly.assertThat(value.allowProjectCreationForGuestAndBelow())
                    .isEqualTo("allow_project_creation_for_guest_and_below");
            softly.assertThat(value.allowAllIntegrations()).isEqualTo("allow_all_integrations");
            softly.assertThat(value.allowGroupOwnersToManageLdap()).isEqualTo("allow_group_owners_to_manage_ldap");
            softly.assertThat(value.allowDeployTokensAndKeysWithExternalAuthn())
                    .isEqualTo("allow_deploy_tokens_and_keys_with_external_authn");
            softly.assertThat(value.allowLocalRequestsFromHooksAndServices())
                    .isEqualTo("allow_local_requests_from_hooks_and_services");
            softly.assertThat(value.allowTopLevelGroupOwnersToCreateServiceAccounts())
                    .isEqualTo("allow_top_level_group_owners_to_create_service_accounts");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabApplicationSettingAllow original = SettingsCatalogFixtures.applicationSettingAllow();

        final GitLabApplicationSettingAllow rebuilt =
                GitLabApplicationSettingAllowBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenAllowApplicationDefaultCredentialsForOfflineTransferIsACredential() {
        final GitLabApplicationSettingAllow value = SettingsCatalogFixtures.applicationSettingAllow();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenAllowRunnerRegistrationTokenIsACredential() {
        final GitLabApplicationSettingAllow value = SettingsCatalogFixtures.applicationSettingAllow();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenAllowDeployTokensAndKeysWithExternalAuthnIsACredential() {
        final GitLabApplicationSettingAllow value = SettingsCatalogFixtures.applicationSettingAllow();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabApplicationSettingAllow.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "allowLocalRequestsFromWebHooksAndServices",
                        "allowLocalRequestsFromSystemHooks",
                        "allowPossibleSpam",
                        "allowBypassPlaceholderConfirmation",
                        "allowContributionMappingToAdmins",
                        "allowS3CompatibleStorageForOfflineTransfer",
                        "allowApplicationDefaultCredentialsForOfflineTransfer",
                        "allowRunnerRegistrationToken",
                        "allowAccountDeletion",
                        "allowProjectCreationForGuestAndBelow",
                        "allowAllIntegrations",
                        "allowGroupOwnersToManageLdap",
                        "allowDeployTokensAndKeysWithExternalAuthn",
                        "allowLocalRequestsFromHooksAndServices",
                        "allowTopLevelGroupOwnersToCreateServiceAccounts");
    }
}
