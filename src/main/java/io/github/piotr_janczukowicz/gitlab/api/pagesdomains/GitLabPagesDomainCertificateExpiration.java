package io.github.piotr_janczukowicz.gitlab.api.pagesdomains;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab pages domain certificate expiration.
 *
 * @param expired the expired
 * @param expiration the expiration
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesPagesDomainCertificateExpiration")
public record GitLabPagesDomainCertificateExpiration(
        @Nullable String expired, @Nullable String expiration) {}
