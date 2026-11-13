package io.github.piotr_janczukowicz.gitlab.api.license;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab gitlab license with active users.
 *
 * @param id the id
 * @param plan the plan
 * @param createdAt the created at
 * @param startsAt the starts at
 * @param expiresAt the expires at
 * @param historicalMax the historical max
 * @param maximumUserCount the maximum user count
 * @param licensee the licensee
 * @param addOns the add ons
 * @param expired the expired
 * @param overage the overage
 * @param userLimit the user limit
 * @param activeUsers the active users
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesGitlabLicenseWithActiveUsers")
public record GitLabGitlabLicenseWithActiveUsers(
        @Nullable Long id,
        @Nullable String plan,
        @Nullable Instant createdAt,
        @Nullable LocalDate startsAt,
        @Nullable LocalDate expiresAt,
        @Nullable Integer historicalMax,
        @Nullable Integer maximumUserCount,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> licensee,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> addOns,

        @Nullable Boolean expired,
        @Nullable Integer overage,
        @Nullable Integer userLimit,
        @Nullable Integer activeUsers) {}
