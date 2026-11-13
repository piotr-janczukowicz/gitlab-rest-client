package io.github.piotr_janczukowicz.gitlab.api.topics;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4TopicsMerge}.
 *
 * @param sourceTopicId the source topic id
 * @param targetTopicId the target topic id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4TopicsMerge/requestBody")
public record GitLabTopicsMergePayload(
        @Nullable Long sourceTopicId, @Nullable Long targetTopicId) {}
