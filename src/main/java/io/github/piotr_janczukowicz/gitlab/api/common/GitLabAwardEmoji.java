package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab award emoji.
 *
 * @param id the id
 * @param name the name
 * @param user the user
 * @param createdAt the created at
 * @param updatedAt the updated at
 * @param awardableId the awardable id
 * @param awardableType the awardable type
 * @param url the url
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesAwardEmoji")
public record GitLabAwardEmoji(
        @Nullable Long id,
        @Nullable String name,
        @Nullable GitLabUserBasic user,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt,
        @Nullable Long awardableId,
        @Nullable String awardableType,
        @Nullable String url) {}
