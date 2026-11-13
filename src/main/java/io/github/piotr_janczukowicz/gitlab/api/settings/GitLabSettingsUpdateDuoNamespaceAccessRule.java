package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * The git lab settings update duo namespace access rule of a GitLab resource.
 *
 * @param throughNamespace the through namespace
 * @param features the features
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ApplicationSettings/requestBody/properties/duo_namespace_access_rules/items")
public record GitLabSettingsUpdateDuoNamespaceAccessRule(
        @Nullable GitLabSettingsUpdateDuoNamespaceAccessRuleThroughNamespace throughNamespace,
        @Nullable List<String> features) {
    public GitLabSettingsUpdateDuoNamespaceAccessRule {
        if (features != null) {
            features = List.copyOf(features);
        }
    }
}
