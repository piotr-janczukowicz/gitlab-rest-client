package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ci pipeline merge request.
 *
 * @param iid the iid
 * @param title the title
 * @param webUrl the web url
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiPipelineMergeRequest")
public record GitLabCiPipelineMergeRequest(
        @Nullable Long iid,
        @Nullable String title,
        @Nullable String webUrl) {}
