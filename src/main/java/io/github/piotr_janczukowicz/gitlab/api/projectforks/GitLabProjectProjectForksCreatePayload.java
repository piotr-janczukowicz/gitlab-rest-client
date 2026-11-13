package io.github.piotr_janczukowicz.gitlab.api.projectforks;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdFork}.
 *
 * @param namespace the namespace
 * @param namespaceId the namespace id
 * @param namespacePath the namespace path
 * @param path the path
 * @param name the name
 * @param description the description
 * @param visibility the visibility
 * @param mrDefaultTargetSelf the mr default target self
 * @param branches the branches
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdFork/requestBody")
public record GitLabProjectProjectForksCreatePayload(
        @Nullable String namespace,
        @Nullable Long namespaceId,
        @Nullable String namespacePath,
        @Nullable String path,
        @Nullable String name,
        @Nullable String description,
        @Nullable GitLabProjectProjectForksCreateVisibility visibility,
        @Nullable Boolean mrDefaultTargetSelf,
        @Nullable String branches) {}
