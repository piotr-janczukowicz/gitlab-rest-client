package io.github.piotr_janczukowicz.gitlab.api.members;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectMembersListAllFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenQueryIsNullable() {
        final GitLabProjectMembersListAllFilterBuilder builder = GitLabProjectMembersListAllFilterBuilder.builder(
                        GitLabProjectMembersListAllFilterBuilder.builder()
                                .query("query")
                                .userIds(List.of(1L))
                                .showSeatInfo(true)
                                .state(GitLabProjectMembersListAllState.AWAITING)
                                .build())
                .query(null);

        final GitLabProjectMembersListAllFilter built = builder.build();

        assertThat(built.query()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdsIsNullable() {
        final GitLabProjectMembersListAllFilterBuilder builder = GitLabProjectMembersListAllFilterBuilder.builder(
                        GitLabProjectMembersListAllFilterBuilder.builder()
                                .query("query")
                                .userIds(List.of(1L))
                                .showSeatInfo(true)
                                .state(GitLabProjectMembersListAllState.AWAITING)
                                .build())
                .userIds(null);

        final GitLabProjectMembersListAllFilter built = builder.build();

        assertThat(built.userIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShowSeatInfoIsNullable() {
        final GitLabProjectMembersListAllFilterBuilder builder = GitLabProjectMembersListAllFilterBuilder.builder(
                        GitLabProjectMembersListAllFilterBuilder.builder()
                                .query("query")
                                .userIds(List.of(1L))
                                .showSeatInfo(true)
                                .state(GitLabProjectMembersListAllState.AWAITING)
                                .build())
                .showSeatInfo(null);

        final GitLabProjectMembersListAllFilter built = builder.build();

        assertThat(built.showSeatInfo()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabProjectMembersListAllFilterBuilder builder = GitLabProjectMembersListAllFilterBuilder.builder(
                        GitLabProjectMembersListAllFilterBuilder.builder()
                                .query("query")
                                .userIds(List.of(1L))
                                .showSeatInfo(true)
                                .state(GitLabProjectMembersListAllState.AWAITING)
                                .build())
                .state(null);

        final GitLabProjectMembersListAllFilter built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectMembersListAllFilter value = GitLabProjectMembersListAllFilterBuilder.builder()
                .query("query")
                .userIds(List.of(1L))
                .showSeatInfo(true)
                .state(GitLabProjectMembersListAllState.AWAITING)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.query()).isEqualTo("query");
            softly.assertThat(value.userIds()).isEqualTo(List.of(1L));
            softly.assertThat(value.showSeatInfo()).isEqualTo(true);
            softly.assertThat(value.state()).isEqualTo(GitLabProjectMembersListAllState.AWAITING);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectMembersListAllFilter original = GitLabProjectMembersListAllFilterBuilder.builder()
                .query("query")
                .userIds(List.of(1L))
                .showSeatInfo(true)
                .state(GitLabProjectMembersListAllState.AWAITING)
                .build();

        final GitLabProjectMembersListAllFilter rebuilt =
                GitLabProjectMembersListAllFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenUserIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabProjectMembersListAllFilter built = GitLabProjectMembersListAllFilterBuilder.builder(
                        GitLabProjectMembersListAllFilterBuilder.builder()
                                .query("query")
                                .userIds(List.of(1L))
                                .showSeatInfo(true)
                                .state(GitLabProjectMembersListAllState.AWAITING)
                                .build())
                .userIds(source)
                .build();
        source.clear();

        assertThat(built.userIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenUserIdsIsRead() {
        final GitLabProjectMembersListAllFilter built = GitLabProjectMembersListAllFilterBuilder.builder()
                .query("query")
                .userIds(List.of(1L))
                .showSeatInfo(true)
                .state(GitLabProjectMembersListAllState.AWAITING)
                .build();
        final List<Long> values = built.userIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectMembersListAllFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("query", "userIds", "showSeatInfo", "state");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectMembersListAllFilter empty = GitLabProjectMembersListAllFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectMembersListAllFilter filter = GitLabProjectMembersListAllFilterBuilder.builder()
                .query("query")
                .userIds(List.of(1L))
                .showSeatInfo(true)
                .state(GitLabProjectMembersListAllState.AWAITING)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("query", "query"),
                        Map.entry("user_ids", "1"),
                        Map.entry("show_seat_info", "true"),
                        Map.entry("state", "awaiting"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectMembersListAllFilter filter = GitLabProjectMembersListAllFilterBuilder.builder()
                .query("query")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("query", "query"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectMembersListAllFilter filter = GitLabProjectMembersListAllFilterBuilder.builder()
                .query("query")
                .userIds(List.of(1L))
                .showSeatInfo(true)
                .state(GitLabProjectMembersListAllState.AWAITING)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
