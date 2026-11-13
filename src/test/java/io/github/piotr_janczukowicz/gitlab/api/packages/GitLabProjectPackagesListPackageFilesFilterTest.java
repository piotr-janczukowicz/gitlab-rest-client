package io.github.piotr_janczukowicz.gitlab.api.packages;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectPackagesListPackageFilesFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenOrderByIsNullable() {
        final GitLabProjectPackagesListPackageFilesFilterBuilder builder =
                GitLabProjectPackagesListPackageFilesFilterBuilder.builder(
                                GitLabProjectPackagesListPackageFilesFilterBuilder.builder()
                                        .orderBy(GitLabProjectPackagesListPackageFilesOrderBy.ID)
                                        .sort(GitLabProjectPackagesListPackageFilesSort.ASC)
                                        .build())
                        .orderBy(null);

        final GitLabProjectPackagesListPackageFilesFilter built = builder.build();

        assertThat(built.orderBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabProjectPackagesListPackageFilesFilterBuilder builder =
                GitLabProjectPackagesListPackageFilesFilterBuilder.builder(
                                GitLabProjectPackagesListPackageFilesFilterBuilder.builder()
                                        .orderBy(GitLabProjectPackagesListPackageFilesOrderBy.ID)
                                        .sort(GitLabProjectPackagesListPackageFilesSort.ASC)
                                        .build())
                        .sort(null);

        final GitLabProjectPackagesListPackageFilesFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectPackagesListPackageFilesFilter value =
                GitLabProjectPackagesListPackageFilesFilterBuilder.builder()
                        .orderBy(GitLabProjectPackagesListPackageFilesOrderBy.ID)
                        .sort(GitLabProjectPackagesListPackageFilesSort.ASC)
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.orderBy()).isEqualTo(GitLabProjectPackagesListPackageFilesOrderBy.ID);
            softly.assertThat(value.sort()).isEqualTo(GitLabProjectPackagesListPackageFilesSort.ASC);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectPackagesListPackageFilesFilter original =
                GitLabProjectPackagesListPackageFilesFilterBuilder.builder()
                        .orderBy(GitLabProjectPackagesListPackageFilesOrderBy.ID)
                        .sort(GitLabProjectPackagesListPackageFilesSort.ASC)
                        .build();

        final GitLabProjectPackagesListPackageFilesFilter rebuilt =
                GitLabProjectPackagesListPackageFilesFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectPackagesListPackageFilesFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("orderBy", "sort");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectPackagesListPackageFilesFilter empty = GitLabProjectPackagesListPackageFilesFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectPackagesListPackageFilesFilter filter =
                GitLabProjectPackagesListPackageFilesFilterBuilder.builder()
                        .orderBy(GitLabProjectPackagesListPackageFilesOrderBy.ID)
                        .sort(GitLabProjectPackagesListPackageFilesSort.ASC)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("order_by", "id"), Map.entry("sort", "asc"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectPackagesListPackageFilesFilter filter =
                GitLabProjectPackagesListPackageFilesFilterBuilder.builder()
                        .orderBy(GitLabProjectPackagesListPackageFilesOrderBy.ID)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("order_by", "id"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectPackagesListPackageFilesFilter filter =
                GitLabProjectPackagesListPackageFilesFilterBuilder.builder()
                        .orderBy(GitLabProjectPackagesListPackageFilesOrderBy.ID)
                        .sort(GitLabProjectPackagesListPackageFilesSort.ASC)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
