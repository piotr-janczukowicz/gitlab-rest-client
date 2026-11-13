package io.github.piotr_janczukowicz.gitlab.api.broadcastmessages;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab system broadcast message.
 *
 * @param id the id
 * @param message the message
 * @param startsAt the starts at
 * @param endsAt the ends at
 * @param color the color
 * @param font the font
 * @param targetAccessLevels the target access levels
 * @param targetPath the target path
 * @param broadcastType the broadcast type
 * @param theme the theme
 * @param dismissable the dismissable
 * @param active the active
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesSystemBroadcastMessage")
public record GitLabSystemBroadcastMessage(
        @Nullable Long id,
        @Nullable String message,
        @Nullable Instant startsAt,
        @Nullable Instant endsAt,
        @Nullable String color,
        @Nullable String font,
        @Nullable List<Integer> targetAccessLevels,
        @Nullable String targetPath,
        @Nullable String broadcastType,
        @Nullable String theme,
        @Nullable Boolean dismissable,
        @Nullable Boolean active) {}
