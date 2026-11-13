package io.github.piotr_janczukowicz.gitlab.api.systemhooks;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab system hooks create branch filter strategy. */
@CatalogSchema("operations/postApiV4Hooks/requestBody/properties/branch_filter_strategy")
public enum GitLabSystemHooksCreateBranchFilterStrategy {
    WILDCARD("wildcard"),
    REGEX("regex"),
    ALL_BRANCHES("all_branches");

    private static final EnumUtils.WireIndex<GitLabSystemHooksCreateBranchFilterStrategy> WIRE_INDEX = EnumUtils.index(
            GitLabSystemHooksCreateBranchFilterStrategy.class, GitLabSystemHooksCreateBranchFilterStrategy::wireValue);

    private final String wireValue;

    GitLabSystemHooksCreateBranchFilterStrategy(final String wireValue) {
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
    public static GitLabSystemHooksCreateBranchFilterStrategy fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
