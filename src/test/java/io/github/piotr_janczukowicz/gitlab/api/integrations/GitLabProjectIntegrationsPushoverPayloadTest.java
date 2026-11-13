package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsPushoverPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenApiKeyIsNullable() {
        final GitLabProjectIntegrationsPushoverPayloadBuilder builder =
                GitLabProjectIntegrationsPushoverPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPushoverPayload())
                        .apiKey(null);

        final GitLabProjectIntegrationsPushoverPayload built = builder.build();

        assertThat(built.apiKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserKeyIsNullable() {
        final GitLabProjectIntegrationsPushoverPayloadBuilder builder =
                GitLabProjectIntegrationsPushoverPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPushoverPayload())
                        .userKey(null);

        final GitLabProjectIntegrationsPushoverPayload built = builder.build();

        assertThat(built.userKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeviceIsNullable() {
        final GitLabProjectIntegrationsPushoverPayloadBuilder builder =
                GitLabProjectIntegrationsPushoverPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPushoverPayload())
                        .device(null);

        final GitLabProjectIntegrationsPushoverPayload built = builder.build();

        assertThat(built.device()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPriorityIsNullable() {
        final GitLabProjectIntegrationsPushoverPayloadBuilder builder =
                GitLabProjectIntegrationsPushoverPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPushoverPayload())
                        .priority(null);

        final GitLabProjectIntegrationsPushoverPayload built = builder.build();

        assertThat(built.priority()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSoundIsNullable() {
        final GitLabProjectIntegrationsPushoverPayloadBuilder builder =
                GitLabProjectIntegrationsPushoverPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPushoverPayload())
                        .sound(null);

        final GitLabProjectIntegrationsPushoverPayload built = builder.build();

        assertThat(built.sound()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsPushoverPayloadBuilder builder =
                GitLabProjectIntegrationsPushoverPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPushoverPayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsPushoverPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsPushoverPayloadBuilder builder =
                GitLabProjectIntegrationsPushoverPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPushoverPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsPushoverPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsPushoverPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsPushoverPayload();

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
        final GitLabProjectIntegrationsPushoverPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsPushoverPayload();

        final GitLabProjectIntegrationsPushoverPayload rebuilt =
                GitLabProjectIntegrationsPushoverPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsPushoverPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "apiKey", "userKey", "device", "priority", "sound", "pushEvents", "useInheritedSettings");
    }
}
