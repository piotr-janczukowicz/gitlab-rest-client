package io.github.piotr_janczukowicz.gitlab.api.users;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab users update status clear status after. */
@CatalogSchema("operations/putApiV4UserStatus/requestBody/properties/clear_status_after")
public enum GitLabUsersUpdateStatusClearStatusAfter {
    N_30_MINUTES("30_minutes"),
    N_3_HOURS("3_hours"),
    N_8_HOURS("8_hours"),
    N_1_DAY("1_day"),
    N_3_DAYS("3_days"),
    N_7_DAYS("7_days"),
    N_30_DAYS("30_days");

    private static final EnumUtils.WireIndex<GitLabUsersUpdateStatusClearStatusAfter> WIRE_INDEX = EnumUtils.index(
            GitLabUsersUpdateStatusClearStatusAfter.class, GitLabUsersUpdateStatusClearStatusAfter::wireValue);

    private final String wireValue;

    GitLabUsersUpdateStatusClearStatusAfter(final String wireValue) {
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
    public static GitLabUsersUpdateStatusClearStatusAfter fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
