package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsJiraCloudAppPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenJiraCloudAppServiceIdsIsNullable() {
        final GitLabProjectIntegrationsJiraCloudAppPayloadBuilder builder =
                GitLabProjectIntegrationsJiraCloudAppPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsJiraCloudAppPayload())
                        .jiraCloudAppServiceIds(null);

        final GitLabProjectIntegrationsJiraCloudAppPayload built = builder.build();

        assertThat(built.jiraCloudAppServiceIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraCloudAppEnableDeploymentGatingIsNullable() {
        final GitLabProjectIntegrationsJiraCloudAppPayloadBuilder builder =
                GitLabProjectIntegrationsJiraCloudAppPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsJiraCloudAppPayload())
                        .jiraCloudAppEnableDeploymentGating(null);

        final GitLabProjectIntegrationsJiraCloudAppPayload built = builder.build();

        assertThat(built.jiraCloudAppEnableDeploymentGating()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraCloudAppDeploymentGatingEnvironmentsIsNullable() {
        final GitLabProjectIntegrationsJiraCloudAppPayloadBuilder builder =
                GitLabProjectIntegrationsJiraCloudAppPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsJiraCloudAppPayload())
                        .jiraCloudAppDeploymentGatingEnvironments(null);

        final GitLabProjectIntegrationsJiraCloudAppPayload built = builder.build();

        assertThat(built.jiraCloudAppDeploymentGatingEnvironments()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsJiraCloudAppPayloadBuilder builder =
                GitLabProjectIntegrationsJiraCloudAppPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsJiraCloudAppPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsJiraCloudAppPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsJiraCloudAppPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsJiraCloudAppPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.jiraCloudAppServiceIds()).isEqualTo("jira_cloud_app_service_ids");
            softly.assertThat(value.jiraCloudAppEnableDeploymentGating()).isEqualTo(true);
            softly.assertThat(value.jiraCloudAppDeploymentGatingEnvironments())
                    .isEqualTo("jira_cloud_app_deployment_gating_environments");
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsJiraCloudAppPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsJiraCloudAppPayload();

        final GitLabProjectIntegrationsJiraCloudAppPayload rebuilt =
                GitLabProjectIntegrationsJiraCloudAppPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsJiraCloudAppPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "jiraCloudAppServiceIds",
                        "jiraCloudAppEnableDeploymentGating",
                        "jiraCloudAppDeploymentGatingEnvironments",
                        "useInheritedSettings");
    }
}
