package io.github.piotr_janczukowicz.gitlab.api.agents;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdClusterAgentsAgentIdUrlConfigurations}.
 *
 * @param url the url
 * @param clientCert the client cert
 * @param clientKey the client key
 * @param caCert the ca cert
 * @param tlsHost the tls host
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdClusterAgentsAgentIdUrlConfigurations/requestBody")
public record GitLabProjectAgentsCreateUrlConfigurationPayload(
        @Nullable String url,
        @Nullable String clientCert,
        @Nullable String clientKey,
        @Nullable String caCert,
        @Nullable String tlsHost) {}
