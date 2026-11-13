package io.github.piotr_janczukowicz.gitlab.api.serviceaccounts;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.LocalDate;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupServiceAccountsRotatePersonalAccessTokenPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabGroupServiceAccountsRotatePersonalAccessTokenPayloadBuilder builder =
                GitLabGroupServiceAccountsRotatePersonalAccessTokenPayloadBuilder.builder(
                                ServiceaccountsCatalogFixtures.groupServiceAccountsRotatePersonalAccessTokenPayload())
                        .expiresAt(null);

        final GitLabGroupServiceAccountsRotatePersonalAccessTokenPayload built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupServiceAccountsRotatePersonalAccessTokenPayload value =
                ServiceaccountsCatalogFixtures.groupServiceAccountsRotatePersonalAccessTokenPayload();

        assertThat(value.expiresAt()).isEqualTo(LocalDate.parse("2026-01-01"));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupServiceAccountsRotatePersonalAccessTokenPayload original =
                ServiceaccountsCatalogFixtures.groupServiceAccountsRotatePersonalAccessTokenPayload();

        final GitLabGroupServiceAccountsRotatePersonalAccessTokenPayload rebuilt =
                GitLabGroupServiceAccountsRotatePersonalAccessTokenPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupServiceAccountsRotatePersonalAccessTokenPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("expiresAt");
    }
}
