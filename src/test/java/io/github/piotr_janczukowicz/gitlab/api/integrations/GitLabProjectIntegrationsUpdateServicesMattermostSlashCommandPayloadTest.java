package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsUpdateServicesMattermostSlashCommandPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesMattermostSlashCommandPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesMattermostSlashCommandPayloadBuilder.builder(
                                IntegrationsCatalogFixtures
                                        .projectIntegrationsUpdateServicesMattermostSlashCommandPayload())
                        .token(null);

        final GitLabProjectIntegrationsUpdateServicesMattermostSlashCommandPayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsUpdateServicesMattermostSlashCommandPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateServicesMattermostSlashCommandPayloadBuilder.builder(
                                IntegrationsCatalogFixtures
                                        .projectIntegrationsUpdateServicesMattermostSlashCommandPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsUpdateServicesMattermostSlashCommandPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsUpdateServicesMattermostSlashCommandPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesMattermostSlashCommandPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsUpdateServicesMattermostSlashCommandPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesMattermostSlashCommandPayload();

        final GitLabProjectIntegrationsUpdateServicesMattermostSlashCommandPayload rebuilt =
                GitLabProjectIntegrationsUpdateServicesMattermostSlashCommandPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabProjectIntegrationsUpdateServicesMattermostSlashCommandPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsUpdateServicesMattermostSlashCommandPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsUpdateServicesMattermostSlashCommandPayload.class
                                .getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("token", "useInheritedSettings");
    }
}
