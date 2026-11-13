package io.github.piotr_janczukowicz.gitlab.api.validategitlabciymlfile;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdCiLint}.
 *
 * @param content the content
 * @param dryRun the dry run
 * @param includeJobs the include jobs
 * @param ref the ref
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdCiLint/requestBody")
public record GitLabProjectValidateGitlabCiYmlFileCreatePayload(
        @Nullable String content,
        @Nullable Boolean dryRun,
        @Nullable Boolean includeJobs,
        @Nullable String ref) {}
