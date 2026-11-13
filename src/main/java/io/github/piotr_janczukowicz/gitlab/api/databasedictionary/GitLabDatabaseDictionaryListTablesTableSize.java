package io.github.piotr_janczukowicz.gitlab.api.databasedictionary;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab database dictionary list tables table size. */
@CatalogSchema("operations/getApiV4DatabasesDatabaseNameDictionaryTables/parameters/table_size/schema")
public enum GitLabDatabaseDictionaryListTablesTableSize {
    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large"),
    OVER_LIMIT("over_limit");

    private static final EnumUtils.WireIndex<GitLabDatabaseDictionaryListTablesTableSize> WIRE_INDEX = EnumUtils.index(
            GitLabDatabaseDictionaryListTablesTableSize.class, GitLabDatabaseDictionaryListTablesTableSize::wireValue);

    private final String wireValue;

    GitLabDatabaseDictionaryListTablesTableSize(final String wireValue) {
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
    public static GitLabDatabaseDictionaryListTablesTableSize fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
