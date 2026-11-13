package io.github.piotr_janczukowicz.gitlab.api.mobilepushsubscriptions;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab mobile push subscriptions create payload mode. */
@CatalogSchema("operations/postApiV4UserPushSubscriptions/requestBody/properties/payload_mode")
public enum GitLabMobilePushSubscriptionsCreatePayloadMode {
    FULL("full"),
    ID_ONLY("id_only");

    private static final EnumUtils.WireIndex<GitLabMobilePushSubscriptionsCreatePayloadMode> WIRE_INDEX =
            EnumUtils.index(
                    GitLabMobilePushSubscriptionsCreatePayloadMode.class,
                    GitLabMobilePushSubscriptionsCreatePayloadMode::wireValue);

    private final String wireValue;

    GitLabMobilePushSubscriptionsCreatePayloadMode(final String wireValue) {
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
    public static GitLabMobilePushSubscriptionsCreatePayloadMode fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
