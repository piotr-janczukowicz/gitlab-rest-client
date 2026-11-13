package io.github.piotr_janczukowicz.gitlab.api.vscode;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab apivs code settings entities vs code manifest.
 *
 * @param latest the latest
 * @param session the session
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIVsCodeSettingsEntitiesVsCodeManifest")
public record GitLabAPIVsCodeSettingsEntitiesVsCodeManifest(
        @Nullable Map<String, String> latest, @Nullable String session) {}
