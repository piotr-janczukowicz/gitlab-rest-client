package io.github.piotr_janczukowicz.gitlab.api.members;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Map;

public final class MembersCatalogFixtures {

    private MembersCatalogFixtures() {}

    public static GitLabBillableMembership billableMembership() {
        return GitLabBillableMembershipBuilder.builder()
                .id(1L)
                .sourceId(1L)
                .sourceFullName("source_full_name")
                .sourceMembersUrl("source_members_url")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .expiresAt(LocalDate.parse("2026-01-01"))
                .accessLevel(MembersCatalogFixtures.billableMembershipAccessLevel())
                .build();
    }

    public static GitLabBillableMembershipAccessLevel billableMembershipAccessLevel() {
        return GitLabBillableMembershipAccessLevelBuilder.builder()
                .stringValue("string_value")
                .integerValue(1)
                .customRole(Map.of("key", "value"))
                .build();
    }

    public static GitLabGroupMembersCreatePayload groupMembersCreatePayload() {
        return GitLabGroupMembersCreatePayloadBuilder.builder()
                .accessLevel(1)
                .userId("text")
                .username("username")
                .expiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .inviteSource("invite_source")
                .build();
    }

    public static GitLabGroupMembersStatePayload groupMembersStatePayload() {
        return GitLabGroupMembersStatePayloadBuilder.builder()
                .state(GitLabGroupMembersStateState.AWAITING)
                .build();
    }

    public static GitLabGroupMembersUpdatePayload groupMembersUpdatePayload() {
        return GitLabGroupMembersUpdatePayloadBuilder.builder()
                .accessLevel(1)
                .expiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .memberRoleId(1L)
                .build();
    }

    public static GitLabProjectMembersCreatePayload projectMembersCreatePayload() {
        return GitLabProjectMembersCreatePayloadBuilder.builder()
                .accessLevel(1)
                .userId("text")
                .username("username")
                .expiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .inviteSource("invite_source")
                .build();
    }

    public static GitLabProjectMembersUpdatePayload projectMembersUpdatePayload() {
        return GitLabProjectMembersUpdatePayloadBuilder.builder()
                .accessLevel(1)
                .expiresAt(Instant.parse("2026-01-01T00:00:00Z"))
                .memberRoleId(1L)
                .build();
    }
}
