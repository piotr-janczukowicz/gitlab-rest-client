package io.github.piotr_janczukowicz.gitlab.api.terraformstate;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdTerraformStateNameLock}.
 *
 * @param id the id
 * @param operation the operation
 * @param info the info
 * @param who the who
 * @param version the version
 * @param created the created
 * @param path the path
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdTerraformStateNameLock/requestBody")
public record GitLabProjectTerraformStateCreateStateLockPayload(
        @Nullable @JsonProperty("ID") String id,
        @Nullable @JsonProperty("Operation") String operation,
        @Nullable @JsonProperty("Info") String info,
        @Nullable @JsonProperty("Who") String who,
        @Nullable @JsonProperty("Version") String version,
        @Nullable @JsonProperty("Created") String created,
        @Nullable @JsonProperty("Path") String path) {
    public GitLabProjectTerraformStateCreateStateLockPayload {
        requireMaxLengthIfPresent(id, 255, "id");
    }
}
