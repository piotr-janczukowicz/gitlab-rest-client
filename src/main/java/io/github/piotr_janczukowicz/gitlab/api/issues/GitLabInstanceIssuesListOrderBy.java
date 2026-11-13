package io.github.piotr_janczukowicz.gitlab.api.issues;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab instance issues list order by. */
@CatalogSchema("operations/getApiV4Issues/parameters/order_by/schema")
public enum GitLabInstanceIssuesListOrderBy {
    CREATED_AT("created_at"),
    DUE_DATE("due_date"),
    LABEL_PRIORITY("label_priority"),
    MILESTONE_DUE("milestone_due"),
    POPULARITY("popularity"),
    PRIORITY("priority"),
    RELATIVE_POSITION("relative_position"),
    TITLE("title"),
    UPDATED_AT("updated_at"),
    WEIGHT("weight");

    private static final EnumUtils.WireIndex<GitLabInstanceIssuesListOrderBy> WIRE_INDEX =
            EnumUtils.index(GitLabInstanceIssuesListOrderBy.class, GitLabInstanceIssuesListOrderBy::wireValue);

    private final String wireValue;

    GitLabInstanceIssuesListOrderBy(final String wireValue) {
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
    public static GitLabInstanceIssuesListOrderBy fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
