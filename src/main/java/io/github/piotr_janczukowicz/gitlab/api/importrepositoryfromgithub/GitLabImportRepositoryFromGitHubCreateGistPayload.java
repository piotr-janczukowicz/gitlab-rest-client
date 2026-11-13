package io.github.piotr_janczukowicz.gitlab.api.importrepositoryfromgithub;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ImportGithubGists}.
 *
 * @param personalAccessToken the personal access token
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ImportGithubGists/requestBody")
public record GitLabImportRepositoryFromGitHubCreateGistPayload(
        @Nullable String personalAccessToken) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code personalAccessToken} redacted
     */
    @Override
    public String toString() {
        return "GitLabImportRepositoryFromGitHubCreateGistPayload[" + "personalAccessToken=<redacted>" + "]";
    }
}
