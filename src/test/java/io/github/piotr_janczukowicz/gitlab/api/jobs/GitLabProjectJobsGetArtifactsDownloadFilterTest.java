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
class GitLabProjectJobsGetArtifactsDownloadFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenJobTokenIsNullable() {
        final GitLabProjectJobsGetArtifactsDownloadFilterBuilder builder =
                GitLabProjectJobsGetArtifactsDownloadFilterBuilder.builder(
                                GitLabProjectJobsGetArtifactsDownloadFilterBuilder.builder()
                                        .jobToken("job_token")
                                        .searchRecentSuccessfulPipelines(true)
                                        .downloadMode(GitLabProjectJobsGetArtifactsDownloadMode.PROXY)
                                        .build())
                        .jobToken(null);

        final GitLabProjectJobsGetArtifactsDownloadFilter built = builder.build();

        assertThat(built.jobToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchRecentSuccessfulPipelinesIsNullable() {
        final GitLabProjectJobsGetArtifactsDownloadFilterBuilder builder =
                GitLabProjectJobsGetArtifactsDownloadFilterBuilder.builder(
                                GitLabProjectJobsGetArtifactsDownloadFilterBuilder.builder()
                                        .jobToken("job_token")
                                        .searchRecentSuccessfulPipelines(true)
                                        .downloadMode(GitLabProjectJobsGetArtifactsDownloadMode.PROXY)
                                        .build())
                        .searchRecentSuccessfulPipelines(null);

        final GitLabProjectJobsGetArtifactsDownloadFilter built = builder.build();

        assertThat(built.searchRecentSuccessfulPipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDownloadModeIsNullable() {
        final GitLabProjectJobsGetArtifactsDownloadFilterBuilder builder =
                GitLabProjectJobsGetArtifactsDownloadFilterBuilder.builder(
                                GitLabProjectJobsGetArtifactsDownloadFilterBuilder.builder()
                                        .jobToken("job_token")
                                        .searchRecentSuccessfulPipelines(true)
                                        .downloadMode(GitLabProjectJobsGetArtifactsDownloadMode.PROXY)
                                        .build())
                        .downloadMode(null);

        final GitLabProjectJobsGetArtifactsDownloadFilter built = builder.build();

        assertThat(built.downloadMode()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectJobsGetArtifactsDownloadFilter value =
                GitLabProjectJobsGetArtifactsDownloadFilterBuilder.builder()
                        .jobToken("job_token")
                        .searchRecentSuccessfulPipelines(true)
                        .downloadMode(GitLabProjectJobsGetArtifactsDownloadMode.PROXY)
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.jobToken()).isEqualTo("job_token");
            softly.assertThat(value.searchRecentSuccessfulPipelines()).isEqualTo(true);
            softly.assertThat(value.downloadMode()).isEqualTo(GitLabProjectJobsGetArtifactsDownloadMode.PROXY);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectJobsGetArtifactsDownloadFilter original =
                GitLabProjectJobsGetArtifactsDownloadFilterBuilder.builder()
                        .jobToken("job_token")
                        .searchRecentSuccessfulPipelines(true)
                        .downloadMode(GitLabProjectJobsGetArtifactsDownloadMode.PROXY)
                        .build();

        final GitLabProjectJobsGetArtifactsDownloadFilter rebuilt =
                GitLabProjectJobsGetArtifactsDownloadFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenJobTokenIsACredential() {
        final GitLabProjectJobsGetArtifactsDownloadFilter value =
                GitLabProjectJobsGetArtifactsDownloadFilterBuilder.builder()
                        .jobToken("job_token")
                        .searchRecentSuccessfulPipelines(true)
                        .downloadMode(GitLabProjectJobsGetArtifactsDownloadMode.PROXY)
                        .build();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectJobsGetArtifactsDownloadFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("jobToken", "searchRecentSuccessfulPipelines", "downloadMode");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectJobsGetArtifactsDownloadFilter empty = GitLabProjectJobsGetArtifactsDownloadFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectJobsGetArtifactsDownloadFilter filter =
                GitLabProjectJobsGetArtifactsDownloadFilterBuilder.builder()
                        .jobToken("job_token")
                        .searchRecentSuccessfulPipelines(true)
                        .downloadMode(GitLabProjectJobsGetArtifactsDownloadMode.PROXY)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("job_token", "job_token"),
                        Map.entry("search_recent_successful_pipelines", "true"),
                        Map.entry("download_mode", "proxy"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectJobsGetArtifactsDownloadFilter filter =
                GitLabProjectJobsGetArtifactsDownloadFilterBuilder.builder()
                        .jobToken("job_token")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("job_token", "job_token"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectJobsGetArtifactsDownloadFilter filter =
                GitLabProjectJobsGetArtifactsDownloadFilterBuilder.builder()
                        .jobToken("job_token")
                        .searchRecentSuccessfulPipelines(true)
                        .downloadMode(GitLabProjectJobsGetArtifactsDownloadMode.PROXY)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
