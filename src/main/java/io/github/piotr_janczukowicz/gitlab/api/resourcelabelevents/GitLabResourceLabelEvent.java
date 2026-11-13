package io.github.piotr_janczukowicz.gitlab.api.resourcelabelevents;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabLabelBasic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab resource label event.
 *
 * @param id the id
 * @param user the user
 * @param createdAt the created at
 * @param resourceType the resource type
 * @param resourceId the resource id
 * @param label the label
 * @param action the action
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesResourceLabelEvent")
public record GitLabResourceLabelEvent(
        @Nullable Long id,
        @Nullable GitLabUserBasic user,
        @Nullable Instant createdAt,
        @Nullable String resourceType,
        @Nullable Long resourceId,
        @Nullable GitLabLabelBasic label,
        @Nullable String action) {}
