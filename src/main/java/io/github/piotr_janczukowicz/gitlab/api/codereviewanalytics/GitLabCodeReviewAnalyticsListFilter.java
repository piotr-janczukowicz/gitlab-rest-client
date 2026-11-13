package io.github.piotr_janczukowicz.gitlab.api.codereviewanalytics;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4AnalyticsCodeReview}, without paging.
 *
 * @param labelName the label name
 * @param milestoneTitle the milestone title
 * @param notLabelName the not label name
 * @param notMilestoneTitle the not milestone title
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4AnalyticsCodeReview/parameters")
public record GitLabCodeReviewAnalyticsListFilter(
        @Nullable List<String> labelName,
        @Nullable String milestoneTitle,
        @Nullable @JsonProperty("not[label_name]") List<String> notLabelName,
        @Nullable @JsonProperty("not[milestone_title]") String notMilestoneTitle) {
    public GitLabCodeReviewAnalyticsListFilter {
        if (labelName != null) {
            labelName = List.copyOf(labelName);
        }
        if (notLabelName != null) {
            notLabelName = List.copyOf(notLabelName);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabCodeReviewAnalyticsListFilter empty() {
        return GitLabCodeReviewAnalyticsListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .list("label_name", labelName)
                .text("milestone_title", milestoneTitle)
                .list("not[label_name]", notLabelName)
                .text("not[milestone_title]", notMilestoneTitle)
                .build();
    }
}
