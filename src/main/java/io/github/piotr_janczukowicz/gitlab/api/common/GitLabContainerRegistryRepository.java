package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab container registry repository.
 *
 * @param id the id
 * @param name the name
 * @param path the path
 * @param projectId the project id
 * @param location the location
 * @param createdAt the created at
 * @param cleanupPolicyStartedAt the cleanup policy started at
 * @param tagsCount the tags count
 * @param tags the tags
 * @param deleteApiPath the delete api path
 * @param size the size
 * @param status the status
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesContainerRegistryRepository")
public record GitLabContainerRegistryRepository(
        @Nullable Long id,
        @Nullable String name,
        @Nullable String path,
        @Nullable Long projectId,
        @Nullable String location,
        @Nullable Instant createdAt,
        @Nullable Instant cleanupPolicyStartedAt,
        @Nullable Integer tagsCount,
        @Nullable List<GitLabContainerRegistryTag> tags,
        @Nullable String deleteApiPath,
        @Nullable Long size,
        @Nullable String status) {}
