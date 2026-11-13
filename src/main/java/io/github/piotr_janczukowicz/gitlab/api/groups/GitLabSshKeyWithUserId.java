package io.github.piotr_janczukowicz.gitlab.api.groups;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ssh key with user id.
 *
 * @param id the id
 * @param title the title
 * @param createdAt the created at
 * @param expiresAt the expires at
 * @param lastUsedAt the last used at
 * @param usageType the usage type
 * @param userId the user id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesSshKeyWithUserId")
public record GitLabSshKeyWithUserId(
        @Nullable Long id,
        @Nullable String title,
        @Nullable Instant createdAt,
        @Nullable Instant expiresAt,
        @Nullable Instant lastUsedAt,
        @Nullable String usageType,
        @Nullable Long userId) {}
