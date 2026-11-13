package io.github.piotr_janczukowicz.gitlab.api.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4UserUserIdCreditCardValidation}.
 *
 * @param creditCardValidatedAt the credit card validated at
 * @param creditCardExpirationMonth the credit card expiration month
 * @param creditCardExpirationYear the credit card expiration year
 * @param creditCardHolderName the credit card holder name
 * @param creditCardMaskNumber the credit card mask number
 * @param creditCardType the credit card type
 * @param zuoraPaymentMethodXid the zuora payment method xid
 * @param stripeSetupIntentXid the stripe setup intent xid
 * @param stripePaymentMethodXid the stripe payment method xid
 * @param stripeCardFingerprint the stripe card fingerprint
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4UserUserIdCreditCardValidation/requestBody")
public record GitLabUsersCreditCardValidationPayload(
        @Nullable Instant creditCardValidatedAt,
        @Nullable Integer creditCardExpirationMonth,
        @Nullable Integer creditCardExpirationYear,
        @Nullable String creditCardHolderName,
        @Nullable String creditCardMaskNumber,
        @Nullable String creditCardType,
        @Nullable String zuoraPaymentMethodXid,
        @Nullable String stripeSetupIntentXid,
        @Nullable String stripePaymentMethodXid,
        @Nullable String stripeCardFingerprint) {}
