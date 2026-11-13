package io.github.piotr_janczukowicz.gitlab.api.namespaces;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.LocalDate;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab namespace.
 *
 * @param id the id
 * @param name the name
 * @param path the path
 * @param kind the kind
 * @param fullPath the full path
 * @param parentId the parent id
 * @param avatarUrl the avatar url
 * @param webUrl the web url
 * @param membersCountWithDescendants the members count with descendants
 * @param rootRepositorySize the root repository size
 * @param projectsCount the projects count
 * @param sharedRunnersMinutesLimit the shared runners minutes limit
 * @param ciMinutesUsage the ci minutes usage
 * @param extraSharedRunnersMinutesLimit the extra shared runners minutes limit
 * @param additionalPurchasedStorageSize the additional purchased storage size
 * @param additionalPurchasedStorageEndsOn the additional purchased storage ends on
 * @param billableMembersCount the billable members count
 * @param seatsInUse the seats in use
 * @param maxSeatsUsed the max seats used
 * @param maxSeatsUsedChangedAt the max seats used changed at
 * @param endDate the end date
 * @param plan the plan
 * @param trialEndsOn the trial ends on
 * @param trial the trial
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesNamespace")
public record GitLabNamespace(
        @Nullable Long id,
        @Nullable String name,
        @Nullable String path,
        @Nullable String kind,
        @Nullable String fullPath,
        @Nullable Long parentId,
        @Nullable String avatarUrl,
        @Nullable String webUrl,
        @Nullable Integer membersCountWithDescendants,
        @Nullable Long rootRepositorySize,
        @Nullable Integer projectsCount,
        @Nullable Integer sharedRunnersMinutesLimit,
        @Nullable GitLabCiMinutesUsage ciMinutesUsage,
        @Nullable Integer extraSharedRunnersMinutesLimit,
        @Nullable Long additionalPurchasedStorageSize,
        @Nullable LocalDate additionalPurchasedStorageEndsOn,
        @Nullable Integer billableMembersCount,
        @Nullable Integer seatsInUse,
        @Nullable Integer maxSeatsUsed,
        @Nullable LocalDate maxSeatsUsedChangedAt,
        @Nullable LocalDate endDate,
        @Nullable String plan,
        @Nullable LocalDate trialEndsOn,
        @Nullable Boolean trial) {}
