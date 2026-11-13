package io.github.piotr_janczukowicz.gitlab.api.jobs;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ci job request step.
 *
 * @param name the name
 * @param script the script
 * @param timeout the timeout
 * @param when the when
 * @param allowFailure the allow failure
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiJobRequestStep")
public record GitLabCiJobRequestStep(
        @Nullable String name,
        @Nullable List<String> script,
        @Nullable Integer timeout,
        @Nullable String when,
        @Nullable Boolean allowFailure) {}
