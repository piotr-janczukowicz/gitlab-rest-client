package io.github.piotr_janczukowicz.gitlab.api.events;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceEventsListUsersEventsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenActionIsNullable() {
        final GitLabInstanceEventsListUsersEventsFilterBuilder builder =
                GitLabInstanceEventsListUsersEventsFilterBuilder.builder(
                                GitLabInstanceEventsListUsersEventsFilterBuilder.builder()
                                        .action("action")
                                        .targetType(GitLabInstanceEventsListUsersEventsTargetType.ISSUE)
                                        .before(LocalDate.parse("2026-01-01"))
                                        .after(LocalDate.parse("2026-01-01"))
                                        .sort(GitLabInstanceEventsListUsersEventsSort.ASC)
                                        .build())
                        .action(null);

        final GitLabInstanceEventsListUsersEventsFilter built = builder.build();

        assertThat(built.action()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetTypeIsNullable() {
        final GitLabInstanceEventsListUsersEventsFilterBuilder builder =
                GitLabInstanceEventsListUsersEventsFilterBuilder.builder(
                                GitLabInstanceEventsListUsersEventsFilterBuilder.builder()
                                        .action("action")
                                        .targetType(GitLabInstanceEventsListUsersEventsTargetType.ISSUE)
                                        .before(LocalDate.parse("2026-01-01"))
                                        .after(LocalDate.parse("2026-01-01"))
                                        .sort(GitLabInstanceEventsListUsersEventsSort.ASC)
                                        .build())
                        .targetType(null);

        final GitLabInstanceEventsListUsersEventsFilter built = builder.build();

        assertThat(built.targetType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBeforeIsNullable() {
        final GitLabInstanceEventsListUsersEventsFilterBuilder builder =
                GitLabInstanceEventsListUsersEventsFilterBuilder.builder(
                                GitLabInstanceEventsListUsersEventsFilterBuilder.builder()
                                        .action("action")
                                        .targetType(GitLabInstanceEventsListUsersEventsTargetType.ISSUE)
                                        .before(LocalDate.parse("2026-01-01"))
                                        .after(LocalDate.parse("2026-01-01"))
                                        .sort(GitLabInstanceEventsListUsersEventsSort.ASC)
                                        .build())
                        .before(null);

        final GitLabInstanceEventsListUsersEventsFilter built = builder.build();

        assertThat(built.before()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAfterIsNullable() {
        final GitLabInstanceEventsListUsersEventsFilterBuilder builder =
                GitLabInstanceEventsListUsersEventsFilterBuilder.builder(
                                GitLabInstanceEventsListUsersEventsFilterBuilder.builder()
                                        .action("action")
                                        .targetType(GitLabInstanceEventsListUsersEventsTargetType.ISSUE)
                                        .before(LocalDate.parse("2026-01-01"))
                                        .after(LocalDate.parse("2026-01-01"))
                                        .sort(GitLabInstanceEventsListUsersEventsSort.ASC)
                                        .build())
                        .after(null);

        final GitLabInstanceEventsListUsersEventsFilter built = builder.build();

        assertThat(built.after()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabInstanceEventsListUsersEventsFilterBuilder builder =
                GitLabInstanceEventsListUsersEventsFilterBuilder.builder(
                                GitLabInstanceEventsListUsersEventsFilterBuilder.builder()
                                        .action("action")
                                        .targetType(GitLabInstanceEventsListUsersEventsTargetType.ISSUE)
                                        .before(LocalDate.parse("2026-01-01"))
                                        .after(LocalDate.parse("2026-01-01"))
                                        .sort(GitLabInstanceEventsListUsersEventsSort.ASC)
                                        .build())
                        .sort(null);

        final GitLabInstanceEventsListUsersEventsFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceEventsListUsersEventsFilter value =
                GitLabInstanceEventsListUsersEventsFilterBuilder.builder()
                        .action("action")
                        .targetType(GitLabInstanceEventsListUsersEventsTargetType.ISSUE)
                        .before(LocalDate.parse("2026-01-01"))
                        .after(LocalDate.parse("2026-01-01"))
                        .sort(GitLabInstanceEventsListUsersEventsSort.ASC)
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.action()).isEqualTo("action");
            softly.assertThat(value.targetType()).isEqualTo(GitLabInstanceEventsListUsersEventsTargetType.ISSUE);
            softly.assertThat(value.before()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.after()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.sort()).isEqualTo(GitLabInstanceEventsListUsersEventsSort.ASC);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceEventsListUsersEventsFilter original =
                GitLabInstanceEventsListUsersEventsFilterBuilder.builder()
                        .action("action")
                        .targetType(GitLabInstanceEventsListUsersEventsTargetType.ISSUE)
                        .before(LocalDate.parse("2026-01-01"))
                        .after(LocalDate.parse("2026-01-01"))
                        .sort(GitLabInstanceEventsListUsersEventsSort.ASC)
                        .build();

        final GitLabInstanceEventsListUsersEventsFilter rebuilt =
                GitLabInstanceEventsListUsersEventsFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabInstanceEventsListUsersEventsFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("action", "targetType", "before", "after", "sort");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabInstanceEventsListUsersEventsFilter empty = GitLabInstanceEventsListUsersEventsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabInstanceEventsListUsersEventsFilter filter =
                GitLabInstanceEventsListUsersEventsFilterBuilder.builder()
                        .action("action")
                        .targetType(GitLabInstanceEventsListUsersEventsTargetType.ISSUE)
                        .before(LocalDate.parse("2026-01-01"))
                        .after(LocalDate.parse("2026-01-01"))
                        .sort(GitLabInstanceEventsListUsersEventsSort.ASC)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("action", "action"),
                        Map.entry("target_type", "issue"),
                        Map.entry("before", "2026-01-01"),
                        Map.entry("after", "2026-01-01"),
                        Map.entry("sort", "asc"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabInstanceEventsListUsersEventsFilter filter =
                GitLabInstanceEventsListUsersEventsFilterBuilder.builder()
                        .action("action")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("action", "action"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabInstanceEventsListUsersEventsFilter filter =
                GitLabInstanceEventsListUsersEventsFilterBuilder.builder()
                        .action("action")
                        .targetType(GitLabInstanceEventsListUsersEventsTargetType.ISSUE)
                        .before(LocalDate.parse("2026-01-01"))
                        .after(LocalDate.parse("2026-01-01"))
                        .sort(GitLabInstanceEventsListUsersEventsSort.ASC)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
