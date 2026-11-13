package io.github.piotr_janczukowicz.gitlab.api.epiclinks;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4GroupsIdDashEpicsEpicIidEpicsChildEpicId}.
 *
 * @param moveBeforeId the move before id
 * @param moveAfterId the move after id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4GroupsIdDashEpicsEpicIidEpicsChildEpicId/requestBody")
public record GitLabGroupEpicLinksUpdatePayload(
        @Nullable Long moveBeforeId, @Nullable Long moveAfterId) {}
