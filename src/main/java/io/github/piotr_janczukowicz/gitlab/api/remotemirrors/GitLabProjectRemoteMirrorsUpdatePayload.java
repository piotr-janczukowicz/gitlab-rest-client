package io.github.piotr_janczukowicz.gitlab.api.remotemirrors;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdRemoteMirrorsMirrorId}.
 *
 * @param enabled the enabled
 * @param authMethod the auth method
 * @param keepDivergentRefs the keep divergent refs
 * @param onlyProtectedBranches the only protected branches
 * @param mirrorBranchRegex the mirror branch regex
 * @param hostKeys the host keys
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdRemoteMirrorsMirrorId/requestBody")
public record GitLabProjectRemoteMirrorsUpdatePayload(
        @Nullable Boolean enabled,
        @Nullable String authMethod,
        @Nullable Boolean keepDivergentRefs,
        @Nullable Boolean onlyProtectedBranches,
        @Nullable String mirrorBranchRegex,
        @Nullable List<String> hostKeys) {
    public GitLabProjectRemoteMirrorsUpdatePayload {
        if (hostKeys != null) {
            hostKeys = List.copyOf(hostKeys);
        }
    }
}
