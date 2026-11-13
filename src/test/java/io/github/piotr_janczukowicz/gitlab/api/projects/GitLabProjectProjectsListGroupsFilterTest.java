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
class GitLabProjectProjectsListGroupsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabProjectProjectsListGroupsFilterBuilder builder =
                GitLabProjectProjectsListGroupsFilterBuilder.builder(
                                GitLabProjectProjectsListGroupsFilterBuilder.builder()
                                        .search("search")
                                        .skipGroups(List.of(1))
                                        .withShared(true)
                                        .sharedVisibleOnly(true)
                                        .sharedMinAccessLevel(GitLabProjectProjectsListGroupsSharedMinAccessLevel.GUEST)
                                        .build())
                        .search(null);

        final GitLabProjectProjectsListGroupsFilter built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSkipGroupsIsNullable() {
        final GitLabProjectProjectsListGroupsFilterBuilder builder =
                GitLabProjectProjectsListGroupsFilterBuilder.builder(
                                GitLabProjectProjectsListGroupsFilterBuilder.builder()
                                        .search("search")
                                        .skipGroups(List.of(1))
                                        .withShared(true)
                                        .sharedVisibleOnly(true)
                                        .sharedMinAccessLevel(GitLabProjectProjectsListGroupsSharedMinAccessLevel.GUEST)
                                        .build())
                        .skipGroups(null);

        final GitLabProjectProjectsListGroupsFilter built = builder.build();

        assertThat(built.skipGroups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithSharedIsNullable() {
        final GitLabProjectProjectsListGroupsFilterBuilder builder =
                GitLabProjectProjectsListGroupsFilterBuilder.builder(
                                GitLabProjectProjectsListGroupsFilterBuilder.builder()
                                        .search("search")
                                        .skipGroups(List.of(1))
                                        .withShared(true)
                                        .sharedVisibleOnly(true)
                                        .sharedMinAccessLevel(GitLabProjectProjectsListGroupsSharedMinAccessLevel.GUEST)
                                        .build())
                        .withShared(null);

        final GitLabProjectProjectsListGroupsFilter built = builder.build();

        assertThat(built.withShared()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSharedVisibleOnlyIsNullable() {
        final GitLabProjectProjectsListGroupsFilterBuilder builder =
                GitLabProjectProjectsListGroupsFilterBuilder.builder(
                                GitLabProjectProjectsListGroupsFilterBuilder.builder()
                                        .search("search")
                                        .skipGroups(List.of(1))
                                        .withShared(true)
                                        .sharedVisibleOnly(true)
                                        .sharedMinAccessLevel(GitLabProjectProjectsListGroupsSharedMinAccessLevel.GUEST)
                                        .build())
                        .sharedVisibleOnly(null);

        final GitLabProjectProjectsListGroupsFilter built = builder.build();

        assertThat(built.sharedVisibleOnly()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSharedMinAccessLevelIsNullable() {
        final GitLabProjectProjectsListGroupsFilterBuilder builder =
                GitLabProjectProjectsListGroupsFilterBuilder.builder(
                                GitLabProjectProjectsListGroupsFilterBuilder.builder()
                                        .search("search")
                                        .skipGroups(List.of(1))
                                        .withShared(true)
                                        .sharedVisibleOnly(true)
                                        .sharedMinAccessLevel(GitLabProjectProjectsListGroupsSharedMinAccessLevel.GUEST)
                                        .build())
                        .sharedMinAccessLevel(null);

        final GitLabProjectProjectsListGroupsFilter built = builder.build();

        assertThat(built.sharedMinAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsListGroupsFilter value = GitLabProjectProjectsListGroupsFilterBuilder.builder()
                .search("search")
                .skipGroups(List.of(1))
                .withShared(true)
                .sharedVisibleOnly(true)
                .sharedMinAccessLevel(GitLabProjectProjectsListGroupsSharedMinAccessLevel.GUEST)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.search()).isEqualTo("search");
            softly.assertThat(value.skipGroups()).isEqualTo(List.of(1));
            softly.assertThat(value.withShared()).isEqualTo(true);
            softly.assertThat(value.sharedVisibleOnly()).isEqualTo(true);
            softly.assertThat(value.sharedMinAccessLevel())
                    .isEqualTo(GitLabProjectProjectsListGroupsSharedMinAccessLevel.GUEST);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsListGroupsFilter original = GitLabProjectProjectsListGroupsFilterBuilder.builder()
                .search("search")
                .skipGroups(List.of(1))
                .withShared(true)
                .sharedVisibleOnly(true)
                .sharedMinAccessLevel(GitLabProjectProjectsListGroupsSharedMinAccessLevel.GUEST)
                .build();

        final GitLabProjectProjectsListGroupsFilter rebuilt =
                GitLabProjectProjectsListGroupsFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenSkipGroupsSourceChangesLater() {
        final List<Integer> source = new ArrayList<>(List.of(1));
        final GitLabProjectProjectsListGroupsFilter built = GitLabProjectProjectsListGroupsFilterBuilder.builder(
                        GitLabProjectProjectsListGroupsFilterBuilder.builder()
                                .search("search")
                                .skipGroups(List.of(1))
                                .withShared(true)
                                .sharedVisibleOnly(true)
                                .sharedMinAccessLevel(GitLabProjectProjectsListGroupsSharedMinAccessLevel.GUEST)
                                .build())
                .skipGroups(source)
                .build();
        source.clear();

        assertThat(built.skipGroups()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenSkipGroupsIsRead() {
        final GitLabProjectProjectsListGroupsFilter built = GitLabProjectProjectsListGroupsFilterBuilder.builder()
                .search("search")
                .skipGroups(List.of(1))
                .withShared(true)
                .sharedVisibleOnly(true)
                .sharedMinAccessLevel(GitLabProjectProjectsListGroupsSharedMinAccessLevel.GUEST)
                .build();
        final List<Integer> values = built.skipGroups();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectsListGroupsFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("search", "skipGroups", "withShared", "sharedVisibleOnly", "sharedMinAccessLevel");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectProjectsListGroupsFilter empty = GitLabProjectProjectsListGroupsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectProjectsListGroupsFilter filter = GitLabProjectProjectsListGroupsFilterBuilder.builder()
                .search("search")
                .skipGroups(List.of(1))
                .withShared(true)
                .sharedVisibleOnly(true)
                .sharedMinAccessLevel(GitLabProjectProjectsListGroupsSharedMinAccessLevel.GUEST)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("search", "search"),
                        Map.entry("skip_groups", "1"),
                        Map.entry("with_shared", "true"),
                        Map.entry("shared_visible_only", "true"),
                        Map.entry("shared_min_access_level", "10"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectProjectsListGroupsFilter filter = GitLabProjectProjectsListGroupsFilterBuilder.builder()
                .search("search")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("search", "search"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectProjectsListGroupsFilter filter = GitLabProjectProjectsListGroupsFilterBuilder.builder()
                .search("search")
                .skipGroups(List.of(1))
                .withShared(true)
                .sharedVisibleOnly(true)
                .sharedMinAccessLevel(GitLabProjectProjectsListGroupsSharedMinAccessLevel.GUEST)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
