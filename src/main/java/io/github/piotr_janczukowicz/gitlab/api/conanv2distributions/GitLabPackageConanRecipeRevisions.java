package io.github.piotr_janczukowicz.gitlab.api.conanv2distributions;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab package conan recipe revisions.
 *
 * @param reference the reference
 * @param revisions the revisions
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesPackagesConanRecipeRevisions")
public record GitLabPackageConanRecipeRevisions(
        @Nullable String reference, @Nullable List<GitLabPackageConanRevision> revisions) {}
