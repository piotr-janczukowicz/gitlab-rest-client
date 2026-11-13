package io.github.piotr_janczukowicz.gitlab.api.projectforks;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project project forks list order by. */
@CatalogSchema("operations/getApiV4ProjectsIdForks/parameters/order_by/schema")
public enum GitLabProjectProjectForksListOrderBy {
    ID("id"),
    NAME("name"),
    PATH("path"),
    CREATED_AT("created_at"),
    UPDATED_AT("updated_at"),
    LAST_ACTIVITY_AT("last_activity_at"),
    SIMILARITY("similarity"),
    STAR_COUNT("star_count"),
    STORAGE_SIZE("storage_size"),
    REPOSITORY_SIZE("repository_size"),
    WIKI_SIZE("wiki_size"),
    PACKAGES_SIZE("packages_size");

    private static final EnumUtils.WireIndex<GitLabProjectProjectForksListOrderBy> WIRE_INDEX = EnumUtils.index(
            GitLabProjectProjectForksListOrderBy.class, GitLabProjectProjectForksListOrderBy::wireValue);

    private final String wireValue;

    GitLabProjectProjectForksListOrderBy(final String wireValue) {
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
    public static GitLabProjectProjectForksListOrderBy fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
