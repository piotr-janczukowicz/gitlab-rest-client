package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab container expiration policy.
 *
 * @param cadence the cadence
 * @param enabled the enabled
 * @param keepN the keep n
 * @param olderThan the older than
 * @param nameRegex the name regex
 * @param nameRegexKeep the name regex keep
 * @param nextRunAt the next run at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesContainerExpirationPolicy")
public record GitLabContainerExpirationPolicy(
        @Nullable String cadence,
        @Nullable Boolean enabled,
        @Nullable Integer keepN,
        @Nullable String olderThan,
        @Nullable String nameRegex,
        @Nullable String nameRegexKeep,
        @Nullable Instant nextRunAt) {}
