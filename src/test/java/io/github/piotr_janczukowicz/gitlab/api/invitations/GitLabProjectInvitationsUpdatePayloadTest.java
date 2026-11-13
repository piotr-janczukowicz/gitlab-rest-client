package io.github.piotr_janczukowicz.gitlab.api.invitations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectInvitationsUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabProjectInvitationsUpdatePayloadBuilder builder =
                GitLabProjectInvitationsUpdatePayloadBuilder.builder(
                                InvitationsCatalogFixtures.projectInvitationsUpdatePayload())
                        .accessLevel(null);

        final GitLabProjectInvitationsUpdatePayload built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabProjectInvitationsUpdatePayloadBuilder builder =
                GitLabProjectInvitationsUpdatePayloadBuilder.builder(
                                InvitationsCatalogFixtures.projectInvitationsUpdatePayload())
                        .expiresAt(null);

        final GitLabProjectInvitationsUpdatePayload built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMemberRoleIdIsNullable() {
        final GitLabProjectInvitationsUpdatePayloadBuilder builder =
                GitLabProjectInvitationsUpdatePayloadBuilder.builder(
                                InvitationsCatalogFixtures.projectInvitationsUpdatePayload())
                        .memberRoleId(null);

        final GitLabProjectInvitationsUpdatePayload built = builder.build();

        assertThat(built.memberRoleId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectInvitationsUpdatePayload value =
                InvitationsCatalogFixtures.projectInvitationsUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.accessLevel()).isEqualTo(GitLabProjectInvitationsUpdateAccessLevel.GUEST);
            softly.assertThat(value.expiresAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.memberRoleId()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectInvitationsUpdatePayload original =
                InvitationsCatalogFixtures.projectInvitationsUpdatePayload();

        final GitLabProjectInvitationsUpdatePayload rebuilt =
                GitLabProjectInvitationsUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectInvitationsUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("accessLevel", "expiresAt", "memberRoleId");
    }
}
