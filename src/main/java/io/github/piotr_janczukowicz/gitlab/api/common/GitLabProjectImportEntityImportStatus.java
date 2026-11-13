package io.github.piotr_janczukowicz.gitlab.api.common;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project import entity import status. */
@CatalogSchema("components/schemas/ProjectImportEntity/properties/import_status")
public enum GitLabProjectImportEntityImportStatus {
    SCHEDULED("scheduled"),
    STARTED("started"),
    FINISHED("finished"),
    FAILED("failed"),
    CANCELED("canceled"),
    /** A value this library version does not know. */
    UNRECOGNIZED("unrecognized");

    private static final EnumUtils.WireIndex<GitLabProjectImportEntityImportStatus> WIRE_INDEX = EnumUtils.index(
            GitLabProjectImportEntityImportStatus.class, GitLabProjectImportEntityImportStatus::wireValue);

    private final String wireValue;

    GitLabProjectImportEntityImportStatus(final String wireValue) {
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
    public static GitLabProjectImportEntityImportStatus fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
