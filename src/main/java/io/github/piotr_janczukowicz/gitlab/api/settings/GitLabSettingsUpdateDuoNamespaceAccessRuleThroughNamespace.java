package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab settings update duo namespace access rule through namespace of a GitLab resource.
 *
 * @param id the id
 * @param name the name
 * @param fullPath the full path
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema(
        "operations/putApiV4ApplicationSettings/requestBody/properties/duo_namespace_access_rules/items/properties/through_namespace")
public record GitLabSettingsUpdateDuoNamespaceAccessRuleThroughNamespace(
        @Nullable Long id, @Nullable String name, @Nullable String fullPath) {}
