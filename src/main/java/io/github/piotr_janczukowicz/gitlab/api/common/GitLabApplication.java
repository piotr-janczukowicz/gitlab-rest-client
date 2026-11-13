package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab application.
 *
 * @param id the id
 * @param applicationId the application id
 * @param applicationName the application name
 * @param callbackUrl the callback url
 * @param confidential the confidential
 * @param scopes the scopes
 * @param granularScopes the granular scopes
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesApplication")
public record GitLabApplication(
        @Nullable Long id,
        @Nullable String applicationId,
        @Nullable String applicationName,
        @Nullable String callbackUrl,
        @Nullable Boolean confidential,
        @Nullable List<String> scopes,
        @Nullable List<GitLabGranularScope> granularScopes) {}
