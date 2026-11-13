package io.github.piotr_janczukowicz.gitlab.api.featureflags;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab feature flag basic user list.
 *
 * @param id the id
 * @param iid the iid
 * @param name the name
 * @param userXids the user xids
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesFeatureFlagBasicUserList")
public record GitLabFeatureFlagBasicUserList(
        @Nullable Long id,
        @Nullable Long iid,
        @Nullable String name,
        @Nullable String userXids) {}
