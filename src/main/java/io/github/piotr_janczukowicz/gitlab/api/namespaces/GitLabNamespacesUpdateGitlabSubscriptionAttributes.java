package io.github.piotr_janczukowicz.gitlab.api.namespaces;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.LocalDate;
import org.jspecify.annotations.Nullable;

/**
 * The git lab namespaces update gitlab subscription attributes of a GitLab resource.
 *
 * @param startDate the start date
 * @param seats the seats
 * @param maxSeatsUsed the max seats used
 * @param planCode the plan code
 * @param endDate the end date
 * @param autoRenew the auto renew
 * @param trial the trial
 * @param trialEndsOn the trial ends on
 * @param trialStartsOn the trial starts on
 * @param trialExtensionType the trial extension type
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4NamespacesId/requestBody/properties/gitlab_subscription_attributes")
public record GitLabNamespacesUpdateGitlabSubscriptionAttributes(
        @Nullable LocalDate startDate,
        @Nullable Integer seats,
        @Nullable Integer maxSeatsUsed,
        @Nullable String planCode,
        @Nullable LocalDate endDate,
        @Nullable Boolean autoRenew,
        @Nullable Boolean trial,
        @Nullable LocalDate trialEndsOn,
        @Nullable LocalDate trialStartsOn,
        @Nullable Integer trialExtensionType) {}
