package io.github.piotr_janczukowicz.gitlab.api.metadata;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab metadata.
 *
 * @param version the version
 * @param revision the revision
 * @param kas the kas
 * @param enterprise the enterprise
 * @param plan the plan
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesMetadata")
public record GitLabMetadata(
        @Nullable String version,
        @Nullable String revision,
        @Nullable GitLabMetadataKas kas,
        @Nullable Boolean enterprise,
        @Nullable String plan) {}
