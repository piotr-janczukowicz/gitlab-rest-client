package io.github.piotr_janczukowicz.gitlab.api.jiraforgeinstallation;

public final class JiraforgeinstallationCatalogFixtures {

    private JiraforgeinstallationCatalogFixtures() {}

    public static GitLabJiraForgeInstallationUpdateInstallationPayload
            jiraForgeInstallationUpdateInstallationPayload() {
        return GitLabJiraForgeInstallationUpdateInstallationPayloadBuilder.builder()
                .instanceUrl("instance_url")
                .build();
    }
}
