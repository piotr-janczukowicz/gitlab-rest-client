package io.github.piotr_janczukowicz.gitlab.api.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab user status.
 *
 * @param emoji the emoji
 * @param message the message
 * @param availability the availability
 * @param messageHtml the message html
 * @param clearStatusAt the clear status at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesUserStatus")
public record GitLabUserStatus(
        @Nullable String emoji,
        @Nullable String message,
        @Nullable String availability,
        @Nullable String messageHtml,
        @Nullable Instant clearStatusAt) {}
