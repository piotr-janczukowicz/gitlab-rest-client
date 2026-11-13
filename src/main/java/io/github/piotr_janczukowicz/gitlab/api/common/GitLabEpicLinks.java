package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab epic links of a GitLab resource.
 *
 * @param self the self
 * @param epicIssues the epic issues
 * @param group the group
 * @param parent the parent
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesEpic/properties/_links")
public record GitLabEpicLinks(
        @Nullable String self,
        @Nullable String epicIssues,
        @Nullable String group,
        @Nullable String parent) {}
