package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab settings update code dropdown custom client of a GitLab resource.
 *
 * @param name the name
 * @param sshUrlTemplate the ssh url template
 * @param httpUrlTemplate the http url template
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ApplicationSettings/requestBody/properties/code_dropdown_custom_clients/items")
public record GitLabSettingsUpdateCodeDropdownCustomClient(
        @Nullable String name,
        @Nullable String sshUrlTemplate,
        @Nullable String httpUrlTemplate) {}
