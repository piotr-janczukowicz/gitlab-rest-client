package io.github.piotr_janczukowicz.gitlab.api.pagesdomains;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.CatalogSimpleXor;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdPagesDomains}.
 *
 * @param domain the domain
 * @param certificate the certificate
 * @param key the key
 * @param autoSslEnabled the auto ssl enabled
 * @param userProvidedCertificate the user provided certificate
 * @param userProvidedKey the user provided key
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdPagesDomains/requestBody")
public record GitLabProjectPagesDomainsCreatePayload(
        @Nullable String domain,

        @Nullable @CatalogSimpleXor(GitLabAnnotationValues.XOR_STRING_STRING)
        String certificate,

        @Nullable @CatalogSimpleXor(GitLabAnnotationValues.XOR_STRING_STRING)
        String key,

        @Nullable Boolean autoSslEnabled,
        @Nullable String userProvidedCertificate,
        @Nullable String userProvidedKey) {}
