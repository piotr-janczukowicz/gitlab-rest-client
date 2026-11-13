package io.github.piotr_janczukowicz.gitlab.api.jiraforgesubscriptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab jira connect group entity.
 *
 * @param name the name
 * @param avatarUrl the avatar url
 * @param fullName the full name
 * @param description the description
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/JiraConnectGroupEntity")
public record GitLabJiraConnectGroupEntity(
        @Nullable String name,
        @Nullable String avatarUrl,
        @Nullable String fullName,
        @Nullable String description) {}
