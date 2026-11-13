package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab relation import tracker.
 *
 * @param id the id
 * @param projectPath the project path
 * @param relation the relation
 * @param status the status
 * @param createdAt the created at
 * @param updatedAt the updated at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesRelationImportTracker")
public record GitLabRelationImportTracker(
        @Nullable Long id,
        @Nullable String projectPath,
        @Nullable String relation,
        @Nullable String status,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt) {}
