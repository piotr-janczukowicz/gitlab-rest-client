package io.github.piotr_janczukowicz.gitlab.api.agents;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabClusterAgentUrlConfigurationTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabClusterAgentUrlConfigurationBuilder builder = GitLabClusterAgentUrlConfigurationBuilder.builder(
                        AgentsCatalogFixtures.clusterAgentUrlConfiguration())
                .id(null);

        final GitLabClusterAgentUrlConfiguration built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAgentIdIsNullable() {
        final GitLabClusterAgentUrlConfigurationBuilder builder = GitLabClusterAgentUrlConfigurationBuilder.builder(
                        AgentsCatalogFixtures.clusterAgentUrlConfiguration())
                .agentId(null);

        final GitLabClusterAgentUrlConfiguration built = builder.build();

        assertThat(built.agentId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabClusterAgentUrlConfigurationBuilder builder = GitLabClusterAgentUrlConfigurationBuilder.builder(
                        AgentsCatalogFixtures.clusterAgentUrlConfiguration())
                .url(null);

        final GitLabClusterAgentUrlConfiguration built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPublicKeyIsNullable() {
        final GitLabClusterAgentUrlConfigurationBuilder builder = GitLabClusterAgentUrlConfigurationBuilder.builder(
                        AgentsCatalogFixtures.clusterAgentUrlConfiguration())
                .publicKey(null);

        final GitLabClusterAgentUrlConfiguration built = builder.build();

        assertThat(built.publicKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClientCertIsNullable() {
        final GitLabClusterAgentUrlConfigurationBuilder builder = GitLabClusterAgentUrlConfigurationBuilder.builder(
                        AgentsCatalogFixtures.clusterAgentUrlConfiguration())
                .clientCert(null);

        final GitLabClusterAgentUrlConfiguration built = builder.build();

        assertThat(built.clientCert()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCaCertIsNullable() {
        final GitLabClusterAgentUrlConfigurationBuilder builder = GitLabClusterAgentUrlConfigurationBuilder.builder(
                        AgentsCatalogFixtures.clusterAgentUrlConfiguration())
                .caCert(null);

        final GitLabClusterAgentUrlConfiguration built = builder.build();

        assertThat(built.caCert()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTlsHostIsNullable() {
        final GitLabClusterAgentUrlConfigurationBuilder builder = GitLabClusterAgentUrlConfigurationBuilder.builder(
                        AgentsCatalogFixtures.clusterAgentUrlConfiguration())
                .tlsHost(null);

        final GitLabClusterAgentUrlConfiguration built = builder.build();

        assertThat(built.tlsHost()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabClusterAgentUrlConfiguration value = AgentsCatalogFixtures.clusterAgentUrlConfiguration();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.agentId()).isEqualTo(1L);
            softly.assertThat(value.url()).isEqualTo("url");
            softly.assertThat(value.publicKey()).isEqualTo("public_key");
            softly.assertThat(value.clientCert()).isEqualTo("client_cert");
            softly.assertThat(value.caCert()).isEqualTo("ca_cert");
            softly.assertThat(value.tlsHost()).isEqualTo("tls_host");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabClusterAgentUrlConfiguration original = AgentsCatalogFixtures.clusterAgentUrlConfiguration();

        final GitLabClusterAgentUrlConfiguration rebuilt =
                GitLabClusterAgentUrlConfigurationBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabClusterAgentUrlConfiguration.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "agentId", "url", "publicKey", "clientCert", "caCert", "tlsHost");
    }
}
