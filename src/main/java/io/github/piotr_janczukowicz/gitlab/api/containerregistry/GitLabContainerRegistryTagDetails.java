package io.github.piotr_janczukowicz.gitlab.api.containerregistry;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab container registry tag details.
 *
 * @param name the name
 * @param path the path
 * @param location the location
 * @param revision the revision
 * @param shortRevision the short revision
 * @param digest the digest
 * @param createdAt the created at
 * @param totalSize the total size
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesContainerRegistryTagDetails")
public record GitLabContainerRegistryTagDetails(
        @Nullable String name,
        @Nullable String path,
        @Nullable String location,
        @Nullable String revision,
        @Nullable String shortRevision,
        @Nullable String digest,
        @Nullable Instant createdAt,
        @Nullable Long totalSize) {}
