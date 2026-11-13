package io.github.piotr_janczukowicz.gitlab.api.events;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabNote;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabWikiPageBasic;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab event.
 *
 * @param id the id
 * @param projectId the project id
 * @param actionName the action name
 * @param targetId the target id
 * @param targetIid the target iid
 * @param targetType the target type
 * @param authorId the author id
 * @param targetTitle the target title
 * @param createdAt the created at
 * @param note the note
 * @param author the author
 * @param wikiPage the wiki page
 * @param imported the imported
 * @param importedFrom the imported from
 * @param pushData the push data
 * @param authorUsername the author username
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesEvent")
public record GitLabEvent(
        @Nullable Long id,
        @Nullable Long projectId,
        @Nullable String actionName,
        @Nullable Long targetId,
        @Nullable Long targetIid,
        @Nullable String targetType,
        @Nullable Long authorId,
        @Nullable String targetTitle,

        @Nullable @SuppressSchemaTypeMismatch("type rule: date-time (created_at)")
        Instant createdAt,

        @Nullable GitLabNote note,
        @Nullable GitLabUserBasic author,
        @Nullable GitLabWikiPageBasic wikiPage,
        @Nullable Boolean imported,
        @Nullable String importedFrom,
        @Nullable GitLabPushEventPayload pushData,
        @Nullable String authorUsername) {}
