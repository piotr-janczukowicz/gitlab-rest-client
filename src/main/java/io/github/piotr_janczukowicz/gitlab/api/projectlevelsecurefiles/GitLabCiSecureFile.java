package io.github.piotr_janczukowicz.gitlab.api.projectlevelsecurefiles;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ci secure file.
 *
 * @param id the id
 * @param name the name
 * @param checksum the checksum
 * @param checksumAlgorithm the checksum algorithm
 * @param createdAt the created at
 * @param expiresAt the expires at
 * @param metadata the metadata
 * @param fileExtension the file extension
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiSecureFile")
public record GitLabCiSecureFile(
        @Nullable Long id,
        @Nullable String name,
        @Nullable String checksum,
        @Nullable String checksumAlgorithm,
        @Nullable Instant createdAt,
        @Nullable Instant expiresAt,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> metadata,

        @Nullable String fileExtension) {}
