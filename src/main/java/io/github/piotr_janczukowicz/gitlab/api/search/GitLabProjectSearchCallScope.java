package io.github.piotr_janczukowicz.gitlab.api.search;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project search call scope. */
@CatalogSchema("operations/getApiV4ProjectsIdDashSearch/parameters/scope/schema")
public enum GitLabProjectSearchCallScope {
    ISSUES("issues"),
    WORK_ITEMS("work_items"),
    MERGE_REQUESTS("merge_requests"),
    MILESTONES("milestones"),
    NOTES("notes"),
    WIKI_BLOBS("wiki_blobs"),
    COMMITS("commits"),
    BLOBS("blobs"),
    USERS("users");

    private static final EnumUtils.WireIndex<GitLabProjectSearchCallScope> WIRE_INDEX =
            EnumUtils.index(GitLabProjectSearchCallScope.class, GitLabProjectSearchCallScope::wireValue);

    private final String wireValue;

    GitLabProjectSearchCallScope(final String wireValue) {
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
    public static GitLabProjectSearchCallScope fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
