package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabSettingsUpdatePayload}, flattened into it in JSON.
 *
 * @param lockRequireShaForMerge the lock require sha for merge
 * @param lockDuoFeaturesEnabled the lock duo features enabled
 * @param lockDuoCustomAgentsEnabled the lock duo custom agents enabled
 * @param lockDuoCustomFlowsEnabled the lock duo custom flows enabled
 * @param lockDuoExternalAgentsEnabled the lock duo external agents enabled
 * @param lockDuoRemoteFlowsEnabled the lock duo remote flows enabled
 * @param lockDuoScheduledAutomationsEnabled the lock duo scheduled automations enabled
 * @param lockBuiltInProjectTemplatesEnabled the lock built in project templates enabled
 * @param lockMembershipsToSaml the lock memberships to saml
 * @param lockResourceAccessTokenNotifyInherited the lock resource access token notify inherited
 * @param lockMembershipsToLdap the lock memberships to ldap
 * @param lockModelPromptCacheEnabled the lock model prompt cache enabled
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabSettingsUpdateLock(
        @Nullable String lockRequireShaForMerge,
        @Nullable Boolean lockDuoFeaturesEnabled,
        @Nullable Boolean lockDuoCustomAgentsEnabled,
        @Nullable Boolean lockDuoCustomFlowsEnabled,
        @Nullable Boolean lockDuoExternalAgentsEnabled,
        @Nullable Boolean lockDuoRemoteFlowsEnabled,
        @Nullable Boolean lockDuoScheduledAutomationsEnabled,
        @Nullable Boolean lockBuiltInProjectTemplatesEnabled,
        @Nullable String lockMembershipsToSaml,
        @Nullable String lockResourceAccessTokenNotifyInherited,
        @Nullable String lockMembershipsToLdap,
        @Nullable String lockModelPromptCacheEnabled) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code lockResourceAccessTokenNotifyInherited} redacted
     */
    @Override
    public String toString() {
        return "GitLabSettingsUpdateLock[" + "lockRequireShaForMerge=" + lockRequireShaForMerge
                + ", lockDuoFeaturesEnabled=" + lockDuoFeaturesEnabled + ", lockDuoCustomAgentsEnabled="
                + lockDuoCustomAgentsEnabled + ", lockDuoCustomFlowsEnabled=" + lockDuoCustomFlowsEnabled
                + ", lockDuoExternalAgentsEnabled=" + lockDuoExternalAgentsEnabled + ", lockDuoRemoteFlowsEnabled="
                + lockDuoRemoteFlowsEnabled + ", lockDuoScheduledAutomationsEnabled="
                + lockDuoScheduledAutomationsEnabled + ", lockBuiltInProjectTemplatesEnabled="
                + lockBuiltInProjectTemplatesEnabled + ", lockMembershipsToSaml=" + lockMembershipsToSaml
                + ", lockResourceAccessTokenNotifyInherited=<redacted>" + ", lockMembershipsToLdap="
                + lockMembershipsToLdap + ", lockModelPromptCacheEnabled=" + lockModelPromptCacheEnabled + "]";
    }
}
