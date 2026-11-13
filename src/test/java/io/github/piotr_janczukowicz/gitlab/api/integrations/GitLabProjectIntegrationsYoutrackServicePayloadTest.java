package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsYoutrackServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectUrlIsNullable() {
        final GitLabProjectIntegrationsYoutrackServicePayloadBuilder builder =
                GitLabProjectIntegrationsYoutrackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsYoutrackServicePayload())
                        .projectUrl(null);

        final GitLabProjectIntegrationsYoutrackServicePayload built = builder.build();

        assertThat(built.projectUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesUrlIsNullable() {
        final GitLabProjectIntegrationsYoutrackServicePayloadBuilder builder =
                GitLabProjectIntegrationsYoutrackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsYoutrackServicePayload())
                        .issuesUrl(null);

        final GitLabProjectIntegrationsYoutrackServicePayload built = builder.build();

        assertThat(built.issuesUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsYoutrackServicePayloadBuilder builder =
                GitLabProjectIntegrationsYoutrackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsYoutrackServicePayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsYoutrackServicePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsYoutrackServicePayloadBuilder builder =
                GitLabProjectIntegrationsYoutrackServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsYoutrackServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsYoutrackServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsYoutrackServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsYoutrackServicePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.projectUrl()).isEqualTo("project_url");
            softly.assertThat(value.issuesUrl()).isEqualTo("issues_url");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsYoutrackServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsYoutrackServicePayload();

        final GitLabProjectIntegrationsYoutrackServicePayload rebuilt =
                GitLabProjectIntegrationsYoutrackServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsYoutrackServicePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("projectUrl", "issuesUrl", "pushEvents", "useInheritedSettings");
    }
}
