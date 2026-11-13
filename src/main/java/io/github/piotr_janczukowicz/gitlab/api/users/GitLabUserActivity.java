package io.github.piotr_janczukowicz.gitlab.api.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.LocalDate;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab user activity.
 *
 * @param username the username
 * @param lastActivityOn the last activity on
 * @param lastActivityAt the last activity at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesUserActivity")
public record GitLabUserActivity(
        @Nullable String username,
        @Nullable LocalDate lastActivityOn,
        @Nullable LocalDate lastActivityAt) {}
