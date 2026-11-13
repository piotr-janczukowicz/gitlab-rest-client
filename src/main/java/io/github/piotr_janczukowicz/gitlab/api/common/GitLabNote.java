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
 * A GitLab note.
 *
 * @param id the id
 * @param type the type
 * @param body the body
 * @param author the author
 * @param createdAt the created at
 * @param updatedAt the updated at
 * @param system the system
 * @param noteableId the noteable id
 * @param noteableType the noteable type
 * @param projectId the project id
 * @param commitId the commit id
 * @param position the position
 * @param resolvable the resolvable
 * @param resolved the resolved
 * @param resolvedBy the resolved by
 * @param resolvedAt the resolved at
 * @param suggestions the suggestions
 * @param confidential the confidential
 * @param internal the internal
 * @param imported the imported
 * @param importedFrom the imported from
 * @param noteableIid the noteable iid
 * @param commandsChanges the commands changes
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesNote")
public record GitLabNote(
        @Nullable Long id,
        @Nullable String type,
        @Nullable String body,
        @Nullable GitLabUserBasic author,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt,
        @Nullable Boolean system,
        @Nullable Long noteableId,
        @Nullable String noteableType,
        @Nullable Long projectId,
        @Nullable String commitId,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> position,

        @Nullable Boolean resolvable,
        @Nullable Boolean resolved,
        @Nullable GitLabUserBasic resolvedBy,
        @Nullable Instant resolvedAt,
        @Nullable List<GitLabSuggestion> suggestions,
        @Nullable Boolean confidential,
        @Nullable Boolean internal,
        @Nullable Boolean imported,
        @Nullable String importedFrom,
        @Nullable Long noteableIid,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> commandsChanges) {}
