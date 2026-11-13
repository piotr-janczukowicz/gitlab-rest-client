package io.github.piotr_janczukowicz.gitlab.api.groupimportandexport;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupImportAndExportListExportRelationsStatusFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenRelationIsNullable() {
        final GitLabGroupGroupImportAndExportListExportRelationsStatusFilterBuilder builder =
                GitLabGroupGroupImportAndExportListExportRelationsStatusFilterBuilder.builder(
                                GitLabGroupGroupImportAndExportListExportRelationsStatusFilterBuilder.builder()
                                        .relation("relation")
                                        .build())
                        .relation(null);

        final GitLabGroupGroupImportAndExportListExportRelationsStatusFilter built = builder.build();

        assertThat(built.relation()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupImportAndExportListExportRelationsStatusFilter value =
                GitLabGroupGroupImportAndExportListExportRelationsStatusFilterBuilder.builder()
                        .relation("relation")
                        .build();

        assertThat(value.relation()).isEqualTo("relation");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupImportAndExportListExportRelationsStatusFilter original =
                GitLabGroupGroupImportAndExportListExportRelationsStatusFilterBuilder.builder()
                        .relation("relation")
                        .build();

        final GitLabGroupGroupImportAndExportListExportRelationsStatusFilter rebuilt =
                GitLabGroupGroupImportAndExportListExportRelationsStatusFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupGroupImportAndExportListExportRelationsStatusFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("relation");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupGroupImportAndExportListExportRelationsStatusFilter empty =
                GitLabGroupGroupImportAndExportListExportRelationsStatusFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupGroupImportAndExportListExportRelationsStatusFilter filter =
                GitLabGroupGroupImportAndExportListExportRelationsStatusFilterBuilder.builder()
                        .relation("relation")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("relation", "relation"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupGroupImportAndExportListExportRelationsStatusFilter filter =
                GitLabGroupGroupImportAndExportListExportRelationsStatusFilterBuilder.builder()
                        .relation("relation")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("relation", "relation"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupGroupImportAndExportListExportRelationsStatusFilter filter =
                GitLabGroupGroupImportAndExportListExportRelationsStatusFilterBuilder.builder()
                        .relation("relation")
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
