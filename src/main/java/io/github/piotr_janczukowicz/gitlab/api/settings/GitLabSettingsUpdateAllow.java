package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabSettingsUpdatePayload}, flattened into it in JSON.
 *
 * @param allowLocalRequestsFromHooksAndServices the allow local requests from hooks and services
 * @param allowRunnerRegistrationToken the allow runner registration token
 * @param allowAccountDeletion the allow account deletion
 * @param allowApplicationDefaultCredentialsForOfflineTransfer the allow application default credentials for offline
 *     transfer
 * @param allowBypassPlaceholderConfirmation the allow bypass placeholder confirmation
 * @param allowLocalRequestsFromSystemHooks the allow local requests from system hooks
 * @param allowLocalRequestsFromWebHooksAndServices the allow local requests from web hooks and services
 * @param allowProjectCreationForGuestAndBelow the allow project creation for guest and below
 * @param allowS3CompatibleStorageForOfflineTransfer the allow s3 compatible storage for offline transfer
 * @param allowAllIntegrations the allow all integrations
 * @param allowGroupOwnersToManageLdap the allow group owners to manage ldap
 * @param allowPossibleSpam the allow possible spam
 * @param allowContributionMappingToAdmins the allow contribution mapping to admins
 * @param allowDeployTokensAndKeysWithExternalAuthn the allow deploy tokens and keys with external authn
 * @param allowTopLevelGroupOwnersToCreateServiceAccounts the allow top level group owners to create service accounts
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabSettingsUpdateAllow(
        @Nullable Boolean allowLocalRequestsFromHooksAndServices,
        @Nullable Boolean allowRunnerRegistrationToken,
        @Nullable String allowAccountDeletion,
        @Nullable String allowApplicationDefaultCredentialsForOfflineTransfer,
        @Nullable String allowBypassPlaceholderConfirmation,
        @Nullable String allowLocalRequestsFromSystemHooks,
        @Nullable String allowLocalRequestsFromWebHooksAndServices,
        @Nullable String allowProjectCreationForGuestAndBelow,
        @Nullable String allowS3CompatibleStorageForOfflineTransfer,
        @Nullable String allowAllIntegrations,
        @Nullable String allowGroupOwnersToManageLdap,
        @Nullable String allowPossibleSpam,
        @Nullable String allowContributionMappingToAdmins,
        @Nullable String allowDeployTokensAndKeysWithExternalAuthn,
        @Nullable String allowTopLevelGroupOwnersToCreateServiceAccounts) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code allowApplicationDefaultCredentialsForOfflineTransfer},
     *     {@code allowDeployTokensAndKeysWithExternalAuthn} redacted
     */
    @Override
    public String toString() {
        return "GitLabSettingsUpdateAllow[" + "allowLocalRequestsFromHooksAndServices="
                + allowLocalRequestsFromHooksAndServices + ", allowRunnerRegistrationToken="
                + allowRunnerRegistrationToken + ", allowAccountDeletion=" + allowAccountDeletion
                + ", allowApplicationDefaultCredentialsForOfflineTransfer=<redacted>"
                + ", allowBypassPlaceholderConfirmation=" + allowBypassPlaceholderConfirmation
                + ", allowLocalRequestsFromSystemHooks=" + allowLocalRequestsFromSystemHooks
                + ", allowLocalRequestsFromWebHooksAndServices=" + allowLocalRequestsFromWebHooksAndServices
                + ", allowProjectCreationForGuestAndBelow=" + allowProjectCreationForGuestAndBelow
                + ", allowS3CompatibleStorageForOfflineTransfer=" + allowS3CompatibleStorageForOfflineTransfer
                + ", allowAllIntegrations=" + allowAllIntegrations + ", allowGroupOwnersToManageLdap="
                + allowGroupOwnersToManageLdap + ", allowPossibleSpam=" + allowPossibleSpam
                + ", allowContributionMappingToAdmins=" + allowContributionMappingToAdmins
                + ", allowDeployTokensAndKeysWithExternalAuthn=<redacted>"
                + ", allowTopLevelGroupOwnersToCreateServiceAccounts=" + allowTopLevelGroupOwnersToCreateServiceAccounts
                + "]";
    }
}
