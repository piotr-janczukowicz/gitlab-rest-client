package io.github.piotr_janczukowicz.gitlab.api.runners;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab ci runner details job execution status. */
@CatalogSchema("components/schemas/APIEntitiesCiRunnerDetails/properties/job_execution_status")
public enum GitLabCiRunnerDetailsJobExecutionStatus {
    ACTIVE("active"),
    IDLE("idle"),
    /** A value this library version does not know. */
    UNRECOGNIZED("unrecognized");

    private static final EnumUtils.WireIndex<GitLabCiRunnerDetailsJobExecutionStatus> WIRE_INDEX = EnumUtils.index(
            GitLabCiRunnerDetailsJobExecutionStatus.class, GitLabCiRunnerDetailsJobExecutionStatus::wireValue);

    private final String wireValue;

    GitLabCiRunnerDetailsJobExecutionStatus(final String wireValue) {
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
     */
    @JsonCreator
    public static GitLabCiRunnerDetailsJobExecutionStatus fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
