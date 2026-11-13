package io.github.piotr_janczukowicz.gitlab.api.projectvulnerabilities;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdVulnerabilities}.
 *
 * @param findingId the finding id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdVulnerabilities/requestBody")
public record GitLabProjectProjectVulnerabilitiesCreatePayload(
        @Nullable Long findingId) {}
