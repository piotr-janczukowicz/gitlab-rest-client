package io.github.piotr_janczukowicz.gitlab.api.databasedictionary;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDictionaryTableTest {

    @Test
    void constructor_shouldAcceptNull_whenTableNameIsNullable() {
        final GitLabDictionaryTableBuilder builder = GitLabDictionaryTableBuilder.builder(
                        DatabasedictionaryCatalogFixtures.dictionaryTable())
                .tableName(null);

        final GitLabDictionaryTable built = builder.build();

        assertThat(built.tableName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFeatureCategoriesIsNullable() {
        final GitLabDictionaryTableBuilder builder = GitLabDictionaryTableBuilder.builder(
                        DatabasedictionaryCatalogFixtures.dictionaryTable())
                .featureCategories(null);

        final GitLabDictionaryTable built = builder.build();

        assertThat(built.featureCategories()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTableSizeIsNullable() {
        final GitLabDictionaryTableBuilder builder = GitLabDictionaryTableBuilder.builder(
                        DatabasedictionaryCatalogFixtures.dictionaryTable())
                .tableSize(null);

        final GitLabDictionaryTable built = builder.build();

        assertThat(built.tableSize()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDictionaryTable value = DatabasedictionaryCatalogFixtures.dictionaryTable();

        assertSoftly(softly -> {
            softly.assertThat(value.tableName()).isEqualTo("users");
            softly.assertThat(value.featureCategories()).isEqualTo(List.of("database"));
            softly.assertThat(value.tableSize()).isEqualTo("small");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDictionaryTable original = DatabasedictionaryCatalogFixtures.dictionaryTable();

        final GitLabDictionaryTable rebuilt =
                GitLabDictionaryTableBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabDictionaryTable.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("tableName", "featureCategories", "tableSize");
    }
}
