package io.github.piotr_janczukowicz.gitlab.api.accessrequests;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4GroupsIdAccessRequestsUserIdApprove}.
 *
 * @param accessLevel the access level
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4GroupsIdAccessRequestsUserIdApprove/requestBody")
public record GitLabGroupAccessRequestsApprovePayload(
        @Nullable Integer accessLevel) {}
