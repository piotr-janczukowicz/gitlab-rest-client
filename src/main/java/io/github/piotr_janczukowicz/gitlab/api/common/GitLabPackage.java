package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab package.
 *
 * @param id the id
 * @param name the name
 * @param conanPackageName the conan package name
 * @param version the version
 * @param packageType the package type
 * @param status the status
 * @param links the links
 * @param createdAt the created at
 * @param lastDownloadedAt the last downloaded at
 * @param creatorId the creator id
 * @param projectId the project id
 * @param projectPath the project path
 * @param tags the tags
 * @param pipeline the pipeline
 * @param pipelines the pipelines
 * @param versions the versions
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesPackage")
public record GitLabPackage(
        @Nullable Long id,
        @Nullable String name,
        @Nullable String conanPackageName,
        @Nullable String version,
        @Nullable String packageType,
        @Nullable String status,
        @Nullable @JsonProperty("_links") GitLabPackageLinks links,
        @Nullable Instant createdAt,
        @Nullable Instant lastDownloadedAt,
        @Nullable Long creatorId,
        @Nullable Long projectId,
        @Nullable String projectPath,
        @Nullable List<GitLabPackageTag> tags,
        @Nullable GitLabPackagePipeline pipeline,
        @Nullable List<GitLabPackagePipeline> pipelines,
        @Nullable List<GitLabPackageVersion> versions) {}
