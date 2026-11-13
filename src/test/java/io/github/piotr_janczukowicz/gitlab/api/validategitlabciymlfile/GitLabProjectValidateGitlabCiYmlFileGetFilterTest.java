package io.github.piotr_janczukowicz.gitlab.api.validategitlabciymlfile;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectValidateGitlabCiYmlFileGetFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenShaIsNullable() {
        final GitLabProjectValidateGitlabCiYmlFileGetFilterBuilder builder =
                GitLabProjectValidateGitlabCiYmlFileGetFilterBuilder.builder(
                                GitLabProjectValidateGitlabCiYmlFileGetFilterBuilder.builder()
                                        .sha("sha")
                                        .contentRef("content_ref")
                                        .dryRun(true)
                                        .includeJobs(true)
                                        .ref("ref")
                                        .dryRunRef("dry_run_ref")
                                        .build())
                        .sha(null);

        final GitLabProjectValidateGitlabCiYmlFileGetFilter built = builder.build();

        assertThat(built.sha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContentRefIsNullable() {
        final GitLabProjectValidateGitlabCiYmlFileGetFilterBuilder builder =
                GitLabProjectValidateGitlabCiYmlFileGetFilterBuilder.builder(
                                GitLabProjectValidateGitlabCiYmlFileGetFilterBuilder.builder()
                                        .sha("sha")
                                        .contentRef("content_ref")
                                        .dryRun(true)
                                        .includeJobs(true)
                                        .ref("ref")
                                        .dryRunRef("dry_run_ref")
                                        .build())
                        .contentRef(null);

        final GitLabProjectValidateGitlabCiYmlFileGetFilter built = builder.build();

        assertThat(built.contentRef()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDryRunIsNullable() {
        final GitLabProjectValidateGitlabCiYmlFileGetFilterBuilder builder =
                GitLabProjectValidateGitlabCiYmlFileGetFilterBuilder.builder(
                                GitLabProjectValidateGitlabCiYmlFileGetFilterBuilder.builder()
                                        .sha("sha")
                                        .contentRef("content_ref")
                                        .dryRun(true)
                                        .includeJobs(true)
                                        .ref("ref")
                                        .dryRunRef("dry_run_ref")
                                        .build())
                        .dryRun(null);

        final GitLabProjectValidateGitlabCiYmlFileGetFilter built = builder.build();

        assertThat(built.dryRun()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncludeJobsIsNullable() {
        final GitLabProjectValidateGitlabCiYmlFileGetFilterBuilder builder =
                GitLabProjectValidateGitlabCiYmlFileGetFilterBuilder.builder(
                                GitLabProjectValidateGitlabCiYmlFileGetFilterBuilder.builder()
                                        .sha("sha")
                                        .contentRef("content_ref")
                                        .dryRun(true)
                                        .includeJobs(true)
                                        .ref("ref")
                                        .dryRunRef("dry_run_ref")
                                        .build())
                        .includeJobs(null);

        final GitLabProjectValidateGitlabCiYmlFileGetFilter built = builder.build();

        assertThat(built.includeJobs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabProjectValidateGitlabCiYmlFileGetFilterBuilder builder =
                GitLabProjectValidateGitlabCiYmlFileGetFilterBuilder.builder(
                                GitLabProjectValidateGitlabCiYmlFileGetFilterBuilder.builder()
                                        .sha("sha")
                                        .contentRef("content_ref")
                                        .dryRun(true)
                                        .includeJobs(true)
                                        .ref("ref")
                                        .dryRunRef("dry_run_ref")
                                        .build())
                        .ref(null);

        final GitLabProjectValidateGitlabCiYmlFileGetFilter built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDryRunRefIsNullable() {
        final GitLabProjectValidateGitlabCiYmlFileGetFilterBuilder builder =
                GitLabProjectValidateGitlabCiYmlFileGetFilterBuilder.builder(
                                GitLabProjectValidateGitlabCiYmlFileGetFilterBuilder.builder()
                                        .sha("sha")
                                        .contentRef("content_ref")
                                        .dryRun(true)
                                        .includeJobs(true)
                                        .ref("ref")
                                        .dryRunRef("dry_run_ref")
                                        .build())
                        .dryRunRef(null);

        final GitLabProjectValidateGitlabCiYmlFileGetFilter built = builder.build();

        assertThat(built.dryRunRef()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectValidateGitlabCiYmlFileGetFilter value =
                GitLabProjectValidateGitlabCiYmlFileGetFilterBuilder.builder()
                        .sha("sha")
                        .contentRef("content_ref")
                        .dryRun(true)
                        .includeJobs(true)
                        .ref("ref")
                        .dryRunRef("dry_run_ref")
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.sha()).isEqualTo("sha");
            softly.assertThat(value.contentRef()).isEqualTo("content_ref");
            softly.assertThat(value.dryRun()).isEqualTo(true);
            softly.assertThat(value.includeJobs()).isEqualTo(true);
            softly.assertThat(value.ref()).isEqualTo("ref");
            softly.assertThat(value.dryRunRef()).isEqualTo("dry_run_ref");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectValidateGitlabCiYmlFileGetFilter original =
                GitLabProjectValidateGitlabCiYmlFileGetFilterBuilder.builder()
                        .sha("sha")
                        .contentRef("content_ref")
                        .dryRun(true)
                        .includeJobs(true)
                        .ref("ref")
                        .dryRunRef("dry_run_ref")
                        .build();

        final GitLabProjectValidateGitlabCiYmlFileGetFilter rebuilt =
                GitLabProjectValidateGitlabCiYmlFileGetFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectValidateGitlabCiYmlFileGetFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("sha", "contentRef", "dryRun", "includeJobs", "ref", "dryRunRef");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectValidateGitlabCiYmlFileGetFilter empty =
                GitLabProjectValidateGitlabCiYmlFileGetFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectValidateGitlabCiYmlFileGetFilter filter =
                GitLabProjectValidateGitlabCiYmlFileGetFilterBuilder.builder()
                        .sha("sha")
                        .contentRef("content_ref")
                        .dryRun(true)
                        .includeJobs(true)
                        .ref("ref")
                        .dryRunRef("dry_run_ref")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("sha", "sha"),
                        Map.entry("content_ref", "content_ref"),
                        Map.entry("dry_run", "true"),
                        Map.entry("include_jobs", "true"),
                        Map.entry("ref", "ref"),
                        Map.entry("dry_run_ref", "dry_run_ref"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectValidateGitlabCiYmlFileGetFilter filter =
                GitLabProjectValidateGitlabCiYmlFileGetFilterBuilder.builder()
                        .sha("sha")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("sha", "sha"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectValidateGitlabCiYmlFileGetFilter filter =
                GitLabProjectValidateGitlabCiYmlFileGetFilterBuilder.builder()
                        .sha("sha")
                        .contentRef("content_ref")
                        .dryRun(true)
                        .includeJobs(true)
                        .ref("ref")
                        .dryRunRef("dry_run_ref")
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
