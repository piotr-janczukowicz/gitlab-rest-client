package io.github.piotr_janczukowicz.gitlab.api.deployments;

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
class GitLabProjectDeploymentsListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenOrderByIsNullable() {
        final GitLabProjectDeploymentsListFilterBuilder builder = GitLabProjectDeploymentsListFilterBuilder.builder(
                        GitLabProjectDeploymentsListFilterBuilder.builder()
                                .orderBy(GitLabProjectDeploymentsListOrderBy.ID)
                                .sort(GitLabProjectDeploymentsListSort.ASC)
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .finishedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .finishedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .status(GitLabProjectDeploymentsListStatus.CREATED)
                                .build())
                .orderBy(null);

        final GitLabProjectDeploymentsListFilter built = builder.build();

        assertThat(built.orderBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabProjectDeploymentsListFilterBuilder builder = GitLabProjectDeploymentsListFilterBuilder.builder(
                        GitLabProjectDeploymentsListFilterBuilder.builder()
                                .orderBy(GitLabProjectDeploymentsListOrderBy.ID)
                                .sort(GitLabProjectDeploymentsListSort.ASC)
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .finishedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .finishedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .status(GitLabProjectDeploymentsListStatus.CREATED)
                                .build())
                .sort(null);

        final GitLabProjectDeploymentsListFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAfterIsNullable() {
        final GitLabProjectDeploymentsListFilterBuilder builder = GitLabProjectDeploymentsListFilterBuilder.builder(
                        GitLabProjectDeploymentsListFilterBuilder.builder()
                                .orderBy(GitLabProjectDeploymentsListOrderBy.ID)
                                .sort(GitLabProjectDeploymentsListSort.ASC)
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .finishedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .finishedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .status(GitLabProjectDeploymentsListStatus.CREATED)
                                .build())
                .updatedAfter(null);

        final GitLabProjectDeploymentsListFilter built = builder.build();

        assertThat(built.updatedAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedBeforeIsNullable() {
        final GitLabProjectDeploymentsListFilterBuilder builder = GitLabProjectDeploymentsListFilterBuilder.builder(
                        GitLabProjectDeploymentsListFilterBuilder.builder()
                                .orderBy(GitLabProjectDeploymentsListOrderBy.ID)
                                .sort(GitLabProjectDeploymentsListSort.ASC)
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .finishedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .finishedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .status(GitLabProjectDeploymentsListStatus.CREATED)
                                .build())
                .updatedBefore(null);

        final GitLabProjectDeploymentsListFilter built = builder.build();

        assertThat(built.updatedBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFinishedAfterIsNullable() {
        final GitLabProjectDeploymentsListFilterBuilder builder = GitLabProjectDeploymentsListFilterBuilder.builder(
                        GitLabProjectDeploymentsListFilterBuilder.builder()
                                .orderBy(GitLabProjectDeploymentsListOrderBy.ID)
                                .sort(GitLabProjectDeploymentsListSort.ASC)
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .finishedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .finishedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .status(GitLabProjectDeploymentsListStatus.CREATED)
                                .build())
                .finishedAfter(null);

        final GitLabProjectDeploymentsListFilter built = builder.build();

        assertThat(built.finishedAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFinishedBeforeIsNullable() {
        final GitLabProjectDeploymentsListFilterBuilder builder = GitLabProjectDeploymentsListFilterBuilder.builder(
                        GitLabProjectDeploymentsListFilterBuilder.builder()
                                .orderBy(GitLabProjectDeploymentsListOrderBy.ID)
                                .sort(GitLabProjectDeploymentsListSort.ASC)
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .finishedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .finishedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .status(GitLabProjectDeploymentsListStatus.CREATED)
                                .build())
                .finishedBefore(null);

        final GitLabProjectDeploymentsListFilter built = builder.build();

        assertThat(built.finishedBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentIsNullable() {
        final GitLabProjectDeploymentsListFilterBuilder builder = GitLabProjectDeploymentsListFilterBuilder.builder(
                        GitLabProjectDeploymentsListFilterBuilder.builder()
                                .orderBy(GitLabProjectDeploymentsListOrderBy.ID)
                                .sort(GitLabProjectDeploymentsListSort.ASC)
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .finishedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .finishedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .status(GitLabProjectDeploymentsListStatus.CREATED)
                                .build())
                .environment(null);

        final GitLabProjectDeploymentsListFilter built = builder.build();

        assertThat(built.environment()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabProjectDeploymentsListFilterBuilder builder = GitLabProjectDeploymentsListFilterBuilder.builder(
                        GitLabProjectDeploymentsListFilterBuilder.builder()
                                .orderBy(GitLabProjectDeploymentsListOrderBy.ID)
                                .sort(GitLabProjectDeploymentsListSort.ASC)
                                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .finishedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .finishedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .environment("environment")
                                .status(GitLabProjectDeploymentsListStatus.CREATED)
                                .build())
                .status(null);

        final GitLabProjectDeploymentsListFilter built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDeploymentsListFilter value = GitLabProjectDeploymentsListFilterBuilder.builder()
                .orderBy(GitLabProjectDeploymentsListOrderBy.ID)
                .sort(GitLabProjectDeploymentsListSort.ASC)
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .finishedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .finishedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .environment("environment")
                .status(GitLabProjectDeploymentsListStatus.CREATED)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.orderBy()).isEqualTo(GitLabProjectDeploymentsListOrderBy.ID);
            softly.assertThat(value.sort()).isEqualTo(GitLabProjectDeploymentsListSort.ASC);
            softly.assertThat(value.updatedAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.finishedAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.finishedBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.environment()).isEqualTo("environment");
            softly.assertThat(value.status()).isEqualTo(GitLabProjectDeploymentsListStatus.CREATED);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDeploymentsListFilter original = GitLabProjectDeploymentsListFilterBuilder.builder()
                .orderBy(GitLabProjectDeploymentsListOrderBy.ID)
                .sort(GitLabProjectDeploymentsListSort.ASC)
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .finishedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .finishedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .environment("environment")
                .status(GitLabProjectDeploymentsListStatus.CREATED)
                .build();

        final GitLabProjectDeploymentsListFilter rebuilt =
                GitLabProjectDeploymentsListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectDeploymentsListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "orderBy",
                        "sort",
                        "updatedAfter",
                        "updatedBefore",
                        "finishedAfter",
                        "finishedBefore",
                        "environment",
                        "status");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectDeploymentsListFilter empty = GitLabProjectDeploymentsListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectDeploymentsListFilter filter = GitLabProjectDeploymentsListFilterBuilder.builder()
                .orderBy(GitLabProjectDeploymentsListOrderBy.ID)
                .sort(GitLabProjectDeploymentsListSort.ASC)
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .finishedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .finishedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .environment("environment")
                .status(GitLabProjectDeploymentsListStatus.CREATED)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("order_by", "id"),
                        Map.entry("sort", "asc"),
                        Map.entry("updated_after", "2026-01-01T00:00:00Z"),
                        Map.entry("updated_before", "2026-01-01T00:00:00Z"),
                        Map.entry("finished_after", "2026-01-01T00:00:00Z"),
                        Map.entry("finished_before", "2026-01-01T00:00:00Z"),
                        Map.entry("environment", "environment"),
                        Map.entry("status", "created"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectDeploymentsListFilter filter = GitLabProjectDeploymentsListFilterBuilder.builder()
                .orderBy(GitLabProjectDeploymentsListOrderBy.ID)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("order_by", "id"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectDeploymentsListFilter filter = GitLabProjectDeploymentsListFilterBuilder.builder()
                .orderBy(GitLabProjectDeploymentsListOrderBy.ID)
                .sort(GitLabProjectDeploymentsListSort.ASC)
                .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .finishedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .finishedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .environment("environment")
                .status(GitLabProjectDeploymentsListStatus.CREATED)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
