package io.github.piotr_janczukowicz.gitlab.api.organizations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4OrganizationsIdTransferUsers}.
 *
 * @param userIds the user ids
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4OrganizationsIdTransferUsers/requestBody")
public record GitLabOrganizationsCreateTransferUserPayload(
        @Nullable List<Long> userIds) {
    public GitLabOrganizationsCreateTransferUserPayload {
        if (userIds != null) {
            userIds = List.copyOf(userIds);
        }
    }
}
