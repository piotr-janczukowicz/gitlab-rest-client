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
class GitLabProjectMergeTrainsListByTargetBranchFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenScopeIsNullable() {
        final GitLabProjectMergeTrainsListByTargetBranchFilterBuilder builder =
                GitLabProjectMergeTrainsListByTargetBranchFilterBuilder.builder(
                                GitLabProjectMergeTrainsListByTargetBranchFilterBuilder.builder()
                                        .scope(GitLabProjectMergeTrainsListByTargetBranchScope.ACTIVE)
                                        .sort(GitLabProjectMergeTrainsListByTargetBranchSort.ASC)
                                        .build())
                        .scope(null);

        final GitLabProjectMergeTrainsListByTargetBranchFilter built = builder.build();

        assertThat(built.scope()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabProjectMergeTrainsListByTargetBranchFilterBuilder builder =
                GitLabProjectMergeTrainsListByTargetBranchFilterBuilder.builder(
                                GitLabProjectMergeTrainsListByTargetBranchFilterBuilder.builder()
                                        .scope(GitLabProjectMergeTrainsListByTargetBranchScope.ACTIVE)
                                        .sort(GitLabProjectMergeTrainsListByTargetBranchSort.ASC)
                                        .build())
                        .sort(null);

        final GitLabProjectMergeTrainsListByTargetBranchFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectMergeTrainsListByTargetBranchFilter value =
                GitLabProjectMergeTrainsListByTargetBranchFilterBuilder.builder()
                        .scope(GitLabProjectMergeTrainsListByTargetBranchScope.ACTIVE)
                        .sort(GitLabProjectMergeTrainsListByTargetBranchSort.ASC)
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.scope()).isEqualTo(GitLabProjectMergeTrainsListByTargetBranchScope.ACTIVE);
            softly.assertThat(value.sort()).isEqualTo(GitLabProjectMergeTrainsListByTargetBranchSort.ASC);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectMergeTrainsListByTargetBranchFilter original =
                GitLabProjectMergeTrainsListByTargetBranchFilterBuilder.builder()
                        .scope(GitLabProjectMergeTrainsListByTargetBranchScope.ACTIVE)
                        .sort(GitLabProjectMergeTrainsListByTargetBranchSort.ASC)
                        .build();

        final GitLabProjectMergeTrainsListByTargetBranchFilter rebuilt =
                GitLabProjectMergeTrainsListByTargetBranchFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectMergeTrainsListByTargetBranchFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("scope", "sort");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectMergeTrainsListByTargetBranchFilter empty =
                GitLabProjectMergeTrainsListByTargetBranchFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectMergeTrainsListByTargetBranchFilter filter =
                GitLabProjectMergeTrainsListByTargetBranchFilterBuilder.builder()
                        .scope(GitLabProjectMergeTrainsListByTargetBranchScope.ACTIVE)
                        .sort(GitLabProjectMergeTrainsListByTargetBranchSort.ASC)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("scope", "active"), Map.entry("sort", "asc"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectMergeTrainsListByTargetBranchFilter filter =
                GitLabProjectMergeTrainsListByTargetBranchFilterBuilder.builder()
                        .scope(GitLabProjectMergeTrainsListByTargetBranchScope.ACTIVE)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("scope", "active"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectMergeTrainsListByTargetBranchFilter filter =
                GitLabProjectMergeTrainsListByTargetBranchFilterBuilder.builder()
                        .scope(GitLabProjectMergeTrainsListByTargetBranchScope.ACTIVE)
                        .sort(GitLabProjectMergeTrainsListByTargetBranchSort.ASC)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
