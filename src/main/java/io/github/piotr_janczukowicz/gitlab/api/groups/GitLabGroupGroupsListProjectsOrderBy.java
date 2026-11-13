package io.github.piotr_janczukowicz.gitlab.api.groups;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab group groups list projects order by. */
@CatalogSchema("operations/getApiV4GroupsIdProjects/parameters/order_by/schema")
public enum GitLabGroupGroupsListProjectsOrderBy {
    ID("id"),
    NAME("name"),
    PATH("path"),
    CREATED_AT("created_at"),
    UPDATED_AT("updated_at"),
    LAST_ACTIVITY_AT("last_activity_at"),
    SIMILARITY("similarity"),
    STAR_COUNT("star_count");

    private static final EnumUtils.WireIndex<GitLabGroupGroupsListProjectsOrderBy> WIRE_INDEX = EnumUtils.index(
            GitLabGroupGroupsListProjectsOrderBy.class, GitLabGroupGroupsListProjectsOrderBy::wireValue);

    private final String wireValue;

    GitLabGroupGroupsListProjectsOrderBy(final String wireValue) {
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
    public static GitLabGroupGroupsListProjectsOrderBy fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
