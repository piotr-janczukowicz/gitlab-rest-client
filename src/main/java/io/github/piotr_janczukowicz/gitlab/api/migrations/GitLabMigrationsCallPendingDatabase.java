package io.github.piotr_janczukowicz.gitlab.api.migrations;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab migrations call pending database. */
@CatalogSchema("operations/getApiV4AdminMigrationsPending/parameters/database/schema")
public enum GitLabMigrationsCallPendingDatabase {
    MAIN("main"),
    CI("ci"),
    SEC("sec"),
    MR_DIFF("mr_diff"),
    EMBEDDING("embedding"),
    GEO("geo");

    private static final EnumUtils.WireIndex<GitLabMigrationsCallPendingDatabase> WIRE_INDEX =
            EnumUtils.index(GitLabMigrationsCallPendingDatabase.class, GitLabMigrationsCallPendingDatabase::wireValue);

    private final String wireValue;

    GitLabMigrationsCallPendingDatabase(final String wireValue) {
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
    public static GitLabMigrationsCallPendingDatabase fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
