package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabApplicationSetting}, flattened into it in JSON.
 *
 * @param lockRequireShaForMerge the lock require sha for merge
 * @param lockResourceAccessTokenNotifyInherited the lock resource access token notify inherited
 * @param lockMembershipsToLdap the lock memberships to ldap
 * @param lockMembershipsToSaml the lock memberships to saml
 * @param lockModelPromptCacheEnabled the lock model prompt cache enabled
 * @param lockDuoFeaturesEnabled the lock duo features enabled
 * @param lockDuoCustomAgentsEnabled the lock duo custom agents enabled
 * @param lockDuoCustomFlowsEnabled the lock duo custom flows enabled
 * @param lockDuoExternalAgentsEnabled the lock duo external agents enabled
 * @param lockBuiltInProjectTemplatesEnabled the lock built in project templates enabled
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabApplicationSettingLock(
        @Nullable String lockRequireShaForMerge,
        @Nullable String lockResourceAccessTokenNotifyInherited,
        @Nullable String lockMembershipsToLdap,
        @Nullable String lockMembershipsToSaml,
        @Nullable String lockModelPromptCacheEnabled,
        @Nullable String lockDuoFeaturesEnabled,
        @Nullable Boolean lockDuoCustomAgentsEnabled,
        @Nullable Boolean lockDuoCustomFlowsEnabled,
        @Nullable Boolean lockDuoExternalAgentsEnabled,
        @Nullable Boolean lockBuiltInProjectTemplatesEnabled) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code lockResourceAccessTokenNotifyInherited} redacted
     */
    @Override
    public String toString() {
        return "GitLabApplicationSettingLock[" + "lockRequireShaForMerge=" + lockRequireShaForMerge
                + ", lockResourceAccessTokenNotifyInherited=<redacted>" + ", lockMembershipsToLdap="
                + lockMembershipsToLdap + ", lockMembershipsToSaml=" + lockMembershipsToSaml
                + ", lockModelPromptCacheEnabled=" + lockModelPromptCacheEnabled + ", lockDuoFeaturesEnabled="
                + lockDuoFeaturesEnabled + ", lockDuoCustomAgentsEnabled=" + lockDuoCustomAgentsEnabled
                + ", lockDuoCustomFlowsEnabled=" + lockDuoCustomFlowsEnabled + ", lockDuoExternalAgentsEnabled="
                + lockDuoExternalAgentsEnabled + ", lockBuiltInProjectTemplatesEnabled="
                + lockBuiltInProjectTemplatesEnabled + "]";
    }
}
