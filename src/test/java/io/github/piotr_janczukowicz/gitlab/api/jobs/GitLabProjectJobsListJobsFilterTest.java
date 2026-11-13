package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectJobsListJobsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenScopeIsNullable() {
        final GitLabProjectJobsListJobsFilterBuilder builder = GitLabProjectJobsListJobsFilterBuilder.builder(
                        GitLabProjectJobsListJobsFilterBuilder.builder()
                                .scope(List.of(GitLabProjectJobsListJobsScope.CREATED))
                                .ref("ref")
                                .build())
                .scope(null);

        final GitLabProjectJobsListJobsFilter built = builder.build();

        assertThat(built.scope()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabProjectJobsListJobsFilterBuilder builder = GitLabProjectJobsListJobsFilterBuilder.builder(
                        GitLabProjectJobsListJobsFilterBuilder.builder()
                                .scope(List.of(GitLabProjectJobsListJobsScope.CREATED))
                                .ref("ref")
                                .build())
                .ref(null);

        final GitLabProjectJobsListJobsFilter built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectJobsListJobsFilter value = GitLabProjectJobsListJobsFilterBuilder.builder()
                .scope(List.of(GitLabProjectJobsListJobsScope.CREATED))
                .ref("ref")
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.scope()).isEqualTo(List.of(GitLabProjectJobsListJobsScope.CREATED));
            softly.assertThat(value.ref()).isEqualTo("ref");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectJobsListJobsFilter original = GitLabProjectJobsListJobsFilterBuilder.builder()
                .scope(List.of(GitLabProjectJobsListJobsScope.CREATED))
                .ref("ref")
                .build();

        final GitLabProjectJobsListJobsFilter rebuilt =
                GitLabProjectJobsListJobsFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenScopeSourceChangesLater() {
        final List<GitLabProjectJobsListJobsScope> source =
                new ArrayList<>(List.of(GitLabProjectJobsListJobsScope.CREATED));
        final GitLabProjectJobsListJobsFilter built = GitLabProjectJobsListJobsFilterBuilder.builder(
                        GitLabProjectJobsListJobsFilterBuilder.builder()
                                .scope(List.of(GitLabProjectJobsListJobsScope.CREATED))
                                .ref("ref")
                                .build())
                .scope(source)
                .build();
        source.clear();

        assertThat(built.scope()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenScopeIsRead() {
        final GitLabProjectJobsListJobsFilter built = GitLabProjectJobsListJobsFilterBuilder.builder()
                .scope(List.of(GitLabProjectJobsListJobsScope.CREATED))
                .ref("ref")
                .build();
        final List<GitLabProjectJobsListJobsScope> values = built.scope();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectJobsListJobsFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("scope", "ref");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectJobsListJobsFilter empty = GitLabProjectJobsListJobsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectJobsListJobsFilter filter = GitLabProjectJobsListJobsFilterBuilder.builder()
                .scope(List.of(GitLabProjectJobsListJobsScope.CREATED))
                .ref("ref")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("scope", "created"), Map.entry("ref", "ref"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectJobsListJobsFilter filter = GitLabProjectJobsListJobsFilterBuilder.builder()
                .scope(List.of(GitLabProjectJobsListJobsScope.CREATED))
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("scope", "created"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectJobsListJobsFilter filter = GitLabProjectJobsListJobsFilterBuilder.builder()
                .scope(List.of(GitLabProjectJobsListJobsScope.CREATED))
                .ref("ref")
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
