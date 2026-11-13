package io.github.piotr_janczukowicz.gitlab.api.errortracking;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab error tracking client key.
 *
 * @param id the id
 * @param active the active
 * @param publicKey the public key
 * @param sentryDsn the sentry dsn
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesErrorTrackingClientKey")
public record GitLabErrorTrackingClientKey(
        @Nullable Long id,
        @Nullable Boolean active,
        @Nullable String publicKey,
        @Nullable String sentryDsn) {}
