package io.github.piotr_janczukowicz.gitlab.api.tags;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCommit;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab tag.
 *
 * @param name the name
 * @param message the message
 * @param target the target
 * @param commit the commit
 * @param release the release
 * @param protectedValue the protected
 * @param createdAt the created at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesTag")
public record GitLabTag(
        @Nullable String name,
        @Nullable String message,
        @Nullable String target,
        @Nullable GitLabCommit commit,
        @Nullable GitLabTagRelease release,
        @Nullable @JsonProperty("protected") Boolean protectedValue,
        @Nullable Instant createdAt) {}
