package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectMergeRequestsGetFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenRenderHtmlIsNullable() {
        final GitLabProjectMergeRequestsGetFilterBuilder builder = GitLabProjectMergeRequestsGetFilterBuilder.builder(
                        GitLabProjectMergeRequestsGetFilterBuilder.builder()
                                .renderHtml(true)
                                .includeDivergedCommitsCount(true)
                                .includeRebaseInProgress(true)
                                .build())
                .renderHtml(null);

        final GitLabProjectMergeRequestsGetFilter built = builder.build();

        assertThat(built.renderHtml()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncludeDivergedCommitsCountIsNullable() {
        final GitLabProjectMergeRequestsGetFilterBuilder builder = GitLabProjectMergeRequestsGetFilterBuilder.builder(
                        GitLabProjectMergeRequestsGetFilterBuilder.builder()
                                .renderHtml(true)
                                .includeDivergedCommitsCount(true)
                                .includeRebaseInProgress(true)
                                .build())
                .includeDivergedCommitsCount(null);

        final GitLabProjectMergeRequestsGetFilter built = builder.build();

        assertThat(built.includeDivergedCommitsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncludeRebaseInProgressIsNullable() {
        final GitLabProjectMergeRequestsGetFilterBuilder builder = GitLabProjectMergeRequestsGetFilterBuilder.builder(
                        GitLabProjectMergeRequestsGetFilterBuilder.builder()
                                .renderHtml(true)
                                .includeDivergedCommitsCount(true)
                                .includeRebaseInProgress(true)
                                .build())
                .includeRebaseInProgress(null);

        final GitLabProjectMergeRequestsGetFilter built = builder.build();

        assertThat(built.includeRebaseInProgress()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectMergeRequestsGetFilter value = GitLabProjectMergeRequestsGetFilterBuilder.builder()
                .renderHtml(true)
                .includeDivergedCommitsCount(true)
                .includeRebaseInProgress(true)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.renderHtml()).isEqualTo(true);
            softly.assertThat(value.includeDivergedCommitsCount()).isEqualTo(true);
            softly.assertThat(value.includeRebaseInProgress()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectMergeRequestsGetFilter original = GitLabProjectMergeRequestsGetFilterBuilder.builder()
                .renderHtml(true)
                .includeDivergedCommitsCount(true)
                .includeRebaseInProgress(true)
                .build();

        final GitLabProjectMergeRequestsGetFilter rebuilt =
                GitLabProjectMergeRequestsGetFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectMergeRequestsGetFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("renderHtml", "includeDivergedCommitsCount", "includeRebaseInProgress");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectMergeRequestsGetFilter empty = GitLabProjectMergeRequestsGetFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectMergeRequestsGetFilter filter = GitLabProjectMergeRequestsGetFilterBuilder.builder()
                .renderHtml(true)
                .includeDivergedCommitsCount(true)
                .includeRebaseInProgress(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("render_html", "true"),
                        Map.entry("include_diverged_commits_count", "true"),
                        Map.entry("include_rebase_in_progress", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectMergeRequestsGetFilter filter = GitLabProjectMergeRequestsGetFilterBuilder.builder()
                .renderHtml(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("render_html", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectMergeRequestsGetFilter filter = GitLabProjectMergeRequestsGetFilterBuilder.builder()
                .renderHtml(true)
                .includeDivergedCommitsCount(true)
                .includeRebaseInProgress(true)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
