package io.github.piotr_janczukowicz.gitlab.api.users;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab users update preference mobile push working days. */
@CatalogSchema("operations/putApiV4UserPreferences/requestBody/properties/mobile_push_working_days/items")
public enum GitLabUsersUpdatePreferenceMobilePushWorkingDays {
    MONDAY("monday"),
    TUESDAY("tuesday"),
    WEDNESDAY("wednesday"),
    THURSDAY("thursday"),
    FRIDAY("friday"),
    SATURDAY("saturday"),
    SUNDAY("sunday");

    private static final EnumUtils.WireIndex<GitLabUsersUpdatePreferenceMobilePushWorkingDays> WIRE_INDEX =
            EnumUtils.index(
                    GitLabUsersUpdatePreferenceMobilePushWorkingDays.class,
                    GitLabUsersUpdatePreferenceMobilePushWorkingDays::wireValue);

    private final String wireValue;

    GitLabUsersUpdatePreferenceMobilePushWorkingDays(final String wireValue) {
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
    public static GitLabUsersUpdatePreferenceMobilePushWorkingDays fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
