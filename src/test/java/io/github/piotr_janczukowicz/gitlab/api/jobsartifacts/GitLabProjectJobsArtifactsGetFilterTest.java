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
class GitLabProjectJobsArtifactsGetFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenFileTypeIsNullable() {
        final GitLabProjectJobsArtifactsGetFilterBuilder builder = GitLabProjectJobsArtifactsGetFilterBuilder.builder(
                        GitLabProjectJobsArtifactsGetFilterBuilder.builder()
                                .fileType(GitLabProjectJobsArtifactsGetFileType.ACCESSIBILITY)
                                .jobToken("job_token")
                                .downloadMode(GitLabProjectJobsArtifactsGetDownloadMode.PROXY)
                                .build())
                .fileType(null);

        final GitLabProjectJobsArtifactsGetFilter built = builder.build();

        assertThat(built.fileType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobTokenIsNullable() {
        final GitLabProjectJobsArtifactsGetFilterBuilder builder = GitLabProjectJobsArtifactsGetFilterBuilder.builder(
                        GitLabProjectJobsArtifactsGetFilterBuilder.builder()
                                .fileType(GitLabProjectJobsArtifactsGetFileType.ACCESSIBILITY)
                                .jobToken("job_token")
                                .downloadMode(GitLabProjectJobsArtifactsGetDownloadMode.PROXY)
                                .build())
                .jobToken(null);

        final GitLabProjectJobsArtifactsGetFilter built = builder.build();

        assertThat(built.jobToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDownloadModeIsNullable() {
        final GitLabProjectJobsArtifactsGetFilterBuilder builder = GitLabProjectJobsArtifactsGetFilterBuilder.builder(
                        GitLabProjectJobsArtifactsGetFilterBuilder.builder()
                                .fileType(GitLabProjectJobsArtifactsGetFileType.ACCESSIBILITY)
                                .jobToken("job_token")
                                .downloadMode(GitLabProjectJobsArtifactsGetDownloadMode.PROXY)
                                .build())
                .downloadMode(null);

        final GitLabProjectJobsArtifactsGetFilter built = builder.build();

        assertThat(built.downloadMode()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectJobsArtifactsGetFilter value = GitLabProjectJobsArtifactsGetFilterBuilder.builder()
                .fileType(GitLabProjectJobsArtifactsGetFileType.ACCESSIBILITY)
                .jobToken("job_token")
                .downloadMode(GitLabProjectJobsArtifactsGetDownloadMode.PROXY)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.fileType()).isEqualTo(GitLabProjectJobsArtifactsGetFileType.ACCESSIBILITY);
            softly.assertThat(value.jobToken()).isEqualTo("job_token");
            softly.assertThat(value.downloadMode()).isEqualTo(GitLabProjectJobsArtifactsGetDownloadMode.PROXY);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectJobsArtifactsGetFilter original = GitLabProjectJobsArtifactsGetFilterBuilder.builder()
                .fileType(GitLabProjectJobsArtifactsGetFileType.ACCESSIBILITY)
                .jobToken("job_token")
                .downloadMode(GitLabProjectJobsArtifactsGetDownloadMode.PROXY)
                .build();

        final GitLabProjectJobsArtifactsGetFilter rebuilt =
                GitLabProjectJobsArtifactsGetFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenJobTokenIsACredential() {
        final GitLabProjectJobsArtifactsGetFilter value = GitLabProjectJobsArtifactsGetFilterBuilder.builder()
                .fileType(GitLabProjectJobsArtifactsGetFileType.ACCESSIBILITY)
                .jobToken("job_token")
                .downloadMode(GitLabProjectJobsArtifactsGetDownloadMode.PROXY)
                .build();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectJobsArtifactsGetFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("fileType", "jobToken", "downloadMode");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectJobsArtifactsGetFilter empty = GitLabProjectJobsArtifactsGetFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectJobsArtifactsGetFilter filter = GitLabProjectJobsArtifactsGetFilterBuilder.builder()
                .fileType(GitLabProjectJobsArtifactsGetFileType.ACCESSIBILITY)
                .jobToken("job_token")
                .downloadMode(GitLabProjectJobsArtifactsGetDownloadMode.PROXY)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("file_type", "accessibility"),
                        Map.entry("job_token", "job_token"),
                        Map.entry("download_mode", "proxy"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectJobsArtifactsGetFilter filter = GitLabProjectJobsArtifactsGetFilterBuilder.builder()
                .fileType(GitLabProjectJobsArtifactsGetFileType.ACCESSIBILITY)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("file_type", "accessibility"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectJobsArtifactsGetFilter filter = GitLabProjectJobsArtifactsGetFilterBuilder.builder()
                .fileType(GitLabProjectJobsArtifactsGetFileType.ACCESSIBILITY)
                .jobToken("job_token")
                .downloadMode(GitLabProjectJobsArtifactsGetDownloadMode.PROXY)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
