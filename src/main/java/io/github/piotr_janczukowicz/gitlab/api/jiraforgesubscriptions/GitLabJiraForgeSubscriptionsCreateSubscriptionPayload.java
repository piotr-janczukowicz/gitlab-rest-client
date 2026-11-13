package io.github.piotr_janczukowicz.gitlab.api.jiraforgesubscriptions;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4IntegrationsJiraForgeSubscriptions}.
 *
 * @param namespacePath the namespace path
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4IntegrationsJiraForgeSubscriptions/requestBody")
public record GitLabJiraForgeSubscriptionsCreateSubscriptionPayload(
        @Nullable String namespacePath) {
    public GitLabJiraForgeSubscriptionsCreateSubscriptionPayload {
        requireMaxLengthIfPresent(namespacePath, 255, "namespacePath");
    }
}
