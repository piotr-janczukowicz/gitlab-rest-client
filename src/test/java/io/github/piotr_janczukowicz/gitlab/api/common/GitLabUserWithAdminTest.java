package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabUserWithAdminTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .id(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .username(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPublicEmailIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .publicEmail(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.publicEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .name(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .state(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockedIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .locked(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.locked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvatarUrlIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .avatarUrl(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.avatarUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvatarPathIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .avatarPath(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.avatarPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomAttributesIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .customAttributes(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.customAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .webUrl(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .createdAt(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBioIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .bio(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.bio()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLocationIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .location(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.location()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinkedinIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .linkedin(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.linkedin()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTwitterIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .twitter(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.twitter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiscordIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .discord(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.discord()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebsiteUrlIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .websiteUrl(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.websiteUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGithubIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .github(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.github()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobTitleIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .jobTitle(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.jobTitle()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPronounsIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .pronouns(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.pronouns()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrganizationIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .organization(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.organization()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBotIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .bot(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.bot()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkInformationIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .workInformation(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.workInformation()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFollowersIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .followers(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.followers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFollowingIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .following(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.following()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIsFollowedIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .isFollowed(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.isFollowed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLocalTimeIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .localTime(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.localTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastSignInAtIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .lastSignInAt(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.lastSignInAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfirmedAtIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .confirmedAt(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.confirmedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastActivityOnIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .lastActivityOn(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.lastActivityOn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .email(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.email()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThemeIdIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .themeId(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.themeId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenColorSchemeIdIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .colorSchemeId(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.colorSchemeId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectsLimitIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .projectsLimit(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.projectsLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCurrentSignInAtIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .currentSignInAt(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.currentSignInAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIdentitiesIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .identities(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.identities()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCanCreateGroupIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .canCreateGroup(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.canCreateGroup()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCanCreateProjectIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .canCreateProject(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.canCreateProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTwoFactorEnabledIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .twoFactorEnabled(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.twoFactorEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .external(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.external()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPrivateProfileIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .privateProfile(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.privateProfile()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitEmailIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .commitEmail(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.commitEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPreferredLanguageIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .preferredLanguage(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.preferredLanguage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSharedRunnersMinutesLimitIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .sharedRunnersMinutesLimit(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.sharedRunnersMinutesLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExtraSharedRunnersMinutesLimitIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .extraSharedRunnersMinutesLimit(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.extraSharedRunnersMinutesLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScimIdentitiesIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .scimIdentities(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.scimIdentities()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIsAdminIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .isAdmin(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.isAdmin()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNoteIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .note(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.note()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespaceIdIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .namespaceId(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.namespaceId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProvisionedByProjectIdIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .provisionedByProjectId(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.provisionedByProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedByIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .createdBy(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.createdBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsingLicenseSeatIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .usingLicenseSeat(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.usingLicenseSeat()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIsAuditorIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .isAuditor(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.isAuditor()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProvisionedByGroupIdIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .provisionedByGroupId(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.provisionedByGroupId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnterpriseGroupIdIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .enterpriseGroupId(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.enterpriseGroupId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnterpriseGroupAssociatedAtIsNullable() {
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .enterpriseGroupAssociatedAt(null);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.enterpriseGroupAssociatedAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUserWithAdmin value = CommonCatalogFixtures.userWithAdmin();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.username()).isEqualTo("admin");
            softly.assertThat(value.publicEmail()).isEqualTo("john@example.com");
            softly.assertThat(value.name()).isEqualTo("Administrator");
            softly.assertThat(value.state()).isEqualTo("active");
            softly.assertThat(value.locked()).isEqualTo(true);
            softly.assertThat(value.avatarUrl()).isEqualTo("https://gravatar.com/avatar/1");
            softly.assertThat(value.avatarPath()).isEqualTo("/user/avatar/28/The-Big-Lebowski-400-400.png");
            softly.assertThat(value.customAttributes()).isEqualTo(List.of(CommonCatalogFixtures.customAttribute()));
            softly.assertThat(value.webUrl()).isEqualTo("https://gitlab.example.com/root");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.bio()).isEqualTo("bio");
            softly.assertThat(value.location()).isEqualTo("location");
            softly.assertThat(value.linkedin()).isEqualTo("linkedin");
            softly.assertThat(value.twitter()).isEqualTo("twitter");
            softly.assertThat(value.discord()).isEqualTo("discord");
            softly.assertThat(value.websiteUrl()).isEqualTo("website_url");
            softly.assertThat(value.github()).isEqualTo("github");
            softly.assertThat(value.jobTitle()).isEqualTo("job_title");
            softly.assertThat(value.pronouns()).isEqualTo("pronouns");
            softly.assertThat(value.organization()).isEqualTo("organization");
            softly.assertThat(value.bot()).isEqualTo(true);
            softly.assertThat(value.workInformation()).isEqualTo("work_information");
            softly.assertThat(value.followers()).isEqualTo("followers");
            softly.assertThat(value.following()).isEqualTo("following");
            softly.assertThat(value.isFollowed()).isEqualTo("is_followed");
            softly.assertThat(value.localTime()).isEqualTo("local_time");
            softly.assertThat(value.lastSignInAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.confirmedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.lastActivityOn()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.email()).isEqualTo("john@example.com");
            softly.assertThat(value.themeId()).isEqualTo(1L);
            softly.assertThat(value.colorSchemeId()).isEqualTo(1L);
            softly.assertThat(value.projectsLimit()).isEqualTo(1);
            softly.assertThat(value.currentSignInAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.identities()).isEqualTo(List.of(CommonCatalogFixtures.identity()));
            softly.assertThat(value.canCreateGroup()).isEqualTo(true);
            softly.assertThat(value.canCreateProject()).isEqualTo(true);
            softly.assertThat(value.twoFactorEnabled()).isEqualTo(true);
            softly.assertThat(value.external()).isEqualTo(true);
            softly.assertThat(value.privateProfile()).isEqualTo(true);
            softly.assertThat(value.commitEmail()).isEqualTo("commit_email");
            softly.assertThat(value.preferredLanguage()).isEqualTo("en");
            softly.assertThat(value.sharedRunnersMinutesLimit()).isEqualTo("shared_runners_minutes_limit");
            softly.assertThat(value.extraSharedRunnersMinutesLimit()).isEqualTo("extra_shared_runners_minutes_limit");
            softly.assertThat(value.scimIdentities()).isEqualTo(List.of(CommonCatalogFixtures.scimIdentity()));
            softly.assertThat(value.isAdmin()).isEqualTo("is_admin");
            softly.assertThat(value.note()).isEqualTo("note");
            softly.assertThat(value.namespaceId()).isEqualTo("namespace_id");
            softly.assertThat(value.provisionedByProjectId()).isEqualTo("provisioned_by_project_id");
            softly.assertThat(value.createdBy()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.usingLicenseSeat()).isEqualTo("using_license_seat");
            softly.assertThat(value.isAuditor()).isEqualTo("is_auditor");
            softly.assertThat(value.provisionedByGroupId()).isEqualTo("provisioned_by_group_id");
            softly.assertThat(value.enterpriseGroupId()).isEqualTo("enterprise_group_id");
            softly.assertThat(value.enterpriseGroupAssociatedAt()).isEqualTo("enterprise_group_associated_at");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUserWithAdmin original = CommonCatalogFixtures.userWithAdmin();

        final GitLabUserWithAdmin rebuilt =
                GitLabUserWithAdminBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabUserWithAdminBuilder builder = GitLabUserWithAdminBuilder.builder(
                        CommonCatalogFixtures.userWithAdmin())
                .createdAt(instant);

        final GitLabUserWithAdmin built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUserWithAdmin.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "username",
                        "publicEmail",
                        "name",
                        "state",
                        "locked",
                        "avatarUrl",
                        "avatarPath",
                        "customAttributes",
                        "webUrl",
                        "createdAt",
                        "bio",
                        "location",
                        "linkedin",
                        "twitter",
                        "discord",
                        "websiteUrl",
                        "github",
                        "jobTitle",
                        "pronouns",
                        "organization",
                        "bot",
                        "workInformation",
                        "followers",
                        "following",
                        "isFollowed",
                        "localTime",
                        "lastSignInAt",
                        "confirmedAt",
                        "lastActivityOn",
                        "email",
                        "themeId",
                        "colorSchemeId",
                        "projectsLimit",
                        "currentSignInAt",
                        "identities",
                        "canCreateGroup",
                        "canCreateProject",
                        "twoFactorEnabled",
                        "external",
                        "privateProfile",
                        "commitEmail",
                        "preferredLanguage",
                        "sharedRunnersMinutesLimit",
                        "extraSharedRunnersMinutesLimit",
                        "scimIdentities",
                        "isAdmin",
                        "note",
                        "namespaceId",
                        "provisionedByProjectId",
                        "createdBy",
                        "usingLicenseSeat",
                        "isAuditor",
                        "provisionedByGroupId",
                        "enterpriseGroupId",
                        "enterpriseGroupAssociatedAt");
    }
}
