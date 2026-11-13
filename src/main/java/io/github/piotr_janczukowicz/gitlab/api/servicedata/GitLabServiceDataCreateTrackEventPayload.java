package io.github.piotr_janczukowicz.gitlab.api.servicedata;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4UsageDataTrackEvents}.
 *
 * @param events the events
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4UsageDataTrackEvents/requestBody")
public record GitLabServiceDataCreateTrackEventPayload(
        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        List<Map<String, Object>> events) {
    public GitLabServiceDataCreateTrackEventPayload {
        if (events != null) {
            events = List.copyOf(events);
        }
    }
}
