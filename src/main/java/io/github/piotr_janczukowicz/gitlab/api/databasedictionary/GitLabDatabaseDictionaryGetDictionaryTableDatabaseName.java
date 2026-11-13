package io.github.piotr_janczukowicz.gitlab.api.databasedictionary;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab database dictionary get dictionary table database name. */
@CatalogSchema("operations/getApiV4AdminDatabasesDatabaseNameDictionaryTablesTableName/parameters/database_name/schema")
public enum GitLabDatabaseDictionaryGetDictionaryTableDatabaseName {
    MAIN("main"),
    CI("ci");

    private static final EnumUtils.WireIndex<GitLabDatabaseDictionaryGetDictionaryTableDatabaseName> WIRE_INDEX =
            EnumUtils.index(
                    GitLabDatabaseDictionaryGetDictionaryTableDatabaseName.class,
                    GitLabDatabaseDictionaryGetDictionaryTableDatabaseName::wireValue);

    private final String wireValue;

    GitLabDatabaseDictionaryGetDictionaryTableDatabaseName(final String wireValue) {
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
    public static GitLabDatabaseDictionaryGetDictionaryTableDatabaseName fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
