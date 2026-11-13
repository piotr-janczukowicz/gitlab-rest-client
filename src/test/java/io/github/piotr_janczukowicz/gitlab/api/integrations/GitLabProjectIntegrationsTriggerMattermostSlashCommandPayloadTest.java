package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsTriggerMattermostSlashCommandPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabProjectIntegrationsTriggerMattermostSlashCommandPayloadBuilder builder =
                GitLabProjectIntegrationsTriggerMattermostSlashCommandPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTriggerMattermostSlashCommandPayload())
                        .token(null);

        final GitLabProjectIntegrationsTriggerMattermostSlashCommandPayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsTriggerMattermostSlashCommandPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsTriggerMattermostSlashCommandPayload();

        assertThat(value.token()).isEqualTo("token");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsTriggerMattermostSlashCommandPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsTriggerMattermostSlashCommandPayload();

        final GitLabProjectIntegrationsTriggerMattermostSlashCommandPayload rebuilt =
                GitLabProjectIntegrationsTriggerMattermostSlashCommandPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabProjectIntegrationsTriggerMattermostSlashCommandPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsTriggerMattermostSlashCommandPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsTriggerMattermostSlashCommandPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("token");
    }
}
