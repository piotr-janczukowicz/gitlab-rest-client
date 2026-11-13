package io.github.piotr_janczukowicz.gitlab.api.members;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.time.LocalDate;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab billable membership.
 *
 * @param id the id
 * @param sourceId the source id
 * @param sourceFullName the source full name
 * @param sourceMembersUrl the source members url
 * @param createdAt the created at
 * @param expiresAt the expires at
 * @param accessLevel the access level
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesBillableMembership")
public record GitLabBillableMembership(
        @Nullable Long id,
        @Nullable Long sourceId,
        @Nullable String sourceFullName,
        @Nullable String sourceMembersUrl,
        @Nullable Instant createdAt,
        @Nullable LocalDate expiresAt,
        @Nullable GitLabBillableMembershipAccessLevel accessLevel) {}
