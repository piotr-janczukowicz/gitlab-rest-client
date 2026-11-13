package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsEwmServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectUrlIsNullable() {
        final GitLabProjectIntegrationsEwmServicePayloadBuilder builder =
                GitLabProjectIntegrationsEwmServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsEwmServicePayload())
                        .projectUrl(null);

        final GitLabProjectIntegrationsEwmServicePayload built = builder.build();

        assertThat(built.projectUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesUrlIsNullable() {
        final GitLabProjectIntegrationsEwmServicePayloadBuilder builder =
                GitLabProjectIntegrationsEwmServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsEwmServicePayload())
                        .issuesUrl(null);

        final GitLabProjectIntegrationsEwmServicePayload built = builder.build();

        assertThat(built.issuesUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewIssueUrlIsNullable() {
        final GitLabProjectIntegrationsEwmServicePayloadBuilder builder =
                GitLabProjectIntegrationsEwmServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsEwmServicePayload())
                        .newIssueUrl(null);

        final GitLabProjectIntegrationsEwmServicePayload built = builder.build();

        assertThat(built.newIssueUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsEwmServicePayloadBuilder builder =
                GitLabProjectIntegrationsEwmServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsEwmServicePayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsEwmServicePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsEwmServicePayloadBuilder builder =
                GitLabProjectIntegrationsEwmServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsEwmServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsEwmServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsEwmServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsEwmServicePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.projectUrl()).isEqualTo("project_url");
            softly.assertThat(value.issuesUrl()).isEqualTo("issues_url");
            softly.assertThat(value.newIssueUrl()).isEqualTo("new_issue_url");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsEwmServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsEwmServicePayload();

        final GitLabProjectIntegrationsEwmServicePayload rebuilt =
                GitLabProjectIntegrationsEwmServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsEwmServicePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("projectUrl", "issuesUrl", "newIssueUrl", "pushEvents", "useInheritedSettings");
    }
}
