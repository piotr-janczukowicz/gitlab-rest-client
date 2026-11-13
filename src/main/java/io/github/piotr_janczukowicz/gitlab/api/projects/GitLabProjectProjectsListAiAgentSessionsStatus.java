package io.github.piotr_janczukowicz.gitlab.api.projects;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project projects list ai agent sessions status. */
@CatalogSchema("operations/getApiV4ProjectsIdAiAgentSessions/parameters/status/schema")
public enum GitLabProjectProjectsListAiAgentSessionsStatus {
    CREATED("created"),
    RUNNING("running"),
    FINISHED("finished"),
    FAILED("failed"),
    STOPPED("stopped");

    private static final EnumUtils.WireIndex<GitLabProjectProjectsListAiAgentSessionsStatus> WIRE_INDEX =
            EnumUtils.index(
                    GitLabProjectProjectsListAiAgentSessionsStatus.class,
                    GitLabProjectProjectsListAiAgentSessionsStatus::wireValue);

    private final String wireValue;

    GitLabProjectProjectsListAiAgentSessionsStatus(final String wireValue) {
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
    public static GitLabProjectProjectsListAiAgentSessionsStatus fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
