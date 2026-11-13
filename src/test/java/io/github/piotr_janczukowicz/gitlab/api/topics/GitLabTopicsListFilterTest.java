package io.github.piotr_janczukowicz.gitlab.api.topics;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabTopicsListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabTopicsListFilterBuilder builder = GitLabTopicsListFilterBuilder.builder(
                        GitLabTopicsListFilterBuilder.builder()
                                .search("search")
                                .withoutProjects(true)
                                .organizationId(1L)
                                .build())
                .search(null);

        final GitLabTopicsListFilter built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithoutProjectsIsNullable() {
        final GitLabTopicsListFilterBuilder builder = GitLabTopicsListFilterBuilder.builder(
                        GitLabTopicsListFilterBuilder.builder()
                                .search("search")
                                .withoutProjects(true)
                                .organizationId(1L)
                                .build())
                .withoutProjects(null);

        final GitLabTopicsListFilter built = builder.build();

        assertThat(built.withoutProjects()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrganizationIdIsNullable() {
        final GitLabTopicsListFilterBuilder builder = GitLabTopicsListFilterBuilder.builder(
                        GitLabTopicsListFilterBuilder.builder()
                                .search("search")
                                .withoutProjects(true)
                                .organizationId(1L)
                                .build())
                .organizationId(null);

        final GitLabTopicsListFilter built = builder.build();

        assertThat(built.organizationId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabTopicsListFilter value = GitLabTopicsListFilterBuilder.builder()
                .search("search")
                .withoutProjects(true)
                .organizationId(1L)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.search()).isEqualTo("search");
            softly.assertThat(value.withoutProjects()).isEqualTo(true);
            softly.assertThat(value.organizationId()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabTopicsListFilter original = GitLabTopicsListFilterBuilder.builder()
                .search("search")
                .withoutProjects(true)
                .organizationId(1L)
                .build();

        final GitLabTopicsListFilter rebuilt =
                GitLabTopicsListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabTopicsListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("search", "withoutProjects", "organizationId");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabTopicsListFilter empty = GitLabTopicsListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabTopicsListFilter filter = GitLabTopicsListFilterBuilder.builder()
                .search("search")
                .withoutProjects(true)
                .organizationId(1L)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("search", "search"),
                        Map.entry("without_projects", "true"),
                        Map.entry("organization_id", "1"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabTopicsListFilter filter =
                GitLabTopicsListFilterBuilder.builder().search("search").build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("search", "search"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabTopicsListFilter filter = GitLabTopicsListFilterBuilder.builder()
                .search("search")
                .withoutProjects(true)
                .organizationId(1L)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
