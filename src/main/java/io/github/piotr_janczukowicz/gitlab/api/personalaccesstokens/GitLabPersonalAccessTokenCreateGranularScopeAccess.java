package io.github.piotr_janczukowicz.gitlab.api.personalaccesstokens;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab personal access token create granular scope access. */
@CatalogSchema(
        "operations/postApiV4UserPersonalAccessTokens/requestBody/properties/granular_scopes/items/properties/access")
public enum GitLabPersonalAccessTokenCreateGranularScopeAccess {
    PERSONAL_PROJECTS("personal_projects"),
    ALL_MEMBERSHIPS("all_memberships"),
    SELECTED_MEMBERSHIPS("selected_memberships"),
    USER("user"),
    INSTANCE("instance");

    private static final EnumUtils.WireIndex<GitLabPersonalAccessTokenCreateGranularScopeAccess> WIRE_INDEX =
            EnumUtils.index(
                    GitLabPersonalAccessTokenCreateGranularScopeAccess.class,
                    GitLabPersonalAccessTokenCreateGranularScopeAccess::wireValue);

    private final String wireValue;

    GitLabPersonalAccessTokenCreateGranularScopeAccess(final String wireValue) {
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
    public static GitLabPersonalAccessTokenCreateGranularScopeAccess fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
