package io.github.piotr_janczukowicz.gitlab.api.datamanagement;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.CatalogSimpleXor;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab admin model.
 *
 * @param recordIdentifier the record identifier
 * @param modelClass the model class
 * @param createdAt the created at
 * @param fileSize the file size
 * @param checksumInformation the checksum information
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesAdminModel")
public record GitLabAdminModel(
        @Nullable @CatalogSimpleXor(GitLabAnnotationValues.XOR_STRING_INTEGER)
        String recordIdentifier,

        @Nullable String modelClass,
        @Nullable Instant createdAt,
        @Nullable Long fileSize,
        @Nullable GitLabAdminModelChecksumInformation checksumInformation) {}
