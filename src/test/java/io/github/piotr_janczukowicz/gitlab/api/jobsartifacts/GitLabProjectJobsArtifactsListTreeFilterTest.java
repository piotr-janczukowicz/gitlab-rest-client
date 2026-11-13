package io.github.piotr_janczukowicz.gitlab.api.jobsartifacts;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectJobsArtifactsListTreeFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabProjectJobsArtifactsListTreeFilterBuilder builder =
                GitLabProjectJobsArtifactsListTreeFilterBuilder.builder(
                                GitLabProjectJobsArtifactsListTreeFilterBuilder.builder()
                                        .path("path")
                                        .recursive(true)
                                        .jobToken("job_token")
                                        .build())
                        .path(null);

        final GitLabProjectJobsArtifactsListTreeFilter built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRecursiveIsNullable() {
        final GitLabProjectJobsArtifactsListTreeFilterBuilder builder =
                GitLabProjectJobsArtifactsListTreeFilterBuilder.builder(
                                GitLabProjectJobsArtifactsListTreeFilterBuilder.builder()
                                        .path("path")
                                        .recursive(true)
                                        .jobToken("job_token")
                                        .build())
                        .recursive(null);

        final GitLabProjectJobsArtifactsListTreeFilter built = builder.build();

        assertThat(built.recursive()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobTokenIsNullable() {
        final GitLabProjectJobsArtifactsListTreeFilterBuilder builder =
                GitLabProjectJobsArtifactsListTreeFilterBuilder.builder(
                                GitLabProjectJobsArtifactsListTreeFilterBuilder.builder()
                                        .path("path")
                                        .recursive(true)
                                        .jobToken("job_token")
                                        .build())
                        .jobToken(null);

        final GitLabProjectJobsArtifactsListTreeFilter built = builder.build();

        assertThat(built.jobToken()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectJobsArtifactsListTreeFilter value = GitLabProjectJobsArtifactsListTreeFilterBuilder.builder()
                .path("path")
                .recursive(true)
                .jobToken("job_token")
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.path()).isEqualTo("path");
            softly.assertThat(value.recursive()).isEqualTo(true);
            softly.assertThat(value.jobToken()).isEqualTo("job_token");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectJobsArtifactsListTreeFilter original =
                GitLabProjectJobsArtifactsListTreeFilterBuilder.builder()
                        .path("path")
                        .recursive(true)
                        .jobToken("job_token")
                        .build();

        final GitLabProjectJobsArtifactsListTreeFilter rebuilt =
                GitLabProjectJobsArtifactsListTreeFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenJobTokenIsACredential() {
        final GitLabProjectJobsArtifactsListTreeFilter value = GitLabProjectJobsArtifactsListTreeFilterBuilder.builder()
                .path("path")
                .recursive(true)
                .jobToken("job_token")
                .build();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectJobsArtifactsListTreeFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("path", "recursive", "jobToken");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectJobsArtifactsListTreeFilter empty = GitLabProjectJobsArtifactsListTreeFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectJobsArtifactsListTreeFilter filter =
                GitLabProjectJobsArtifactsListTreeFilterBuilder.builder()
                        .path("path")
                        .recursive(true)
                        .jobToken("job_token")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("path", "path"), Map.entry("recursive", "true"), Map.entry("job_token", "job_token"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectJobsArtifactsListTreeFilter filter =
                GitLabProjectJobsArtifactsListTreeFilterBuilder.builder()
                        .path("path")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("path", "path"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectJobsArtifactsListTreeFilter filter =
                GitLabProjectJobsArtifactsListTreeFilterBuilder.builder()
                        .path("path")
                        .recursive(true)
                        .jobToken("job_token")
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
