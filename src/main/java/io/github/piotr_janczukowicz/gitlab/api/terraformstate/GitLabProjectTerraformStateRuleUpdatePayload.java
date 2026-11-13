package io.github.piotr_janczukowicz.gitlab.api.terraformstate;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation
 * {@code patchApiV4ProjectsIdTerraformStateProtectionRulesTerraformStateProtectionRuleId}.
 *
 * @param stateName the state name
 * @param minimumAccessLevelForWrite the minimum access level for write
 * @param allowedFrom the allowed from
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/patchApiV4ProjectsIdTerraformStateProtectionRulesTerraformStateProtectionRuleId/requestBody")
public record GitLabProjectTerraformStateRuleUpdatePayload(
        @Nullable String stateName,
        @Nullable GitLabProjectTerraformStateRuleUpdateMinimumAccessLevelForWrite minimumAccessLevelForWrite,
        @Nullable GitLabProjectTerraformStateRuleUpdateAllowedFrom allowedFrom) {}
