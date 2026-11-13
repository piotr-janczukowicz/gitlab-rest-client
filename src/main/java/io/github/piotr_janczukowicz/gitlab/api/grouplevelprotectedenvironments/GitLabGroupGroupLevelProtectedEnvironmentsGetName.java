package io.github.piotr_janczukowicz.gitlab.api.grouplevelprotectedenvironments;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab group group level protected environments get name. */
@CatalogSchema("operations/getApiV4GroupsIdProtectedEnvironmentsName/parameters/name/schema")
public enum GitLabGroupGroupLevelProtectedEnvironmentsGetName {
    PRODUCTION("production"),
    STAGING("staging"),
    TESTING("testing"),
    DEVELOPMENT("development"),
    OTHER("other");

    private static final EnumUtils.WireIndex<GitLabGroupGroupLevelProtectedEnvironmentsGetName> WIRE_INDEX =
            EnumUtils.index(
                    GitLabGroupGroupLevelProtectedEnvironmentsGetName.class,
                    GitLabGroupGroupLevelProtectedEnvironmentsGetName::wireValue);

    private final String wireValue;

    GitLabGroupGroupLevelProtectedEnvironmentsGetName(final String wireValue) {
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
    public static GitLabGroupGroupLevelProtectedEnvironmentsGetName fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
