package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabSettingsUpdatePayload}, flattened into it in JSON.
 *
 * @param throttleAuthenticatedApiEnabled the throttle authenticated api enabled
 * @param throttleAuthenticatedApiPeriodInSeconds the throttle authenticated api period in seconds
 * @param throttleAuthenticatedApiRequestsPerPeriod the throttle authenticated api requests per period
 * @param throttleAuthenticatedGitHttpEnabled the throttle authenticated git http enabled
 * @param throttleAuthenticatedGitHttpPeriodInSeconds the throttle authenticated git http period in seconds
 * @param throttleAuthenticatedGitHttpRequestsPerPeriod the throttle authenticated git http requests per period
 * @param throttleAuthenticatedMcpEnabled the throttle authenticated mcp enabled
 * @param throttleAuthenticatedMcpPeriodInSeconds the throttle authenticated mcp period in seconds
 * @param throttleAuthenticatedMcpRequestsPerPeriod the throttle authenticated mcp requests per period
 * @param throttleAuthenticatedDependencyProxyEnabled the throttle authenticated dependency proxy enabled
 * @param throttleAuthenticatedDependencyProxyPeriodInSeconds the throttle authenticated dependency proxy period in
 *     seconds
 * @param throttleAuthenticatedDependencyProxyRequestsPerPeriod the throttle authenticated dependency proxy requests per
 *     period
 * @param throttleAuthenticatedPackagesApiEnabled the throttle authenticated packages api enabled
 * @param throttleAuthenticatedPackagesApiPeriodInSeconds the throttle authenticated packages api period in seconds
 * @param throttleAuthenticatedPackagesApiRequestsPerPeriod the throttle authenticated packages api requests per period
 * @param throttleAuthenticatedWebEnabled the throttle authenticated web enabled
 * @param throttleAuthenticatedWebPeriodInSeconds the throttle authenticated web period in seconds
 * @param throttleAuthenticatedWebRequestsPerPeriod the throttle authenticated web requests per period
 * @param throttleUnauthenticatedApiEnabled the throttle unauthenticated api enabled
 * @param throttleUnauthenticatedApiPeriodInSeconds the throttle unauthenticated api period in seconds
 * @param throttleUnauthenticatedApiRequestsPerPeriod the throttle unauthenticated api requests per period
 * @param throttleUnauthenticatedEnabled the throttle unauthenticated enabled
 * @param throttleUnauthenticatedGitHttpEnabled the throttle unauthenticated git http enabled
 * @param throttleUnauthenticatedGitHttpPeriodInSeconds the throttle unauthenticated git http period in seconds
 * @param throttleUnauthenticatedGitHttpRequestsPerPeriod the throttle unauthenticated git http requests per period
 * @param throttleUnauthenticatedPackagesApiEnabled the throttle unauthenticated packages api enabled
 * @param throttleUnauthenticatedPackagesApiPeriodInSeconds the throttle unauthenticated packages api period in seconds
 * @param throttleUnauthenticatedPackagesApiRequestsPerPeriod the throttle unauthenticated packages api requests per
 *     period
 * @param throttleUnauthenticatedPeriodInSeconds the throttle unauthenticated period in seconds
 * @param throttleUnauthenticatedRequestsPerPeriod the throttle unauthenticated requests per period
 * @param throttleUnauthenticatedWebEnabled the throttle unauthenticated web enabled
 * @param throttleUnauthenticatedWebPeriodInSeconds the throttle unauthenticated web period in seconds
 * @param throttleUnauthenticatedWebRequestsPerPeriod the throttle unauthenticated web requests per period
 * @param throttleAuthenticatedGitLfsEnabled the throttle authenticated git lfs enabled
 * @param throttleAuthenticatedGitLfsPeriodInSeconds the throttle authenticated git lfs period in seconds
 * @param throttleAuthenticatedGitLfsRequestsPerPeriod the throttle authenticated git lfs requests per period
 * @param throttleAuthenticatedFilesApiEnabled the throttle authenticated files api enabled
 * @param throttleAuthenticatedFilesApiPeriodInSeconds the throttle authenticated files api period in seconds
 * @param throttleAuthenticatedFilesApiRequestsPerPeriod the throttle authenticated files api requests per period
 * @param throttleAuthenticatedDeprecatedApiEnabled the throttle authenticated deprecated api enabled
 * @param throttleAuthenticatedDeprecatedApiPeriodInSeconds the throttle authenticated deprecated api period in seconds
 * @param throttleAuthenticatedDeprecatedApiRequestsPerPeriod the throttle authenticated deprecated api requests per
 *     period
 * @param throttleUnauthenticatedFilesApiEnabled the throttle unauthenticated files api enabled
 * @param throttleUnauthenticatedFilesApiPeriodInSeconds the throttle unauthenticated files api period in seconds
 * @param throttleUnauthenticatedFilesApiRequestsPerPeriod the throttle unauthenticated files api requests per period
 * @param throttleUnauthenticatedDeprecatedApiEnabled the throttle unauthenticated deprecated api enabled
 * @param throttleUnauthenticatedDeprecatedApiPeriodInSeconds the throttle unauthenticated deprecated api period in
 *     seconds
 * @param throttleUnauthenticatedDeprecatedApiRequestsPerPeriod the throttle unauthenticated deprecated api requests per
 *     period
 * @param throttleProtectedPathsEnabled the throttle protected paths enabled
 * @param throttleProtectedPathsPeriodInSeconds the throttle protected paths period in seconds
 * @param throttleProtectedPathsRequestsPerPeriod the throttle protected paths requests per period
 * @param throttleIncidentManagementNotificationEnabled the throttle incident management notification enabled
 * @param throttleIncidentManagementNotificationPerPeriod the throttle incident management notification per period
 * @param throttleIncidentManagementNotificationPeriodInSeconds the throttle incident management notification period in
 *     seconds
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabSettingsUpdateThrottle(
        @Nullable String throttleAuthenticatedApiEnabled,
        @Nullable String throttleAuthenticatedApiPeriodInSeconds,
        @Nullable String throttleAuthenticatedApiRequestsPerPeriod,
        @Nullable String throttleAuthenticatedGitHttpEnabled,
        @Nullable String throttleAuthenticatedGitHttpPeriodInSeconds,
        @Nullable String throttleAuthenticatedGitHttpRequestsPerPeriod,
        @Nullable String throttleAuthenticatedMcpEnabled,
        @Nullable String throttleAuthenticatedMcpPeriodInSeconds,
        @Nullable String throttleAuthenticatedMcpRequestsPerPeriod,
        @Nullable String throttleAuthenticatedDependencyProxyEnabled,
        @Nullable String throttleAuthenticatedDependencyProxyPeriodInSeconds,
        @Nullable String throttleAuthenticatedDependencyProxyRequestsPerPeriod,
        @Nullable String throttleAuthenticatedPackagesApiEnabled,
        @Nullable String throttleAuthenticatedPackagesApiPeriodInSeconds,
        @Nullable String throttleAuthenticatedPackagesApiRequestsPerPeriod,
        @Nullable String throttleAuthenticatedWebEnabled,
        @Nullable String throttleAuthenticatedWebPeriodInSeconds,
        @Nullable String throttleAuthenticatedWebRequestsPerPeriod,
        @Nullable String throttleUnauthenticatedApiEnabled,
        @Nullable String throttleUnauthenticatedApiPeriodInSeconds,
        @Nullable String throttleUnauthenticatedApiRequestsPerPeriod,
        @Nullable String throttleUnauthenticatedEnabled,
        @Nullable String throttleUnauthenticatedGitHttpEnabled,
        @Nullable String throttleUnauthenticatedGitHttpPeriodInSeconds,
        @Nullable String throttleUnauthenticatedGitHttpRequestsPerPeriod,
        @Nullable String throttleUnauthenticatedPackagesApiEnabled,
        @Nullable String throttleUnauthenticatedPackagesApiPeriodInSeconds,
        @Nullable String throttleUnauthenticatedPackagesApiRequestsPerPeriod,
        @Nullable String throttleUnauthenticatedPeriodInSeconds,
        @Nullable String throttleUnauthenticatedRequestsPerPeriod,
        @Nullable String throttleUnauthenticatedWebEnabled,
        @Nullable String throttleUnauthenticatedWebPeriodInSeconds,
        @Nullable String throttleUnauthenticatedWebRequestsPerPeriod,
        @Nullable String throttleAuthenticatedGitLfsEnabled,
        @Nullable String throttleAuthenticatedGitLfsPeriodInSeconds,
        @Nullable String throttleAuthenticatedGitLfsRequestsPerPeriod,
        @Nullable String throttleAuthenticatedFilesApiEnabled,
        @Nullable String throttleAuthenticatedFilesApiPeriodInSeconds,
        @Nullable String throttleAuthenticatedFilesApiRequestsPerPeriod,
        @Nullable String throttleAuthenticatedDeprecatedApiEnabled,
        @Nullable String throttleAuthenticatedDeprecatedApiPeriodInSeconds,
        @Nullable String throttleAuthenticatedDeprecatedApiRequestsPerPeriod,
        @Nullable String throttleUnauthenticatedFilesApiEnabled,
        @Nullable String throttleUnauthenticatedFilesApiPeriodInSeconds,
        @Nullable String throttleUnauthenticatedFilesApiRequestsPerPeriod,
        @Nullable String throttleUnauthenticatedDeprecatedApiEnabled,
        @Nullable String throttleUnauthenticatedDeprecatedApiPeriodInSeconds,
        @Nullable String throttleUnauthenticatedDeprecatedApiRequestsPerPeriod,
        @Nullable String throttleProtectedPathsEnabled,
        @Nullable String throttleProtectedPathsPeriodInSeconds,
        @Nullable String throttleProtectedPathsRequestsPerPeriod,
        @Nullable String throttleIncidentManagementNotificationEnabled,
        @Nullable String throttleIncidentManagementNotificationPerPeriod,
        @Nullable String throttleIncidentManagementNotificationPeriodInSeconds) {}
