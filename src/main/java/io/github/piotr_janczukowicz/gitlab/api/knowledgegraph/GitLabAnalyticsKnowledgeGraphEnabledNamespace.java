package io.github.piotr_janczukowicz.gitlab.api.knowledgegraph;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab analytics knowledge graph enabled namespace.
 *
 * @param id the id
 * @param rootNamespaceId the root namespace id
 * @param createdAt the created at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesAnalyticsKnowledgeGraphEnabledNamespace")
public record GitLabAnalyticsKnowledgeGraphEnabledNamespace(
        @Nullable Long id,
        @Nullable Long rootNamespaceId,
        @Nullable Instant createdAt) {}
