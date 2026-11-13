package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupsListBillableMembersFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabGroupGroupsListBillableMembersFilterBuilder builder =
                GitLabGroupGroupsListBillableMembersFilterBuilder.builder(
                                GitLabGroupGroupsListBillableMembersFilterBuilder.builder()
                                        .search("search")
                                        .sort(GitLabGroupGroupsListBillableMembersSort.ACCESS_LEVEL_ASC)
                                        .build())
                        .search(null);

        final GitLabGroupGroupsListBillableMembersFilter built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabGroupGroupsListBillableMembersFilterBuilder builder =
                GitLabGroupGroupsListBillableMembersFilterBuilder.builder(
                                GitLabGroupGroupsListBillableMembersFilterBuilder.builder()
                                        .search("search")
                                        .sort(GitLabGroupGroupsListBillableMembersSort.ACCESS_LEVEL_ASC)
                                        .build())
                        .sort(null);

        final GitLabGroupGroupsListBillableMembersFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupsListBillableMembersFilter value =
                GitLabGroupGroupsListBillableMembersFilterBuilder.builder()
                        .search("search")
                        .sort(GitLabGroupGroupsListBillableMembersSort.ACCESS_LEVEL_ASC)
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.search()).isEqualTo("search");
            softly.assertThat(value.sort()).isEqualTo(GitLabGroupGroupsListBillableMembersSort.ACCESS_LEVEL_ASC);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupsListBillableMembersFilter original =
                GitLabGroupGroupsListBillableMembersFilterBuilder.builder()
                        .search("search")
                        .sort(GitLabGroupGroupsListBillableMembersSort.ACCESS_LEVEL_ASC)
                        .build();

        final GitLabGroupGroupsListBillableMembersFilter rebuilt =
                GitLabGroupGroupsListBillableMembersFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupsListBillableMembersFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("search", "sort");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupGroupsListBillableMembersFilter empty = GitLabGroupGroupsListBillableMembersFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupGroupsListBillableMembersFilter filter =
                GitLabGroupGroupsListBillableMembersFilterBuilder.builder()
                        .search("search")
                        .sort(GitLabGroupGroupsListBillableMembersSort.ACCESS_LEVEL_ASC)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("search", "search"), Map.entry("sort", "access_level_asc"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupGroupsListBillableMembersFilter filter =
                GitLabGroupGroupsListBillableMembersFilterBuilder.builder()
                        .search("search")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("search", "search"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupGroupsListBillableMembersFilter filter =
                GitLabGroupGroupsListBillableMembersFilterBuilder.builder()
                        .search("search")
                        .sort(GitLabGroupGroupsListBillableMembersSort.ACCESS_LEVEL_ASC)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
