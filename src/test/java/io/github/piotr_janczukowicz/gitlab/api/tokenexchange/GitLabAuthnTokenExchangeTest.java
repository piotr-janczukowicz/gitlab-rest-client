package io.github.piotr_janczukowicz.gitlab.api.tokenexchange;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAuthnTokenExchangeTest {

    @Test
    void constructor_shouldAcceptNull_whenAccessTokenIsNullable() {
        final GitLabAuthnTokenExchangeBuilder builder = GitLabAuthnTokenExchangeBuilder.builder(
                        TokenexchangeCatalogFixtures.authnTokenExchange())
                .accessToken(null);

        final GitLabAuthnTokenExchange built = builder.build();

        assertThat(built.accessToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuedTokenTypeIsNullable() {
        final GitLabAuthnTokenExchangeBuilder builder = GitLabAuthnTokenExchangeBuilder.builder(
                        TokenexchangeCatalogFixtures.authnTokenExchange())
                .issuedTokenType(null);

        final GitLabAuthnTokenExchange built = builder.build();

        assertThat(built.issuedTokenType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenTypeIsNullable() {
        final GitLabAuthnTokenExchangeBuilder builder = GitLabAuthnTokenExchangeBuilder.builder(
                        TokenexchangeCatalogFixtures.authnTokenExchange())
                .tokenType(null);

        final GitLabAuthnTokenExchange built = builder.build();

        assertThat(built.tokenType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresInIsNullable() {
        final GitLabAuthnTokenExchangeBuilder builder = GitLabAuthnTokenExchangeBuilder.builder(
                        TokenexchangeCatalogFixtures.authnTokenExchange())
                .expiresIn(null);

        final GitLabAuthnTokenExchange built = builder.build();

        assertThat(built.expiresIn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabAuthnTokenExchangeBuilder builder = GitLabAuthnTokenExchangeBuilder.builder(
                        TokenexchangeCatalogFixtures.authnTokenExchange())
                .token(null);

        final GitLabAuthnTokenExchange built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAuthnTokenExchange value = TokenexchangeCatalogFixtures.authnTokenExchange();

        assertSoftly(softly -> {
            softly.assertThat(value.accessToken()).isEqualTo("eyJhbGciOiJSUzI1NiJ9...");
            softly.assertThat(value.issuedTokenType()).isEqualTo("urn:ietf:params:oauth:token-type:jwt");
            softly.assertThat(value.tokenType()).isEqualTo("Bearer");
            softly.assertThat(value.expiresIn()).isEqualTo(1);
            softly.assertThat(value.token()).isEqualTo("eyJhbGciOiJSUzI1NiJ9...");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAuthnTokenExchange original = TokenexchangeCatalogFixtures.authnTokenExchange();

        final GitLabAuthnTokenExchange rebuilt =
                GitLabAuthnTokenExchangeBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenAccessTokenIsACredential() {
        final GitLabAuthnTokenExchange value = TokenexchangeCatalogFixtures.authnTokenExchange();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabAuthnTokenExchange value = TokenexchangeCatalogFixtures.authnTokenExchange();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabAuthnTokenExchange.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("accessToken", "issuedTokenType", "tokenType", "expiresIn", "token");
    }
}
