package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab duo agent platform flows create agent workflow environment. */
@CatalogSchema("operations/postApiV4AiDuoWorkflowsAgentWorkflows/requestBody/properties/environment")
public enum GitLabDuoAgentPlatformFlowsCreateAgentWorkflowEnvironment {
    IDE("ide"),
    WEB("web"),
    CHAT_PARTIAL("chat_partial"),
    CHAT("chat"),
    AMBIENT("ambient"),
    EXTERNAL("external");

    private static final EnumUtils.WireIndex<GitLabDuoAgentPlatformFlowsCreateAgentWorkflowEnvironment> WIRE_INDEX =
            EnumUtils.index(
                    GitLabDuoAgentPlatformFlowsCreateAgentWorkflowEnvironment.class,
                    GitLabDuoAgentPlatformFlowsCreateAgentWorkflowEnvironment::wireValue);

    private final String wireValue;

    GitLabDuoAgentPlatformFlowsCreateAgentWorkflowEnvironment(final String wireValue) {
        this.wireValue = wireValue;
    }

    /**
     * Value GitLab sends and expects in JSON.
     *
     * @return wire value
     */
    @JsonValue
    public String wireValue() {
        return wireValue;
    }

    /**
     * Resolves the constant from its wire value.
     *
     * @param value JSON value
     * @return matching constant
     * @throws NullPointerException if {@code value} is {@code null}
     * @throws IllegalArgumentException if {@code value} is not a known value
     */
    @JsonCreator
    public static GitLabDuoAgentPlatformFlowsCreateAgentWorkflowEnvironment fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
