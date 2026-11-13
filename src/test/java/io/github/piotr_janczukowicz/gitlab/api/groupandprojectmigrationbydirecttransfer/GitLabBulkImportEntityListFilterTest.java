package io.github.piotr_janczukowicz.gitlab.api.groupandprojectmigrationbydirecttransfer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabBulkImportEntityListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabBulkImportEntityListFilterBuilder builder = GitLabBulkImportEntityListFilterBuilder.builder(
                        GitLabBulkImportEntityListFilterBuilder.builder()
                                .status(GitLabBulkImportEntityListStatus.CREATED)
                                .build())
                .status(null);

        final GitLabBulkImportEntityListFilter built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabBulkImportEntityListFilter value = GitLabBulkImportEntityListFilterBuilder.builder()
                .status(GitLabBulkImportEntityListStatus.CREATED)
                .build();

        assertThat(value.status()).isEqualTo(GitLabBulkImportEntityListStatus.CREATED);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabBulkImportEntityListFilter original = GitLabBulkImportEntityListFilterBuilder.builder()
                .status(GitLabBulkImportEntityListStatus.CREATED)
                .build();

        final GitLabBulkImportEntityListFilter rebuilt =
                GitLabBulkImportEntityListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabBulkImportEntityListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("status");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabBulkImportEntityListFilter empty = GitLabBulkImportEntityListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabBulkImportEntityListFilter filter = GitLabBulkImportEntityListFilterBuilder.builder()
                .status(GitLabBulkImportEntityListStatus.CREATED)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("status", "created"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabBulkImportEntityListFilter filter = GitLabBulkImportEntityListFilterBuilder.builder()
                .status(GitLabBulkImportEntityListStatus.CREATED)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("status", "created"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabBulkImportEntityListFilter filter = GitLabBulkImportEntityListFilterBuilder.builder()
                .status(GitLabBulkImportEntityListStatus.CREATED)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
