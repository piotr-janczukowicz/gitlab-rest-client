package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsDroneCiPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenEnableSslVerificationIsNullable() {
        final GitLabGroupGroupIntegrationsDroneCiPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDroneCiPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDroneCiPayload())
                        .enableSslVerification(null);

        final GitLabGroupGroupIntegrationsDroneCiPayload built = builder.build();

        assertThat(built.enableSslVerification()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDroneUrlIsNullable() {
        final GitLabGroupGroupIntegrationsDroneCiPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDroneCiPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDroneCiPayload())
                        .droneUrl(null);

        final GitLabGroupGroupIntegrationsDroneCiPayload built = builder.build();

        assertThat(built.droneUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabGroupGroupIntegrationsDroneCiPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDroneCiPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDroneCiPayload())
                        .token(null);

        final GitLabGroupGroupIntegrationsDroneCiPayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsDroneCiPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDroneCiPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDroneCiPayload())
                        .pushEvents(null);

        final GitLabGroupGroupIntegrationsDroneCiPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabGroupGroupIntegrationsDroneCiPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDroneCiPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDroneCiPayload())
                        .mergeRequestsEvents(null);

        final GitLabGroupGroupIntegrationsDroneCiPayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsDroneCiPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDroneCiPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDroneCiPayload())
                        .tagPushEvents(null);

        final GitLabGroupGroupIntegrationsDroneCiPayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsDroneCiPayloadBuilder builder =
                GitLabGroupGroupIntegrationsDroneCiPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDroneCiPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsDroneCiPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsDroneCiPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDroneCiPayload();

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
        final GitLabGroupGroupIntegrationsDroneCiPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDroneCiPayload();

        final GitLabGroupGroupIntegrationsDroneCiPayload rebuilt =
                GitLabGroupGroupIntegrationsDroneCiPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabGroupGroupIntegrationsDroneCiPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsDroneCiPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIntegrationsDroneCiPayload.class.getRecordComponents())
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
