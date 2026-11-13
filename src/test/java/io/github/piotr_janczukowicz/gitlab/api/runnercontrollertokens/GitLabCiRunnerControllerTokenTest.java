package io.github.piotr_janczukowicz.gitlab.api.runnercontrollertokens;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiRunnerControllerTokenTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabCiRunnerControllerTokenBuilder builder = GitLabCiRunnerControllerTokenBuilder.builder(
                        RunnercontrollertokensCatalogFixtures.ciRunnerControllerToken())
                .id(null);

        final GitLabCiRunnerControllerToken built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunnerControllerIdIsNullable() {
        final GitLabCiRunnerControllerTokenBuilder builder = GitLabCiRunnerControllerTokenBuilder.builder(
                        RunnercontrollertokensCatalogFixtures.ciRunnerControllerToken())
                .runnerControllerId(null);

        final GitLabCiRunnerControllerToken built = builder.build();

        assertThat(built.runnerControllerId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabCiRunnerControllerTokenBuilder builder = GitLabCiRunnerControllerTokenBuilder.builder(
                        RunnercontrollertokensCatalogFixtures.ciRunnerControllerToken())
                .description(null);

        final GitLabCiRunnerControllerToken built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastUsedAtIsNullable() {
        final GitLabCiRunnerControllerTokenBuilder builder = GitLabCiRunnerControllerTokenBuilder.builder(
                        RunnercontrollertokensCatalogFixtures.ciRunnerControllerToken())
                .lastUsedAt(null);

        final GitLabCiRunnerControllerToken built = builder.build();

        assertThat(built.lastUsedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabCiRunnerControllerTokenBuilder builder = GitLabCiRunnerControllerTokenBuilder.builder(
                        RunnercontrollertokensCatalogFixtures.ciRunnerControllerToken())
                .createdAt(null);

        final GitLabCiRunnerControllerToken built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabCiRunnerControllerTokenBuilder builder = GitLabCiRunnerControllerTokenBuilder.builder(
                        RunnercontrollertokensCatalogFixtures.ciRunnerControllerToken())
                .updatedAt(null);

        final GitLabCiRunnerControllerToken built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiRunnerControllerToken value = RunnercontrollertokensCatalogFixtures.ciRunnerControllerToken();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.runnerControllerId()).isEqualTo(1L);
            softly.assertThat(value.description()).isEqualTo("Controller for managing runner");
            softly.assertThat(value.lastUsedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiRunnerControllerToken original = RunnercontrollertokensCatalogFixtures.ciRunnerControllerToken();

        final GitLabCiRunnerControllerToken rebuilt =
                GitLabCiRunnerControllerTokenBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiRunnerControllerToken.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("id", "runnerControllerId", "description", "lastUsedAt", "createdAt", "updatedAt");
    }
}
