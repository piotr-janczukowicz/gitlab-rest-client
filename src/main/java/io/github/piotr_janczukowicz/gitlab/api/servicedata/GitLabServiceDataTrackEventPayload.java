package io.github.piotr_janczukowicz.gitlab.api.servicedata;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4UsageDataTrackEvent}.
 *
 * @param event the event
 * @param namespaceId the namespace id
 * @param projectId the project id
 * @param projectPath the project path
 * @param additionalProperties the additional properties
 * @param sendToSnowplow the send to snowplow
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4UsageDataTrackEvent/requestBody")
public record GitLabServiceDataTrackEventPayload(
        @Nullable String event,
        @Nullable Long namespaceId,
        @Nullable Long projectId,
        @Nullable String projectPath,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> additionalProperties,

        @Nullable Boolean sendToSnowplow) {
    public GitLabServiceDataTrackEventPayload {
        if (additionalProperties != null) {
            additionalProperties = Map.copyOf(additionalProperties);
        }
    }
}
