package io.github.piotr_janczukowicz.gitlab.api.jobs;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ci job request cache.
 *
 * @param key the key
 * @param untracked the untracked
 * @param paths the paths
 * @param policy the policy
 * @param when the when
 * @param fallbackKeys the fallback keys
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiJobRequestCache")
public record GitLabCiJobRequestCache(
        @Nullable String key,
        @Nullable Boolean untracked,
        @Nullable List<String> paths,
        @Nullable String policy,
        @Nullable String when,
        @Nullable List<String> fallbackKeys) {}
