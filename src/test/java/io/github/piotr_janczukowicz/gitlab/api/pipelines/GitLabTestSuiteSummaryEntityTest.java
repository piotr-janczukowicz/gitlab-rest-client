package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabTestSuiteSummaryEntityTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabTestSuiteSummaryEntityBuilder builder = GitLabTestSuiteSummaryEntityBuilder.builder(
                        PipelinesCatalogFixtures.testSuiteSummaryEntity())
                .name(null);

        final GitLabTestSuiteSummaryEntity built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTotalTimeIsNullable() {
        final GitLabTestSuiteSummaryEntityBuilder builder = GitLabTestSuiteSummaryEntityBuilder.builder(
                        PipelinesCatalogFixtures.testSuiteSummaryEntity())
                .totalTime(null);

        final GitLabTestSuiteSummaryEntity built = builder.build();

        assertThat(built.totalTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTotalCountIsNullable() {
        final GitLabTestSuiteSummaryEntityBuilder builder = GitLabTestSuiteSummaryEntityBuilder.builder(
                        PipelinesCatalogFixtures.testSuiteSummaryEntity())
                .totalCount(null);

        final GitLabTestSuiteSummaryEntity built = builder.build();

        assertThat(built.totalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSuccessCountIsNullable() {
        final GitLabTestSuiteSummaryEntityBuilder builder = GitLabTestSuiteSummaryEntityBuilder.builder(
                        PipelinesCatalogFixtures.testSuiteSummaryEntity())
                .successCount(null);

        final GitLabTestSuiteSummaryEntity built = builder.build();

        assertThat(built.successCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFailedCountIsNullable() {
        final GitLabTestSuiteSummaryEntityBuilder builder = GitLabTestSuiteSummaryEntityBuilder.builder(
                        PipelinesCatalogFixtures.testSuiteSummaryEntity())
                .failedCount(null);

        final GitLabTestSuiteSummaryEntity built = builder.build();

        assertThat(built.failedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSkippedCountIsNullable() {
        final GitLabTestSuiteSummaryEntityBuilder builder = GitLabTestSuiteSummaryEntityBuilder.builder(
                        PipelinesCatalogFixtures.testSuiteSummaryEntity())
                .skippedCount(null);

        final GitLabTestSuiteSummaryEntity built = builder.build();

        assertThat(built.skippedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenErrorCountIsNullable() {
        final GitLabTestSuiteSummaryEntityBuilder builder = GitLabTestSuiteSummaryEntityBuilder.builder(
                        PipelinesCatalogFixtures.testSuiteSummaryEntity())
                .errorCount(null);

        final GitLabTestSuiteSummaryEntity built = builder.build();

        assertThat(built.errorCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSuiteErrorIsNullable() {
        final GitLabTestSuiteSummaryEntityBuilder builder = GitLabTestSuiteSummaryEntityBuilder.builder(
                        PipelinesCatalogFixtures.testSuiteSummaryEntity())
                .suiteError(null);

        final GitLabTestSuiteSummaryEntity built = builder.build();

        assertThat(built.suiteError()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTestCasesIsNullable() {
        final GitLabTestSuiteSummaryEntityBuilder builder = GitLabTestSuiteSummaryEntityBuilder.builder(
                        PipelinesCatalogFixtures.testSuiteSummaryEntity())
                .testCases(null);

        final GitLabTestSuiteSummaryEntity built = builder.build();

        assertThat(built.testCases()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBuildIdsIsNullable() {
        final GitLabTestSuiteSummaryEntityBuilder builder = GitLabTestSuiteSummaryEntityBuilder.builder(
                        PipelinesCatalogFixtures.testSuiteSummaryEntity())
                .buildIds(null);

        final GitLabTestSuiteSummaryEntity built = builder.build();

        assertThat(built.buildIds()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabTestSuiteSummaryEntity value = PipelinesCatalogFixtures.testSuiteSummaryEntity();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("test");
            softly.assertThat(value.totalTime()).isEqualTo(1);
            softly.assertThat(value.totalCount()).isEqualTo(1);
            softly.assertThat(value.successCount()).isEqualTo(1);
            softly.assertThat(value.failedCount()).isEqualTo(1);
            softly.assertThat(value.skippedCount()).isEqualTo(1);
            softly.assertThat(value.errorCount()).isEqualTo(1);
            softly.assertThat(value.suiteError()).isEqualTo("JUnit XML parsing failed: 1:1: FATAL: Document is empty");
            softly.assertThat(value.testCases()).isEqualTo(List.of(PipelinesCatalogFixtures.testCaseEntity()));
            softly.assertThat(value.buildIds()).isEqualTo(List.of(1L));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabTestSuiteSummaryEntity original = PipelinesCatalogFixtures.testSuiteSummaryEntity();

        final GitLabTestSuiteSummaryEntity rebuilt =
                GitLabTestSuiteSummaryEntityBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabTestSuiteSummaryEntity.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "name",
                        "totalTime",
                        "totalCount",
                        "successCount",
                        "failedCount",
                        "skippedCount",
                        "errorCount",
                        "suiteError",
                        "testCases",
                        "buildIds");
    }
}
