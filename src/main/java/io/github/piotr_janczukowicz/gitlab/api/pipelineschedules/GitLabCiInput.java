package io.github.piotr_janczukowicz.gitlab.api.pipelineschedules;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ci input.
 *
 * @param name the name
 * @param value the value
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiInput")
public record GitLabCiInput(@Nullable String name, @Nullable String value) {}
