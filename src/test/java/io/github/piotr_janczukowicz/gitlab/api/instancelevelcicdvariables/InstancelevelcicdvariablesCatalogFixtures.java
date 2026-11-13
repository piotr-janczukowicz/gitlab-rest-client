package io.github.piotr_janczukowicz.gitlab.api.instancelevelcicdvariables;

public final class InstancelevelcicdvariablesCatalogFixtures {

    private InstancelevelcicdvariablesCatalogFixtures() {}

    public static GitLabInstanceLevelCICDVariablesCreatePayload instanceLevelCICDVariablesCreatePayload() {
        return GitLabInstanceLevelCICDVariablesCreatePayloadBuilder.builder()
                .key("key")
                .description("description")
                .value("value")
                .protectedValue(true)
                .masked(true)
                .raw(true)
                .variableType(GitLabInstanceLevelCICDVariablesCreateVariableType.ENV_VAR)
                .build();
    }

    public static GitLabInstanceLevelCICDVariablesUpdatePayload instanceLevelCICDVariablesUpdatePayload() {
        return GitLabInstanceLevelCICDVariablesUpdatePayloadBuilder.builder()
                .description("description")
                .value("value")
                .protectedValue(true)
                .masked(true)
                .raw(true)
                .variableType(GitLabInstanceLevelCICDVariablesUpdateVariableType.ENV_VAR)
                .build();
    }
}
