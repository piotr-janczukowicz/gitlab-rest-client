package io.github.piotr_janczukowicz.gitlab.api.debiandistributions;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdDebianDistributions}, without paging.
 *
 * @param codename the codename
 * @param suite the suite
 * @param origin the origin
 * @param label the label
 * @param version the version
 * @param description the description
 * @param validTimeDurationSeconds the valid time duration seconds
 * @param components the components
 * @param architectures the architectures
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdDebianDistributions/parameters")
public record GitLabProjectDebianDistributionsListFilter(
        @Nullable String codename,
        @Nullable String suite,
        @Nullable String origin,
        @Nullable String label,
        @Nullable String version,
        @Nullable String description,
        @Nullable Integer validTimeDurationSeconds,
        @Nullable List<String> components,
        @Nullable List<String> architectures) {
    public GitLabProjectDebianDistributionsListFilter {
        if (components != null) {
            components = List.copyOf(components);
        }
        if (architectures != null) {
            architectures = List.copyOf(architectures);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectDebianDistributionsListFilter empty() {
        return GitLabProjectDebianDistributionsListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("codename", codename)
                .text("suite", suite)
                .text("origin", origin)
                .text("label", label)
                .text("version", version)
                .text("description", description)
                .value("valid_time_duration_seconds", validTimeDurationSeconds)
                .list("components", components)
                .list("architectures", architectures)
                .build();
    }
}
