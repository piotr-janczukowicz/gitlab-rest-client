package io.github.piotr_janczukowicz.gitlab.api.agents;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectAgentsCreateUrlConfigurationPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabProjectAgentsCreateUrlConfigurationPayloadBuilder builder =
                GitLabProjectAgentsCreateUrlConfigurationPayloadBuilder.builder(
                                AgentsCatalogFixtures.projectAgentsCreateUrlConfigurationPayload())
                        .url(null);

        final GitLabProjectAgentsCreateUrlConfigurationPayload built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClientCertIsNullable() {
        final GitLabProjectAgentsCreateUrlConfigurationPayloadBuilder builder =
                GitLabProjectAgentsCreateUrlConfigurationPayloadBuilder.builder(
                                AgentsCatalogFixtures.projectAgentsCreateUrlConfigurationPayload())
                        .clientCert(null);

        final GitLabProjectAgentsCreateUrlConfigurationPayload built = builder.build();

        assertThat(built.clientCert()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClientKeyIsNullable() {
        final GitLabProjectAgentsCreateUrlConfigurationPayloadBuilder builder =
                GitLabProjectAgentsCreateUrlConfigurationPayloadBuilder.builder(
                                AgentsCatalogFixtures.projectAgentsCreateUrlConfigurationPayload())
                        .clientKey(null);

        final GitLabProjectAgentsCreateUrlConfigurationPayload built = builder.build();

        assertThat(built.clientKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCaCertIsNullable() {
        final GitLabProjectAgentsCreateUrlConfigurationPayloadBuilder builder =
                GitLabProjectAgentsCreateUrlConfigurationPayloadBuilder.builder(
                                AgentsCatalogFixtures.projectAgentsCreateUrlConfigurationPayload())
                        .caCert(null);

        final GitLabProjectAgentsCreateUrlConfigurationPayload built = builder.build();

        assertThat(built.caCert()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTlsHostIsNullable() {
        final GitLabProjectAgentsCreateUrlConfigurationPayloadBuilder builder =
                GitLabProjectAgentsCreateUrlConfigurationPayloadBuilder.builder(
                                AgentsCatalogFixtures.projectAgentsCreateUrlConfigurationPayload())
                        .tlsHost(null);

        final GitLabProjectAgentsCreateUrlConfigurationPayload built = builder.build();

        assertThat(built.tlsHost()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectAgentsCreateUrlConfigurationPayload value =
                AgentsCatalogFixtures.projectAgentsCreateUrlConfigurationPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.url()).isEqualTo("url");
            softly.assertThat(value.clientCert()).isEqualTo("client_cert");
            softly.assertThat(value.clientKey()).isEqualTo("client_key");
            softly.assertThat(value.caCert()).isEqualTo("ca_cert");
            softly.assertThat(value.tlsHost()).isEqualTo("tls_host");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectAgentsCreateUrlConfigurationPayload original =
                AgentsCatalogFixtures.projectAgentsCreateUrlConfigurationPayload();

        final GitLabProjectAgentsCreateUrlConfigurationPayload rebuilt =
                GitLabProjectAgentsCreateUrlConfigurationPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectAgentsCreateUrlConfigurationPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("url", "clientCert", "clientKey", "caCert", "tlsHost");
    }
}
