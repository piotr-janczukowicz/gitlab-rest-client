package io.github.piotr_janczukowicz.gitlab.api.resourcegroup;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ci resource group.
 *
 * @param id the id
 * @param key the key
 * @param processMode the process mode
 * @param createdAt the created at
 * @param updatedAt the updated at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiResourceGroup")
public record GitLabCiResourceGroup(
        @Nullable Long id,
        @Nullable String key,
        @Nullable String processMode,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt) {}
