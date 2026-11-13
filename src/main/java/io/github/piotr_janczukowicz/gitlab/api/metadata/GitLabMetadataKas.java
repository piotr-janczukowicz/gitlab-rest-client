package io.github.piotr_janczukowicz.gitlab.api.metadata;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab metadata kas of a GitLab resource.
 *
 * @param enabled the enabled
 * @param externalUrl the external url
 * @param externalK8sProxyUrl the external k8s proxy url
 * @param version the version
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesMetadata/properties/kas")
public record GitLabMetadataKas(
        @Nullable Boolean enabled,
        @Nullable @JsonProperty("externalUrl") String externalUrl,
        @Nullable @JsonProperty("externalK8sProxyUrl") String externalK8sProxyUrl,
        @Nullable String version) {}
