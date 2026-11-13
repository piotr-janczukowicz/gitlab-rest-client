package io.github.piotr_janczukowicz.gitlab.api.commits;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project commits list refs type. */
@CatalogSchema("operations/getApiV4ProjectsIdRepositoryCommitsShaRefs/parameters/type/schema")
public enum GitLabProjectCommitsListRefsType {
    BRANCH("branch"),
    TAG("tag"),
    ALL("all");

    private static final EnumUtils.WireIndex<GitLabProjectCommitsListRefsType> WIRE_INDEX =
            EnumUtils.index(GitLabProjectCommitsListRefsType.class, GitLabProjectCommitsListRefsType::wireValue);

    private final String wireValue;

    GitLabProjectCommitsListRefsType(final String wireValue) {
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
    public static GitLabProjectCommitsListRefsType fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
