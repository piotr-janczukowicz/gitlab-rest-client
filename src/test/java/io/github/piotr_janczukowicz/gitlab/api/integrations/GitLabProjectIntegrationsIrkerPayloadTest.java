package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsIrkerPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenServerHostIsNullable() {
        final GitLabProjectIntegrationsIrkerPayloadBuilder builder =
                GitLabProjectIntegrationsIrkerPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsIrkerPayload())
                        .serverHost(null);

        final GitLabProjectIntegrationsIrkerPayload built = builder.build();

        assertThat(built.serverHost()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServerPortIsNullable() {
        final GitLabProjectIntegrationsIrkerPayloadBuilder builder =
                GitLabProjectIntegrationsIrkerPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsIrkerPayload())
                        .serverPort(null);

        final GitLabProjectIntegrationsIrkerPayload built = builder.build();

        assertThat(built.serverPort()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultIrcUriIsNullable() {
        final GitLabProjectIntegrationsIrkerPayloadBuilder builder =
                GitLabProjectIntegrationsIrkerPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsIrkerPayload())
                        .defaultIrcUri(null);

        final GitLabProjectIntegrationsIrkerPayload built = builder.build();

        assertThat(built.defaultIrcUri()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRecipientsIsNullable() {
        final GitLabProjectIntegrationsIrkerPayloadBuilder builder =
                GitLabProjectIntegrationsIrkerPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsIrkerPayload())
                        .recipients(null);

        final GitLabProjectIntegrationsIrkerPayload built = builder.build();

        assertThat(built.recipients()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenColorizeMessagesIsNullable() {
        final GitLabProjectIntegrationsIrkerPayloadBuilder builder =
                GitLabProjectIntegrationsIrkerPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsIrkerPayload())
                        .colorizeMessages(null);

        final GitLabProjectIntegrationsIrkerPayload built = builder.build();

        assertThat(built.colorizeMessages()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsIrkerPayloadBuilder builder =
                GitLabProjectIntegrationsIrkerPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsIrkerPayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsIrkerPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsIrkerPayloadBuilder builder =
                GitLabProjectIntegrationsIrkerPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsIrkerPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsIrkerPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsIrkerPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsIrkerPayload();

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
        final GitLabProjectIntegrationsIrkerPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsIrkerPayload();

        final GitLabProjectIntegrationsIrkerPayload rebuilt =
                GitLabProjectIntegrationsIrkerPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsIrkerPayload.class.getRecordComponents())
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
