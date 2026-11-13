package io.github.piotr_janczukowicz.gitlab.api.runnercontrollers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiRunnerControllerInstanceLevelScopingTest {

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabCiRunnerControllerInstanceLevelScopingBuilder builder =
                GitLabCiRunnerControllerInstanceLevelScopingBuilder.builder(
                                RunnercontrollersCatalogFixtures.ciRunnerControllerInstanceLevelScoping())
                        .createdAt(null);

        final GitLabCiRunnerControllerInstanceLevelScoping built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabCiRunnerControllerInstanceLevelScopingBuilder builder =
                GitLabCiRunnerControllerInstanceLevelScopingBuilder.builder(
                                RunnercontrollersCatalogFixtures.ciRunnerControllerInstanceLevelScoping())
                        .updatedAt(null);

        final GitLabCiRunnerControllerInstanceLevelScoping built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiRunnerControllerInstanceLevelScoping value =
                RunnercontrollersCatalogFixtures.ciRunnerControllerInstanceLevelScoping();

        assertSoftly(softly -> {
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiRunnerControllerInstanceLevelScoping original =
                RunnercontrollersCatalogFixtures.ciRunnerControllerInstanceLevelScoping();

        final GitLabCiRunnerControllerInstanceLevelScoping rebuilt =
                GitLabCiRunnerControllerInstanceLevelScopingBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiRunnerControllerInstanceLevelScoping.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("createdAt", "updatedAt");
    }
}
