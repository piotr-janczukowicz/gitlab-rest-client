package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab public group details.
 *
 * @param id the id
 * @param webUrl the web url
 * @param name the name
 * @param avatarUrl the avatar url
 * @param fullName the full name
 * @param fullPath the full path
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesPublicGroupDetails")
public record GitLabPublicGroupDetails(
        @Nullable Long id,
        @Nullable String webUrl,
        @Nullable String name,
        @Nullable String avatarUrl,
        @Nullable String fullName,
        @Nullable String fullPath) {}
