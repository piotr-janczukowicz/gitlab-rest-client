package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsIrkerServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenServerHostIsNullable() {
        final GitLabProjectIntegrationsIrkerServicePayloadBuilder builder =
                GitLabProjectIntegrationsIrkerServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsIrkerServicePayload())
                        .serverHost(null);

        final GitLabProjectIntegrationsIrkerServicePayload built = builder.build();

        assertThat(built.serverHost()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServerPortIsNullable() {
        final GitLabProjectIntegrationsIrkerServicePayloadBuilder builder =
                GitLabProjectIntegrationsIrkerServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsIrkerServicePayload())
                        .serverPort(null);

        final GitLabProjectIntegrationsIrkerServicePayload built = builder.build();

        assertThat(built.serverPort()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultIrcUriIsNullable() {
        final GitLabProjectIntegrationsIrkerServicePayloadBuilder builder =
                GitLabProjectIntegrationsIrkerServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsIrkerServicePayload())
                        .defaultIrcUri(null);

        final GitLabProjectIntegrationsIrkerServicePayload built = builder.build();

        assertThat(built.defaultIrcUri()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRecipientsIsNullable() {
        final GitLabProjectIntegrationsIrkerServicePayloadBuilder builder =
                GitLabProjectIntegrationsIrkerServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsIrkerServicePayload())
                        .recipients(null);

        final GitLabProjectIntegrationsIrkerServicePayload built = builder.build();

        assertThat(built.recipients()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenColorizeMessagesIsNullable() {
        final GitLabProjectIntegrationsIrkerServicePayloadBuilder builder =
                GitLabProjectIntegrationsIrkerServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsIrkerServicePayload())
                        .colorizeMessages(null);

        final GitLabProjectIntegrationsIrkerServicePayload built = builder.build();

        assertThat(built.colorizeMessages()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsIrkerServicePayloadBuilder builder =
                GitLabProjectIntegrationsIrkerServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsIrkerServicePayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsIrkerServicePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsIrkerServicePayloadBuilder builder =
                GitLabProjectIntegrationsIrkerServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsIrkerServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsIrkerServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsIrkerServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsIrkerServicePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.serverHost()).isEqualTo("server_host");
            softly.assertThat(value.serverPort()).isEqualTo(1);
            softly.assertThat(value.defaultIrcUri()).isEqualTo("default_irc_uri");
            softly.assertThat(value.recipients()).isEqualTo("recipients");
            softly.assertThat(value.colorizeMessages()).isEqualTo(true);
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsIrkerServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsIrkerServicePayload();

        final GitLabProjectIntegrationsIrkerServicePayload rebuilt =
                GitLabProjectIntegrationsIrkerServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsIrkerServicePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "serverHost",
                        "serverPort",
                        "defaultIrcUri",
                        "recipients",
                        "colorizeMessages",
                        "pushEvents",
                        "useInheritedSettings");
    }
}
