package io.github.piotr_janczukowicz.gitlab.api.datamanagement;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * The git lab admin model checksum information of a GitLab resource.
 *
 * @param checksum the checksum
 * @param lastChecksum the last checksum
 * @param checksumState the checksum state
 * @param checksumRetryCount the checksum retry count
 * @param checksumRetryAt the checksum retry at
 * @param checksumFailure the checksum failure
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesAdminModel/properties/checksum_information")
public record GitLabAdminModelChecksumInformation(
        @Nullable String checksum,
        @Nullable Instant lastChecksum,
        @Nullable String checksumState,
        @Nullable Integer checksumRetryCount,
        @Nullable Instant checksumRetryAt,
        @Nullable String checksumFailure) {}
