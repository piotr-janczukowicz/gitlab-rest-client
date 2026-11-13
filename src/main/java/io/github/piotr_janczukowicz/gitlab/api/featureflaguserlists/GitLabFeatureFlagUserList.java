package io.github.piotr_janczukowicz.gitlab.api.featureflaguserlists;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab feature flag user list.
 *
 * @param id the id
 * @param iid the iid
 * @param name the name
 * @param userXids the user xids
 * @param projectId the project id
 * @param createdAt the created at
 * @param updatedAt the updated at
 * @param path the path
 * @param editPath the edit path
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesFeatureFlagUserList")
public record GitLabFeatureFlagUserList(
        @Nullable Long id,
        @Nullable Long iid,
        @Nullable String name,
        @Nullable String userXids,
        @Nullable Long projectId,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt,
        @Nullable String path,
        @Nullable String editPath) {}
