package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab ci job project of a GitLab resource.
 *
 * @param ciJobTokenScopeEnabled the ci job token scope enabled
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiJob/properties/project")
public record GitLabCiJobProject(@Nullable Boolean ciJobTokenScopeEnabled) {}
