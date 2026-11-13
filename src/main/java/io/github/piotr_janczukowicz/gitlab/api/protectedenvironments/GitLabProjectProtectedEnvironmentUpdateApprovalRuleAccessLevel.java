package io.github.piotr_janczukowicz.gitlab.api.protectedenvironments;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project protected environment update approval rule access level. */
@CatalogSchema(
        "operations/putApiV4ProjectsIdProtectedEnvironmentsName/requestBody/properties/approval_rules/items/properties/access_level")
public enum GitLabProjectProtectedEnvironmentUpdateApprovalRuleAccessLevel {
    MAINTAINER(40),
    DEVELOPER(30),
    REPORTER(20),
    ADMINISTRATOR(60);

    private static final EnumUtils.WireIndex<GitLabProjectProtectedEnvironmentUpdateApprovalRuleAccessLevel>
            WIRE_INDEX = EnumUtils.index(
                    GitLabProjectProtectedEnvironmentUpdateApprovalRuleAccessLevel.class,
                    value -> String.valueOf(value.wireValue()));

    private final int wireValue;

    GitLabProjectProtectedEnvironmentUpdateApprovalRuleAccessLevel(final int wireValue) {
        this.wireValue = wireValue;
    }

    /**
     * Value GitLab sends and expects in JSON.
     *
     * @return wire value
     */
    @JsonValue
    public int wireValue() {
        return wireValue;
    }

    /**
     * Resolves the constant from its wire value.
     *
     * @param value JSON value
     * @return matching constant
     * @throws IllegalArgumentException if {@code value} is not a known value
     */
    @JsonCreator
    public static GitLabProjectProtectedEnvironmentUpdateApprovalRuleAccessLevel fromWire(final int value) {
        return WIRE_INDEX
                .fromWire(String.valueOf(value))
                .orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
