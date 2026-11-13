package io.github.piotr_janczukowicz.gitlab.api.keys;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab gpg key.
 *
 * @param id the id
 * @param key the key
 * @param createdAt the created at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesGpgKey")
public record GitLabGpgKey(
        @Nullable Long id, @Nullable String key, @Nullable Instant createdAt) {}
