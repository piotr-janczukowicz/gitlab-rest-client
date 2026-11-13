package io.github.piotr_janczukowicz.gitlab.api.grouplevelprotectedenvironments;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab group protected environment update deploy access level access level. */
@CatalogSchema(
        "operations/putApiV4GroupsIdProtectedEnvironmentsName/requestBody/properties/deploy_access_levels/items/properties/access_level")
public enum GitLabGroupProtectedEnvironmentUpdateDeployAccessLevelAccessLevel {
    MAINTAINER(40),
    DEVELOPER(30),
    REPORTER(20),
    ADMINISTRATOR(60);

    private static final EnumUtils.WireIndex<GitLabGroupProtectedEnvironmentUpdateDeployAccessLevelAccessLevel>
            WIRE_INDEX = EnumUtils.index(
                    GitLabGroupProtectedEnvironmentUpdateDeployAccessLevelAccessLevel.class,
                    value -> String.valueOf(value.wireValue()));

    private final int wireValue;

    GitLabGroupProtectedEnvironmentUpdateDeployAccessLevelAccessLevel(final int wireValue) {
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
    public static GitLabGroupProtectedEnvironmentUpdateDeployAccessLevelAccessLevel fromWire(final int value) {
        return WIRE_INDEX
                .fromWire(String.valueOf(value))
                .orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
