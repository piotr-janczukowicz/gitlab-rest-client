package io.github.piotr_janczukowicz.gitlab.api.repositories;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab repository health last full repack.
 *
 * @param seconds the seconds
 * @param nanos the nanos
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesRepositoryHealthLastFullRepack")
public record GitLabRepositoryHealthLastFullRepack(
        @Nullable Integer seconds, @Nullable Integer nanos) {}
