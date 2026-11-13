package io.github.piotr_janczukowicz.gitlab.api.agents;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab cluster agent url configuration.
 *
 * @param id the id
 * @param agentId the agent id
 * @param url the url
 * @param publicKey the public key
 * @param clientCert the client cert
 * @param caCert the ca cert
 * @param tlsHost the tls host
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesClustersAgentUrlConfiguration")
public record GitLabClusterAgentUrlConfiguration(
        @Nullable Long id,
        @Nullable Long agentId,
        @Nullable String url,
        @Nullable String publicKey,
        @Nullable String clientCert,
        @Nullable String caCert,
        @Nullable String tlsHost) {}
