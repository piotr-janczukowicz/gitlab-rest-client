package io.github.piotr_janczukowicz.gitlab.api.avatar;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4Avatar}, without paging.
 *
 * @param size the size
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4Avatar/parameters")
public record GitLabAvatarGetFilter(@Nullable Long size) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabAvatarGetFilter empty() {
        return GitLabAvatarGetFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder().value("size", size).build();
    }
}
