package io.github.piotr_janczukowicz.gitlab.api.packages;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project packages list package files order by. */
@CatalogSchema("operations/getApiV4ProjectsIdPackagesPackageIdPackageFiles/parameters/order_by/schema")
public enum GitLabProjectPackagesListPackageFilesOrderBy {
    ID("id"),
    CREATED_AT("created_at"),
    FILE_NAME("file_name");

    private static final EnumUtils.WireIndex<GitLabProjectPackagesListPackageFilesOrderBy> WIRE_INDEX = EnumUtils.index(
            GitLabProjectPackagesListPackageFilesOrderBy.class,
            GitLabProjectPackagesListPackageFilesOrderBy::wireValue);

    private final String wireValue;

    GitLabProjectPackagesListPackageFilesOrderBy(final String wireValue) {
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
    public static GitLabProjectPackagesListPackageFilesOrderBy fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
