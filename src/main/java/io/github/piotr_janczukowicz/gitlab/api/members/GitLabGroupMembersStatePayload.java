package io.github.piotr_janczukowicz.gitlab.api.members;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;

/**
 * Request body of the operation {@code putApiV4GroupsIdMembersUserIdState}.
 *
 * @param state the state
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4GroupsIdMembersUserIdState/requestBody")
public record GitLabGroupMembersStatePayload(GitLabGroupMembersStateState state) {
    public GitLabGroupMembersStatePayload {
        requireNonNull(state, "state");
    }
}
