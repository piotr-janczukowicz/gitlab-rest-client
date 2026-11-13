package io.github.piotr_janczukowicz.gitlab.api.conanv2distributions;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab package conan revision.
 *
 * @param revision the revision
 * @param time the time
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesPackagesConanRevision")
public record GitLabPackageConanRevision(
        @Nullable String revision, @Nullable String time) {}
