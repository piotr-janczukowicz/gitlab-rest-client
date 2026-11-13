package io.github.piotr_janczukowicz.gitlab.api.jiraforgeuserdelegation;

public final class JiraforgeuserdelegationCatalogFixtures {

    private JiraforgeuserdelegationCatalogFixtures() {}

    public static GitLabJiraForgeUserDelegationUserDelegationPayload jiraForgeUserDelegationUserDelegationPayload() {
        return GitLabJiraForgeUserDelegationUserDelegationPayloadBuilder.builder()
                .accountId("account_id")
                .cloudId("cloud_id")
                .build();
    }
}
