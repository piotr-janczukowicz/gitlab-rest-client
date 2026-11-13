package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab identity detail.
 *
 * @param externUid the extern uid
 * @param userId the user id
 * @param active the active
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesIdentityDetail")
public record GitLabIdentityDetail(
        @Nullable String externUid,
        @Nullable Long userId,
        @Nullable Boolean active) {}
