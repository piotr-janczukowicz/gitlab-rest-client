package io.github.piotr_janczukowicz.gitlab.api.offlinetransfers;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab import offline export status. */
@CatalogSchema("components/schemas/APIEntitiesImportOfflineExport/properties/status")
public enum GitLabImportOfflineExportStatus {
    CREATED("created"),
    STARTED("started"),
    FINISHED("finished"),
    FAILED("failed"),
    /** A value this library version does not know. */
    UNRECOGNIZED("unrecognized");

    private static final EnumUtils.WireIndex<GitLabImportOfflineExportStatus> WIRE_INDEX =
            EnumUtils.index(GitLabImportOfflineExportStatus.class, GitLabImportOfflineExportStatus::wireValue);

    private final String wireValue;

    GitLabImportOfflineExportStatus(final String wireValue) {
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
    public static GitLabImportOfflineExportStatus fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
