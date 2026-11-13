package io.github.piotr_janczukowicz.gitlab.api.projectstarring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectStarringListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabProjectProjectStarringListFilterBuilder builder =
                GitLabProjectProjectStarringListFilterBuilder.builder(
                                GitLabProjectProjectStarringListFilterBuilder.builder()
                                        .search("search")
                                        .build())
                        .search(null);

        final GitLabProjectProjectStarringListFilter built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectStarringListFilter value = GitLabProjectProjectStarringListFilterBuilder.builder()
                .search("search")
                .build();

        assertThat(value.search()).isEqualTo("search");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectStarringListFilter original = GitLabProjectProjectStarringListFilterBuilder.builder()
                .search("search")
                .build();

        final GitLabProjectProjectStarringListFilter rebuilt =
                GitLabProjectProjectStarringListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectStarringListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("search");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectProjectStarringListFilter empty = GitLabProjectProjectStarringListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectProjectStarringListFilter filter = GitLabProjectProjectStarringListFilterBuilder.builder()
                .search("search")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("search", "search"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectProjectStarringListFilter filter = GitLabProjectProjectStarringListFilterBuilder.builder()
                .search("search")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("search", "search"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectProjectStarringListFilter filter = GitLabProjectProjectStarringListFilterBuilder.builder()
                .search("search")
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
