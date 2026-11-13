package io.github.piotr_janczukowicz.gitlab.api.freezeperiods;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab freeze period.
 *
 * @param id the id
 * @param freezeStart the freeze start
 * @param freezeEnd the freeze end
 * @param cronTimezone the cron timezone
 * @param createdAt the created at
 * @param updatedAt the updated at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesFreezePeriod")
public record GitLabFreezePeriod(
        @Nullable Long id,
        @Nullable String freezeStart,
        @Nullable String freezeEnd,
        @Nullable String cronTimezone,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt) {}
