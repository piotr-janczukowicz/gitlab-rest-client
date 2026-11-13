package io.github.piotr_janczukowicz.gitlab.api.grouplevelprotectedenvironments;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab group protected environment create approval rule group inheritance type. */
@CatalogSchema(
        "operations/postApiV4GroupsIdProtectedEnvironments/requestBody/properties/approval_rules/items/properties/group_inheritance_type")
public enum GitLabGroupProtectedEnvironmentCreateApprovalRuleGroupInheritanceType {
    N_0(0),
    N_1(1);

    private static final EnumUtils.WireIndex<GitLabGroupProtectedEnvironmentCreateApprovalRuleGroupInheritanceType>
            WIRE_INDEX = EnumUtils.index(
                    GitLabGroupProtectedEnvironmentCreateApprovalRuleGroupInheritanceType.class,
                    value -> String.valueOf(value.wireValue()));

    private final int wireValue;

    GitLabGroupProtectedEnvironmentCreateApprovalRuleGroupInheritanceType(final int wireValue) {
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
    public static GitLabGroupProtectedEnvironmentCreateApprovalRuleGroupInheritanceType fromWire(final int value) {
        return WIRE_INDEX
                .fromWire(String.valueOf(value))
                .orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
