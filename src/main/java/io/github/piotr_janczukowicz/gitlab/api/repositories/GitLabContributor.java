package io.github.piotr_janczukowicz.gitlab.api.repositories;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab contributor.
 *
 * @param name the name
 * @param email the email
 * @param commits the commits
 * @param additions the additions
 * @param deletions the deletions
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesContributor")
public record GitLabContributor(
        @Nullable String name,
        @Nullable String email,
        @Nullable Integer commits,
        @Nullable Integer additions,
        @Nullable Integer deletions) {}
