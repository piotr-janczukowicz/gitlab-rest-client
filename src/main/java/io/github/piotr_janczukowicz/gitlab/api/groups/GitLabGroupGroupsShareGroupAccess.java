package io.github.piotr_janczukowicz.gitlab.api.groups;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab group groups share group access. */
@CatalogSchema("operations/postApiV4GroupsIdShare/requestBody/properties/group_access")
public enum GitLabGroupGroupsShareGroupAccess {
    N_5(5),
    N_10(10),
    N_15(15),
    N_20(20),
    N_25(25),
    N_30(30),
    N_40(40),
    N_50(50);

    private static final EnumUtils.WireIndex<GitLabGroupGroupsShareGroupAccess> WIRE_INDEX =
            EnumUtils.index(GitLabGroupGroupsShareGroupAccess.class, value -> String.valueOf(value.wireValue()));

    private final int wireValue;

    GitLabGroupGroupsShareGroupAccess(final int wireValue) {
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
    public static GitLabGroupGroupsShareGroupAccess fromWire(final int value) {
        return WIRE_INDEX
                .fromWire(String.valueOf(value))
                .orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
