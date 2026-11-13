package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab package version.
 *
 * @param id the id
 * @param version the version
 * @param createdAt the created at
 * @param tags the tags
 * @param pipeline the pipeline
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesPackageVersion")
public record GitLabPackageVersion(
        @Nullable Long id,
        @Nullable String version,

        @Nullable @SuppressSchemaTypeMismatch("type rule: date-time (created_at)")
        Instant createdAt,

        @Nullable List<GitLabPackageVersionTag> tags,
        @Nullable GitLabPackagePipeline pipeline) {}
