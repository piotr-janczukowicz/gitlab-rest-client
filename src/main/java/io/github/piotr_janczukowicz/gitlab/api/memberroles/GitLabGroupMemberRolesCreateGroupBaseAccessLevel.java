package io.github.piotr_janczukowicz.gitlab.api.memberroles;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab group member roles create group base access level. */
@CatalogSchema("operations/postApiV4GroupsIdMemberRoles/requestBody/properties/base_access_level")
public enum GitLabGroupMemberRolesCreateGroupBaseAccessLevel {
    GUEST(10),
    PLANNER(15),
    REPORTER(20),
    SECURITY_MANAGER(25),
    DEVELOPER(30),
    MAINTAINER(40),
    OWNER(50);

    private static final EnumUtils.WireIndex<GitLabGroupMemberRolesCreateGroupBaseAccessLevel> WIRE_INDEX =
            EnumUtils.index(
                    GitLabGroupMemberRolesCreateGroupBaseAccessLevel.class, value -> String.valueOf(value.wireValue()));

    private final int wireValue;

    GitLabGroupMemberRolesCreateGroupBaseAccessLevel(final int wireValue) {
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
    public static GitLabGroupMemberRolesCreateGroupBaseAccessLevel fromWire(final int value) {
        return WIRE_INDEX
                .fromWire(String.valueOf(value))
                .orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
