package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * The git lab settings update vscode extension marketplace of a GitLab resource.
 *
 * @param enabled the enabled
 * @param preset the preset
 * @param customValues the custom values
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ApplicationSettings/requestBody/properties/vscode_extension_marketplace")
public record GitLabSettingsUpdateVscodeExtensionMarketplace(
        @Nullable Boolean enabled,
        @Nullable String preset,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> customValues) {
    public GitLabSettingsUpdateVscodeExtensionMarketplace {
        if (customValues != null) {
            customValues = Map.copyOf(customValues);
        }
    }
}
