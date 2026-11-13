package io.github.piotr_janczukowicz.gitlab.api.projects;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project projects status compliance external control status. */
@CatalogSchema("operations/patchApiV4ProjectsIdComplianceExternalControlsControlIdStatus/requestBody/properties/status")
public enum GitLabProjectProjectsStatusComplianceExternalControlStatus {
    PASS("pass"),
    FAIL("fail"),
    NOT_APPLICABLE("not_applicable");

    private static final EnumUtils.WireIndex<GitLabProjectProjectsStatusComplianceExternalControlStatus> WIRE_INDEX =
            EnumUtils.index(
                    GitLabProjectProjectsStatusComplianceExternalControlStatus.class,
                    GitLabProjectProjectsStatusComplianceExternalControlStatus::wireValue);

    private final String wireValue;

    GitLabProjectProjectsStatusComplianceExternalControlStatus(final String wireValue) {
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
    public static GitLabProjectProjectsStatusComplianceExternalControlStatus fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
