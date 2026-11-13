package io.github.piotr_janczukowicz.gitlab.api.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectRepositoriesListContributorsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabProjectRepositoriesListContributorsFilterBuilder builder =
                GitLabProjectRepositoriesListContributorsFilterBuilder.builder(
                                GitLabProjectRepositoriesListContributorsFilterBuilder.builder()
                                        .ref("ref")
                                        .orderBy(GitLabProjectRepositoriesListContributorsOrderBy.EMAIL)
                                        .sort(GitLabProjectRepositoriesListContributorsSort.ASC)
                                        .build())
                        .ref(null);

        final GitLabProjectRepositoriesListContributorsFilter built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrderByIsNullable() {
        final GitLabProjectRepositoriesListContributorsFilterBuilder builder =
                GitLabProjectRepositoriesListContributorsFilterBuilder.builder(
                                GitLabProjectRepositoriesListContributorsFilterBuilder.builder()
                                        .ref("ref")
                                        .orderBy(GitLabProjectRepositoriesListContributorsOrderBy.EMAIL)
                                        .sort(GitLabProjectRepositoriesListContributorsSort.ASC)
                                        .build())
                        .orderBy(null);

        final GitLabProjectRepositoriesListContributorsFilter built = builder.build();

        assertThat(built.orderBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabProjectRepositoriesListContributorsFilterBuilder builder =
                GitLabProjectRepositoriesListContributorsFilterBuilder.builder(
                                GitLabProjectRepositoriesListContributorsFilterBuilder.builder()
                                        .ref("ref")
                                        .orderBy(GitLabProjectRepositoriesListContributorsOrderBy.EMAIL)
                                        .sort(GitLabProjectRepositoriesListContributorsSort.ASC)
                                        .build())
                        .sort(null);

        final GitLabProjectRepositoriesListContributorsFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectRepositoriesListContributorsFilter value =
                GitLabProjectRepositoriesListContributorsFilterBuilder.builder()
                        .ref("ref")
                        .orderBy(GitLabProjectRepositoriesListContributorsOrderBy.EMAIL)
                        .sort(GitLabProjectRepositoriesListContributorsSort.ASC)
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.ref()).isEqualTo("ref");
            softly.assertThat(value.orderBy()).isEqualTo(GitLabProjectRepositoriesListContributorsOrderBy.EMAIL);
            softly.assertThat(value.sort()).isEqualTo(GitLabProjectRepositoriesListContributorsSort.ASC);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectRepositoriesListContributorsFilter original =
                GitLabProjectRepositoriesListContributorsFilterBuilder.builder()
                        .ref("ref")
                        .orderBy(GitLabProjectRepositoriesListContributorsOrderBy.EMAIL)
                        .sort(GitLabProjectRepositoriesListContributorsSort.ASC)
                        .build();

        final GitLabProjectRepositoriesListContributorsFilter rebuilt =
                GitLabProjectRepositoriesListContributorsFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectRepositoriesListContributorsFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("ref", "orderBy", "sort");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectRepositoriesListContributorsFilter empty =
                GitLabProjectRepositoriesListContributorsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectRepositoriesListContributorsFilter filter =
                GitLabProjectRepositoriesListContributorsFilterBuilder.builder()
                        .ref("ref")
                        .orderBy(GitLabProjectRepositoriesListContributorsOrderBy.EMAIL)
                        .sort(GitLabProjectRepositoriesListContributorsSort.ASC)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(Map.entry("ref", "ref"), Map.entry("order_by", "email"), Map.entry("sort", "asc"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectRepositoriesListContributorsFilter filter =
                GitLabProjectRepositoriesListContributorsFilterBuilder.builder()
                        .ref("ref")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("ref", "ref"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectRepositoriesListContributorsFilter filter =
                GitLabProjectRepositoriesListContributorsFilterBuilder.builder()
                        .ref("ref")
                        .orderBy(GitLabProjectRepositoriesListContributorsOrderBy.EMAIL)
                        .sort(GitLabProjectRepositoriesListContributorsSort.ASC)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
