package io.github.piotr_janczukowicz.gitlab.api.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab user credit card validations.
 *
 * @param userId the user id
 * @param creditCardValidatedAt the credit card validated at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesUserCreditCardValidations")
public record GitLabUserCreditCardValidations(
        @Nullable String userId,

        @Nullable @SuppressSchemaTypeMismatch("type rule: date-time (credit_card_validated_at)")
        Instant creditCardValidatedAt) {}
