package io.github.piotr_janczukowicz.gitlab.api.containerregistry;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code deleteApiV4ProjectsIdRegistryRepositoriesRepositoryIdTags}, without
 * paging.
 *
 * @param nameRegexDelete the name regex delete
 * @param nameRegex the name regex
 * @param nameRegexKeep the name regex keep
 * @param keepN the keep n
 * @param olderThan the older than
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/deleteApiV4ProjectsIdRegistryRepositoriesRepositoryIdTags/parameters")
public record GitLabProjectContainerRegistryDeleteTagFilter(
        @Nullable String nameRegexDelete,
        @Nullable String nameRegex,
        @Nullable String nameRegexKeep,
        @Nullable Integer keepN,
        @Nullable String olderThan) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectContainerRegistryDeleteTagFilter empty() {
        return GitLabProjectContainerRegistryDeleteTagFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("name_regex_delete", nameRegexDelete)
                .text("name_regex", nameRegex)
                .text("name_regex_keep", nameRegexKeep)
                .value("keep_n", keepN)
                .text("older_than", olderThan)
                .build();
    }
}
