package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabApplicationSetting}, flattened into it in JSON.
 *
 * @param runnerTokenExpirationInterval the runner token expiration interval
 * @param runnerJobListCompletedStatusesLimitPerUser the runner job list completed statuses limit per user
 * @param runnerJobListProjectFilteredLimitPerUser the runner job list project filtered limit per user
 * @param runnerManagerListLimitPerUser the runner manager list limit per user
 * @param runnerJobsRequestApiLimit the runner jobs request api limit
 * @param runnerJobsPatchTraceApiLimit the runner jobs patch trace api limit
 * @param runnerJobsEndpointsApiLimit the runner jobs endpoints api limit
 * @param runnerManagerCreationLimit the runner manager creation limit
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabApplicationSettingRunner(
        @Nullable String runnerTokenExpirationInterval,
        @Nullable String runnerJobListCompletedStatusesLimitPerUser,
        @Nullable String runnerJobListProjectFilteredLimitPerUser,
        @Nullable String runnerManagerListLimitPerUser,
        @Nullable String runnerJobsRequestApiLimit,
        @Nullable String runnerJobsPatchTraceApiLimit,
        @Nullable String runnerJobsEndpointsApiLimit,
        @Nullable String runnerManagerCreationLimit) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code runnerTokenExpirationInterval} redacted
     */
    @Override
    public String toString() {
        return "GitLabApplicationSettingRunner[" + "runnerTokenExpirationInterval=<redacted>"
                + ", runnerJobListCompletedStatusesLimitPerUser=" + runnerJobListCompletedStatusesLimitPerUser
                + ", runnerJobListProjectFilteredLimitPerUser=" + runnerJobListProjectFilteredLimitPerUser
                + ", runnerManagerListLimitPerUser=" + runnerManagerListLimitPerUser + ", runnerJobsRequestApiLimit="
                + runnerJobsRequestApiLimit + ", runnerJobsPatchTraceApiLimit=" + runnerJobsPatchTraceApiLimit
                + ", runnerJobsEndpointsApiLimit=" + runnerJobsEndpointsApiLimit + ", runnerManagerCreationLimit="
                + runnerManagerCreationLimit + "]";
    }
}
