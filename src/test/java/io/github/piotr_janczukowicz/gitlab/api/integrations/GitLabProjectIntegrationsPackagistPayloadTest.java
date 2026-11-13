package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsPackagistPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabProjectIntegrationsPackagistPayloadBuilder builder =
                GitLabProjectIntegrationsPackagistPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPackagistPayload())
                        .username(null);

        final GitLabProjectIntegrationsPackagistPayload built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabProjectIntegrationsPackagistPayloadBuilder builder =
                GitLabProjectIntegrationsPackagistPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPackagistPayload())
                        .token(null);

        final GitLabProjectIntegrationsPackagistPayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenServerIsNullable() {
        final GitLabProjectIntegrationsPackagistPayloadBuilder builder =
                GitLabProjectIntegrationsPackagistPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPackagistPayload())
                        .server(null);

        final GitLabProjectIntegrationsPackagistPayload built = builder.build();

        assertThat(built.server()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsPackagistPayloadBuilder builder =
                GitLabProjectIntegrationsPackagistPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPackagistPayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsPackagistPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsEventsIsNullable() {
        final GitLabProjectIntegrationsPackagistPayloadBuilder builder =
                GitLabProjectIntegrationsPackagistPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPackagistPayload())
                        .mergeRequestsEvents(null);

        final GitLabProjectIntegrationsPackagistPayload built = builder.build();

        assertThat(built.mergeRequestsEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPushEventsIsNullable() {
        final GitLabProjectIntegrationsPackagistPayloadBuilder builder =
                GitLabProjectIntegrationsPackagistPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPackagistPayload())
                        .tagPushEvents(null);

        final GitLabProjectIntegrationsPackagistPayload built = builder.build();

        assertThat(built.tagPushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsPackagistPayloadBuilder builder =
                GitLabProjectIntegrationsPackagistPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsPackagistPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsPackagistPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsPackagistPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsPackagistPayload();

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
        final GitLabProjectIntegrationsPackagistPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsPackagistPayload();

        final GitLabProjectIntegrationsPackagistPayload rebuilt =
                GitLabProjectIntegrationsPackagistPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabProjectIntegrationsPackagistPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsPackagistPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsPackagistPayload.class.getRecordComponents())
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
