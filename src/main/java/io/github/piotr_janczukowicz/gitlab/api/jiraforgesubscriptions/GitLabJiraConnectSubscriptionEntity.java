package io.github.piotr_janczukowicz.gitlab.api.jiraforgesubscriptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab jira connect subscription entity.
 *
 * @param createdAt the created at
 * @param unlinkPath the unlink path
 * @param group the group
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/JiraConnectSubscriptionEntity")
public record GitLabJiraConnectSubscriptionEntity(
        @Nullable @SuppressSchemaTypeMismatch("type rule: date-time (created_at)")
        Instant createdAt,

        @Nullable String unlinkPath,
        @Nullable GitLabJiraConnectGroupEntity group) {}
