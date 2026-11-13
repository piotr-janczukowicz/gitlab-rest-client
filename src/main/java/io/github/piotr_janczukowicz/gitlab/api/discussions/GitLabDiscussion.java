package io.github.piotr_janczukowicz.gitlab.api.discussions;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabNote;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab discussion.
 *
 * @param id the id
 * @param individualNote the individual note
 * @param resolvable the resolvable
 * @param resolved the resolved
 * @param notes the notes
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesDiscussion")
public record GitLabDiscussion(
        @Nullable String id,
        @Nullable Boolean individualNote,
        @Nullable Boolean resolvable,
        @Nullable Boolean resolved,
        @Nullable List<GitLabNote> notes) {}
