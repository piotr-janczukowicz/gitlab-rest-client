package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsUpdateJenkinPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenEnableSslVerificationIsNullable() {
        final GitLabProjectIntegrationsUpdateJenkinPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateJenkinPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateJenkinPayload())
                        .enableSslVerification(null);

        final GitLabProjectIntegrationsUpdateJenkinPayload built = builder.build();

        assertThat(built.enableSslVerification()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJenkinsUrlIsNullable() {
        final GitLabProjectIntegrationsUpdateJenkinPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateJenkinPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateJenkinPayload())
                        .jenkinsUrl(null);

        final GitLabProjectIntegrationsUpdateJenkinPayload built = builder.build();

        assertThat(built.jenkinsUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectNameIsNullable() {
        final GitLabProjectIntegrationsUpdateJenkinPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateJenkinPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateJenkinPayload())
                        .projectName(null);

        final GitLabProjectIntegrationsUpdateJenkinPayload built = builder.build();

        assertThat(built.projectName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabProjectIntegrationsUpdateJenkinPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateJenkinPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateJenkinPayload())
                        .username(null);

        final GitLabProjectIntegrationsUpdateJenkinPayload built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPasswordIsNullable() {
        final GitLabProjectIntegrationsUpdateJenkinPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateJenkinPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateJenkinPayload())
                        .password(null);

        final GitLabProjectIntegrationsUpdateJenkinPayload built = builder.build();

        assertThat(built.password()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateJenkinPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateJenkinPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateJenkinPayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsUpdateJenkinPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateJenkinPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateJenkinPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateJenkinPayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsUpdateJenkinPayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectIntegrationsUpdateJenkinPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateJenkinPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateJenkinPayload())
                        .tagPushEvents(null);

        final GitLabProjectIntegrationsUpdateJenkinPayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsUpdateJenkinPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateJenkinPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateJenkinPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsUpdateJenkinPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsUpdateJenkinPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsUpdateJenkinPayload();

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
        final GitLabProjectIntegrationsUpdateJenkinPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsUpdateJenkinPayload();

        final GitLabProjectIntegrationsUpdateJenkinPayload rebuilt =
                GitLabProjectIntegrationsUpdateJenkinPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenPasswordIsACredential() {
        final GitLabProjectIntegrationsUpdateJenkinPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsUpdateJenkinPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsUpdateJenkinPayload.class.getRecordComponents())
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
