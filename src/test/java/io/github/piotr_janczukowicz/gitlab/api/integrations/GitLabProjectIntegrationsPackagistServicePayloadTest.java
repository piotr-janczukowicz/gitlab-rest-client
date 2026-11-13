package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsPackagistServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabProjectIntegrationsPackagistServicePayloadBuilder builder =
                GitLabProjectIntegrationsPackagistServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPackagistServicePayload())
                        .username(null);

        final GitLabProjectIntegrationsPackagistServicePayload built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabProjectIntegrationsPackagistServicePayloadBuilder builder =
                GitLabProjectIntegrationsPackagistServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPackagistServicePayload())
                        .token(null);

        final GitLabProjectIntegrationsPackagistServicePayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServerIsNullable() {
        final GitLabProjectIntegrationsPackagistServicePayloadBuilder builder =
                GitLabProjectIntegrationsPackagistServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPackagistServicePayload())
                        .server(null);

        final GitLabProjectIntegrationsPackagistServicePayload built = builder.build();

        assertThat(built.server()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsPackagistServicePayloadBuilder builder =
                GitLabProjectIntegrationsPackagistServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPackagistServicePayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsPackagistServicePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsPackagistServicePayloadBuilder builder =
                GitLabProjectIntegrationsPackagistServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPackagistServicePayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsPackagistServicePayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectIntegrationsPackagistServicePayloadBuilder builder =
                GitLabProjectIntegrationsPackagistServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPackagistServicePayload())
                        .tagPushEvents(null);

        final GitLabProjectIntegrationsPackagistServicePayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsPackagistServicePayloadBuilder builder =
                GitLabProjectIntegrationsPackagistServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPackagistServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsPackagistServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsPackagistServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsPackagistServicePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.username()).isEqualTo("username");
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.server()).isEqualTo("server");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.mergeRequestsEvents()).isEqualTo(true);
            softly.assertThat(value.tagPushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsPackagistServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsPackagistServicePayload();

        final GitLabProjectIntegrationsPackagistServicePayload rebuilt =
                GitLabProjectIntegrationsPackagistServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabProjectIntegrationsPackagistServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsPackagistServicePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsPackagistServicePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "username",
                        "token",
                        "server",
                        "pushEvents",
                        "mergeRequestsEvents",
                        "tagPushEvents",
                        "useInheritedSettings");
    }
}
