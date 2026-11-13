package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsBambooPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenEnableSslVerificationIsNullable() {
        final GitLabGroupGroupIntegrationsBambooPayloadBuilder builder =
                GitLabGroupGroupIntegrationsBambooPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsBambooPayload())
                        .enableSslVerification(null);

        final GitLabGroupGroupIntegrationsBambooPayload built = builder.build();

        assertThat(built.enableSslVerification()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBambooUrlIsNullable() {
        final GitLabGroupGroupIntegrationsBambooPayloadBuilder builder =
                GitLabGroupGroupIntegrationsBambooPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsBambooPayload())
                        .bambooUrl(null);

        final GitLabGroupGroupIntegrationsBambooPayload built = builder.build();

        assertThat(built.bambooUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBuildKeyIsNullable() {
        final GitLabGroupGroupIntegrationsBambooPayloadBuilder builder =
                GitLabGroupGroupIntegrationsBambooPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsBambooPayload())
                        .buildKey(null);

        final GitLabGroupGroupIntegrationsBambooPayload built = builder.build();

        assertThat(built.buildKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabGroupGroupIntegrationsBambooPayloadBuilder builder =
                GitLabGroupGroupIntegrationsBambooPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsBambooPayload())
                        .username(null);

        final GitLabGroupGroupIntegrationsBambooPayload built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPasswordIsNullable() {
        final GitLabGroupGroupIntegrationsBambooPayloadBuilder builder =
                GitLabGroupGroupIntegrationsBambooPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsBambooPayload())
                        .password(null);

        final GitLabGroupGroupIntegrationsBambooPayload built = builder.build();

        assertThat(built.password()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsBambooPayloadBuilder builder =
                GitLabGroupGroupIntegrationsBambooPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsBambooPayload())
                        .pushEvents(null);

        final GitLabGroupGroupIntegrationsBambooPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsBambooPayloadBuilder builder =
                GitLabGroupGroupIntegrationsBambooPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsBambooPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsBambooPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsBambooPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsBambooPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.enableSslVerification()).isEqualTo(true);
            softly.assertThat(value.bambooUrl()).isEqualTo("bamboo_url");
            softly.assertThat(value.buildKey()).isEqualTo("build_key");
            softly.assertThat(value.username()).isEqualTo("username");
            softly.assertThat(value.password()).isEqualTo("password");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupIntegrationsBambooPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsBambooPayload();

        final GitLabGroupGroupIntegrationsBambooPayload rebuilt =
                GitLabGroupGroupIntegrationsBambooPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenPasswordIsACredential() {
        final GitLabGroupGroupIntegrationsBambooPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsBambooPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIntegrationsBambooPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "enableSslVerification",
                        "bambooUrl",
                        "buildKey",
                        "username",
                        "password",
                        "pushEvents",
                        "useInheritedSettings");
    }
}
