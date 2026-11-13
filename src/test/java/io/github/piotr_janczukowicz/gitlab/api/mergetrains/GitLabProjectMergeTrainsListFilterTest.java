package io.github.piotr_janczukowicz.gitlab.api.mergetrains;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectMergeTrainsListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenScopeIsNullable() {
        final GitLabProjectMergeTrainsListFilterBuilder builder = GitLabProjectMergeTrainsListFilterBuilder.builder(
                        GitLabProjectMergeTrainsListFilterBuilder.builder()
                                .scope(GitLabProjectMergeTrainsListScope.ACTIVE)
                                .sort(GitLabProjectMergeTrainsListSort.ASC)
                                .build())
                .scope(null);

        final GitLabProjectMergeTrainsListFilter built = builder.build();

        assertThat(built.scope()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabProjectMergeTrainsListFilterBuilder builder = GitLabProjectMergeTrainsListFilterBuilder.builder(
                        GitLabProjectMergeTrainsListFilterBuilder.builder()
                                .scope(GitLabProjectMergeTrainsListScope.ACTIVE)
                                .sort(GitLabProjectMergeTrainsListSort.ASC)
                                .build())
                .sort(null);

        final GitLabProjectMergeTrainsListFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectMergeTrainsListFilter value = GitLabProjectMergeTrainsListFilterBuilder.builder()
                .scope(GitLabProjectMergeTrainsListScope.ACTIVE)
                .sort(GitLabProjectMergeTrainsListSort.ASC)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.scope()).isEqualTo(GitLabProjectMergeTrainsListScope.ACTIVE);
            softly.assertThat(value.sort()).isEqualTo(GitLabProjectMergeTrainsListSort.ASC);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectMergeTrainsListFilter original = GitLabProjectMergeTrainsListFilterBuilder.builder()
                .scope(GitLabProjectMergeTrainsListScope.ACTIVE)
                .sort(GitLabProjectMergeTrainsListSort.ASC)
                .build();

        final GitLabProjectMergeTrainsListFilter rebuilt =
                GitLabProjectMergeTrainsListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectMergeTrainsListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("scope", "sort");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectMergeTrainsListFilter empty = GitLabProjectMergeTrainsListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectMergeTrainsListFilter filter = GitLabProjectMergeTrainsListFilterBuilder.builder()
                .scope(GitLabProjectMergeTrainsListScope.ACTIVE)
                .sort(GitLabProjectMergeTrainsListSort.ASC)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("scope", "active"), Map.entry("sort", "asc"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectMergeTrainsListFilter filter = GitLabProjectMergeTrainsListFilterBuilder.builder()
                .scope(GitLabProjectMergeTrainsListScope.ACTIVE)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("scope", "active"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectMergeTrainsListFilter filter = GitLabProjectMergeTrainsListFilterBuilder.builder()
                .scope(GitLabProjectMergeTrainsListScope.ACTIVE)
                .sort(GitLabProjectMergeTrainsListSort.ASC)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
