package io.github.piotr_janczukowicz.gitlab.api.protectedpackages;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdPackagesProtectionRules}.
 *
 * @param packageNamePattern the package name pattern
 * @param packageType the package type
 * @param minimumAccessLevelForDelete the minimum access level for delete
 * @param minimumAccessLevelForPush the minimum access level for push
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdPackagesProtectionRules/requestBody")
public record GitLabProjectProtectedPackagesCreatePayload(
        @Nullable String packageNamePattern,
        GitLabProjectProtectedPackagesCreatePackageType packageType,
        @Nullable GitLabProjectProtectedPackagesCreateMinimumAccessLevelForDelete minimumAccessLevelForDelete,
        @Nullable GitLabProjectProtectedPackagesCreateMinimumAccessLevelForPush minimumAccessLevelForPush) {
    public GitLabProjectProtectedPackagesCreatePayload {
        requireNonNull(packageType, "packageType");
    }
}
