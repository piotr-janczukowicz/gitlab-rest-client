package io.github.piotr_janczukowicz.gitlab.api.jiraforgeuserdelegation;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4IntegrationsJiraForgeUserDelegation}.
 *
 * @param accountId the account id
 * @param cloudId the cloud id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4IntegrationsJiraForgeUserDelegation/requestBody")
public record GitLabJiraForgeUserDelegationUserDelegationPayload(
        @Nullable String accountId, @Nullable String cloudId) {
    public GitLabJiraForgeUserDelegationUserDelegationPayload {
        requireMaxLengthIfPresent(accountId, 255, "accountId");
        requireMaxLengthIfPresent(cloudId, 255, "cloudId");
    }
}
