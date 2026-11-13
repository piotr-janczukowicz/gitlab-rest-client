package io.github.piotr_janczukowicz.gitlab.api.personalaccesstokens;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.LocalDate;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabPersonalAccessTokensRotateSelfPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabPersonalAccessTokensRotateSelfPayloadBuilder builder =
                GitLabPersonalAccessTokensRotateSelfPayloadBuilder.builder(
                                PersonalaccesstokensCatalogFixtures.personalAccessTokensRotateSelfPayload())
                        .expiresAt(null);

        final GitLabPersonalAccessTokensRotateSelfPayload built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPersonalAccessTokensRotateSelfPayload value =
                PersonalaccesstokensCatalogFixtures.personalAccessTokensRotateSelfPayload();

        assertThat(value.expiresAt()).isEqualTo(LocalDate.parse("2026-01-01"));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabPersonalAccessTokensRotateSelfPayload original =
                PersonalaccesstokensCatalogFixtures.personalAccessTokensRotateSelfPayload();

        final GitLabPersonalAccessTokensRotateSelfPayload rebuilt =
                GitLabPersonalAccessTokensRotateSelfPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabPersonalAccessTokensRotateSelfPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("expiresAt");
    }
}
