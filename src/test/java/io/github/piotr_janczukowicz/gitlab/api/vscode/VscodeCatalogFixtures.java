package io.github.piotr_janczukowicz.gitlab.api.vscode;

import java.util.Map;

public final class VscodeCatalogFixtures {

    private VscodeCatalogFixtures() {}

    public static GitLabAPIVsCodeSettingsEntitiesVsCodeManifest apivsCodeSettingsEntitiesVsCodeManifest() {
        return GitLabAPIVsCodeSettingsEntitiesVsCodeManifestBuilder.builder()
                .latest(Map.of("key", "value"))
                .session("1")
                .build();
    }

    public static GitLabAPIVsCodeSettingsEntitiesVsCodeSetting apivsCodeSettingsEntitiesVsCodeSetting() {
        return GitLabAPIVsCodeSettingsEntitiesVsCodeSettingBuilder.builder()
                .content("content")
                .machines("machines")
                .version("version")
                .machineId("machineId")
                .build();
    }

    public static GitLabAPIVsCodeSettingsEntitiesVsCodeSettingReference
            apivsCodeSettingsEntitiesVsCodeSettingReference() {
        return GitLabAPIVsCodeSettingsEntitiesVsCodeSettingReferenceBuilder.builder()
                .url("url")
                .created("created")
                .build();
    }
}
