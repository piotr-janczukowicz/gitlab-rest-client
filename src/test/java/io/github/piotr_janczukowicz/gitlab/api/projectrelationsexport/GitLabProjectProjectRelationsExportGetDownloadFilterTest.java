package io.github.piotr_janczukowicz.gitlab.api.projectrelationsexport;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectRelationsExportGetDownloadFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenBatchedIsNullable() {
        final GitLabProjectProjectRelationsExportGetDownloadFilterBuilder builder =
                GitLabProjectProjectRelationsExportGetDownloadFilterBuilder.builder(
                                GitLabProjectProjectRelationsExportGetDownloadFilterBuilder.builder()
                                        .batched(true)
                                        .batchNumber(1)
                                        .build())
                        .batched(null);

        final GitLabProjectProjectRelationsExportGetDownloadFilter built = builder.build();

        assertThat(built.batched()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBatchNumberIsNullable() {
        final GitLabProjectProjectRelationsExportGetDownloadFilterBuilder builder =
                GitLabProjectProjectRelationsExportGetDownloadFilterBuilder.builder(
                                GitLabProjectProjectRelationsExportGetDownloadFilterBuilder.builder()
                                        .batched(true)
                                        .batchNumber(1)
                                        .build())
                        .batchNumber(null);

        final GitLabProjectProjectRelationsExportGetDownloadFilter built = builder.build();

        assertThat(built.batchNumber()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectRelationsExportGetDownloadFilter value =
                GitLabProjectProjectRelationsExportGetDownloadFilterBuilder.builder()
                        .batched(true)
                        .batchNumber(1)
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.batched()).isEqualTo(true);
            softly.assertThat(value.batchNumber()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectRelationsExportGetDownloadFilter original =
                GitLabProjectProjectRelationsExportGetDownloadFilterBuilder.builder()
                        .batched(true)
                        .batchNumber(1)
                        .build();

        final GitLabProjectProjectRelationsExportGetDownloadFilter rebuilt =
                GitLabProjectProjectRelationsExportGetDownloadFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectRelationsExportGetDownloadFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("batched", "batchNumber");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectProjectRelationsExportGetDownloadFilter empty =
                GitLabProjectProjectRelationsExportGetDownloadFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectProjectRelationsExportGetDownloadFilter filter =
                GitLabProjectProjectRelationsExportGetDownloadFilterBuilder.builder()
                        .batched(true)
                        .batchNumber(1)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("batched", "true"), Map.entry("batch_number", "1"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectProjectRelationsExportGetDownloadFilter filter =
                GitLabProjectProjectRelationsExportGetDownloadFilterBuilder.builder()
                        .batched(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("batched", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectProjectRelationsExportGetDownloadFilter filter =
                GitLabProjectProjectRelationsExportGetDownloadFilterBuilder.builder()
                        .batched(true)
                        .batchNumber(1)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
