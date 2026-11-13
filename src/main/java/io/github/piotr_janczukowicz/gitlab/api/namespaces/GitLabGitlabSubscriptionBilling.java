package io.github.piotr_janczukowicz.gitlab.api.namespaces;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.LocalDate;
import org.jspecify.annotations.Nullable;

/**
 * The git lab gitlab subscription billing of a GitLab resource.
 *
 * @param subscriptionStartDate the subscription start date
 * @param subscriptionEndDate the subscription end date
 * @param trialEndsOn the trial ends on
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesGitlabSubscription/properties/billing")
public record GitLabGitlabSubscriptionBilling(
        @Nullable LocalDate subscriptionStartDate,
        @Nullable LocalDate subscriptionEndDate,
        @Nullable LocalDate trialEndsOn) {}
