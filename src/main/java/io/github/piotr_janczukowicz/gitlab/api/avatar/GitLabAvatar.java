package io.github.piotr_janczukowicz.gitlab.api.avatar;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab avatar.
 *
 * @param avatarUrl the avatar url
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesAvatar")
public record GitLabAvatar(@Nullable String avatarUrl) {}
