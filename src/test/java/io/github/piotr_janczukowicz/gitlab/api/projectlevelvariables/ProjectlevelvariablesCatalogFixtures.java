package io.github.piotr_janczukowicz.gitlab.api.projectlevelvariables;

public final class ProjectlevelvariablesCatalogFixtures {

    private ProjectlevelvariablesCatalogFixtures() {}

    public static GitLabProjectProjectLevelVariablesCreatePayload projectProjectLevelVariablesCreatePayload() {
        return GitLabProjectProjectLevelVariablesCreatePayloadBuilder.builder()
                .key("key")
                .value("value")
                .protectedValue(true)
                .masked(true)
                .maskedAndHidden(true)
                .raw(true)
                .variableType(GitLabProjectProjectLevelVariablesCreateVariableType.ENV_VAR)
                .environmentScope("environment_scope")
                .description("description")
                .build();
    }

    public static GitLabProjectProjectLevelVariablesUpdateFilter projectProjectLevelVariablesUpdateFilter() {
        return GitLabProjectProjectLevelVariablesUpdateFilterBuilder.builder()
                .environmentScope("environment_scope")
                .build();
    }

    public static GitLabProjectProjectLevelVariablesUpdatePayload projectProjectLevelVariablesUpdatePayload() {
        return GitLabProjectProjectLevelVariablesUpdatePayloadBuilder.builder()
                .value("value")
                .protectedValue(true)
                .masked(true)
                .environmentScope("environment_scope")
                .raw(true)
                .variableType(GitLabProjectProjectLevelVariablesUpdateVariableType.ENV_VAR)
                .filter(ProjectlevelvariablesCatalogFixtures.projectProjectLevelVariablesUpdateFilter())
                .description("description")
                .build();
    }
}
