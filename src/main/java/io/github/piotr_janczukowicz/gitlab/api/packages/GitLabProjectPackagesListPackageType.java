package io.github.piotr_janczukowicz.gitlab.api.packages;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project packages list package type. */
@CatalogSchema("operations/getApiV4ProjectsIdPackages/parameters/package_type/schema")
public enum GitLabProjectPackagesListPackageType {
    MAVEN("maven"),
    NPM("npm"),
    CONAN("conan"),
    NUGET("nuget"),
    PYPI("pypi"),
    COMPOSER("composer"),
    GENERIC("generic"),
    GOLANG("golang"),
    DEBIAN("debian"),
    RUBYGEMS("rubygems"),
    HELM("helm"),
    TERRAFORM_MODULE("terraform_module"),
    RPM("rpm"),
    ML_MODEL("ml_model"),
    CARGO("cargo"),
    SWIFT("swift");

    private static final EnumUtils.WireIndex<GitLabProjectPackagesListPackageType> WIRE_INDEX = EnumUtils.index(
            GitLabProjectPackagesListPackageType.class, GitLabProjectPackagesListPackageType::wireValue);

    private final String wireValue;

    GitLabProjectPackagesListPackageType(final String wireValue) {
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
    public static GitLabProjectPackagesListPackageType fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
