package io.github.piotr_janczukowicz.gitlab.api.resourcegroup;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project resource group update process mode. */
@CatalogSchema("operations/putApiV4ProjectsIdResourceGroupsKey/requestBody/properties/process_mode")
public enum GitLabProjectResourceGroupUpdateProcessMode {
    UNORDERED("unordered"),
    OLDEST_FIRST("oldest_first"),
    NEWEST_FIRST("newest_first"),
    NEWEST_READY_FIRST("newest_ready_first");

    private static final EnumUtils.WireIndex<GitLabProjectResourceGroupUpdateProcessMode> WIRE_INDEX = EnumUtils.index(
            GitLabProjectResourceGroupUpdateProcessMode.class, GitLabProjectResourceGroupUpdateProcessMode::wireValue);

    private final String wireValue;

    GitLabProjectResourceGroupUpdateProcessMode(final String wireValue) {
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
    public static GitLabProjectResourceGroupUpdateProcessMode fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
