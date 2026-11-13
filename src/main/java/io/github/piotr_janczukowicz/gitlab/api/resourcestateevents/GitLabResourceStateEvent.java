package io.github.piotr_janczukowicz.gitlab.api.resourcestateevents;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab resource state event.
 *
 * @param id the id
 * @param user the user
 * @param createdAt the created at
 * @param resourceType the resource type
 * @param resourceId the resource id
 * @param sourceCommit the source commit
 * @param sourceMergeRequestId the source merge request id
 * @param state the state
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesResourceStateEvent")
public record GitLabResourceStateEvent(
        @Nullable Long id,
        @Nullable GitLabUserBasic user,
        @Nullable Instant createdAt,
        @Nullable String resourceType,
        @Nullable Long resourceId,
        @Nullable String sourceCommit,
        @Nullable Long sourceMergeRequestId,
        @Nullable String state) {}
