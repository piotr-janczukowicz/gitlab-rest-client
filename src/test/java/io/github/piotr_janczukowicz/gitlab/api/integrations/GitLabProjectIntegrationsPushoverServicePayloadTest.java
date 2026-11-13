package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsPushoverServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenApiKeyIsNullable() {
        final GitLabProjectIntegrationsPushoverServicePayloadBuilder builder =
                GitLabProjectIntegrationsPushoverServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPushoverServicePayload())
                        .apiKey(null);

        final GitLabProjectIntegrationsPushoverServicePayload built = builder.build();

        assertThat(built.apiKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserKeyIsNullable() {
        final GitLabProjectIntegrationsPushoverServicePayloadBuilder builder =
                GitLabProjectIntegrationsPushoverServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPushoverServicePayload())
                        .userKey(null);

        final GitLabProjectIntegrationsPushoverServicePayload built = builder.build();

        assertThat(built.userKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeviceIsNullable() {
        final GitLabProjectIntegrationsPushoverServicePayloadBuilder builder =
                GitLabProjectIntegrationsPushoverServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPushoverServicePayload())
                        .device(null);

        final GitLabProjectIntegrationsPushoverServicePayload built = builder.build();

        assertThat(built.device()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPriorityIsNullable() {
        final GitLabProjectIntegrationsPushoverServicePayloadBuilder builder =
                GitLabProjectIntegrationsPushoverServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPushoverServicePayload())
                        .priority(null);

        final GitLabProjectIntegrationsPushoverServicePayload built = builder.build();

        assertThat(built.priority()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSoundIsNullable() {
        final GitLabProjectIntegrationsPushoverServicePayloadBuilder builder =
                GitLabProjectIntegrationsPushoverServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPushoverServicePayload())
                        .sound(null);

        final GitLabProjectIntegrationsPushoverServicePayload built = builder.build();

        assertThat(built.sound()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsPushoverServicePayloadBuilder builder =
                GitLabProjectIntegrationsPushoverServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPushoverServicePayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsPushoverServicePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsPushoverServicePayloadBuilder builder =
                GitLabProjectIntegrationsPushoverServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPushoverServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsPushoverServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsPushoverServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsPushoverServicePayload();

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
        final GitLabProjectIntegrationsPushoverServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsPushoverServicePayload();

        final GitLabProjectIntegrationsPushoverServicePayload rebuilt =
                GitLabProjectIntegrationsPushoverServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsPushoverServicePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "apiKey", "userKey", "device", "priority", "sound", "pushEvents", "useInheritedSettings");
    }
}
