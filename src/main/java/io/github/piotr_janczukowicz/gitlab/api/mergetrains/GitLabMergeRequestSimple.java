package io.github.piotr_janczukowicz.gitlab.api.mergetrains;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab merge request simple.
 *
 * @param id the id
 * @param iid the iid
 * @param projectId the project id
 * @param title the title
 * @param description the description
 * @param state the state
 * @param createdAt the created at
 * @param updatedAt the updated at
 * @param webUrl the web url
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesMergeRequestSimple")
public record GitLabMergeRequestSimple(
        @Nullable Long id,
        @Nullable Long iid,
        @Nullable Long projectId,
        @Nullable String title,
        @Nullable String description,
        @Nullable String state,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt,
        @Nullable String webUrl) {}
