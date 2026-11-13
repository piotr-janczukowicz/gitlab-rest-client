package io.github.piotr_janczukowicz.gitlab.api.tags;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectTagsListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabProjectTagsListFilterBuilder builder = GitLabProjectTagsListFilterBuilder.builder(
                        GitLabProjectTagsListFilterBuilder.builder()
                                .sort(GitLabProjectTagsListSort.ASC)
                                .orderBy(GitLabProjectTagsListOrderBy.NAME)
                                .search("search")
                                .pageToken("page_token")
                                .build())
                .sort(null);

        final GitLabProjectTagsListFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrderByIsNullable() {
        final GitLabProjectTagsListFilterBuilder builder = GitLabProjectTagsListFilterBuilder.builder(
                        GitLabProjectTagsListFilterBuilder.builder()
                                .sort(GitLabProjectTagsListSort.ASC)
                                .orderBy(GitLabProjectTagsListOrderBy.NAME)
                                .search("search")
                                .pageToken("page_token")
                                .build())
                .orderBy(null);

        final GitLabProjectTagsListFilter built = builder.build();

        assertThat(built.orderBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabProjectTagsListFilterBuilder builder = GitLabProjectTagsListFilterBuilder.builder(
                        GitLabProjectTagsListFilterBuilder.builder()
                                .sort(GitLabProjectTagsListSort.ASC)
                                .orderBy(GitLabProjectTagsListOrderBy.NAME)
                                .search("search")
                                .pageToken("page_token")
                                .build())
                .search(null);

        final GitLabProjectTagsListFilter built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPageTokenIsNullable() {
        final GitLabProjectTagsListFilterBuilder builder = GitLabProjectTagsListFilterBuilder.builder(
                        GitLabProjectTagsListFilterBuilder.builder()
                                .sort(GitLabProjectTagsListSort.ASC)
                                .orderBy(GitLabProjectTagsListOrderBy.NAME)
                                .search("search")
                                .pageToken("page_token")
                                .build())
                .pageToken(null);

        final GitLabProjectTagsListFilter built = builder.build();

        assertThat(built.pageToken()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectTagsListFilter value = GitLabProjectTagsListFilterBuilder.builder()
                .sort(GitLabProjectTagsListSort.ASC)
                .orderBy(GitLabProjectTagsListOrderBy.NAME)
                .search("search")
                .pageToken("page_token")
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.sort()).isEqualTo(GitLabProjectTagsListSort.ASC);
            softly.assertThat(value.orderBy()).isEqualTo(GitLabProjectTagsListOrderBy.NAME);
            softly.assertThat(value.search()).isEqualTo("search");
            softly.assertThat(value.pageToken()).isEqualTo("page_token");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectTagsListFilter original = GitLabProjectTagsListFilterBuilder.builder()
                .sort(GitLabProjectTagsListSort.ASC)
                .orderBy(GitLabProjectTagsListOrderBy.NAME)
                .search("search")
                .pageToken("page_token")
                .build();

        final GitLabProjectTagsListFilter rebuilt =
                GitLabProjectTagsListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenPageTokenIsACredential() {
        final GitLabProjectTagsListFilter value = GitLabProjectTagsListFilterBuilder.builder()
                .sort(GitLabProjectTagsListSort.ASC)
                .orderBy(GitLabProjectTagsListOrderBy.NAME)
                .search("search")
                .pageToken("page_token")
                .build();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectTagsListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("sort", "orderBy", "search", "pageToken");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectTagsListFilter empty = GitLabProjectTagsListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectTagsListFilter filter = GitLabProjectTagsListFilterBuilder.builder()
                .sort(GitLabProjectTagsListSort.ASC)
                .orderBy(GitLabProjectTagsListOrderBy.NAME)
                .search("search")
                .pageToken("page_token")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("sort", "asc"),
                        Map.entry("order_by", "name"),
                        Map.entry("search", "search"),
                        Map.entry("page_token", "page_token"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectTagsListFilter filter = GitLabProjectTagsListFilterBuilder.builder()
                .sort(GitLabProjectTagsListSort.ASC)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("sort", "asc"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectTagsListFilter filter = GitLabProjectTagsListFilterBuilder.builder()
                .sort(GitLabProjectTagsListSort.ASC)
                .orderBy(GitLabProjectTagsListOrderBy.NAME)
                .search("search")
                .pageToken("page_token")
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
