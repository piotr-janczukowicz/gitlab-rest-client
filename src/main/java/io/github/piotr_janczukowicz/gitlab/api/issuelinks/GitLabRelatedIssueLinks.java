package io.github.piotr_janczukowicz.gitlab.api.issuelinks;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab related issue links of a GitLab resource.
 *
 * @param self the self
 * @param notes the notes
 * @param awardEmoji the award emoji
 * @param project the project
 * @param closedAsDuplicateOf the closed as duplicate of
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesRelatedIssue/properties/_links")
public record GitLabRelatedIssueLinks(
        @Nullable String self,
        @Nullable String notes,
        @Nullable String awardEmoji,
        @Nullable String project,
        @Nullable String closedAsDuplicateOf) {}
