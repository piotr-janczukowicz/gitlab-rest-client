package io.github.piotr_janczukowicz.gitlab.api.invitations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupInvitationsUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabGroupInvitationsUpdatePayloadBuilder builder = GitLabGroupInvitationsUpdatePayloadBuilder.builder(
                        InvitationsCatalogFixtures.groupInvitationsUpdatePayload())
                .accessLevel(null);

        final GitLabGroupInvitationsUpdatePayload built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabGroupInvitationsUpdatePayloadBuilder builder = GitLabGroupInvitationsUpdatePayloadBuilder.builder(
                        InvitationsCatalogFixtures.groupInvitationsUpdatePayload())
                .expiresAt(null);

        final GitLabGroupInvitationsUpdatePayload built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMemberRoleIdIsNullable() {
        final GitLabGroupInvitationsUpdatePayloadBuilder builder = GitLabGroupInvitationsUpdatePayloadBuilder.builder(
                        InvitationsCatalogFixtures.groupInvitationsUpdatePayload())
                .memberRoleId(null);

        final GitLabGroupInvitationsUpdatePayload built = builder.build();

        assertThat(built.memberRoleId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupInvitationsUpdatePayload value = InvitationsCatalogFixtures.groupInvitationsUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.accessLevel()).isEqualTo(GitLabGroupInvitationsUpdateAccessLevel.GUEST);
            softly.assertThat(value.expiresAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.memberRoleId()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupInvitationsUpdatePayload original = InvitationsCatalogFixtures.groupInvitationsUpdatePayload();

        final GitLabGroupInvitationsUpdatePayload rebuilt =
                GitLabGroupInvitationsUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupInvitationsUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("accessLevel", "expiresAt", "memberRoleId");
    }
}
