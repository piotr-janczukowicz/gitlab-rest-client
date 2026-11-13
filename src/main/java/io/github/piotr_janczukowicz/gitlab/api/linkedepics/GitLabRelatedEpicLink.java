package io.github.piotr_janczukowicz.gitlab.api.linkedepics;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabEpic;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab related epic link.
 *
 * @param id the id
 * @param sourceEpic the source epic
 * @param targetEpic the target epic
 * @param linkType the link type
 * @param createdAt the created at
 * @param updatedAt the updated at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesRelatedEpicLink")
public record GitLabRelatedEpicLink(
        @Nullable Long id,
        @Nullable GitLabEpic sourceEpic,
        @Nullable GitLabEpic targetEpic,
        @Nullable String linkType,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt) {}
