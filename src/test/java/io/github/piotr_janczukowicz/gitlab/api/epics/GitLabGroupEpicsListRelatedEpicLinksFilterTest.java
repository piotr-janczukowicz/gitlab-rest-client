package io.github.piotr_janczukowicz.gitlab.api.epics;

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
class GitLabGroupEpicsListRelatedEpicLinksFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenUpdatedBeforeIsNullable() {
        final GitLabGroupEpicsListRelatedEpicLinksFilterBuilder builder =
                GitLabGroupEpicsListRelatedEpicLinksFilterBuilder.builder(
                                GitLabGroupEpicsListRelatedEpicLinksFilterBuilder.builder()
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .build())
                        .updatedBefore(null);

        final GitLabGroupEpicsListRelatedEpicLinksFilter built = builder.build();

        assertThat(built.updatedBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAfterIsNullable() {
        final GitLabGroupEpicsListRelatedEpicLinksFilterBuilder builder =
                GitLabGroupEpicsListRelatedEpicLinksFilterBuilder.builder(
                                GitLabGroupEpicsListRelatedEpicLinksFilterBuilder.builder()
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .build())
                        .updatedAfter(null);

        final GitLabGroupEpicsListRelatedEpicLinksFilter built = builder.build();

        assertThat(built.updatedAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedBeforeIsNullable() {
        final GitLabGroupEpicsListRelatedEpicLinksFilterBuilder builder =
                GitLabGroupEpicsListRelatedEpicLinksFilterBuilder.builder(
                                GitLabGroupEpicsListRelatedEpicLinksFilterBuilder.builder()
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .build())
                        .createdBefore(null);

        final GitLabGroupEpicsListRelatedEpicLinksFilter built = builder.build();

        assertThat(built.createdBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAfterIsNullable() {
        final GitLabGroupEpicsListRelatedEpicLinksFilterBuilder builder =
                GitLabGroupEpicsListRelatedEpicLinksFilterBuilder.builder(
                                GitLabGroupEpicsListRelatedEpicLinksFilterBuilder.builder()
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .build())
                        .createdAfter(null);

        final GitLabGroupEpicsListRelatedEpicLinksFilter built = builder.build();

        assertThat(built.createdAfter()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupEpicsListRelatedEpicLinksFilter value =
                GitLabGroupEpicsListRelatedEpicLinksFilterBuilder.builder()
                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.updatedBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.createdBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.createdAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupEpicsListRelatedEpicLinksFilter original =
                GitLabGroupEpicsListRelatedEpicLinksFilterBuilder.builder()
                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .build();

        final GitLabGroupEpicsListRelatedEpicLinksFilter rebuilt =
                GitLabGroupEpicsListRelatedEpicLinksFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupEpicsListRelatedEpicLinksFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("updatedBefore", "updatedAfter", "createdBefore", "createdAfter");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupEpicsListRelatedEpicLinksFilter empty = GitLabGroupEpicsListRelatedEpicLinksFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupEpicsListRelatedEpicLinksFilter filter =
                GitLabGroupEpicsListRelatedEpicLinksFilterBuilder.builder()
                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("updated_before", "2026-01-01T00:00:00Z"),
                        Map.entry("updated_after", "2026-01-01T00:00:00Z"),
                        Map.entry("created_before", "2026-01-01T00:00:00Z"),
                        Map.entry("created_after", "2026-01-01T00:00:00Z"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupEpicsListRelatedEpicLinksFilter filter =
                GitLabGroupEpicsListRelatedEpicLinksFilterBuilder.builder()
                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("updated_before", "2026-01-01T00:00:00Z"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupEpicsListRelatedEpicLinksFilter filter =
                GitLabGroupEpicsListRelatedEpicLinksFilterBuilder.builder()
                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
