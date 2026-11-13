package io.github.piotr_janczukowicz.gitlab.api.deploykeys;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProjectIdentity;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab deploy keys project.
 *
 * @param id the id
 * @param title the title
 * @param createdAt the created at
 * @param expiresAt the expires at
 * @param lastUsedAt the last used at
 * @param key the key
 * @param usageType the usage type
 * @param fingerprint the fingerprint
 * @param fingerprintSha256 the fingerprint sha256
 * @param projectsWithWriteAccess the projects with write access
 * @param projectsWithReadonlyAccess the projects with readonly access
 * @param canPush the can push
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesDeployKeysProject")
public record GitLabDeployKeysProject(
        @Nullable Long id,
        @Nullable String title,
        @Nullable Instant createdAt,
        @Nullable Instant expiresAt,
        @Nullable Instant lastUsedAt,
        @Nullable String key,
        @Nullable String usageType,
        @Nullable String fingerprint,
        @Nullable String fingerprintSha256,
        @Nullable List<GitLabProjectIdentity> projectsWithWriteAccess,
        @Nullable List<GitLabProjectIdentity> projectsWithReadonlyAccess,
        @Nullable Boolean canPush) {}
