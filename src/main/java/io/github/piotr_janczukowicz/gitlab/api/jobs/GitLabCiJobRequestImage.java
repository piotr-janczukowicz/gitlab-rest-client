package io.github.piotr_janczukowicz.gitlab.api.jobs;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ci job request image.
 *
 * @param name the name
 * @param entrypoint the entrypoint
 * @param ports the ports
 * @param executorOpts the executor opts
 * @param pullPolicy the pull policy
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiJobRequestImage")
public record GitLabCiJobRequestImage(
        @Nullable String name,
        @Nullable String entrypoint,
        @Nullable List<GitLabCiJobRequestPort> ports,
        @Nullable String executorOpts,
        @Nullable String pullPolicy) {}
