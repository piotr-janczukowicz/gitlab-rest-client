package io.github.piotr_janczukowicz.gitlab.api.jiraconnectsubscriptions;

public final class JiraconnectsubscriptionsCatalogFixtures {

    private JiraconnectsubscriptionsCatalogFixtures() {}

    public static GitLabJiraConnectSubscriptionsCreateSubscriptionPayload
            jiraConnectSubscriptionsCreateSubscriptionPayload() {
        return GitLabJiraConnectSubscriptionsCreateSubscriptionPayloadBuilder.builder()
                .jwt("jwt")
                .namespacePath("namespace_path")
                .build();
    }
}
