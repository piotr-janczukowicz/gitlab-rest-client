package io.github.piotr_janczukowicz.gitlab.api.jobs;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * The git lab instance jobs request info of a GitLab resource.
 *
 * @param name the name
 * @param version the version
 * @param revision the revision
 * @param platform the platform
 * @param architecture the architecture
 * @param executor the executor
 * @param features the features
 * @param config the config
 * @param labels the labels
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4JobsRequest/requestBody/properties/info")
public record GitLabInstanceJobsRequestInfo(
        @Nullable String name,
        @Nullable String version,
        @Nullable String revision,
        @Nullable String platform,
        @Nullable String architecture,
        @Nullable String executor,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> features,

        @Nullable GitLabInstanceJobsRequestInfoConfig config,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> labels) {
    public GitLabInstanceJobsRequestInfo {
        if (features != null) {
            features = Map.copyOf(features);
        }
        if (labels != null) {
            labels = Map.copyOf(labels);
        }
    }
}
