package io.github.piotr_janczukowicz.gitlab.api.conanv2distributions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab package conan package revisions.
 *
 * @param packageReference the package reference
 * @param revisions the revisions
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesPackagesConanPackageRevisions")
public record GitLabPackageConanPackageRevisions(
        @Nullable @JsonProperty("packageReference") String packageReference,
        @Nullable List<GitLabPackageConanRevision> revisions) {}
