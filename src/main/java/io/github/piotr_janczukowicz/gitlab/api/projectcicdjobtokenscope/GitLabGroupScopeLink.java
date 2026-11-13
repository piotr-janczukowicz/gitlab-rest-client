package io.github.piotr_janczukowicz.gitlab.api.projectcicdjobtokenscope;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab group scope link.
 *
 * @param sourceProjectId the source project id
 * @param targetGroupId the target group id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesGroupScopeLink")
public record GitLabGroupScopeLink(
        @Nullable Long sourceProjectId, @Nullable Long targetGroupId) {}
