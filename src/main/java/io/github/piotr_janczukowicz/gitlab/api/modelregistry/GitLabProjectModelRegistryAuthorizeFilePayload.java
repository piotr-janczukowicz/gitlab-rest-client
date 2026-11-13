package io.github.piotr_janczukowicz.gitlab.api.modelregistry;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdPackagesMlModelsModelVersionIdFilesFileNameAuthorize}.
 *
 * @param status the status
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdPackagesMlModelsModelVersionIdFilesFileNameAuthorize/requestBody")
public record GitLabProjectModelRegistryAuthorizeFilePayload(
        @Nullable GitLabProjectModelRegistryAuthorizeFileStatus status) {}
