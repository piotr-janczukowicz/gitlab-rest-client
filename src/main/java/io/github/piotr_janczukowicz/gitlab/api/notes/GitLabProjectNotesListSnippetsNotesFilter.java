package io.github.piotr_janczukowicz.gitlab.api.notes;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdSnippetsNoteableIdNotes}, without paging.
 *
 * @param orderBy the order by
 * @param sort the sort
 * @param activityFilter the activity filter
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdSnippetsNoteableIdNotes/parameters")
public record GitLabProjectNotesListSnippetsNotesFilter(
        @Nullable GitLabProjectNotesListSnippetsNotesOrderBy orderBy,
        @Nullable GitLabProjectNotesListSnippetsNotesSort sort,
        @Nullable GitLabProjectNotesListSnippetsNotesActivityFilter activityFilter) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectNotesListSnippetsNotesFilter empty() {
        return GitLabProjectNotesListSnippetsNotesFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("order_by", orderBy, GitLabProjectNotesListSnippetsNotesOrderBy::wireValue)
                .wire("sort", sort, GitLabProjectNotesListSnippetsNotesSort::wireValue)
                .wire("activity_filter", activityFilter, GitLabProjectNotesListSnippetsNotesActivityFilter::wireValue)
                .build();
    }
}
