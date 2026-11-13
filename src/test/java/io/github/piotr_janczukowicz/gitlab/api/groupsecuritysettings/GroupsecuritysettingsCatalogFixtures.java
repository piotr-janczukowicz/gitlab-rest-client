package io.github.piotr_janczukowicz.gitlab.api.groupsecuritysettings;

import java.util.List;

public final class GroupsecuritysettingsCatalogFixtures {

    private GroupsecuritysettingsCatalogFixtures() {}

    public static GitLabGroupGroupSecuritySettingsUpdatePayload groupGroupSecuritySettingsUpdatePayload() {
        return GitLabGroupGroupSecuritySettingsUpdatePayloadBuilder.builder()
                .secretPushProtectionEnabled(true)
                .projectsToExclude(List.of(1))
                .build();
    }
}
