package io.github.piotr_janczukowicz.gitlab.api.debianpackages;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdPackagesDebianFileNameAuthorize}.
 *
 * @param distribution the distribution
 * @param component the component
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdPackagesDebianFileNameAuthorize/requestBody")
public record GitLabProjectDebianPackagesAuthorizePayload(
        @Nullable String distribution, @Nullable String component) {}
