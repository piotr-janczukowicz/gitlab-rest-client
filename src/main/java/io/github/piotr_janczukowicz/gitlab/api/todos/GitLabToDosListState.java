package io.github.piotr_janczukowicz.gitlab.api.todos;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab to dos list state. */
@CatalogSchema("operations/getApiV4Todos/parameters/state/schema")
public enum GitLabToDosListState {
    PENDING("pending"),
    DONE("done");

    private static final EnumUtils.WireIndex<GitLabToDosListState> WIRE_INDEX =
            EnumUtils.index(GitLabToDosListState.class, GitLabToDosListState::wireValue);

    private final String wireValue;

    GitLabToDosListState(final String wireValue) {
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
    public static GitLabToDosListState fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
