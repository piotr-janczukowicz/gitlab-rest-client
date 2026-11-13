package io.github.piotr_janczukowicz.gitlab.api.search;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectSearchGetSemanticFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenDirectoryPathIsNullable() {
        final GitLabProjectSearchGetSemanticFilterBuilder builder = GitLabProjectSearchGetSemanticFilterBuilder.builder(
                        GitLabProjectSearchGetSemanticFilterBuilder.builder()
                                .directoryPath("directory_path")
                                .knn(1)
                                .limit(1)
                                .build())
                .directoryPath(null);

        final GitLabProjectSearchGetSemanticFilter built = builder.build();

        assertThat(built.directoryPath()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenDirectoryPathIsTooLong() {
        final GitLabProjectSearchGetSemanticFilterBuilder builder = GitLabProjectSearchGetSemanticFilterBuilder.builder(
                        GitLabProjectSearchGetSemanticFilterBuilder.builder()
                                .directoryPath("directory_path")
                                .knn(1)
                                .limit(1)
                                .build())
                .directoryPath("x".repeat(101));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenDirectoryPathHasTheMaximumLength() {
        final GitLabProjectSearchGetSemanticFilterBuilder builder = GitLabProjectSearchGetSemanticFilterBuilder.builder(
                        GitLabProjectSearchGetSemanticFilterBuilder.builder()
                                .directoryPath("directory_path")
                                .knn(1)
                                .limit(1)
                                .build())
                .directoryPath("x".repeat(100));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKnnIsNullable() {
        final GitLabProjectSearchGetSemanticFilterBuilder builder = GitLabProjectSearchGetSemanticFilterBuilder.builder(
                        GitLabProjectSearchGetSemanticFilterBuilder.builder()
                                .directoryPath("directory_path")
                                .knn(1)
                                .limit(1)
                                .build())
                .knn(null);

        final GitLabProjectSearchGetSemanticFilter built = builder.build();

        assertThat(built.knn()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenKnnIsBelowTheMinimum() {
        final GitLabProjectSearchGetSemanticFilterBuilder builder = GitLabProjectSearchGetSemanticFilterBuilder.builder(
                        GitLabProjectSearchGetSemanticFilterBuilder.builder()
                                .directoryPath("directory_path")
                                .knn(1)
                                .limit(1)
                                .build())
                .knn(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenKnnIsTheMinimum() {
        final GitLabProjectSearchGetSemanticFilterBuilder builder = GitLabProjectSearchGetSemanticFilterBuilder.builder(
                        GitLabProjectSearchGetSemanticFilterBuilder.builder()
                                .directoryPath("directory_path")
                                .knn(1)
                                .limit(1)
                                .build())
                .knn(1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenKnnIsAboveTheMaximum() {
        final GitLabProjectSearchGetSemanticFilterBuilder builder = GitLabProjectSearchGetSemanticFilterBuilder.builder(
                        GitLabProjectSearchGetSemanticFilterBuilder.builder()
                                .directoryPath("directory_path")
                                .knn(1)
                                .limit(1)
                                .build())
                .knn(101);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenKnnIsTheMaximum() {
        final GitLabProjectSearchGetSemanticFilterBuilder builder = GitLabProjectSearchGetSemanticFilterBuilder.builder(
                        GitLabProjectSearchGetSemanticFilterBuilder.builder()
                                .directoryPath("directory_path")
                                .knn(1)
                                .limit(1)
                                .build())
                .knn(100);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLimitIsNullable() {
        final GitLabProjectSearchGetSemanticFilterBuilder builder = GitLabProjectSearchGetSemanticFilterBuilder.builder(
                        GitLabProjectSearchGetSemanticFilterBuilder.builder()
                                .directoryPath("directory_path")
                                .knn(1)
                                .limit(1)
                                .build())
                .limit(null);

        final GitLabProjectSearchGetSemanticFilter built = builder.build();

        assertThat(built.limit()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenLimitIsBelowTheMinimum() {
        final GitLabProjectSearchGetSemanticFilterBuilder builder = GitLabProjectSearchGetSemanticFilterBuilder.builder(
                        GitLabProjectSearchGetSemanticFilterBuilder.builder()
                                .directoryPath("directory_path")
                                .knn(1)
                                .limit(1)
                                .build())
                .limit(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenLimitIsTheMinimum() {
        final GitLabProjectSearchGetSemanticFilterBuilder builder = GitLabProjectSearchGetSemanticFilterBuilder.builder(
                        GitLabProjectSearchGetSemanticFilterBuilder.builder()
                                .directoryPath("directory_path")
                                .knn(1)
                                .limit(1)
                                .build())
                .limit(1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenLimitIsAboveTheMaximum() {
        final GitLabProjectSearchGetSemanticFilterBuilder builder = GitLabProjectSearchGetSemanticFilterBuilder.builder(
                        GitLabProjectSearchGetSemanticFilterBuilder.builder()
                                .directoryPath("directory_path")
                                .knn(1)
                                .limit(1)
                                .build())
                .limit(101);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenLimitIsTheMaximum() {
        final GitLabProjectSearchGetSemanticFilterBuilder builder = GitLabProjectSearchGetSemanticFilterBuilder.builder(
                        GitLabProjectSearchGetSemanticFilterBuilder.builder()
                                .directoryPath("directory_path")
                                .knn(1)
                                .limit(1)
                                .build())
                .limit(100);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectSearchGetSemanticFilter value = GitLabProjectSearchGetSemanticFilterBuilder.builder()
                .directoryPath("directory_path")
                .knn(1)
                .limit(1)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.directoryPath()).isEqualTo("directory_path");
            softly.assertThat(value.knn()).isEqualTo(1);
            softly.assertThat(value.limit()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectSearchGetSemanticFilter original = GitLabProjectSearchGetSemanticFilterBuilder.builder()
                .directoryPath("directory_path")
                .knn(1)
                .limit(1)
                .build();

        final GitLabProjectSearchGetSemanticFilter rebuilt =
                GitLabProjectSearchGetSemanticFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectSearchGetSemanticFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("directoryPath", "knn", "limit");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectSearchGetSemanticFilter empty = GitLabProjectSearchGetSemanticFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectSearchGetSemanticFilter filter = GitLabProjectSearchGetSemanticFilterBuilder.builder()
                .directoryPath("directory_path")
                .knn(1)
                .limit(1)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("directory_path", "directory_path"), Map.entry("knn", "1"), Map.entry("limit", "1"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectSearchGetSemanticFilter filter = GitLabProjectSearchGetSemanticFilterBuilder.builder()
                .directoryPath("directory_path")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("directory_path", "directory_path"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectSearchGetSemanticFilter filter = GitLabProjectSearchGetSemanticFilterBuilder.builder()
                .directoryPath("directory_path")
                .knn(1)
                .limit(1)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
