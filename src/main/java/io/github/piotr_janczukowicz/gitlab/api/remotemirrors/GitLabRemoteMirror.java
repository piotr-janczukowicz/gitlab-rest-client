package io.github.piotr_janczukowicz.gitlab.api.remotemirrors;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab remote mirror.
 *
 * @param id the id
 * @param enabled the enabled
 * @param url the url
 * @param updateStatus the update status
 * @param lastUpdateAt the last update at
 * @param lastUpdateStartedAt the last update started at
 * @param lastSuccessfulUpdateAt the last successful update at
 * @param lastError the last error
 * @param onlyProtectedBranches the only protected branches
 * @param keepDivergentRefs the keep divergent refs
 * @param authMethod the auth method
 * @param hostKeys the host keys
 * @param mirrorBranchRegex the mirror branch regex
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesRemoteMirror")
public record GitLabRemoteMirror(
        @Nullable Long id,
        @Nullable Boolean enabled,
        @Nullable String url,
        @Nullable String updateStatus,
        @Nullable Instant lastUpdateAt,
        @Nullable Instant lastUpdateStartedAt,
        @Nullable Instant lastSuccessfulUpdateAt,
        @Nullable String lastError,
        @Nullable Boolean onlyProtectedBranches,
        @Nullable Boolean keepDivergentRefs,
        @Nullable String authMethod,
        @Nullable List<GitLabMirrorHostKey> hostKeys,
        @Nullable String mirrorBranchRegex) {}
