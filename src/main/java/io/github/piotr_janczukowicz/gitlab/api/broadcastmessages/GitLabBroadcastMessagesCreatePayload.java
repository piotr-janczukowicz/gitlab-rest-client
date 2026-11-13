package io.github.piotr_janczukowicz.gitlab.api.broadcastmessages;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4BroadcastMessages}.
 *
 * @param message the message
 * @param startsAt the starts at
 * @param endsAt the ends at
 * @param color the color
 * @param font the font
 * @param targetAccessLevels the target access levels
 * @param targetPath the target path
 * @param broadcastType the broadcast type
 * @param dismissable the dismissable
 * @param theme the theme
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4BroadcastMessages/requestBody")
public record GitLabBroadcastMessagesCreatePayload(
        @Nullable String message,
        @Nullable Instant startsAt,
        @Nullable Instant endsAt,
        @Nullable String color,
        @Nullable String font,
        @Nullable List<Integer> targetAccessLevels,
        @Nullable String targetPath,
        @Nullable GitLabBroadcastMessagesCreateBroadcastType broadcastType,
        @Nullable Boolean dismissable,
        @Nullable GitLabBroadcastMessagesCreateTheme theme) {
    public GitLabBroadcastMessagesCreatePayload {
        if (targetAccessLevels != null) {
            targetAccessLevels = List.copyOf(targetAccessLevels);
        }
    }
}
