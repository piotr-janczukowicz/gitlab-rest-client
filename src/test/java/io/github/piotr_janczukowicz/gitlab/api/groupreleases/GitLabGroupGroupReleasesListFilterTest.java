package io.github.piotr_janczukowicz.gitlab.api.groupreleases;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupReleasesListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabGroupGroupReleasesListFilterBuilder builder = GitLabGroupGroupReleasesListFilterBuilder.builder(
                        GitLabGroupGroupReleasesListFilterBuilder.builder()
                                .sort(GitLabGroupGroupReleasesListSort.ASC)
                                .simple(true)
                                .build())
                .sort(null);

        final GitLabGroupGroupReleasesListFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSimpleIsNullable() {
        final GitLabGroupGroupReleasesListFilterBuilder builder = GitLabGroupGroupReleasesListFilterBuilder.builder(
                        GitLabGroupGroupReleasesListFilterBuilder.builder()
                                .sort(GitLabGroupGroupReleasesListSort.ASC)
                                .simple(true)
                                .build())
                .simple(null);

        final GitLabGroupGroupReleasesListFilter built = builder.build();

        assertThat(built.simple()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupReleasesListFilter value = GitLabGroupGroupReleasesListFilterBuilder.builder()
                .sort(GitLabGroupGroupReleasesListSort.ASC)
                .simple(true)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.sort()).isEqualTo(GitLabGroupGroupReleasesListSort.ASC);
            softly.assertThat(value.simple()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupReleasesListFilter original = GitLabGroupGroupReleasesListFilterBuilder.builder()
                .sort(GitLabGroupGroupReleasesListSort.ASC)
                .simple(true)
                .build();

        final GitLabGroupGroupReleasesListFilter rebuilt =
                GitLabGroupGroupReleasesListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupReleasesListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("sort", "simple");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupGroupReleasesListFilter empty = GitLabGroupGroupReleasesListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupGroupReleasesListFilter filter = GitLabGroupGroupReleasesListFilterBuilder.builder()
                .sort(GitLabGroupGroupReleasesListSort.ASC)
                .simple(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("sort", "asc"), Map.entry("simple", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupGroupReleasesListFilter filter = GitLabGroupGroupReleasesListFilterBuilder.builder()
                .sort(GitLabGroupGroupReleasesListSort.ASC)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("sort", "asc"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupGroupReleasesListFilter filter = GitLabGroupGroupReleasesListFilterBuilder.builder()
                .sort(GitLabGroupGroupReleasesListSort.ASC)
                .simple(true)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
