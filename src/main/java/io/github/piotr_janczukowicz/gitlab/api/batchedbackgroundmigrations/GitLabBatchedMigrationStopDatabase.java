package io.github.piotr_janczukowicz.gitlab.api.batchedbackgroundmigrations;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab batched migration stop database. */
@CatalogSchema("operations/putApiV4AdminBatchedBackgroundOperationsIdStop/requestBody/properties/database")
public enum GitLabBatchedMigrationStopDatabase {
    MAIN("main"),
    CI("ci"),
    SEC("sec"),
    MR_DIFF("mr_diff"),
    EMBEDDING("embedding"),
    GEO("geo");

    private static final EnumUtils.WireIndex<GitLabBatchedMigrationStopDatabase> WIRE_INDEX =
            EnumUtils.index(GitLabBatchedMigrationStopDatabase.class, GitLabBatchedMigrationStopDatabase::wireValue);

    private final String wireValue;

    GitLabBatchedMigrationStopDatabase(final String wireValue) {
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
    public static GitLabBatchedMigrationStopDatabase fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
