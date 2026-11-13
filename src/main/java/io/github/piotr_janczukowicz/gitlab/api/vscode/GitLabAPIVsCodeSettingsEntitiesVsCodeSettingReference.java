package io.github.piotr_janczukowicz.gitlab.api.vscode;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab apivs code settings entities vs code setting reference.
 *
 * @param url the url
 * @param created the created
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIVsCodeSettingsEntitiesVsCodeSettingReference")
public record GitLabAPIVsCodeSettingsEntitiesVsCodeSettingReference(
        @Nullable String url, @Nullable String created) {}
