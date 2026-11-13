package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab diff refs.
 *
 * @param baseSha the base sha
 * @param headSha the head sha
 * @param startSha the start sha
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesDiffRefs")
public record GitLabDiffRefs(
        @Nullable String baseSha,
        @Nullable String headSha,
        @Nullable String startSha) {}
