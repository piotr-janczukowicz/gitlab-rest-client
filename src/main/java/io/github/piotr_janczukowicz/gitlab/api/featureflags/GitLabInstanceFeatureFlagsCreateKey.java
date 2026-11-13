package io.github.piotr_janczukowicz.gitlab.api.featureflags;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab instance feature flags create key. */
@CatalogSchema("operations/postApiV4FeaturesName/requestBody/properties/key")
public enum GitLabInstanceFeatureFlagsCreateKey {
    PERCENTAGE_OF_ACTORS("percentage_of_actors"),
    PERCENTAGE_OF_TIME("percentage_of_time");

    private static final EnumUtils.WireIndex<GitLabInstanceFeatureFlagsCreateKey> WIRE_INDEX =
            EnumUtils.index(GitLabInstanceFeatureFlagsCreateKey.class, GitLabInstanceFeatureFlagsCreateKey::wireValue);

    private final String wireValue;

    GitLabInstanceFeatureFlagsCreateKey(final String wireValue) {
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
    public static GitLabInstanceFeatureFlagsCreateKey fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
