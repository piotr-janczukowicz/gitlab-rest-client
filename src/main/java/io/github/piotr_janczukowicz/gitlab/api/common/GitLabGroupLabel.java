package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab group label.
 *
 * @param id the id
 * @param name the name
 * @param description the description
 * @param textColor the text color
 * @param descriptionHtml the description html
 * @param color the color
 * @param archived the archived
 * @param openIssuesCount the open issues count
 * @param closedIssuesCount the closed issues count
 * @param openMergeRequestsCount the open merge requests count
 * @param subscribed the subscribed
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesGroupLabel")
public record GitLabGroupLabel(
        @Nullable Long id,
        @Nullable String name,
        @Nullable String description,
        @Nullable String textColor,
        @Nullable String descriptionHtml,
        @Nullable String color,
        @Nullable Boolean archived,
        @Nullable Integer openIssuesCount,
        @Nullable Integer closedIssuesCount,
        @Nullable Integer openMergeRequestsCount,
        @Nullable Boolean subscribed) {}
