package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabUserTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabUserBuilder builder =
                GitLabUserBuilder.builder(CommonCatalogFixtures.user()).id(null);

        final GitLabUser built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabUserBuilder builder =
                GitLabUserBuilder.builder(CommonCatalogFixtures.user()).username(null);

        final GitLabUser built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPublicEmailIsNullable() {
        final GitLabUserBuilder builder =
                GitLabUserBuilder.builder(CommonCatalogFixtures.user()).publicEmail(null);

        final GitLabUser built = builder.build();

        assertThat(built.publicEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabUserBuilder builder =
                GitLabUserBuilder.builder(CommonCatalogFixtures.user()).name(null);

        final GitLabUser built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabUserBuilder builder =
                GitLabUserBuilder.builder(CommonCatalogFixtures.user()).state(null);

        final GitLabUser built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockedIsNullable() {
        final GitLabUserBuilder builder =
                GitLabUserBuilder.builder(CommonCatalogFixtures.user()).locked(null);

        final GitLabUser built = builder.build();

        assertThat(built.locked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvatarUrlIsNullable() {
        final GitLabUserBuilder builder =
                GitLabUserBuilder.builder(CommonCatalogFixtures.user()).avatarUrl(null);

        final GitLabUser built = builder.build();

        assertThat(built.avatarUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvatarPathIsNullable() {
        final GitLabUserBuilder builder =
                GitLabUserBuilder.builder(CommonCatalogFixtures.user()).avatarPath(null);

        final GitLabUser built = builder.build();

        assertThat(built.avatarPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomAttributesIsNullable() {
        final GitLabUserBuilder builder =
                GitLabUserBuilder.builder(CommonCatalogFixtures.user()).customAttributes(null);

        final GitLabUser built = builder.build();

        assertThat(built.customAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabUserBuilder builder =
                GitLabUserBuilder.builder(CommonCatalogFixtures.user()).webUrl(null);

        final GitLabUser built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabUserBuilder builder =
                GitLabUserBuilder.builder(CommonCatalogFixtures.user()).createdAt(null);

        final GitLabUser built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBioIsNullable() {
        final GitLabUserBuilder builder =
                GitLabUserBuilder.builder(CommonCatalogFixtures.user()).bio(null);

        final GitLabUser built = builder.build();

        assertThat(built.bio()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLocationIsNullable() {
        final GitLabUserBuilder builder =
                GitLabUserBuilder.builder(CommonCatalogFixtures.user()).location(null);

        final GitLabUser built = builder.build();

        assertThat(built.location()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinkedinIsNullable() {
        final GitLabUserBuilder builder =
                GitLabUserBuilder.builder(CommonCatalogFixtures.user()).linkedin(null);

        final GitLabUser built = builder.build();

        assertThat(built.linkedin()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTwitterIsNullable() {
        final GitLabUserBuilder builder =
                GitLabUserBuilder.builder(CommonCatalogFixtures.user()).twitter(null);

        final GitLabUser built = builder.build();

        assertThat(built.twitter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiscordIsNullable() {
        final GitLabUserBuilder builder =
                GitLabUserBuilder.builder(CommonCatalogFixtures.user()).discord(null);

        final GitLabUser built = builder.build();

        assertThat(built.discord()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebsiteUrlIsNullable() {
        final GitLabUserBuilder builder =
                GitLabUserBuilder.builder(CommonCatalogFixtures.user()).websiteUrl(null);

        final GitLabUser built = builder.build();

        assertThat(built.websiteUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGithubIsNullable() {
        final GitLabUserBuilder builder =
                GitLabUserBuilder.builder(CommonCatalogFixtures.user()).github(null);

        final GitLabUser built = builder.build();

        assertThat(built.github()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobTitleIsNullable() {
        final GitLabUserBuilder builder =
                GitLabUserBuilder.builder(CommonCatalogFixtures.user()).jobTitle(null);

        final GitLabUser built = builder.build();

        assertThat(built.jobTitle()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPronounsIsNullable() {
        final GitLabUserBuilder builder =
                GitLabUserBuilder.builder(CommonCatalogFixtures.user()).pronouns(null);

        final GitLabUser built = builder.build();

        assertThat(built.pronouns()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrganizationIsNullable() {
        final GitLabUserBuilder builder =
                GitLabUserBuilder.builder(CommonCatalogFixtures.user()).organization(null);

        final GitLabUser built = builder.build();

        assertThat(built.organization()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBotIsNullable() {
        final GitLabUserBuilder builder =
                GitLabUserBuilder.builder(CommonCatalogFixtures.user()).bot(null);

        final GitLabUser built = builder.build();

        assertThat(built.bot()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkInformationIsNullable() {
        final GitLabUserBuilder builder =
                GitLabUserBuilder.builder(CommonCatalogFixtures.user()).workInformation(null);

        final GitLabUser built = builder.build();

        assertThat(built.workInformation()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFollowersIsNullable() {
        final GitLabUserBuilder builder =
                GitLabUserBuilder.builder(CommonCatalogFixtures.user()).followers(null);

        final GitLabUser built = builder.build();

        assertThat(built.followers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFollowingIsNullable() {
        final GitLabUserBuilder builder =
                GitLabUserBuilder.builder(CommonCatalogFixtures.user()).following(null);

        final GitLabUser built = builder.build();

        assertThat(built.following()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIsFollowedIsNullable() {
        final GitLabUserBuilder builder =
                GitLabUserBuilder.builder(CommonCatalogFixtures.user()).isFollowed(null);

        final GitLabUser built = builder.build();

        assertThat(built.isFollowed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLocalTimeIsNullable() {
        final GitLabUserBuilder builder =
                GitLabUserBuilder.builder(CommonCatalogFixtures.user()).localTime(null);

        final GitLabUser built = builder.build();

        assertThat(built.localTime()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUser value = CommonCatalogFixtures.user();

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
            softly.assertThat(value.followers()).isEqualTo(1);
            softly.assertThat(value.following()).isEqualTo(1);
            softly.assertThat(value.isFollowed()).isEqualTo(true);
            softly.assertThat(value.localTime()).isEqualTo("local_time");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUser original = CommonCatalogFixtures.user();

        final GitLabUser rebuilt = GitLabUserBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabUserBuilder builder =
                GitLabUserBuilder.builder(CommonCatalogFixtures.user()).createdAt(instant);

        final GitLabUser built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUser.class.getRecordComponents())
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
                        "localTime");
    }
}
