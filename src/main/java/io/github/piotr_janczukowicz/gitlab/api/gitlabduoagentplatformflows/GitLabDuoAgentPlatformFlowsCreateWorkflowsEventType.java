package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab duo agent platform flows create workflows event type. */
@CatalogSchema("operations/postApiV4AiDuoWorkflowsWorkflowsIdEvents/requestBody/properties/event_type")
public enum GitLabDuoAgentPlatformFlowsCreateWorkflowsEventType {
    PAUSE("pause"),
    RESUME("resume"),
    STOP("stop"),
    MESSAGE("message"),
    RESPONSE("response"),
    REQUIRE_INPUT("require_input");

    private static final EnumUtils.WireIndex<GitLabDuoAgentPlatformFlowsCreateWorkflowsEventType> WIRE_INDEX =
            EnumUtils.index(
                    GitLabDuoAgentPlatformFlowsCreateWorkflowsEventType.class,
                    GitLabDuoAgentPlatformFlowsCreateWorkflowsEventType::wireValue);

    private final String wireValue;

    GitLabDuoAgentPlatformFlowsCreateWorkflowsEventType(final String wireValue) {
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
    public static GitLabDuoAgentPlatformFlowsCreateWorkflowsEventType fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
