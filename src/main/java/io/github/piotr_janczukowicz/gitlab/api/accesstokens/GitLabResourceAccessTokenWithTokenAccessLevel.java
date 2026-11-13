package io.github.piotr_janczukowicz.gitlab.api.accesstokens;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab resource access token with token access level. */
@CatalogSchema("components/schemas/APIEntitiesResourceAccessTokenWithToken/properties/access_level")
public enum GitLabResourceAccessTokenWithTokenAccessLevel {
    GUEST(10),
    REPORTER(20),
    DEVELOPER(30),
    MAINTAINER(40),
    OWNER(50);

    private static final EnumUtils.WireIndex<GitLabResourceAccessTokenWithTokenAccessLevel> WIRE_INDEX =
            EnumUtils.index(
                    GitLabResourceAccessTokenWithTokenAccessLevel.class, value -> String.valueOf(value.wireValue()));

    private final int wireValue;

    GitLabResourceAccessTokenWithTokenAccessLevel(final int wireValue) {
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
    public static GitLabResourceAccessTokenWithTokenAccessLevel fromWire(final int value) {
        return WIRE_INDEX
                .fromWire(String.valueOf(value))
                .orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
