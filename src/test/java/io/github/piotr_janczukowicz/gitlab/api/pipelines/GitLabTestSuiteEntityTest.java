package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabTestSuiteEntityTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabTestSuiteEntityBuilder builder = GitLabTestSuiteEntityBuilder.builder(
                        PipelinesCatalogFixtures.testSuiteEntity())
                .name(null);

        final GitLabTestSuiteEntity built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTotalTimeIsNullable() {
        final GitLabTestSuiteEntityBuilder builder = GitLabTestSuiteEntityBuilder.builder(
                        PipelinesCatalogFixtures.testSuiteEntity())
                .totalTime(null);

        final GitLabTestSuiteEntity built = builder.build();

        assertThat(built.totalTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTotalCountIsNullable() {
        final GitLabTestSuiteEntityBuilder builder = GitLabTestSuiteEntityBuilder.builder(
                        PipelinesCatalogFixtures.testSuiteEntity())
                .totalCount(null);

        final GitLabTestSuiteEntity built = builder.build();

        assertThat(built.totalCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSuccessCountIsNullable() {
        final GitLabTestSuiteEntityBuilder builder = GitLabTestSuiteEntityBuilder.builder(
                        PipelinesCatalogFixtures.testSuiteEntity())
                .successCount(null);

        final GitLabTestSuiteEntity built = builder.build();

        assertThat(built.successCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFailedCountIsNullable() {
        final GitLabTestSuiteEntityBuilder builder = GitLabTestSuiteEntityBuilder.builder(
                        PipelinesCatalogFixtures.testSuiteEntity())
                .failedCount(null);

        final GitLabTestSuiteEntity built = builder.build();

        assertThat(built.failedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSkippedCountIsNullable() {
        final GitLabTestSuiteEntityBuilder builder = GitLabTestSuiteEntityBuilder.builder(
                        PipelinesCatalogFixtures.testSuiteEntity())
                .skippedCount(null);

        final GitLabTestSuiteEntity built = builder.build();

        assertThat(built.skippedCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenErrorCountIsNullable() {
        final GitLabTestSuiteEntityBuilder builder = GitLabTestSuiteEntityBuilder.builder(
                        PipelinesCatalogFixtures.testSuiteEntity())
                .errorCount(null);

        final GitLabTestSuiteEntity built = builder.build();

        assertThat(built.errorCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSuiteErrorIsNullable() {
        final GitLabTestSuiteEntityBuilder builder = GitLabTestSuiteEntityBuilder.builder(
                        PipelinesCatalogFixtures.testSuiteEntity())
                .suiteError(null);

        final GitLabTestSuiteEntity built = builder.build();

        assertThat(built.suiteError()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTestCasesIsNullable() {
        final GitLabTestSuiteEntityBuilder builder = GitLabTestSuiteEntityBuilder.builder(
                        PipelinesCatalogFixtures.testSuiteEntity())
                .testCases(null);

        final GitLabTestSuiteEntity built = builder.build();

        assertThat(built.testCases()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabTestSuiteEntity value = PipelinesCatalogFixtures.testSuiteEntity();

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
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabTestSuiteEntity original = PipelinesCatalogFixtures.testSuiteEntity();

        final GitLabTestSuiteEntity rebuilt =
                GitLabTestSuiteEntityBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabTestSuiteEntity.class.getRecordComponents())
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
                        "testCases");
    }
}
