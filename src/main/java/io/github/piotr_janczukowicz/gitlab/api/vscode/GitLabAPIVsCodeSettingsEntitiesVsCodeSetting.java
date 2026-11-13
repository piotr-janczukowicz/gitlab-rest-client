package io.github.piotr_janczukowicz.gitlab.api.vscode;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab apivs code settings entities vs code setting.
 *
 * @param content the content
 * @param machines the machines
 * @param version the version
 * @param machineId the machine id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIVsCodeSettingsEntitiesVsCodeSetting")
public record GitLabAPIVsCodeSettingsEntitiesVsCodeSetting(
        @Nullable String content,
        @Nullable String machines,
        @Nullable String version,
        @Nullable @JsonProperty("machineId") String machineId) {}
