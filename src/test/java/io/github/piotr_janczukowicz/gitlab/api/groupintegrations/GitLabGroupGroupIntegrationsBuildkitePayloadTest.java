package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsBuildkitePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectUrlIsNullable() {
        final GitLabGroupGroupIntegrationsBuildkitePayloadBuilder builder =
                GitLabGroupGroupIntegrationsBuildkitePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsBuildkitePayload())
                        .projectUrl(null);

        final GitLabGroupGroupIntegrationsBuildkitePayload built = builder.build();

        assertThat(built.projectUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabGroupGroupIntegrationsBuildkitePayloadBuilder builder =
                GitLabGroupGroupIntegrationsBuildkitePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsBuildkitePayload())
                        .token(null);

        final GitLabGroupGroupIntegrationsBuildkitePayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnableSslVerificationIsNullable() {
        final GitLabGroupGroupIntegrationsBuildkitePayloadBuilder builder =
                GitLabGroupGroupIntegrationsBuildkitePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsBuildkitePayload())
                        .enableSslVerification(null);

        final GitLabGroupGroupIntegrationsBuildkitePayload built = builder.build();

        assertThat(built.enableSslVerification()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsBuildkitePayloadBuilder builder =
                GitLabGroupGroupIntegrationsBuildkitePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsBuildkitePayload())
                        .pushEvents(null);

        final GitLabGroupGroupIntegrationsBuildkitePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabGroupGroupIntegrationsBuildkitePayloadBuilder builder =
                GitLabGroupGroupIntegrationsBuildkitePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsBuildkitePayload())
                        .mergeRequestsEvents(null);

        final GitLabGroupGroupIntegrationsBuildkitePayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsBuildkitePayloadBuilder builder =
                GitLabGroupGroupIntegrationsBuildkitePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsBuildkitePayload())
                        .tagPushEvents(null);

        final GitLabGroupGroupIntegrationsBuildkitePayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsBuildkitePayloadBuilder builder =
                GitLabGroupGroupIntegrationsBuildkitePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsBuildkitePayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsBuildkitePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsBuildkitePayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsBuildkitePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.projectUrl()).isEqualTo("project_url");
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.enableSslVerification()).isEqualTo(true);
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.mergeRequestsEvents()).isEqualTo(true);
            softly.assertThat(value.tagPushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupIntegrationsBuildkitePayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsBuildkitePayload();

        final GitLabGroupGroupIntegrationsBuildkitePayload rebuilt =
                GitLabGroupGroupIntegrationsBuildkitePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabGroupGroupIntegrationsBuildkitePayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsBuildkitePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIntegrationsBuildkitePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "projectUrl",
                        "token",
                        "enableSslVerification",
                        "pushEvents",
                        "mergeRequestsEvents",
                        "tagPushEvents",
                        "useInheritedSettings");
    }
}
