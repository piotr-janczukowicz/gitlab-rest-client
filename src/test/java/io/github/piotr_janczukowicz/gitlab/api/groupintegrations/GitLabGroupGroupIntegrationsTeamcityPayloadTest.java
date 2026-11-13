package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsTeamcityPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenEnableSslVerificationIsNullable() {
        final GitLabGroupGroupIntegrationsTeamcityPayloadBuilder builder =
                GitLabGroupGroupIntegrationsTeamcityPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTeamcityPayload())
                        .enableSslVerification(null);

        final GitLabGroupGroupIntegrationsTeamcityPayload built = builder.build();

        assertThat(built.enableSslVerification()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTeamcityUrlIsNullable() {
        final GitLabGroupGroupIntegrationsTeamcityPayloadBuilder builder =
                GitLabGroupGroupIntegrationsTeamcityPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTeamcityPayload())
                        .teamcityUrl(null);

        final GitLabGroupGroupIntegrationsTeamcityPayload built = builder.build();

        assertThat(built.teamcityUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBuildTypeIsNullable() {
        final GitLabGroupGroupIntegrationsTeamcityPayloadBuilder builder =
                GitLabGroupGroupIntegrationsTeamcityPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTeamcityPayload())
                        .buildType(null);

        final GitLabGroupGroupIntegrationsTeamcityPayload built = builder.build();

        assertThat(built.buildType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabGroupGroupIntegrationsTeamcityPayloadBuilder builder =
                GitLabGroupGroupIntegrationsTeamcityPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTeamcityPayload())
                        .username(null);

        final GitLabGroupGroupIntegrationsTeamcityPayload built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPasswordIsNullable() {
        final GitLabGroupGroupIntegrationsTeamcityPayloadBuilder builder =
                GitLabGroupGroupIntegrationsTeamcityPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTeamcityPayload())
                        .password(null);

        final GitLabGroupGroupIntegrationsTeamcityPayload built = builder.build();

        assertThat(built.password()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsTeamcityPayloadBuilder builder =
                GitLabGroupGroupIntegrationsTeamcityPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTeamcityPayload())
                        .pushEvents(null);

        final GitLabGroupGroupIntegrationsTeamcityPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabGroupGroupIntegrationsTeamcityPayloadBuilder builder =
                GitLabGroupGroupIntegrationsTeamcityPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTeamcityPayload())
                        .mergeRequestsEvents(null);

        final GitLabGroupGroupIntegrationsTeamcityPayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsTeamcityPayloadBuilder builder =
                GitLabGroupGroupIntegrationsTeamcityPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTeamcityPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsTeamcityPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsTeamcityPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTeamcityPayload();

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
        final GitLabGroupGroupIntegrationsTeamcityPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTeamcityPayload();

        final GitLabGroupGroupIntegrationsTeamcityPayload rebuilt =
                GitLabGroupGroupIntegrationsTeamcityPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenPasswordIsACredential() {
        final GitLabGroupGroupIntegrationsTeamcityPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsTeamcityPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIntegrationsTeamcityPayload.class.getRecordComponents())
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
