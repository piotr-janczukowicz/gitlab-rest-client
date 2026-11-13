package io.github.piotr_janczukowicz.gitlab.api.containerregistryprotectiontagrules;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdRegistryProtectionTagRules}.
 *
 * @param tagNamePattern the tag name pattern
 * @param minimumAccessLevelForPush the minimum access level for push
 * @param minimumAccessLevelForDelete the minimum access level for delete
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdRegistryProtectionTagRules/requestBody")
public record GitLabContainerTagRuleCreatePayload(
        @Nullable String tagNamePattern,
        GitLabContainerTagRuleCreateMinimumAccessLevelForPush minimumAccessLevelForPush,
        GitLabContainerTagRuleCreateMinimumAccessLevelForDelete minimumAccessLevelForDelete) {
    public GitLabContainerTagRuleCreatePayload {
        requireNonNull(minimumAccessLevelForPush, "minimumAccessLevelForPush");
        requireNonNull(minimumAccessLevelForDelete, "minimumAccessLevelForDelete");
    }
}
