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
class GitLabGroupMembersListAllFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenQueryIsNullable() {
        final GitLabGroupMembersListAllFilterBuilder builder = GitLabGroupMembersListAllFilterBuilder.builder(
                        GitLabGroupMembersListAllFilterBuilder.builder()
                                .query("query")
                                .userIds(List.of(1L))
                                .showSeatInfo(true)
                                .state(GitLabGroupMembersListAllState.AWAITING)
                                .build())
                .query(null);

        final GitLabGroupMembersListAllFilter built = builder.build();

        assertThat(built.query()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdsIsNullable() {
        final GitLabGroupMembersListAllFilterBuilder builder = GitLabGroupMembersListAllFilterBuilder.builder(
                        GitLabGroupMembersListAllFilterBuilder.builder()
                                .query("query")
                                .userIds(List.of(1L))
                                .showSeatInfo(true)
                                .state(GitLabGroupMembersListAllState.AWAITING)
                                .build())
                .userIds(null);

        final GitLabGroupMembersListAllFilter built = builder.build();

        assertThat(built.userIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShowSeatInfoIsNullable() {
        final GitLabGroupMembersListAllFilterBuilder builder = GitLabGroupMembersListAllFilterBuilder.builder(
                        GitLabGroupMembersListAllFilterBuilder.builder()
                                .query("query")
                                .userIds(List.of(1L))
                                .showSeatInfo(true)
                                .state(GitLabGroupMembersListAllState.AWAITING)
                                .build())
                .showSeatInfo(null);

        final GitLabGroupMembersListAllFilter built = builder.build();

        assertThat(built.showSeatInfo()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabGroupMembersListAllFilterBuilder builder = GitLabGroupMembersListAllFilterBuilder.builder(
                        GitLabGroupMembersListAllFilterBuilder.builder()
                                .query("query")
                                .userIds(List.of(1L))
                                .showSeatInfo(true)
                                .state(GitLabGroupMembersListAllState.AWAITING)
                                .build())
                .state(null);

        final GitLabGroupMembersListAllFilter built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupMembersListAllFilter value = GitLabGroupMembersListAllFilterBuilder.builder()
                .query("query")
                .userIds(List.of(1L))
                .showSeatInfo(true)
                .state(GitLabGroupMembersListAllState.AWAITING)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.query()).isEqualTo("query");
            softly.assertThat(value.userIds()).isEqualTo(List.of(1L));
            softly.assertThat(value.showSeatInfo()).isEqualTo(true);
            softly.assertThat(value.state()).isEqualTo(GitLabGroupMembersListAllState.AWAITING);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupMembersListAllFilter original = GitLabGroupMembersListAllFilterBuilder.builder()
                .query("query")
                .userIds(List.of(1L))
                .showSeatInfo(true)
                .state(GitLabGroupMembersListAllState.AWAITING)
                .build();

        final GitLabGroupMembersListAllFilter rebuilt =
                GitLabGroupMembersListAllFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenUserIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabGroupMembersListAllFilter built = GitLabGroupMembersListAllFilterBuilder.builder(
                        GitLabGroupMembersListAllFilterBuilder.builder()
                                .query("query")
                                .userIds(List.of(1L))
                                .showSeatInfo(true)
                                .state(GitLabGroupMembersListAllState.AWAITING)
                                .build())
                .userIds(source)
                .build();
        source.clear();

        assertThat(built.userIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenUserIdsIsRead() {
        final GitLabGroupMembersListAllFilter built = GitLabGroupMembersListAllFilterBuilder.builder()
                .query("query")
                .userIds(List.of(1L))
                .showSeatInfo(true)
                .state(GitLabGroupMembersListAllState.AWAITING)
                .build();
        final List<Long> values = built.userIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupMembersListAllFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("query", "userIds", "showSeatInfo", "state");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupMembersListAllFilter empty = GitLabGroupMembersListAllFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupMembersListAllFilter filter = GitLabGroupMembersListAllFilterBuilder.builder()
                .query("query")
                .userIds(List.of(1L))
                .showSeatInfo(true)
                .state(GitLabGroupMembersListAllState.AWAITING)
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
        final GitLabGroupMembersListAllFilter filter =
                GitLabGroupMembersListAllFilterBuilder.builder().query("query").build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("query", "query"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupMembersListAllFilter filter = GitLabGroupMembersListAllFilterBuilder.builder()
                .query("query")
                .userIds(List.of(1L))
                .showSeatInfo(true)
                .state(GitLabGroupMembersListAllState.AWAITING)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
