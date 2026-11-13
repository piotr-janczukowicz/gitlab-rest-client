package io.github.piotr_janczukowicz.gitlab.api.vscode;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab vscode get v1 resource name. */
@CatalogSchema("operations/getApiV4VscodeSettingsSyncV1ResourceResourceNameId/parameters/resource_name/schema")
public enum GitLabVSCodeGetV1ResourceName {
    SETTINGS("settings"),
    EXTENSIONS("extensions"),
    GLOBAL_STATE("globalState"),
    MACHINES("machines"),
    KEYBINDINGS("keybindings"),
    SNIPPETS("snippets"),
    TASKS("tasks"),
    PROFILES("profiles");

    private static final EnumUtils.WireIndex<GitLabVSCodeGetV1ResourceName> WIRE_INDEX =
            EnumUtils.index(GitLabVSCodeGetV1ResourceName.class, GitLabVSCodeGetV1ResourceName::wireValue);

    private final String wireValue;

    GitLabVSCodeGetV1ResourceName(final String wireValue) {
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
    public static GitLabVSCodeGetV1ResourceName fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
