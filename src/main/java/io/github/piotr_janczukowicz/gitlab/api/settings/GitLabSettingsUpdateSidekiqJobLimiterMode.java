package io.github.piotr_janczukowicz.gitlab.api.settings;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab settings update sidekiq job limiter mode. */
@CatalogSchema("operations/putApiV4ApplicationSettings/requestBody/properties/sidekiq_job_limiter_mode")
public enum GitLabSettingsUpdateSidekiqJobLimiterMode {
    TRACK("track"),
    COMPRESS("compress");

    private static final EnumUtils.WireIndex<GitLabSettingsUpdateSidekiqJobLimiterMode> WIRE_INDEX = EnumUtils.index(
            GitLabSettingsUpdateSidekiqJobLimiterMode.class, GitLabSettingsUpdateSidekiqJobLimiterMode::wireValue);

    private final String wireValue;

    GitLabSettingsUpdateSidekiqJobLimiterMode(final String wireValue) {
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
    public static GitLabSettingsUpdateSidekiqJobLimiterMode fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
