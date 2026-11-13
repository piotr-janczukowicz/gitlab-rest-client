package io.github.piotr_janczukowicz.gitlab.api.repositories;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdRepositoryChangelog}, without paging.
 *
 * @param fromValue the from
 * @param to the to
 * @param date the date
 * @param trailer the trailer
 * @param configFile the config file
 * @param configFileRef the config file ref
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdRepositoryChangelog/parameters")
public record GitLabProjectRepositoriesGetChangelogFilter(
        @Nullable @JsonProperty("from") String fromValue,
        @Nullable String to,
        @Nullable Instant date,
        @Nullable String trailer,
        @Nullable String configFile,
        @Nullable String configFileRef) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectRepositoriesGetChangelogFilter empty() {
        return GitLabProjectRepositoriesGetChangelogFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("from", fromValue)
                .text("to", to)
                .value("date", date)
                .text("trailer", trailer)
                .text("config_file", configFile)
                .text("config_file_ref", configFileRef)
                .build();
    }
}
