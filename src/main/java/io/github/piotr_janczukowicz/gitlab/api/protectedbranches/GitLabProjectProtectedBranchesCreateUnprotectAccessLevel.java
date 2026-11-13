package io.github.piotr_janczukowicz.gitlab.api.protectedbranches;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project protected branches create unprotect access level. */
@CatalogSchema("operations/postApiV4ProjectsIdProtectedBranches/requestBody/properties/unprotect_access_level")
public enum GitLabProjectProtectedBranchesCreateUnprotectAccessLevel {
    DEVELOPER(30),
    MAINTAINER(40),
    ADMINISTRATOR(60);

    private static final EnumUtils.WireIndex<GitLabProjectProtectedBranchesCreateUnprotectAccessLevel> WIRE_INDEX =
            EnumUtils.index(
                    GitLabProjectProtectedBranchesCreateUnprotectAccessLevel.class,
                    value -> String.valueOf(value.wireValue()));

    private final int wireValue;

    GitLabProjectProtectedBranchesCreateUnprotectAccessLevel(final int wireValue) {
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
    public static GitLabProjectProtectedBranchesCreateUnprotectAccessLevel fromWire(final int value) {
        return WIRE_INDEX
                .fromWire(String.valueOf(value))
                .orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
