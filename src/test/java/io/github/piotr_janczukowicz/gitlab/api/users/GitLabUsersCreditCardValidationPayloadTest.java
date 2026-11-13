package io.github.piotr_janczukowicz.gitlab.api.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabUsersCreditCardValidationPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenCreditCardValidatedAtIsNullable() {
        final GitLabUsersCreditCardValidationPayloadBuilder builder =
                GitLabUsersCreditCardValidationPayloadBuilder.builder(
                                UsersCatalogFixtures.usersCreditCardValidationPayload())
                        .creditCardValidatedAt(null);

        final GitLabUsersCreditCardValidationPayload built = builder.build();

        assertThat(built.creditCardValidatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreditCardExpirationMonthIsNullable() {
        final GitLabUsersCreditCardValidationPayloadBuilder builder =
                GitLabUsersCreditCardValidationPayloadBuilder.builder(
                                UsersCatalogFixtures.usersCreditCardValidationPayload())
                        .creditCardExpirationMonth(null);

        final GitLabUsersCreditCardValidationPayload built = builder.build();

        assertThat(built.creditCardExpirationMonth()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreditCardExpirationYearIsNullable() {
        final GitLabUsersCreditCardValidationPayloadBuilder builder =
                GitLabUsersCreditCardValidationPayloadBuilder.builder(
                                UsersCatalogFixtures.usersCreditCardValidationPayload())
                        .creditCardExpirationYear(null);

        final GitLabUsersCreditCardValidationPayload built = builder.build();

        assertThat(built.creditCardExpirationYear()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreditCardHolderNameIsNullable() {
        final GitLabUsersCreditCardValidationPayloadBuilder builder =
                GitLabUsersCreditCardValidationPayloadBuilder.builder(
                                UsersCatalogFixtures.usersCreditCardValidationPayload())
                        .creditCardHolderName(null);

        final GitLabUsersCreditCardValidationPayload built = builder.build();

        assertThat(built.creditCardHolderName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreditCardMaskNumberIsNullable() {
        final GitLabUsersCreditCardValidationPayloadBuilder builder =
                GitLabUsersCreditCardValidationPayloadBuilder.builder(
                                UsersCatalogFixtures.usersCreditCardValidationPayload())
                        .creditCardMaskNumber(null);

        final GitLabUsersCreditCardValidationPayload built = builder.build();

        assertThat(built.creditCardMaskNumber()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreditCardTypeIsNullable() {
        final GitLabUsersCreditCardValidationPayloadBuilder builder =
                GitLabUsersCreditCardValidationPayloadBuilder.builder(
                                UsersCatalogFixtures.usersCreditCardValidationPayload())
                        .creditCardType(null);

        final GitLabUsersCreditCardValidationPayload built = builder.build();

        assertThat(built.creditCardType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZuoraPaymentMethodXidIsNullable() {
        final GitLabUsersCreditCardValidationPayloadBuilder builder =
                GitLabUsersCreditCardValidationPayloadBuilder.builder(
                                UsersCatalogFixtures.usersCreditCardValidationPayload())
                        .zuoraPaymentMethodXid(null);

        final GitLabUsersCreditCardValidationPayload built = builder.build();

        assertThat(built.zuoraPaymentMethodXid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStripeSetupIntentXidIsNullable() {
        final GitLabUsersCreditCardValidationPayloadBuilder builder =
                GitLabUsersCreditCardValidationPayloadBuilder.builder(
                                UsersCatalogFixtures.usersCreditCardValidationPayload())
                        .stripeSetupIntentXid(null);

        final GitLabUsersCreditCardValidationPayload built = builder.build();

        assertThat(built.stripeSetupIntentXid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStripePaymentMethodXidIsNullable() {
        final GitLabUsersCreditCardValidationPayloadBuilder builder =
                GitLabUsersCreditCardValidationPayloadBuilder.builder(
                                UsersCatalogFixtures.usersCreditCardValidationPayload())
                        .stripePaymentMethodXid(null);

        final GitLabUsersCreditCardValidationPayload built = builder.build();

        assertThat(built.stripePaymentMethodXid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStripeCardFingerprintIsNullable() {
        final GitLabUsersCreditCardValidationPayloadBuilder builder =
                GitLabUsersCreditCardValidationPayloadBuilder.builder(
                                UsersCatalogFixtures.usersCreditCardValidationPayload())
                        .stripeCardFingerprint(null);

        final GitLabUsersCreditCardValidationPayload built = builder.build();

        assertThat(built.stripeCardFingerprint()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUsersCreditCardValidationPayload value = UsersCatalogFixtures.usersCreditCardValidationPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.creditCardValidatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.creditCardExpirationMonth()).isEqualTo(1);
            softly.assertThat(value.creditCardExpirationYear()).isEqualTo(1);
            softly.assertThat(value.creditCardHolderName()).isEqualTo("credit_card_holder_name");
            softly.assertThat(value.creditCardMaskNumber()).isEqualTo("credit_card_mask_number");
            softly.assertThat(value.creditCardType()).isEqualTo("credit_card_type");
            softly.assertThat(value.zuoraPaymentMethodXid()).isEqualTo("zuora_payment_method_xid");
            softly.assertThat(value.stripeSetupIntentXid()).isEqualTo("stripe_setup_intent_xid");
            softly.assertThat(value.stripePaymentMethodXid()).isEqualTo("stripe_payment_method_xid");
            softly.assertThat(value.stripeCardFingerprint()).isEqualTo("stripe_card_fingerprint");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUsersCreditCardValidationPayload original = UsersCatalogFixtures.usersCreditCardValidationPayload();

        final GitLabUsersCreditCardValidationPayload rebuilt =
                GitLabUsersCreditCardValidationPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUsersCreditCardValidationPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "creditCardValidatedAt",
                        "creditCardExpirationMonth",
                        "creditCardExpirationYear",
                        "creditCardHolderName",
                        "creditCardMaskNumber",
                        "creditCardType",
                        "zuoraPaymentMethodXid",
                        "stripeSetupIntentXid",
                        "stripePaymentMethodXid",
                        "stripeCardFingerprint");
    }
}
