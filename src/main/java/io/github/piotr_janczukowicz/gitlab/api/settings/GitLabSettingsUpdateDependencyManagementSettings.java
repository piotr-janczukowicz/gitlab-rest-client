package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab settings update dependency management settings of a GitLab resource.
 *
 * @param securityUpdateSchedulerMaxConcurrency the security update scheduler max concurrency
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ApplicationSettings/requestBody/properties/dependency_management_settings")
public record GitLabSettingsUpdateDependencyManagementSettings(
        @Nullable Integer securityUpdateSchedulerMaxConcurrency) {}
