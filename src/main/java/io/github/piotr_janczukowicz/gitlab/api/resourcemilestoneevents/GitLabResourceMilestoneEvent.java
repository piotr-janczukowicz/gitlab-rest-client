package io.github.piotr_janczukowicz.gitlab.api.resourcemilestoneevents;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMilestone;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab resource milestone event.
 *
 * @param id the id
 * @param user the user
 * @param createdAt the created at
 * @param resourceType the resource type
 * @param resourceId the resource id
 * @param milestone the milestone
 * @param action the action
 * @param state the state
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesResourceMilestoneEvent")
public record GitLabResourceMilestoneEvent(
        @Nullable Long id,
        @Nullable GitLabUserBasic user,
        @Nullable Instant createdAt,
        @Nullable String resourceType,
        @Nullable Long resourceId,
        @Nullable GitLabMilestone milestone,
        @Nullable String action,
        @Nullable String state) {}
