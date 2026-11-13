package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsUpdateServicesJenkinPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenEnableSslVerificationIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesJenkinPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesJenkinPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesJenkinPayload())
                        .enableSslVerification(null);

        final GitLabProjectIntegrationsUpdateServicesJenkinPayload built = builder.build();

        assertThat(built.enableSslVerification()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJenkinsUrlIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesJenkinPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesJenkinPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesJenkinPayload())
                        .jenkinsUrl(null);

        final GitLabProjectIntegrationsUpdateServicesJenkinPayload built = builder.build();

        assertThat(built.jenkinsUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectNameIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesJenkinPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesJenkinPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesJenkinPayload())
                        .projectName(null);

        final GitLabProjectIntegrationsUpdateServicesJenkinPayload built = builder.build();

        assertThat(built.projectName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesJenkinPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesJenkinPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesJenkinPayload())
                        .username(null);

        final GitLabProjectIntegrationsUpdateServicesJenkinPayload built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPasswordIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesJenkinPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesJenkinPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesJenkinPayload())
                        .password(null);

        final GitLabProjectIntegrationsUpdateServicesJenkinPayload built = builder.build();

        assertThat(built.password()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesJenkinPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesJenkinPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesJenkinPayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsUpdateServicesJenkinPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesJenkinPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesJenkinPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesJenkinPayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsUpdateServicesJenkinPayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesJenkinPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesJenkinPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesJenkinPayload())
                        .tagPushEvents(null);

        final GitLabProjectIntegrationsUpdateServicesJenkinPayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesJenkinPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesJenkinPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesJenkinPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsUpdateServicesJenkinPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsUpdateServicesJenkinPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesJenkinPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.enableSslVerification()).isEqualTo(true);
            softly.assertThat(value.jenkinsUrl()).isEqualTo("jenkins_url");
            softly.assertThat(value.projectName()).isEqualTo("project_name");
            softly.assertThat(value.username()).isEqualTo("username");
            softly.assertThat(value.password()).isEqualTo("password");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.mergeRequestsEvents()).isEqualTo(true);
            softly.assertThat(value.tagPushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsUpdateServicesJenkinPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesJenkinPayload();

        final GitLabProjectIntegrationsUpdateServicesJenkinPayload rebuilt =
                GitLabProjectIntegrationsUpdateServicesJenkinPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenPasswordIsACredential() {
        final GitLabProjectIntegrationsUpdateServicesJenkinPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesJenkinPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsUpdateServicesJenkinPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "enableSslVerification",
                        "jenkinsUrl",
                        "projectName",
                        "username",
                        "password",
                        "pushEvents",
                        "mergeRequestsEvents",
                        "tagPushEvents",
                        "useInheritedSettings");
    }
}
