package io.github.piotr_janczukowicz.gitlab.api.orbit;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab orbit context.
 *
 * @param version the version
 * @param entities the entities
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesOrbitContext")
public record GitLabOrbitContext(
        @Nullable String version, @Nullable List<GitLabOrbitContextEntity> entities) {}
