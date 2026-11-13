package io.github.piotr_janczukowicz.gitlab.api.groupandprojectmigrationbydirecttransfer;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab bulk imports entity status. */
@CatalogSchema("components/schemas/APIEntitiesBulkImportsEntity/properties/status")
public enum GitLabBulkImportsEntityStatus {
    CREATED("created"),
    STARTED("started"),
    FINISHED("finished"),
    TIMEOUT("timeout"),
    FAILED("failed"),
    /** A value this library version does not know. */
    UNRECOGNIZED("unrecognized");

    private static final EnumUtils.WireIndex<GitLabBulkImportsEntityStatus> WIRE_INDEX =
            EnumUtils.index(GitLabBulkImportsEntityStatus.class, GitLabBulkImportsEntityStatus::wireValue);

    private final String wireValue;

    GitLabBulkImportsEntityStatus(final String wireValue) {
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
    public static GitLabBulkImportsEntityStatus fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
