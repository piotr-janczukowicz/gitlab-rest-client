package io.github.piotr_janczukowicz.gitlab.api.commits;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectCommitsListStatusesFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabProjectCommitsListStatusesFilterBuilder builder =
                GitLabProjectCommitsListStatusesFilterBuilder.builder(
                                GitLabProjectCommitsListStatusesFilterBuilder.builder()
                                        .ref("ref")
                                        .stage("stage")
                                        .name("name")
                                        .pipelineId(1L)
                                        .all(true)
                                        .orderBy(GitLabProjectCommitsListStatusesOrderBy.ID)
                                        .sort(GitLabProjectCommitsListStatusesSort.ASC)
                                        .build())
                        .ref(null);

        final GitLabProjectCommitsListStatusesFilter built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStageIsNullable() {
        final GitLabProjectCommitsListStatusesFilterBuilder builder =
                GitLabProjectCommitsListStatusesFilterBuilder.builder(
                                GitLabProjectCommitsListStatusesFilterBuilder.builder()
                                        .ref("ref")
                                        .stage("stage")
                                        .name("name")
                                        .pipelineId(1L)
                                        .all(true)
                                        .orderBy(GitLabProjectCommitsListStatusesOrderBy.ID)
                                        .sort(GitLabProjectCommitsListStatusesSort.ASC)
                                        .build())
                        .stage(null);

        final GitLabProjectCommitsListStatusesFilter built = builder.build();

        assertThat(built.stage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectCommitsListStatusesFilterBuilder builder =
                GitLabProjectCommitsListStatusesFilterBuilder.builder(
                                GitLabProjectCommitsListStatusesFilterBuilder.builder()
                                        .ref("ref")
                                        .stage("stage")
                                        .name("name")
                                        .pipelineId(1L)
                                        .all(true)
                                        .orderBy(GitLabProjectCommitsListStatusesOrderBy.ID)
                                        .sort(GitLabProjectCommitsListStatusesSort.ASC)
                                        .build())
                        .name(null);

        final GitLabProjectCommitsListStatusesFilter built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineIdIsNullable() {
        final GitLabProjectCommitsListStatusesFilterBuilder builder =
                GitLabProjectCommitsListStatusesFilterBuilder.builder(
                                GitLabProjectCommitsListStatusesFilterBuilder.builder()
                                        .ref("ref")
                                        .stage("stage")
                                        .name("name")
                                        .pipelineId(1L)
                                        .all(true)
                                        .orderBy(GitLabProjectCommitsListStatusesOrderBy.ID)
                                        .sort(GitLabProjectCommitsListStatusesSort.ASC)
                                        .build())
                        .pipelineId(null);

        final GitLabProjectCommitsListStatusesFilter built = builder.build();

        assertThat(built.pipelineId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllIsNullable() {
        final GitLabProjectCommitsListStatusesFilterBuilder builder =
                GitLabProjectCommitsListStatusesFilterBuilder.builder(
                                GitLabProjectCommitsListStatusesFilterBuilder.builder()
                                        .ref("ref")
                                        .stage("stage")
                                        .name("name")
                                        .pipelineId(1L)
                                        .all(true)
                                        .orderBy(GitLabProjectCommitsListStatusesOrderBy.ID)
                                        .sort(GitLabProjectCommitsListStatusesSort.ASC)
                                        .build())
                        .all(null);

        final GitLabProjectCommitsListStatusesFilter built = builder.build();

        assertThat(built.all()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrderByIsNullable() {
        final GitLabProjectCommitsListStatusesFilterBuilder builder =
                GitLabProjectCommitsListStatusesFilterBuilder.builder(
                                GitLabProjectCommitsListStatusesFilterBuilder.builder()
                                        .ref("ref")
                                        .stage("stage")
                                        .name("name")
                                        .pipelineId(1L)
                                        .all(true)
                                        .orderBy(GitLabProjectCommitsListStatusesOrderBy.ID)
                                        .sort(GitLabProjectCommitsListStatusesSort.ASC)
                                        .build())
                        .orderBy(null);

        final GitLabProjectCommitsListStatusesFilter built = builder.build();

        assertThat(built.orderBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabProjectCommitsListStatusesFilterBuilder builder =
                GitLabProjectCommitsListStatusesFilterBuilder.builder(
                                GitLabProjectCommitsListStatusesFilterBuilder.builder()
                                        .ref("ref")
                                        .stage("stage")
                                        .name("name")
                                        .pipelineId(1L)
                                        .all(true)
                                        .orderBy(GitLabProjectCommitsListStatusesOrderBy.ID)
                                        .sort(GitLabProjectCommitsListStatusesSort.ASC)
                                        .build())
                        .sort(null);

        final GitLabProjectCommitsListStatusesFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectCommitsListStatusesFilter value = GitLabProjectCommitsListStatusesFilterBuilder.builder()
                .ref("ref")
                .stage("stage")
                .name("name")
                .pipelineId(1L)
                .all(true)
                .orderBy(GitLabProjectCommitsListStatusesOrderBy.ID)
                .sort(GitLabProjectCommitsListStatusesSort.ASC)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.ref()).isEqualTo("ref");
            softly.assertThat(value.stage()).isEqualTo("stage");
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.pipelineId()).isEqualTo(1L);
            softly.assertThat(value.all()).isEqualTo(true);
            softly.assertThat(value.orderBy()).isEqualTo(GitLabProjectCommitsListStatusesOrderBy.ID);
            softly.assertThat(value.sort()).isEqualTo(GitLabProjectCommitsListStatusesSort.ASC);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectCommitsListStatusesFilter original = GitLabProjectCommitsListStatusesFilterBuilder.builder()
                .ref("ref")
                .stage("stage")
                .name("name")
                .pipelineId(1L)
                .all(true)
                .orderBy(GitLabProjectCommitsListStatusesOrderBy.ID)
                .sort(GitLabProjectCommitsListStatusesSort.ASC)
                .build();

        final GitLabProjectCommitsListStatusesFilter rebuilt =
                GitLabProjectCommitsListStatusesFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectCommitsListStatusesFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("ref", "stage", "name", "pipelineId", "all", "orderBy", "sort");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectCommitsListStatusesFilter empty = GitLabProjectCommitsListStatusesFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectCommitsListStatusesFilter filter = GitLabProjectCommitsListStatusesFilterBuilder.builder()
                .ref("ref")
                .stage("stage")
                .name("name")
                .pipelineId(1L)
                .all(true)
                .orderBy(GitLabProjectCommitsListStatusesOrderBy.ID)
                .sort(GitLabProjectCommitsListStatusesSort.ASC)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("ref", "ref"),
                        Map.entry("stage", "stage"),
                        Map.entry("name", "name"),
                        Map.entry("pipeline_id", "1"),
                        Map.entry("all", "true"),
                        Map.entry("order_by", "id"),
                        Map.entry("sort", "asc"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectCommitsListStatusesFilter filter = GitLabProjectCommitsListStatusesFilterBuilder.builder()
                .ref("ref")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("ref", "ref"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectCommitsListStatusesFilter filter = GitLabProjectCommitsListStatusesFilterBuilder.builder()
                .ref("ref")
                .stage("stage")
                .name("name")
                .pipelineId(1L)
                .all(true)
                .orderBy(GitLabProjectCommitsListStatusesOrderBy.ID)
                .sort(GitLabProjectCommitsListStatusesSort.ASC)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
