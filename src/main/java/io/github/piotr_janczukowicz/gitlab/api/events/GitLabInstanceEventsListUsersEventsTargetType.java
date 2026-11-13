package io.github.piotr_janczukowicz.gitlab.api.events;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab instance events list users events target type. */
@CatalogSchema("operations/getApiV4UsersIdEvents/parameters/target_type/schema")
public enum GitLabInstanceEventsListUsersEventsTargetType {
    ISSUE("issue"),
    MILESTONE("milestone"),
    MERGE_REQUEST("merge_request"),
    NOTE("note"),
    PROJECT("project"),
    SNIPPET("snippet"),
    USER("user"),
    WIKI("wiki"),
    DESIGN("design");

    private static final EnumUtils.WireIndex<GitLabInstanceEventsListUsersEventsTargetType> WIRE_INDEX =
            EnumUtils.index(
                    GitLabInstanceEventsListUsersEventsTargetType.class,
                    GitLabInstanceEventsListUsersEventsTargetType::wireValue);

    private final String wireValue;

    GitLabInstanceEventsListUsersEventsTargetType(final String wireValue) {
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
    public static GitLabInstanceEventsListUsersEventsTargetType fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
