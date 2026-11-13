package io.github.piotr_janczukowicz.gitlab.api.sidekiq;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireBetweenIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4AdminSidekiqConcurrencyLimitsWorkerClass}.
 *
 * @param limit the limit
 * @param ttl the ttl
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4AdminSidekiqConcurrencyLimitsWorkerClass/requestBody")
public record GitLabSidekiqUpdateConcurrencyLimitPayload(
        @Nullable Integer limit, @Nullable Integer ttl) {
    public GitLabSidekiqUpdateConcurrencyLimitPayload {
        requireBetweenIfPresent(ttl, 1, 86_400, "ttl");
    }
}
