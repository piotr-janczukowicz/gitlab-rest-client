package io.github.piotr_janczukowicz.gitlab.api.search;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project search call state. */
@CatalogSchema("operations/getApiV4ProjectsIdDashSearch/parameters/state/schema")
public enum GitLabProjectSearchCallState {
    ALL("all"),
    OPENED("opened"),
    CLOSED("closed"),
    MERGED("merged");

    private static final EnumUtils.WireIndex<GitLabProjectSearchCallState> WIRE_INDEX =
            EnumUtils.index(GitLabProjectSearchCallState.class, GitLabProjectSearchCallState::wireValue);

    private final String wireValue;

    GitLabProjectSearchCallState(final String wireValue) {
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
    public static GitLabProjectSearchCallState fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
