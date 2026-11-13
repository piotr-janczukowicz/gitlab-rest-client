package io.github.piotr_janczukowicz.gitlab.api.geo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4GeoFailures}.
 *
 * @param geoNodeId the geo node id
 * @param failures the failures
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4GeoFailures/requestBody")
public record GitLabGeoCreateFailuresPayload(
        @Nullable Long geoNodeId, @Nullable List<GitLabGeoCreateFailuresFailure> failures) {
    public GitLabGeoCreateFailuresPayload {
        if (failures != null) {
            failures = List.copyOf(failures);
        }
    }
}
