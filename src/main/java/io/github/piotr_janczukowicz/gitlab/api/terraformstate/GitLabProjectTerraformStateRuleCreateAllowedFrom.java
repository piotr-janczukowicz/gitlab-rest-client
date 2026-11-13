package io.github.piotr_janczukowicz.gitlab.api.terraformstate;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project terraform state rule create allowed from. */
@CatalogSchema("operations/postApiV4ProjectsIdTerraformStateProtectionRules/requestBody/properties/allowed_from")
public enum GitLabProjectTerraformStateRuleCreateAllowedFrom {
    ANYWHERE("anywhere"),
    CI_ONLY("ci_only"),
    CI_ON_PROTECTED_BRANCH_ONLY("ci_on_protected_branch_only");

    private static final EnumUtils.WireIndex<GitLabProjectTerraformStateRuleCreateAllowedFrom> WIRE_INDEX =
            EnumUtils.index(
                    GitLabProjectTerraformStateRuleCreateAllowedFrom.class,
                    GitLabProjectTerraformStateRuleCreateAllowedFrom::wireValue);

    private final String wireValue;

    GitLabProjectTerraformStateRuleCreateAllowedFrom(final String wireValue) {
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
    public static GitLabProjectTerraformStateRuleCreateAllowedFrom fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
