package io.github.piotr_janczukowicz.gitlab.api.common;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab issue basic type. */
@CatalogSchema("components/schemas/APIEntitiesIssueBasic/properties/type")
public enum GitLabIssueBasicType {
    ISSUE("ISSUE"),
    INCIDENT("INCIDENT"),
    TEST_CASE("TEST_CASE"),
    REQUIREMENT("REQUIREMENT"),
    TASK("TASK"),
    TICKET("TICKET"),
    /** A value this library version does not know. */
    UNRECOGNIZED("unrecognized");

    private static final EnumUtils.WireIndex<GitLabIssueBasicType> WIRE_INDEX =
            EnumUtils.index(GitLabIssueBasicType.class, GitLabIssueBasicType::wireValue);

    private final String wireValue;

    GitLabIssueBasicType(final String wireValue) {
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
    public static GitLabIssueBasicType fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
