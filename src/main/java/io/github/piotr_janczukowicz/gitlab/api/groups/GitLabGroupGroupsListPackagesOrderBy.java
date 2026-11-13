package io.github.piotr_janczukowicz.gitlab.api.groups;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab group groups list packages order by. */
@CatalogSchema("operations/getApiV4GroupsIdPackages/parameters/order_by/schema")
public enum GitLabGroupGroupsListPackagesOrderBy {
    CREATED_AT("created_at"),
    NAME("name"),
    VERSION("version"),
    TYPE("type"),
    PROJECT_PATH("project_path");

    private static final EnumUtils.WireIndex<GitLabGroupGroupsListPackagesOrderBy> WIRE_INDEX = EnumUtils.index(
            GitLabGroupGroupsListPackagesOrderBy.class, GitLabGroupGroupsListPackagesOrderBy::wireValue);

    private final String wireValue;

    GitLabGroupGroupsListPackagesOrderBy(final String wireValue) {
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
    public static GitLabGroupGroupsListPackagesOrderBy fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
