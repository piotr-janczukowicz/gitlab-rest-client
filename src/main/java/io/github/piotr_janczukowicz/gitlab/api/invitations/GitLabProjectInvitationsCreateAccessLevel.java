package io.github.piotr_janczukowicz.gitlab.api.invitations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project invitations create access level. */
@CatalogSchema("operations/postApiV4ProjectsIdInvitations/requestBody/properties/access_level")
public enum GitLabProjectInvitationsCreateAccessLevel {
    GUEST(10),
    PLANNER(15),
    REPORTER(20),
    SECURITY_MANAGER(25),
    DEVELOPER(30),
    MAINTAINER(40),
    OWNER(50),
    MINIMAL_ACCESS(5);

    private static final EnumUtils.WireIndex<GitLabProjectInvitationsCreateAccessLevel> WIRE_INDEX = EnumUtils.index(
            GitLabProjectInvitationsCreateAccessLevel.class, value -> String.valueOf(value.wireValue()));

    private final int wireValue;

    GitLabProjectInvitationsCreateAccessLevel(final int wireValue) {
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
    public static GitLabProjectInvitationsCreateAccessLevel fromWire(final int value) {
        return WIRE_INDEX
                .fromWire(String.valueOf(value))
                .orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
