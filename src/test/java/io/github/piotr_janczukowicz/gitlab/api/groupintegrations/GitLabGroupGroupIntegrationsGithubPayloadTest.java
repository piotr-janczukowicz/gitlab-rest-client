package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsGithubPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabGroupGroupIntegrationsGithubPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGithubPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGithubPayload())
                        .token(null);

        final GitLabGroupGroupIntegrationsGithubPayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryUrlIsNullable() {
        final GitLabGroupGroupIntegrationsGithubPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGithubPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGithubPayload())
                        .repositoryUrl(null);

        final GitLabGroupGroupIntegrationsGithubPayload built = builder.build();

        assertThat(built.repositoryUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStaticContextIsNullable() {
        final GitLabGroupGroupIntegrationsGithubPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGithubPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGithubPayload())
                        .staticContext(null);

        final GitLabGroupGroupIntegrationsGithubPayload built = builder.build();

        assertThat(built.staticContext()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineEventsIsNullable() {
        final GitLabGroupGroupIntegrationsGithubPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGithubPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGithubPayload())
                        .pipelineEvents(null);

        final GitLabGroupGroupIntegrationsGithubPayload built = builder.build();

        assertThat(built.pipelineEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsGithubPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGithubPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGithubPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsGithubPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsGithubPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGithubPayload();

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
        final GitLabGroupGroupIntegrationsGithubPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGithubPayload();

        final GitLabGroupGroupIntegrationsGithubPayload rebuilt =
                GitLabGroupGroupIntegrationsGithubPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabGroupGroupIntegrationsGithubPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGithubPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIntegrationsGithubPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("token", "repositoryUrl", "staticContext", "pipelineEvents", "useInheritedSettings");
    }
}
