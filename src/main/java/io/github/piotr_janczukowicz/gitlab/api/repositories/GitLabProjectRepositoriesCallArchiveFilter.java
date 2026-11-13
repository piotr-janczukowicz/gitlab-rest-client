package io.github.piotr_janczukowicz.gitlab.api.repositories;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdRepositoryArchive}, without paging.
 *
 * @param sha the sha
 * @param refType the ref type
 * @param format the format
 * @param path the path
 * @param includeLfsBlobs the include lfs blobs
 * @param excludePaths the exclude paths
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdRepositoryArchive/parameters")
public record GitLabProjectRepositoriesCallArchiveFilter(
        @Nullable String sha,
        @Nullable GitLabProjectRepositoriesCallArchiveRefType refType,
        @Nullable String format,
        @Nullable String path,
        @Nullable Boolean includeLfsBlobs,
        @Nullable List<String> excludePaths) {
    public GitLabProjectRepositoriesCallArchiveFilter {
        if (excludePaths != null) {
            excludePaths = List.copyOf(excludePaths);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectRepositoriesCallArchiveFilter empty() {
        return GitLabProjectRepositoriesCallArchiveFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("sha", sha)
                .wire("ref_type", refType, GitLabProjectRepositoriesCallArchiveRefType::wireValue)
                .text("format", format)
                .text("path", path)
                .value("include_lfs_blobs", includeLfsBlobs)
                .list("exclude_paths", excludePaths)
                .build();
    }
}
