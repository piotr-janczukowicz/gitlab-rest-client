package io.github.piotr_janczukowicz.gitlab.api.runnercontrollers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiRunnerControllerDetailTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabCiRunnerControllerDetailBuilder builder = GitLabCiRunnerControllerDetailBuilder.builder(
                        RunnercontrollersCatalogFixtures.ciRunnerControllerDetail())
                .id(null);

        final GitLabCiRunnerControllerDetail built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabCiRunnerControllerDetailBuilder builder = GitLabCiRunnerControllerDetailBuilder.builder(
                        RunnercontrollersCatalogFixtures.ciRunnerControllerDetail())
                .description(null);

        final GitLabCiRunnerControllerDetail built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabCiRunnerControllerDetailBuilder builder = GitLabCiRunnerControllerDetailBuilder.builder(
                        RunnercontrollersCatalogFixtures.ciRunnerControllerDetail())
                .state(null);

        final GitLabCiRunnerControllerDetail built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabCiRunnerControllerDetailBuilder builder = GitLabCiRunnerControllerDetailBuilder.builder(
                        RunnercontrollersCatalogFixtures.ciRunnerControllerDetail())
                .createdAt(null);

        final GitLabCiRunnerControllerDetail built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabCiRunnerControllerDetailBuilder builder = GitLabCiRunnerControllerDetailBuilder.builder(
                        RunnercontrollersCatalogFixtures.ciRunnerControllerDetail())
                .updatedAt(null);

        final GitLabCiRunnerControllerDetail built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConnectedIsNullable() {
        final GitLabCiRunnerControllerDetailBuilder builder = GitLabCiRunnerControllerDetailBuilder.builder(
                        RunnercontrollersCatalogFixtures.ciRunnerControllerDetail())
                .connected(null);

        final GitLabCiRunnerControllerDetail built = builder.build();

        assertThat(built.connected()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiRunnerControllerDetail value = RunnercontrollersCatalogFixtures.ciRunnerControllerDetail();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.description()).isEqualTo("Controller for managing runner");
            softly.assertThat(value.state()).isEqualTo("enabled");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.connected()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiRunnerControllerDetail original = RunnercontrollersCatalogFixtures.ciRunnerControllerDetail();

        final GitLabCiRunnerControllerDetail rebuilt =
                GitLabCiRunnerControllerDetailBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiRunnerControllerDetail.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "description", "state", "createdAt", "updatedAt", "connected");
    }
}
