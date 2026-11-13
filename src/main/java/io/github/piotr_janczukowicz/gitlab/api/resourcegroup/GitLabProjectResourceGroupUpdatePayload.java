package io.github.piotr_janczukowicz.gitlab.api.resourcegroup;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdResourceGroupsKey}.
 *
 * @param processMode the process mode
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdResourceGroupsKey/requestBody")
public record GitLabProjectResourceGroupUpdatePayload(
        @Nullable GitLabProjectResourceGroupUpdateProcessMode processMode) {}
