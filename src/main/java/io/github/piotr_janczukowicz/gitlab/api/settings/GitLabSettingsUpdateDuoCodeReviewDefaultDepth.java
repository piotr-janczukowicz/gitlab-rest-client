package io.github.piotr_janczukowicz.gitlab.api.settings;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab settings update duo code review default depth. */
@CatalogSchema("operations/putApiV4ApplicationSettings/requestBody/properties/duo_code_review_default_depth")
public enum GitLabSettingsUpdateDuoCodeReviewDefaultDepth {
    STANDARD("standard"),
    DEEP("deep");

    private static final EnumUtils.WireIndex<GitLabSettingsUpdateDuoCodeReviewDefaultDepth> WIRE_INDEX =
            EnumUtils.index(
                    GitLabSettingsUpdateDuoCodeReviewDefaultDepth.class,
                    GitLabSettingsUpdateDuoCodeReviewDefaultDepth::wireValue);

    private final String wireValue;

    GitLabSettingsUpdateDuoCodeReviewDefaultDepth(final String wireValue) {
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
    public static GitLabSettingsUpdateDuoCodeReviewDefaultDepth fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
