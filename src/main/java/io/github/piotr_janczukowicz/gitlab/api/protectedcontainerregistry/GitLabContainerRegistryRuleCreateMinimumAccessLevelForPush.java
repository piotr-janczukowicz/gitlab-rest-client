package io.github.piotr_janczukowicz.gitlab.api.protectedcontainerregistry;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab container registry rule create minimum access level for push. */
@CatalogSchema(
        "operations/postApiV4ProjectsIdRegistryProtectionRepositoryRules/requestBody/properties/minimum_access_level_for_push")
public enum GitLabContainerRegistryRuleCreateMinimumAccessLevelForPush {
    MAINTAINER("maintainer"),
    OWNER("owner"),
    ADMIN("admin");

    private static final EnumUtils.WireIndex<GitLabContainerRegistryRuleCreateMinimumAccessLevelForPush> WIRE_INDEX =
            EnumUtils.index(
                    GitLabContainerRegistryRuleCreateMinimumAccessLevelForPush.class,
                    GitLabContainerRegistryRuleCreateMinimumAccessLevelForPush::wireValue);

    private final String wireValue;

    GitLabContainerRegistryRuleCreateMinimumAccessLevelForPush(final String wireValue) {
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
    public static GitLabContainerRegistryRuleCreateMinimumAccessLevelForPush fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
