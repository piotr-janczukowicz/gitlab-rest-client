package io.github.piotr_janczukowicz.gitlab.api.pagesdomains;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.CatalogSimpleXor;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdPagesDomainsDomain}.
 *
 * @param certificate the certificate
 * @param key the key
 * @param autoSslEnabled the auto ssl enabled
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdPagesDomainsDomain/requestBody")
public record GitLabProjectPagesDomainsUpdatePayload(
        @Nullable @CatalogSimpleXor(GitLabAnnotationValues.XOR_STRING_STRING)
        String certificate,

        @Nullable @CatalogSimpleXor(GitLabAnnotationValues.XOR_STRING_STRING)
        String key,

        @Nullable Boolean autoSslEnabled) {}
