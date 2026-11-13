package io.github.piotr_janczukowicz.gitlab.api.codesnippets;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab snippet.
 *
 * @param id the id
 * @param title the title
 * @param description the description
 * @param visibility the visibility
 * @param author the author
 * @param createdAt the created at
 * @param updatedAt the updated at
 * @param projectId the project id
 * @param webUrl the web url
 * @param rawUrl the raw url
 * @param sshUrlToRepo the ssh url to repo
 * @param httpUrlToRepo the http url to repo
 * @param fileName the file name
 * @param files the files
 * @param imported the imported
 * @param importedFrom the imported from
 * @param repositoryStorage the repository storage
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesSnippet")
public record GitLabSnippet(
        @Nullable Long id,
        @Nullable String title,
        @Nullable String description,
        @Nullable String visibility,
        @Nullable GitLabUserBasic author,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt,
        @Nullable Long projectId,
        @Nullable String webUrl,
        @Nullable String rawUrl,
        @Nullable String sshUrlToRepo,
        @Nullable String httpUrlToRepo,
        @Nullable String fileName,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        List<Map<String, Object>> files,

        @Nullable Boolean imported,
        @Nullable String importedFrom,
        @Nullable String repositoryStorage) {}
