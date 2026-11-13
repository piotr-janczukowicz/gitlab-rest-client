package io.github.piotr_janczukowicz.gitlab.api.groups;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4GroupsIdDashDebianDistributions}.
 *
 * @param codename the codename
 * @param suite the suite
 * @param origin the origin
 * @param label the label
 * @param description the description
 * @param validTimeDurationSeconds the valid time duration seconds
 * @param components the components
 * @param architectures the architectures
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4GroupsIdDashDebianDistributions/requestBody")
public record GitLabGroupGroupsCreateDebianDistributionPayload(
        @Nullable String codename,
        @Nullable String suite,
        @Nullable String origin,
        @Nullable String label,
        @Nullable String description,
        @Nullable Integer validTimeDurationSeconds,
        @Nullable List<String> components,
        @Nullable List<String> architectures) {
    public GitLabGroupGroupsCreateDebianDistributionPayload {
        if (components != null) {
            components = List.copyOf(components);
        }
        if (architectures != null) {
            architectures = List.copyOf(architectures);
        }
    }
}
