package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsBambooPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenEnableSslVerificationIsNullable() {
        final GitLabProjectIntegrationsBambooPayloadBuilder builder =
                GitLabProjectIntegrationsBambooPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBambooPayload())
                        .enableSslVerification(null);

        final GitLabProjectIntegrationsBambooPayload built = builder.build();

        assertThat(built.enableSslVerification()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBambooUrlIsNullable() {
        final GitLabProjectIntegrationsBambooPayloadBuilder builder =
                GitLabProjectIntegrationsBambooPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBambooPayload())
                        .bambooUrl(null);

        final GitLabProjectIntegrationsBambooPayload built = builder.build();

        assertThat(built.bambooUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBuildKeyIsNullable() {
        final GitLabProjectIntegrationsBambooPayloadBuilder builder =
                GitLabProjectIntegrationsBambooPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBambooPayload())
                        .buildKey(null);

        final GitLabProjectIntegrationsBambooPayload built = builder.build();

        assertThat(built.buildKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabProjectIntegrationsBambooPayloadBuilder builder =
                GitLabProjectIntegrationsBambooPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBambooPayload())
                        .username(null);

        final GitLabProjectIntegrationsBambooPayload built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPasswordIsNullable() {
        final GitLabProjectIntegrationsBambooPayloadBuilder builder =
                GitLabProjectIntegrationsBambooPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBambooPayload())
                        .password(null);

        final GitLabProjectIntegrationsBambooPayload built = builder.build();

        assertThat(built.password()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsBambooPayloadBuilder builder =
                GitLabProjectIntegrationsBambooPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBambooPayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsBambooPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsBambooPayloadBuilder builder =
                GitLabProjectIntegrationsBambooPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBambooPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsBambooPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsBambooPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsBambooPayload();

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
        final GitLabProjectIntegrationsBambooPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsBambooPayload();

        final GitLabProjectIntegrationsBambooPayload rebuilt =
                GitLabProjectIntegrationsBambooPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenPasswordIsACredential() {
        final GitLabProjectIntegrationsBambooPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsBambooPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsBambooPayload.class.getRecordComponents())
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
