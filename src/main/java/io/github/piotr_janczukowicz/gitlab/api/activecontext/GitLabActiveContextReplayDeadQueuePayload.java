package io.github.piotr_janczukowicz.gitlab.api.activecontext;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4AdminActiveContextDeadQueueReplay}.
 *
 * @param queue the queue
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4AdminActiveContextDeadQueueReplay/requestBody")
public record GitLabActiveContextReplayDeadQueuePayload(
        @Nullable String queue) {}
