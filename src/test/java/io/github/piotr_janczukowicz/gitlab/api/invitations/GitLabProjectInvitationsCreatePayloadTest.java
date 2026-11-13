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
class GitLabProjectInvitationsCreatePayloadTest {

    @Test
    void constructor_shouldRefuseNull_whenAccessLevelIsNull() {
        final GitLabProjectInvitationsCreatePayloadBuilder builder =
                GitLabProjectInvitationsCreatePayloadBuilder.builder(
                                InvitationsCatalogFixtures.projectInvitationsCreatePayload())
                        .accessLevel(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("accessLevel");
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailIsNullable() {
        final GitLabProjectInvitationsCreatePayloadBuilder builder =
                GitLabProjectInvitationsCreatePayloadBuilder.builder(
                                InvitationsCatalogFixtures.projectInvitationsCreatePayload())
                        .email(null);

        final GitLabProjectInvitationsCreatePayload built = builder.build();

        assertThat(built.email()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabProjectInvitationsCreatePayloadBuilder builder =
                GitLabProjectInvitationsCreatePayloadBuilder.builder(
                                InvitationsCatalogFixtures.projectInvitationsCreatePayload())
                        .userId(null);

        final GitLabProjectInvitationsCreatePayload built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabProjectInvitationsCreatePayloadBuilder builder =
                GitLabProjectInvitationsCreatePayloadBuilder.builder(
                                InvitationsCatalogFixtures.projectInvitationsCreatePayload())
                        .expiresAt(null);

        final GitLabProjectInvitationsCreatePayload built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInviteSourceIsNullable() {
        final GitLabProjectInvitationsCreatePayloadBuilder builder =
                GitLabProjectInvitationsCreatePayloadBuilder.builder(
                                InvitationsCatalogFixtures.projectInvitationsCreatePayload())
                        .inviteSource(null);

        final GitLabProjectInvitationsCreatePayload built = builder.build();

        assertThat(built.inviteSource()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMemberRoleIdIsNullable() {
        final GitLabProjectInvitationsCreatePayloadBuilder builder =
                GitLabProjectInvitationsCreatePayloadBuilder.builder(
                                InvitationsCatalogFixtures.projectInvitationsCreatePayload())
                        .memberRoleId(null);

        final GitLabProjectInvitationsCreatePayload built = builder.build();

        assertThat(built.memberRoleId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectInvitationsCreatePayload value =
                InvitationsCatalogFixtures.projectInvitationsCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.accessLevel()).isEqualTo(GitLabProjectInvitationsCreateAccessLevel.GUEST);
            softly.assertThat(value.email()).isEqualTo(List.of("email"));
            softly.assertThat(value.userId()).isEqualTo(List.of("user_id"));
            softly.assertThat(value.expiresAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.inviteSource()).isEqualTo("invite_source");
            softly.assertThat(value.memberRoleId()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectInvitationsCreatePayload original =
                InvitationsCatalogFixtures.projectInvitationsCreatePayload();

        final GitLabProjectInvitationsCreatePayload rebuilt =
                GitLabProjectInvitationsCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenEmailSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("email"));
        final GitLabProjectInvitationsCreatePayload built = GitLabProjectInvitationsCreatePayloadBuilder.builder(
                        InvitationsCatalogFixtures.projectInvitationsCreatePayload())
                .email(source)
                .build();
        source.clear();

        assertThat(built.email()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenEmailIsRead() {
        final GitLabProjectInvitationsCreatePayload built =
                InvitationsCatalogFixtures.projectInvitationsCreatePayload();
        final List<String> values = built.email();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenUserIdSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("user_id"));
        final GitLabProjectInvitationsCreatePayload built = GitLabProjectInvitationsCreatePayloadBuilder.builder(
                        InvitationsCatalogFixtures.projectInvitationsCreatePayload())
                .userId(source)
                .build();
        source.clear();

        assertThat(built.userId()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenUserIdIsRead() {
        final GitLabProjectInvitationsCreatePayload built =
                InvitationsCatalogFixtures.projectInvitationsCreatePayload();
        final List<String> values = built.userId();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectInvitationsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("accessLevel", "email", "userId", "expiresAt", "inviteSource", "memberRoleId");
    }
}
