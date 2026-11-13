package io.github.piotr_janczukowicz.gitlab.api.projectvulnerabilities;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdVulnerabilitiesNoteableIdNotes}, without paging.
 *
 * @param orderBy the order by
 * @param sort the sort
 * @param activityFilter the activity filter
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdVulnerabilitiesNoteableIdNotes/parameters")
public record GitLabProjectProjectVulnerabilitiesListNotesFilter(
        @Nullable GitLabProjectProjectVulnerabilitiesListNotesOrderBy orderBy,
        @Nullable GitLabProjectProjectVulnerabilitiesListNotesSort sort,
        @Nullable GitLabProjectProjectVulnerabilitiesListNotesActivityFilter activityFilter) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectProjectVulnerabilitiesListNotesFilter empty() {
        return GitLabProjectProjectVulnerabilitiesListNotesFilterBuilder.builder()
                .build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("order_by", orderBy, GitLabProjectProjectVulnerabilitiesListNotesOrderBy::wireValue)
                .wire("sort", sort, GitLabProjectProjectVulnerabilitiesListNotesSort::wireValue)
                .wire(
                        "activity_filter",
                        activityFilter,
                        GitLabProjectProjectVulnerabilitiesListNotesActivityFilter::wireValue)
                .build();
    }
}
