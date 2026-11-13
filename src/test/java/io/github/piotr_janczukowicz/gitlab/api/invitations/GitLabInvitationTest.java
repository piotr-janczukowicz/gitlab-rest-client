package io.github.piotr_janczukowicz.gitlab.api.invitations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInvitationTest {

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabInvitationBuilder builder = GitLabInvitationBuilder.builder(InvitationsCatalogFixtures.invitation())
                .accessLevel(null);

        final GitLabInvitation built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabInvitationBuilder builder = GitLabInvitationBuilder.builder(InvitationsCatalogFixtures.invitation())
                .createdAt(null);

        final GitLabInvitation built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabInvitationBuilder builder = GitLabInvitationBuilder.builder(InvitationsCatalogFixtures.invitation())
                .expiresAt(null);

        final GitLabInvitation built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInviteEmailIsNullable() {
        final GitLabInvitationBuilder builder = GitLabInvitationBuilder.builder(InvitationsCatalogFixtures.invitation())
                .inviteEmail(null);

        final GitLabInvitation built = builder.build();

        assertThat(built.inviteEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInviteTokenIsNullable() {
        final GitLabInvitationBuilder builder = GitLabInvitationBuilder.builder(InvitationsCatalogFixtures.invitation())
                .inviteToken(null);

        final GitLabInvitation built = builder.build();

        assertThat(built.inviteToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserNameIsNullable() {
        final GitLabInvitationBuilder builder = GitLabInvitationBuilder.builder(InvitationsCatalogFixtures.invitation())
                .userName(null);

        final GitLabInvitation built = builder.build();

        assertThat(built.userName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedByNameIsNullable() {
        final GitLabInvitationBuilder builder = GitLabInvitationBuilder.builder(InvitationsCatalogFixtures.invitation())
                .createdByName(null);

        final GitLabInvitation built = builder.build();

        assertThat(built.createdByName()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInvitation value = InvitationsCatalogFixtures.invitation();

        assertSoftly(softly -> {
            softly.assertThat(value.accessLevel()).isEqualTo("access_level");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.expiresAt()).isEqualTo("expires_at");
            softly.assertThat(value.inviteEmail()).isEqualTo("invite_email");
            softly.assertThat(value.inviteToken()).isEqualTo("invite_token");
            softly.assertThat(value.userName()).isEqualTo("user_name");
            softly.assertThat(value.createdByName()).isEqualTo("created_by_name");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInvitation original = InvitationsCatalogFixtures.invitation();

        final GitLabInvitation rebuilt =
                GitLabInvitationBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenInviteTokenIsACredential() {
        final GitLabInvitation value = InvitationsCatalogFixtures.invitation();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabInvitationBuilder builder = GitLabInvitationBuilder.builder(InvitationsCatalogFixtures.invitation())
                .createdAt(instant);

        final GitLabInvitation built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabInvitation.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "accessLevel",
                        "createdAt",
                        "expiresAt",
                        "inviteEmail",
                        "inviteToken",
                        "userName",
                        "createdByName");
    }
}
