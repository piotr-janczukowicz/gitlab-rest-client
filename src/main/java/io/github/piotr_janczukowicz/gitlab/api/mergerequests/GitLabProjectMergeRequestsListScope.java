package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project merge requests list scope. */
@CatalogSchema("operations/getApiV4ProjectsIdMergeRequests/parameters/scope/schema")
public enum GitLabProjectMergeRequestsListScope {
    CREATED_BY_ME_DASHED("created-by-me"),
    ASSIGNED_TO_ME_DASHED("assigned-to-me"),
    CREATED_BY_ME("created_by_me"),
    ASSIGNED_TO_ME("assigned_to_me"),
    REVIEWS_FOR_ME("reviews_for_me"),
    ALL("all");

    private static final EnumUtils.WireIndex<GitLabProjectMergeRequestsListScope> WIRE_INDEX =
            EnumUtils.index(GitLabProjectMergeRequestsListScope.class, GitLabProjectMergeRequestsListScope::wireValue);

    private final String wireValue;

    GitLabProjectMergeRequestsListScope(final String wireValue) {
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
    public static GitLabProjectMergeRequestsListScope fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
