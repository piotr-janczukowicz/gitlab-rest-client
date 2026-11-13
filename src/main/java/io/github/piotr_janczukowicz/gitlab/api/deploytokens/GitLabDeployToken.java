package io.github.piotr_janczukowicz.gitlab.api.deploytokens;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab deploy token.
 *
 * @param id the id
 * @param name the name
 * @param username the username
 * @param expiresAt the expires at
 * @param scopes the scopes
 * @param revoked the revoked
 * @param expired the expired
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesDeployToken")
public record GitLabDeployToken(
        @Nullable Long id,
        @Nullable String name,
        @Nullable String username,
        @Nullable Instant expiresAt,
        @Nullable List<String> scopes,
        @Nullable Boolean revoked,
        @Nullable Boolean expired) {}
