package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsGithubServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabProjectIntegrationsGithubServicePayloadBuilder builder =
                GitLabProjectIntegrationsGithubServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGithubServicePayload())
                        .token(null);

        final GitLabProjectIntegrationsGithubServicePayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryUrlIsNullable() {
        final GitLabProjectIntegrationsGithubServicePayloadBuilder builder =
                GitLabProjectIntegrationsGithubServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGithubServicePayload())
                        .repositoryUrl(null);

        final GitLabProjectIntegrationsGithubServicePayload built = builder.build();

        assertThat(built.repositoryUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStaticContextIsNullable() {
        final GitLabProjectIntegrationsGithubServicePayloadBuilder builder =
                GitLabProjectIntegrationsGithubServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGithubServicePayload())
                        .staticContext(null);

        final GitLabProjectIntegrationsGithubServicePayload built = builder.build();

        assertThat(built.staticContext()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabProjectIntegrationsGithubServicePayloadBuilder builder =
                GitLabProjectIntegrationsGithubServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGithubServicePayload())
                        .pipelineEvents(null);

        final GitLabProjectIntegrationsGithubServicePayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsGithubServicePayloadBuilder builder =
                GitLabProjectIntegrationsGithubServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGithubServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsGithubServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsGithubServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsGithubServicePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.repositoryUrl()).isEqualTo("repository_url");
            softly.assertThat(value.staticContext()).isEqualTo(true);
            softly.assertThat(value.pipelineEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsGithubServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsGithubServicePayload();

        final GitLabProjectIntegrationsGithubServicePayload rebuilt =
                GitLabProjectIntegrationsGithubServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabProjectIntegrationsGithubServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsGithubServicePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsGithubServicePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("token", "repositoryUrl", "staticContext", "pipelineEvents", "useInheritedSettings");
    }
}
