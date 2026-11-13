package io.github.piotr_janczukowicz.gitlab.api.invitations;

import java.time.Instant;
import java.util.List;

public final class InvitationsCatalogFixtures {

    private InvitationsCatalogFixtures() {}

    public static GitLabGroupInvitationsCreatePayload groupInvitationsCreatePayload() {
        return GitLabGroupInvitationsCreatePayloadBuilder.builder()
                .accessLevel(GitLabGroupInvitationsCreateAccessLevel.GUEST)
                .email(List.of("email"))
                .userId(List.of("user_id"))
                .expiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .inviteSource("invite_source")
                .memberRoleId(1L)
                .build();
    }

    public static GitLabGroupInvitationsUpdatePayload groupInvitationsUpdatePayload() {
        return GitLabGroupInvitationsUpdatePayloadBuilder.builder()
                .accessLevel(GitLabGroupInvitationsUpdateAccessLevel.GUEST)
                .expiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .memberRoleId(1L)
                .build();
    }

    public static GitLabInvitation invitation() {
        return GitLabInvitationBuilder.builder()
                .accessLevel("access_level")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .expiresAt("expires_at")
                .inviteEmail("invite_email")
                .inviteToken("invite_token")
                .userName("user_name")
                .createdByName("created_by_name")
                .build();
    }

    public static GitLabProjectInvitationsCreatePayload projectInvitationsCreatePayload() {
        return GitLabProjectInvitationsCreatePayloadBuilder.builder()
                .accessLevel(GitLabProjectInvitationsCreateAccessLevel.GUEST)
                .email(List.of("email"))
                .userId(List.of("user_id"))
                .expiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .inviteSource("invite_source")
                .memberRoleId(1L)
                .build();
    }

    public static GitLabProjectInvitationsUpdatePayload projectInvitationsUpdatePayload() {
        return GitLabProjectInvitationsUpdatePayloadBuilder.builder()
                .accessLevel(GitLabProjectInvitationsUpdateAccessLevel.GUEST)
                .expiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .memberRoleId(1L)
                .build();
    }
}
