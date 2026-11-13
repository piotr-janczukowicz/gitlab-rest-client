package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsIrkerPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenServerHostIsNullable() {
        final GitLabGroupGroupIntegrationsIrkerPayloadBuilder builder =
                GitLabGroupGroupIntegrationsIrkerPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsIrkerPayload())
                        .serverHost(null);

        final GitLabGroupGroupIntegrationsIrkerPayload built = builder.build();

        assertThat(built.serverHost()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServerPortIsNullable() {
        final GitLabGroupGroupIntegrationsIrkerPayloadBuilder builder =
                GitLabGroupGroupIntegrationsIrkerPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsIrkerPayload())
                        .serverPort(null);

        final GitLabGroupGroupIntegrationsIrkerPayload built = builder.build();

        assertThat(built.serverPort()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultIrcUriIsNullable() {
        final GitLabGroupGroupIntegrationsIrkerPayloadBuilder builder =
                GitLabGroupGroupIntegrationsIrkerPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsIrkerPayload())
                        .defaultIrcUri(null);

        final GitLabGroupGroupIntegrationsIrkerPayload built = builder.build();

        assertThat(built.defaultIrcUri()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRecipientsIsNullable() {
        final GitLabGroupGroupIntegrationsIrkerPayloadBuilder builder =
                GitLabGroupGroupIntegrationsIrkerPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsIrkerPayload())
                        .recipients(null);

        final GitLabGroupGroupIntegrationsIrkerPayload built = builder.build();

        assertThat(built.recipients()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenColorizeMessagesIsNullable() {
        final GitLabGroupGroupIntegrationsIrkerPayloadBuilder builder =
                GitLabGroupGroupIntegrationsIrkerPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsIrkerPayload())
                        .colorizeMessages(null);

        final GitLabGroupGroupIntegrationsIrkerPayload built = builder.build();

        assertThat(built.colorizeMessages()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsIrkerPayloadBuilder builder =
                GitLabGroupGroupIntegrationsIrkerPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsIrkerPayload())
                        .pushEvents(null);

        final GitLabGroupGroupIntegrationsIrkerPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsIrkerPayloadBuilder builder =
                GitLabGroupGroupIntegrationsIrkerPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsIrkerPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsIrkerPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsIrkerPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsIrkerPayload();

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
        final GitLabGroupGroupIntegrationsIrkerPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsIrkerPayload();

        final GitLabGroupGroupIntegrationsIrkerPayload rebuilt =
                GitLabGroupGroupIntegrationsIrkerPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIntegrationsIrkerPayload.class.getRecordComponents())
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
