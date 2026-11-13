package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab project repository storage.
 *
 * @param diskPath the disk path
 * @param projectId the project id
 * @param repositoryStorage the repository storage
 * @param createdAt the created at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesProjectRepositoryStorage")
public record GitLabProjectRepositoryStorage(
        @Nullable String diskPath,
        @Nullable Long projectId,
        @Nullable String repositoryStorage,
        @Nullable Instant createdAt) {}
