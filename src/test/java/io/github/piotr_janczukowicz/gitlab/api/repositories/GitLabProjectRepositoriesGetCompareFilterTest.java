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
class GitLabProjectRepositoriesGetCompareFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenFromProjectIdIsNullable() {
        final GitLabProjectRepositoriesGetCompareFilterBuilder builder =
                GitLabProjectRepositoriesGetCompareFilterBuilder.builder(
                                GitLabProjectRepositoriesGetCompareFilterBuilder.builder()
                                        .fromProjectId(1L)
                                        .straight(true)
                                        .unidiff(true)
                                        .build())
                        .fromProjectId(null);

        final GitLabProjectRepositoriesGetCompareFilter built = builder.build();

        assertThat(built.fromProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStraightIsNullable() {
        final GitLabProjectRepositoriesGetCompareFilterBuilder builder =
                GitLabProjectRepositoriesGetCompareFilterBuilder.builder(
                                GitLabProjectRepositoriesGetCompareFilterBuilder.builder()
                                        .fromProjectId(1L)
                                        .straight(true)
                                        .unidiff(true)
                                        .build())
                        .straight(null);

        final GitLabProjectRepositoriesGetCompareFilter built = builder.build();

        assertThat(built.straight()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUnidiffIsNullable() {
        final GitLabProjectRepositoriesGetCompareFilterBuilder builder =
                GitLabProjectRepositoriesGetCompareFilterBuilder.builder(
                                GitLabProjectRepositoriesGetCompareFilterBuilder.builder()
                                        .fromProjectId(1L)
                                        .straight(true)
                                        .unidiff(true)
                                        .build())
                        .unidiff(null);

        final GitLabProjectRepositoriesGetCompareFilter built = builder.build();

        assertThat(built.unidiff()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectRepositoriesGetCompareFilter value =
                GitLabProjectRepositoriesGetCompareFilterBuilder.builder()
                        .fromProjectId(1L)
                        .straight(true)
                        .unidiff(true)
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.fromProjectId()).isEqualTo(1L);
            softly.assertThat(value.straight()).isEqualTo(true);
            softly.assertThat(value.unidiff()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectRepositoriesGetCompareFilter original =
                GitLabProjectRepositoriesGetCompareFilterBuilder.builder()
                        .fromProjectId(1L)
                        .straight(true)
                        .unidiff(true)
                        .build();

        final GitLabProjectRepositoriesGetCompareFilter rebuilt =
                GitLabProjectRepositoriesGetCompareFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectRepositoriesGetCompareFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("fromProjectId", "straight", "unidiff");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectRepositoriesGetCompareFilter empty = GitLabProjectRepositoriesGetCompareFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectRepositoriesGetCompareFilter filter =
                GitLabProjectRepositoriesGetCompareFilterBuilder.builder()
                        .fromProjectId(1L)
                        .straight(true)
                        .unidiff(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("from_project_id", "1"), Map.entry("straight", "true"), Map.entry("unidiff", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectRepositoriesGetCompareFilter filter =
                GitLabProjectRepositoriesGetCompareFilterBuilder.builder()
                        .fromProjectId(1L)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("from_project_id", "1"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectRepositoriesGetCompareFilter filter =
                GitLabProjectRepositoriesGetCompareFilterBuilder.builder()
                        .fromProjectId(1L)
                        .straight(true)
                        .unidiff(true)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
