package io.github.piotr_janczukowicz.gitlab.api.settings;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab settings update enabled git access protocol. */
@CatalogSchema("operations/putApiV4ApplicationSettings/requestBody/properties/enabled_git_access_protocol")
public enum GitLabSettingsUpdateEnabledGitAccessProtocol {
    SSH("ssh"),
    HTTP("http"),
    ALL("all");

    private static final EnumUtils.WireIndex<GitLabSettingsUpdateEnabledGitAccessProtocol> WIRE_INDEX = EnumUtils.index(
            GitLabSettingsUpdateEnabledGitAccessProtocol.class,
            GitLabSettingsUpdateEnabledGitAccessProtocol::wireValue);

    private final String wireValue;

    GitLabSettingsUpdateEnabledGitAccessProtocol(final String wireValue) {
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
    public static GitLabSettingsUpdateEnabledGitAccessProtocol fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
