package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiRunnerControllerTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabCiRunnerControllerBuilder builder = GitLabCiRunnerControllerBuilder.builder(
                        CommonCatalogFixtures.ciRunnerController())
                .id(null);

        final GitLabCiRunnerController built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabCiRunnerControllerBuilder builder = GitLabCiRunnerControllerBuilder.builder(
                        CommonCatalogFixtures.ciRunnerController())
                .description(null);

        final GitLabCiRunnerController built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabCiRunnerControllerBuilder builder = GitLabCiRunnerControllerBuilder.builder(
                        CommonCatalogFixtures.ciRunnerController())
                .state(null);

        final GitLabCiRunnerController built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabCiRunnerControllerBuilder builder = GitLabCiRunnerControllerBuilder.builder(
                        CommonCatalogFixtures.ciRunnerController())
                .createdAt(null);

        final GitLabCiRunnerController built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabCiRunnerControllerBuilder builder = GitLabCiRunnerControllerBuilder.builder(
                        CommonCatalogFixtures.ciRunnerController())
                .updatedAt(null);

        final GitLabCiRunnerController built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiRunnerController value = CommonCatalogFixtures.ciRunnerController();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.description()).isEqualTo("Controller for managing runner");
            softly.assertThat(value.state()).isEqualTo("enabled");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiRunnerController original = CommonCatalogFixtures.ciRunnerController();

        final GitLabCiRunnerController rebuilt =
                GitLabCiRunnerControllerBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiRunnerController.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "description", "state", "createdAt", "updatedAt");
    }
}
