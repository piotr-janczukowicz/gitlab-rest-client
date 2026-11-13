package io.github.piotr_janczukowicz.gitlab.api.organizations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabOrganizationsListUsersFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenCursorIsNullable() {
        final GitLabOrganizationsListUsersFilterBuilder builder = GitLabOrganizationsListUsersFilterBuilder.builder(
                        GitLabOrganizationsListUsersFilterBuilder.builder()
                                .cursor("cursor")
                                .orderBy(GitLabOrganizationsListUsersOrderBy.ID)
                                .sort(GitLabOrganizationsListUsersSort.ASC)
                                .build())
                .cursor(null);

        final GitLabOrganizationsListUsersFilter built = builder.build();

        assertThat(built.cursor()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrderByIsNullable() {
        final GitLabOrganizationsListUsersFilterBuilder builder = GitLabOrganizationsListUsersFilterBuilder.builder(
                        GitLabOrganizationsListUsersFilterBuilder.builder()
                                .cursor("cursor")
                                .orderBy(GitLabOrganizationsListUsersOrderBy.ID)
                                .sort(GitLabOrganizationsListUsersSort.ASC)
                                .build())
                .orderBy(null);

        final GitLabOrganizationsListUsersFilter built = builder.build();

        assertThat(built.orderBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabOrganizationsListUsersFilterBuilder builder = GitLabOrganizationsListUsersFilterBuilder.builder(
                        GitLabOrganizationsListUsersFilterBuilder.builder()
                                .cursor("cursor")
                                .orderBy(GitLabOrganizationsListUsersOrderBy.ID)
                                .sort(GitLabOrganizationsListUsersSort.ASC)
                                .build())
                .sort(null);

        final GitLabOrganizationsListUsersFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabOrganizationsListUsersFilter value = GitLabOrganizationsListUsersFilterBuilder.builder()
                .cursor("cursor")
                .orderBy(GitLabOrganizationsListUsersOrderBy.ID)
                .sort(GitLabOrganizationsListUsersSort.ASC)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.cursor()).isEqualTo("cursor");
            softly.assertThat(value.orderBy()).isEqualTo(GitLabOrganizationsListUsersOrderBy.ID);
            softly.assertThat(value.sort()).isEqualTo(GitLabOrganizationsListUsersSort.ASC);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabOrganizationsListUsersFilter original = GitLabOrganizationsListUsersFilterBuilder.builder()
                .cursor("cursor")
                .orderBy(GitLabOrganizationsListUsersOrderBy.ID)
                .sort(GitLabOrganizationsListUsersSort.ASC)
                .build();

        final GitLabOrganizationsListUsersFilter rebuilt =
                GitLabOrganizationsListUsersFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabOrganizationsListUsersFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("cursor", "orderBy", "sort");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabOrganizationsListUsersFilter empty = GitLabOrganizationsListUsersFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabOrganizationsListUsersFilter filter = GitLabOrganizationsListUsersFilterBuilder.builder()
                .cursor("cursor")
                .orderBy(GitLabOrganizationsListUsersOrderBy.ID)
                .sort(GitLabOrganizationsListUsersSort.ASC)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(Map.entry("cursor", "cursor"), Map.entry("order_by", "id"), Map.entry("sort", "asc"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabOrganizationsListUsersFilter filter = GitLabOrganizationsListUsersFilterBuilder.builder()
                .cursor("cursor")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("cursor", "cursor"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabOrganizationsListUsersFilter filter = GitLabOrganizationsListUsersFilterBuilder.builder()
                .cursor("cursor")
                .orderBy(GitLabOrganizationsListUsersOrderBy.ID)
                .sort(GitLabOrganizationsListUsersSort.ASC)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
