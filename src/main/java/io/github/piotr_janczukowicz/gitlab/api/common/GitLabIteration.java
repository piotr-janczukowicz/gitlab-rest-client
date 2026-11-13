package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.time.LocalDate;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab iteration.
 *
 * @param id the id
 * @param iid the iid
 * @param sequence the sequence
 * @param groupId the group id
 * @param title the title
 * @param description the description
 * @param state the state
 * @param createdAt the created at
 * @param updatedAt the updated at
 * @param startDate the start date
 * @param dueDate the due date
 * @param webUrl the web url
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesIteration")
public record GitLabIteration(
        @Nullable Long id,
        @Nullable Long iid,
        @Nullable Integer sequence,
        @Nullable Long groupId,
        @Nullable String title,
        @Nullable String description,
        @Nullable Integer state,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt,
        @Nullable LocalDate startDate,
        @Nullable LocalDate dueDate,
        @Nullable String webUrl) {}
