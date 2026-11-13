package io.github.piotr_janczukowicz.gitlab.api.namespaces;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab gitlab subscription.
 *
 * @param plan the plan
 * @param usage the usage
 * @param billing the billing
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesGitlabSubscription")
public record GitLabGitlabSubscription(
        @Nullable GitLabGitlabSubscriptionPlan plan,
        @Nullable GitLabGitlabSubscriptionUsage usage,
        @Nullable GitLabGitlabSubscriptionBilling billing) {}
