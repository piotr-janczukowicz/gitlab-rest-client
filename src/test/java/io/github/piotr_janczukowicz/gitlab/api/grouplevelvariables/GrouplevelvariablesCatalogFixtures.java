package io.github.piotr_janczukowicz.gitlab.api.grouplevelvariables;

public final class GrouplevelvariablesCatalogFixtures {

    private GrouplevelvariablesCatalogFixtures() {}

    public static GitLabGroupGroupLevelVariablesCreatePayload groupGroupLevelVariablesCreatePayload() {
        return GitLabGroupGroupLevelVariablesCreatePayloadBuilder.builder()
                .key("key")
                .value("value")
                .protectedValue(true)
                .maskedAndHidden(true)
                .masked(true)
                .raw(true)
                .variableType(GitLabGroupGroupLevelVariablesCreateVariableType.ENV_VAR)
                .environmentScope("environment_scope")
                .description("description")
                .build();
    }

    public static GitLabGroupGroupLevelVariablesUpdatePayload groupGroupLevelVariablesUpdatePayload() {
        return GitLabGroupGroupLevelVariablesUpdatePayloadBuilder.builder()
                .value("value")
                .protectedValue(true)
                .masked(true)
                .raw(true)
                .variableType(GitLabGroupGroupLevelVariablesUpdateVariableType.ENV_VAR)
                .environmentScope("environment_scope")
                .description("description")
                .build();
    }
}
