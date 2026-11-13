package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsGetSnapshotFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenWikiIsNullable() {
        final GitLabProjectProjectsGetSnapshotFilterBuilder builder =
                GitLabProjectProjectsGetSnapshotFilterBuilder.builder(
                                GitLabProjectProjectsGetSnapshotFilterBuilder.builder()
                                        .wiki(true)
                                        .build())
                        .wiki(null);

        final GitLabProjectProjectsGetSnapshotFilter built = builder.build();

        assertThat(built.wiki()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsGetSnapshotFilter value = GitLabProjectProjectsGetSnapshotFilterBuilder.builder()
                .wiki(true)
                .build();

        assertThat(value.wiki()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsGetSnapshotFilter original = GitLabProjectProjectsGetSnapshotFilterBuilder.builder()
                .wiki(true)
                .build();

        final GitLabProjectProjectsGetSnapshotFilter rebuilt =
                GitLabProjectProjectsGetSnapshotFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectsGetSnapshotFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("wiki");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectProjectsGetSnapshotFilter empty = GitLabProjectProjectsGetSnapshotFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectProjectsGetSnapshotFilter filter = GitLabProjectProjectsGetSnapshotFilterBuilder.builder()
                .wiki(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("wiki", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectProjectsGetSnapshotFilter filter = GitLabProjectProjectsGetSnapshotFilterBuilder.builder()
                .wiki(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("wiki", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectProjectsGetSnapshotFilter filter = GitLabProjectProjectsGetSnapshotFilterBuilder.builder()
                .wiki(true)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
