package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab todo.
 *
 * @param id the id
 * @param project the project
 * @param group the group
 * @param author the author
 * @param actionName the action name
 * @param targetType the target type
 * @param target the target
 * @param targetUrl the target url
 * @param body the body
 * @param state the state
 * @param createdAt the created at
 * @param updatedAt the updated at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesTodo")
public record GitLabTodo(
        @Nullable Long id,
        @Nullable GitLabProjectIdentity project,
        @Nullable GitLabNamespaceBasic group,
        @Nullable GitLabUserBasic author,
        @Nullable String actionName,
        @Nullable String targetType,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> target,

        @Nullable String targetUrl,
        @Nullable String body,
        @Nullable String state,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt) {}
