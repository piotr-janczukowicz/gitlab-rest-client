package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabSettingsUpdatePayload}, flattened into it in JSON.
 *
 * @param runnerTokenExpirationInterval the runner token expiration interval
 * @param runnerJobListCompletedStatusesLimitPerUser the runner job list completed statuses limit per user
 * @param runnerJobListProjectFilteredLimitPerUser the runner job list project filtered limit per user
 * @param runnerManagerListLimitPerUser the runner manager list limit per user
 * @param runnerJobsEndpointsApiLimit the runner jobs endpoints api limit
 * @param runnerJobsPatchTraceApiLimit the runner jobs patch trace api limit
 * @param runnerJobsRequestApiLimit the runner jobs request api limit
 * @param runnerManagerCreationLimit the runner manager creation limit
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabSettingsUpdateRunner(
        @Nullable Integer runnerTokenExpirationInterval,
        @Nullable Integer runnerJobListCompletedStatusesLimitPerUser,
        @Nullable Integer runnerJobListProjectFilteredLimitPerUser,
        @Nullable Integer runnerManagerListLimitPerUser,
        @Nullable String runnerJobsEndpointsApiLimit,
        @Nullable String runnerJobsPatchTraceApiLimit,
        @Nullable String runnerJobsRequestApiLimit,
        @Nullable String runnerManagerCreationLimit) {}
