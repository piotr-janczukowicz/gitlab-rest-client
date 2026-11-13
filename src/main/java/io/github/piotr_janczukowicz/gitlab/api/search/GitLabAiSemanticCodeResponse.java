package io.github.piotr_janczukowicz.gitlab.api.search;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ai semantic code response.
 *
 * @param confidence the confidence
 * @param results the results
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesAiSemanticCodeResponse")
public record GitLabAiSemanticCodeResponse(
        @Nullable String confidence, @Nullable List<GitLabAiSemanticCodeGroupedResult> results) {}
