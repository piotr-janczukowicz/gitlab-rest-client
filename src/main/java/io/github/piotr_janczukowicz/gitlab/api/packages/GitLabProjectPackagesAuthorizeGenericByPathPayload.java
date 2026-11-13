package io.github.piotr_janczukowicz.gitlab.api.packages;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation
 * {@code putApiV4ProjectsIdPackagesGenericPackageNamePackageVersionPathFileNameAuthorize}.
 *
 * @param status the status
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdPackagesGenericPackageNamePackageVersionPathFileNameAuthorize/requestBody")
public record GitLabProjectPackagesAuthorizeGenericByPathPayload(
        @Nullable GitLabProjectPackagesAuthorizeGenericByPathStatus status) {}
