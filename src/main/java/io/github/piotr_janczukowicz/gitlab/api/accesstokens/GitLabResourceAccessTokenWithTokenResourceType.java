package io.github.piotr_janczukowicz.gitlab.api.accesstokens;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab resource access token with token resource type. */
@CatalogSchema("components/schemas/APIEntitiesResourceAccessTokenWithToken/properties/resource_type")
public enum GitLabResourceAccessTokenWithTokenResourceType {
    PROJECT("project"),
    GROUP("group"),
    /** A value this library version does not know. */
    UNRECOGNIZED("unrecognized");

    private static final EnumUtils.WireIndex<GitLabResourceAccessTokenWithTokenResourceType> WIRE_INDEX =
            EnumUtils.index(
                    GitLabResourceAccessTokenWithTokenResourceType.class,
                    GitLabResourceAccessTokenWithTokenResourceType::wireValue);

    private final String wireValue;

    GitLabResourceAccessTokenWithTokenResourceType(final String wireValue) {
        this.wireValue = wireValue;
    }

    /**
     * Value GitLab sends and expects in JSON.
     *
     * @return wire value
     */
    @JsonValue
    public String wireValue() {
        return wireValue;
    }

    /**
     * Resolves the constant from its wire value.
     *
     * @param value JSON value
     * @return matching constant
     * @throws NullPointerException if {@code value} is {@code null}
     */
    @JsonCreator
    public static GitLabResourceAccessTokenWithTokenResourceType fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
