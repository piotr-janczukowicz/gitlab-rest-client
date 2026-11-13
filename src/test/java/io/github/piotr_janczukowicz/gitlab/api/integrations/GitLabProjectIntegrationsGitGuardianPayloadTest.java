package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsGitGuardianPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenApiUrlIsNullable() {
        final GitLabProjectIntegrationsGitGuardianPayloadBuilder builder =
                GitLabProjectIntegrationsGitGuardianPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitGuardianPayload())
                        .apiUrl(null);

        final GitLabProjectIntegrationsGitGuardianPayload built = builder.build();

        assertThat(built.apiUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabProjectIntegrationsGitGuardianPayloadBuilder builder =
                GitLabProjectIntegrationsGitGuardianPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitGuardianPayload())
                        .token(null);

        final GitLabProjectIntegrationsGitGuardianPayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsGitGuardianPayloadBuilder builder =
                GitLabProjectIntegrationsGitGuardianPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitGuardianPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsGitGuardianPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsGitGuardianPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsGitGuardianPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.apiUrl()).isEqualTo("api_url");
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsGitGuardianPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsGitGuardianPayload();

        final GitLabProjectIntegrationsGitGuardianPayload rebuilt =
                GitLabProjectIntegrationsGitGuardianPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabProjectIntegrationsGitGuardianPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsGitGuardianPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsGitGuardianPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("apiUrl", "token", "useInheritedSettings");
    }
}
