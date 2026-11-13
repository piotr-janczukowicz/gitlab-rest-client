package io.github.piotr_janczukowicz.gitlab.api.projectcicdjobtokenscope;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab project scope link.
 *
 * @param sourceProjectId the source project id
 * @param targetProjectId the target project id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesProjectScopeLink")
public record GitLabProjectScopeLink(
        @Nullable Long sourceProjectId, @Nullable Long targetProjectId) {}
