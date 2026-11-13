package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabTestReportSummaryEntityTest {

    @Test
    void constructor_shouldAcceptNull_whenTotalIsNullable() {
        final GitLabTestReportSummaryEntityBuilder builder = GitLabTestReportSummaryEntityBuilder.builder(
                        PipelinesCatalogFixtures.testReportSummaryEntity())
                .total(null);

        final GitLabTestReportSummaryEntity built = builder.build();

        assertThat(built.total()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTestSuitesIsNullable() {
        final GitLabTestReportSummaryEntityBuilder builder = GitLabTestReportSummaryEntityBuilder.builder(
                        PipelinesCatalogFixtures.testReportSummaryEntity())
                .testSuites(null);

        final GitLabTestReportSummaryEntity built = builder.build();

        assertThat(built.testSuites()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabTestReportSummaryEntity value = PipelinesCatalogFixtures.testReportSummaryEntity();

        assertSoftly(softly -> {
            softly.assertThat(value.total()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.testSuites()).isEqualTo(List.of(PipelinesCatalogFixtures.testSuiteSummaryEntity()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabTestReportSummaryEntity original = PipelinesCatalogFixtures.testReportSummaryEntity();

        final GitLabTestReportSummaryEntity rebuilt =
                GitLabTestReportSummaryEntityBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabTestReportSummaryEntity.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("total", "testSuites");
    }
}
