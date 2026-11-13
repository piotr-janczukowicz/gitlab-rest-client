package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ml mlflow list experiment.
 *
 * @param experiments the experiments
 * @param nextPageToken the next page token
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesMlMlflowListExperiment")
public record GitLabMlMlflowListExperiment(
        @Nullable List<GitLabMlMlflowExperiment> experiments,
        @Nullable String nextPageToken) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code nextPageToken} redacted
     */
    @Override
    public String toString() {
        return "GitLabMlMlflowListExperiment[" + "experiments=" + experiments + ", nextPageToken=<redacted>" + "]";
    }
}
