package io.github.piotr_janczukowicz.gitlab.api.databasemigrations;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab database migrations create database. */
@CatalogSchema("operations/postApiV4AdminMigrationsTimestampMark/requestBody/properties/database")
public enum GitLabDatabaseMigrationsCreateDatabase {
    MAIN("main"),
    CI("ci"),
    SEC("sec"),
    MR_DIFF("mr_diff"),
    EMBEDDING("embedding"),
    GEO("geo");

    private static final EnumUtils.WireIndex<GitLabDatabaseMigrationsCreateDatabase> WIRE_INDEX = EnumUtils.index(
            GitLabDatabaseMigrationsCreateDatabase.class, GitLabDatabaseMigrationsCreateDatabase::wireValue);

    private final String wireValue;

    GitLabDatabaseMigrationsCreateDatabase(final String wireValue) {
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
    public static GitLabDatabaseMigrationsCreateDatabase fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
