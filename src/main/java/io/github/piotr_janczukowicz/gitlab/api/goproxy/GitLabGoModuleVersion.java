package io.github.piotr_janczukowicz.gitlab.api.goproxy;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab go module version.
 *
 * @param version the version
 * @param time the time
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesGoModuleVersion")
public record GitLabGoModuleVersion(
        @Nullable @JsonProperty("Version") String version,
        @Nullable @JsonProperty("Time") String time) {}
