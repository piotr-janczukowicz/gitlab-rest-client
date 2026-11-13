package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsRedmineServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectUrlIsNullable() {
        final GitLabProjectIntegrationsRedmineServicePayloadBuilder builder =
                GitLabProjectIntegrationsRedmineServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsRedmineServicePayload())
                        .projectUrl(null);

        final GitLabProjectIntegrationsRedmineServicePayload built = builder.build();

        assertThat(built.projectUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesUrlIsNullable() {
        final GitLabProjectIntegrationsRedmineServicePayloadBuilder builder =
                GitLabProjectIntegrationsRedmineServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsRedmineServicePayload())
                        .issuesUrl(null);

        final GitLabProjectIntegrationsRedmineServicePayload built = builder.build();

        assertThat(built.issuesUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewIssueUrlIsNullable() {
        final GitLabProjectIntegrationsRedmineServicePayloadBuilder builder =
                GitLabProjectIntegrationsRedmineServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsRedmineServicePayload())
                        .newIssueUrl(null);

        final GitLabProjectIntegrationsRedmineServicePayload built = builder.build();

        assertThat(built.newIssueUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsRedmineServicePayloadBuilder builder =
                GitLabProjectIntegrationsRedmineServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsRedmineServicePayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsRedmineServicePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsRedmineServicePayloadBuilder builder =
                GitLabProjectIntegrationsRedmineServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsRedmineServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsRedmineServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsRedmineServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsRedmineServicePayload();

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
        final GitLabProjectIntegrationsRedmineServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsRedmineServicePayload();

        final GitLabProjectIntegrationsRedmineServicePayload rebuilt =
                GitLabProjectIntegrationsRedmineServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsRedmineServicePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("projectUrl", "issuesUrl", "newIssueUrl", "pushEvents", "useInheritedSettings");
    }
}
