package io.github.piotr_janczukowicz.gitlab.api.pullmirroring;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab pull mirror.
 *
 * @param id the id
 * @param updateStatus the update status
 * @param url the url
 * @param lastError the last error
 * @param lastUpdateAt the last update at
 * @param lastUpdateStartedAt the last update started at
 * @param lastSuccessfulUpdateAt the last successful update at
 * @param enabled the enabled
 * @param mirrorTriggerBuilds the mirror trigger builds
 * @param onlyMirrorProtectedBranches the only mirror protected branches
 * @param mirrorOverwritesDivergedBranches the mirror overwrites diverged branches
 * @param mirrorBranchRegex the mirror branch regex
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesPullMirror")
public record GitLabPullMirror(
        @Nullable Long id,
        @Nullable String updateStatus,
        @Nullable String url,
        @Nullable String lastError,
        @Nullable Instant lastUpdateAt,
        @Nullable Instant lastUpdateStartedAt,
        @Nullable Instant lastSuccessfulUpdateAt,
        @Nullable Boolean enabled,
        @Nullable Boolean mirrorTriggerBuilds,
        @Nullable Boolean onlyMirrorProtectedBranches,
        @Nullable Boolean mirrorOverwritesDivergedBranches,
        @Nullable String mirrorBranchRegex) {}
