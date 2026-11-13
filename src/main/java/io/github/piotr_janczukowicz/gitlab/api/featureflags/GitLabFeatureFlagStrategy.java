package io.github.piotr_janczukowicz.gitlab.api.featureflags;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab feature flag strategy.
 *
 * @param id the id
 * @param name the name
 * @param parameters the parameters
 * @param scopes the scopes
 * @param userList the user list
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesFeatureFlagStrategy")
public record GitLabFeatureFlagStrategy(
        @Nullable Long id,
        @Nullable String name,
        @Nullable String parameters,
        @Nullable List<GitLabFeatureFlagScope> scopes,
        @Nullable GitLabFeatureFlagBasicUserList userList) {}
