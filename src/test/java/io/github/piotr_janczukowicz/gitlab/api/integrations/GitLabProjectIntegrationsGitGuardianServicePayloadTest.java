package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsGitGuardianServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenApiUrlIsNullable() {
        final GitLabProjectIntegrationsGitGuardianServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitGuardianServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitGuardianServicePayload())
                        .apiUrl(null);

        final GitLabProjectIntegrationsGitGuardianServicePayload built = builder.build();

        assertThat(built.apiUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabProjectIntegrationsGitGuardianServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitGuardianServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitGuardianServicePayload())
                        .token(null);

        final GitLabProjectIntegrationsGitGuardianServicePayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsGitGuardianServicePayloadBuilder builder =
                GitLabProjectIntegrationsGitGuardianServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsGitGuardianServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsGitGuardianServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsGitGuardianServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsGitGuardianServicePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.apiUrl()).isEqualTo("api_url");
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsGitGuardianServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsGitGuardianServicePayload();

        final GitLabProjectIntegrationsGitGuardianServicePayload rebuilt =
                GitLabProjectIntegrationsGitGuardianServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabProjectIntegrationsGitGuardianServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsGitGuardianServicePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsGitGuardianServicePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("apiUrl", "token", "useInheritedSettings");
    }
}
