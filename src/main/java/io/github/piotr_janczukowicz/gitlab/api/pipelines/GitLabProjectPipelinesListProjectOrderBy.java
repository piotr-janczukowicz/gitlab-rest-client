package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project pipelines list project order by. */
@CatalogSchema("operations/getApiV4ProjectsIdPipelines/parameters/order_by/schema")
public enum GitLabProjectPipelinesListProjectOrderBy {
    ID("id"),
    STATUS("status"),
    REF("ref"),
    UPDATED_AT("updated_at"),
    USER_ID("user_id");

    private static final EnumUtils.WireIndex<GitLabProjectPipelinesListProjectOrderBy> WIRE_INDEX = EnumUtils.index(
            GitLabProjectPipelinesListProjectOrderBy.class, GitLabProjectPipelinesListProjectOrderBy::wireValue);

    private final String wireValue;

    GitLabProjectPipelinesListProjectOrderBy(final String wireValue) {
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
    public static GitLabProjectPipelinesListProjectOrderBy fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
