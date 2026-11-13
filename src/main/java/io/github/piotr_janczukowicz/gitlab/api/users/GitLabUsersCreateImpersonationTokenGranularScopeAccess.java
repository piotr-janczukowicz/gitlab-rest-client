package io.github.piotr_janczukowicz.gitlab.api.users;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab users create impersonation token granular scope access. */
@CatalogSchema(
        "operations/postApiV4UsersUserIdImpersonationTokens/requestBody/properties/granular_scopes/items/properties/access")
public enum GitLabUsersCreateImpersonationTokenGranularScopeAccess {
    PERSONAL_PROJECTS("personal_projects"),
    ALL_MEMBERSHIPS("all_memberships"),
    SELECTED_MEMBERSHIPS("selected_memberships"),
    USER("user"),
    INSTANCE("instance");

    private static final EnumUtils.WireIndex<GitLabUsersCreateImpersonationTokenGranularScopeAccess> WIRE_INDEX =
            EnumUtils.index(
                    GitLabUsersCreateImpersonationTokenGranularScopeAccess.class,
                    GitLabUsersCreateImpersonationTokenGranularScopeAccess::wireValue);

    private final String wireValue;

    GitLabUsersCreateImpersonationTokenGranularScopeAccess(final String wireValue) {
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
    public static GitLabUsersCreateImpersonationTokenGranularScopeAccess fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
