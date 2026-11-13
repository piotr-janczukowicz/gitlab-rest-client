package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab instance merge requests list order by. */
@CatalogSchema("operations/getApiV4MergeRequests/parameters/order_by/schema")
public enum GitLabInstanceMergeRequestsListOrderBy {
    CREATED_AT("created_at"),
    LABEL_PRIORITY("label_priority"),
    MILESTONE_DUE("milestone_due"),
    POPULARITY("popularity"),
    PRIORITY("priority"),
    TITLE("title"),
    UPDATED_AT("updated_at"),
    MERGED_AT("merged_at");

    private static final EnumUtils.WireIndex<GitLabInstanceMergeRequestsListOrderBy> WIRE_INDEX = EnumUtils.index(
            GitLabInstanceMergeRequestsListOrderBy.class, GitLabInstanceMergeRequestsListOrderBy::wireValue);

    private final String wireValue;

    GitLabInstanceMergeRequestsListOrderBy(final String wireValue) {
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
    public static GitLabInstanceMergeRequestsListOrderBy fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
