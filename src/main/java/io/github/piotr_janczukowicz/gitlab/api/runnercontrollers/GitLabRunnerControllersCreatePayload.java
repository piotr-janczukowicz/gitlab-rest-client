package io.github.piotr_janczukowicz.gitlab.api.runnercontrollers;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4RunnerControllers}.
 *
 * @param description the description
 * @param state the state
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4RunnerControllers/requestBody")
public record GitLabRunnerControllersCreatePayload(
        @Nullable String description, @Nullable GitLabRunnerControllersCreateState state) {}
