package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiRunnerRegistrationDetailsTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabCiRunnerRegistrationDetailsBuilder builder = GitLabCiRunnerRegistrationDetailsBuilder.builder(
                        CommonCatalogFixtures.ciRunnerRegistrationDetails())
                .id(null);

        final GitLabCiRunnerRegistrationDetails built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabCiRunnerRegistrationDetailsBuilder builder = GitLabCiRunnerRegistrationDetailsBuilder.builder(
                        CommonCatalogFixtures.ciRunnerRegistrationDetails())
                .token(null);

        final GitLabCiRunnerRegistrationDetails built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenExpiresAtIsNullable() {
        final GitLabCiRunnerRegistrationDetailsBuilder builder = GitLabCiRunnerRegistrationDetailsBuilder.builder(
                        CommonCatalogFixtures.ciRunnerRegistrationDetails())
                .tokenExpiresAt(null);

        final GitLabCiRunnerRegistrationDetails built = builder.build();

        assertThat(built.tokenExpiresAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiRunnerRegistrationDetails value = CommonCatalogFixtures.ciRunnerRegistrationDetails();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo("id");
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.tokenExpiresAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiRunnerRegistrationDetails original = CommonCatalogFixtures.ciRunnerRegistrationDetails();

        final GitLabCiRunnerRegistrationDetails rebuilt =
                GitLabCiRunnerRegistrationDetailsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabCiRunnerRegistrationDetails value = CommonCatalogFixtures.ciRunnerRegistrationDetails();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void constructor_shouldKeepTheInstant_whenTokenExpiresAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabCiRunnerRegistrationDetailsBuilder builder = GitLabCiRunnerRegistrationDetailsBuilder.builder(
                        CommonCatalogFixtures.ciRunnerRegistrationDetails())
                .tokenExpiresAt(instant);

        final GitLabCiRunnerRegistrationDetails built = builder.build();

        assertThat(built.tokenExpiresAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiRunnerRegistrationDetails.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "token", "tokenExpiresAt");
    }
}
