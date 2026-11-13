package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project projects list groups shared min access level. */
@CatalogSchema("operations/getApiV4ProjectsIdGroups/parameters/shared_min_access_level/schema")
public enum GitLabProjectProjectsListGroupsSharedMinAccessLevel {
    GUEST(10),
    PLANNER(15),
    REPORTER(20),
    SECURITY_MANAGER(25),
    DEVELOPER(30),
    MAINTAINER(40),
    OWNER(50);

    private static final EnumUtils.WireIndex<GitLabProjectProjectsListGroupsSharedMinAccessLevel> WIRE_INDEX =
            EnumUtils.index(
                    GitLabProjectProjectsListGroupsSharedMinAccessLevel.class,
                    value -> String.valueOf(value.wireValue()));

    private final int wireValue;

    GitLabProjectProjectsListGroupsSharedMinAccessLevel(final int wireValue) {
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
    public static GitLabProjectProjectsListGroupsSharedMinAccessLevel fromWire(final int value) {
        return WIRE_INDEX
                .fromWire(String.valueOf(value))
                .orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
