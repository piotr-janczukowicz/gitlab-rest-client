package io.github.piotr_janczukowicz.gitlab.api.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab membership.
 *
 * @param sourceId the source id
 * @param sourceName the source name
 * @param sourceType the source type
 * @param accessLevel the access level
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesMembership")
public record GitLabMembership(
        @Nullable String sourceId,
        @Nullable String sourceName,
        @Nullable String sourceType,
        @Nullable String accessLevel) {}
