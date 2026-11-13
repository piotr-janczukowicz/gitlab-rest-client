package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsBuildkitePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectUrlIsNullable() {
        final GitLabProjectIntegrationsBuildkitePayloadBuilder builder =
                GitLabProjectIntegrationsBuildkitePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBuildkitePayload())
                        .projectUrl(null);

        final GitLabProjectIntegrationsBuildkitePayload built = builder.build();

        assertThat(built.projectUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabProjectIntegrationsBuildkitePayloadBuilder builder =
                GitLabProjectIntegrationsBuildkitePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBuildkitePayload())
                        .token(null);

        final GitLabProjectIntegrationsBuildkitePayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnableSslVerificationIsNullable() {
        final GitLabProjectIntegrationsBuildkitePayloadBuilder builder =
                GitLabProjectIntegrationsBuildkitePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBuildkitePayload())
                        .enableSslVerification(null);

        final GitLabProjectIntegrationsBuildkitePayload built = builder.build();

        assertThat(built.enableSslVerification()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsBuildkitePayloadBuilder builder =
                GitLabProjectIntegrationsBuildkitePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBuildkitePayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsBuildkitePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsBuildkitePayloadBuilder builder =
                GitLabProjectIntegrationsBuildkitePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBuildkitePayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsBuildkitePayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectIntegrationsBuildkitePayloadBuilder builder =
                GitLabProjectIntegrationsBuildkitePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBuildkitePayload())
                        .tagPushEvents(null);

        final GitLabProjectIntegrationsBuildkitePayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsBuildkitePayloadBuilder builder =
                GitLabProjectIntegrationsBuildkitePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsBuildkitePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsBuildkitePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsBuildkitePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsBuildkitePayload();

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
        final GitLabProjectIntegrationsBuildkitePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsBuildkitePayload();

        final GitLabProjectIntegrationsBuildkitePayload rebuilt =
                GitLabProjectIntegrationsBuildkitePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabProjectIntegrationsBuildkitePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsBuildkitePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsBuildkitePayload.class.getRecordComponents())
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
