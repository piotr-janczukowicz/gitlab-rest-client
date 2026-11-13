package io.github.piotr_janczukowicz.gitlab.api.jiraforgesubscriptions;

import java.time.Instant;

public final class JiraforgesubscriptionsCatalogFixtures {

    private JiraforgesubscriptionsCatalogFixtures() {}

    public static GitLabJiraConnectGroupEntity jiraConnectGroupEntity() {
        return GitLabJiraConnectGroupEntityBuilder.builder()
                .name("name")
                .avatarUrl("avatar_url")
                .fullName("full_name")
                .description("description")
                .build();
    }

    public static GitLabJiraConnectSubscriptionEntity jiraConnectSubscriptionEntity() {
        return GitLabJiraConnectSubscriptionEntityBuilder.builder()
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .unlinkPath("unlink_path")
                .group(JiraforgesubscriptionsCatalogFixtures.jiraConnectGroupEntity())
                .build();
    }

    public static GitLabJiraForgeSubscriptionsCreateSubscriptionPayload
            jiraForgeSubscriptionsCreateSubscriptionPayload() {
        return GitLabJiraForgeSubscriptionsCreateSubscriptionPayloadBuilder.builder()
                .namespacePath("namespace_path")
                .build();
    }
}
