package io.github.piotr_janczukowicz.gitlab.api.notes;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4GroupsIdWikiPagesNoteableIdNotes}, without paging.
 *
 * @param orderBy the order by
 * @param sort the sort
 * @param activityFilter the activity filter
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4GroupsIdWikiPagesNoteableIdNotes/parameters")
public record GitLabGroupNotesListWikiPagesNotesFilter(
        @Nullable GitLabGroupNotesListWikiPagesNotesOrderBy orderBy,
        @Nullable GitLabGroupNotesListWikiPagesNotesSort sort,
        @Nullable GitLabGroupNotesListWikiPagesNotesActivityFilter activityFilter) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabGroupNotesListWikiPagesNotesFilter empty() {
        return GitLabGroupNotesListWikiPagesNotesFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("order_by", orderBy, GitLabGroupNotesListWikiPagesNotesOrderBy::wireValue)
                .wire("sort", sort, GitLabGroupNotesListWikiPagesNotesSort::wireValue)
                .wire("activity_filter", activityFilter, GitLabGroupNotesListWikiPagesNotesActivityFilter::wireValue)
                .build();
    }
}
