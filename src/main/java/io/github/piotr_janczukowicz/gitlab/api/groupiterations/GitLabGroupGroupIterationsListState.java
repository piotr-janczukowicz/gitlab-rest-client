package io.github.piotr_janczukowicz.gitlab.api.groupiterations;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab group group iterations list state. */
@CatalogSchema("operations/getApiV4GroupsIdIterations/parameters/state/schema")
public enum GitLabGroupGroupIterationsListState {
    OPENED("opened"),
    UPCOMING("upcoming"),
    STARTED("started"),
    CURRENT("current"),
    CLOSED("closed"),
    ALL("all");

    private static final EnumUtils.WireIndex<GitLabGroupGroupIterationsListState> WIRE_INDEX =
            EnumUtils.index(GitLabGroupGroupIterationsListState.class, GitLabGroupGroupIterationsListState::wireValue);

    private final String wireValue;

    GitLabGroupGroupIterationsListState(final String wireValue) {
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
    public static GitLabGroupGroupIterationsListState fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
