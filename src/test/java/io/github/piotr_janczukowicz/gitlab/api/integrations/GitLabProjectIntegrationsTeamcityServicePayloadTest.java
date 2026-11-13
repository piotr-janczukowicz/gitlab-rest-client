package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsTeamcityServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenEnableSslVerificationIsNullable() {
        final GitLabProjectIntegrationsTeamcityServicePayloadBuilder builder =
                GitLabProjectIntegrationsTeamcityServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTeamcityServicePayload())
                        .enableSslVerification(null);

        final GitLabProjectIntegrationsTeamcityServicePayload built = builder.build();

        assertThat(built.enableSslVerification()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTeamcityUrlIsNullable() {
        final GitLabProjectIntegrationsTeamcityServicePayloadBuilder builder =
                GitLabProjectIntegrationsTeamcityServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTeamcityServicePayload())
                        .teamcityUrl(null);

        final GitLabProjectIntegrationsTeamcityServicePayload built = builder.build();

        assertThat(built.teamcityUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBuildTypeIsNullable() {
        final GitLabProjectIntegrationsTeamcityServicePayloadBuilder builder =
                GitLabProjectIntegrationsTeamcityServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTeamcityServicePayload())
                        .buildType(null);

        final GitLabProjectIntegrationsTeamcityServicePayload built = builder.build();

        assertThat(built.buildType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabProjectIntegrationsTeamcityServicePayloadBuilder builder =
                GitLabProjectIntegrationsTeamcityServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTeamcityServicePayload())
                        .username(null);

        final GitLabProjectIntegrationsTeamcityServicePayload built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPasswordIsNullable() {
        final GitLabProjectIntegrationsTeamcityServicePayloadBuilder builder =
                GitLabProjectIntegrationsTeamcityServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTeamcityServicePayload())
                        .password(null);

        final GitLabProjectIntegrationsTeamcityServicePayload built = builder.build();

        assertThat(built.password()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsTeamcityServicePayloadBuilder builder =
                GitLabProjectIntegrationsTeamcityServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTeamcityServicePayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsTeamcityServicePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsTeamcityServicePayloadBuilder builder =
                GitLabProjectIntegrationsTeamcityServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTeamcityServicePayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsTeamcityServicePayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsTeamcityServicePayloadBuilder builder =
                GitLabProjectIntegrationsTeamcityServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTeamcityServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsTeamcityServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsTeamcityServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsTeamcityServicePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.enableSslVerification()).isEqualTo(true);
            softly.assertThat(value.teamcityUrl()).isEqualTo("teamcity_url");
            softly.assertThat(value.buildType()).isEqualTo("build_type");
            softly.assertThat(value.username()).isEqualTo("username");
            softly.assertThat(value.password()).isEqualTo("password");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.mergeRequestsEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsTeamcityServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsTeamcityServicePayload();

        final GitLabProjectIntegrationsTeamcityServicePayload rebuilt =
                GitLabProjectIntegrationsTeamcityServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenPasswordIsACredential() {
        final GitLabProjectIntegrationsTeamcityServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsTeamcityServicePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsTeamcityServicePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "enableSslVerification",
                        "teamcityUrl",
                        "buildType",
                        "username",
                        "password",
                        "pushEvents",
                        "mergeRequestsEvents",
                        "useInheritedSettings");
    }
}
