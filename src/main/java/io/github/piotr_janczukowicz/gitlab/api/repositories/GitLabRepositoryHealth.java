package io.github.piotr_janczukowicz.gitlab.api.repositories;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab repository health.
 *
 * @param size the size
 * @param references the references
 * @param objects the objects
 * @param commitGraph the commit graph
 * @param bitmap the bitmap
 * @param multiPackIndex the multi pack index
 * @param multiPackIndexBitmap the multi pack index bitmap
 * @param alternates the alternates
 * @param isObjectPool the is object pool
 * @param lastFullRepack the last full repack
 * @param updatedAt the updated at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesRepositoryHealth")
public record GitLabRepositoryHealth(
        @Nullable Long size,
        @Nullable GitLabRepositoryHealthReferences references,
        @Nullable GitLabRepositoryHealthObjects objects,
        @Nullable GitLabRepositoryHealthCommitGraph commitGraph,
        @Nullable GitLabRepositoryHealthBitmap bitmap,
        @Nullable GitLabRepositoryHealthMultiPackIndex multiPackIndex,
        @Nullable GitLabRepositoryHealthBitmap multiPackIndexBitmap,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> alternates,

        @Nullable Boolean isObjectPool,
        @Nullable GitLabRepositoryHealthLastFullRepack lastFullRepack,
        @Nullable Instant updatedAt) {}
