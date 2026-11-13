package io.github.piotr_janczukowicz.gitlab.api.topics;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab project topic.
 *
 * @param id the id
 * @param name the name
 * @param title the title
 * @param description the description
 * @param totalProjectsCount the total projects count
 * @param organizationId the organization id
 * @param avatarUrl the avatar url
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesProjectsTopic")
public record GitLabProjectTopic(
        @Nullable Long id,
        @Nullable String name,
        @Nullable String title,
        @Nullable String description,
        @Nullable Integer totalProjectsCount,
        @Nullable Long organizationId,
        @Nullable String avatarUrl) {}
