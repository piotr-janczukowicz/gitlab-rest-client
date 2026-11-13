package io.github.piotr_janczukowicz.gitlab.api.accesstokens;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.LocalDate;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupAccessTokensRotateSelfPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabGroupAccessTokensRotateSelfPayloadBuilder builder =
                GitLabGroupAccessTokensRotateSelfPayloadBuilder.builder(
                                AccesstokensCatalogFixtures.groupAccessTokensRotateSelfPayload())
                        .expiresAt(null);

        final GitLabGroupAccessTokensRotateSelfPayload built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupAccessTokensRotateSelfPayload value =
                AccesstokensCatalogFixtures.groupAccessTokensRotateSelfPayload();

        assertThat(value.expiresAt()).isEqualTo(LocalDate.parse("2026-01-01"));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupAccessTokensRotateSelfPayload original =
                AccesstokensCatalogFixtures.groupAccessTokensRotateSelfPayload();

        final GitLabGroupAccessTokensRotateSelfPayload rebuilt =
                GitLabGroupAccessTokensRotateSelfPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupAccessTokensRotateSelfPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("expiresAt");
    }
}
