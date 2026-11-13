package io.github.piotr_janczukowicz.gitlab.api.importrepositoryfromgithub;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireBetweenIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ImportGithub}.
 *
 * @param personalAccessToken the personal access token
 * @param repoId the repo id
 * @param newName the new name
 * @param targetNamespace the target namespace
 * @param githubHostname the github hostname
 * @param optionalStages the optional stages
 * @param timeoutStrategy the timeout strategy
 * @param paginationLimit the pagination limit
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ImportGithub/requestBody")
public record GitLabImportRepositoryFromGitHubCreatePayload(
        @Nullable String personalAccessToken,
        @Nullable Long repoId,
        @Nullable String newName,
        @Nullable String targetNamespace,
        @Nullable String githubHostname,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> optionalStages,

        @Nullable GitLabImportRepositoryFromGitHubCreateTimeoutStrategy timeoutStrategy,
        @Nullable Integer paginationLimit) {
    public GitLabImportRepositoryFromGitHubCreatePayload {
        if (optionalStages != null) {
            optionalStages = Map.copyOf(optionalStages);
        }
        requireBetweenIfPresent(paginationLimit, 1, 100, "paginationLimit");
    }

    /**
     * Describes this record without its secret.
     *
     * @return text with {@code personalAccessToken} redacted
     */
    @Override
    public String toString() {
        return "GitLabImportRepositoryFromGitHubCreatePayload[" + "personalAccessToken=<redacted>" + ", repoId="
                + repoId + ", newName=" + newName + ", targetNamespace=" + targetNamespace + ", githubHostname="
                + githubHostname + ", optionalStages=" + optionalStages + ", timeoutStrategy=" + timeoutStrategy
                + ", paginationLimit=" + paginationLimit + "]";
    }
}
