package io.github.piotr_janczukowicz.gitlab.api.attestations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab supply chain attestation.
 *
 * @param id the id
 * @param iid the iid
 * @param createdAt the created at
 * @param updatedAt the updated at
 * @param expireAt the expire at
 * @param projectId the project id
 * @param buildId the build id
 * @param status the status
 * @param predicateKind the predicate kind
 * @param predicateType the predicate type
 * @param subjectDigest the subject digest
 * @param signingMethod the signing method
 * @param downloadUrl the download url
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesSupplyChainAttestation")
public record GitLabSupplyChainAttestation(
        @Nullable Long id,
        @Nullable Long iid,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt,
        @Nullable Instant expireAt,
        @Nullable Long projectId,
        @Nullable Long buildId,
        @Nullable String status,
        @Nullable String predicateKind,
        @Nullable String predicateType,
        @Nullable String subjectDigest,
        @Nullable GitLabSupplyChainAttestationSigningMethod signingMethod,
        @Nullable String downloadUrl) {}
