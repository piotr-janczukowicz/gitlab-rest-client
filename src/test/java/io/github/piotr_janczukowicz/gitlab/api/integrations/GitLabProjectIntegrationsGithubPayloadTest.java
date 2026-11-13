package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsGithubPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabProjectIntegrationsGithubPayloadBuilder builder =
                GitLabProjectIntegrationsGithubPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGithubPayload())
                        .token(null);

        final GitLabProjectIntegrationsGithubPayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryUrlIsNullable() {
        final GitLabProjectIntegrationsGithubPayloadBuilder builder =
                GitLabProjectIntegrationsGithubPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGithubPayload())
                        .repositoryUrl(null);

        final GitLabProjectIntegrationsGithubPayload built = builder.build();

        assertThat(built.repositoryUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStaticContextIsNullable() {
        final GitLabProjectIntegrationsGithubPayloadBuilder builder =
                GitLabProjectIntegrationsGithubPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGithubPayload())
                        .staticContext(null);

        final GitLabProjectIntegrationsGithubPayload built = builder.build();

        assertThat(built.staticContext()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabProjectIntegrationsGithubPayloadBuilder builder =
                GitLabProjectIntegrationsGithubPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGithubPayload())
                        .pipelineEvents(null);

        final GitLabProjectIntegrationsGithubPayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsGithubPayloadBuilder builder =
                GitLabProjectIntegrationsGithubPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGithubPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsGithubPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsGithubPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsGithubPayload();

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
        final GitLabProjectIntegrationsGithubPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsGithubPayload();

        final GitLabProjectIntegrationsGithubPayload rebuilt =
                GitLabProjectIntegrationsGithubPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabProjectIntegrationsGithubPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsGithubPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsGithubPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("token", "repositoryUrl", "staticContext", "pipelineEvents", "useInheritedSettings");
    }
}
