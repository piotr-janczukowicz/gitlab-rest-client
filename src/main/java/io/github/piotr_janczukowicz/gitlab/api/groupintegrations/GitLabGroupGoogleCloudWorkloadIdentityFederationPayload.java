package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4GroupsIdIntegrationsGoogleCloudPlatformWorkloadIdentityFederation}.
 *
 * @param workloadIdentityFederationProjectId the workload identity federation project id
 * @param workloadIdentityFederationProjectNumber the workload identity federation project number
 * @param workloadIdentityPoolId the workload identity pool id
 * @param workloadIdentityPoolProviderId the workload identity pool provider id
 * @param useInheritedSettings the use inherited settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4GroupsIdIntegrationsGoogleCloudPlatformWorkloadIdentityFederation/requestBody")
public record GitLabGroupGoogleCloudWorkloadIdentityFederationPayload(
        @Nullable String workloadIdentityFederationProjectId,
        @Nullable String workloadIdentityFederationProjectNumber,
        @Nullable String workloadIdentityPoolId,
        @Nullable String workloadIdentityPoolProviderId,
        @Nullable Boolean useInheritedSettings) {}
