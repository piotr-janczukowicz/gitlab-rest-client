package io.github.piotr_janczukowicz.gitlab.api.databasedictionary;

import java.util.List;

public final class DatabasedictionaryCatalogFixtures {

    private DatabasedictionaryCatalogFixtures() {}

    public static GitLabDictionaryTable dictionaryTable() {
        return GitLabDictionaryTableBuilder.builder()
                .tableName("users")
                .featureCategories(List.of("database"))
                .tableSize("small")
                .build();
    }
}
