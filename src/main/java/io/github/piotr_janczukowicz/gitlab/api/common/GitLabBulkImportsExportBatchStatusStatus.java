package io.github.piotr_janczukowicz.gitlab.api.common;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab bulk imports export batch status status. */
@CatalogSchema("components/schemas/APIEntitiesBulkImportsExportBatchStatus/properties/status")
public enum GitLabBulkImportsExportBatchStatusStatus {
    STARTED("started"),
    FINISHED("finished"),
    FAILED("failed"),
    /** A value this library version does not know. */
    UNRECOGNIZED("unrecognized");

    private static final EnumUtils.WireIndex<GitLabBulkImportsExportBatchStatusStatus> WIRE_INDEX = EnumUtils.index(
            GitLabBulkImportsExportBatchStatusStatus.class, GitLabBulkImportsExportBatchStatusStatus::wireValue);

    private final String wireValue;

    GitLabBulkImportsExportBatchStatusStatus(final String wireValue) {
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
    public static GitLabBulkImportsExportBatchStatusStatus fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
