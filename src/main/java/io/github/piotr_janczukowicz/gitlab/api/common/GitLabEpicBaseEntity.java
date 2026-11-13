package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab epic base entity.
 *
 * @param id the id
 * @param iid the iid
 * @param title the title
 * @param url the url
 * @param groupId the group id
 * @param humanReadableEndDate the human readable end date
 * @param humanReadableTimestamp the human readable timestamp
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/EpicBaseEntity")
public record GitLabEpicBaseEntity(
        @Nullable Long id,
        @Nullable Long iid,
        @Nullable String title,
        @Nullable String url,
        @Nullable Long groupId,
        @Nullable String humanReadableEndDate,
        @Nullable String humanReadableTimestamp) {}
