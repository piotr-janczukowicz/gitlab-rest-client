package io.github.piotr_janczukowicz.gitlab.api.runnercontrollers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiRunnerControllerRunnerLevelScopingTest {

    @Test
    void constructor_shouldAcceptNull_whenRunnerIdIsNullable() {
        final GitLabCiRunnerControllerRunnerLevelScopingBuilder builder =
                GitLabCiRunnerControllerRunnerLevelScopingBuilder.builder(
                                RunnercontrollersCatalogFixtures.ciRunnerControllerRunnerLevelScoping())
                        .runnerId(null);

        final GitLabCiRunnerControllerRunnerLevelScoping built = builder.build();

        assertThat(built.runnerId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabCiRunnerControllerRunnerLevelScopingBuilder builder =
                GitLabCiRunnerControllerRunnerLevelScopingBuilder.builder(
                                RunnercontrollersCatalogFixtures.ciRunnerControllerRunnerLevelScoping())
                        .createdAt(null);

        final GitLabCiRunnerControllerRunnerLevelScoping built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabCiRunnerControllerRunnerLevelScopingBuilder builder =
                GitLabCiRunnerControllerRunnerLevelScopingBuilder.builder(
                                RunnercontrollersCatalogFixtures.ciRunnerControllerRunnerLevelScoping())
                        .updatedAt(null);

        final GitLabCiRunnerControllerRunnerLevelScoping built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiRunnerControllerRunnerLevelScoping value =
                RunnercontrollersCatalogFixtures.ciRunnerControllerRunnerLevelScoping();

        assertSoftly(softly -> {
            softly.assertThat(value.runnerId()).isEqualTo(1L);
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiRunnerControllerRunnerLevelScoping original =
                RunnercontrollersCatalogFixtures.ciRunnerControllerRunnerLevelScoping();

        final GitLabCiRunnerControllerRunnerLevelScoping rebuilt =
                GitLabCiRunnerControllerRunnerLevelScopingBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiRunnerControllerRunnerLevelScoping.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("runnerId", "createdAt", "updatedAt");
    }
}
