package io.github.piotr_janczukowicz.gitlab.api.epiclinks;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4GroupsIdDashEpicsEpicIidEpics}.
 *
 * @param title the title
 * @param confidential the confidential
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4GroupsIdDashEpicsEpicIidEpics/requestBody")
public record GitLabGroupEpicLinksCreatePayload(
        @Nullable String title, @Nullable Boolean confidential) {}
