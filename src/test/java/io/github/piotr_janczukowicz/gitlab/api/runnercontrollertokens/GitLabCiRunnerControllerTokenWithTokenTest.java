package io.github.piotr_janczukowicz.gitlab.api.runnercontrollertokens;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiRunnerControllerTokenWithTokenTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabCiRunnerControllerTokenWithTokenBuilder builder =
                GitLabCiRunnerControllerTokenWithTokenBuilder.builder(
                                RunnercontrollertokensCatalogFixtures.ciRunnerControllerTokenWithToken())
                        .id(null);

        final GitLabCiRunnerControllerTokenWithToken built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunnerControllerIdIsNullable() {
        final GitLabCiRunnerControllerTokenWithTokenBuilder builder =
                GitLabCiRunnerControllerTokenWithTokenBuilder.builder(
                                RunnercontrollertokensCatalogFixtures.ciRunnerControllerTokenWithToken())
                        .runnerControllerId(null);

        final GitLabCiRunnerControllerTokenWithToken built = builder.build();

        assertThat(built.runnerControllerId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabCiRunnerControllerTokenWithTokenBuilder builder =
                GitLabCiRunnerControllerTokenWithTokenBuilder.builder(
                                RunnercontrollertokensCatalogFixtures.ciRunnerControllerTokenWithToken())
                        .description(null);

        final GitLabCiRunnerControllerTokenWithToken built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastUsedAtIsNullable() {
        final GitLabCiRunnerControllerTokenWithTokenBuilder builder =
                GitLabCiRunnerControllerTokenWithTokenBuilder.builder(
                                RunnercontrollertokensCatalogFixtures.ciRunnerControllerTokenWithToken())
                        .lastUsedAt(null);

        final GitLabCiRunnerControllerTokenWithToken built = builder.build();

        assertThat(built.lastUsedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabCiRunnerControllerTokenWithTokenBuilder builder =
                GitLabCiRunnerControllerTokenWithTokenBuilder.builder(
                                RunnercontrollertokensCatalogFixtures.ciRunnerControllerTokenWithToken())
                        .createdAt(null);

        final GitLabCiRunnerControllerTokenWithToken built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabCiRunnerControllerTokenWithTokenBuilder builder =
                GitLabCiRunnerControllerTokenWithTokenBuilder.builder(
                                RunnercontrollertokensCatalogFixtures.ciRunnerControllerTokenWithToken())
                        .updatedAt(null);

        final GitLabCiRunnerControllerTokenWithToken built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabCiRunnerControllerTokenWithTokenBuilder builder =
                GitLabCiRunnerControllerTokenWithTokenBuilder.builder(
                                RunnercontrollertokensCatalogFixtures.ciRunnerControllerTokenWithToken())
                        .token(null);

        final GitLabCiRunnerControllerTokenWithToken built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiRunnerControllerTokenWithToken value =
                RunnercontrollertokensCatalogFixtures.ciRunnerControllerTokenWithToken();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.runnerControllerId()).isEqualTo(1L);
            softly.assertThat(value.description()).isEqualTo("Controller for managing runner");
            softly.assertThat(value.lastUsedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.token()).isEqualTo("token");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiRunnerControllerTokenWithToken original =
                RunnercontrollertokensCatalogFixtures.ciRunnerControllerTokenWithToken();

        final GitLabCiRunnerControllerTokenWithToken rebuilt =
                GitLabCiRunnerControllerTokenWithTokenBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabCiRunnerControllerTokenWithToken value =
                RunnercontrollertokensCatalogFixtures.ciRunnerControllerTokenWithToken();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiRunnerControllerTokenWithToken.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id", "runnerControllerId", "description", "lastUsedAt", "createdAt", "updatedAt", "token");
    }
}
