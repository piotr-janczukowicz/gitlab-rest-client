package io.github.piotr_janczukowicz.gitlab.api.organizations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab organization.
 *
 * @param id the id
 * @param uuid the uuid
 * @param name the name
 * @param path the path
 * @param description the description
 * @param visibility the visibility
 * @param createdAt the created at
 * @param updatedAt the updated at
 * @param webUrl the web url
 * @param avatarUrl the avatar url
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesOrganizationsOrganization")
public record GitLabOrganization(
        @Nullable Long id,
        @Nullable String uuid,
        @Nullable String name,
        @Nullable String path,
        @Nullable String description,
        @Nullable String visibility,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt,
        @Nullable String webUrl,
        @Nullable String avatarUrl) {}
