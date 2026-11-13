package io.github.piotr_janczukowicz.gitlab.api.pagesdomains;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab pages domain.
 *
 * @param domain the domain
 * @param url the url
 * @param verified the verified
 * @param verificationCode the verification code
 * @param enabledUntil the enabled until
 * @param autoSslEnabled the auto ssl enabled
 * @param certificate the certificate
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesPagesDomain")
public record GitLabPagesDomain(
        @Nullable String domain,
        @Nullable String url,
        @Nullable String verified,
        @Nullable String verificationCode,
        @Nullable String enabledUntil,
        @Nullable String autoSslEnabled,
        @Nullable GitLabPagesDomainCertificate certificate) {}
