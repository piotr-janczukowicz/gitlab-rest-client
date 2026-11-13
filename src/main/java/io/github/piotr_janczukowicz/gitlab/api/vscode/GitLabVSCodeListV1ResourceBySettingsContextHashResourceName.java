package io.github.piotr_janczukowicz.gitlab.api.vscode;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab vscode list v1 resource by settings context hash resource name. */
@CatalogSchema(
        "operations/getApiV4VscodeSettingsSyncSettingsContextHashV1ResourceResourceName/parameters/resource_name/schema")
public enum GitLabVSCodeListV1ResourceBySettingsContextHashResourceName {
    SETTINGS("settings"),
    EXTENSIONS("extensions"),
    GLOBAL_STATE("globalState"),
    MACHINES("machines"),
    KEYBINDINGS("keybindings"),
    SNIPPETS("snippets"),
    TASKS("tasks"),
    PROFILES("profiles");

    private static final EnumUtils.WireIndex<GitLabVSCodeListV1ResourceBySettingsContextHashResourceName> WIRE_INDEX =
            EnumUtils.index(
                    GitLabVSCodeListV1ResourceBySettingsContextHashResourceName.class,
                    GitLabVSCodeListV1ResourceBySettingsContextHashResourceName::wireValue);

    private final String wireValue;

    GitLabVSCodeListV1ResourceBySettingsContextHashResourceName(final String wireValue) {
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
    public static GitLabVSCodeListV1ResourceBySettingsContextHashResourceName fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
