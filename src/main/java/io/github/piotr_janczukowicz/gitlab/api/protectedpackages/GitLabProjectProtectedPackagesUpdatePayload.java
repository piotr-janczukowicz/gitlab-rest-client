package io.github.piotr_janczukowicz.gitlab.api.protectedpackages;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code patchApiV4ProjectsIdPackagesProtectionRulesPackageProtectionRuleId}.
 *
 * @param packageNamePattern the package name pattern
 * @param packageType the package type
 * @param minimumAccessLevelForDelete the minimum access level for delete
 * @param minimumAccessLevelForPush the minimum access level for push
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/patchApiV4ProjectsIdPackagesProtectionRulesPackageProtectionRuleId/requestBody")
public record GitLabProjectProtectedPackagesUpdatePayload(
        @Nullable String packageNamePattern,
        @Nullable GitLabProjectProtectedPackagesUpdatePackageType packageType,
        @Nullable GitLabProjectProtectedPackagesUpdateMinimumAccessLevelForDelete minimumAccessLevelForDelete,
        @Nullable GitLabProjectProtectedPackagesUpdateMinimumAccessLevelForPush minimumAccessLevelForPush) {}
