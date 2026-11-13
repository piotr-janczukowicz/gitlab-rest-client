package io.github.piotr_janczukowicz.gitlab.api.freezeperiods;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdFreezePeriodsFreezePeriodId}.
 *
 * @param freezeStart the freeze start
 * @param freezeEnd the freeze end
 * @param cronTimezone the cron timezone
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdFreezePeriodsFreezePeriodId/requestBody")
public record GitLabProjectFreezePeriodsUpdatePayload(
        @Nullable String freezeStart,
        @Nullable String freezeEnd,
        @Nullable String cronTimezone) {}
