package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsUpdateMattermostSlashCommandPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabProjectIntegrationsUpdateMattermostSlashCommandPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateMattermostSlashCommandPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateMattermostSlashCommandPayload())
                        .token(null);

        final GitLabProjectIntegrationsUpdateMattermostSlashCommandPayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsUpdateMattermostSlashCommandPayloadBuilder builder =
                GitLabProjectIntegrationsUpdateMattermostSlashCommandPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsUpdateMattermostSlashCommandPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsUpdateMattermostSlashCommandPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsUpdateMattermostSlashCommandPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsUpdateMattermostSlashCommandPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsUpdateMattermostSlashCommandPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsUpdateMattermostSlashCommandPayload();

        final GitLabProjectIntegrationsUpdateMattermostSlashCommandPayload rebuilt =
                GitLabProjectIntegrationsUpdateMattermostSlashCommandPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabProjectIntegrationsUpdateMattermostSlashCommandPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsUpdateMattermostSlashCommandPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsUpdateMattermostSlashCommandPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("token", "useInheritedSettings");
    }
}
