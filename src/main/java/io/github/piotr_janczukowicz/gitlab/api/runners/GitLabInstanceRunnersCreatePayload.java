package io.github.piotr_janczukowicz.gitlab.api.runners;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4Runners}.
 *
 * @param token the token
 * @param description the description
 * @param maintainerNote the maintainer note
 * @param maintenanceNote the maintenance note
 * @param info the info
 * @param active the active
 * @param paused the paused
 * @param locked the locked
 * @param accessLevel the access level
 * @param runUntagged the run untagged
 * @param tagList the tag list
 * @param maximumTimeout the maximum timeout
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4Runners/requestBody")
public record GitLabInstanceRunnersCreatePayload(
        @Nullable String token,
        @Nullable String description,
        @Nullable String maintainerNote,
        @Nullable String maintenanceNote,
        @Nullable GitLabInstanceRunnersCreateInfo info,
        @Nullable Boolean active,
        @Nullable Boolean paused,
        @Nullable Boolean locked,
        @Nullable GitLabInstanceRunnersCreateAccessLevel accessLevel,
        @Nullable Boolean runUntagged,
        @Nullable List<String> tagList,
        @Nullable Integer maximumTimeout) {
    public GitLabInstanceRunnersCreatePayload {
        if (tagList != null) {
            tagList = List.copyOf(tagList);
        }
    }

    /**
     * Describes this record without its secret.
     *
     * @return text with {@code token} redacted
     */
    @Override
    public String toString() {
        return "GitLabInstanceRunnersCreatePayload[" + "token=<redacted>" + ", description=" + description
                + ", maintainerNote=" + maintainerNote + ", maintenanceNote=" + maintenanceNote + ", info=" + info
                + ", active=" + active + ", paused=" + paused + ", locked=" + locked + ", accessLevel=" + accessLevel
                + ", runUntagged=" + runUntagged + ", tagList=" + tagList + ", maximumTimeout=" + maximumTimeout + "]";
    }
}
