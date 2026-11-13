package io.github.piotr_janczukowicz.gitlab.api.branches;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectBranchesListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabProjectBranchesListFilterBuilder builder = GitLabProjectBranchesListFilterBuilder.builder(
                        GitLabProjectBranchesListFilterBuilder.builder()
                                .search("search")
                                .regex("regex")
                                .sort(GitLabProjectBranchesListSort.NAME_ASC)
                                .pageToken("page_token")
                                .build())
                .search(null);

        final GitLabProjectBranchesListFilter built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRegexIsNullable() {
        final GitLabProjectBranchesListFilterBuilder builder = GitLabProjectBranchesListFilterBuilder.builder(
                        GitLabProjectBranchesListFilterBuilder.builder()
                                .search("search")
                                .regex("regex")
                                .sort(GitLabProjectBranchesListSort.NAME_ASC)
                                .pageToken("page_token")
                                .build())
                .regex(null);

        final GitLabProjectBranchesListFilter built = builder.build();

        assertThat(built.regex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabProjectBranchesListFilterBuilder builder = GitLabProjectBranchesListFilterBuilder.builder(
                        GitLabProjectBranchesListFilterBuilder.builder()
                                .search("search")
                                .regex("regex")
                                .sort(GitLabProjectBranchesListSort.NAME_ASC)
                                .pageToken("page_token")
                                .build())
                .sort(null);

        final GitLabProjectBranchesListFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPageTokenIsNullable() {
        final GitLabProjectBranchesListFilterBuilder builder = GitLabProjectBranchesListFilterBuilder.builder(
                        GitLabProjectBranchesListFilterBuilder.builder()
                                .search("search")
                                .regex("regex")
                                .sort(GitLabProjectBranchesListSort.NAME_ASC)
                                .pageToken("page_token")
                                .build())
                .pageToken(null);

        final GitLabProjectBranchesListFilter built = builder.build();

        assertThat(built.pageToken()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectBranchesListFilter value = GitLabProjectBranchesListFilterBuilder.builder()
                .search("search")
                .regex("regex")
                .sort(GitLabProjectBranchesListSort.NAME_ASC)
                .pageToken("page_token")
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.search()).isEqualTo("search");
            softly.assertThat(value.regex()).isEqualTo("regex");
            softly.assertThat(value.sort()).isEqualTo(GitLabProjectBranchesListSort.NAME_ASC);
            softly.assertThat(value.pageToken()).isEqualTo("page_token");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectBranchesListFilter original = GitLabProjectBranchesListFilterBuilder.builder()
                .search("search")
                .regex("regex")
                .sort(GitLabProjectBranchesListSort.NAME_ASC)
                .pageToken("page_token")
                .build();

        final GitLabProjectBranchesListFilter rebuilt =
                GitLabProjectBranchesListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenPageTokenIsACredential() {
        final GitLabProjectBranchesListFilter value = GitLabProjectBranchesListFilterBuilder.builder()
                .search("search")
                .regex("regex")
                .sort(GitLabProjectBranchesListSort.NAME_ASC)
                .pageToken("page_token")
                .build();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectBranchesListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("search", "regex", "sort", "pageToken");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectBranchesListFilter empty = GitLabProjectBranchesListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectBranchesListFilter filter = GitLabProjectBranchesListFilterBuilder.builder()
                .search("search")
                .regex("regex")
                .sort(GitLabProjectBranchesListSort.NAME_ASC)
                .pageToken("page_token")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("search", "search"),
                        Map.entry("regex", "regex"),
                        Map.entry("sort", "name_asc"),
                        Map.entry("page_token", "page_token"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectBranchesListFilter filter = GitLabProjectBranchesListFilterBuilder.builder()
                .search("search")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("search", "search"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectBranchesListFilter filter = GitLabProjectBranchesListFilterBuilder.builder()
                .search("search")
                .regex("regex")
                .sort(GitLabProjectBranchesListSort.NAME_ASC)
                .pageToken("page_token")
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
