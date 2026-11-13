package io.github.piotr_janczukowicz.gitlab.api.mergerequestcontextcommits;

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
 * A GitLab commit with link.
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
 * @param author the author
 * @param authorGravatarUrl the author gravatar url
 * @param commitUrl the commit url
 * @param commitPath the commit path
 * @param descriptionHtml the description html
 * @param titleHtml the title html
 * @param signatureHtml the signature html
 * @param prevCommitId the prev commit id
 * @param nextCommitId the next commit id
 * @param pipelineStatusPath the pipeline status path
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCommitWithLink")
public record GitLabCommitWithLink(
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

        @Nullable String webUrl,
        @Nullable GitLabUserPath author,
        @Nullable String authorGravatarUrl,
        @Nullable String commitUrl,
        @Nullable String commitPath,
        @Nullable String descriptionHtml,
        @Nullable String titleHtml,
        @Nullable String signatureHtml,
        @Nullable String prevCommitId,
        @Nullable String nextCommitId,
        @Nullable String pipelineStatusPath) {}
