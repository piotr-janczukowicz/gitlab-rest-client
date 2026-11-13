package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.LocalDate;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAnalyticsDeploymentFrequencyTest {

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabAnalyticsDeploymentFrequencyBuilder builder = GitLabAnalyticsDeploymentFrequencyBuilder.builder(
                        ProjectsCatalogFixtures.analyticsDeploymentFrequency())
                .value(null);

        final GitLabAnalyticsDeploymentFrequency built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFromValueIsNullable() {
        final GitLabAnalyticsDeploymentFrequencyBuilder builder = GitLabAnalyticsDeploymentFrequencyBuilder.builder(
                        ProjectsCatalogFixtures.analyticsDeploymentFrequency())
                .fromValue(null);

        final GitLabAnalyticsDeploymentFrequency built = builder.build();

        assertThat(built.fromValue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenToIsNullable() {
        final GitLabAnalyticsDeploymentFrequencyBuilder builder = GitLabAnalyticsDeploymentFrequencyBuilder.builder(
                        ProjectsCatalogFixtures.analyticsDeploymentFrequency())
                .to(null);

        final GitLabAnalyticsDeploymentFrequency built = builder.build();

        assertThat(built.to()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAnalyticsDeploymentFrequency value = ProjectsCatalogFixtures.analyticsDeploymentFrequency();

        assertSoftly(softly -> {
            softly.assertThat(value.value()).isEqualTo(1);
            softly.assertThat(value.fromValue()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.to()).isEqualTo(LocalDate.parse("2026-01-01"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAnalyticsDeploymentFrequency original = ProjectsCatalogFixtures.analyticsDeploymentFrequency();

        final GitLabAnalyticsDeploymentFrequency rebuilt =
                GitLabAnalyticsDeploymentFrequencyBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabAnalyticsDeploymentFrequency.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("value", "fromValue", "to");
    }
}
