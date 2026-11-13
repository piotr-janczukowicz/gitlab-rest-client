package io.github.piotr_janczukowicz.gitlab.api.groupimportandexport;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupImportAndExportGetExportRelationsDownloadFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenBatchedIsNullable() {
        final GitLabGroupGroupImportAndExportGetExportRelationsDownloadFilterBuilder builder =
                GitLabGroupGroupImportAndExportGetExportRelationsDownloadFilterBuilder.builder(
                                GitLabGroupGroupImportAndExportGetExportRelationsDownloadFilterBuilder.builder()
                                        .batched(true)
                                        .batchNumber(1)
                                        .build())
                        .batched(null);

        final GitLabGroupGroupImportAndExportGetExportRelationsDownloadFilter built = builder.build();

        assertThat(built.batched()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBatchNumberIsNullable() {
        final GitLabGroupGroupImportAndExportGetExportRelationsDownloadFilterBuilder builder =
                GitLabGroupGroupImportAndExportGetExportRelationsDownloadFilterBuilder.builder(
                                GitLabGroupGroupImportAndExportGetExportRelationsDownloadFilterBuilder.builder()
                                        .batched(true)
                                        .batchNumber(1)
                                        .build())
                        .batchNumber(null);

        final GitLabGroupGroupImportAndExportGetExportRelationsDownloadFilter built = builder.build();

        assertThat(built.batchNumber()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupImportAndExportGetExportRelationsDownloadFilter value =
                GitLabGroupGroupImportAndExportGetExportRelationsDownloadFilterBuilder.builder()
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
        final GitLabGroupGroupImportAndExportGetExportRelationsDownloadFilter original =
                GitLabGroupGroupImportAndExportGetExportRelationsDownloadFilterBuilder.builder()
                        .batched(true)
                        .batchNumber(1)
                        .build();

        final GitLabGroupGroupImportAndExportGetExportRelationsDownloadFilter rebuilt =
                GitLabGroupGroupImportAndExportGetExportRelationsDownloadFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupGroupImportAndExportGetExportRelationsDownloadFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("batched", "batchNumber");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupGroupImportAndExportGetExportRelationsDownloadFilter empty =
                GitLabGroupGroupImportAndExportGetExportRelationsDownloadFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupGroupImportAndExportGetExportRelationsDownloadFilter filter =
                GitLabGroupGroupImportAndExportGetExportRelationsDownloadFilterBuilder.builder()
                        .batched(true)
                        .batchNumber(1)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("batched", "true"), Map.entry("batch_number", "1"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupGroupImportAndExportGetExportRelationsDownloadFilter filter =
                GitLabGroupGroupImportAndExportGetExportRelationsDownloadFilterBuilder.builder()
                        .batched(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("batched", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupGroupImportAndExportGetExportRelationsDownloadFilter filter =
                GitLabGroupGroupImportAndExportGetExportRelationsDownloadFilterBuilder.builder()
                        .batched(true)
                        .batchNumber(1)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
