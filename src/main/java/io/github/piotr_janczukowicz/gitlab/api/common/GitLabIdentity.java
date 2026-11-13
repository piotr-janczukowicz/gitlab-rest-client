package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab identity.
 *
 * @param provider the provider
 * @param externUid the extern uid
 * @param samlProviderId the saml provider id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesIdentity")
public record GitLabIdentity(
        @Nullable String provider,
        @Nullable String externUid,
        @Nullable Long samlProviderId) {}
