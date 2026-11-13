package io.github.piotr_janczukowicz.gitlab.api.repositoryfiles;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab project repository files get response.
 *
 * @param fileName the file name
 * @param filePath the file path
 * @param size the size
 * @param encoding the encoding
 * @param content the content
 * @param contentSha256 the content sha256
 * @param ref the ref
 * @param blobId the blob id
 * @param commitId the commit id
 * @param lastCommitId the last commit id
 * @param executeFilemode the execute filemode
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdRepositoryFilesFilePath/200")
public record GitLabProjectRepositoryFilesGetResponse(
        @Nullable String fileName,
        @Nullable String filePath,
        @Nullable Long size,
        @Nullable String encoding,
        @Nullable String content,
        @Nullable String contentSha256,
        @Nullable String ref,
        @Nullable String blobId,
        @Nullable String commitId,
        @Nullable String lastCommitId,
        @Nullable Boolean executeFilemode) {}
