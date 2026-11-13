package io.github.piotr_janczukowicz.gitlab.api.groupwebhooks;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab group group webhooks update branch filter strategy. */
@CatalogSchema("operations/putApiV4GroupsIdHooksHookId/requestBody/properties/branch_filter_strategy")
public enum GitLabGroupGroupWebhooksUpdateBranchFilterStrategy {
    WILDCARD("wildcard"),
    REGEX("regex"),
    ALL_BRANCHES("all_branches");

    private static final EnumUtils.WireIndex<GitLabGroupGroupWebhooksUpdateBranchFilterStrategy> WIRE_INDEX =
            EnumUtils.index(
                    GitLabGroupGroupWebhooksUpdateBranchFilterStrategy.class,
                    GitLabGroupGroupWebhooksUpdateBranchFilterStrategy::wireValue);

    private final String wireValue;

    GitLabGroupGroupWebhooksUpdateBranchFilterStrategy(final String wireValue) {
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
    public static GitLabGroupGroupWebhooksUpdateBranchFilterStrategy fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
