package io.github.piotr_janczukowicz.gitlab.api.protectedpackages;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project protected packages update package type. */
@CatalogSchema(
        "operations/patchApiV4ProjectsIdPackagesProtectionRulesPackageProtectionRuleId/requestBody/properties/package_type")
public enum GitLabProjectProtectedPackagesUpdatePackageType {
    CARGO("cargo"),
    CONAN("conan"),
    GENERIC("generic"),
    HELM("helm"),
    MAVEN("maven"),
    NPM("npm"),
    NUGET("nuget"),
    PYPI("pypi"),
    RUBYGEMS("rubygems"),
    TERRAFORM_MODULE("terraform_module");

    private static final EnumUtils.WireIndex<GitLabProjectProtectedPackagesUpdatePackageType> WIRE_INDEX =
            EnumUtils.index(
                    GitLabProjectProtectedPackagesUpdatePackageType.class,
                    GitLabProjectProtectedPackagesUpdatePackageType::wireValue);

    private final String wireValue;

    GitLabProjectProtectedPackagesUpdatePackageType(final String wireValue) {
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
    public static GitLabProjectProtectedPackagesUpdatePackageType fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
