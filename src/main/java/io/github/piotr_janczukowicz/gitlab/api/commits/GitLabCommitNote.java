package io.github.piotr_janczukowicz.gitlab.api.commits;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab commit note.
 *
 * @param note the note
 * @param path the path
 * @param line the line
 * @param lineType the line type
 * @param author the author
 * @param createdAt the created at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCommitNote")
public record GitLabCommitNote(
        @Nullable String note,
        @Nullable String path,
        @Nullable Integer line,
        @Nullable String lineType,
        @Nullable GitLabUserBasic author,
        @Nullable Instant createdAt) {}
