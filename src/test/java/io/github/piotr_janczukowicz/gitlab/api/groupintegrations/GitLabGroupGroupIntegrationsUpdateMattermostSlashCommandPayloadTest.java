package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsUpdateMattermostSlashCommandPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateMattermostSlashCommandPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateMattermostSlashCommandPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures
                                        .groupGroupIntegrationsUpdateMattermostSlashCommandPayload())
                        .token(null);

        final GitLabGroupGroupIntegrationsUpdateMattermostSlashCommandPayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsUpdateMattermostSlashCommandPayloadBuilder builder =
                GitLabGroupGroupIntegrationsUpdateMattermostSlashCommandPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures
                                        .groupGroupIntegrationsUpdateMattermostSlashCommandPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsUpdateMattermostSlashCommandPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsUpdateMattermostSlashCommandPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateMattermostSlashCommandPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupIntegrationsUpdateMattermostSlashCommandPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateMattermostSlashCommandPayload();

        final GitLabGroupGroupIntegrationsUpdateMattermostSlashCommandPayload rebuilt =
                GitLabGroupGroupIntegrationsUpdateMattermostSlashCommandPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabGroupGroupIntegrationsUpdateMattermostSlashCommandPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsUpdateMattermostSlashCommandPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupGroupIntegrationsUpdateMattermostSlashCommandPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("token", "useInheritedSettings");
    }
}
