package io.github.piotr_janczukowicz.gitlab.api.common;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab epic issue type. */
@CatalogSchema("components/schemas/APIEntitiesEpicIssue/properties/type")
public enum GitLabEpicIssueType {
    ISSUE("ISSUE"),
    INCIDENT("INCIDENT"),
    TEST_CASE("TEST_CASE"),
    REQUIREMENT("REQUIREMENT"),
    TASK("TASK"),
    TICKET("TICKET"),
    /** A value this library version does not know. */
    UNRECOGNIZED("unrecognized");

    private static final EnumUtils.WireIndex<GitLabEpicIssueType> WIRE_INDEX =
            EnumUtils.index(GitLabEpicIssueType.class, GitLabEpicIssueType::wireValue);

    private final String wireValue;

    GitLabEpicIssueType(final String wireValue) {
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
    public static GitLabEpicIssueType fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
