package io.github.piotr_janczukowicz.gitlab.api.packages;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdPackagesGenericPackageNamePackageVersionFileNameAuthorize}.
 *
 * @param status the status
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdPackagesGenericPackageNamePackageVersionFileNameAuthorize/requestBody")
public record GitLabProjectPackagesAuthorizeGenericPayload(
        @Nullable GitLabProjectPackagesAuthorizeGenericStatus status) {}
