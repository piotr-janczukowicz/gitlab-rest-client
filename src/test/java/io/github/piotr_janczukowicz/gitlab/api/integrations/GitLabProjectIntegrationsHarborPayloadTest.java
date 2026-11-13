package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsHarborPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabProjectIntegrationsHarborPayloadBuilder builder =
                GitLabProjectIntegrationsHarborPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHarborPayload())
                        .url(null);

        final GitLabProjectIntegrationsHarborPayload built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectNameIsNullable() {
        final GitLabProjectIntegrationsHarborPayloadBuilder builder =
                GitLabProjectIntegrationsHarborPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHarborPayload())
                        .projectName(null);

        final GitLabProjectIntegrationsHarborPayload built = builder.build();

        assertThat(built.projectName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabProjectIntegrationsHarborPayloadBuilder builder =
                GitLabProjectIntegrationsHarborPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHarborPayload())
                        .username(null);

        final GitLabProjectIntegrationsHarborPayload built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPasswordIsNullable() {
        final GitLabProjectIntegrationsHarborPayloadBuilder builder =
                GitLabProjectIntegrationsHarborPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHarborPayload())
                        .password(null);

        final GitLabProjectIntegrationsHarborPayload built = builder.build();

        assertThat(built.password()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsHarborPayloadBuilder builder =
                GitLabProjectIntegrationsHarborPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsHarborPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsHarborPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsHarborPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsHarborPayload();

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
        final GitLabProjectIntegrationsHarborPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsHarborPayload();

        final GitLabProjectIntegrationsHarborPayload rebuilt =
                GitLabProjectIntegrationsHarborPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenPasswordIsACredential() {
        final GitLabProjectIntegrationsHarborPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsHarborPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsHarborPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("url", "projectName", "username", "password", "useInheritedSettings");
    }
}
