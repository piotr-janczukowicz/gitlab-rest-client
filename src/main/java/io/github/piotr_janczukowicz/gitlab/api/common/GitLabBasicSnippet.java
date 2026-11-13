package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab basic snippet.
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
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesBasicSnippet")
public record GitLabBasicSnippet(
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
        @Nullable String httpUrlToRepo) {}
