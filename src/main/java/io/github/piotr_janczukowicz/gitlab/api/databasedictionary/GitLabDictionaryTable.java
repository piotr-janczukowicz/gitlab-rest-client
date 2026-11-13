package io.github.piotr_janczukowicz.gitlab.api.databasedictionary;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab dictionary table.
 *
 * @param tableName the table name
 * @param featureCategories the feature categories
 * @param tableSize the table size
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesDictionaryTable")
public record GitLabDictionaryTable(
        @Nullable String tableName,
        @Nullable List<String> featureCategories,
        @Nullable String tableSize) {}
