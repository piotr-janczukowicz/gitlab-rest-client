package io.github.piotr_janczukowicz.gitlab.api.terraformmodules;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdPackagesTerraformModulesModuleNameModuleSystem},
 * without paging.
 *
 * @param terraformGet the terraform get
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdPackagesTerraformModulesModuleNameModuleSystem/parameters")
public record GitLabProjectTerraformModulesCallFilter(
        @Nullable @JsonProperty("terraform-get") GitLabProjectTerraformModulesCallTerraformGet terraformGet) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectTerraformModulesCallFilter empty() {
        return GitLabProjectTerraformModulesCallFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("terraform-get", terraformGet, GitLabProjectTerraformModulesCallTerraformGet::wireValue)
                .build();
    }
}
