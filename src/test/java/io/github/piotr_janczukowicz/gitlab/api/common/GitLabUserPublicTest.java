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
class GitLabUserPublicTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .id(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .username(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPublicEmailIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .publicEmail(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.publicEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .name(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .state(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockedIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .locked(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.locked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvatarUrlIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .avatarUrl(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.avatarUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvatarPathIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .avatarPath(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.avatarPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomAttributesIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .customAttributes(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.customAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .webUrl(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .createdAt(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBioIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .bio(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.bio()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLocationIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .location(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.location()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinkedinIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .linkedin(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.linkedin()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTwitterIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .twitter(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.twitter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiscordIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .discord(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.discord()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebsiteUrlIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .websiteUrl(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.websiteUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGithubIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .github(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.github()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobTitleIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .jobTitle(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.jobTitle()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPronounsIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .pronouns(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.pronouns()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrganizationIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .organization(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.organization()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBotIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .bot(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.bot()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkInformationIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .workInformation(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.workInformation()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFollowersIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .followers(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.followers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFollowingIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .following(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.following()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIsFollowedIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .isFollowed(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.isFollowed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLocalTimeIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .localTime(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.localTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastSignInAtIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .lastSignInAt(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.lastSignInAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfirmedAtIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .confirmedAt(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.confirmedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastActivityOnIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .lastActivityOn(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.lastActivityOn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .email(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.email()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenThemeIdIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .themeId(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.themeId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenColorSchemeIdIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .colorSchemeId(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.colorSchemeId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectsLimitIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .projectsLimit(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.projectsLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCurrentSignInAtIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .currentSignInAt(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.currentSignInAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIdentitiesIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .identities(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.identities()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCanCreateGroupIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .canCreateGroup(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.canCreateGroup()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCanCreateProjectIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .canCreateProject(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.canCreateProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTwoFactorEnabledIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .twoFactorEnabled(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.twoFactorEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .external(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.external()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPrivateProfileIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .privateProfile(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.privateProfile()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitEmailIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .commitEmail(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.commitEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPreferredLanguageIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .preferredLanguage(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.preferredLanguage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSharedRunnersMinutesLimitIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .sharedRunnersMinutesLimit(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.sharedRunnersMinutesLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExtraSharedRunnersMinutesLimitIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .extraSharedRunnersMinutesLimit(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.extraSharedRunnersMinutesLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScimIdentitiesIsNullable() {
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .scimIdentities(null);

        final GitLabUserPublic built = builder.build();

        assertThat(built.scimIdentities()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUserPublic value = CommonCatalogFixtures.userPublic();

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
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUserPublic original = CommonCatalogFixtures.userPublic();

        final GitLabUserPublic rebuilt =
                GitLabUserPublicBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabUserPublicBuilder builder = GitLabUserPublicBuilder.builder(CommonCatalogFixtures.userPublic())
                .createdAt(instant);

        final GitLabUserPublic built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUserPublic.class.getRecordComponents())
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
                        "scimIdentities");
    }
}
