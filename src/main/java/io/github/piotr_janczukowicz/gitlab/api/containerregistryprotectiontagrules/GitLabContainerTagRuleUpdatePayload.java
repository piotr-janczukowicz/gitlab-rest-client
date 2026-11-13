package io.github.piotr_janczukowicz.gitlab.api.containerregistryprotectiontagrules;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code patchApiV4ProjectsIdRegistryProtectionTagRulesProtectionRuleId}.
 *
 * @param tagNamePattern the tag name pattern
 * @param minimumAccessLevelForPush the minimum access level for push
 * @param minimumAccessLevelForDelete the minimum access level for delete
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/patchApiV4ProjectsIdRegistryProtectionTagRulesProtectionRuleId/requestBody")
public record GitLabContainerTagRuleUpdatePayload(
        @Nullable String tagNamePattern,
        @Nullable GitLabContainerTagRuleUpdateMinimumAccessLevelForPush minimumAccessLevelForPush,
        @Nullable GitLabContainerTagRuleUpdateMinimumAccessLevelForDelete minimumAccessLevelForDelete) {}
