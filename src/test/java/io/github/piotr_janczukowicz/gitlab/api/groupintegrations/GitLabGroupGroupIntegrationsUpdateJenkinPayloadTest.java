package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsUpdateJenkinPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenEnableSslVerificationIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateJenkinPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateJenkinPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateJenkinPayload())
                        .enableSslVerification(null);

        final GitLabGroupGroupIntegrationsUpdateJenkinPayload built = builder.build();

        assertThat(built.enableSslVerification()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJenkinsUrlIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateJenkinPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateJenkinPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateJenkinPayload())
                        .jenkinsUrl(null);

        final GitLabGroupGroupIntegrationsUpdateJenkinPayload built = builder.build();

        assertThat(built.jenkinsUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectNameIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateJenkinPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateJenkinPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateJenkinPayload())
                        .projectName(null);

        final GitLabGroupGroupIntegrationsUpdateJenkinPayload built = builder.build();

        assertThat(built.projectName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateJenkinPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateJenkinPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateJenkinPayload())
                        .username(null);

        final GitLabGroupGroupIntegrationsUpdateJenkinPayload built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPasswordIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateJenkinPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateJenkinPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateJenkinPayload())
                        .password(null);

        final GitLabGroupGroupIntegrationsUpdateJenkinPayload built = builder.build();

        assertThat(built.password()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateJenkinPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateJenkinPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateJenkinPayload())
                        .pushEvents(null);

        final GitLabGroupGroupIntegrationsUpdateJenkinPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateJenkinPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateJenkinPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateJenkinPayload())
                        .mergeRequestsEvents(null);

        final GitLabGroupGroupIntegrationsUpdateJenkinPayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateJenkinPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateJenkinPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateJenkinPayload())
                        .tagPushEvents(null);

        final GitLabGroupGroupIntegrationsUpdateJenkinPayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateJenkinPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateJenkinPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateJenkinPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsUpdateJenkinPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsUpdateJenkinPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateJenkinPayload();

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
        final GitLabGroupGroupIntegrationsUpdateJenkinPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateJenkinPayload();

        final GitLabGroupGroupIntegrationsUpdateJenkinPayload rebuilt =
                GitLabGroupGroupIntegrationsUpdateJenkinPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenPasswordIsACredential() {
        final GitLabGroupGroupIntegrationsUpdateJenkinPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateJenkinPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupGroupIntegrationsUpdateJenkinPayload.class.getRecordComponents())
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
