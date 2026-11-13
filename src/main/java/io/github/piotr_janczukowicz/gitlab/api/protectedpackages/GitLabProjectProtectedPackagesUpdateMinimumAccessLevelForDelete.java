package io.github.piotr_janczukowicz.gitlab.api.protectedpackages;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project protected packages update minimum access level for delete. */
@CatalogSchema(
        "operations/patchApiV4ProjectsIdPackagesProtectionRulesPackageProtectionRuleId/requestBody/properties/minimum_access_level_for_delete")
public enum GitLabProjectProtectedPackagesUpdateMinimumAccessLevelForDelete {
    OWNER("owner"),
    ADMIN("admin");

    private static final EnumUtils.WireIndex<GitLabProjectProtectedPackagesUpdateMinimumAccessLevelForDelete>
            WIRE_INDEX = EnumUtils.index(
                    GitLabProjectProtectedPackagesUpdateMinimumAccessLevelForDelete.class,
                    GitLabProjectProtectedPackagesUpdateMinimumAccessLevelForDelete::wireValue);

    private final String wireValue;

    GitLabProjectProtectedPackagesUpdateMinimumAccessLevelForDelete(final String wireValue) {
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
    public static GitLabProjectProtectedPackagesUpdateMinimumAccessLevelForDelete fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
