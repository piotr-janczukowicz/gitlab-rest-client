package io.github.piotr_janczukowicz.gitlab.api.packages;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabPackagePipeline;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab package file.
 *
 * @param id the id
 * @param packageId the package id
 * @param createdAt the created at
 * @param fileName the file name
 * @param size the size
 * @param fileMd5 the file md5
 * @param fileSha1 the file sha1
 * @param fileSha256 the file sha256
 * @param pipelines the pipelines
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesPackageFile")
public record GitLabPackageFile(
        @Nullable Long id,
        @Nullable Long packageId,
        @Nullable Instant createdAt,
        @Nullable String fileName,
        @Nullable Long size,
        @Nullable String fileMd5,
        @Nullable String fileSha1,
        @Nullable String fileSha256,
        @Nullable List<GitLabPackagePipeline> pipelines) {}
