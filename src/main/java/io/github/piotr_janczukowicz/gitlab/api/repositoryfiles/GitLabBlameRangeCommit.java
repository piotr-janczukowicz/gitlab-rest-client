package io.github.piotr_janczukowicz.gitlab.api.repositoryfiles;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab blame range commit.
 *
 * @param id the id
 * @param parentIds the parent ids
 * @param message the message
 * @param authoredDate the authored date
 * @param authorName the author name
 * @param authorEmail the author email
 * @param committedDate the committed date
 * @param committerName the committer name
 * @param committerEmail the committer email
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesBlameRangeCommit")
public record GitLabBlameRangeCommit(
        @Nullable String id,
        @Nullable List<String> parentIds,
        @Nullable String message,
        @Nullable Instant authoredDate,
        @Nullable String authorName,
        @Nullable String authorEmail,
        @Nullable Instant committedDate,
        @Nullable String committerName,
        @Nullable String committerEmail) {}
