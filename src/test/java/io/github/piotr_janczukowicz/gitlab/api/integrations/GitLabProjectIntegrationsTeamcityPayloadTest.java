package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsTeamcityPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenEnableSslVerificationIsNullable() {
        final GitLabProjectIntegrationsTeamcityPayloadBuilder builder =
                GitLabProjectIntegrationsTeamcityPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTeamcityPayload())
                        .enableSslVerification(null);

        final GitLabProjectIntegrationsTeamcityPayload built = builder.build();

        assertThat(built.enableSslVerification()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTeamcityUrlIsNullable() {
        final GitLabProjectIntegrationsTeamcityPayloadBuilder builder =
                GitLabProjectIntegrationsTeamcityPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTeamcityPayload())
                        .teamcityUrl(null);

        final GitLabProjectIntegrationsTeamcityPayload built = builder.build();

        assertThat(built.teamcityUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBuildTypeIsNullable() {
        final GitLabProjectIntegrationsTeamcityPayloadBuilder builder =
                GitLabProjectIntegrationsTeamcityPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTeamcityPayload())
                        .buildType(null);

        final GitLabProjectIntegrationsTeamcityPayload built = builder.build();

        assertThat(built.buildType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabProjectIntegrationsTeamcityPayloadBuilder builder =
                GitLabProjectIntegrationsTeamcityPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTeamcityPayload())
                        .username(null);

        final GitLabProjectIntegrationsTeamcityPayload built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPasswordIsNullable() {
        final GitLabProjectIntegrationsTeamcityPayloadBuilder builder =
                GitLabProjectIntegrationsTeamcityPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTeamcityPayload())
                        .password(null);

        final GitLabProjectIntegrationsTeamcityPayload built = builder.build();

        assertThat(built.password()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsTeamcityPayloadBuilder builder =
                GitLabProjectIntegrationsTeamcityPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTeamcityPayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsTeamcityPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsTeamcityPayloadBuilder builder =
                GitLabProjectIntegrationsTeamcityPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTeamcityPayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsTeamcityPayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsTeamcityPayloadBuilder builder =
                GitLabProjectIntegrationsTeamcityPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTeamcityPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsTeamcityPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsTeamcityPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsTeamcityPayload();

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
        final GitLabProjectIntegrationsTeamcityPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsTeamcityPayload();

        final GitLabProjectIntegrationsTeamcityPayload rebuilt =
                GitLabProjectIntegrationsTeamcityPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenPasswordIsACredential() {
        final GitLabProjectIntegrationsTeamcityPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsTeamcityPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsTeamcityPayload.class.getRecordComponents())
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
