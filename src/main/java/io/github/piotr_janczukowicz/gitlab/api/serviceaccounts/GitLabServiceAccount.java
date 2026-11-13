package io.github.piotr_janczukowicz.gitlab.api.serviceaccounts;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab service account.
 *
 * @param id the id
 * @param username the username
 * @param publicEmail the public email
 * @param name the name
 * @param email the email
 * @param unconfirmedEmail the unconfirmed email
 * @param external the external
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesServiceAccount")
public record GitLabServiceAccount(
        @Nullable Long id,
        @Nullable String username,
        @Nullable String publicEmail,
        @Nullable String name,
        @Nullable String email,
        @Nullable String unconfirmedEmail,
        @Nullable Boolean external) {}
