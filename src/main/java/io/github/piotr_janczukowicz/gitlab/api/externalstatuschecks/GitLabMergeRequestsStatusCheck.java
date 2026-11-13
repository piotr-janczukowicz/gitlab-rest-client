package io.github.piotr_janczukowicz.gitlab.api.externalstatuschecks;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab merge requests status check.
 *
 * @param id the id
 * @param name the name
 * @param externalUrl the external url
 * @param status the status
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesMergeRequestsStatusCheck")
public record GitLabMergeRequestsStatusCheck(
        @Nullable Long id,
        @Nullable String name,
        @Nullable String externalUrl,
        @Nullable String status) {}
