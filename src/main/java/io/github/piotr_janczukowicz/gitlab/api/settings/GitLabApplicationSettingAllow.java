package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabApplicationSetting}, flattened into it in JSON.
 *
 * @param allowLocalRequestsFromWebHooksAndServices the allow local requests from web hooks and services
 * @param allowLocalRequestsFromSystemHooks the allow local requests from system hooks
 * @param allowPossibleSpam the allow possible spam
 * @param allowBypassPlaceholderConfirmation the allow bypass placeholder confirmation
 * @param allowContributionMappingToAdmins the allow contribution mapping to admins
 * @param allowS3CompatibleStorageForOfflineTransfer the allow s3 compatible storage for offline transfer
 * @param allowApplicationDefaultCredentialsForOfflineTransfer the allow application default credentials for offline
 *     transfer
 * @param allowRunnerRegistrationToken the allow runner registration token
 * @param allowAccountDeletion the allow account deletion
 * @param allowProjectCreationForGuestAndBelow the allow project creation for guest and below
 * @param allowAllIntegrations the allow all integrations
 * @param allowGroupOwnersToManageLdap the allow group owners to manage ldap
 * @param allowDeployTokensAndKeysWithExternalAuthn the allow deploy tokens and keys with external authn
 * @param allowLocalRequestsFromHooksAndServices the allow local requests from hooks and services
 * @param allowTopLevelGroupOwnersToCreateServiceAccounts the allow top level group owners to create service accounts
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabApplicationSettingAllow(
        @Nullable String allowLocalRequestsFromWebHooksAndServices,
        @Nullable String allowLocalRequestsFromSystemHooks,
        @Nullable String allowPossibleSpam,
        @Nullable String allowBypassPlaceholderConfirmation,
        @Nullable String allowContributionMappingToAdmins,
        @Nullable String allowS3CompatibleStorageForOfflineTransfer,
        @Nullable String allowApplicationDefaultCredentialsForOfflineTransfer,
        @Nullable String allowRunnerRegistrationToken,
        @Nullable String allowAccountDeletion,
        @Nullable String allowProjectCreationForGuestAndBelow,
        @Nullable String allowAllIntegrations,
        @Nullable String allowGroupOwnersToManageLdap,
        @Nullable String allowDeployTokensAndKeysWithExternalAuthn,
        @Nullable String allowLocalRequestsFromHooksAndServices,
        @Nullable String allowTopLevelGroupOwnersToCreateServiceAccounts) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code allowApplicationDefaultCredentialsForOfflineTransfer},
     *     {@code allowRunnerRegistrationToken}, {@code allowDeployTokensAndKeysWithExternalAuthn} redacted
     */
    @Override
    public String toString() {
        return "GitLabApplicationSettingAllow[" + "allowLocalRequestsFromWebHooksAndServices="
                + allowLocalRequestsFromWebHooksAndServices + ", allowLocalRequestsFromSystemHooks="
                + allowLocalRequestsFromSystemHooks + ", allowPossibleSpam=" + allowPossibleSpam
                + ", allowBypassPlaceholderConfirmation=" + allowBypassPlaceholderConfirmation
                + ", allowContributionMappingToAdmins=" + allowContributionMappingToAdmins
                + ", allowS3CompatibleStorageForOfflineTransfer=" + allowS3CompatibleStorageForOfflineTransfer
                + ", allowApplicationDefaultCredentialsForOfflineTransfer=<redacted>"
                + ", allowRunnerRegistrationToken=<redacted>" + ", allowAccountDeletion=" + allowAccountDeletion
                + ", allowProjectCreationForGuestAndBelow=" + allowProjectCreationForGuestAndBelow
                + ", allowAllIntegrations=" + allowAllIntegrations + ", allowGroupOwnersToManageLdap="
                + allowGroupOwnersToManageLdap + ", allowDeployTokensAndKeysWithExternalAuthn=<redacted>"
                + ", allowLocalRequestsFromHooksAndServices=" + allowLocalRequestsFromHooksAndServices
                + ", allowTopLevelGroupOwnersToCreateServiceAccounts=" + allowTopLevelGroupOwnersToCreateServiceAccounts
                + "]";
    }
}
