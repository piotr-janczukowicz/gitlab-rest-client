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
class GitLabInstanceJobsGetArtifactsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabInstanceJobsGetArtifactsFilterBuilder builder = GitLabInstanceJobsGetArtifactsFilterBuilder.builder(
                        GitLabInstanceJobsGetArtifactsFilterBuilder.builder()
                                .token("token")
                                .directDownload(true)
                                .downloadMode(GitLabInstanceJobsGetArtifactsDownloadMode.PROXY)
                                .build())
                .token(null);

        final GitLabInstanceJobsGetArtifactsFilter built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDirectDownloadIsNullable() {
        final GitLabInstanceJobsGetArtifactsFilterBuilder builder = GitLabInstanceJobsGetArtifactsFilterBuilder.builder(
                        GitLabInstanceJobsGetArtifactsFilterBuilder.builder()
                                .token("token")
                                .directDownload(true)
                                .downloadMode(GitLabInstanceJobsGetArtifactsDownloadMode.PROXY)
                                .build())
                .directDownload(null);

        final GitLabInstanceJobsGetArtifactsFilter built = builder.build();

        assertThat(built.directDownload()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDownloadModeIsNullable() {
        final GitLabInstanceJobsGetArtifactsFilterBuilder builder = GitLabInstanceJobsGetArtifactsFilterBuilder.builder(
                        GitLabInstanceJobsGetArtifactsFilterBuilder.builder()
                                .token("token")
                                .directDownload(true)
                                .downloadMode(GitLabInstanceJobsGetArtifactsDownloadMode.PROXY)
                                .build())
                .downloadMode(null);

        final GitLabInstanceJobsGetArtifactsFilter built = builder.build();

        assertThat(built.downloadMode()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceJobsGetArtifactsFilter value = GitLabInstanceJobsGetArtifactsFilterBuilder.builder()
                .token("token")
                .directDownload(true)
                .downloadMode(GitLabInstanceJobsGetArtifactsDownloadMode.PROXY)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.directDownload()).isEqualTo(true);
            softly.assertThat(value.downloadMode()).isEqualTo(GitLabInstanceJobsGetArtifactsDownloadMode.PROXY);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceJobsGetArtifactsFilter original = GitLabInstanceJobsGetArtifactsFilterBuilder.builder()
                .token("token")
                .directDownload(true)
                .downloadMode(GitLabInstanceJobsGetArtifactsDownloadMode.PROXY)
                .build();

        final GitLabInstanceJobsGetArtifactsFilter rebuilt =
                GitLabInstanceJobsGetArtifactsFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabInstanceJobsGetArtifactsFilter value = GitLabInstanceJobsGetArtifactsFilterBuilder.builder()
                .token("token")
                .directDownload(true)
                .downloadMode(GitLabInstanceJobsGetArtifactsDownloadMode.PROXY)
                .build();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabInstanceJobsGetArtifactsFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("token", "directDownload", "downloadMode");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabInstanceJobsGetArtifactsFilter empty = GitLabInstanceJobsGetArtifactsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabInstanceJobsGetArtifactsFilter filter = GitLabInstanceJobsGetArtifactsFilterBuilder.builder()
                .token("token")
                .directDownload(true)
                .downloadMode(GitLabInstanceJobsGetArtifactsDownloadMode.PROXY)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("token", "token"),
                        Map.entry("direct_download", "true"),
                        Map.entry("download_mode", "proxy"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabInstanceJobsGetArtifactsFilter filter = GitLabInstanceJobsGetArtifactsFilterBuilder.builder()
                .token("token")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("token", "token"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabInstanceJobsGetArtifactsFilter filter = GitLabInstanceJobsGetArtifactsFilterBuilder.builder()
                .token("token")
                .directDownload(true)
                .downloadMode(GitLabInstanceJobsGetArtifactsDownloadMode.PROXY)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
