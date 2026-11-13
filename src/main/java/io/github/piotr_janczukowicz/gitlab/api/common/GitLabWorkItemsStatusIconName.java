package io.github.piotr_janczukowicz.gitlab.api.common;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab work items status icon name. */
@CatalogSchema("components/schemas/APIEntitiesWorkItemsStatus/properties/icon_name")
public enum GitLabWorkItemsStatusIconName {
    STATUS_NEUTRAL("status-neutral"),
    STATUS_WAITING("status-waiting"),
    STATUS_RUNNING("status-running"),
    STATUS_SUCCESS("status-success"),
    STATUS_CANCELLED("status-cancelled"),
    /** A value this library version does not know. */
    UNRECOGNIZED("unrecognized");

    private static final EnumUtils.WireIndex<GitLabWorkItemsStatusIconName> WIRE_INDEX =
            EnumUtils.index(GitLabWorkItemsStatusIconName.class, GitLabWorkItemsStatusIconName::wireValue);

    private final String wireValue;

    GitLabWorkItemsStatusIconName(final String wireValue) {
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
     */
    @JsonCreator
    public static GitLabWorkItemsStatusIconName fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
