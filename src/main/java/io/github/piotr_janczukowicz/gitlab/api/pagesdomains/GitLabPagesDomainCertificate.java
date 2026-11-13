package io.github.piotr_janczukowicz.gitlab.api.pagesdomains;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab pages domain certificate.
 *
 * @param subject the subject
 * @param expired the expired
 * @param certificate the certificate
 * @param certificateText the certificate text
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesPagesDomainCertificate")
public record GitLabPagesDomainCertificate(
        @Nullable String subject,
        @Nullable String expired,
        @Nullable String certificate,
        @Nullable String certificateText) {}
