package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabTestCaseEntityTest {

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabTestCaseEntityBuilder builder = GitLabTestCaseEntityBuilder.builder(
                        PipelinesCatalogFixtures.testCaseEntity())
                .status(null);

        final GitLabTestCaseEntity built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabTestCaseEntityBuilder builder = GitLabTestCaseEntityBuilder.builder(
                        PipelinesCatalogFixtures.testCaseEntity())
                .name(null);

        final GitLabTestCaseEntity built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClassnameIsNullable() {
        final GitLabTestCaseEntityBuilder builder = GitLabTestCaseEntityBuilder.builder(
                        PipelinesCatalogFixtures.testCaseEntity())
                .classname(null);

        final GitLabTestCaseEntity built = builder.build();

        assertThat(built.classname()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFileIsNullable() {
        final GitLabTestCaseEntityBuilder builder = GitLabTestCaseEntityBuilder.builder(
                        PipelinesCatalogFixtures.testCaseEntity())
                .file(null);

        final GitLabTestCaseEntity built = builder.build();

        assertThat(built.file()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExecutionTimeIsNullable() {
        final GitLabTestCaseEntityBuilder builder = GitLabTestCaseEntityBuilder.builder(
                        PipelinesCatalogFixtures.testCaseEntity())
                .executionTime(null);

        final GitLabTestCaseEntity built = builder.build();

        assertThat(built.executionTime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSystemOutputIsNullable() {
        final GitLabTestCaseEntityBuilder builder = GitLabTestCaseEntityBuilder.builder(
                        PipelinesCatalogFixtures.testCaseEntity())
                .systemOutput(null);

        final GitLabTestCaseEntity built = builder.build();

        assertThat(built.systemOutput()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStackTraceIsNullable() {
        final GitLabTestCaseEntityBuilder builder = GitLabTestCaseEntityBuilder.builder(
                        PipelinesCatalogFixtures.testCaseEntity())
                .stackTrace(null);

        final GitLabTestCaseEntity built = builder.build();

        assertThat(built.stackTrace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRecentFailuresIsNullable() {
        final GitLabTestCaseEntityBuilder builder = GitLabTestCaseEntityBuilder.builder(
                        PipelinesCatalogFixtures.testCaseEntity())
                .recentFailures(null);

        final GitLabTestCaseEntity built = builder.build();

        assertThat(built.recentFailures()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAttachmentUrlIsNullable() {
        final GitLabTestCaseEntityBuilder builder = GitLabTestCaseEntityBuilder.builder(
                        PipelinesCatalogFixtures.testCaseEntity())
                .attachmentUrl(null);

        final GitLabTestCaseEntity built = builder.build();

        assertThat(built.attachmentUrl()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabTestCaseEntity value = PipelinesCatalogFixtures.testCaseEntity();

        assertSoftly(softly -> {
            softly.assertThat(value.status()).isEqualTo("success");
            softly.assertThat(value.name()).isEqualTo("Security Reports can create an auto-remediation MR");
            softly.assertThat(value.classname()).isEqualTo("vulnerability_management_spec");
            softly.assertThat(value.file()).isEqualTo("./spec/test_spec.rb");
            softly.assertThat(value.executionTime()).isEqualTo(1);
            softly.assertThat(value.systemOutput()).isEqualTo("Failure/Error: is_expected.to eq(3)");
            softly.assertThat(value.stackTrace()).isEqualTo("Failure/Error: is_expected.to eq(3)");
            softly.assertThat(value.recentFailures()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.attachmentUrl())
                    .isEqualTo("http://localhost/namespace1/project1/-/jobs/1/artifacts/file/some/path.png");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabTestCaseEntity original = PipelinesCatalogFixtures.testCaseEntity();

        final GitLabTestCaseEntity rebuilt =
                GitLabTestCaseEntityBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabTestCaseEntity.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "status",
                        "name",
                        "classname",
                        "file",
                        "executionTime",
                        "systemOutput",
                        "stackTrace",
                        "recentFailures",
                        "attachmentUrl");
    }
}
