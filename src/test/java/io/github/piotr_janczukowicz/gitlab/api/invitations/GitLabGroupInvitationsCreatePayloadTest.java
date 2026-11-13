package io.github.piotr_janczukowicz.gitlab.api.invitations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupInvitationsCreatePayloadTest {

    @Test
    void constructor_shouldRefuseNull_whenAccessLevelIsNull() {
        final GitLabGroupInvitationsCreatePayloadBuilder builder = GitLabGroupInvitationsCreatePayloadBuilder.builder(
                        InvitationsCatalogFixtures.groupInvitationsCreatePayload())
                .accessLevel(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("accessLevel");
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailIsNullable() {
        final GitLabGroupInvitationsCreatePayloadBuilder builder = GitLabGroupInvitationsCreatePayloadBuilder.builder(
                        InvitationsCatalogFixtures.groupInvitationsCreatePayload())
                .email(null);

        final GitLabGroupInvitationsCreatePayload built = builder.build();

        assertThat(built.email()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabGroupInvitationsCreatePayloadBuilder builder = GitLabGroupInvitationsCreatePayloadBuilder.builder(
                        InvitationsCatalogFixtures.groupInvitationsCreatePayload())
                .userId(null);

        final GitLabGroupInvitationsCreatePayload built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabGroupInvitationsCreatePayloadBuilder builder = GitLabGroupInvitationsCreatePayloadBuilder.builder(
                        InvitationsCatalogFixtures.groupInvitationsCreatePayload())
                .expiresAt(null);

        final GitLabGroupInvitationsCreatePayload built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInviteSourceIsNullable() {
        final GitLabGroupInvitationsCreatePayloadBuilder builder = GitLabGroupInvitationsCreatePayloadBuilder.builder(
                        InvitationsCatalogFixtures.groupInvitationsCreatePayload())
                .inviteSource(null);

        final GitLabGroupInvitationsCreatePayload built = builder.build();

        assertThat(built.inviteSource()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMemberRoleIdIsNullable() {
        final GitLabGroupInvitationsCreatePayloadBuilder builder = GitLabGroupInvitationsCreatePayloadBuilder.builder(
                        InvitationsCatalogFixtures.groupInvitationsCreatePayload())
                .memberRoleId(null);

        final GitLabGroupInvitationsCreatePayload built = builder.build();

        assertThat(built.memberRoleId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupInvitationsCreatePayload value = InvitationsCatalogFixtures.groupInvitationsCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.accessLevel()).isEqualTo(GitLabGroupInvitationsCreateAccessLevel.GUEST);
            softly.assertThat(value.email()).isEqualTo(List.of("email"));
            softly.assertThat(value.userId()).isEqualTo(List.of("user_id"));
            softly.assertThat(value.expiresAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.inviteSource()).isEqualTo("invite_source");
            softly.assertThat(value.memberRoleId()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupInvitationsCreatePayload original = InvitationsCatalogFixtures.groupInvitationsCreatePayload();

        final GitLabGroupInvitationsCreatePayload rebuilt =
                GitLabGroupInvitationsCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenEmailSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("email"));
        final GitLabGroupInvitationsCreatePayload built = GitLabGroupInvitationsCreatePayloadBuilder.builder(
                        InvitationsCatalogFixtures.groupInvitationsCreatePayload())
                .email(source)
                .build();
        source.clear();

        assertThat(built.email()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenEmailIsRead() {
        final GitLabGroupInvitationsCreatePayload built = InvitationsCatalogFixtures.groupInvitationsCreatePayload();
        final List<String> values = built.email();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenUserIdSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("user_id"));
        final GitLabGroupInvitationsCreatePayload built = GitLabGroupInvitationsCreatePayloadBuilder.builder(
                        InvitationsCatalogFixtures.groupInvitationsCreatePayload())
                .userId(source)
                .build();
        source.clear();

        assertThat(built.userId()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenUserIdIsRead() {
        final GitLabGroupInvitationsCreatePayload built = InvitationsCatalogFixtures.groupInvitationsCreatePayload();
        final List<String> values = built.userId();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupInvitationsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("accessLevel", "email", "userId", "expiresAt", "inviteSource", "memberRoleId");
    }
}
