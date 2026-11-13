package io.github.piotr_janczukowicz.gitlab.api.complianceandpolicysettings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4AdminSecurityCompliancePolicySettings}.
 *
 * @param cspNamespaceId the csp namespace id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4AdminSecurityCompliancePolicySettings/requestBody")
public record GitLabComplianceAndPolicySettingsUpdatePayload(
        @Nullable Long cspNamespaceId) {}
