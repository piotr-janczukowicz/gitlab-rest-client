package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab merge requests status check response external status check.
 *
 * @param id the id
 * @param name the name
 * @param externalUrl the external url
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesMergeRequestsStatusCheckResponseExternalStatusCheck")
public record GitLabMergeRequestsStatusCheckResponseExternalStatusCheck(
        @Nullable Long id, @Nullable String name, @Nullable String externalUrl) {}
