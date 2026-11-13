package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsBambooServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenEnableSslVerificationIsNullable() {
        final GitLabProjectIntegrationsBambooServicePayloadBuilder builder =
                GitLabProjectIntegrationsBambooServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBambooServicePayload())
                        .enableSslVerification(null);

        final GitLabProjectIntegrationsBambooServicePayload built = builder.build();

        assertThat(built.enableSslVerification()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBambooUrlIsNullable() {
        final GitLabProjectIntegrationsBambooServicePayloadBuilder builder =
                GitLabProjectIntegrationsBambooServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBambooServicePayload())
                        .bambooUrl(null);

        final GitLabProjectIntegrationsBambooServicePayload built = builder.build();

        assertThat(built.bambooUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBuildKeyIsNullable() {
        final GitLabProjectIntegrationsBambooServicePayloadBuilder builder =
                GitLabProjectIntegrationsBambooServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBambooServicePayload())
                        .buildKey(null);

        final GitLabProjectIntegrationsBambooServicePayload built = builder.build();

        assertThat(built.buildKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabProjectIntegrationsBambooServicePayloadBuilder builder =
                GitLabProjectIntegrationsBambooServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBambooServicePayload())
                        .username(null);

        final GitLabProjectIntegrationsBambooServicePayload built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPasswordIsNullable() {
        final GitLabProjectIntegrationsBambooServicePayloadBuilder builder =
                GitLabProjectIntegrationsBambooServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBambooServicePayload())
                        .password(null);

        final GitLabProjectIntegrationsBambooServicePayload built = builder.build();

        assertThat(built.password()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsBambooServicePayloadBuilder builder =
                GitLabProjectIntegrationsBambooServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBambooServicePayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsBambooServicePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsBambooServicePayloadBuilder builder =
                GitLabProjectIntegrationsBambooServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBambooServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsBambooServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsBambooServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsBambooServicePayload();

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
        final GitLabProjectIntegrationsBambooServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsBambooServicePayload();

        final GitLabProjectIntegrationsBambooServicePayload rebuilt =
                GitLabProjectIntegrationsBambooServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenPasswordIsACredential() {
        final GitLabProjectIntegrationsBambooServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsBambooServicePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsBambooServicePayload.class.getRecordComponents())
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
