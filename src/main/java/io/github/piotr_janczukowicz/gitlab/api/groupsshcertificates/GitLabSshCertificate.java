package io.github.piotr_janczukowicz.gitlab.api.groupsshcertificates;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ssh certificate.
 *
 * @param id the id
 * @param title the title
 * @param key the key
 * @param fingerprint the fingerprint
 * @param createdAt the created at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesSshCertificate")
public record GitLabSshCertificate(
        @Nullable Long id,
        @Nullable String title,
        @Nullable String key,
        @Nullable String fingerprint,
        @Nullable Instant createdAt) {}
