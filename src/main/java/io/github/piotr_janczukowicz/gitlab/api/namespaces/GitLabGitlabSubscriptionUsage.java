package io.github.piotr_janczukowicz.gitlab.api.namespaces;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab gitlab subscription usage of a GitLab resource.
 *
 * @param seatsInSubscription the seats in subscription
 * @param seatsInUse the seats in use
 * @param maxSeatsUsed the max seats used
 * @param seatsOwed the seats owed
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesGitlabSubscription/properties/usage")
public record GitLabGitlabSubscriptionUsage(
        @Nullable Integer seatsInSubscription,
        @Nullable Integer seatsInUse,
        @Nullable Integer maxSeatsUsed,
        @Nullable Integer seatsOwed) {}
