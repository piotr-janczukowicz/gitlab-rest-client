package io.github.piotr_janczukowicz.gitlab.api.projecttemplates;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project project templates get type. */
@CatalogSchema("operations/getApiV4ProjectsIdTemplatesTypeName/parameters/type/schema")
public enum GitLabProjectProjectTemplatesGetType {
    DOCKERFILES("dockerfiles"),
    GITIGNORES("gitignores"),
    GITLAB_CI_YMLS("gitlab_ci_ymls"),
    LICENSES("licenses"),
    ISSUES("issues"),
    MERGE_REQUESTS("merge_requests");

    private static final EnumUtils.WireIndex<GitLabProjectProjectTemplatesGetType> WIRE_INDEX = EnumUtils.index(
            GitLabProjectProjectTemplatesGetType.class, GitLabProjectProjectTemplatesGetType::wireValue);

    private final String wireValue;

    GitLabProjectProjectTemplatesGetType(final String wireValue) {
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
    public static GitLabProjectProjectTemplatesGetType fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
