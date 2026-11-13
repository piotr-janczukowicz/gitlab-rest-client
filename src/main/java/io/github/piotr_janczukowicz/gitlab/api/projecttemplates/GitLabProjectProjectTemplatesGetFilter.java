package io.github.piotr_janczukowicz.gitlab.api.projecttemplates;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdTemplatesTypeName}, without paging.
 *
 * @param sourceTemplateProjectId the source template project id
 * @param project the project
 * @param fullname the fullname
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdTemplatesTypeName/parameters")
public record GitLabProjectProjectTemplatesGetFilter(
        @Nullable Long sourceTemplateProjectId,
        @Nullable String project,
        @Nullable String fullname) {
    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectProjectTemplatesGetFilter empty() {
        return GitLabProjectProjectTemplatesGetFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .value("source_template_project_id", sourceTemplateProjectId)
                .text("project", project)
                .text("fullname", fullname)
                .build();
    }
}
