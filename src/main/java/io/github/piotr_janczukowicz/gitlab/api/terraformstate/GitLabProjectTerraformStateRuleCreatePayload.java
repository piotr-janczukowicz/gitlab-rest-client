package io.github.piotr_janczukowicz.gitlab.api.terraformstate;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdTerraformStateProtectionRules}.
 *
 * @param stateName the state name
 * @param minimumAccessLevelForWrite the minimum access level for write
 * @param allowedFrom the allowed from
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdTerraformStateProtectionRules/requestBody")
public record GitLabProjectTerraformStateRuleCreatePayload(
        @Nullable String stateName,
        GitLabProjectTerraformStateRuleCreateMinimumAccessLevelForWrite minimumAccessLevelForWrite,
        @Nullable GitLabProjectTerraformStateRuleCreateAllowedFrom allowedFrom) {
    public GitLabProjectTerraformStateRuleCreatePayload {
        requireMaxLengthIfPresent(stateName, 255, "stateName");
        requireNonNull(minimumAccessLevelForWrite, "minimumAccessLevelForWrite");
    }
}
