package io.github.piotr_janczukowicz.gitlab.api.projectsecuritysettings;

public final class ProjectsecuritysettingsCatalogFixtures {

    private ProjectsecuritysettingsCatalogFixtures() {}

    public static GitLabProjectProjectSecuritySettingsUpdatePayload projectProjectSecuritySettingsUpdatePayload() {
        return GitLabProjectProjectSecuritySettingsUpdatePayloadBuilder.builder()
                .secretPushProtectionEnabled(true)
                .preReceiveSecretDetectionEnabled(true)
                .fastDependencyPathsEnabled(true)
                .build();
    }
}
