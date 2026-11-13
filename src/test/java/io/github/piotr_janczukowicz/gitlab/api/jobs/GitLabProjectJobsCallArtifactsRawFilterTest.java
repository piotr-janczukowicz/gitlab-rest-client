package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectJobsCallArtifactsRawFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenJobTokenIsNullable() {
        final GitLabProjectJobsCallArtifactsRawFilterBuilder builder =
                GitLabProjectJobsCallArtifactsRawFilterBuilder.builder(
                                GitLabProjectJobsCallArtifactsRawFilterBuilder.builder()
                                        .jobToken("job_token")
                                        .searchRecentSuccessfulPipelines(true)
                                        .build())
                        .jobToken(null);

        final GitLabProjectJobsCallArtifactsRawFilter built = builder.build();

        assertThat(built.jobToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchRecentSuccessfulPipelinesIsNullable() {
        final GitLabProjectJobsCallArtifactsRawFilterBuilder builder =
                GitLabProjectJobsCallArtifactsRawFilterBuilder.builder(
                                GitLabProjectJobsCallArtifactsRawFilterBuilder.builder()
                                        .jobToken("job_token")
                                        .searchRecentSuccessfulPipelines(true)
                                        .build())
                        .searchRecentSuccessfulPipelines(null);

        final GitLabProjectJobsCallArtifactsRawFilter built = builder.build();

        assertThat(built.searchRecentSuccessfulPipelines()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectJobsCallArtifactsRawFilter value = GitLabProjectJobsCallArtifactsRawFilterBuilder.builder()
                .jobToken("job_token")
                .searchRecentSuccessfulPipelines(true)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.jobToken()).isEqualTo("job_token");
            softly.assertThat(value.searchRecentSuccessfulPipelines()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectJobsCallArtifactsRawFilter original =
                GitLabProjectJobsCallArtifactsRawFilterBuilder.builder()
                        .jobToken("job_token")
                        .searchRecentSuccessfulPipelines(true)
                        .build();

        final GitLabProjectJobsCallArtifactsRawFilter rebuilt =
                GitLabProjectJobsCallArtifactsRawFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenJobTokenIsACredential() {
        final GitLabProjectJobsCallArtifactsRawFilter value = GitLabProjectJobsCallArtifactsRawFilterBuilder.builder()
                .jobToken("job_token")
                .searchRecentSuccessfulPipelines(true)
                .build();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectJobsCallArtifactsRawFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("jobToken", "searchRecentSuccessfulPipelines");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectJobsCallArtifactsRawFilter empty = GitLabProjectJobsCallArtifactsRawFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectJobsCallArtifactsRawFilter filter = GitLabProjectJobsCallArtifactsRawFilterBuilder.builder()
                .jobToken("job_token")
                .searchRecentSuccessfulPipelines(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("job_token", "job_token"), Map.entry("search_recent_successful_pipelines", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectJobsCallArtifactsRawFilter filter = GitLabProjectJobsCallArtifactsRawFilterBuilder.builder()
                .jobToken("job_token")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("job_token", "job_token"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectJobsCallArtifactsRawFilter filter = GitLabProjectJobsCallArtifactsRawFilterBuilder.builder()
                .jobToken("job_token")
                .searchRecentSuccessfulPipelines(true)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
