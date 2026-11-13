package io.github.piotr_janczukowicz.gitlab.api.vulnerabilities;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4VulnerabilitiesIdConfirm}.
 *
 * @param comment the comment
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4VulnerabilitiesIdConfirm/requestBody")
public record GitLabProjectVulnerabilitiesConfirmPayload(
        @Nullable String comment) {}
