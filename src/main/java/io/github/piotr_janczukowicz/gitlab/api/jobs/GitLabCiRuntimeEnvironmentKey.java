package io.github.piotr_janczukowicz.gitlab.api.jobs;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ci runtime environment key.
 *
 * @param runtimeEnvironmentKey the runtime environment key
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiRuntimeEnvironmentKey")
public record GitLabCiRuntimeEnvironmentKey(@Nullable String runtimeEnvironmentKey) {}
