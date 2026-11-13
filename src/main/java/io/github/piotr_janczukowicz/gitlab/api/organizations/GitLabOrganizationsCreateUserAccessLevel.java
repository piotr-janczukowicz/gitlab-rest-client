package io.github.piotr_janczukowicz.gitlab.api.organizations;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab organizations create user access level. */
@CatalogSchema("operations/postApiV4OrganizationsIdUsers/requestBody/properties/access_level")
public enum GitLabOrganizationsCreateUserAccessLevel {
    DEFAULT("default"),
    OWNER("owner");

    private static final EnumUtils.WireIndex<GitLabOrganizationsCreateUserAccessLevel> WIRE_INDEX = EnumUtils.index(
            GitLabOrganizationsCreateUserAccessLevel.class, GitLabOrganizationsCreateUserAccessLevel::wireValue);

    private final String wireValue;

    GitLabOrganizationsCreateUserAccessLevel(final String wireValue) {
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
     * @throws IllegalArgumentException if {@code value} is not a known value
     */
    @JsonCreator
    public static GitLabOrganizationsCreateUserAccessLevel fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
