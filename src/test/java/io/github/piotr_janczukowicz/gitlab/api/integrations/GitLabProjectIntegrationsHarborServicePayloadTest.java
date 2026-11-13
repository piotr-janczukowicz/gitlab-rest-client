package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsHarborServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabProjectIntegrationsHarborServicePayloadBuilder builder =
                GitLabProjectIntegrationsHarborServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHarborServicePayload())
                        .url(null);

        final GitLabProjectIntegrationsHarborServicePayload built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectNameIsNullable() {
        final GitLabProjectIntegrationsHarborServicePayloadBuilder builder =
                GitLabProjectIntegrationsHarborServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHarborServicePayload())
                        .projectName(null);

        final GitLabProjectIntegrationsHarborServicePayload built = builder.build();

        assertThat(built.projectName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabProjectIntegrationsHarborServicePayloadBuilder builder =
                GitLabProjectIntegrationsHarborServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHarborServicePayload())
                        .username(null);

        final GitLabProjectIntegrationsHarborServicePayload built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPasswordIsNullable() {
        final GitLabProjectIntegrationsHarborServicePayloadBuilder builder =
                GitLabProjectIntegrationsHarborServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHarborServicePayload())
                        .password(null);

        final GitLabProjectIntegrationsHarborServicePayload built = builder.build();

        assertThat(built.password()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsHarborServicePayloadBuilder builder =
                GitLabProjectIntegrationsHarborServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHarborServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsHarborServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsHarborServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsHarborServicePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.url()).isEqualTo("url");
            softly.assertThat(value.projectName()).isEqualTo("project_name");
            softly.assertThat(value.username()).isEqualTo("username");
            softly.assertThat(value.password()).isEqualTo("password");
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsHarborServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsHarborServicePayload();

        final GitLabProjectIntegrationsHarborServicePayload rebuilt =
                GitLabProjectIntegrationsHarborServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenPasswordIsACredential() {
        final GitLabProjectIntegrationsHarborServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsHarborServicePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsHarborServicePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("url", "projectName", "username", "password", "useInheritedSettings");
    }
}
