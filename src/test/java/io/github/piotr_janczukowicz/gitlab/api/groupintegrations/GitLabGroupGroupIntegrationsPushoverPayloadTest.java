package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsPushoverPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenApiKeyIsNullable() {
        final GitLabGroupGroupIntegrationsPushoverPayloadBuilder builder =
                GitLabGroupGroupIntegrationsPushoverPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPushoverPayload())
                        .apiKey(null);

        final GitLabGroupGroupIntegrationsPushoverPayload built = builder.build();

        assertThat(built.apiKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserKeyIsNullable() {
        final GitLabGroupGroupIntegrationsPushoverPayloadBuilder builder =
                GitLabGroupGroupIntegrationsPushoverPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPushoverPayload())
                        .userKey(null);

        final GitLabGroupGroupIntegrationsPushoverPayload built = builder.build();

        assertThat(built.userKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeviceIsNullable() {
        final GitLabGroupGroupIntegrationsPushoverPayloadBuilder builder =
                GitLabGroupGroupIntegrationsPushoverPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPushoverPayload())
                        .device(null);

        final GitLabGroupGroupIntegrationsPushoverPayload built = builder.build();

        assertThat(built.device()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPriorityIsNullable() {
        final GitLabGroupGroupIntegrationsPushoverPayloadBuilder builder =
                GitLabGroupGroupIntegrationsPushoverPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPushoverPayload())
                        .priority(null);

        final GitLabGroupGroupIntegrationsPushoverPayload built = builder.build();

        assertThat(built.priority()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSoundIsNullable() {
        final GitLabGroupGroupIntegrationsPushoverPayloadBuilder builder =
                GitLabGroupGroupIntegrationsPushoverPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPushoverPayload())
                        .sound(null);

        final GitLabGroupGroupIntegrationsPushoverPayload built = builder.build();

        assertThat(built.sound()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsPushoverPayloadBuilder builder =
                GitLabGroupGroupIntegrationsPushoverPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPushoverPayload())
                        .pushEvents(null);

        final GitLabGroupGroupIntegrationsPushoverPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsPushoverPayloadBuilder builder =
                GitLabGroupGroupIntegrationsPushoverPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPushoverPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsPushoverPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsPushoverPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPushoverPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.apiKey()).isEqualTo("api_key");
            softly.assertThat(value.userKey()).isEqualTo("user_key");
            softly.assertThat(value.device()).isEqualTo("device");
            softly.assertThat(value.priority()).isEqualTo("priority");
            softly.assertThat(value.sound()).isEqualTo("sound");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupIntegrationsPushoverPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsPushoverPayload();

        final GitLabGroupGroupIntegrationsPushoverPayload rebuilt =
                GitLabGroupGroupIntegrationsPushoverPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIntegrationsPushoverPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "apiKey", "userKey", "device", "priority", "sound", "pushEvents", "useInheritedSettings");
    }
}
