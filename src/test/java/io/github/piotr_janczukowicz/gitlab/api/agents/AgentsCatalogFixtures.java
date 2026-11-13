package io.github.piotr_janczukowicz.gitlab.api.agents;

import java.time.Instant;

public final class AgentsCatalogFixtures {

    private AgentsCatalogFixtures() {}

    public static GitLabClusterAgentToken clusterAgentToken() {
        return GitLabClusterAgentTokenBuilder.builder()
                .id(1L)
                .name("name")
                .description("description")
                .agentId(1L)
                .status("status")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .createdByUserId(1L)
                .lastUsedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .build();
    }

    public static GitLabClusterAgentTokenBasic clusterAgentTokenBasic() {
        return GitLabClusterAgentTokenBasicBuilder.builder()
                .id(1L)
                .name("name")
                .description("description")
                .agentId(1L)
                .status("status")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .createdByUserId(1L)
                .build();
    }

    public static GitLabClusterAgentTokenWithToken clusterAgentTokenWithToken() {
        return GitLabClusterAgentTokenWithTokenBuilder.builder()
                .id(1L)
                .name("name")
                .description("description")
                .agentId(1L)
                .status("status")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .createdByUserId(1L)
                .lastUsedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .token("token")
                .build();
    }

    public static GitLabClusterAgentUrlConfiguration clusterAgentUrlConfiguration() {
        return GitLabClusterAgentUrlConfigurationBuilder.builder()
                .id(1L)
                .agentId(1L)
                .url("url")
                .publicKey("public_key")
                .clientCert("client_cert")
                .caCert("ca_cert")
                .tlsHost("tls_host")
                .build();
    }

    public static GitLabProjectAgentsCreatePayload projectAgentsCreatePayload() {
        return GitLabProjectAgentsCreatePayloadBuilder.builder().name("name").build();
    }

    public static GitLabProjectAgentsCreateTokenPayload projectAgentsCreateTokenPayload() {
        return GitLabProjectAgentsCreateTokenPayloadBuilder.builder()
                .name("name")
                .description("description")
                .build();
    }

    public static GitLabProjectAgentsCreateUrlConfigurationPayload projectAgentsCreateUrlConfigurationPayload() {
        return GitLabProjectAgentsCreateUrlConfigurationPayloadBuilder.builder()
                .url("url")
                .clientCert("client_cert")
                .clientKey("client_key")
                .caCert("ca_cert")
                .tlsHost("tls_host")
                .build();
    }
}
