package io.github.piotr_janczukowicz.gitlab.api.packages;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project packages list order by. */
@CatalogSchema("operations/getApiV4ProjectsIdPackages/parameters/order_by/schema")
public enum GitLabProjectPackagesListOrderBy {
    CREATED_AT("created_at"),
    NAME("name"),
    VERSION("version"),
    TYPE("type");

    private static final EnumUtils.WireIndex<GitLabProjectPackagesListOrderBy> WIRE_INDEX =
            EnumUtils.index(GitLabProjectPackagesListOrderBy.class, GitLabProjectPackagesListOrderBy::wireValue);

    private final String wireValue;

    GitLabProjectPackagesListOrderBy(final String wireValue) {
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
    public static GitLabProjectPackagesListOrderBy fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
