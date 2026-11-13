package io.github.piotr_janczukowicz.gitlab.api.commits;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab basic ref.
 *
 * @param type the type
 * @param name the name
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesBasicRef")
public record GitLabBasicRef(
        @Nullable String type, @Nullable String name) {}
