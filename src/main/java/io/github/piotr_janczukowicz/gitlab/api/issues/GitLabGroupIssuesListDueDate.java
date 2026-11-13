package io.github.piotr_janczukowicz.gitlab.api.issues;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab group issues list due date. */
@CatalogSchema("operations/getApiV4GroupsIdIssues/parameters/due_date/schema")
public enum GitLabGroupIssuesListDueDate {
    EMPTY(""),
    N_0("0"),
    ANY("any"),
    TODAY("today"),
    TOMORROW("tomorrow"),
    OVERDUE("overdue"),
    WEEK("week"),
    MONTH("month"),
    NEXT_MONTH_AND_PREVIOUS_TWO_WEEKS("next_month_and_previous_two_weeks");

    private static final EnumUtils.WireIndex<GitLabGroupIssuesListDueDate> WIRE_INDEX =
            EnumUtils.index(GitLabGroupIssuesListDueDate.class, GitLabGroupIssuesListDueDate::wireValue);

    private final String wireValue;

    GitLabGroupIssuesListDueDate(final String wireValue) {
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
    public static GitLabGroupIssuesListDueDate fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
