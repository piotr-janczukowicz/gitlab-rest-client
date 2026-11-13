package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsDroneCiServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenEnableSslVerificationIsNullable() {
        final GitLabProjectIntegrationsDroneCiServicePayloadBuilder builder =
                GitLabProjectIntegrationsDroneCiServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDroneCiServicePayload())
                        .enableSslVerification(null);

        final GitLabProjectIntegrationsDroneCiServicePayload built = builder.build();

        assertThat(built.enableSslVerification()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDroneUrlIsNullable() {
        final GitLabProjectIntegrationsDroneCiServicePayloadBuilder builder =
                GitLabProjectIntegrationsDroneCiServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDroneCiServicePayload())
                        .droneUrl(null);

        final GitLabProjectIntegrationsDroneCiServicePayload built = builder.build();

        assertThat(built.droneUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabProjectIntegrationsDroneCiServicePayloadBuilder builder =
                GitLabProjectIntegrationsDroneCiServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDroneCiServicePayload())
                        .token(null);

        final GitLabProjectIntegrationsDroneCiServicePayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsDroneCiServicePayloadBuilder builder =
                GitLabProjectIntegrationsDroneCiServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDroneCiServicePayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsDroneCiServicePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsDroneCiServicePayloadBuilder builder =
                GitLabProjectIntegrationsDroneCiServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDroneCiServicePayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsDroneCiServicePayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectIntegrationsDroneCiServicePayloadBuilder builder =
                GitLabProjectIntegrationsDroneCiServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDroneCiServicePayload())
                        .tagPushEvents(null);

        final GitLabProjectIntegrationsDroneCiServicePayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsDroneCiServicePayloadBuilder builder =
                GitLabProjectIntegrationsDroneCiServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDroneCiServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsDroneCiServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsDroneCiServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsDroneCiServicePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.enableSslVerification()).isEqualTo(true);
            softly.assertThat(value.droneUrl()).isEqualTo("drone_url");
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.mergeRequestsEvents()).isEqualTo(true);
            softly.assertThat(value.tagPushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsDroneCiServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsDroneCiServicePayload();

        final GitLabProjectIntegrationsDroneCiServicePayload rebuilt =
                GitLabProjectIntegrationsDroneCiServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabProjectIntegrationsDroneCiServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsDroneCiServicePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsDroneCiServicePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "enableSslVerification",
                        "droneUrl",
                        "token",
                        "pushEvents",
                        "mergeRequestsEvents",
                        "tagPushEvents",
                        "useInheritedSettings");
    }
}
