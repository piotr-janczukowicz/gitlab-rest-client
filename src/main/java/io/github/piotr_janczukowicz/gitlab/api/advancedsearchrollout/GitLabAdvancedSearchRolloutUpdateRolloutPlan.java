package io.github.piotr_janczukowicz.gitlab.api.advancedsearchrollout;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab advanced search rollout update rollout plan. */
@CatalogSchema("operations/putApiV4ElasticsearchIndexedNamespacesRollout/requestBody/properties/plan")
public enum GitLabAdvancedSearchRolloutUpdateRolloutPlan {
    BRONZE("bronze"),
    SILVER("silver"),
    PREMIUM("premium"),
    GOLD("gold"),
    ULTIMATE("ultimate"),
    ULTIMATE_TRIAL("ultimate_trial"),
    ULTIMATE_TRIAL_PAID_CUSTOMER("ultimate_trial_paid_customer"),
    PREMIUM_TRIAL("premium_trial"),
    OPENSOURCE("opensource");

    private static final EnumUtils.WireIndex<GitLabAdvancedSearchRolloutUpdateRolloutPlan> WIRE_INDEX = EnumUtils.index(
            GitLabAdvancedSearchRolloutUpdateRolloutPlan.class,
            GitLabAdvancedSearchRolloutUpdateRolloutPlan::wireValue);

    private final String wireValue;

    GitLabAdvancedSearchRolloutUpdateRolloutPlan(final String wireValue) {
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
    public static GitLabAdvancedSearchRolloutUpdateRolloutPlan fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
