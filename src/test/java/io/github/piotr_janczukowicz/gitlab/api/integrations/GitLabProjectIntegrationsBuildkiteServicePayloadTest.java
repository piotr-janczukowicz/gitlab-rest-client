package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsBuildkiteServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectUrlIsNullable() {
        final GitLabProjectIntegrationsBuildkiteServicePayloadBuilder builder =
                GitLabProjectIntegrationsBuildkiteServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBuildkiteServicePayload())
                        .projectUrl(null);

        final GitLabProjectIntegrationsBuildkiteServicePayload built = builder.build();

        assertThat(built.projectUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabProjectIntegrationsBuildkiteServicePayloadBuilder builder =
                GitLabProjectIntegrationsBuildkiteServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBuildkiteServicePayload())
                        .token(null);

        final GitLabProjectIntegrationsBuildkiteServicePayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnableSslVerificationIsNullable() {
        final GitLabProjectIntegrationsBuildkiteServicePayloadBuilder builder =
                GitLabProjectIntegrationsBuildkiteServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBuildkiteServicePayload())
                        .enableSslVerification(null);

        final GitLabProjectIntegrationsBuildkiteServicePayload built = builder.build();

        assertThat(built.enableSslVerification()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsBuildkiteServicePayloadBuilder builder =
                GitLabProjectIntegrationsBuildkiteServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBuildkiteServicePayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsBuildkiteServicePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsBuildkiteServicePayloadBuilder builder =
                GitLabProjectIntegrationsBuildkiteServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBuildkiteServicePayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsBuildkiteServicePayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectIntegrationsBuildkiteServicePayloadBuilder builder =
                GitLabProjectIntegrationsBuildkiteServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBuildkiteServicePayload())
                        .tagPushEvents(null);

        final GitLabProjectIntegrationsBuildkiteServicePayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsBuildkiteServicePayloadBuilder builder =
                GitLabProjectIntegrationsBuildkiteServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBuildkiteServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsBuildkiteServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsBuildkiteServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsBuildkiteServicePayload();

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
        final GitLabProjectIntegrationsBuildkiteServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsBuildkiteServicePayload();

        final GitLabProjectIntegrationsBuildkiteServicePayload rebuilt =
                GitLabProjectIntegrationsBuildkiteServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabProjectIntegrationsBuildkiteServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsBuildkiteServicePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsBuildkiteServicePayload.class.getRecordComponents())
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
