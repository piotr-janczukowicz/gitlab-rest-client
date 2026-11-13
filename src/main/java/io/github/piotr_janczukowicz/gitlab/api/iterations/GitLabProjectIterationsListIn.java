package io.github.piotr_janczukowicz.gitlab.api.iterations;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project iterations list in. */
@CatalogSchema("operations/getApiV4ProjectsIdIterations/parameters/in/schema/items")
public enum GitLabProjectIterationsListIn {
    TITLE("title"),
    CADENCE_TITLE("cadence_title");

    private static final EnumUtils.WireIndex<GitLabProjectIterationsListIn> WIRE_INDEX =
            EnumUtils.index(GitLabProjectIterationsListIn.class, GitLabProjectIterationsListIn::wireValue);

    private final String wireValue;

    GitLabProjectIterationsListIn(final String wireValue) {
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
    public static GitLabProjectIterationsListIn fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
