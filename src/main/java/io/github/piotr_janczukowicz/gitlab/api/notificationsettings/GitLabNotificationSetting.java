package io.github.piotr_janczukowicz.gitlab.api.notificationsettings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab notification setting.
 *
 * @param level the level
 * @param events the events
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesNotificationSetting")
public record GitLabNotificationSetting(
        @Nullable String level, @Nullable String events) {}
