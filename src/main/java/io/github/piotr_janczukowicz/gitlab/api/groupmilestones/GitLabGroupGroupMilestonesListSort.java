package io.github.piotr_janczukowicz.gitlab.api.groupmilestones;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab group group milestones list sort. */
@CatalogSchema("operations/getApiV4GroupsIdMilestones/parameters/sort/schema")
public enum GitLabGroupGroupMilestonesListSort {
    DUE_DATE_ASC("due_date_asc"),
    DUE_DATE_DESC("due_date_desc"),
    START_DATE_ASC("start_date_asc"),
    START_DATE_DESC("start_date_desc"),
    NAME_ASC("name_asc"),
    NAME_DESC("name_desc"),
    CREATED_ASC("created_asc"),
    CREATED_DESC("created_desc"),
    UPDATED_ASC("updated_asc"),
    UPDATED_DESC("updated_desc");

    private static final EnumUtils.WireIndex<GitLabGroupGroupMilestonesListSort> WIRE_INDEX =
            EnumUtils.index(GitLabGroupGroupMilestonesListSort.class, GitLabGroupGroupMilestonesListSort::wireValue);

    private final String wireValue;

    GitLabGroupGroupMilestonesListSort(final String wireValue) {
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
    public static GitLabGroupGroupMilestonesListSort fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
