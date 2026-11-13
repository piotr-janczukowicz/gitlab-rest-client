package io.github.piotr_janczukowicz.gitlab.api.serviceaccounts;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project service accounts list personal access tokens state. */
@CatalogSchema("operations/getApiV4ProjectsIdServiceAccountsUserIdPersonalAccessTokens/parameters/state/schema")
public enum GitLabProjectServiceAccountsListPersonalAccessTokensState {
    ALL("all"),
    ACTIVE("active"),
    INACTIVE("inactive");

    private static final EnumUtils.WireIndex<GitLabProjectServiceAccountsListPersonalAccessTokensState> WIRE_INDEX =
            EnumUtils.index(
                    GitLabProjectServiceAccountsListPersonalAccessTokensState.class,
                    GitLabProjectServiceAccountsListPersonalAccessTokensState::wireValue);

    private final String wireValue;

    GitLabProjectServiceAccountsListPersonalAccessTokensState(final String wireValue) {
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
    public static GitLabProjectServiceAccountsListPersonalAccessTokensState fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
