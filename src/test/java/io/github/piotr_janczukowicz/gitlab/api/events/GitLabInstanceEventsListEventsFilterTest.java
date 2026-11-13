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
class GitLabInstanceEventsListEventsFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenScopeIsNullable() {
        final GitLabInstanceEventsListEventsFilterBuilder builder = GitLabInstanceEventsListEventsFilterBuilder.builder(
                        GitLabInstanceEventsListEventsFilterBuilder.builder()
                                .scope("scope")
                                .action("action")
                                .targetType(GitLabInstanceEventsListEventsTargetType.ISSUE)
                                .before(LocalDate.parse("2026-01-01"))
                                .after(LocalDate.parse("2026-01-01"))
                                .sort(GitLabInstanceEventsListEventsSort.ASC)
                                .build())
                .scope(null);

        final GitLabInstanceEventsListEventsFilter built = builder.build();

        assertThat(built.scope()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActionIsNullable() {
        final GitLabInstanceEventsListEventsFilterBuilder builder = GitLabInstanceEventsListEventsFilterBuilder.builder(
                        GitLabInstanceEventsListEventsFilterBuilder.builder()
                                .scope("scope")
                                .action("action")
                                .targetType(GitLabInstanceEventsListEventsTargetType.ISSUE)
                                .before(LocalDate.parse("2026-01-01"))
                                .after(LocalDate.parse("2026-01-01"))
                                .sort(GitLabInstanceEventsListEventsSort.ASC)
                                .build())
                .action(null);

        final GitLabInstanceEventsListEventsFilter built = builder.build();

        assertThat(built.action()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetTypeIsNullable() {
        final GitLabInstanceEventsListEventsFilterBuilder builder = GitLabInstanceEventsListEventsFilterBuilder.builder(
                        GitLabInstanceEventsListEventsFilterBuilder.builder()
                                .scope("scope")
                                .action("action")
                                .targetType(GitLabInstanceEventsListEventsTargetType.ISSUE)
                                .before(LocalDate.parse("2026-01-01"))
                                .after(LocalDate.parse("2026-01-01"))
                                .sort(GitLabInstanceEventsListEventsSort.ASC)
                                .build())
                .targetType(null);

        final GitLabInstanceEventsListEventsFilter built = builder.build();

        assertThat(built.targetType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBeforeIsNullable() {
        final GitLabInstanceEventsListEventsFilterBuilder builder = GitLabInstanceEventsListEventsFilterBuilder.builder(
                        GitLabInstanceEventsListEventsFilterBuilder.builder()
                                .scope("scope")
                                .action("action")
                                .targetType(GitLabInstanceEventsListEventsTargetType.ISSUE)
                                .before(LocalDate.parse("2026-01-01"))
                                .after(LocalDate.parse("2026-01-01"))
                                .sort(GitLabInstanceEventsListEventsSort.ASC)
                                .build())
                .before(null);

        final GitLabInstanceEventsListEventsFilter built = builder.build();

        assertThat(built.before()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAfterIsNullable() {
        final GitLabInstanceEventsListEventsFilterBuilder builder = GitLabInstanceEventsListEventsFilterBuilder.builder(
                        GitLabInstanceEventsListEventsFilterBuilder.builder()
                                .scope("scope")
                                .action("action")
                                .targetType(GitLabInstanceEventsListEventsTargetType.ISSUE)
                                .before(LocalDate.parse("2026-01-01"))
                                .after(LocalDate.parse("2026-01-01"))
                                .sort(GitLabInstanceEventsListEventsSort.ASC)
                                .build())
                .after(null);

        final GitLabInstanceEventsListEventsFilter built = builder.build();

        assertThat(built.after()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabInstanceEventsListEventsFilterBuilder builder = GitLabInstanceEventsListEventsFilterBuilder.builder(
                        GitLabInstanceEventsListEventsFilterBuilder.builder()
                                .scope("scope")
                                .action("action")
                                .targetType(GitLabInstanceEventsListEventsTargetType.ISSUE)
                                .before(LocalDate.parse("2026-01-01"))
                                .after(LocalDate.parse("2026-01-01"))
                                .sort(GitLabInstanceEventsListEventsSort.ASC)
                                .build())
                .sort(null);

        final GitLabInstanceEventsListEventsFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceEventsListEventsFilter value = GitLabInstanceEventsListEventsFilterBuilder.builder()
                .scope("scope")
                .action("action")
                .targetType(GitLabInstanceEventsListEventsTargetType.ISSUE)
                .before(LocalDate.parse("2026-01-01"))
                .after(LocalDate.parse("2026-01-01"))
                .sort(GitLabInstanceEventsListEventsSort.ASC)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.scope()).isEqualTo("scope");
            softly.assertThat(value.action()).isEqualTo("action");
            softly.assertThat(value.targetType()).isEqualTo(GitLabInstanceEventsListEventsTargetType.ISSUE);
            softly.assertThat(value.before()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.after()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.sort()).isEqualTo(GitLabInstanceEventsListEventsSort.ASC);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceEventsListEventsFilter original = GitLabInstanceEventsListEventsFilterBuilder.builder()
                .scope("scope")
                .action("action")
                .targetType(GitLabInstanceEventsListEventsTargetType.ISSUE)
                .before(LocalDate.parse("2026-01-01"))
                .after(LocalDate.parse("2026-01-01"))
                .sort(GitLabInstanceEventsListEventsSort.ASC)
                .build();

        final GitLabInstanceEventsListEventsFilter rebuilt =
                GitLabInstanceEventsListEventsFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabInstanceEventsListEventsFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("scope", "action", "targetType", "before", "after", "sort");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabInstanceEventsListEventsFilter empty = GitLabInstanceEventsListEventsFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabInstanceEventsListEventsFilter filter = GitLabInstanceEventsListEventsFilterBuilder.builder()
                .scope("scope")
                .action("action")
                .targetType(GitLabInstanceEventsListEventsTargetType.ISSUE)
                .before(LocalDate.parse("2026-01-01"))
                .after(LocalDate.parse("2026-01-01"))
                .sort(GitLabInstanceEventsListEventsSort.ASC)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("scope", "scope"),
                        Map.entry("action", "action"),
                        Map.entry("target_type", "issue"),
                        Map.entry("before", "2026-01-01"),
                        Map.entry("after", "2026-01-01"),
                        Map.entry("sort", "asc"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabInstanceEventsListEventsFilter filter = GitLabInstanceEventsListEventsFilterBuilder.builder()
                .scope("scope")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("scope", "scope"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabInstanceEventsListEventsFilter filter = GitLabInstanceEventsListEventsFilterBuilder.builder()
                .scope("scope")
                .action("action")
                .targetType(GitLabInstanceEventsListEventsTargetType.ISSUE)
                .before(LocalDate.parse("2026-01-01"))
                .after(LocalDate.parse("2026-01-01"))
                .sort(GitLabInstanceEventsListEventsSort.ASC)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
