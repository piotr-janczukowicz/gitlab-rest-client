package io.github.piotr_janczukowicz.gitlab.api.jiraconnectsubscriptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4IntegrationsJiraConnectSubscriptions}.
 *
 * @param jwt the jwt
 * @param namespacePath the namespace path
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4IntegrationsJiraConnectSubscriptions/requestBody")
public record GitLabJiraConnectSubscriptionsCreateSubscriptionPayload(
        @Nullable String jwt, @Nullable String namespacePath) {}
