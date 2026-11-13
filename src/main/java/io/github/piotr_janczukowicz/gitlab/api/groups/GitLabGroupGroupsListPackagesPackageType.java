package io.github.piotr_janczukowicz.gitlab.api.groups;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab group groups list packages package type. */
@CatalogSchema("operations/getApiV4GroupsIdPackages/parameters/package_type/schema")
public enum GitLabGroupGroupsListPackagesPackageType {
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

    private static final EnumUtils.WireIndex<GitLabGroupGroupsListPackagesPackageType> WIRE_INDEX = EnumUtils.index(
            GitLabGroupGroupsListPackagesPackageType.class, GitLabGroupGroupsListPackagesPackageType::wireValue);

    private final String wireValue;

    GitLabGroupGroupsListPackagesPackageType(final String wireValue) {
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
    public static GitLabGroupGroupsListPackagesPackageType fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
