package io.github.piotr_janczukowicz.gitlab.api.personalaccesstokens;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4PersonalAccessTokensSelfAssociations}, without paging.
 *
 * @param minAccessLevel the min access level
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4PersonalAccessTokensSelfAssociations/parameters")
public record GitLabPersonalAccessTokensListSelfAssociationsFilter(
        @Nullable GitLabPersonalAccessTokensListSelfAssociationsMinAccessLevel minAccessLevel) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabPersonalAccessTokensListSelfAssociationsFilter empty() {
        return GitLabPersonalAccessTokensListSelfAssociationsFilterBuilder.builder()
                .build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire(
                        "min_access_level",
                        minAccessLevel,
                        GitLabPersonalAccessTokensListSelfAssociationsMinAccessLevel::wireValue)
                .build();
    }
}
