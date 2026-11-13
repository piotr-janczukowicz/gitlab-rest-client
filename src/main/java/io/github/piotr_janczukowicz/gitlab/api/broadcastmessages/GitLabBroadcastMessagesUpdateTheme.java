package io.github.piotr_janczukowicz.gitlab.api.broadcastmessages;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab broadcast messages update theme. */
@CatalogSchema("operations/putApiV4BroadcastMessagesId/requestBody/properties/theme")
public enum GitLabBroadcastMessagesUpdateTheme {
    INDIGO("indigo"),
    LIGHT_INDIGO("light-indigo"),
    BLUE("blue"),
    LIGHT_BLUE("light-blue"),
    GREEN("green"),
    LIGHT_GREEN("light-green"),
    RED("red"),
    LIGHT_RED("light-red"),
    DARK("dark"),
    LIGHT("light");

    private static final EnumUtils.WireIndex<GitLabBroadcastMessagesUpdateTheme> WIRE_INDEX =
            EnumUtils.index(GitLabBroadcastMessagesUpdateTheme.class, GitLabBroadcastMessagesUpdateTheme::wireValue);

    private final String wireValue;

    GitLabBroadcastMessagesUpdateTheme(final String wireValue) {
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
    public static GitLabBroadcastMessagesUpdateTheme fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
