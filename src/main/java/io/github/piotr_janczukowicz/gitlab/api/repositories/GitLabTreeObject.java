package io.github.piotr_janczukowicz.gitlab.api.repositories;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCommit;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab tree object.
 *
 * @param id the id
 * @param name the name
 * @param type the type
 * @param path the path
 * @param mode the mode
 * @param lastCommit the last commit
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesTreeObject")
public record GitLabTreeObject(
        @Nullable String id,
        @Nullable String name,
        @Nullable String type,
        @Nullable String path,
        @Nullable String mode,
        @Nullable GitLabCommit lastCommit) {}
