package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab commit.
 *
 * @param id the id
 * @param shortId the short id
 * @param createdAt the created at
 * @param parentIds the parent ids
 * @param title the title
 * @param message the message
 * @param authorName the author name
 * @param authorEmail the author email
 * @param authoredDate the authored date
 * @param committerName the committer name
 * @param committerEmail the committer email
 * @param committedDate the committed date
 * @param trailers the trailers
 * @param extendedTrailers the extended trailers
 * @param webUrl the web url
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCommit")
public record GitLabCommit(
        @Nullable String id,
        @Nullable String shortId,
        @Nullable Instant createdAt,
        @Nullable List<String> parentIds,
        @Nullable String title,
        @Nullable String message,
        @Nullable String authorName,
        @Nullable String authorEmail,
        @Nullable Instant authoredDate,
        @Nullable String committerName,
        @Nullable String committerEmail,
        @Nullable Instant committedDate,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> trailers,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> extendedTrailers,

        @Nullable String webUrl) {}
