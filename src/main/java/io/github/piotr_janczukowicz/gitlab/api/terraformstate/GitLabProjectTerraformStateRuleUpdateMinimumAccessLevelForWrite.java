package io.github.piotr_janczukowicz.gitlab.api.terraformstate;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project terraform state rule update minimum access level for write. */
@CatalogSchema(
        "operations/patchApiV4ProjectsIdTerraformStateProtectionRulesTerraformStateProtectionRuleId/requestBody/properties/minimum_access_level_for_write")
public enum GitLabProjectTerraformStateRuleUpdateMinimumAccessLevelForWrite {
    DEVELOPER("developer"),
    MAINTAINER("maintainer"),
    OWNER("owner"),
    ADMIN("admin");

    private static final EnumUtils.WireIndex<GitLabProjectTerraformStateRuleUpdateMinimumAccessLevelForWrite>
            WIRE_INDEX = EnumUtils.index(
                    GitLabProjectTerraformStateRuleUpdateMinimumAccessLevelForWrite.class,
                    GitLabProjectTerraformStateRuleUpdateMinimumAccessLevelForWrite::wireValue);

    private final String wireValue;

    GitLabProjectTerraformStateRuleUpdateMinimumAccessLevelForWrite(final String wireValue) {
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
    public static GitLabProjectTerraformStateRuleUpdateMinimumAccessLevelForWrite fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
