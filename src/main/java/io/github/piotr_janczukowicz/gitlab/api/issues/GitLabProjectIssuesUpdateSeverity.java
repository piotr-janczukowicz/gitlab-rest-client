package io.github.piotr_janczukowicz.gitlab.api.issues;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project issues update severity. */
@CatalogSchema("operations/putApiV4ProjectsIdIssuesIssueIid/requestBody/properties/severity")
public enum GitLabProjectIssuesUpdateSeverity {
    UNKNOWN("unknown"),
    LOW("low"),
    MEDIUM("medium"),
    HIGH("high"),
    CRITICAL("critical");

    private static final EnumUtils.WireIndex<GitLabProjectIssuesUpdateSeverity> WIRE_INDEX =
            EnumUtils.index(GitLabProjectIssuesUpdateSeverity.class, GitLabProjectIssuesUpdateSeverity::wireValue);

    private final String wireValue;

    GitLabProjectIssuesUpdateSeverity(final String wireValue) {
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
    public static GitLabProjectIssuesUpdateSeverity fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
