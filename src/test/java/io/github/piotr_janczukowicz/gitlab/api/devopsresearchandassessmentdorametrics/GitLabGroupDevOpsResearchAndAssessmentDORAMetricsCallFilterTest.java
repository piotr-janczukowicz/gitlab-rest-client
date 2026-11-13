package io.github.piotr_janczukowicz.gitlab.api.devopsresearchandassessmentdorametrics;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenStartDateIsNullable() {
        final GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilterBuilder builder =
                GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilterBuilder.builder(
                                GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilterBuilder.builder()
                                        .startDate(LocalDate.parse("2026-01-01"))
                                        .endDate(LocalDate.parse("2026-01-01"))
                                        .interval(GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallInterval.ALL)
                                        .environmentTiers(List.of(
                                                GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallEnvironmentTiers
                                                        .PRODUCTION))
                                        .build())
                        .startDate(null);

        final GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilter built = builder.build();

        assertThat(built.startDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEndDateIsNullable() {
        final GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilterBuilder builder =
                GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilterBuilder.builder(
                                GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilterBuilder.builder()
                                        .startDate(LocalDate.parse("2026-01-01"))
                                        .endDate(LocalDate.parse("2026-01-01"))
                                        .interval(GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallInterval.ALL)
                                        .environmentTiers(List.of(
                                                GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallEnvironmentTiers
                                                        .PRODUCTION))
                                        .build())
                        .endDate(null);

        final GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilter built = builder.build();

        assertThat(built.endDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIntervalIsNullable() {
        final GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilterBuilder builder =
                GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilterBuilder.builder(
                                GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilterBuilder.builder()
                                        .startDate(LocalDate.parse("2026-01-01"))
                                        .endDate(LocalDate.parse("2026-01-01"))
                                        .interval(GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallInterval.ALL)
                                        .environmentTiers(List.of(
                                                GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallEnvironmentTiers
                                                        .PRODUCTION))
                                        .build())
                        .interval(null);

        final GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilter built = builder.build();

        assertThat(built.interval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentTiersIsNullable() {
        final GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilterBuilder builder =
                GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilterBuilder.builder(
                                GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilterBuilder.builder()
                                        .startDate(LocalDate.parse("2026-01-01"))
                                        .endDate(LocalDate.parse("2026-01-01"))
                                        .interval(GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallInterval.ALL)
                                        .environmentTiers(List.of(
                                                GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallEnvironmentTiers
                                                        .PRODUCTION))
                                        .build())
                        .environmentTiers(null);

        final GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilter built = builder.build();

        assertThat(built.environmentTiers()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilter value =
                GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilterBuilder.builder()
                        .startDate(LocalDate.parse("2026-01-01"))
                        .endDate(LocalDate.parse("2026-01-01"))
                        .interval(GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallInterval.ALL)
                        .environmentTiers(List.of(
                                GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallEnvironmentTiers.PRODUCTION))
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.startDate()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.endDate()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.interval())
                    .isEqualTo(GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallInterval.ALL);
            softly.assertThat(value.environmentTiers())
                    .isEqualTo(
                            List.of(GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallEnvironmentTiers.PRODUCTION));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilter original =
                GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilterBuilder.builder()
                        .startDate(LocalDate.parse("2026-01-01"))
                        .endDate(LocalDate.parse("2026-01-01"))
                        .interval(GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallInterval.ALL)
                        .environmentTiers(List.of(
                                GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallEnvironmentTiers.PRODUCTION))
                        .build();

        final GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilter rebuilt =
                GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenEnvironmentTiersSourceChangesLater() {
        final List<GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallEnvironmentTiers> source = new ArrayList<>(
                List.of(GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallEnvironmentTiers.PRODUCTION));
        final GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilter built =
                GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilterBuilder.builder(
                                GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilterBuilder.builder()
                                        .startDate(LocalDate.parse("2026-01-01"))
                                        .endDate(LocalDate.parse("2026-01-01"))
                                        .interval(GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallInterval.ALL)
                                        .environmentTiers(List.of(
                                                GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallEnvironmentTiers
                                                        .PRODUCTION))
                                        .build())
                        .environmentTiers(source)
                        .build();
        source.clear();

        assertThat(built.environmentTiers()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenEnvironmentTiersIsRead() {
        final GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilter built =
                GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilterBuilder.builder()
                        .startDate(LocalDate.parse("2026-01-01"))
                        .endDate(LocalDate.parse("2026-01-01"))
                        .interval(GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallInterval.ALL)
                        .environmentTiers(List.of(
                                GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallEnvironmentTiers.PRODUCTION))
                        .build();
        final List<GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallEnvironmentTiers> values =
                built.environmentTiers();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("startDate", "endDate", "interval", "environmentTiers");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilter empty =
                GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilter filter =
                GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilterBuilder.builder()
                        .startDate(LocalDate.parse("2026-01-01"))
                        .endDate(LocalDate.parse("2026-01-01"))
                        .interval(GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallInterval.ALL)
                        .environmentTiers(List.of(
                                GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallEnvironmentTiers.PRODUCTION))
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("start_date", "2026-01-01"),
                        Map.entry("end_date", "2026-01-01"),
                        Map.entry("interval", "all"),
                        Map.entry("environment_tiers", "production"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilter filter =
                GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilterBuilder.builder()
                        .startDate(LocalDate.parse("2026-01-01"))
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("start_date", "2026-01-01"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilter filter =
                GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallFilterBuilder.builder()
                        .startDate(LocalDate.parse("2026-01-01"))
                        .endDate(LocalDate.parse("2026-01-01"))
                        .interval(GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallInterval.ALL)
                        .environmentTiers(List.of(
                                GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallEnvironmentTiers.PRODUCTION))
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
