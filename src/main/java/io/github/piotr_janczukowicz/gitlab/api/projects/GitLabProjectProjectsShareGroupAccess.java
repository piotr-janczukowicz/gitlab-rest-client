package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project projects share group access. */
@CatalogSchema("operations/postApiV4ProjectsIdShare/requestBody/properties/group_access")
public enum GitLabProjectProjectsShareGroupAccess {
    N_10(10),
    N_15(15),
    N_20(20),
    N_25(25),
    N_30(30),
    N_40(40),
    N_50(50);

    private static final EnumUtils.WireIndex<GitLabProjectProjectsShareGroupAccess> WIRE_INDEX =
            EnumUtils.index(GitLabProjectProjectsShareGroupAccess.class, value -> String.valueOf(value.wireValue()));

    private final int wireValue;

    GitLabProjectProjectsShareGroupAccess(final int wireValue) {
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
    public static GitLabProjectProjectsShareGroupAccess fromWire(final int value) {
        return WIRE_INDEX
                .fromWire(String.valueOf(value))
                .orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
