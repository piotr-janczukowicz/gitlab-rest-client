package io.github.piotr_janczukowicz.gitlab.api.projects;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.LocalDate;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdShare}.
 *
 * @param groupId the group id
 * @param groupAccess the group access
 * @param expiresAt the expires at
 * @param memberRoleId the member role id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdShare/requestBody")
public record GitLabProjectProjectsSharePayload(
        @Nullable Long groupId,
        GitLabProjectProjectsShareGroupAccess groupAccess,
        @Nullable LocalDate expiresAt,
        @Nullable Long memberRoleId) {
    public GitLabProjectProjectsSharePayload {
        requireNonNull(groupAccess, "groupAccess");
    }
}
