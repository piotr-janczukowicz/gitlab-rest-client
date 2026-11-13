package io.github.piotr_janczukowicz.gitlab.api.issues;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab issue type. */
@CatalogSchema("components/schemas/APIEntitiesIssue/properties/type")
public enum GitLabIssueType {
    ISSUE("ISSUE"),
    INCIDENT("INCIDENT"),
    TEST_CASE("TEST_CASE"),
    REQUIREMENT("REQUIREMENT"),
    TASK("TASK"),
    TICKET("TICKET"),
    /** A value this library version does not know. */
    UNRECOGNIZED("unrecognized");

    private static final EnumUtils.WireIndex<GitLabIssueType> WIRE_INDEX =
            EnumUtils.index(GitLabIssueType.class, GitLabIssueType::wireValue);

    private final String wireValue;

    GitLabIssueType(final String wireValue) {
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
    public static GitLabIssueType fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
