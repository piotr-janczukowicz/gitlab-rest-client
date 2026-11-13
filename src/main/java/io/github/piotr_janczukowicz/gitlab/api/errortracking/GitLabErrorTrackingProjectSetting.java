package io.github.piotr_janczukowicz.gitlab.api.errortracking;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab error tracking project setting.
 *
 * @param active the active
 * @param projectName the project name
 * @param sentryExternalUrl the sentry external url
 * @param apiUrl the api url
 * @param integrated the integrated
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesErrorTrackingProjectSetting")
public record GitLabErrorTrackingProjectSetting(
        @Nullable Boolean active,
        @Nullable String projectName,
        @Nullable String sentryExternalUrl,
        @Nullable String apiUrl,
        @Nullable Boolean integrated) {}
