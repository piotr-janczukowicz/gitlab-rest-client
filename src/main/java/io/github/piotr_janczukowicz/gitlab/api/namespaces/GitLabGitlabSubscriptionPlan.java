package io.github.piotr_janczukowicz.gitlab.api.namespaces;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab gitlab subscription plan of a GitLab resource.
 *
 * @param code the code
 * @param name the name
 * @param trial the trial
 * @param autoRenew the auto renew
 * @param upgradable the upgradable
 * @param excludeGuests the exclude guests
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesGitlabSubscription/properties/plan")
public record GitLabGitlabSubscriptionPlan(
        @Nullable String code,
        @Nullable String name,
        @Nullable Boolean trial,
        @Nullable Boolean autoRenew,
        @Nullable Boolean upgradable,
        @Nullable Boolean excludeGuests) {}
