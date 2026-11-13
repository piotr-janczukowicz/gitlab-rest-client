package io.github.piotr_janczukowicz.gitlab.api.repositories;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab repository health multi pack index.
 *
 * @param packfileCount the packfile count
 * @param version the version
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesRepositoryHealthMultiPackIndex")
public record GitLabRepositoryHealthMultiPackIndex(
        @Nullable Integer packfileCount, @Nullable Integer version) {}
