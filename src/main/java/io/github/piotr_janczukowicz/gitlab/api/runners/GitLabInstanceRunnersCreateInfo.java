package io.github.piotr_janczukowicz.gitlab.api.runners;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab instance runners create info of a GitLab resource.
 *
 * @param name the name
 * @param version the version
 * @param revision the revision
 * @param platform the platform
 * @param architecture the architecture
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4Runners/requestBody/properties/info")
public record GitLabInstanceRunnersCreateInfo(
        @Nullable String name,
        @Nullable String version,
        @Nullable String revision,
        @Nullable String platform,
        @Nullable String architecture) {}
