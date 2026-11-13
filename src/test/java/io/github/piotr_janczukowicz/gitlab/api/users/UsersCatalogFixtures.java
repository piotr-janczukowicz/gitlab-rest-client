package io.github.piotr_janczukowicz.gitlab.api.users;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

public final class UsersCatalogFixtures {

    private UsersCatalogFixtures() {}

    public static GitLabImpersonationToken impersonationToken() {
        return GitLabImpersonationTokenBuilder.builder()
                .id(1L)
                .name("John Doe")
                .revoked(true)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .description("Token to manage api")
                .scopes(List.of("api"))
                .userId(1L)
                .lastUsedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .lastUsedIps(List.of("127.0.0.1"))
                .granularScopes(List.of(CommonCatalogFixtures.granularScope()))
                .active(true)
                .granular(true)
                .expiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .impersonation("impersonation")
                .build();
    }

    public static GitLabImpersonationTokenWithToken impersonationTokenWithToken() {
        return GitLabImpersonationTokenWithTokenBuilder.builder()
                .id(1L)
                .name("John Doe")
                .revoked(true)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .description("Token to manage api")
                .scopes(List.of("api"))
                .userId(1L)
                .lastUsedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .lastUsedIps(List.of("127.0.0.1"))
                .granularScopes(List.of(CommonCatalogFixtures.granularScope()))
                .active(true)
                .granular(true)
                .expiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .impersonation("impersonation")
                .token("token")
                .build();
    }

    public static GitLabMembership membership() {
        return GitLabMembershipBuilder.builder()
                .sourceId("source_id")
                .sourceName("source_name")
                .sourceType("source_type")
                .accessLevel("access_level")
                .build();
    }

    public static GitLabUserActivity userActivity() {
        return GitLabUserActivityBuilder.builder()
                .username("johndoe")
                .lastActivityOn(LocalDate.parse("2026-01-01"))
                .lastActivityAt(LocalDate.parse("2026-01-01"))
                .build();
    }

    public static GitLabUserAssociationsCount userAssociationsCount() {
        return GitLabUserAssociationsCountBuilder.builder()
                .groupsCount(1)
                .projectsCount(1)
                .issuesCount(1)
                .mergeRequestsCount(1)
                .build();
    }

    public static GitLabUserCounts userCounts() {
        return GitLabUserCountsBuilder.builder()
                .mergeRequests(1)
                .assignedIssues(1)
                .assignedMergeRequests(1)
                .reviewRequestedMergeRequests(1)
                .todos(1)
                .build();
    }

    public static GitLabUserCreditCardValidations userCreditCardValidations() {
        return GitLabUserCreditCardValidationsBuilder.builder()
                .userId("user_id")
                .creditCardValidatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabUserPreferences userPreferences() {
        return GitLabUserPreferencesBuilder.builder()
                .id(1L)
                .userId(1L)
                .viewDiffsFileByFile(true)
                .showWhitespaceInDiffs(true)
                .passUserIdentitiesToCiJwt(true)
                .policyAdvancedEditor(true)
                .emojiSkinTone("emoji_skin_tone")
                .mobilePushWorkingHoursEnabled(true)
                .mobilePushWorkingHoursStart(1)
                .mobilePushWorkingHoursEnd(1)
                .mobilePushWorkingDays(List.of("monday"))
                .mobilePushWorkingHoursTimeZone("Europe/Berlin")
                .build();
    }

    public static GitLabUserProfile userProfile() {
        return GitLabUserProfileBuilder.builder()
                .id(1L)
                .username("admin")
                .publicEmail("john@example.com")
                .name("Administrator")
                .state("active")
                .locked(true)
                .avatarUrl("https://gravatar.com/avatar/1")
                .avatarPath("/user/avatar/28/The-Big-Lebowski-400-400.png")
                .customAttributes(List.of(CommonCatalogFixtures.customAttribute()))
                .webUrl("https://gitlab.example.com/root")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .bio("bio")
                .location("location")
                .linkedin("linkedin")
                .twitter("twitter")
                .discord("discord")
                .websiteUrl("website_url")
                .github("github")
                .jobTitle("job_title")
                .pronouns("pronouns")
                .organization("organization")
                .bot(true)
                .workInformation("work_information")
                .followers("followers")
                .following("following")
                .isFollowed("is_followed")
                .localTime("local_time")
                .bioHtml("My <em>bio</em>.")
                .build();
    }

    public static GitLabUserStatus userStatus() {
        return GitLabUserStatusBuilder.builder()
                .emoji("coffee")
                .message("I crave coffee")
                .availability("busy")
                .messageHtml("<p dir=\"auto\">I crave coffee</p>")
                .clearStatusAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabUserSupportPin userSupportPin() {
        return GitLabUserSupportPinBuilder.builder()
                .pin("pin")
                .expiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabUsersCreateEmailPayload usersCreateEmailPayload() {
        return GitLabUsersCreateEmailPayloadBuilder.builder()
                .email("email")
                .skipConfirmation(true)
                .build();
    }

    public static GitLabUsersCreateImpersonationTokenGranularScope usersCreateImpersonationTokenGranularScope() {
        return GitLabUsersCreateImpersonationTokenGranularScopeBuilder.builder()
                .access(GitLabUsersCreateImpersonationTokenGranularScopeAccess.PERSONAL_PROJECTS)
                .permissions(List.of("permissions"))
                .projectIds(List.of(1L))
                .groupIds(List.of(1L))
                .build();
    }

    public static GitLabUsersCreateImpersonationTokenPayload usersCreateImpersonationTokenPayload() {
        return GitLabUsersCreateImpersonationTokenPayloadBuilder.builder()
                .name("name")
                .description("description")
                .expiresAt(LocalDate.parse("2026-01-01"))
                .scopes(List.of("scopes"))
                .granularScopes(List.of(UsersCatalogFixtures.usersCreateImpersonationTokenGranularScope()))
                .build();
    }

    public static GitLabUsersCreateRunnerPayload usersCreateRunnerPayload() {
        return GitLabUsersCreateRunnerPayloadBuilder.builder()
                .runnerType(GitLabUsersCreateRunnerType.INSTANCE_TYPE)
                .groupId(1L)
                .projectId(1L)
                .description("description")
                .maintenanceNote("maintenance_note")
                .paused(true)
                .locked(true)
                .accessLevel(GitLabUsersCreateRunnerAccessLevel.NOT_PROTECTED)
                .runUntagged(true)
                .tagList(List.of("tag_list"))
                .maximumTimeout(1)
                .tokenExpiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .tokenRotationDeadline(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabUsersCreditCardValidationPayload usersCreditCardValidationPayload() {
        return GitLabUsersCreditCardValidationPayloadBuilder.builder()
                .creditCardValidatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .creditCardExpirationMonth(1)
                .creditCardExpirationYear(1)
                .creditCardHolderName("credit_card_holder_name")
                .creditCardMaskNumber("credit_card_mask_number")
                .creditCardType("credit_card_type")
                .zuoraPaymentMethodXid("zuora_payment_method_xid")
                .stripeSetupIntentXid("stripe_setup_intent_xid")
                .stripePaymentMethodXid("stripe_payment_method_xid")
                .stripeCardFingerprint("stripe_card_fingerprint")
                .build();
    }

    public static GitLabUsersPatchStatusPayload usersPatchStatusPayload() {
        return GitLabUsersPatchStatusPayloadBuilder.builder()
                .emoji("emoji")
                .message("message")
                .availability("availability")
                .clearStatusAfter(GitLabUsersPatchStatusClearStatusAfter.N_30_MINUTES)
                .build();
    }

    public static GitLabUsersUpdatePreferencePayload usersUpdatePreferencePayload() {
        return GitLabUsersUpdatePreferencePayloadBuilder.builder()
                .viewDiffsFileByFile(true)
                .showWhitespaceInDiffs(true)
                .passUserIdentitiesToCiJwt(true)
                .policyAdvancedEditor(true)
                .emojiSkinTone(GitLabUsersUpdatePreferenceEmojiSkinTone.DEFAULT)
                .mobilePushWorkingHoursEnabled(true)
                .mobilePushWorkingHoursStart(1)
                .mobilePushWorkingHoursEnd(1)
                .mobilePushWorkingDays(List.of(GitLabUsersUpdatePreferenceMobilePushWorkingDays.MONDAY))
                .mobilePushWorkingHoursTimeZone("mobile_push_working_hours_time_zone")
                .build();
    }

    public static GitLabUsersUpdateStatusPayload usersUpdateStatusPayload() {
        return GitLabUsersUpdateStatusPayloadBuilder.builder()
                .emoji("emoji")
                .message("message")
                .availability("availability")
                .clearStatusAfter(GitLabUsersUpdateStatusClearStatusAfter.N_30_MINUTES)
                .build();
    }
}
