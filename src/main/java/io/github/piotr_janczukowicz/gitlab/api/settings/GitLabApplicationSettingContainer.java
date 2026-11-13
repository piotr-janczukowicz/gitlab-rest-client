package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabApplicationSetting}, flattened into it in JSON.
 *
 * @param containerExpirationPoliciesEnableHistoricEntries the container expiration policies enable historic entries
 * @param containerRegistryExpirationPoliciesCaching the container registry expiration policies caching
 * @param containerRegistryTokenExpireDelay the container registry token expire delay
 * @param containerRegistryDeleteTagsServiceTimeout the container registry delete tags service timeout
 * @param containerRegistryExpirationPoliciesWorkerCapacity the container registry expiration policies worker capacity
 * @param containerRegistryCleanupTagsServiceMaxListSize the container registry cleanup tags service max list size
 * @param containerRegistryImportMaxTagsCount the container registry import max tags count
 * @param containerRegistryImportMaxRetries the container registry import max retries
 * @param containerRegistryImportStartMaxRetries the container registry import start max retries
 * @param containerRegistryImportMaxStepDuration the container registry import max step duration
 * @param containerRegistryPreImportTagsRate the container registry pre import tags rate
 * @param containerRegistryPreImportTimeout the container registry pre import timeout
 * @param containerRegistryImportTimeout the container registry import timeout
 * @param containerRegistryImportTargetPlan the container registry import target plan
 * @param containerRegistryImportCreatedBefore the container registry import created before
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabApplicationSettingContainer(
        @Nullable String containerExpirationPoliciesEnableHistoricEntries,
        @Nullable String containerRegistryExpirationPoliciesCaching,
        @Nullable String containerRegistryTokenExpireDelay,
        @Nullable String containerRegistryDeleteTagsServiceTimeout,
        @Nullable String containerRegistryExpirationPoliciesWorkerCapacity,
        @Nullable String containerRegistryCleanupTagsServiceMaxListSize,
        @Nullable String containerRegistryImportMaxTagsCount,
        @Nullable String containerRegistryImportMaxRetries,
        @Nullable String containerRegistryImportStartMaxRetries,
        @Nullable String containerRegistryImportMaxStepDuration,
        @Nullable String containerRegistryPreImportTagsRate,
        @Nullable String containerRegistryPreImportTimeout,
        @Nullable String containerRegistryImportTimeout,
        @Nullable String containerRegistryImportTargetPlan,
        @Nullable String containerRegistryImportCreatedBefore) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code containerRegistryTokenExpireDelay} redacted
     */
    @Override
    public String toString() {
        return "GitLabApplicationSettingContainer[" + "containerExpirationPoliciesEnableHistoricEntries="
                + containerExpirationPoliciesEnableHistoricEntries + ", containerRegistryExpirationPoliciesCaching="
                + containerRegistryExpirationPoliciesCaching + ", containerRegistryTokenExpireDelay=<redacted>"
                + ", containerRegistryDeleteTagsServiceTimeout=" + containerRegistryDeleteTagsServiceTimeout
                + ", containerRegistryExpirationPoliciesWorkerCapacity="
                + containerRegistryExpirationPoliciesWorkerCapacity
                + ", containerRegistryCleanupTagsServiceMaxListSize=" + containerRegistryCleanupTagsServiceMaxListSize
                + ", containerRegistryImportMaxTagsCount=" + containerRegistryImportMaxTagsCount
                + ", containerRegistryImportMaxRetries=" + containerRegistryImportMaxRetries
                + ", containerRegistryImportStartMaxRetries=" + containerRegistryImportStartMaxRetries
                + ", containerRegistryImportMaxStepDuration=" + containerRegistryImportMaxStepDuration
                + ", containerRegistryPreImportTagsRate=" + containerRegistryPreImportTagsRate
                + ", containerRegistryPreImportTimeout=" + containerRegistryPreImportTimeout
                + ", containerRegistryImportTimeout=" + containerRegistryImportTimeout
                + ", containerRegistryImportTargetPlan=" + containerRegistryImportTargetPlan
                + ", containerRegistryImportCreatedBefore=" + containerRegistryImportCreatedBefore + "]";
    }
}
