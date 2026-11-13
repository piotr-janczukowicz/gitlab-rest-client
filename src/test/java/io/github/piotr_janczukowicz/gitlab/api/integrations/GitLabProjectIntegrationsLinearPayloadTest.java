package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsLinearPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenWorkspaceUrlIsNullable() {
        final GitLabProjectIntegrationsLinearPayloadBuilder builder =
                GitLabProjectIntegrationsLinearPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsLinearPayload())
                        .workspaceUrl(null);

        final GitLabProjectIntegrationsLinearPayload built = builder.build();

        assertThat(built.workspaceUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsLinearPayloadBuilder builder =
                GitLabProjectIntegrationsLinearPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsLinearPayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsLinearPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsLinearPayloadBuilder builder =
                GitLabProjectIntegrationsLinearPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsLinearPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsLinearPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsLinearPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsLinearPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.workspaceUrl()).isEqualTo("workspace_url");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsLinearPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsLinearPayload();

        final GitLabProjectIntegrationsLinearPayload rebuilt =
                GitLabProjectIntegrationsLinearPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsLinearPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("workspaceUrl", "pushEvents", "useInheritedSettings");
    }
}
