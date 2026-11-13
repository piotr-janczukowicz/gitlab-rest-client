package io.github.piotr_janczukowicz.gitlab.api.pipelineschedules;

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
class GitLabProjectPipelineSchedulesListPipelinesFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenScopeIsNullable() {
        final GitLabProjectPipelineSchedulesListPipelinesFilterBuilder builder =
                GitLabProjectPipelineSchedulesListPipelinesFilterBuilder.builder(
                                GitLabProjectPipelineSchedulesListPipelinesFilterBuilder.builder()
                                        .scope(GitLabProjectPipelineSchedulesListPipelinesScope.RUNNING)
                                        .status(GitLabProjectPipelineSchedulesListPipelinesStatus.CREATED)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .sort(GitLabProjectPipelineSchedulesListPipelinesSort.ASC)
                                        .build())
                        .scope(null);

        final GitLabProjectPipelineSchedulesListPipelinesFilter built = builder.build();

        assertThat(built.scope()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabProjectPipelineSchedulesListPipelinesFilterBuilder builder =
                GitLabProjectPipelineSchedulesListPipelinesFilterBuilder.builder(
                                GitLabProjectPipelineSchedulesListPipelinesFilterBuilder.builder()
                                        .scope(GitLabProjectPipelineSchedulesListPipelinesScope.RUNNING)
                                        .status(GitLabProjectPipelineSchedulesListPipelinesStatus.CREATED)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .sort(GitLabProjectPipelineSchedulesListPipelinesSort.ASC)
                                        .build())
                        .status(null);

        final GitLabProjectPipelineSchedulesListPipelinesFilter built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedBeforeIsNullable() {
        final GitLabProjectPipelineSchedulesListPipelinesFilterBuilder builder =
                GitLabProjectPipelineSchedulesListPipelinesFilterBuilder.builder(
                                GitLabProjectPipelineSchedulesListPipelinesFilterBuilder.builder()
                                        .scope(GitLabProjectPipelineSchedulesListPipelinesScope.RUNNING)
                                        .status(GitLabProjectPipelineSchedulesListPipelinesStatus.CREATED)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .sort(GitLabProjectPipelineSchedulesListPipelinesSort.ASC)
                                        .build())
                        .updatedBefore(null);

        final GitLabProjectPipelineSchedulesListPipelinesFilter built = builder.build();

        assertThat(built.updatedBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAfterIsNullable() {
        final GitLabProjectPipelineSchedulesListPipelinesFilterBuilder builder =
                GitLabProjectPipelineSchedulesListPipelinesFilterBuilder.builder(
                                GitLabProjectPipelineSchedulesListPipelinesFilterBuilder.builder()
                                        .scope(GitLabProjectPipelineSchedulesListPipelinesScope.RUNNING)
                                        .status(GitLabProjectPipelineSchedulesListPipelinesStatus.CREATED)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .sort(GitLabProjectPipelineSchedulesListPipelinesSort.ASC)
                                        .build())
                        .updatedAfter(null);

        final GitLabProjectPipelineSchedulesListPipelinesFilter built = builder.build();

        assertThat(built.updatedAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedBeforeIsNullable() {
        final GitLabProjectPipelineSchedulesListPipelinesFilterBuilder builder =
                GitLabProjectPipelineSchedulesListPipelinesFilterBuilder.builder(
                                GitLabProjectPipelineSchedulesListPipelinesFilterBuilder.builder()
                                        .scope(GitLabProjectPipelineSchedulesListPipelinesScope.RUNNING)
                                        .status(GitLabProjectPipelineSchedulesListPipelinesStatus.CREATED)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .sort(GitLabProjectPipelineSchedulesListPipelinesSort.ASC)
                                        .build())
                        .createdBefore(null);

        final GitLabProjectPipelineSchedulesListPipelinesFilter built = builder.build();

        assertThat(built.createdBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAfterIsNullable() {
        final GitLabProjectPipelineSchedulesListPipelinesFilterBuilder builder =
                GitLabProjectPipelineSchedulesListPipelinesFilterBuilder.builder(
                                GitLabProjectPipelineSchedulesListPipelinesFilterBuilder.builder()
                                        .scope(GitLabProjectPipelineSchedulesListPipelinesScope.RUNNING)
                                        .status(GitLabProjectPipelineSchedulesListPipelinesStatus.CREATED)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .sort(GitLabProjectPipelineSchedulesListPipelinesSort.ASC)
                                        .build())
                        .createdAfter(null);

        final GitLabProjectPipelineSchedulesListPipelinesFilter built = builder.build();

        assertThat(built.createdAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSortIsNullable() {
        final GitLabProjectPipelineSchedulesListPipelinesFilterBuilder builder =
                GitLabProjectPipelineSchedulesListPipelinesFilterBuilder.builder(
                                GitLabProjectPipelineSchedulesListPipelinesFilterBuilder.builder()
                                        .scope(GitLabProjectPipelineSchedulesListPipelinesScope.RUNNING)
                                        .status(GitLabProjectPipelineSchedulesListPipelinesStatus.CREATED)
                                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                        .sort(GitLabProjectPipelineSchedulesListPipelinesSort.ASC)
                                        .build())
                        .sort(null);

        final GitLabProjectPipelineSchedulesListPipelinesFilter built = builder.build();

        assertThat(built.sort()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectPipelineSchedulesListPipelinesFilter value =
                GitLabProjectPipelineSchedulesListPipelinesFilterBuilder.builder()
                        .scope(GitLabProjectPipelineSchedulesListPipelinesScope.RUNNING)
                        .status(GitLabProjectPipelineSchedulesListPipelinesStatus.CREATED)
                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .sort(GitLabProjectPipelineSchedulesListPipelinesSort.ASC)
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.scope()).isEqualTo(GitLabProjectPipelineSchedulesListPipelinesScope.RUNNING);
            softly.assertThat(value.status()).isEqualTo(GitLabProjectPipelineSchedulesListPipelinesStatus.CREATED);
            softly.assertThat(value.updatedBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.createdBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.createdAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.sort()).isEqualTo(GitLabProjectPipelineSchedulesListPipelinesSort.ASC);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectPipelineSchedulesListPipelinesFilter original =
                GitLabProjectPipelineSchedulesListPipelinesFilterBuilder.builder()
                        .scope(GitLabProjectPipelineSchedulesListPipelinesScope.RUNNING)
                        .status(GitLabProjectPipelineSchedulesListPipelinesStatus.CREATED)
                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .sort(GitLabProjectPipelineSchedulesListPipelinesSort.ASC)
                        .build();

        final GitLabProjectPipelineSchedulesListPipelinesFilter rebuilt =
                GitLabProjectPipelineSchedulesListPipelinesFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectPipelineSchedulesListPipelinesFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "scope", "status", "updatedBefore", "updatedAfter", "createdBefore", "createdAfter", "sort");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectPipelineSchedulesListPipelinesFilter empty =
                GitLabProjectPipelineSchedulesListPipelinesFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectPipelineSchedulesListPipelinesFilter filter =
                GitLabProjectPipelineSchedulesListPipelinesFilterBuilder.builder()
                        .scope(GitLabProjectPipelineSchedulesListPipelinesScope.RUNNING)
                        .status(GitLabProjectPipelineSchedulesListPipelinesStatus.CREATED)
                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .sort(GitLabProjectPipelineSchedulesListPipelinesSort.ASC)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("scope", "running"),
                        Map.entry("status", "created"),
                        Map.entry("updated_before", "2026-01-01T00:00:00Z"),
                        Map.entry("updated_after", "2026-01-01T00:00:00Z"),
                        Map.entry("created_before", "2026-01-01T00:00:00Z"),
                        Map.entry("created_after", "2026-01-01T00:00:00Z"),
                        Map.entry("sort", "asc"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectPipelineSchedulesListPipelinesFilter filter =
                GitLabProjectPipelineSchedulesListPipelinesFilterBuilder.builder()
                        .scope(GitLabProjectPipelineSchedulesListPipelinesScope.RUNNING)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("scope", "running"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectPipelineSchedulesListPipelinesFilter filter =
                GitLabProjectPipelineSchedulesListPipelinesFilterBuilder.builder()
                        .scope(GitLabProjectPipelineSchedulesListPipelinesScope.RUNNING)
                        .status(GitLabProjectPipelineSchedulesListPipelinesStatus.CREATED)
                        .updatedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .updatedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .sort(GitLabProjectPipelineSchedulesListPipelinesSort.ASC)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
