package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab milestone with stats.
 *
 * @param id the id
 * @param iid the iid
 * @param projectId the project id
 * @param groupId the group id
 * @param title the title
 * @param description the description
 * @param state the state
 * @param createdAt the created at
 * @param updatedAt the updated at
 * @param dueDate the due date
 * @param startDate the start date
 * @param expired the expired
 * @param webUrl the web url
 * @param issueStats the issue stats
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesMilestoneWithStats")
public record GitLabMilestoneWithStats(
        @Nullable Long id,
        @Nullable Long iid,
        @Nullable Long projectId,
        @Nullable String groupId,
        @Nullable String title,
        @Nullable String description,
        @Nullable String state,

        @Nullable @SuppressSchemaTypeMismatch("type rule: date-time (created_at)")
        Instant createdAt,

        @Nullable @SuppressSchemaTypeMismatch("type rule: date-time (updated_at)")
        Instant updatedAt,

        @Nullable String dueDate,
        @Nullable String startDate,
        @Nullable Boolean expired,
        @Nullable String webUrl,
        @Nullable GitLabMilestoneWithStatsIssueStats issueStats) {}
