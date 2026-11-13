package io.github.piotr_janczukowicz.gitlab.api.vulnerabilities;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4VulnerabilitiesIdRevert}.
 *
 * @param comment the comment
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4VulnerabilitiesIdRevert/requestBody")
public record GitLabProjectVulnerabilitiesRevertPayload(
        @Nullable String comment) {}
