package io.github.piotr_janczukowicz.gitlab.api.runners;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4RunnersId}.
 *
 * @param description the description
 * @param active the active
 * @param paused the paused
 * @param tagList the tag list
 * @param runUntagged the run untagged
 * @param locked the locked
 * @param accessLevel the access level
 * @param maximumTimeout the maximum timeout
 * @param maintenanceNote the maintenance note
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4RunnersId/requestBody")
public record GitLabInstanceRunnersUpdatePayload(
        @Nullable String description,
        @Nullable Boolean active,
        @Nullable Boolean paused,
        @Nullable List<String> tagList,
        @Nullable Boolean runUntagged,
        @Nullable Boolean locked,
        @Nullable GitLabInstanceRunnersUpdateAccessLevel accessLevel,
        @Nullable Integer maximumTimeout,
        @Nullable String maintenanceNote) {
    public GitLabInstanceRunnersUpdatePayload {
        if (tagList != null) {
            tagList = List.copyOf(tagList);
        }
    }
}
