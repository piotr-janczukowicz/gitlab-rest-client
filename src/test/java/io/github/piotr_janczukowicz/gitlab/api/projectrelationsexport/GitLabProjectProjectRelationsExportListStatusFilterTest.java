package io.github.piotr_janczukowicz.gitlab.api.projectrelationsexport;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectRelationsExportListStatusFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenRelationIsNullable() {
        final GitLabProjectProjectRelationsExportListStatusFilterBuilder builder =
                GitLabProjectProjectRelationsExportListStatusFilterBuilder.builder(
                                GitLabProjectProjectRelationsExportListStatusFilterBuilder.builder()
                                        .relation("relation")
                                        .build())
                        .relation(null);

        final GitLabProjectProjectRelationsExportListStatusFilter built = builder.build();

        assertThat(built.relation()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectRelationsExportListStatusFilter value =
                GitLabProjectProjectRelationsExportListStatusFilterBuilder.builder()
                        .relation("relation")
                        .build();

        assertThat(value.relation()).isEqualTo("relation");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectRelationsExportListStatusFilter original =
                GitLabProjectProjectRelationsExportListStatusFilterBuilder.builder()
                        .relation("relation")
                        .build();

        final GitLabProjectProjectRelationsExportListStatusFilter rebuilt =
                GitLabProjectProjectRelationsExportListStatusFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectRelationsExportListStatusFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("relation");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectProjectRelationsExportListStatusFilter empty =
                GitLabProjectProjectRelationsExportListStatusFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectProjectRelationsExportListStatusFilter filter =
                GitLabProjectProjectRelationsExportListStatusFilterBuilder.builder()
                        .relation("relation")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("relation", "relation"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectProjectRelationsExportListStatusFilter filter =
                GitLabProjectProjectRelationsExportListStatusFilterBuilder.builder()
                        .relation("relation")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("relation", "relation"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectProjectRelationsExportListStatusFilter filter =
                GitLabProjectProjectRelationsExportListStatusFilterBuilder.builder()
                        .relation("relation")
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
