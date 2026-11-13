package io.github.piotr_janczukowicz.gitlab.api.projectcicdjobtokenscope;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdJobTokenScopeAllowlist}.
 *
 * @param targetProjectId the target project id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdJobTokenScopeAllowlist/requestBody")
public record GitLabProjectProjectCICDJobTokenScopeCreateAllowlistPayload(
        @Nullable Long targetProjectId) {}
