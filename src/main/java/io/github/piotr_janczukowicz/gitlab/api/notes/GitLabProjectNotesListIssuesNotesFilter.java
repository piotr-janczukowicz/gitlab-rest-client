package io.github.piotr_janczukowicz.gitlab.api.notes;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdIssuesNoteableIdNotes}, without paging.
 *
 * @param orderBy the order by
 * @param sort the sort
 * @param activityFilter the activity filter
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdIssuesNoteableIdNotes/parameters")
public record GitLabProjectNotesListIssuesNotesFilter(
        @Nullable GitLabProjectNotesListIssuesNotesOrderBy orderBy,
        @Nullable GitLabProjectNotesListIssuesNotesSort sort,
        @Nullable GitLabProjectNotesListIssuesNotesActivityFilter activityFilter) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectNotesListIssuesNotesFilter empty() {
        return GitLabProjectNotesListIssuesNotesFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("order_by", orderBy, GitLabProjectNotesListIssuesNotesOrderBy::wireValue)
                .wire("sort", sort, GitLabProjectNotesListIssuesNotesSort::wireValue)
                .wire("activity_filter", activityFilter, GitLabProjectNotesListIssuesNotesActivityFilter::wireValue)
                .build();
    }
}
