package io.github.piotr_janczukowicz.gitlab.api.namespaces;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab namespace storage limit exclusion.
 *
 * @param id the id
 * @param namespaceId the namespace id
 * @param namespaceName the namespace name
 * @param reason the reason
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesNamespacesStorageLimitExclusion")
public record GitLabNamespaceStorageLimitExclusion(
        @Nullable Long id,
        @Nullable Long namespaceId,
        @Nullable String namespaceName,
        @Nullable String reason) {}
