package io.github.piotr_janczukowicz.gitlab.api.databasedictionary;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDatabaseDictionaryListTablesFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenTableSizeIsNullable() {
        final GitLabDatabaseDictionaryListTablesFilterBuilder builder =
                GitLabDatabaseDictionaryListTablesFilterBuilder.builder(
                                GitLabDatabaseDictionaryListTablesFilterBuilder.builder()
                                        .tableSize(GitLabDatabaseDictionaryListTablesTableSize.SMALL)
                                        .build())
                        .tableSize(null);

        final GitLabDatabaseDictionaryListTablesFilter built = builder.build();

        assertThat(built.tableSize()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDatabaseDictionaryListTablesFilter value = GitLabDatabaseDictionaryListTablesFilterBuilder.builder()
                .tableSize(GitLabDatabaseDictionaryListTablesTableSize.SMALL)
                .build();

        assertThat(value.tableSize()).isEqualTo(GitLabDatabaseDictionaryListTablesTableSize.SMALL);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDatabaseDictionaryListTablesFilter original =
                GitLabDatabaseDictionaryListTablesFilterBuilder.builder()
                        .tableSize(GitLabDatabaseDictionaryListTablesTableSize.SMALL)
                        .build();

        final GitLabDatabaseDictionaryListTablesFilter rebuilt =
                GitLabDatabaseDictionaryListTablesFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabDatabaseDictionaryListTablesFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("tableSize");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabDatabaseDictionaryListTablesFilter empty = GitLabDatabaseDictionaryListTablesFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabDatabaseDictionaryListTablesFilter filter =
                GitLabDatabaseDictionaryListTablesFilterBuilder.builder()
                        .tableSize(GitLabDatabaseDictionaryListTablesTableSize.SMALL)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("table_size", "small"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabDatabaseDictionaryListTablesFilter filter =
                GitLabDatabaseDictionaryListTablesFilterBuilder.builder()
                        .tableSize(GitLabDatabaseDictionaryListTablesTableSize.SMALL)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("table_size", "small"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabDatabaseDictionaryListTablesFilter filter =
                GitLabDatabaseDictionaryListTablesFilterBuilder.builder()
                        .tableSize(GitLabDatabaseDictionaryListTablesTableSize.SMALL)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
