package io.github.piotr_janczukowicz.gitlab.api.deploykeys;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdDeployKeysKeyId}.
 *
 * @param title the title
 * @param canPush the can push
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdDeployKeysKeyId/requestBody")
public record GitLabProjectDeployKeysUpdatePayload(
        @Nullable String title, @Nullable Boolean canPush) {}
