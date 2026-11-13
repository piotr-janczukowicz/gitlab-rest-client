package io.github.piotr_janczukowicz.gitlab.api.jobsartifacts;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ci job artifact entry.
 *
 * @param name the name
 * @param path the path
 * @param type the type
 * @param size the size
 * @param mode the mode
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiJobArtifactEntry")
public record GitLabCiJobArtifactEntry(
        @Nullable String name,
        @Nullable String path,
        @Nullable GitLabCiJobArtifactEntryType type,
        @Nullable Long size,
        @Nullable String mode) {}
