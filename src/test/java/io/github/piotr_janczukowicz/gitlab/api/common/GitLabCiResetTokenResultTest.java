package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiResetTokenResultTest {

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabCiResetTokenResultBuilder builder = GitLabCiResetTokenResultBuilder.builder(
                        CommonCatalogFixtures.ciResetTokenResult())
                .token(null);

        final GitLabCiResetTokenResult built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenExpiresAtIsNullable() {
        final GitLabCiResetTokenResultBuilder builder = GitLabCiResetTokenResultBuilder.builder(
                        CommonCatalogFixtures.ciResetTokenResult())
                .tokenExpiresAt(null);

        final GitLabCiResetTokenResult built = builder.build();

        assertThat(built.tokenExpiresAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiResetTokenResult value = CommonCatalogFixtures.ciResetTokenResult();

        assertSoftly(softly -> {
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.tokenExpiresAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiResetTokenResult original = CommonCatalogFixtures.ciResetTokenResult();

        final GitLabCiResetTokenResult rebuilt =
                GitLabCiResetTokenResultBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabCiResetTokenResult value = CommonCatalogFixtures.ciResetTokenResult();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void constructor_shouldKeepTheInstant_whenTokenExpiresAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabCiResetTokenResultBuilder builder = GitLabCiResetTokenResultBuilder.builder(
                        CommonCatalogFixtures.ciResetTokenResult())
                .tokenExpiresAt(instant);

        final GitLabCiResetTokenResult built = builder.build();

        assertThat(built.tokenExpiresAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiResetTokenResult.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("token", "tokenExpiresAt");
    }
}
