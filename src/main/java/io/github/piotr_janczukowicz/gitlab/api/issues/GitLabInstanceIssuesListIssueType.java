package io.github.piotr_janczukowicz.gitlab.api.issues;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab instance issues list issue type. */
@CatalogSchema("operations/getApiV4Issues/parameters/issue_type/schema")
public enum GitLabInstanceIssuesListIssueType {
    ISSUE("issue"),
    INCIDENT("incident"),
    TEST_CASE("test_case"),
    REQUIREMENT("requirement"),
    TASK("task"),
    TICKET("ticket");

    private static final EnumUtils.WireIndex<GitLabInstanceIssuesListIssueType> WIRE_INDEX =
            EnumUtils.index(GitLabInstanceIssuesListIssueType.class, GitLabInstanceIssuesListIssueType::wireValue);

    private final String wireValue;

    GitLabInstanceIssuesListIssueType(final String wireValue) {
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
    public static GitLabInstanceIssuesListIssueType fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
