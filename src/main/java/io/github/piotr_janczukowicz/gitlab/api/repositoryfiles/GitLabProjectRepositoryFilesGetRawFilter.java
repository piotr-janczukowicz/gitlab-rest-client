package io.github.piotr_janczukowicz.gitlab.api.repositoryfiles;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdRepositoryFilesFilePathRaw}, without paging.
 *
 * @param ref the ref
 * @param lfs the lfs
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdRepositoryFilesFilePathRaw/parameters")
public record GitLabProjectRepositoryFilesGetRawFilter(
        @Nullable String ref, @Nullable Boolean lfs) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectRepositoryFilesGetRawFilter empty() {
        return GitLabProjectRepositoryFilesGetRawFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("ref", ref)
                .value("lfs", lfs)
                .build();
    }
}
