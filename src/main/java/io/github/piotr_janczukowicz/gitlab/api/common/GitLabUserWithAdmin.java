package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab user with admin.
 *
 * @param id the id
 * @param username the username
 * @param publicEmail the public email
 * @param name the name
 * @param state the state
 * @param locked the locked
 * @param avatarUrl the avatar url
 * @param avatarPath the avatar path
 * @param customAttributes the custom attributes
 * @param webUrl the web url
 * @param createdAt the created at
 * @param bio the bio
 * @param location the location
 * @param linkedin the linkedin
 * @param twitter the twitter
 * @param discord the discord
 * @param websiteUrl the website url
 * @param github the github
 * @param jobTitle the job title
 * @param pronouns the pronouns
 * @param organization the organization
 * @param bot the bot
 * @param workInformation the work information
 * @param followers the followers
 * @param following the following
 * @param isFollowed the is followed
 * @param localTime the local time
 * @param lastSignInAt the last sign in at
 * @param confirmedAt the confirmed at
 * @param lastActivityOn the last activity on
 * @param email the email
 * @param themeId the theme id
 * @param colorSchemeId the color scheme id
 * @param projectsLimit the projects limit
 * @param currentSignInAt the current sign in at
 * @param identities the identities
 * @param canCreateGroup the can create group
 * @param canCreateProject the can create project
 * @param twoFactorEnabled the two factor enabled
 * @param external the external
 * @param privateProfile the private profile
 * @param commitEmail the commit email
 * @param preferredLanguage the preferred language
 * @param sharedRunnersMinutesLimit the shared runners minutes limit
 * @param extraSharedRunnersMinutesLimit the extra shared runners minutes limit
 * @param scimIdentities the scim identities
 * @param isAdmin the is admin
 * @param note the note
 * @param namespaceId the namespace id
 * @param provisionedByProjectId the provisioned by project id
 * @param createdBy the created by
 * @param usingLicenseSeat the using license seat
 * @param isAuditor the is auditor
 * @param provisionedByGroupId the provisioned by group id
 * @param enterpriseGroupId the enterprise group id
 * @param enterpriseGroupAssociatedAt the enterprise group associated at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesUserWithAdmin")
public record GitLabUserWithAdmin(
        @Nullable Long id,
        @Nullable String username,
        @Nullable String publicEmail,
        @Nullable String name,
        @Nullable String state,
        @Nullable Boolean locked,
        @Nullable String avatarUrl,
        @Nullable String avatarPath,
        @Nullable List<GitLabCustomAttribute> customAttributes,
        @Nullable String webUrl,

        @Nullable @SuppressSchemaTypeMismatch("type rule: date-time (created_at)")
        Instant createdAt,

        @Nullable String bio,
        @Nullable String location,
        @Nullable String linkedin,
        @Nullable String twitter,
        @Nullable String discord,
        @Nullable String websiteUrl,
        @Nullable String github,
        @Nullable String jobTitle,
        @Nullable String pronouns,
        @Nullable String organization,
        @Nullable Boolean bot,
        @Nullable String workInformation,
        @Nullable String followers,
        @Nullable String following,
        @Nullable String isFollowed,
        @Nullable String localTime,
        @Nullable Instant lastSignInAt,
        @Nullable Instant confirmedAt,
        @Nullable LocalDate lastActivityOn,
        @Nullable String email,
        @Nullable Long themeId,
        @Nullable Long colorSchemeId,
        @Nullable Integer projectsLimit,
        @Nullable Instant currentSignInAt,
        @Nullable List<GitLabIdentity> identities,
        @Nullable Boolean canCreateGroup,
        @Nullable Boolean canCreateProject,
        @Nullable Boolean twoFactorEnabled,
        @Nullable Boolean external,
        @Nullable Boolean privateProfile,
        @Nullable String commitEmail,
        @Nullable String preferredLanguage,
        @Nullable String sharedRunnersMinutesLimit,
        @Nullable String extraSharedRunnersMinutesLimit,
        @Nullable List<GitLabScimIdentity> scimIdentities,
        @Nullable String isAdmin,
        @Nullable String note,
        @Nullable String namespaceId,
        @Nullable String provisionedByProjectId,
        @Nullable GitLabUserBasic createdBy,
        @Nullable String usingLicenseSeat,
        @Nullable String isAuditor,
        @Nullable String provisionedByGroupId,
        @Nullable String enterpriseGroupId,
        @Nullable String enterpriseGroupAssociatedAt) {}
