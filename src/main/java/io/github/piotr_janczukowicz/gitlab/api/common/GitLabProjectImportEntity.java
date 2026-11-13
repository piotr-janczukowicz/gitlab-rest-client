package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab project import entity.
 *
 * @param id the id
 * @param name the name
 * @param fullPath the full path
 * @param fullName the full name
 * @param refsUrl the refs url
 * @param forked the forked
 * @param importSource the import source
 * @param importStatus the import status
 * @param humanImportStatusName the human import status name
 * @param providerLink the provider link
 * @param importError the import error
 * @param importWarning the import warning
 * @param relationType the relation type
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/ProjectImportEntity")
public record GitLabProjectImportEntity(
        @Nullable Long id,
        @Nullable String name,
        @Nullable String fullPath,
        @Nullable String fullName,
        @Nullable String refsUrl,
        @Nullable Boolean forked,
        @Nullable String importSource,
        @Nullable GitLabProjectImportEntityImportStatus importStatus,
        @Nullable String humanImportStatusName,
        @Nullable String providerLink,
        @Nullable String importError,
        @Nullable String importWarning,
        @Nullable String relationType) {}
