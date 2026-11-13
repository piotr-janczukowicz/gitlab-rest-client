package io.github.piotr_janczukowicz.gitlab.api.personalaccesstokens;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.LocalDate;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabPersonalAccessTokensRotatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabPersonalAccessTokensRotatePayloadBuilder builder =
                GitLabPersonalAccessTokensRotatePayloadBuilder.builder(
                                PersonalaccesstokensCatalogFixtures.personalAccessTokensRotatePayload())
                        .expiresAt(null);

        final GitLabPersonalAccessTokensRotatePayload built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPersonalAccessTokensRotatePayload value =
                PersonalaccesstokensCatalogFixtures.personalAccessTokensRotatePayload();

        assertThat(value.expiresAt()).isEqualTo(LocalDate.parse("2026-01-01"));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabPersonalAccessTokensRotatePayload original =
                PersonalaccesstokensCatalogFixtures.personalAccessTokensRotatePayload();

        final GitLabPersonalAccessTokensRotatePayload rebuilt =
                GitLabPersonalAccessTokensRotatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabPersonalAccessTokensRotatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("expiresAt");
    }
}
