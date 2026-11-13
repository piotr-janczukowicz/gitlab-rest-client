package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab instance merge requests list state. */
@CatalogSchema("operations/getApiV4MergeRequests/parameters/state/schema")
public enum GitLabInstanceMergeRequestsListState {
    OPENED("opened"),
    CLOSED("closed"),
    LOCKED("locked"),
    MERGED("merged"),
    ALL("all");

    private static final EnumUtils.WireIndex<GitLabInstanceMergeRequestsListState> WIRE_INDEX = EnumUtils.index(
            GitLabInstanceMergeRequestsListState.class, GitLabInstanceMergeRequestsListState::wireValue);

    private final String wireValue;

    GitLabInstanceMergeRequestsListState(final String wireValue) {
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
    public static GitLabInstanceMergeRequestsListState fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
