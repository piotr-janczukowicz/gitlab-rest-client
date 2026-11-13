package io.github.piotr_janczukowicz.gitlab.api.search;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab instance search call scope. */
@CatalogSchema("operations/getApiV4Search/parameters/scope/schema")
public enum GitLabInstanceSearchCallScope {
    WIKI_BLOBS("wiki_blobs"),
    BLOBS("blobs"),
    COMMITS("commits"),
    NOTES("notes"),
    PROJECTS("projects"),
    GROUPS("groups"),
    ISSUES("issues"),
    WORK_ITEMS("work_items"),
    MERGE_REQUESTS("merge_requests"),
    MILESTONES("milestones"),
    SNIPPET_TITLES("snippet_titles"),
    USERS("users");

    private static final EnumUtils.WireIndex<GitLabInstanceSearchCallScope> WIRE_INDEX =
            EnumUtils.index(GitLabInstanceSearchCallScope.class, GitLabInstanceSearchCallScope::wireValue);

    private final String wireValue;

    GitLabInstanceSearchCallScope(final String wireValue) {
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
    public static GitLabInstanceSearchCallScope fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
