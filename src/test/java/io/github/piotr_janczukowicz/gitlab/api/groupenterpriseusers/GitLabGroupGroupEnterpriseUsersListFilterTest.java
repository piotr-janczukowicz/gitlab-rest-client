package io.github.piotr_janczukowicz.gitlab.api.groupenterpriseusers;

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
class GitLabGroupGroupEnterpriseUsersListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabGroupGroupEnterpriseUsersListFilterBuilder builder =
                GitLabGroupGroupEnterpriseUsersListFilterBuilder.builder(
                                GitLabGroupGroupEnterpriseUsersListFilterBuilder.builder()
                                        .username("username")
                                        .search("search")
                                        .active(true)
                                        .blocked(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .twoFactor("two_factor")
                                        .build())
                        .username(null);

        final GitLabGroupGroupEnterpriseUsersListFilter built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabGroupGroupEnterpriseUsersListFilterBuilder builder =
                GitLabGroupGroupEnterpriseUsersListFilterBuilder.builder(
                                GitLabGroupGroupEnterpriseUsersListFilterBuilder.builder()
                                        .username("username")
                                        .search("search")
                                        .active(true)
                                        .blocked(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .twoFactor("two_factor")
                                        .build())
                        .search(null);

        final GitLabGroupGroupEnterpriseUsersListFilter built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabGroupGroupEnterpriseUsersListFilterBuilder builder =
                GitLabGroupGroupEnterpriseUsersListFilterBuilder.builder(
                                GitLabGroupGroupEnterpriseUsersListFilterBuilder.builder()
                                        .username("username")
                                        .search("search")
                                        .active(true)
                                        .blocked(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .twoFactor("two_factor")
                                        .build())
                        .active(null);

        final GitLabGroupGroupEnterpriseUsersListFilter built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBlockedIsNullable() {
        final GitLabGroupGroupEnterpriseUsersListFilterBuilder builder =
                GitLabGroupGroupEnterpriseUsersListFilterBuilder.builder(
                                GitLabGroupGroupEnterpriseUsersListFilterBuilder.builder()
                                        .username("username")
                                        .search("search")
                                        .active(true)
                                        .blocked(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .twoFactor("two_factor")
                                        .build())
                        .blocked(null);

        final GitLabGroupGroupEnterpriseUsersListFilter built = builder.build();

        assertThat(built.blocked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAfterIsNullable() {
        final GitLabGroupGroupEnterpriseUsersListFilterBuilder builder =
                GitLabGroupGroupEnterpriseUsersListFilterBuilder.builder(
                                GitLabGroupGroupEnterpriseUsersListFilterBuilder.builder()
                                        .username("username")
                                        .search("search")
                                        .active(true)
                                        .blocked(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .twoFactor("two_factor")
                                        .build())
                        .createdAfter(null);

        final GitLabGroupGroupEnterpriseUsersListFilter built = builder.build();

        assertThat(built.createdAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedBeforeIsNullable() {
        final GitLabGroupGroupEnterpriseUsersListFilterBuilder builder =
                GitLabGroupGroupEnterpriseUsersListFilterBuilder.builder(
                                GitLabGroupGroupEnterpriseUsersListFilterBuilder.builder()
                                        .username("username")
                                        .search("search")
                                        .active(true)
                                        .blocked(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .twoFactor("two_factor")
                                        .build())
                        .createdBefore(null);

        final GitLabGroupGroupEnterpriseUsersListFilter built = builder.build();

        assertThat(built.createdBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTwoFactorIsNullable() {
        final GitLabGroupGroupEnterpriseUsersListFilterBuilder builder =
                GitLabGroupGroupEnterpriseUsersListFilterBuilder.builder(
                                GitLabGroupGroupEnterpriseUsersListFilterBuilder.builder()
                                        .username("username")
                                        .search("search")
                                        .active(true)
                                        .blocked(true)
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .twoFactor("two_factor")
                                        .build())
                        .twoFactor(null);

        final GitLabGroupGroupEnterpriseUsersListFilter built = builder.build();

        assertThat(built.twoFactor()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupEnterpriseUsersListFilter value =
                GitLabGroupGroupEnterpriseUsersListFilterBuilder.builder()
                        .username("username")
                        .search("search")
                        .active(true)
                        .blocked(true)
                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .twoFactor("two_factor")
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.username()).isEqualTo("username");
            softly.assertThat(value.search()).isEqualTo("search");
            softly.assertThat(value.active()).isEqualTo(true);
            softly.assertThat(value.blocked()).isEqualTo(true);
            softly.assertThat(value.createdAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.createdBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.twoFactor()).isEqualTo("two_factor");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupEnterpriseUsersListFilter original =
                GitLabGroupGroupEnterpriseUsersListFilterBuilder.builder()
                        .username("username")
                        .search("search")
                        .active(true)
                        .blocked(true)
                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .twoFactor("two_factor")
                        .build();

        final GitLabGroupGroupEnterpriseUsersListFilter rebuilt =
                GitLabGroupGroupEnterpriseUsersListFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupEnterpriseUsersListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "username", "search", "active", "blocked", "createdAfter", "createdBefore", "twoFactor");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupGroupEnterpriseUsersListFilter empty = GitLabGroupGroupEnterpriseUsersListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupGroupEnterpriseUsersListFilter filter =
                GitLabGroupGroupEnterpriseUsersListFilterBuilder.builder()
                        .username("username")
                        .search("search")
                        .active(true)
                        .blocked(true)
                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .twoFactor("two_factor")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("username", "username"),
                        Map.entry("search", "search"),
                        Map.entry("active", "true"),
                        Map.entry("blocked", "true"),
                        Map.entry("created_after", "2026-01-01T00:00:00Z"),
                        Map.entry("created_before", "2026-01-01T00:00:00Z"),
                        Map.entry("two_factor", "two_factor"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupGroupEnterpriseUsersListFilter filter =
                GitLabGroupGroupEnterpriseUsersListFilterBuilder.builder()
                        .username("username")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("username", "username"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupGroupEnterpriseUsersListFilter filter =
                GitLabGroupGroupEnterpriseUsersListFilterBuilder.builder()
                        .username("username")
                        .search("search")
                        .active(true)
                        .blocked(true)
                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .twoFactor("two_factor")
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
