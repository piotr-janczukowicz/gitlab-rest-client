package io.github.piotr_janczukowicz.gitlab.api.runners;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab instance runners list all type. */
@CatalogSchema("operations/getApiV4RunnersAll/parameters/type/schema")
public enum GitLabInstanceRunnersListAllType {
    INSTANCE_TYPE("instance_type"),
    GROUP_TYPE("group_type"),
    PROJECT_TYPE("project_type");

    private static final EnumUtils.WireIndex<GitLabInstanceRunnersListAllType> WIRE_INDEX =
            EnumUtils.index(GitLabInstanceRunnersListAllType.class, GitLabInstanceRunnersListAllType::wireValue);

    private final String wireValue;

    GitLabInstanceRunnersListAllType(final String wireValue) {
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
    public static GitLabInstanceRunnersListAllType fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
