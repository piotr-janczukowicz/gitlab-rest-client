package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.releaselinks.GitLabReleaseLink;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * The git lab release assets of a GitLab resource.
 *
 * @param count the count
 * @param sources the sources
 * @param links the links
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesRelease/properties/assets")
public record GitLabReleaseAssets(
        @Nullable Integer count,
        @Nullable List<GitLabReleaseSource> sources,
        @Nullable List<GitLabReleaseLink> links) {}
