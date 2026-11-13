package io.github.piotr_janczukowicz.gitlab.api.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabUserProfileTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabUserProfileBuilder builder = GitLabUserProfileBuilder.builder(UsersCatalogFixtures.userProfile())
                .id(null);

        final GitLabUserProfile built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabUserProfileBuilder builder = GitLabUserProfileBuilder.builder(UsersCatalogFixtures.userProfile())
                .username(null);

        final GitLabUserProfile built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPublicEmailIsNullable() {
        final GitLabUserProfileBuilder builder = GitLabUserProfileBuilder.builder(UsersCatalogFixtures.userProfile())
                .publicEmail(null);

        final GitLabUserProfile built = builder.build();

        assertThat(built.publicEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabUserProfileBuilder builder = GitLabUserProfileBuilder.builder(UsersCatalogFixtures.userProfile())
                .name(null);

        final GitLabUserProfile built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabUserProfileBuilder builder = GitLabUserProfileBuilder.builder(UsersCatalogFixtures.userProfile())
                .state(null);

        final GitLabUserProfile built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockedIsNullable() {
        final GitLabUserProfileBuilder builder = GitLabUserProfileBuilder.builder(UsersCatalogFixtures.userProfile())
                .locked(null);

        final GitLabUserProfile built = builder.build();

        assertThat(built.locked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvatarUrlIsNullable() {
        final GitLabUserProfileBuilder builder = GitLabUserProfileBuilder.builder(UsersCatalogFixtures.userProfile())
                .avatarUrl(null);

        final GitLabUserProfile built = builder.build();

        assertThat(built.avatarUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvatarPathIsNullable() {
        final GitLabUserProfileBuilder builder = GitLabUserProfileBuilder.builder(UsersCatalogFixtures.userProfile())
                .avatarPath(null);

        final GitLabUserProfile built = builder.build();

        assertThat(built.avatarPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomAttributesIsNullable() {
        final GitLabUserProfileBuilder builder = GitLabUserProfileBuilder.builder(UsersCatalogFixtures.userProfile())
                .customAttributes(null);

        final GitLabUserProfile built = builder.build();

        assertThat(built.customAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabUserProfileBuilder builder = GitLabUserProfileBuilder.builder(UsersCatalogFixtures.userProfile())
                .webUrl(null);

        final GitLabUserProfile built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabUserProfileBuilder builder = GitLabUserProfileBuilder.builder(UsersCatalogFixtures.userProfile())
                .createdAt(null);

        final GitLabUserProfile built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBioIsNullable() {
        final GitLabUserProfileBuilder builder = GitLabUserProfileBuilder.builder(UsersCatalogFixtures.userProfile())
                .bio(null);

        final GitLabUserProfile built = builder.build();

        assertThat(built.bio()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLocationIsNullable() {
        final GitLabUserProfileBuilder builder = GitLabUserProfileBuilder.builder(UsersCatalogFixtures.userProfile())
                .location(null);

        final GitLabUserProfile built = builder.build();

        assertThat(built.location()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinkedinIsNullable() {
        final GitLabUserProfileBuilder builder = GitLabUserProfileBuilder.builder(UsersCatalogFixtures.userProfile())
                .linkedin(null);

        final GitLabUserProfile built = builder.build();

        assertThat(built.linkedin()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTwitterIsNullable() {
        final GitLabUserProfileBuilder builder = GitLabUserProfileBuilder.builder(UsersCatalogFixtures.userProfile())
                .twitter(null);

        final GitLabUserProfile built = builder.build();

        assertThat(built.twitter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiscordIsNullable() {
        final GitLabUserProfileBuilder builder = GitLabUserProfileBuilder.builder(UsersCatalogFixtures.userProfile())
                .discord(null);

        final GitLabUserProfile built = builder.build();

        assertThat(built.discord()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebsiteUrlIsNullable() {
        final GitLabUserProfileBuilder builder = GitLabUserProfileBuilder.builder(UsersCatalogFixtures.userProfile())
                .websiteUrl(null);

        final GitLabUserProfile built = builder.build();

        assertThat(built.websiteUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGithubIsNullable() {
        final GitLabUserProfileBuilder builder = GitLabUserProfileBuilder.builder(UsersCatalogFixtures.userProfile())
                .github(null);

        final GitLabUserProfile built = builder.build();

        assertThat(built.github()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobTitleIsNullable() {
        final GitLabUserProfileBuilder builder = GitLabUserProfileBuilder.builder(UsersCatalogFixtures.userProfile())
                .jobTitle(null);

        final GitLabUserProfile built = builder.build();

        assertThat(built.jobTitle()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPronounsIsNullable() {
        final GitLabUserProfileBuilder builder = GitLabUserProfileBuilder.builder(UsersCatalogFixtures.userProfile())
                .pronouns(null);

        final GitLabUserProfile built = builder.build();

        assertThat(built.pronouns()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrganizationIsNullable() {
        final GitLabUserProfileBuilder builder = GitLabUserProfileBuilder.builder(UsersCatalogFixtures.userProfile())
                .organization(null);

        final GitLabUserProfile built = builder.build();

        assertThat(built.organization()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBotIsNullable() {
        final GitLabUserProfileBuilder builder = GitLabUserProfileBuilder.builder(UsersCatalogFixtures.userProfile())
                .bot(null);

        final GitLabUserProfile built = builder.build();

        assertThat(built.bot()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkInformationIsNullable() {
        final GitLabUserProfileBuilder builder = GitLabUserProfileBuilder.builder(UsersCatalogFixtures.userProfile())
                .workInformation(null);

        final GitLabUserProfile built = builder.build();

        assertThat(built.workInformation()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFollowersIsNullable() {
        final GitLabUserProfileBuilder builder = GitLabUserProfileBuilder.builder(UsersCatalogFixtures.userProfile())
                .followers(null);

        final GitLabUserProfile built = builder.build();

        assertThat(built.followers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFollowingIsNullable() {
        final GitLabUserProfileBuilder builder = GitLabUserProfileBuilder.builder(UsersCatalogFixtures.userProfile())
                .following(null);

        final GitLabUserProfile built = builder.build();

        assertThat(built.following()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIsFollowedIsNullable() {
        final GitLabUserProfileBuilder builder = GitLabUserProfileBuilder.builder(UsersCatalogFixtures.userProfile())
                .isFollowed(null);

        final GitLabUserProfile built = builder.build();

        assertThat(built.isFollowed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLocalTimeIsNullable() {
        final GitLabUserProfileBuilder builder = GitLabUserProfileBuilder.builder(UsersCatalogFixtures.userProfile())
                .localTime(null);

        final GitLabUserProfile built = builder.build();

        assertThat(built.localTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBioHtmlIsNullable() {
        final GitLabUserProfileBuilder builder = GitLabUserProfileBuilder.builder(UsersCatalogFixtures.userProfile())
                .bioHtml(null);

        final GitLabUserProfile built = builder.build();

        assertThat(built.bioHtml()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUserProfile value = UsersCatalogFixtures.userProfile();

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
            softly.assertThat(value.bioHtml()).isEqualTo("My <em>bio</em>.");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUserProfile original = UsersCatalogFixtures.userProfile();

        final GitLabUserProfile rebuilt =
                GitLabUserProfileBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabUserProfileBuilder builder = GitLabUserProfileBuilder.builder(UsersCatalogFixtures.userProfile())
                .createdAt(instant);

        final GitLabUserProfile built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUserProfile.class.getRecordComponents())
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
                        "bioHtml");
    }
}
