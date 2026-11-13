package io.github.piotr_janczukowicz.gitlab.api.jobsartifacts;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectJobsArtifactsCallFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenJobTokenIsNullable() {
        final GitLabProjectJobsArtifactsCallFilterBuilder builder = GitLabProjectJobsArtifactsCallFilterBuilder.builder(
                        GitLabProjectJobsArtifactsCallFilterBuilder.builder()
                                .jobToken("job_token")
                                .build())
                .jobToken(null);

        final GitLabProjectJobsArtifactsCallFilter built = builder.build();

        assertThat(built.jobToken()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectJobsArtifactsCallFilter value = GitLabProjectJobsArtifactsCallFilterBuilder.builder()
                .jobToken("job_token")
                .build();

        assertThat(value.jobToken()).isEqualTo("job_token");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectJobsArtifactsCallFilter original = GitLabProjectJobsArtifactsCallFilterBuilder.builder()
                .jobToken("job_token")
                .build();

        final GitLabProjectJobsArtifactsCallFilter rebuilt =
                GitLabProjectJobsArtifactsCallFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenJobTokenIsACredential() {
        final GitLabProjectJobsArtifactsCallFilter value = GitLabProjectJobsArtifactsCallFilterBuilder.builder()
                .jobToken("job_token")
                .build();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectJobsArtifactsCallFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("jobToken");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectJobsArtifactsCallFilter empty = GitLabProjectJobsArtifactsCallFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectJobsArtifactsCallFilter filter = GitLabProjectJobsArtifactsCallFilterBuilder.builder()
                .jobToken("job_token")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("job_token", "job_token"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectJobsArtifactsCallFilter filter = GitLabProjectJobsArtifactsCallFilterBuilder.builder()
                .jobToken("job_token")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("job_token", "job_token"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectJobsArtifactsCallFilter filter = GitLabProjectJobsArtifactsCallFilterBuilder.builder()
                .jobToken("job_token")
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
