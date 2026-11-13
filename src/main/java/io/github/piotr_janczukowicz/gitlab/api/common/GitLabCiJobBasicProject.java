package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab ci job basic project of a GitLab resource.
 *
 * @param ciJobTokenScopeEnabled the ci job token scope enabled
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiJobBasic/properties/project")
public record GitLabCiJobBasicProject(@Nullable String ciJobTokenScopeEnabled) {}
