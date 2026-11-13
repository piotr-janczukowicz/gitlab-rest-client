package io.github.piotr_janczukowicz.gitlab.api.namespaces;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ci minutes usage.
 *
 * @param totalMinutesUsed the total minutes used
 * @param monthlyMinutesUsed the monthly minutes used
 * @param purchasedMinutesUsed the purchased minutes used
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiMinutesUsage")
public record GitLabCiMinutesUsage(
        @Nullable Integer totalMinutesUsed,
        @Nullable Integer monthlyMinutesUsed,
        @Nullable Integer purchasedMinutesUsed) {}
