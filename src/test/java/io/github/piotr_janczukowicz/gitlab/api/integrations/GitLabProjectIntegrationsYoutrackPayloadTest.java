package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsYoutrackPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectUrlIsNullable() {
        final GitLabProjectIntegrationsYoutrackPayloadBuilder builder =
                GitLabProjectIntegrationsYoutrackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsYoutrackPayload())
                        .projectUrl(null);

        final GitLabProjectIntegrationsYoutrackPayload built = builder.build();

        assertThat(built.projectUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesUrlIsNullable() {
        final GitLabProjectIntegrationsYoutrackPayloadBuilder builder =
                GitLabProjectIntegrationsYoutrackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsYoutrackPayload())
                        .issuesUrl(null);

        final GitLabProjectIntegrationsYoutrackPayload built = builder.build();

        assertThat(built.issuesUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsYoutrackPayloadBuilder builder =
                GitLabProjectIntegrationsYoutrackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsYoutrackPayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsYoutrackPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsYoutrackPayloadBuilder builder =
                GitLabProjectIntegrationsYoutrackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsYoutrackPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsYoutrackPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsYoutrackPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsYoutrackPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.projectUrl()).isEqualTo("project_url");
            softly.assertThat(value.issuesUrl()).isEqualTo("issues_url");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsYoutrackPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsYoutrackPayload();

        final GitLabProjectIntegrationsYoutrackPayload rebuilt =
                GitLabProjectIntegrationsYoutrackPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsYoutrackPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("projectUrl", "issuesUrl", "pushEvents", "useInheritedSettings");
    }
}
