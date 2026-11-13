package io.github.piotr_janczukowicz.gitlab.api.branches;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project branches list sort. */
@CatalogSchema("operations/getApiV4ProjectsIdRepositoryBranches/parameters/sort/schema")
public enum GitLabProjectBranchesListSort {
    NAME_ASC("name_asc"),
    UPDATED_ASC("updated_asc"),
    UPDATED_DESC("updated_desc");

    private static final EnumUtils.WireIndex<GitLabProjectBranchesListSort> WIRE_INDEX =
            EnumUtils.index(GitLabProjectBranchesListSort.class, GitLabProjectBranchesListSort::wireValue);

    private final String wireValue;

    GitLabProjectBranchesListSort(final String wireValue) {
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
    public static GitLabProjectBranchesListSort fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
