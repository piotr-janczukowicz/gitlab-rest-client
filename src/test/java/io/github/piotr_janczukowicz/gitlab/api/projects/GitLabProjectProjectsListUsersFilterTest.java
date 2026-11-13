package io.github.piotr_janczukowicz.gitlab.api.projects;

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
class GitLabProjectProjectsListUsersFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabProjectProjectsListUsersFilterBuilder builder = GitLabProjectProjectsListUsersFilterBuilder.builder(
                        GitLabProjectProjectsListUsersFilterBuilder.builder()
                                .search("search")
                                .skipUsers(List.of(1))
                                .build())
                .search(null);

        final GitLabProjectProjectsListUsersFilter built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSkipUsersIsNullable() {
        final GitLabProjectProjectsListUsersFilterBuilder builder = GitLabProjectProjectsListUsersFilterBuilder.builder(
                        GitLabProjectProjectsListUsersFilterBuilder.builder()
                                .search("search")
                                .skipUsers(List.of(1))
                                .build())
                .skipUsers(null);

        final GitLabProjectProjectsListUsersFilter built = builder.build();

        assertThat(built.skipUsers()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsListUsersFilter value = GitLabProjectProjectsListUsersFilterBuilder.builder()
                .search("search")
                .skipUsers(List.of(1))
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.search()).isEqualTo("search");
            softly.assertThat(value.skipUsers()).isEqualTo(List.of(1));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsListUsersFilter original = GitLabProjectProjectsListUsersFilterBuilder.builder()
                .search("search")
                .skipUsers(List.of(1))
                .build();

        final GitLabProjectProjectsListUsersFilter rebuilt =
                GitLabProjectProjectsListUsersFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenSkipUsersSourceChangesLater() {
        final List<Integer> source = new ArrayList<>(List.of(1));
        final GitLabProjectProjectsListUsersFilter built = GitLabProjectProjectsListUsersFilterBuilder.builder(
                        GitLabProjectProjectsListUsersFilterBuilder.builder()
                                .search("search")
                                .skipUsers(List.of(1))
                                .build())
                .skipUsers(source)
                .build();
        source.clear();

        assertThat(built.skipUsers()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenSkipUsersIsRead() {
        final GitLabProjectProjectsListUsersFilter built = GitLabProjectProjectsListUsersFilterBuilder.builder()
                .search("search")
                .skipUsers(List.of(1))
                .build();
        final List<Integer> values = built.skipUsers();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectsListUsersFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("search", "skipUsers");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectProjectsListUsersFilter empty = GitLabProjectProjectsListUsersFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectProjectsListUsersFilter filter = GitLabProjectProjectsListUsersFilterBuilder.builder()
                .search("search")
                .skipUsers(List.of(1))
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("search", "search"), Map.entry("skip_users", "1"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectProjectsListUsersFilter filter = GitLabProjectProjectsListUsersFilterBuilder.builder()
                .search("search")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("search", "search"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectProjectsListUsersFilter filter = GitLabProjectProjectsListUsersFilterBuilder.builder()
                .search("search")
                .skipUsers(List.of(1))
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
