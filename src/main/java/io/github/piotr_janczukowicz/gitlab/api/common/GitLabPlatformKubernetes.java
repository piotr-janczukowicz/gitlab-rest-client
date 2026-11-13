package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab platform kubernetes.
 *
 * @param apiUrl the api url
 * @param namespace the namespace
 * @param authorizationType the authorization type
 * @param caCert the ca cert
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesPlatformKubernetes")
public record GitLabPlatformKubernetes(
        @Nullable String apiUrl,
        @Nullable String namespace,
        @Nullable String authorizationType,
        @Nullable String caCert) {}
