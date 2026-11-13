package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupsListProvisionedUsersFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabGroupGroupsListProvisionedUsersFilterBuilder builder =
                GitLabGroupGroupsListProvisionedUsersFilterBuilder.builder(
                                GitLabGroupGroupsListProvisionedUsersFilterBuilder.builder()
                                        .username("username")
                                        .search("search")
                                        .active(true)
                                        .blocked(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .build())
                        .username(null);

        final GitLabGroupGroupsListProvisionedUsersFilter built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabGroupGroupsListProvisionedUsersFilterBuilder builder =
                GitLabGroupGroupsListProvisionedUsersFilterBuilder.builder(
                                GitLabGroupGroupsListProvisionedUsersFilterBuilder.builder()
                                        .username("username")
                                        .search("search")
                                        .active(true)
                                        .blocked(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .build())
                        .search(null);

        final GitLabGroupGroupsListProvisionedUsersFilter built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabGroupGroupsListProvisionedUsersFilterBuilder builder =
                GitLabGroupGroupsListProvisionedUsersFilterBuilder.builder(
                                GitLabGroupGroupsListProvisionedUsersFilterBuilder.builder()
                                        .username("username")
                                        .search("search")
                                        .active(true)
                                        .blocked(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .build())
                        .active(null);

        final GitLabGroupGroupsListProvisionedUsersFilter built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBlockedIsNullable() {
        final GitLabGroupGroupsListProvisionedUsersFilterBuilder builder =
                GitLabGroupGroupsListProvisionedUsersFilterBuilder.builder(
                                GitLabGroupGroupsListProvisionedUsersFilterBuilder.builder()
                                        .username("username")
                                        .search("search")
                                        .active(true)
                                        .blocked(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .build())
                        .blocked(null);

        final GitLabGroupGroupsListProvisionedUsersFilter built = builder.build();

        assertThat(built.blocked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAfterIsNullable() {
        final GitLabGroupGroupsListProvisionedUsersFilterBuilder builder =
                GitLabGroupGroupsListProvisionedUsersFilterBuilder.builder(
                                GitLabGroupGroupsListProvisionedUsersFilterBuilder.builder()
                                        .username("username")
                                        .search("search")
                                        .active(true)
                                        .blocked(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .build())
                        .createdAfter(null);

        final GitLabGroupGroupsListProvisionedUsersFilter built = builder.build();

        assertThat(built.createdAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedBeforeIsNullable() {
        final GitLabGroupGroupsListProvisionedUsersFilterBuilder builder =
                GitLabGroupGroupsListProvisionedUsersFilterBuilder.builder(
                                GitLabGroupGroupsListProvisionedUsersFilterBuilder.builder()
                                        .username("username")
                                        .search("search")
                                        .active(true)
                                        .blocked(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .build())
                        .createdBefore(null);

        final GitLabGroupGroupsListProvisionedUsersFilter built = builder.build();

        assertThat(built.createdBefore()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupsListProvisionedUsersFilter value =
                GitLabGroupGroupsListProvisionedUsersFilterBuilder.builder()
                        .username("username")
                        .search("search")
                        .active(true)
                        .blocked(true)
                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.username()).isEqualTo("username");
            softly.assertThat(value.search()).isEqualTo("search");
            softly.assertThat(value.active()).isEqualTo(true);
            softly.assertThat(value.blocked()).isEqualTo(true);
            softly.assertThat(value.createdAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.createdBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupsListProvisionedUsersFilter original =
                GitLabGroupGroupsListProvisionedUsersFilterBuilder.builder()
                        .username("username")
                        .search("search")
                        .active(true)
                        .blocked(true)
                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .build();

        final GitLabGroupGroupsListProvisionedUsersFilter rebuilt =
                GitLabGroupGroupsListProvisionedUsersFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupsListProvisionedUsersFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("username", "search", "active", "blocked", "createdAfter", "createdBefore");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupGroupsListProvisionedUsersFilter empty = GitLabGroupGroupsListProvisionedUsersFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupGroupsListProvisionedUsersFilter filter =
                GitLabGroupGroupsListProvisionedUsersFilterBuilder.builder()
                        .username("username")
                        .search("search")
                        .active(true)
                        .blocked(true)
                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("username", "username"),
                        Map.entry("search", "search"),
                        Map.entry("active", "true"),
                        Map.entry("blocked", "true"),
                        Map.entry("created_after", "2026-01-01T00:00:00Z"),
                        Map.entry("created_before", "2026-01-01T00:00:00Z"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupGroupsListProvisionedUsersFilter filter =
                GitLabGroupGroupsListProvisionedUsersFilterBuilder.builder()
                        .username("username")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("username", "username"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupGroupsListProvisionedUsersFilter filter =
                GitLabGroupGroupsListProvisionedUsersFilterBuilder.builder()
                        .username("username")
                        .search("search")
                        .active(true)
                        .blocked(true)
                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
