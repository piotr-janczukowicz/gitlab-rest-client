package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ml mlflow get metric history.
 *
 * @param metrics the metrics
 * @param nextPageToken the next page token
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesMlMlflowGetMetricHistory")
public record GitLabMlMlflowGetMetricHistory(
        @Nullable List<GitLabMlMlflowMetric> metrics,
        @Nullable String nextPageToken) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code nextPageToken} redacted
     */
    @Override
    public String toString() {
        return "GitLabMlMlflowGetMetricHistory[" + "metrics=" + metrics + ", nextPageToken=<redacted>" + "]";
    }
}
