package io.github.piotr_janczukowicz.gitlab.api.todos;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabToDosListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenActionIsNullable() {
        final GitLabToDosListFilterBuilder builder = GitLabToDosListFilterBuilder.builder(
                        GitLabToDosListFilterBuilder.builder()
                                .action(GitLabToDosListAction.ASSIGNED)
                                .authorId(1L)
                                .projectId(1L)
                                .groupId(1L)
                                .state(GitLabToDosListState.PENDING)
                                .type(GitLabToDosListType.COMMIT)
                                .build())
                .action(null);

        final GitLabToDosListFilter built = builder.build();

        assertThat(built.action()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorIdIsNullable() {
        final GitLabToDosListFilterBuilder builder = GitLabToDosListFilterBuilder.builder(
                        GitLabToDosListFilterBuilder.builder()
                                .action(GitLabToDosListAction.ASSIGNED)
                                .authorId(1L)
                                .projectId(1L)
                                .groupId(1L)
                                .state(GitLabToDosListState.PENDING)
                                .type(GitLabToDosListType.COMMIT)
                                .build())
                .authorId(null);

        final GitLabToDosListFilter built = builder.build();

        assertThat(built.authorId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabToDosListFilterBuilder builder = GitLabToDosListFilterBuilder.builder(
                        GitLabToDosListFilterBuilder.builder()
                                .action(GitLabToDosListAction.ASSIGNED)
                                .authorId(1L)
                                .projectId(1L)
                                .groupId(1L)
                                .state(GitLabToDosListState.PENDING)
                                .type(GitLabToDosListType.COMMIT)
                                .build())
                .projectId(null);

        final GitLabToDosListFilter built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdIsNullable() {
        final GitLabToDosListFilterBuilder builder = GitLabToDosListFilterBuilder.builder(
                        GitLabToDosListFilterBuilder.builder()
                                .action(GitLabToDosListAction.ASSIGNED)
                                .authorId(1L)
                                .projectId(1L)
                                .groupId(1L)
                                .state(GitLabToDosListState.PENDING)
                                .type(GitLabToDosListType.COMMIT)
                                .build())
                .groupId(null);

        final GitLabToDosListFilter built = builder.build();

        assertThat(built.groupId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabToDosListFilterBuilder builder = GitLabToDosListFilterBuilder.builder(
                        GitLabToDosListFilterBuilder.builder()
                                .action(GitLabToDosListAction.ASSIGNED)
                                .authorId(1L)
                                .projectId(1L)
                                .groupId(1L)
                                .state(GitLabToDosListState.PENDING)
                                .type(GitLabToDosListType.COMMIT)
                                .build())
                .state(null);

        final GitLabToDosListFilter built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTypeIsNullable() {
        final GitLabToDosListFilterBuilder builder = GitLabToDosListFilterBuilder.builder(
                        GitLabToDosListFilterBuilder.builder()
                                .action(GitLabToDosListAction.ASSIGNED)
                                .authorId(1L)
                                .projectId(1L)
                                .groupId(1L)
                                .state(GitLabToDosListState.PENDING)
                                .type(GitLabToDosListType.COMMIT)
                                .build())
                .type(null);

        final GitLabToDosListFilter built = builder.build();

        assertThat(built.type()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabToDosListFilter value = GitLabToDosListFilterBuilder.builder()
                .action(GitLabToDosListAction.ASSIGNED)
                .authorId(1L)
                .projectId(1L)
                .groupId(1L)
                .state(GitLabToDosListState.PENDING)
                .type(GitLabToDosListType.COMMIT)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.action()).isEqualTo(GitLabToDosListAction.ASSIGNED);
            softly.assertThat(value.authorId()).isEqualTo(1L);
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.groupId()).isEqualTo(1L);
            softly.assertThat(value.state()).isEqualTo(GitLabToDosListState.PENDING);
            softly.assertThat(value.type()).isEqualTo(GitLabToDosListType.COMMIT);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabToDosListFilter original = GitLabToDosListFilterBuilder.builder()
                .action(GitLabToDosListAction.ASSIGNED)
                .authorId(1L)
                .projectId(1L)
                .groupId(1L)
                .state(GitLabToDosListState.PENDING)
                .type(GitLabToDosListType.COMMIT)
                .build();

        final GitLabToDosListFilter rebuilt =
                GitLabToDosListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabToDosListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("action", "authorId", "projectId", "groupId", "state", "type");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabToDosListFilter empty = GitLabToDosListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabToDosListFilter filter = GitLabToDosListFilterBuilder.builder()
                .action(GitLabToDosListAction.ASSIGNED)
                .authorId(1L)
                .projectId(1L)
                .groupId(1L)
                .state(GitLabToDosListState.PENDING)
                .type(GitLabToDosListType.COMMIT)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("action", "assigned"),
                        Map.entry("author_id", "1"),
                        Map.entry("project_id", "1"),
                        Map.entry("group_id", "1"),
                        Map.entry("state", "pending"),
                        Map.entry("type", "Commit"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabToDosListFilter filter = GitLabToDosListFilterBuilder.builder()
                .action(GitLabToDosListAction.ASSIGNED)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("action", "assigned"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabToDosListFilter filter = GitLabToDosListFilterBuilder.builder()
                .action(GitLabToDosListAction.ASSIGNED)
                .authorId(1L)
                .projectId(1L)
                .groupId(1L)
                .state(GitLabToDosListState.PENDING)
                .type(GitLabToDosListType.COMMIT)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
