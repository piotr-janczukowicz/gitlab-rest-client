package io.github.piotr_janczukowicz.gitlab.api.pagessettings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code patchApiV4ProjectsIdPages}.
 *
 * @param pagesUniqueDomainEnabled the pages unique domain enabled
 * @param pagesHttpsOnly the pages https only
 * @param pagesPrimaryDomain the pages primary domain
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/patchApiV4ProjectsIdPages/requestBody")
public record GitLabProjectPagesSettingsUpdatePayload(
        @Nullable Boolean pagesUniqueDomainEnabled,
        @Nullable Boolean pagesHttpsOnly,
        @Nullable String pagesPrimaryDomain) {}
