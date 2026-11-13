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
class GitLabGroupGroupsListManageSshKeysFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenCreatedBeforeIsNullable() {
        final GitLabGroupGroupsListManageSshKeysFilterBuilder builder =
                GitLabGroupGroupsListManageSshKeysFilterBuilder.builder(
                                GitLabGroupGroupsListManageSshKeysFilterBuilder.builder()
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .expiresBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .expiresAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .build())
                        .createdBefore(null);

        final GitLabGroupGroupsListManageSshKeysFilter built = builder.build();

        assertThat(built.createdBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAfterIsNullable() {
        final GitLabGroupGroupsListManageSshKeysFilterBuilder builder =
                GitLabGroupGroupsListManageSshKeysFilterBuilder.builder(
                                GitLabGroupGroupsListManageSshKeysFilterBuilder.builder()
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .expiresBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .expiresAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .build())
                        .createdAfter(null);

        final GitLabGroupGroupsListManageSshKeysFilter built = builder.build();

        assertThat(built.createdAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresBeforeIsNullable() {
        final GitLabGroupGroupsListManageSshKeysFilterBuilder builder =
                GitLabGroupGroupsListManageSshKeysFilterBuilder.builder(
                                GitLabGroupGroupsListManageSshKeysFilterBuilder.builder()
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .expiresBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .expiresAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .build())
                        .expiresBefore(null);

        final GitLabGroupGroupsListManageSshKeysFilter built = builder.build();

        assertThat(built.expiresBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAfterIsNullable() {
        final GitLabGroupGroupsListManageSshKeysFilterBuilder builder =
                GitLabGroupGroupsListManageSshKeysFilterBuilder.builder(
                                GitLabGroupGroupsListManageSshKeysFilterBuilder.builder()
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .expiresBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .expiresAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .build())
                        .expiresAfter(null);

        final GitLabGroupGroupsListManageSshKeysFilter built = builder.build();

        assertThat(built.expiresAfter()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupsListManageSshKeysFilter value = GitLabGroupGroupsListManageSshKeysFilterBuilder.builder()
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .expiresBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .expiresAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.createdBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.createdAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.expiresBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.expiresAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupsListManageSshKeysFilter original =
                GitLabGroupGroupsListManageSshKeysFilterBuilder.builder()
                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .expiresBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .expiresAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .build();

        final GitLabGroupGroupsListManageSshKeysFilter rebuilt =
                GitLabGroupGroupsListManageSshKeysFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupsListManageSshKeysFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("createdBefore", "createdAfter", "expiresBefore", "expiresAfter");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupGroupsListManageSshKeysFilter empty = GitLabGroupGroupsListManageSshKeysFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupGroupsListManageSshKeysFilter filter =
                GitLabGroupGroupsListManageSshKeysFilterBuilder.builder()
                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .expiresBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .expiresAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("created_before", "2026-01-01T00:00:00Z"),
                        Map.entry("created_after", "2026-01-01T00:00:00Z"),
                        Map.entry("expires_before", "2026-01-01T00:00:00Z"),
                        Map.entry("expires_after", "2026-01-01T00:00:00Z"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupGroupsListManageSshKeysFilter filter =
                GitLabGroupGroupsListManageSshKeysFilterBuilder.builder()
                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("created_before", "2026-01-01T00:00:00Z"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupGroupsListManageSshKeysFilter filter =
                GitLabGroupGroupsListManageSshKeysFilterBuilder.builder()
                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .expiresBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .expiresAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
