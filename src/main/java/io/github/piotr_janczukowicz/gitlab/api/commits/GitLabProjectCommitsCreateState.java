package io.github.piotr_janczukowicz.gitlab.api.commits;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project commits create state. */
@CatalogSchema("operations/postApiV4ProjectsIdStatusesSha/requestBody/properties/state")
public enum GitLabProjectCommitsCreateState {
    PENDING("pending"),
    RUNNING("running"),
    SUCCESS("success"),
    FAILED("failed"),
    CANCELED("canceled"),
    SKIPPED("skipped");

    private static final EnumUtils.WireIndex<GitLabProjectCommitsCreateState> WIRE_INDEX =
            EnumUtils.index(GitLabProjectCommitsCreateState.class, GitLabProjectCommitsCreateState::wireValue);

    private final String wireValue;

    GitLabProjectCommitsCreateState(final String wireValue) {
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
    public static GitLabProjectCommitsCreateState fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
