package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsDroneCiPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenEnableSslVerificationIsNullable() {
        final GitLabProjectIntegrationsDroneCiPayloadBuilder builder =
                GitLabProjectIntegrationsDroneCiPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDroneCiPayload())
                        .enableSslVerification(null);

        final GitLabProjectIntegrationsDroneCiPayload built = builder.build();

        assertThat(built.enableSslVerification()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDroneUrlIsNullable() {
        final GitLabProjectIntegrationsDroneCiPayloadBuilder builder =
                GitLabProjectIntegrationsDroneCiPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDroneCiPayload())
                        .droneUrl(null);

        final GitLabProjectIntegrationsDroneCiPayload built = builder.build();

        assertThat(built.droneUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabProjectIntegrationsDroneCiPayloadBuilder builder =
                GitLabProjectIntegrationsDroneCiPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDroneCiPayload())
                        .token(null);

        final GitLabProjectIntegrationsDroneCiPayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsDroneCiPayloadBuilder builder =
                GitLabProjectIntegrationsDroneCiPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDroneCiPayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsDroneCiPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsDroneCiPayloadBuilder builder =
                GitLabProjectIntegrationsDroneCiPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDroneCiPayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsDroneCiPayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectIntegrationsDroneCiPayloadBuilder builder =
                GitLabProjectIntegrationsDroneCiPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDroneCiPayload())
                        .tagPushEvents(null);

        final GitLabProjectIntegrationsDroneCiPayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsDroneCiPayloadBuilder builder =
                GitLabProjectIntegrationsDroneCiPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsDroneCiPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsDroneCiPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsDroneCiPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsDroneCiPayload();

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
        final GitLabProjectIntegrationsDroneCiPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsDroneCiPayload();

        final GitLabProjectIntegrationsDroneCiPayload rebuilt =
                GitLabProjectIntegrationsDroneCiPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabProjectIntegrationsDroneCiPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsDroneCiPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsDroneCiPayload.class.getRecordComponents())
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
