package io.github.piotr_janczukowicz.gitlab.api.search;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ai semantic code grouped result.
 *
 * @param path the path
 * @param blobId the blob id
 * @param fileUrl the file url
 * @param score the score
 * @param snippetRanges the snippet ranges
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesAiSemanticCodeGroupedResult")
public record GitLabAiSemanticCodeGroupedResult(
        @Nullable String path,
        @Nullable String blobId,
        @Nullable String fileUrl,
        @Nullable Double score,
        @Nullable List<GitLabAiSemanticCodeSnippetRange> snippetRanges) {}
