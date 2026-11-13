package io.github.piotr_janczukowicz.gitlab.api.projects;

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
class GitLabProjectProjectsListAnalyticsDeploymentFrequencyFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenToIsNullable() {
        final GitLabProjectProjectsListAnalyticsDeploymentFrequencyFilterBuilder builder =
                GitLabProjectProjectsListAnalyticsDeploymentFrequencyFilterBuilder.builder(
                                GitLabProjectProjectsListAnalyticsDeploymentFrequencyFilterBuilder.builder()
                                        .to(Instant.parse("2026-01-01T00:00:00Z"))
                                        .interval(GitLabProjectProjectsListAnalyticsDeploymentFrequencyInterval.ALL)
                                        .build())
                        .to(null);

        final GitLabProjectProjectsListAnalyticsDeploymentFrequencyFilter built = builder.build();

        assertThat(built.to()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIntervalIsNullable() {
        final GitLabProjectProjectsListAnalyticsDeploymentFrequencyFilterBuilder builder =
                GitLabProjectProjectsListAnalyticsDeploymentFrequencyFilterBuilder.builder(
                                GitLabProjectProjectsListAnalyticsDeploymentFrequencyFilterBuilder.builder()
                                        .to(Instant.parse("2026-01-01T00:00:00Z"))
                                        .interval(GitLabProjectProjectsListAnalyticsDeploymentFrequencyInterval.ALL)
                                        .build())
                        .interval(null);

        final GitLabProjectProjectsListAnalyticsDeploymentFrequencyFilter built = builder.build();

        assertThat(built.interval()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsListAnalyticsDeploymentFrequencyFilter value =
                GitLabProjectProjectsListAnalyticsDeploymentFrequencyFilterBuilder.builder()
                        .to(Instant.parse("2026-01-01T00:00:00Z"))
                        .interval(GitLabProjectProjectsListAnalyticsDeploymentFrequencyInterval.ALL)
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.to()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.interval())
                    .isEqualTo(GitLabProjectProjectsListAnalyticsDeploymentFrequencyInterval.ALL);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsListAnalyticsDeploymentFrequencyFilter original =
                GitLabProjectProjectsListAnalyticsDeploymentFrequencyFilterBuilder.builder()
                        .to(Instant.parse("2026-01-01T00:00:00Z"))
                        .interval(GitLabProjectProjectsListAnalyticsDeploymentFrequencyInterval.ALL)
                        .build();

        final GitLabProjectProjectsListAnalyticsDeploymentFrequencyFilter rebuilt =
                GitLabProjectProjectsListAnalyticsDeploymentFrequencyFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsListAnalyticsDeploymentFrequencyFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("to", "interval");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectProjectsListAnalyticsDeploymentFrequencyFilter empty =
                GitLabProjectProjectsListAnalyticsDeploymentFrequencyFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectProjectsListAnalyticsDeploymentFrequencyFilter filter =
                GitLabProjectProjectsListAnalyticsDeploymentFrequencyFilterBuilder.builder()
                        .to(Instant.parse("2026-01-01T00:00:00Z"))
                        .interval(GitLabProjectProjectsListAnalyticsDeploymentFrequencyInterval.ALL)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("to", "2026-01-01T00:00:00Z"), Map.entry("interval", "all"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectProjectsListAnalyticsDeploymentFrequencyFilter filter =
                GitLabProjectProjectsListAnalyticsDeploymentFrequencyFilterBuilder.builder()
                        .to(Instant.parse("2026-01-01T00:00:00Z"))
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("to", "2026-01-01T00:00:00Z"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectProjectsListAnalyticsDeploymentFrequencyFilter filter =
                GitLabProjectProjectsListAnalyticsDeploymentFrequencyFilterBuilder.builder()
                        .to(Instant.parse("2026-01-01T00:00:00Z"))
                        .interval(GitLabProjectProjectsListAnalyticsDeploymentFrequencyInterval.ALL)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
