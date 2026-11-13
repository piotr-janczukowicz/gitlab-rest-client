package io.github.piotr_janczukowicz.gitlab.api.groupandprojectmigrationbydirecttransfer;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab group and project migration by direct transfer list entities status. */
@CatalogSchema("operations/getApiV4BulkImportsEntities/parameters/status/schema")
public enum GitLabGroupAndProjectMigrationByDirectTransferListEntitiesStatus {
    CREATED("created"),
    STARTED("started"),
    FINISHED("finished"),
    TIMEOUT("timeout"),
    FAILED("failed"),
    CANCELED("canceled");

    private static final EnumUtils.WireIndex<GitLabGroupAndProjectMigrationByDirectTransferListEntitiesStatus>
            WIRE_INDEX = EnumUtils.index(
                    GitLabGroupAndProjectMigrationByDirectTransferListEntitiesStatus.class,
                    GitLabGroupAndProjectMigrationByDirectTransferListEntitiesStatus::wireValue);

    private final String wireValue;

    GitLabGroupAndProjectMigrationByDirectTransferListEntitiesStatus(final String wireValue) {
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
    public static GitLabGroupAndProjectMigrationByDirectTransferListEntitiesStatus fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
