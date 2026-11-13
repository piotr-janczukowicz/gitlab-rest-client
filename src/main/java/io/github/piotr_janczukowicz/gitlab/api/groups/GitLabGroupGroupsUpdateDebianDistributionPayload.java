package io.github.piotr_janczukowicz.gitlab.api.groups;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4GroupsIdDashDebianDistributionsCodename}.
 *
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
@CatalogSchema("operations/putApiV4GroupsIdDashDebianDistributionsCodename/requestBody")
public record GitLabGroupGroupsUpdateDebianDistributionPayload(
        @Nullable String suite,
        @Nullable String origin,
        @Nullable String label,
        @Nullable String description,
        @Nullable Integer validTimeDurationSeconds,
        @Nullable List<String> components,
        @Nullable List<String> architectures) {
    public GitLabGroupGroupsUpdateDebianDistributionPayload {
        if (components != null) {
            components = List.copyOf(components);
        }
        if (architectures != null) {
            architectures = List.copyOf(architectures);
        }
    }
}
