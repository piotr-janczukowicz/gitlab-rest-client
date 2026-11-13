package io.github.piotr_janczukowicz.gitlab.api.organizations;

import java.time.Instant;
import java.util.List;

public final class OrganizationsCatalogFixtures {

    private OrganizationsCatalogFixtures() {}

    public static GitLabOrganization organization() {
        return GitLabOrganizationBuilder.builder()
                .id(1L)
                .uuid("0192f8c2-1a2b-7cde-89ab-0123456789ab")
                .name("GitLab")
                .path("gitlab")
                .description("My description")
                .visibility("public")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .webUrl("https://example.com/o/gitlab/-/overview")
                .avatarUrl("https://example.com/uploads/-/system/organizations/organization_detail/avatar/1/avatar.png")
                .build();
    }

    public static GitLabOrganizationUser organizationUser() {
        return GitLabOrganizationUserBuilder.builder()
                .id(1L)
                .username("jane_doe")
                .bot(true)
                .accessLevel("owner")
                .build();
    }

    public static GitLabOrganizationsCreateTransferUserPayload organizationsCreateTransferUserPayload() {
        return GitLabOrganizationsCreateTransferUserPayloadBuilder.builder()
                .userIds(List.of(1L))
                .build();
    }

    public static GitLabOrganizationsCreateUserPayload organizationsCreateUserPayload() {
        return GitLabOrganizationsCreateUserPayloadBuilder.builder()
                .username("username")
                .accessLevel(GitLabOrganizationsCreateUserAccessLevel.DEFAULT)
                .build();
    }

    public static GitLabOrganizationsUpdateUserPayload organizationsUpdateUserPayload() {
        return GitLabOrganizationsUpdateUserPayloadBuilder.builder()
                .accessLevel(GitLabOrganizationsUpdateUserAccessLevel.DEFAULT)
                .build();
    }
}
