package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab duo agent platform flows create workflow environment. */
@CatalogSchema("operations/postApiV4AiDuoWorkflowsWorkflows/requestBody/properties/environment")
public enum GitLabDuoAgentPlatformFlowsCreateWorkflowEnvironment {
    IDE("ide"),
    WEB("web"),
    CHAT_PARTIAL("chat_partial"),
    CHAT("chat"),
    AMBIENT("ambient");

    private static final EnumUtils.WireIndex<GitLabDuoAgentPlatformFlowsCreateWorkflowEnvironment> WIRE_INDEX =
            EnumUtils.index(
                    GitLabDuoAgentPlatformFlowsCreateWorkflowEnvironment.class,
                    GitLabDuoAgentPlatformFlowsCreateWorkflowEnvironment::wireValue);

    private final String wireValue;

    GitLabDuoAgentPlatformFlowsCreateWorkflowEnvironment(final String wireValue) {
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
    public static GitLabDuoAgentPlatformFlowsCreateWorkflowEnvironment fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
