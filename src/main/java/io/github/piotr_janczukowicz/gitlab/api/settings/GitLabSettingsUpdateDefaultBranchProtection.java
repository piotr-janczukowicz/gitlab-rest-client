package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab settings update default branch protection. */
@CatalogSchema("operations/putApiV4ApplicationSettings/requestBody/properties/default_branch_protection")
public enum GitLabSettingsUpdateDefaultBranchProtection {
    N_0(0),
    N_3(3),
    N_1(1),
    N_2(2),
    N_4(4);

    private static final EnumUtils.WireIndex<GitLabSettingsUpdateDefaultBranchProtection> WIRE_INDEX = EnumUtils.index(
            GitLabSettingsUpdateDefaultBranchProtection.class, value -> String.valueOf(value.wireValue()));

    private final int wireValue;

    GitLabSettingsUpdateDefaultBranchProtection(final int wireValue) {
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
    public static GitLabSettingsUpdateDefaultBranchProtection fromWire(final int value) {
        return WIRE_INDEX
                .fromWire(String.valueOf(value))
                .orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
