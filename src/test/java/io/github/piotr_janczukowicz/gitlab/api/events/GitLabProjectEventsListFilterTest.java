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
class GitLabProjectEventsListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenActionIsNullable() {
        final GitLabProjectEventsListFilterBuilder builder = GitLabProjectEventsListFilterBuilder.builder(
                        GitLabProjectEventsListFilterBuilder.builder()
                                .action("action")
                                .targetType(GitLabProjectEventsListTargetType.ISSUE)
                                .before(LocalDate.parse("2026-01-01"))
                                .after(LocalDate.parse("2026-01-01"))
                                .sort(GitLabProjectEventsListSort.ASC)
                                .build())
                .action(null);

        final GitLabProjectEventsListFilter built = builder.build();

        assertThat(built.action()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetTypeIsNullable() {
        final GitLabProjectEventsListFilterBuilder builder = GitLabProjectEventsListFilterBuilder.builder(
                        GitLabProjectEventsListFilterBuilder.builder()
                                .action("action")
                                .targetType(GitLabProjectEventsListTargetType.ISSUE)
                                .before(LocalDate.parse("2026-01-01"))
                                .after(LocalDate.parse("2026-01-01"))
                                .sort(GitLabProjectEventsListSort.ASC)
                                .build())
                .targetType(null);

        final GitLabProjectEventsListFilter built = builder.build();

        assertThat(built.targetType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBeforeIsNullable() {
        final GitLabProjectEventsListFilterBuilder builder = GitLabProjectEventsListFilterBuilder.builder(
                        GitLabProjectEventsListFilterBuilder.builder()
                                .action("action")
                                .targetType(GitLabProjectEventsListTargetType.ISSUE)
                                .before(LocalDate.parse("2026-01-01"))
                                .after(LocalDate.parse("2026-01-01"))
                                .sort(GitLabProjectEventsListSort.ASC)
                                .build())
                .before(null);

        final GitLabProjectEventsListFilter built = builder.build();

        assertThat(built.before()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAfterIsNullable() {
        final GitLabProjectEventsListFilterBuilder builder = GitLabProjectEventsListFilterBuilder.builder(
                        GitLabProjectEventsListFilterBuilder.builder()
                                .action("action")
                                .targetType(GitLabProjectEventsListTargetType.ISSUE)
                                .before(LocalDate.parse("2026-01-01"))
                                .after(LocalDate.parse("2026-01-01"))
                                .sort(GitLabProjectEventsListSort.ASC)
                                .build())
                .after(null);

        final GitLabProjectEventsListFilter built = builder.build();

        assertThat(built.after()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabProjectEventsListFilterBuilder builder = GitLabProjectEventsListFilterBuilder.builder(
                        GitLabProjectEventsListFilterBuilder.builder()
                                .action("action")
                                .targetType(GitLabProjectEventsListTargetType.ISSUE)
                                .before(LocalDate.parse("2026-01-01"))
                                .after(LocalDate.parse("2026-01-01"))
                                .sort(GitLabProjectEventsListSort.ASC)
                                .build())
                .sort(null);

        final GitLabProjectEventsListFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectEventsListFilter value = GitLabProjectEventsListFilterBuilder.builder()
                .action("action")
                .targetType(GitLabProjectEventsListTargetType.ISSUE)
                .before(LocalDate.parse("2026-01-01"))
                .after(LocalDate.parse("2026-01-01"))
                .sort(GitLabProjectEventsListSort.ASC)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.action()).isEqualTo("action");
            softly.assertThat(value.targetType()).isEqualTo(GitLabProjectEventsListTargetType.ISSUE);
            softly.assertThat(value.before()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.after()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.sort()).isEqualTo(GitLabProjectEventsListSort.ASC);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectEventsListFilter original = GitLabProjectEventsListFilterBuilder.builder()
                .action("action")
                .targetType(GitLabProjectEventsListTargetType.ISSUE)
                .before(LocalDate.parse("2026-01-01"))
                .after(LocalDate.parse("2026-01-01"))
                .sort(GitLabProjectEventsListSort.ASC)
                .build();

        final GitLabProjectEventsListFilter rebuilt =
                GitLabProjectEventsListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectEventsListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("action", "targetType", "before", "after", "sort");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectEventsListFilter empty = GitLabProjectEventsListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectEventsListFilter filter = GitLabProjectEventsListFilterBuilder.builder()
                .action("action")
                .targetType(GitLabProjectEventsListTargetType.ISSUE)
                .before(LocalDate.parse("2026-01-01"))
                .after(LocalDate.parse("2026-01-01"))
                .sort(GitLabProjectEventsListSort.ASC)
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
        final GitLabProjectEventsListFilter filter =
                GitLabProjectEventsListFilterBuilder.builder().action("action").build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("action", "action"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectEventsListFilter filter = GitLabProjectEventsListFilterBuilder.builder()
                .action("action")
                .targetType(GitLabProjectEventsListTargetType.ISSUE)
                .before(LocalDate.parse("2026-01-01"))
                .after(LocalDate.parse("2026-01-01"))
                .sort(GitLabProjectEventsListSort.ASC)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
