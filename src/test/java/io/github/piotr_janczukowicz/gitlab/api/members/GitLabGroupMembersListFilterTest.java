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
class GitLabGroupMembersListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenQueryIsNullable() {
        final GitLabGroupMembersListFilterBuilder builder = GitLabGroupMembersListFilterBuilder.builder(
                        GitLabGroupMembersListFilterBuilder.builder()
                                .query("query")
                                .userIds(List.of(1L))
                                .skipUsers(List.of(1))
                                .showSeatInfo(true)
                                .withSamlIdentity(true)
                                .build())
                .query(null);

        final GitLabGroupMembersListFilter built = builder.build();

        assertThat(built.query()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIdsIsNullable() {
        final GitLabGroupMembersListFilterBuilder builder = GitLabGroupMembersListFilterBuilder.builder(
                        GitLabGroupMembersListFilterBuilder.builder()
                                .query("query")
                                .userIds(List.of(1L))
                                .skipUsers(List.of(1))
                                .showSeatInfo(true)
                                .withSamlIdentity(true)
                                .build())
                .userIds(null);

        final GitLabGroupMembersListFilter built = builder.build();

        assertThat(built.userIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSkipUsersIsNullable() {
        final GitLabGroupMembersListFilterBuilder builder = GitLabGroupMembersListFilterBuilder.builder(
                        GitLabGroupMembersListFilterBuilder.builder()
                                .query("query")
                                .userIds(List.of(1L))
                                .skipUsers(List.of(1))
                                .showSeatInfo(true)
                                .withSamlIdentity(true)
                                .build())
                .skipUsers(null);

        final GitLabGroupMembersListFilter built = builder.build();

        assertThat(built.skipUsers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShowSeatInfoIsNullable() {
        final GitLabGroupMembersListFilterBuilder builder = GitLabGroupMembersListFilterBuilder.builder(
                        GitLabGroupMembersListFilterBuilder.builder()
                                .query("query")
                                .userIds(List.of(1L))
                                .skipUsers(List.of(1))
                                .showSeatInfo(true)
                                .withSamlIdentity(true)
                                .build())
                .showSeatInfo(null);

        final GitLabGroupMembersListFilter built = builder.build();

        assertThat(built.showSeatInfo()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithSamlIdentityIsNullable() {
        final GitLabGroupMembersListFilterBuilder builder = GitLabGroupMembersListFilterBuilder.builder(
                        GitLabGroupMembersListFilterBuilder.builder()
                                .query("query")
                                .userIds(List.of(1L))
                                .skipUsers(List.of(1))
                                .showSeatInfo(true)
                                .withSamlIdentity(true)
                                .build())
                .withSamlIdentity(null);

        final GitLabGroupMembersListFilter built = builder.build();

        assertThat(built.withSamlIdentity()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupMembersListFilter value = GitLabGroupMembersListFilterBuilder.builder()
                .query("query")
                .userIds(List.of(1L))
                .skipUsers(List.of(1))
                .showSeatInfo(true)
                .withSamlIdentity(true)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.query()).isEqualTo("query");
            softly.assertThat(value.userIds()).isEqualTo(List.of(1L));
            softly.assertThat(value.skipUsers()).isEqualTo(List.of(1));
            softly.assertThat(value.showSeatInfo()).isEqualTo(true);
            softly.assertThat(value.withSamlIdentity()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupMembersListFilter original = GitLabGroupMembersListFilterBuilder.builder()
                .query("query")
                .userIds(List.of(1L))
                .skipUsers(List.of(1))
                .showSeatInfo(true)
                .withSamlIdentity(true)
                .build();

        final GitLabGroupMembersListFilter rebuilt =
                GitLabGroupMembersListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenUserIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabGroupMembersListFilter built = GitLabGroupMembersListFilterBuilder.builder(
                        GitLabGroupMembersListFilterBuilder.builder()
                                .query("query")
                                .userIds(List.of(1L))
                                .skipUsers(List.of(1))
                                .showSeatInfo(true)
                                .withSamlIdentity(true)
                                .build())
                .userIds(source)
                .build();
        source.clear();

        assertThat(built.userIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenUserIdsIsRead() {
        final GitLabGroupMembersListFilter built = GitLabGroupMembersListFilterBuilder.builder()
                .query("query")
                .userIds(List.of(1L))
                .skipUsers(List.of(1))
                .showSeatInfo(true)
                .withSamlIdentity(true)
                .build();
        final List<Long> values = built.userIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenSkipUsersSourceChangesLater() {
        final List<Integer> source = new ArrayList<>(List.of(1));
        final GitLabGroupMembersListFilter built = GitLabGroupMembersListFilterBuilder.builder(
                        GitLabGroupMembersListFilterBuilder.builder()
                                .query("query")
                                .userIds(List.of(1L))
                                .skipUsers(List.of(1))
                                .showSeatInfo(true)
                                .withSamlIdentity(true)
                                .build())
                .skipUsers(source)
                .build();
        source.clear();

        assertThat(built.skipUsers()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenSkipUsersIsRead() {
        final GitLabGroupMembersListFilter built = GitLabGroupMembersListFilterBuilder.builder()
                .query("query")
                .userIds(List.of(1L))
                .skipUsers(List.of(1))
                .showSeatInfo(true)
                .withSamlIdentity(true)
                .build();
        final List<Integer> values = built.skipUsers();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupMembersListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("query", "userIds", "skipUsers", "showSeatInfo", "withSamlIdentity");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupMembersListFilter empty = GitLabGroupMembersListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupMembersListFilter filter = GitLabGroupMembersListFilterBuilder.builder()
                .query("query")
                .userIds(List.of(1L))
                .skipUsers(List.of(1))
                .showSeatInfo(true)
                .withSamlIdentity(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("query", "query"),
                        Map.entry("user_ids", "1"),
                        Map.entry("skip_users", "1"),
                        Map.entry("show_seat_info", "true"),
                        Map.entry("with_saml_identity", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupMembersListFilter filter =
                GitLabGroupMembersListFilterBuilder.builder().query("query").build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("query", "query"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupMembersListFilter filter = GitLabGroupMembersListFilterBuilder.builder()
                .query("query")
                .userIds(List.of(1L))
                .skipUsers(List.of(1))
                .showSeatInfo(true)
                .withSamlIdentity(true)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
