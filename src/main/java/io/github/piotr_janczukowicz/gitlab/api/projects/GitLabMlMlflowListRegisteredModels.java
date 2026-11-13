package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ml mlflow list registered models.
 *
 * @param registeredModels the registered models
 * @param nextPageToken the next page token
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesMlMlflowListRegisteredModels")
public record GitLabMlMlflowListRegisteredModels(
        @Nullable List<GitLabMlMlflowRegisteredModel> registeredModels,
        @Nullable String nextPageToken) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code nextPageToken} redacted
     */
    @Override
    public String toString() {
        return "GitLabMlMlflowListRegisteredModels[" + "registeredModels=" + registeredModels
                + ", nextPageToken=<redacted>" + "]";
    }
}
