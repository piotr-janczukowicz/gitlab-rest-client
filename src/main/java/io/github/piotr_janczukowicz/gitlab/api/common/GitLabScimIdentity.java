package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab scim identity.
 *
 * @param externUid the extern uid
 * @param groupId the group id
 * @param active the active
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesScimIdentity")
public record GitLabScimIdentity(
        @Nullable String externUid,
        @Nullable Long groupId,
        @Nullable Boolean active) {}
