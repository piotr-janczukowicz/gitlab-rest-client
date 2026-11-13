package io.github.piotr_janczukowicz.gitlab.api.personalaccesstokens;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab personal access tokens list self associations min access level. */
@CatalogSchema("operations/getApiV4PersonalAccessTokensSelfAssociations/parameters/min_access_level/schema")
public enum GitLabPersonalAccessTokensListSelfAssociationsMinAccessLevel {
    GUEST(10),
    PLANNER(15),
    REPORTER(20),
    SECURITY_MANAGER(25),
    DEVELOPER(30),
    MAINTAINER(40),
    OWNER(50);

    private static final EnumUtils.WireIndex<GitLabPersonalAccessTokensListSelfAssociationsMinAccessLevel> WIRE_INDEX =
            EnumUtils.index(
                    GitLabPersonalAccessTokensListSelfAssociationsMinAccessLevel.class,
                    value -> String.valueOf(value.wireValue()));

    private final int wireValue;

    GitLabPersonalAccessTokensListSelfAssociationsMinAccessLevel(final int wireValue) {
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
    public static GitLabPersonalAccessTokensListSelfAssociationsMinAccessLevel fromWire(final int value) {
        return WIRE_INDEX
                .fromWire(String.valueOf(value))
                .orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
