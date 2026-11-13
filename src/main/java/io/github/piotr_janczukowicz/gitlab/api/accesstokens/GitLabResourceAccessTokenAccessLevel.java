package io.github.piotr_janczukowicz.gitlab.api.accesstokens;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab resource access token access level. */
@CatalogSchema("components/schemas/APIEntitiesResourceAccessToken/properties/access_level")
public enum GitLabResourceAccessTokenAccessLevel {
    GUEST(10),
    REPORTER(20),
    DEVELOPER(30),
    MAINTAINER(40),
    OWNER(50);

    private static final EnumUtils.WireIndex<GitLabResourceAccessTokenAccessLevel> WIRE_INDEX =
            EnumUtils.index(GitLabResourceAccessTokenAccessLevel.class, value -> String.valueOf(value.wireValue()));

    private final int wireValue;

    GitLabResourceAccessTokenAccessLevel(final int wireValue) {
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
    public static GitLabResourceAccessTokenAccessLevel fromWire(final int value) {
        return WIRE_INDEX
                .fromWire(String.valueOf(value))
                .orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
