package io.github.piotr_janczukowicz.gitlab.api.mobilepushsubscriptions;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab mobile push subscriptions create apns environment. */
@CatalogSchema("operations/postApiV4UserPushSubscriptions/requestBody/properties/apns_environment")
public enum GitLabMobilePushSubscriptionsCreateApnsEnvironment {
    PRODUCTION("production"),
    SANDBOX("sandbox");

    private static final EnumUtils.WireIndex<GitLabMobilePushSubscriptionsCreateApnsEnvironment> WIRE_INDEX =
            EnumUtils.index(
                    GitLabMobilePushSubscriptionsCreateApnsEnvironment.class,
                    GitLabMobilePushSubscriptionsCreateApnsEnvironment::wireValue);

    private final String wireValue;

    GitLabMobilePushSubscriptionsCreateApnsEnvironment(final String wireValue) {
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
    public static GitLabMobilePushSubscriptionsCreateApnsEnvironment fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
