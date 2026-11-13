package io.github.piotr_janczukowicz.gitlab.api.googlecloudintegration;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdGoogleCloudSetupIntegrationsSh}, without paging.
 *
 * @param enableGoogleCloudArtifactRegistry the enable google cloud artifact registry
 * @param googleCloudArtifactRegistryProjectId the google cloud artifact registry project id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdGoogleCloudSetupIntegrationsSh/parameters")
public record GitLabProjectGoogleCloudIntegrationGetIntegrationsShFilter(
        @Nullable Boolean enableGoogleCloudArtifactRegistry,
        @Nullable String googleCloudArtifactRegistryProjectId) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectGoogleCloudIntegrationGetIntegrationsShFilter empty() {
        return GitLabProjectGoogleCloudIntegrationGetIntegrationsShFilterBuilder.builder()
                .build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .value("enable_google_cloud_artifact_registry", enableGoogleCloudArtifactRegistry)
                .text("google_cloud_artifact_registry_project_id", googleCloudArtifactRegistryProjectId)
                .build();
    }
}
