package io.github.piotr_janczukowicz.gitlab.api.dependencies;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project dependencies list package manager. */
@CatalogSchema("operations/getApiV4ProjectsIdDependencies/parameters/package_manager/schema/items")
public enum GitLabProjectDependenciesListPackageManager {
    BUNDLER("bundler"),
    YARN("yarn"),
    NPM("npm"),
    PNPM("pnpm"),
    BUN("bun"),
    MAVEN("maven"),
    COMPOSER("composer"),
    PIP("pip"),
    CONAN("conan"),
    GO("go"),
    NUGET("nuget"),
    SBT("sbt"),
    GRADLE("gradle"),
    PIPENV("pipenv"),
    POETRY("poetry"),
    SETUPTOOLS("setuptools"),
    APK("apk"),
    CONDA("conda"),
    PUB("pub"),
    CARGO("cargo");

    private static final EnumUtils.WireIndex<GitLabProjectDependenciesListPackageManager> WIRE_INDEX = EnumUtils.index(
            GitLabProjectDependenciesListPackageManager.class, GitLabProjectDependenciesListPackageManager::wireValue);

    private final String wireValue;

    GitLabProjectDependenciesListPackageManager(final String wireValue) {
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
    public static GitLabProjectDependenciesListPackageManager fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
