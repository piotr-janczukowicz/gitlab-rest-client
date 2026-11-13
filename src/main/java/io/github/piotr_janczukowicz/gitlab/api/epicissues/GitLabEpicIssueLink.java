package io.github.piotr_janczukowicz.gitlab.api.epicissues;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabIssueBasic;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab epic issue link.
 *
 * @param id the id
 * @param relativePosition the relative position
 * @param epic the epic
 * @param issue the issue
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesEpicIssueLink")
public record GitLabEpicIssueLink(
        @Nullable Long id,
        @Nullable Integer relativePosition,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> epic,

        @Nullable GitLabIssueBasic issue) {}
