package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab sshkey.
 *
 * @param id the id
 * @param title the title
 * @param createdAt the created at
 * @param expiresAt the expires at
 * @param lastUsedAt the last used at
 * @param key the key
 * @param usageType the usage type
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesSSHKey")
public record GitLabSSHKey(
        @Nullable Long id,
        @Nullable String title,
        @Nullable Instant createdAt,
        @Nullable Instant expiresAt,
        @Nullable Instant lastUsedAt,
        @Nullable String key,
        @Nullable String usageType) {}
