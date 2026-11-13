package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ci job artifact.
 *
 * @param fileType the file type
 * @param size the size
 * @param filename the filename
 * @param fileFormat the file format
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiJobArtifact")
public record GitLabCiJobArtifact(
        @Nullable GitLabCiJobArtifactFileType fileType,
        @Nullable Long size,
        @Nullable String filename,
        @Nullable GitLabCiJobArtifactFileFormat fileFormat) {}
