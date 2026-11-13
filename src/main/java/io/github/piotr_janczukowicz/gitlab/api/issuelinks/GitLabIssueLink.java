package io.github.piotr_janczukowicz.gitlab.api.issuelinks;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabIssueBasic;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab issue link.
 *
 * @param id the id
 * @param sourceIssue the source issue
 * @param targetIssue the target issue
 * @param linkType the link type
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesIssueLink")
public record GitLabIssueLink(
        @Nullable Long id,
        @Nullable GitLabIssueBasic sourceIssue,
        @Nullable GitLabIssueBasic targetIssue,
        @Nullable String linkType) {}
