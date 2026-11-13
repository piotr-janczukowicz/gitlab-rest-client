package io.github.piotr_janczukowicz.gitlab.api.jobs;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ci job request runner info.
 *
 * @param uuid the uuid
 * @param timeout the timeout
 * @param runnerSessionUrl the runner session url
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiJobRequestRunnerInfo")
public record GitLabCiJobRequestRunnerInfo(
        @Nullable String uuid,
        @Nullable String timeout,
        @Nullable String runnerSessionUrl) {}
