package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsLinearPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenWorkspaceUrlIsNullable() {
        final GitLabGroupGroupIntegrationsLinearPayloadBuilder builder =
                GitLabGroupGroupIntegrationsLinearPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsLinearPayload())
                        .workspaceUrl(null);

        final GitLabGroupGroupIntegrationsLinearPayload built = builder.build();

        assertThat(built.workspaceUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsLinearPayloadBuilder builder =
                GitLabGroupGroupIntegrationsLinearPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsLinearPayload())
                        .pushEvents(null);

        final GitLabGroupGroupIntegrationsLinearPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsLinearPayloadBuilder builder =
                GitLabGroupGroupIntegrationsLinearPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsLinearPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsLinearPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsLinearPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsLinearPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.workspaceUrl()).isEqualTo("workspace_url");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupIntegrationsLinearPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsLinearPayload();

        final GitLabGroupGroupIntegrationsLinearPayload rebuilt =
                GitLabGroupGroupIntegrationsLinearPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIntegrationsLinearPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("workspaceUrl", "pushEvents", "useInheritedSettings");
    }
}
