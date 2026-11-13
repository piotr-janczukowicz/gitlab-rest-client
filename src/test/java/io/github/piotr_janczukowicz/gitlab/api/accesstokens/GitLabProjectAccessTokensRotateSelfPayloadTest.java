package io.github.piotr_janczukowicz.gitlab.api.accesstokens;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.LocalDate;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectAccessTokensRotateSelfPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabProjectAccessTokensRotateSelfPayloadBuilder builder =
                GitLabProjectAccessTokensRotateSelfPayloadBuilder.builder(
                                AccesstokensCatalogFixtures.projectAccessTokensRotateSelfPayload())
                        .expiresAt(null);

        final GitLabProjectAccessTokensRotateSelfPayload built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectAccessTokensRotateSelfPayload value =
                AccesstokensCatalogFixtures.projectAccessTokensRotateSelfPayload();

        assertThat(value.expiresAt()).isEqualTo(LocalDate.parse("2026-01-01"));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectAccessTokensRotateSelfPayload original =
                AccesstokensCatalogFixtures.projectAccessTokensRotateSelfPayload();

        final GitLabProjectAccessTokensRotateSelfPayload rebuilt =
                GitLabProjectAccessTokensRotateSelfPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectAccessTokensRotateSelfPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("expiresAt");
    }
}
