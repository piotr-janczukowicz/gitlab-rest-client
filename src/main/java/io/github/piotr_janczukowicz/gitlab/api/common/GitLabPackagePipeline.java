package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab package pipeline.
 *
 * @param id the id
 * @param iid the iid
 * @param projectId the project id
 * @param sha the sha
 * @param ref the ref
 * @param status the status
 * @param source the source
 * @param createdAt the created at
 * @param updatedAt the updated at
 * @param webUrl the web url
 * @param user the user
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesPackagePipeline")
public record GitLabPackagePipeline(
        @Nullable Long id,
        @Nullable Long iid,
        @Nullable Long projectId,
        @Nullable String sha,
        @Nullable String ref,
        @Nullable String status,
        @Nullable String source,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt,
        @Nullable String webUrl,
        @Nullable GitLabUserBasic user) {}
