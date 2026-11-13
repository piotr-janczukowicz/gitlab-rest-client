package io.github.piotr_janczukowicz.gitlab.api.issues;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project issues update issue type. */
@CatalogSchema("operations/putApiV4ProjectsIdIssuesIssueIid/requestBody/properties/issue_type")
public enum GitLabProjectIssuesUpdateIssueType {
    ISSUE("issue"),
    INCIDENT("incident"),
    TEST_CASE("test_case"),
    REQUIREMENT("requirement"),
    TASK("task"),
    TICKET("ticket");

    private static final EnumUtils.WireIndex<GitLabProjectIssuesUpdateIssueType> WIRE_INDEX =
            EnumUtils.index(GitLabProjectIssuesUpdateIssueType.class, GitLabProjectIssuesUpdateIssueType::wireValue);

    private final String wireValue;

    GitLabProjectIssuesUpdateIssueType(final String wireValue) {
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
    public static GitLabProjectIssuesUpdateIssueType fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
