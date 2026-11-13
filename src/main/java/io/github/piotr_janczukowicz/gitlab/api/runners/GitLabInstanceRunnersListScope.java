package io.github.piotr_janczukowicz.gitlab.api.runners;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab instance runners list scope. */
@CatalogSchema("operations/getApiV4Runners/parameters/scope/schema")
public enum GitLabInstanceRunnersListScope {
    SPECIFIC("specific"),
    SHARED("shared"),
    INSTANCE_TYPE("instance_type"),
    GROUP_TYPE("group_type"),
    PROJECT_TYPE("project_type"),
    ACTIVE("active"),
    PAUSED("paused"),
    ONLINE("online"),
    OFFLINE("offline"),
    NEVER_CONTACTED("never_contacted"),
    STALE("stale");

    private static final EnumUtils.WireIndex<GitLabInstanceRunnersListScope> WIRE_INDEX =
            EnumUtils.index(GitLabInstanceRunnersListScope.class, GitLabInstanceRunnersListScope::wireValue);

    private final String wireValue;

    GitLabInstanceRunnersListScope(final String wireValue) {
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
    public static GitLabInstanceRunnersListScope fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
