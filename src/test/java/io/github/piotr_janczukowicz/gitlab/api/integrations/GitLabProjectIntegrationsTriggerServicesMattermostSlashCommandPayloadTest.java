package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsTriggerServicesMattermostSlashCommandPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabProjectIntegrationsTriggerServicesMattermostSlashCommandPayloadBuilder builder =
                GitLabProjectIntegrationsTriggerServicesMattermostSlashCommandPayloadBuilder.builder(
                                IntegrationsCatalogFixtures
                                        .projectIntegrationsTriggerServicesMattermostSlashCommandPayload())
                        .token(null);

        final GitLabProjectIntegrationsTriggerServicesMattermostSlashCommandPayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsTriggerServicesMattermostSlashCommandPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsTriggerServicesMattermostSlashCommandPayload();

        assertThat(value.token()).isEqualTo("token");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsTriggerServicesMattermostSlashCommandPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsTriggerServicesMattermostSlashCommandPayload();

        final GitLabProjectIntegrationsTriggerServicesMattermostSlashCommandPayload rebuilt =
                GitLabProjectIntegrationsTriggerServicesMattermostSlashCommandPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabProjectIntegrationsTriggerServicesMattermostSlashCommandPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsTriggerServicesMattermostSlashCommandPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsTriggerServicesMattermostSlashCommandPayload.class
                                .getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("token");
    }
}
