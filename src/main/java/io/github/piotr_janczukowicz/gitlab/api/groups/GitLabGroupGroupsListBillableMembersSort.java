package io.github.piotr_janczukowicz.gitlab.api.groups;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab group groups list billable members sort. */
@CatalogSchema("operations/getApiV4GroupsIdBillableMembers/parameters/sort/schema")
public enum GitLabGroupGroupsListBillableMembersSort {
    ACCESS_LEVEL_ASC("access_level_asc"),
    ACCESS_LEVEL_DESC("access_level_desc"),
    LAST_JOINED("last_joined"),
    NAME_ASC("name_asc"),
    NAME_DESC("name_desc"),
    OLDEST_JOINED("oldest_joined"),
    OLDEST_SIGN_IN("oldest_sign_in"),
    RECENT_SIGN_IN("recent_sign_in"),
    LAST_ACTIVITY_ON_ASC("last_activity_on_asc"),
    LAST_ACTIVITY_ON_DESC("last_activity_on_desc");

    private static final EnumUtils.WireIndex<GitLabGroupGroupsListBillableMembersSort> WIRE_INDEX = EnumUtils.index(
            GitLabGroupGroupsListBillableMembersSort.class, GitLabGroupGroupsListBillableMembersSort::wireValue);

    private final String wireValue;

    GitLabGroupGroupsListBillableMembersSort(final String wireValue) {
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
    public static GitLabGroupGroupsListBillableMembersSort fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
