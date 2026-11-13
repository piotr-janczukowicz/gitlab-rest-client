package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsLinearServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenWorkspaceUrlIsNullable() {
        final GitLabProjectIntegrationsLinearServicePayloadBuilder builder =
                GitLabProjectIntegrationsLinearServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsLinearServicePayload())
                        .workspaceUrl(null);

        final GitLabProjectIntegrationsLinearServicePayload built = builder.build();

        assertThat(built.workspaceUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsLinearServicePayloadBuilder builder =
                GitLabProjectIntegrationsLinearServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsLinearServicePayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsLinearServicePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsLinearServicePayloadBuilder builder =
                GitLabProjectIntegrationsLinearServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsLinearServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsLinearServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsLinearServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsLinearServicePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.workspaceUrl()).isEqualTo("workspace_url");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsLinearServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsLinearServicePayload();

        final GitLabProjectIntegrationsLinearServicePayload rebuilt =
                GitLabProjectIntegrationsLinearServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsLinearServicePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("workspaceUrl", "pushEvents", "useInheritedSettings");
    }
}
