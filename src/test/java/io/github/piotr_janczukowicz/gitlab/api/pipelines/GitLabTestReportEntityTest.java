package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabTestReportEntityTest {

    @Test
    void constructor_shouldAcceptNull_whenTotalTimeIsNullable() {
        final GitLabTestReportEntityBuilder builder = GitLabTestReportEntityBuilder.builder(
                        PipelinesCatalogFixtures.testReportEntity())
                .totalTime(null);

        final GitLabTestReportEntity built = builder.build();

        assertThat(built.totalTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTotalCountIsNullable() {
        final GitLabTestReportEntityBuilder builder = GitLabTestReportEntityBuilder.builder(
                        PipelinesCatalogFixtures.testReportEntity())
                .totalCount(null);

        final GitLabTestReportEntity built = builder.build();

        assertThat(built.totalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSuccessCountIsNullable() {
        final GitLabTestReportEntityBuilder builder = GitLabTestReportEntityBuilder.builder(
                        PipelinesCatalogFixtures.testReportEntity())
                .successCount(null);

        final GitLabTestReportEntity built = builder.build();

        assertThat(built.successCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFailedCountIsNullable() {
        final GitLabTestReportEntityBuilder builder = GitLabTestReportEntityBuilder.builder(
                        PipelinesCatalogFixtures.testReportEntity())
                .failedCount(null);

        final GitLabTestReportEntity built = builder.build();

        assertThat(built.failedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSkippedCountIsNullable() {
        final GitLabTestReportEntityBuilder builder = GitLabTestReportEntityBuilder.builder(
                        PipelinesCatalogFixtures.testReportEntity())
                .skippedCount(null);

        final GitLabTestReportEntity built = builder.build();

        assertThat(built.skippedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenErrorCountIsNullable() {
        final GitLabTestReportEntityBuilder builder = GitLabTestReportEntityBuilder.builder(
                        PipelinesCatalogFixtures.testReportEntity())
                .errorCount(null);

        final GitLabTestReportEntity built = builder.build();

        assertThat(built.errorCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTestSuitesIsNullable() {
        final GitLabTestReportEntityBuilder builder = GitLabTestReportEntityBuilder.builder(
                        PipelinesCatalogFixtures.testReportEntity())
                .testSuites(null);

        final GitLabTestReportEntity built = builder.build();

        assertThat(built.testSuites()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabTestReportEntity value = PipelinesCatalogFixtures.testReportEntity();

        assertSoftly(softly -> {
            softly.assertThat(value.totalTime()).isEqualTo(1);
            softly.assertThat(value.totalCount()).isEqualTo(1);
            softly.assertThat(value.successCount()).isEqualTo(1);
            softly.assertThat(value.failedCount()).isEqualTo(1);
            softly.assertThat(value.skippedCount()).isEqualTo(1);
            softly.assertThat(value.errorCount()).isEqualTo(1);
            softly.assertThat(value.testSuites()).isEqualTo(List.of(PipelinesCatalogFixtures.testSuiteEntity()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabTestReportEntity original = PipelinesCatalogFixtures.testReportEntity();

        final GitLabTestReportEntity rebuilt =
                GitLabTestReportEntityBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabTestReportEntity.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "totalTime",
                        "totalCount",
                        "successCount",
                        "failedCount",
                        "skippedCount",
                        "errorCount",
                        "testSuites");
    }
}
